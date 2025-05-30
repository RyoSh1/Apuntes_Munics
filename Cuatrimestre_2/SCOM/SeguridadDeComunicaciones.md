# SCOM Indice
1. [TLS](#tema-1--transport-layer-security-layer-protocol)
2. [Características principales](#caracteristicas-principales)
3. [Ejemplo de uso](#ejemplo-de-uso)
4. [Conclusión](#conclusion)

# Tema 1 : Transport Layer Security Layer Protocol

### Contexto

TLS es un protocolo que surge como evolución a SSL (Secure Socket Layer) para proveer comunicación segura sobre infraestructuras de red inseguras. Se utiliza para proteger la comunicaciones entre aplicaciones en internet, garantizando autenticación, confidencialidad e integridad.

Objetivos: Interoperabilidad (independencia del sistema operativo), Extensibilidad (Independencia de primitivas criptográficas) y Eficiencia (minimizar el coste de rendimiento sobre la comunicación)

El Transport Layer Security (TLS) es un protocolo de seguridad que evolucionó a partir de Secure Sockets Layer (SSL) con el objetivo de proporcionar una comunicación segura en una infraestructura de red insegura. Se usa ampliamente para proteger la comunicación entre aplicaciones en Internet, como la navegación web segura (HTTPS), correos electrónicos cifrados y otros servicios en línea.

#### Línea temporal

- Durante 1994: SSL 1 nunca vio la luz del dia.
- Noviembre 1994: SSL 2 desplegado en Netscape Navigator 1.1, se introducen los certificados de servidor.
- Noviembre 1996: SSL 3 rediseño completo, soporte para PKI mediante certificados X.509.
- Enero 1999: TLS 1.0, estandarización de SSL 3 y cambios de nombre para complacer a Microsoft.
- Abril 2006: TLS 1.1 correcciones de seguridad y extensiones TLS.
- Agosto 2008: TLS 1.2 versión más común, gran flexibilidad.
- Agosto 2018: TLS 1.3 mejoras en el rendimiento y simplificación.

#### Explicación básica

TLS es un protocolo de capa de transporte que se monta sobre TCP proporcionando una capa de seguridad, se divide en: 

- Handshake: Parámetros de seguridad y realiza la autenticación.
- Change Cipher: Indica cuando se activa el cifrado.
- Alert: Maneja errores y eventos de advertencia.
- Application data ¿?
- Record: Encapsulación y cifrado de datos transmitidos.

#### Competidores

- SSH (Secure Shell):
    - También opera en capa de aplicación (Se contradice con internet, ns).
    - Realiza criptografía de clave pública o mediante contraseñas.
    - Se basa en un sistema de confianza entre hosts e intercambio de claves (en vez de PKI).
    - Se utiliza normalmente en acceso remoto a servidores, transferencia de archivos y tunelización de protocolos.
- PGP (Pretty Good Privacy):
    - Funciona sobre mensajes individuales.
    - Utiliza un modelo de Web of Trust.
    - Se utiliza en correos electrónicos cifrados, verificación de archivos y paquetes de software.

## Protocolo TLS (Versiones 1.2 y 1.3)

### Record Protocol

El protocolo de Registro (supongo) se encarga de transportar y opcionalmente cifrar los datos de cada mensaje TLS entre dos aplicaciones. Cada mensaje TLS se encapsula en un registro (entiendo que lo de antes) que contiene:
- Tipo de mensaje (C).
- Versión de TLS.
- Longitud del mensaje.
- Datos (según la etapa cifrados o no)

También utiliza un contador de 64 bits (que no se envía por la red) para evitar ataques de repetición y garantizar integridad.

Características:
- Transporte de mensajes: Transporta buffers de protocolos superiores de forma opaca.
- Cifrado y validación de la integridad: Los primeros mensajes de transmiten en claro, tras el handshake los datos se cifran con los parámetros negociados.
- Compresión: Antes de TLS 1.3, se quitó debido a que se podían realizar ataques de side channel (CRIME creo).
- Extensibilidad: El record solo se encarga de transporte y cifrado, el resto de tareas se llevan a cabo por otros sub protocolos (handshake, change cipher spec, application data y alert).

### El protocolo de Handshake

Proceso responsable de negociar los parámetros de conexión y realizar la autenticación. Se realizan entre 6 y 10 mensajes y existen tres tipos:
- Handshake completo con autenticación del servidor.
- Handshake abreviado reanudando una sesión anterior.
- Handshake completo con autenticación mutua.

**Estructura del mensaje**
```
struct {
 HandshakeType msg_type; 
 /* Just 1 byte */
 uint24 length;
 HandshakeMessagemessage; 
 /* Actual content depends on msg_type */
 } Handshake;
```

### Tipo 1: Full Handshake con autenticación del servidor

Compuesto por 4 actividades principales: Intercambio de capacidades y negociación de parámetros, Autenticación (validación de certificados), Acordar un secreto maestro y verificar la integridad de los mensajes de enlace.

1. Cliente envía "Client Hello": 
2. Servidor responde con "Server Hello":
3. Servidor envía su certificado digital:
4. Servidor envía una clave pública:
5. Servidor indica el final de la negociación.
6. Cliente envía información adicional para generar el master secret.
7. Cliente cambia a cifrado con la clave negociada.
8. El cliente envía un MAC final con un hash de todos los mensajes.
9. Servidor cambia a cifrado con la clave negociada.
10. Servidor envía un MAC final con un hash de todos los mensajes.

En el Client Hello aparecen campos importantes:
- Random: Previene los ataques de repetición y asegura integridad.
- Session ID: Vacío en la primera conexión.
- Cipher Suites: Ordenadas por preferencia.

#### Intercambio de certificado y claves

El mensaje lleva el certificado x.509 del servidor, primero el principal y luego los intermedios. NO se debe enviar el certificado raíz.

El certificado depende del cipher suite, los algoritmos de firmas deben coincidir. Un servidor puede terner múltiples certificados.

Intercambio de claves: Depende del cipher suite, *ClientKeyExchange* es obligatorio y *ServerKeyExchange* es opcional.

#### Cambio a cifrado

Es un único mensaje (ChangeCipherSpec) que se envía durante el handshake para indicar que el cliente o servidor tienen suficiente información para generar claves de cifrado. A partir del mismo los mensajes serán cifrados.

#### Fin de handshake

Es el primer mensaje cifrado y permite verificar la integridad del handshake. Solo tiene un campo (verify_data) que es un hash de todos los mensajes del handshake mezclados con el master secret (PRF de SINF).

### Tipo 3: Handshake completo con autenticación mutua

A diferencia del anterior se necesita que el servidor se autentique y se introducen nuevos mensajes:

- El servidor solicita al cliente el certificado (paso 5).
- El cliente envía el certificado (paso 7).
- El cliente envía una firma de los mensajes anteriores en el handshake para verificar que posee la clave privada del certificado.

### Handshake en TLS 1.3

Introduce mejoras en el proceso de handshake, eliminando redundancias y mejorando la seguridad.

Principales diferencias:
- Menos mensajes en el handshake (pasa de 4 a 3 rondas), 5 mensajes (CH + Key_share, SH + KeyShare, SCert, Fin, Fin).
- Elimina el uso de claves RSA estáticas, obligando a usar Diffie-Hellman Ephemeral (DHE) o Pre-Shared Keys (PSK) lo que mejora la seguridad.

### Tipo 2: Reanudación de sesión

TLS permite reducir el tiempo de establecimiento de una conexión si cliente y servidor ya han tenido una sesión previamente.

El cliente envía un ID de sesión en el "Client Hello", el servidor lo devuelven y se realiza un nuevo set de claves para reanudar el cifrado.

Existe una alternativa en la que en lugar de almacenar sesiones en el servidor, este envía un ticket cifrado al cliente, con este el cliente puede recuperar la sesión en una reconexión.

### Intercambio de claves

Dos técnicas:

- RSA: Se genera un premaster secret aleatorio y se cifra con la *pk* del servidor. No ofrece forward secrecy, si la *sk* del servidor se compromete, se pueden descifrar las sesiones derivadas.
- Diffie-Hellman Ephemeral (DHE) y Elliptic Curve DHE: Permiten generar una clave compartida en canales inseguros mientras haya autenticación, ofrecen forward secrecy. DHE es estático, la clave compartida es siempre la misma, por otra parte en ECDHE los parámetros del servidor cambian en cada conexión. TLS 1.3 ya no permite DHE, solo ECDHE.

#### Autenticación

Normalmente se realiza algún tipo de criptografía de clave pública para la autenticación (RSA o ECDSA):
1. El cliente obtiene y valida el certificado del servidor.
2.  - RSA: El cliente cifra el premaster secret con la clave pública del servidor, este se autentica si el mensaje "Finished" recibido por el cliente es correcto.
    - ECDSA: El servidor comunica parámetros usando su propia clave privada, los parámetros se concatenan con valores aleatorios para evitar ataques de repetición. 

### Tipos de cifrado en TLS

- Flujo (obsoleto en TLS 1.3): Se genera un flujo de claves que se mezclan con los datos usando XOR.
- Bloque: Divide los datos en bloques de tamaño fijo y se realizan operaciones de cifrado usando los bloques como entrada de los siguientes. Se usa CBC o EMAC.
- Cifrado AEAD (Authenticated Encryption with Associated Data): Integra cifrado y autenticación en una sola operación, evita la necesidad de utilizar una clave MAC separada. Usa CBC-MAC y Galois Counter Mode, es el único en TLS 1.3.

#### Cierre de conexión

Cuando una sesión termina, TLS usa el subprotocolo de alertas para cerrarla de forma segura.

Alertas TLS:
- Warning: Lleva una descripción. "Close Notify" se envía antes de cerrar la sesión para evitar ataques de truncado.
- Fatal: Si ocurre un error grave, la conexión se cierra de inmediato.

#### Operaciones criptográficas

Una función pseudoaleatoria (PRF SINF) genera cantidades arbitrarias de datos pseudoaleatorios. En TLS 1.2 se utiliza Hash-based MAC (HMAC) y en TLS 1.3 se utiliza HKDF.

#### Master Secret

Se deriva del *premaster secret* mediante una PRF, se utilizan campos aleatorios para asegurar la aleatoriedad, tiene una longitud de 48 bytes.

### Generación de claves

Para la generación de la master key se utilizan los siguientes parámetros PRF( pre_master_key, "master secret", client random, server random), esta salida se utiliza pasando por un XOR con ("key expansion", client random, server random) y como parámetro de otra PRF para generar un Key Block que contiene: encrypt key 1 y 2, mac key 1 y 2 y IV 1 y 2. 

### Cipher Suite

Conjunto de primitivas criptográficas y parámetros que definen como se protegerá la conexión segura a establecer entre cliente y servidor.

# Tema 2 : Public Key Infraestructure

El objetivo de PKI es acceder a claves públicas, información sobre la validez de esas claves y ser escalable.

PKI se utiliza en internet basandose en terceras entidades, las CA, estas crean certificados con claves públicas.

### X.509

Es un estándar internacional para PKI adaptado para el uso de internet.

Timeline:
- PKI para X.509:
- CAB Forum:
- IETF Web PKI:

### Campos del certificado

- Version: 1, 2 o 3.
- Número de serie: Número único no secuencial e impredecible con al menos 20 bits de entropía.
- Algoritmo de firma: Usado para firmar el certificado.
- Emisor: Distinguished Name del emisero.
- Validez: Inicio y fin de validez.
- Subject: El DN de la entidad propietaria de la clave pública certificada.
- Clave Pública: ID del algoritmo, parámetros opcionales y la pública en sí.

Extensiones principales:
- Nombre alternativo del Subject: Sustituye el campo de Subject, admite múltiples identidades especificadas por nombre DNS, IP o URI.
- Límites de nombre: Limita las identidades que la CA puede emitir.
- Limites básicos: Limita la profundidad de la cadena.
- Usos de clave: Set limitado.
- Usos de clave extendido: Más específico.
- Políticas del certificado: Lista de links para la policy.
- Puntos de distribución CRL: Ubicación de la lista de revocación.
- Información de acceso de autoridad: Varias URIs, entre ellas la ubicación del OSCP responder.
- Clave de identificación de subject: Hash de la pública.
- Clave de identificación de la autoridad: Hash de la clave que firmó el certificado.

### Ciclo de vida de certificados

1. Solicitud de emisión del Certificado (CSR)
    - Subscriber: El solicitante genera una solicitud de firma de certificado que contiene su información y clave pública.
    - Registration Authority: Recibe el CSR y realiza la validación inicial de la entidad del solicitante.
    - Certification Authority: La autoridad que emite el certificado.
2. Validación y Emisión
    - Validate subscriber's identity: La RA y o la CA verifican la identidad del solicitante según sus políticas.
    - Issue certificate: Una vez validado, la CA firma digitalmente el certificado con su clave privada.
3. Publicación del certificado
    - El certificado se publica en varios lugares:
        - Web Server: Donde se utiliza para autenticación SSL o TLS.
        - CRL Server: Para listas de revocación.
        - OCSP Responder: Servicio de verificación de estado en línea.
4. Proceso de verificación
    1. Request certificate: Solicia al servidor web el certificado.
    2. Verify signature: Verifica que la firma de la CA sea válida.
    3. Check revocation: Consulta CRL u OCSP para asegurarse de que no esté revocado.
    4. Relying Party: Confía si pasa todas las verificaciones.

## Internet PKI Infraestructure

### Solicitud de firma de certificado

Lleva la clave pública del solicitante y su objetivo es demostrar la veracidad de la clave privada correspondiente.

### Validación de la identidad del suscriptor

Estrategias de validación:
- Validación de dominio: Prueba de control de un dominio determinado, enviando un correo a una dirección conocida o un registro de la zona de dominio.
- Validación de organización: Requiere una identidad y autenticidad
- Validación ampliada: Requiere identidad y autenticidad con requisitos muy estrictos.

### Revocación

Se lleva a cabo cuando se sospecha que la clave ha sido comprometida.

Se puede comprobar en la lista de revocación o mediante OCSP (Online Certificate Status Protocol) que permite a las partes interesadas comprobar el estado.

### Cadena de certificados

El Root CA va embebido en el SO o navegador, los intermedios y finales se proveen por el servidor.

### Justificación

- Seguridad de la clave raíz de la CA: Es crítica, si esta se revoca todas sus dependientes deben re-emitirse. La clave debe mantenerse siempre offline.
- Certificación cruzada: Una nueva raíz es firmada por la antigua raíz mientras se despliega en SO y navegadores.
- Compartimentación: Dividir una raíz entre múltiples CA subordinadas reduce riesgos.
- Delegación: Una gran empresa puede querer crear sus certificados, para ello la CA crea una subordinada.

### Partes de confianza

Se debe confiar en una colección de certificados CA raíz:
- Microsoft y Apple: Las CAs deben pasar una auditoría anual.
- Mozilla: Usa un prorgama transparente de certificados raíz.
- Chrome: Usa Mozilla más lo del sistema operativo, sumado a listas blancas y negras.

## Issues with the current PKI Infraestructure

### Control de la emisión de certificados por los propietarios de dominios

Cualquier CA puede emitir un certificado para un dominio sin permiso o notificación del propietario, esto puede ser negligencia o malicia.

Existen cientos de CA, una sola podría comprometer la seguridad.

### Dificultad en la actualización de los almacenes de confianza

La mayoría de CAs son demasiado grandes para quebrar, la eliminación de una CA tiene consecuencias a gran escala, por lo que normalmente no es posible.

Las CA raíz o son confiadas o no, otras opciones son confiar en ellas según su fecha.

### Revocación fallida

Razones:
- Retardo en la propagación de la información en CRL y OCSP (hasta 10 días).
- Los navegadores ignoran fallos en CRL o OCSP, por lo que un atacante puede suprimir ese tráfico.
- Proveedores de navegación que no realizan revocación por no tardar más.

Como medida provisional la mayoría de navegadores disponen de mecanismos basados en listas negras de certificados revocados e intermediarios.

### Otras debilidades

- Validación débil de dominio: llevado a cabo por emails inseguros o utilizando datos whois inseguros.
- Advertencia de certificado: Muchas aplicaciones y librerías se saltan la validación del certificado y los navegadores permiten aceptarlos.

## Infraestructure Improvements

### Notaries

Repositorios públicos de certificados conocidos, puede impedir ataques basados en intermediarios maliciosos.

DNS info: DANE (DNS-Based Authentication of Named Entities) y CAA (Certification Authority Authorization).

### Fijación de claves públicas: HPKP

Permite a los dueños restringir que CAs pueden emitir certificados para sus páginas.

Mecanismos:
- Cabecera especial en HTTP: Usado por firefox, en próximas visitas el navegador rechaza certificados de otras CAs.
- Mecanismos propietarios (chrome).

HPKP está obsoleto hoy en día, tiene un alto riesgo de inutilizar un sitio.

### Transparencia de certificados

Un framework que permite verificar la emisión de certificados, bajo CT todas las CA participantes deben aplicar todos los certificados emitidos a un log público. Cualquiera puede monitorizar la emisión de certificados, las CA obtienen una prueba de que han aplicado una emisión al log.

# Tema 3 : Port-Based Network Access Control

El estándar para el control de acceso a redes basado en puertos es IEEE 802.1X y proporciona mecanismos de autenticación para equipos que se conectan a redes LAN o WLAN. 802.1X implica a 3 partes Suplicante, Autenticador y Servidor de autenticación.

Los puertos de un switch tienen que estar bloqueados por defecto hasta que el dispositivo conectado es autenticado por una entidad de seguridad en la infraestructura. Solo se permite el flujo de paquetes especiales para la autenticación, en WiFi el equivalente es la asociación inicial con el punto de acceso (puerto lógico).

### EAP (Extensible Authentication Protocol)

EAP es un framework de autenticación L2 no el mecanismo en sí, pero si proporciona funciones y métodos de autenticación estándar llamados EAP Methods. La autenticación la realiza el protocolo interno a EAP.

Inciso: L2 significa antes de asignar una IP y L3 que recibe una IP y luego se autentica.

EAP define unos formatos de mensaje de autenticación genéricos: Request, Response, Success y Failure. El campo "EAP Authentication Type" especifica el mecanismo de autenticación concreto, el tipo de credenciales y cómo utilizarlas para realizar autenticación segura.

802.1X Define el encapsulamiento de EAP sobre cable, es decir EAP over LAN o EAPOL. Si el autenticador y el servidor no están ubicados conjuntamente, los mensajes EAP deben ser encapsulados en otro protocolo

## RADIUS

Remote Access Dial-In User Service define su propio protocolo de transporte para comunicación entre el autenticador y el servidor RADIUS AAA. Originalmente creado para la autenticación centralizada de usuarios de acceso telefónico en grupos de módems distribuidos.

Define mensajes entre el Network Access Server y el servidor de autenticación: El NAS envía Access-Request y el AS responde con Access-Challenge, Access-Accept o Access-Reject.

EAP se encapsula en los paquetes AR y AC en las rondas necesarias, contiene el EAP-message attribute y el Message-Authenticator attribute que es obligatorio en RADIUS para transportar atributos EAP (ICV y MAC) .RADIUS tiene su propio protocolo de seguridad basado en una clave compartida entre endpoints.

### Seguridad de RADIUS

Las respuestas del AS contienen un campo authenticator MD5 de Code,ID,Longitud, RequestAuth,Attributes y Shared Secret, RequestAuth es un nonce generado en una Request.

Si un mensaje RADIUS transporta un mensaje EAP debe llevar el atributo Message-Authenticator que es un HMAC-MD5 de Secreto compartido, Código, ID, Longitud, RequestAuth y Atributos. También presenta su propia función para ocultar atributos usando la clave compartida.

Si un método EAP genera claves (MSK), el PMK derivado del MSK se envía en el Access-Accept desde el servidor al NAS cifrado con la clave precompartida. El suplicante recuperará MSK y PMK con el método EAP equivalente. 

### Vulnerabilidades de RADIUS

RADIUS es vulnerable a ataques de diccionario ya que no se actualiza la clave precompartida, los mensajes se envían en claro y MD5.Otras vulnerabilidades estan relacionadas con privacidad, spoofing, replay, negoaciación, etc.

RADIUS recomienda usar un mecanismo de autenticación bidireccional e IPsec para la comunicación con el NAS.

### Métodos de autenticación EAP basados en TLS

- EAP-TLS (EAP Transport Layer Security): Autenticación mútua en el handshake inicial que establece el túnel TLS, necesita certificados X509 en ambos lados.
- EAP-TTLS (EAP Tunneled Transport Layer Security): Solo el servidor lleva certificado, el cliente se autentica dentro del túnel TLS usando otros métodos.
- PEAP (Protected EAP): Similar al anterior, el cliente se autentica usando EAP dentro del túnel TLS. La diferencia es PEAP.
- EAP-FAST (EAP Flexible Authentication via Secure Tunneling): No necesita usar certificados, utiliza una Protected Access Credential para establecer el túnel TLS. 3 Fases: PAC provisioning (tunnel), TLS tunnel establishment, Authentication.


### Secure Association Protocol

El protocolo de asociación segura es aquel que una vez un cliente se autentique con éxito, se encarga de establecer una relación de confianza adicional para asegurar que los datos transmitidos están cifrados y protegidos. Algunos métodos EAP generan claves que se usan para verificar que tanto cliente como autenticador conocen una clave derivada y para establecer claves simétricas.

## MACsec

MACsec es un protocolo de seguridad en redes Ethernet cableadas en capa 2. Interesante para proveedores de red, para despliegue local y naturalmente para links punto a punto.

Garantiza: Integridad, Autenticidad, Confidencialidad, protección contra Replay, Control del retardo de recepción y algo de protección contra DOS. Logra todo esto cifrando los datos directamente en el hardware de red.

### Definiciones MACsec

- Secure Connectivity Association (CA): Relación de seguridad entre dos o más dispositivos (puntos de acceso) conectados a la misma LAN, mantenida por protocolos de acuerdo de claves.
    - Secure Connectivity Association Key (CAK): Secreto poseido por miembros de la CA.
    - Secure Connectivity Association Key Name (CKN): Texto que identifica al CAK. Ambos se derivan del material de claves del método EAP.
    - Las CA tienen 2 miembros iniciales (suplicante y autenticador) y eligen dinamicamente un servidor de claves (mínimo ID).
    - Un servidor que pertenece a varias CA puede crear un grupo CA y unirlas.
- Secure Associantion (SA): Una relación de seguridad que garantiza las tramas transmitidas entre miembros. Es unidireccional y soportada por una clave o conjunto de 1 uso.
- Secure Association Key (SAK): El secreto usado, se deriva en el servidor y se distribuye usando MKA
- Secure Channel (SC): Un SC está respaldado por una secuencia de SA, lo que permite usar periódicamente nuevas claves.

### Acuerdo de clave MACsec

MKA es el protocolo de gestión de claves que:
- Identifica dispositivos ya autenticados a una CA o una potencial CA en la misma LAN.
- Confirma la mútua posesion de una CAK y a su vez que ya se ha pasado la autenticación.
- Acuerda y distribuye las claves SAK que se usarán para cifrar tráfico MACsec.
- Se asegura de que el tráfico cifrado no se haya retrasado ni manipulado.

Usa tramas EAPOL-MKA para el intercambio de información, securiza topologías multipunto distribuido (ICK y KEK por cada CA). Cada CA tiene un servidor de claves dinámico (switch de acceso).

Si MKA no está disponible, MACsec aún puede utilizarse configurando manualmente las claves en extremos.

### Jerarquía de claves

AES Cipher-based Message Authentication Code (CMAC).

La clave CAK usada por MACsec es en realidad la PMK que el AS entrega al Authenticator en Access-Accept. El cliente (supplicant) obtiene esa misma PMK derivada del MSK como resultado del intercambio EAP.

El estandar considera la posibilidad de configurar manualmente CAK y CKN en los extremos.

## Resumen explicativo del tema

Al conectar un equipo a un switch con 802.1x activado los switches están bloqueados por defecto hasta que se realiza autenticación. Ahí entra EAP, que es un marco que establece unos mensajes genéricos y permite negociar métodos de autenticación. En un escenario con pc, switch y RADIUS, el cliente primero se conecta con el switch enviando un Eapol-Start y este le contesta con un request-identity, la respuesta es un response el cual el switch enviará en un paquete access-request al servidor RADIUS. Aquí se sucede una serie de mensajes Response-> Access-Request, con respuesta Access-Challenge->Request hasta llegar al último Access-Accept y EAP-Success. En esta serie de mensajes se envía en su interior el handshake TLS, el cual al terminar se ha establecido un túnel dentro de EAP y se ha logrado autenticar ambos extremos, por lo que sucede ese mensaje Accept desde RADIUS.
El mensaje Accept contiene la PMK que ha sido derivada de la MSK (presumiblemente del intercambio TLS), esta se renombra a CAK y se le asigna un identificador (CKN) y comienza MACsec. Se envía un mensaje EAPOL-MKA el cual verifica que ambos extremos conocen el mismo CAK, se decide un Key Server (switch) y se derivan del CAK la KEK (encriptación) y la ICK (integridad). El Key Server genera la SAK (Secure Association Key) y la distribuye cifrada con la KEK que ya tiene los extremos. 
Una vez instalada la SAK, se activa MACsec.

# Tema 4 : Wireless LAN Security

El objetivo de las redes WLAN es otorgar conexión a internet de forma rápida y flexible sin necesidad de conexión directa, es una tecnología extendida en el ambito público y en residencias privadas.

Ventajas:
- Ubicación y simpleza en la instalación.
- Movilidad y resiliencia a catástrofes o desconexiones.
- Coste de despliegue frente a ubicaciones difíciles de cablear-
- Coste general en entornos dinámicos.
- Polivalencia: Otorga conectividad de alta velocidad tanto en edificios como en zonas rurales.

Desventajas:
- Interfecencia entre sistemas debido a la transmisión simultanea en la frecuencia compartdia.
- Seguridad: Al enviarse paquetes por medio inaámbrico se facilita la posibilidad de captura de tráfico e interferencias.
- Consumo de potencia: Las WLans se asocian a dispositivos móviles con limitaciones de energía.
- Calidad: Menos ancho de banda, mayor tasa de error y delay, alcance limitado.
- Se debe acordar una banda de frecuencia común a nivel nacional.
- La estandarización lleva tiempo debido a las restricciones de los paises.

## IEEE 802.11 WLAN standards

Creado en 1997 y revisado por última vez en 2016, describe las funciones y servicios que un dispositivo debe implementar para integrarse en una red 802.11.

Las bandas de 2.4 y 5Ghz pertenecen a la ISM (No como pone en los apuntes), que es un conjunto de frecuencias reservadas internacionalmente para aplicaciones industriales, científicas y médicas, que no requiere licencia para su uso. La potencia de transmisión está regulada para evitar interferencias con otros dispositivos.

Servicios:
- Soportar transferencia de datos asíncrosas que no son sensibles a retrasos temporales (correo).
- Soportar tráfico si dependiente del retardo con una calidad aceptable (voz, vídeo).
- Procedimientos de autenticación y cifrado de comunicaciones para garantizar privacidad.

Se definen dos arquitecturas de red: Infraestructura y punto a punto (ad hoc).

Las aplicaciones no deberían de conocer que la conexión es por medio inalámbrico.

## IEEE 802.11 architecture

### Infraestructura (Punto de acceso)

Permite que un dispositivo cliente inalámbrico se comunique con cualquier otro dispositivo cableado o inalámbrico en la red mediante un punto de acceso sobre una red cableada o una columna inalámbrica.

Cada AP gestiona las comunicaciones de su rango y realiza funciones clave como: Control de acceso al medio, Gesión de movilidad y autenticación. Gracias a esto los dispositivos inalámbricos funcionan con una configuración mínima.

Infraestructura:
- Estación (STA): Dispositivo que tiene un mecanismo para acceder al medio inalámbrico y establecer una conexión por radio con el AP.
- Punto de acceso (AP): Un nodo que está integrado tanto en la red inalámbrica como en la red cableada (distribución).
- Conjunto de servicio básico (BSS): Grupo de estaciones, incluyendo e AP, dentro del área de cobertura de transmisión del AP.
- Portal: Punto de acceso a otra red.
- Sistema de distribución: Conexión de múltiples áreas de AP en una única red lógica denominada Conjunto de Servicio Extendido (ESS).

Características:
- Un AP tiene un rango de cobertura entre 20 y 500 metros y puede soportar entre 15 y 250 usuarios, dependiendo de la tecnología y configuración.
- Múltiples AP pueden permitir la transferencia de conexión cuando el usuario se mueve de un área a otra.
- Un AP puede monitorizar o bloquear tráfico de un cliente.
- La topología basada en AP es la más extendida, esto no reemplaza LAN sino que lo extiende.

Puentes LAN para exteriores:
- Puente punto a multipunto, conectando redes LAN en distintos edificios.
- Alternativa económica a montar fibra si existen barreras físicas.
- Llega a ofrecen altas tasas de transmisión de datos y alcances de varios kilómetros, utilizando antenas direccionales de línea de vista.

### Ad Hoc

En este caso no existe un punto de acceso, los nodos deben estar dentro del mismo rango de transmición para comunicarse. Para alcanzar distancias mayores se requiere reenvio de datos, actuando los dispositivos como intermediarios (Multihop Wireless Networks).

Tipos de redes Multihop:
- MANET: Arquitectura plana en la que todos los dispositivos pueden actuar como routers. Se realiza enrutamiento en capa de red extendiendo el rango de cada nodo.
- Mesh: Estructura jerárquica dentro de la arquitectura inalámbrica, se incorporan nodos malla que actúian como columna vertebral compuesta por routers inalámbricos, que operan como puentes dentro de una LAN con un solo dominio de difusión. El enrutamiento es en capa de enlace.

## WiFi Alliance

Se encarga de los programas de certificación.

## Wi-Fi Security

Peligros: Interferencias, DoS, Engaño, Robo de credenciales y Redes sin seguridad.

Ataques (vista genérica):
- Ataques con tramas de gestión: las tramas de gestión se envían sin encriptar ni proteger, por lo que se pueden forjar fácilmente.
- Ataques de repetición: Captura y reenvío de paquetes.
- MAC Spoofing: Reconfigurar la MAC de un atacante para hacerse pasar como AP o estación.
- DoS: Conseguir que usuarios autenticados no puedan acceder a los recursos.
- Offline cracking of keys: Fuerza bruta o diccionarios.
- Man in the Middle: Introducción de una estación en el medio de otras dos, que intercepta el tráfico pero sin interrumpir la comunicación, actuando como relé.

## WLAN Man in the Middle

MitM es un ataque en el que un tercero se interpone de forma silenciosa entre dos partes que creen estar comunicándose directamente, interceptando o modificando los datos. Esto permite eavesdropping, phishing y problemas de seguridad.

Estrategias
- En la misma red: Suplantación de servicios (ARP, DHCP o DNS).
- Conectado por ethernet detrás del AP: Manipular tráfico si el AP descifra antes de enviarlos.
- Suplantación del AP: Crear un rogue AP con mejor señal o realizar un DoS al legítimo y suplantarlo (Evil Twin).

Mitigaciones:
- Evitar redes abiertas o sin cifrado fuerte (AES CCMP).
- Evitar conexiones automáticas.
- Usar sistemas de seguridad.
- Detectar anomalías.

## WLAN Security protocols

- WEP.
- WPA.
- WPA2.
- WPA3.

### WEP

Primer sistema de seguridad bajo 802.11, utilica RC4 como algoritmo de cirado y tiene una clave e IV inseguros por ser muy cortos (24 bits IV). Se permitía reutilizar IVs, al usar XOR se puede recuperar el flujo de cifrado, la autenticación se hacía por challengue, por lo que era sencillo recuperar el flujo meidante el texto plano y el cifrado.

### Captive portals

Sistema de autenticación Web usado comúnmente en hotspots públicos. El cliente se conecta a una red abierta y obtiene una IP, todo su tráfico es bloqueado, salvo el que lo redirige a una página web. La web es un portal en el que el usuario introduce credenciales, si son correctas se habilita el acceso completo.

Presenta varias vulnerabilidades: El tráfico no es cifrado, es posible hacer spoofing de usuarios ya autenticados y se puede saltar el portal mediante túneles.

### 4-Way Handshake

0. Previamente tiene que haber una solicitud de acceso, presumiblemente se pudo haber realizado con EAP (WPA-Enterprise).
1. El AP responde con un ANonce (aleatorio).
2. El cliente genera una clave de sesión (PTK) con su PMK,ANonce,SNonce y MACs y responde con su propio SNonce y un MIC (integridad).
3. El AP realiza las comprobaciones y envía una GTK cifrada con la PTK (realmente con el KEK que es parte de la PTK) y un MIC para la integridad.
4. El cliente confirma con un MIC final que todo se ha realizado correctamente.

### Vulnerabilidades del 4-way handshake

Muchos elementos se transmiten en plano, si un atacante conoce la PMK (está dentro de la red), puede derivar las claves y descencriptar el tráfico o suplantar a un STA.

Ataques
- Ataques de diccionario Offline o crackeos.
- KRACK:
- PMKID:

EN WPA-Enterprise la PMK se deriva del intercambio EAP, por lo que es dificil el ataque de fuerza bruta, aunque vulnerable a MitM.

### Wireless Protected Setup

Diseñado para facilitar la conexión de dispositivos WiFi sin conocimientos o sin pantalla. 

Entidades
- Registrar: Una autoridad con permisos de emisión y revocación de credenciales de dominio (AP u otro).
- AP: Punto de acceso.
- Enrollee: Dispositivo que se quiere unir.

Métodos de acceso y problemas
- Push button Configuration, NFC o QR.
- PIN: 8 dígitos, es estático y conocido, es sencillo hacer fuerza bruta.


### TKIP y AES-CTR

TKIP es introducido con WPA como mejora a WEP y está diseñadi para ser compatible con hardware antigua. Utiliza RC4, pero con mejoras. 
- Per-Packet Key Mixing: Cada paquete se cifra con una clave única derivada de la clave temporal (TK) y el IV.
- MIC: Algoritmo de integridad que protege contra la modificación de paquetes.
- IV más grande de 48 bits.
- Rekeying automático.

AES-CTR se utiliza en WPA2 como parte del protocolo CCMP, basado en AES y mucho más seguro que TKIP. Se utilzia AES convertido en un cifrador de flujo y AES-CBC-MAC para verificar la integridad y autenticicdad del mensaje (un MAC).

### Robust Management Frames

El proceso de robust management frames es una mejora introducida en 802.11w en la que los marchos de desautenticación y desasociación ahora son cifrados y protegidos con integridad mediante la clave temporal TK específica de cada dispositivo, negociada con el AP al conectarse.

Se establece también una Integrity Group Temporal Key durante el proceso del 4 way handshake, que se usa para proteger la integridad de transmisiones multicast/broadcast del AP.

## Robust Security Network Association

Concepto que nace con IEEE 802.11i el cual define el tipo de asociación entre un cliente (STA) y un AP cuando se realiza mediante el 4-Way Handshake. La idea es que ambos lados prueban que conocen la clave maestra común, la pairwise Master Key (PMK), que es la base para derivar las temporales de cifrados e integridad.

## WPA3

Introduce la autenticación simultánea de iguales (SAE) en sustitución de PSK.
- Autenticación SAE en vez de Open authentication.
- Diferente PMK para cada asociación entre AP y STA, que se establece con privacidad mediante Ephimeral Diffie-Hellman Handshake.
- Autenticación conocimiento cero, lo que lo hace resistente a ataques de diccionario.
- La contraseña no se usa para la derivación de claves, por lo que las de sesión son seguras.
- Usa el modo transición (Porque esto viene aquí?).

### Cómo funciona WPA3

WPA3 utiliza SAE, pero eso no significa que desaparezca la autenticación de la red, primero es necesario una contraseña de acceso, igual que WPA2. Una vez se ha accedido, comienza SAE:
1. SAE es como diffie Hellman, generas un número privado y uno público, se comparte el público (y nonce aleatorio que se usa más adelante) y cada uno genera una clave compartida en privado. Esto es bastante más complejo, porque la contraseña de la red se utiliza como mapping sobre un punto de la curva elíptica.
2. Se aplica un hash sobre la contraseña y se comparte entre AP y Cliente para verificar que ambos tienen la misma.
3. Se deriva la PMK con otros valores como la MAC y nonce aleatorios con HMAC para obtener la PTK (Pairwise Transient Key).
4. La PTK se divide en;
    - KEK: Para cifrar la distribución de claves.
    - KCK Para verificar la integridad de los mensajes de sesión.
    - TK: Para cifrar los datos transmitidos.

### Otras aportaciones de WPA3

- Opportunistic Wireless Encryption (OWE): Permite cifrado en redes abiertas, protege la comunicación aunque no haya contraseña.
- WPA3-Enterprise: Usa AES-GCMP-256 para cifrado autenticado, permite cálculos en paralelo para mejorar el rendimiento. Varias Suites que no me voy a aprender.
- WiFi Devise Provisioning Protocol (DPP): Reemplazo de WPS, facilita la configuración rápida de equipos sin pantalla.

## Ataques sobre WLANs

**Ataques de control de acceso**
- War Driving:
- Rogue Access Points:
- Ad Hoc Associations:
- MAC Spoofing:
- 802.1X RADIUS Cracking:

**Ataques de confidencialida**
- Eavesdropping:
- WEP Key Cracking:
- Evil Twin AP:
- AP Phishing:
- Man in the Middle:

**Ataques de integridad**
- 802.11 Frame Injection:
- 802.11 Data Replay:
- 802.1X EAP Replay:
- 802.1X RADIUS Replay:

**Ataques de autenticación**
- Shared Key Guessing:
- PSK Cracking:
- Domain Login Cracking:
- VPN Login Cracking:
- 802.1X Identity Theft:
- 802.1X Password Guessing:
- 802.1X LEAP Cracking:
- 802.1X EAP Downgrade:

**Ataques de disponibilidad**
- AP Theft:
- Queensland DoS:
- 802.11 Beacon Flood:
- 802.11 Associate / Authenticate Flood:
- 802.11 TKIP MIC Exploit:
- 802.11 Deauthenticate Flood:
- 802.11 EAP-Start Flood:
- 802.1X EAP-Failure:
- 802.1X EAP-of-Death:
- 802.1X EAP Length Attacks:

# Tema 4.2 : Evil Twin

...

# Tema 5 : IPSec

## Introducción a IPSec

IPsec propone un framework de estándares abiertos para comunicaciones seguras sobre IP. Es transparente ( Capa Transporte), no requiere que las aplicaciones sean conscientes de la seguridad y ofrece soporte para IPv4 y IPv6, en IPv6 es obligatorio mejorando la seguridad.

Es util en FW y routers, ya que proporciona seguridad sin afectar a las estaciones, pero puede dar conflictos ya que requiere los protocolos 50/51 y los puertos UDP 500/4500.

Usos: Establecimiento VPN, Acceso remoto Low-Cost y conectividad con extranet.

RFCs: 4301, 4302, 4303, 7296

### Componentes de IPsec

- Dos protocolos de seguridad: AH y ESP.
- Algoritmos de cifrado.
- Dos modos de encapsulamiento: Transporte y Tunel.
- Protocolo de gestión y distribución de claves (IKE).
- Security Police Database (SPD): Qué paquetes.
- Security Association Database: Cómo van a ser protegidos.

### Modos IPsec

- Modo Transporte: Protege la comunicación extremo a extremo, el encabezado IP original permanece.
- Modo Túnel: Se encapsula el paquete IP en uno nuevo, se usa en VPN y entre routers.

### AH Authentication Header

No cifra los datos, solo proporciona autenticación e integridad. Los campos más importantes serían el Next Header que tiene el tipo de protocolo, el SPI (Security Parameters Index) y el número de secuencia.

### ESP Encapsulation Security Payload

Ofrece confidencialidad y autenticación opcionales, cuando no se usa se utiliza el algoritmo NULL. Campos: ESP Header, Datos cifrados, Trailer, y Autenticación (opcional)

## Security Policies and Selectors

El SPD contiene una lista ordenada de políticas de seguridad, asignación de un subconjunto de tráfico IP a la SA pertinente. Cada entrada tiene como clave uno o varios selectores que definen el conjunto de tráfico que abarcan, basado en direcciones IP, protocolo, rango, lista, etc.

Cada enclada también incluye si el tráfico debe ser omitido, descartado o procesado (SA o SA bundle con protocolos que deben emplearse).

### Procesado de paquetes salientes

1. Comparar el paquete con las políticas del SPD.
2. Si requiere IPsec: Se busca una SA en el SAD, si no existe se inicia IKE y la SA se guarda en el SAD.

En cada SA se especifica el módo de IPsec, los algoritmos y parámetros, TL, parámetros antireplay y su SA o SA bundle.

### Procesado de paquetes entrantes

- Si no contiene encabezado IPsec debe sonsultar el SPD.
- Si contiene encabezado utiliza la dirección de destino, protocolo y SPI para buscar la SA, si no se encuenta se descarta, si se encuentra se procesa y se entrega a la capa superior o se procesa.

Se pueden combinar asociaciones de seguridad o AH + ESP combinando SA.

## IKE

El objetivo de IKE es crear una asociación de seguridad entre 3 equipos, incluyeno el establecimiento dinámico de claves compartidas temporales para cifrado y autentciación.

Presenta dos fases:
1. Establece la asociación de seguridad (IKE-SA).
2. Utiliza IKE-SA para crear la asociación real que utilizarán AH y ESP.

### Intercambios de IKEv2

- IKE_SA_INIT: Negociación de algoritmos de cifrado para la gestión de la SA, Set de transforms (proposal) en la carga SA, derivación de claves maestras y es bidireccional.
- IKE_AUTH: Protección de integridad, autenticación mutua (firma, clave, EAP). Establecimiento de las primeras SAs de datos (unidireccionales).
- CREATE_CHILD_SA: Para establecer otros SA y componer un bundle SA y renovar SA existentes. Cuando se reinicia el proceso cambia el Oro
- INFORMATIONAL: Eliminar SAs, detectar peers muertos, mantener NAT.

## IPsec

### Protección contra DOS

Responder puede gastar recursos on IPs falsas, la solución es utilizar cookies que hacen que el estado no se guarde hasta recibir una respuesta válida del iniciador, esto aumenta la robustez a costo de dos mensajes extra.

### Auth Exchange

Para evitar ataques MITM AUTH se construye con un resumen criptográfico de los datos IKE_SA_INIT, None y la identidad. Es un mecanismo asimétrico, los extremos no necesitan usar el mismo mecanismo.

Peer Authorization Database (PAD): Vinculo SPD con IKE. Define la lista de pares IPsec identificados con su identidad IKE.

### NAT e IPsec

IPsec y NAT tienen problemas de compatibilidad: AH es imcompatible ya que NAT cambia la IP, ESP en modo transporte también tiene problemas por los checksum.

La solución es encapsular paquetes IPsec en UDP puerto 4500 y utilizar la detección intrínseca de NAT en IPsec para cambiar dinámicamente el tiempo del 500 a 4500 (NAT Transversal).

# Tema 6 : Securizando protolos de transporte en internet

## Fiabilidad

### Ataque de Reset TCP

El flag reset hace que la conexión se corte, su uso normalmente es para una recuperación rápida de errores.

Resumen del ataque:
1. Dos usuarios A y B mantienen una comunicación.
2. Un atacante envía un paquete Reset a uno de los pares.
3. Cuando se realice el siguiente envío, ese par corta la conexión con un reset.

Requisito:
- Excepción: En estado SYN-SENT el RST se acepta si el campo ACK hace referencia al SYN
- Todos los segmentos RST son validados comprobando si el número de secuencia se encuentra en la ventana válida. Debe estar entre RCV.NXT y RCV.NXT más RCV.WND.
- También debe coincidir cuatro valores de la comunicación: IP servidor, puerto, IP cliente y puerto.

*Una ventana historica ayuda a manejar paquetes con cierto retraso, en RST 64KB.

#### Posición no limitada

El ataque se puede realizar desde la red del emisor y desde la red del receptor. En el primer caso al observar el envío de datos del emisor, se envían datos más reset con el número de secuencia n + longitud del paquete anterior. En el segundo caso al observar la respuesta ACK con valor n del servidor se le envía datos con reset y secuencia n.

Dificultades del atque:
- Las direcciones y puerto del servidor son anunciadas para el servicio, pero el lado del cliente suelen ser valores no conocidos.
- El espacio de números de secuencia no se conoce, las conexiones duran poco y el espacio de números de secuencia varía, por lo que es dificil de predecir.

#### Posición limitada: Inyección ciega de datos/RST

Para adivinar un número de secuencia correcto se necesitan 2^31/wnd intentos en promedio, con ventanas históricas menores a 64 KB. Hoy en día las ventanas pueden superar los 6MB en redes de alta velocidad.

### Defensas

- Solo aceptar segmentos RST si el número de secuencia es el primero de la ventana (SO).
- Filtrar paquetes falsificados a nivel IP (bordes del AS).
- Utilizar la opción timestamp como defensa adicional.
- Autenticar paquetes TCP, es decir, TCP-AO (más adelante).

### Inundación SYN: Agotamiento de recursos

Se basa en enviar una gran cantidad de solicitudes SUN a un servidor sin completar el handshake TCP. Esto hace que el servidor recuerde los SYN reservando recursos y llenando la tabla de conexiones.

Si se hace con la IP real estas conexiones son filtradas en el servidor. Si se hace con IP suplantadas y el suplantado recibe la conexión , la cortará con un RST. Si se hace con IP que no contesten esto produce una denegación de servicio.

#### Defensas

Se podría cortar conexiones, pero no sabemos cuales, se podría no guardar nada, pero entonces no se establecen conexiones. Una opción es reducir la memoria para conexiones no establecidas.

### SYN Cookies

Una opción de defensa contra inundación SYN son las SYN cookies. En lugar de asignar recursos al recibir una solicitud SYN, se genera un número de secuencia inicial (ISN) que codifica información sobre la conexión:
- Los primeros 5 bits representan un número que aumenta lentamente con el tiempo.
- Los siguientes 3 bits contienen el tamaño máximo de segmento anunciado por el cliente.
- Los últimos 24 bits son un hash secreto basado en la IP y puerto, más los 5 primeros bits.

Al recibir un ACK sin conexión establecida, se le resta 1 y se compara su hash con los últimos 24 bits.

#### Inconvenientes

Las SYN cookies tienen limitaciones de espacio para almacenar información:
- MSS limitado a 65000.
- No hay espacio para SACK ni para ventanas grandes.

Soluciones a las limitaciones:
- Aumentar la cantidad de bits para la codificación.
- Usar SYN cookies solo en caso de ataque.
- Usar el timestamp que se devuelve en el ACK para codificar información adicional (9 bits escala de ventana y SACK).

### Anexo : SlowLoris

Otro ataque de agotamiento, se basa en hacer un montón de peticiones http incompletas, mandar cabeceras periódicamente para mantener las conexiones activas y nunca cerrarlas.

Mitigación: Aumentar el número de hilos (ineficiente), crear límites (ineficiente), proxy inverso en la nube.

QUIC: No explica nada.

## Autenticación

Como se ha mencionado anteriormente, la IP y puerto destino se conocen, el puerto origen se puede adivinar y la IP se puede falsificar. Ante falta de autenticación se pueden realizar ataques DoS (RST y SYN) e inyección de datos.

### Autenticación basada en posición

Uso:
- Control de conexiones entre hosts o enrutadores adyacentes.
- Cuando ambas partes residen en la misma LAN.
- Cuando se conocen la distancia de saltos.

### GTSM : El mecanismo de seguridad TTL generalizado

GTSM es una técnica de seguridad para proteger sesiones de comunicación mediante el uso del Time To Live en los paquetes IP. Se establece el TTL en 255 para saber que los paquetes realizan n saltos (entiendo que es para hacer siempre 255 menos n).

Se clasifican los paquetes recibidos en:
- Desconocido: Cualquier datagrama que no esté relacionado con una sesión GTSM.
- Confiable: Datagrama de la sesión GTSM con valor correcto de TTL (normalmente 254).
- Peligroso: Datagramas de una sesión GTSM con valor TTL incorrecto.

### TCP-AO : TCP Authentication Option

Una solución diseñada para mejorar la seguridad y flexibilidad en la autenticación de sesiones TCP. Permite el uso de algoritmos de seguridad más fuertes que MD5, como HMAC-SHA.

Se complementa con IKE, permitiendo el intercambio seguro de las claves. Y se complementa con TLS porque TLS protege los datos y TCP-AO la información del protocolo.

#### TCP-MD5

Opción de seguridad que añade una firma MD5 a los paquetes TCP, la autenticación se logra mediante una clave compartida entre los dispositivos que establecen la conexión.

TCP-Ao tiene algoritmos más fuertes, seguridad doble al generar las claves de tráfico a partir de la clave configurada por el usuario (como TLS ¿?), mejor gestión de claves y agilidad con cambios sobre la marcha sincronizando el cambio y más adecuado para conexiones de larga duración.

### TCP-AO : Claves y sus propiedades.

TCP-AO utiliza un esquema de claves para proteger las sesiones TCP:
1. Master Key Tuples (MKT): Define los atributos de autenticación de la conexión.
    - ID.
    - Identificador de conexión TCP: IPs y puertos.
    - TCP Option Flag: Las opciones TCP a autenticar.
    - Clave maestra: Secuencia aleatoria para generar las claves de tráfico.
    - Función de derivación de claves (KDF).
    - Algoritmo MAC: Método de autenticación.
2. Traffic Keys: Se generan a partir del MKT, direcciones IP, puertos e ISN (para asegurar la integridad), cuatro claves:
    - Send_SYN_traffic_key: No usa ISN.
    - Receive_SYN_traffic_key: Raro uso, excepto conexiones con apertura simultánea.
    - Send_other_traffic_key.
    - Receive_other_traffic_key.


# Tema 7 : Protección del DNS

El Servicio DNS es una base de datos distribuida que contiene el mapeo de nombres a IPs. Sigue una estructura jerárquica Top-Level Domain, Second-Level Domain... Los princiales elementos son los resolvers, el protocolo y los servidores.

## Domain Name System

Los ordenadores tienen una rutina de resolución de nombres, esta conoce el nombre de los servidores DNS locales. El servidor DNS local recibe una petición recursiva, esta petición se reenvía a otro DNS. Los servidores DNS pueden responder la petición, forwardear la petición o referirla a otro servidor.

Los servidores DNS locales deben conocer la dirección de los servidores DNS de zona raíz. Los servidores autorizados deben ser replicados, un servidor primario y varios secundarios. 

Las BD tienen un tiempo de vida, usado para almacenamiento de cache por parte de los servidores intermedios.

Información guardada:
- A y AAAA: Ipv4 e Ipv6
- CNAME: Nombre canónico (alias)
- NS: Name Server.
- MX: Intercambio de correo (nombre y prioridad de servidores SMTP).
- PTR: Puntero a un nombre para resolución inversa.
- SOA: Define la autoridad de una zona.
- TXT: Texto arbitrario (info adicional).

### Flujo de datos

Componentes del sistema:
- Archivo de zona: Contiene la información DNS.
- Servidor Maestro: Recibe los archivos de zona y distribuye actualizaciones.
- Esclavos: Replicas del maestro que responden a consultas.
- Caching Forwarder: Servidor intermedio que guarda en caché respuestas.
- Resolver: Cliente final que hace consultas DNS.

Flujo y amenazas:
1. Suplantación del maestro.
2. Corrupción de datos.
3. Actualizaciones no autorizadas.
4. Contaminación de caché.
5. Suplantación de caché.

## Vulnerabilidades de DNS

Se trata de un servicio anticuado, transmite la información en claro, no tiene autenticación ni comprobación de integridad. 

La identificación de la respuesta se basa en:
- TCP: Trivial la conexión identifica la sesión.
- UDP: La respuesta se acepta si el puerto origen y el ID de transacción son correctos.

### Contaminación de caché

Engañar a un DNS para que haga caché de un mapeo falso. Se puede solucionar usando puertos aleatorios e IDs en las peticiones. 

Hoy en día los navegadores tienen una caché DNS interna que guarda el dominio de las páginas. 

La solución es el DNS Pining (pin de la primera respuesta), filtrado de IP privadas y revisión de cabeceras de Host HTTP.

### Reflejo DNS y ataques de amplificación

Un atacante envía peticiones en nombre de la víctima y el servidor DNS le responde. Es un ataque de amplificación porque se envían paquetes pequeños con argumentos genéricos para que la respuesta del servidor DNS hacia la vícutima sean paquetes de gran tamaño.

La solución es que los servidores recursivos estén restringidos a IP de empresa/cliente, configurar Response Rate Limiting principalmente en los autoritativos y que los equipos CPE no deben escuchar paquetes DNS en su interfaz WAN.

### DNS Cache Snooping

La caché puede filtrar información sobre consultas resueltas.

1. Consulta no recursiva: Se consulta por un nombre de dominio a un DNS que solo responderá si lo tiene en caché. Solución: Consulta recursiva si no está en caché.
2. Si el valor TTL es cercano al autoritativo significa que no pasó por caché. Solución variabilidad el TTL.
3. Medición del tiempo de respuesta.

Soluciones: Desactivar el caché en autoritativos y hacer que los servidores DNS locales sean inaccesibles.

## Securizar DNS

### DNSSEC: Autenticación e integridad

Autenticación de origen e integridad de los datos. Asocia firmas digitales con Resource Record Sets (registros de un tipo dado para un dominio dado).

Nuevos tipos de RR:
- RRSIG: Contiene la firma criptográfica (de un RRset)
- DNSKEY: Contiene la clave pública.
- DS: Contiene el hash de un registro DNSKEY vinculandolo con la clave de su zona superior.
- NSEC/NSEC3: Demuestra la ausencia de un registro dentro de una zona, sirve para prevenir ataques como el "zone enumeration".
- CDNSKEY y CDS: Similar a DNSKEY pero usado en la comunicación entre registros secundarios y primarios.

Proceso de validación:
1. Validar la respuesta: Cuando un resolver recibe una respuesta DNS debe asegurar que los datos no han sido alterados.
    1. El resolver obtiene un RRset y su firma RRSIG.
    2. Obtiene el DNSKEY correspondiente.
    3. Extrae la Zone Signing Key del DNSKEY.
    4. Usa el ZSK para verificar el RRset con la RRSIG (el resultado de hacer hash sobre el registro con ZSK debe ser RRSIG).
2. Validar la firma: Para que un resolver confíe en una ZSK debe asegurarse de que proviene de una cadena de confianza.
    1. El registro DNSKEY también contiene una o más Key Signing Keys (KSK).
    2. El DNSKEY RRset es firmado con la KSK.
    3. El resolver valida el DNSKEY RRset con la clave pública KSK (se usa otra DNSKEY, en este caso la KSK para verificar otro RRSIG, no es un campo único, hay uno por cada clave).

Dos claves de firma: La ZSK, clave corta gestionada por el administrador de zona y la KSK, larga y guardada offline.

Para la autenticidad de la KSK el DS guarda un fingerprint de la misma, el DS se guarda en la zona padre. Un resolver valida el RRsig del DS en el padre (confianza en el KSK).

Las claves públicas de la zona raíz deben ser conocidas y confiables (Ceremonia de firmado raíz).

### Autenticación de entidades con nombre basado en DNS (DANE)

DNSSec permite la distribución en confianza de claves públicas asociadas a un dominio dado. DANE ofrece la opción de utilizar la infraestructura de DNSSEC para guardar y firmar claves y certificados usados por TLS.

### Autorización de autoridad de certificación

Una capa de seguridad sobre PKI, permite especificar que CA pueden proporcionar certificados para mi dominio o subdominio. Se pueden añadir métdoos de notificación.

### Transportes alternativos

Los ISP pueden ver las peticiones resultas por sus clientes, por lo que pueden modificar los resultados de los DNS (excepto si usa DNSSEC).

Opciones:
- DNS over TLS o DTLS: Mismo formato que plano, pero sobre una sesión TLS/TCP o DTLS/UDP.
- DNS over HTTPS (DoH): Formato DNS plano o en JSON sobre una conexión HTTPS.

## Resumen explicativo DNSSEC

DNS security se usa para asegurar autenticación de origen, integridad de los datos y autenticación en la denegación de existencia.

Las respuestas DNS tienen un nuevo campo llamado DNSKEY que contiene dos sub-entradas: KSK, que se encarga de firmar la ZSK y ZSK, que se usa para firmarse a si mismo.

DNSSEC también crea una nueva entrada RRsig que es una firma digital del RRset (hash de todo firmado con la privada), la ZSK se utiliza para comprobar que el RRsig es verídico y por tanto se logra autenticación e integridad.

Como extra hay que verificar que la ZSK es válida, para ello se usa la cadena de confianza, la respuesta DNS anterior contiene un campo DS que tiene el hash de la KSK del siguiente nivel (hijo). El resolver comprueba que ese DS y el KSK coinciden para comprobar que un registro RRsig(DNSKEY) coincide a su vez con la ZSK, quedando todo así autenticado.

La cadena de KSK y DS sigue entre hijos y padres hasta que llega a la raíz donde se encuentra un fichero que se debe descargar offline cuando montas un resolver el cual verifica la raíz.

Por último, el registro creado es el NSEC, el cual se utiliza para validad que "lo siento no tenemos ese nombre que estás buscando", que es la autenticación de denegación de existencia.

# Tema 8 : Protocolos de enrutamieto

## Interior Gateway Protocol (IGP) Security Issues

### OSPF

Es el protocolo más usado en empresas e ISPs, estandarizado por la IETF. Se trata de un IGP basado en estado de links, la topología se guarda como una colección de LSAs, cada router guarda una copia idéntica de la topología AS (Sistema Autónomo). Cuando cambia la topología los routers hacen sus cálculos SPF individuales.

Funcionamiento:
1. Los routers vecinos (comparten un L2) forman adyacencias, una ver formada intercambian LSA conocidos. 
2. Cuando la topología cambia, los routers afectados envían LSA por broadcast.
3. Las rutas internas se calculan por SPF y las externas se reciben desde un router frontera OSPF.

Consecuencias de los ataques:
- Starvation: El tráfico destinado a un nodo se envía a una parte de la red que no puede entregarlo.
- Congestión de la red: Se reenvía más tráfico de datos a través de una parte de la red de lo que debería.
- Agujero Negro: Gran gantidad de tráfico se dirige hacia un anerutador que no puede manejar ese nivel y deja caer muchos paquetes.
- Delay: El tráfico hacia un nodo se envía por una peor ruta.
- Looping: El tráfico se envía por una ruta que termina haciendo bucles, por lo que nunca llega.
- Eavesdrop: El tráfico se reenvía a través de un router que no debería ver el tráfico, creando una oportunidad de espiarlo.
- Partition: Una parte de la red cree que está particionada del resto de la red.
- Cut: Hacer creer que una parte de la red no tiene conexión.
- Instability: OSPF se vuelve inestable si no se logra convergencia en estado de reenvío global.
- Churn: Se aceleera el envío en la red, resultando en una larga variedad de patrones de envío de paquetes.
- Overload: Convertir los paquetes OSPF en una gran parte dle tráfico.
- Resource Exhaustion: Si hay muchos paquetes se provoca el agotamiento de recursos críticos del router como espacio de tablas y colas.

Técnicas de ataque genéricas:
- Eavesdropping: Información de enrutamiento transmitida en texto claro.
- Message Replay: Normalmente evitado ocn autenticación criptográfica.
- Message Insertion: Solo funciona desde un nodo interno o con la autenticación desactivada.
- Message Deletion: Se detecta mediante los LSU y caida de adyacencia.
- Message Modification: Solo funciona desde un nodo interno o con la autenticación desactivada.
- Man in the Middle: Solo funciona desde un nodo interno o con la autenticación desactivada.
- Denial of Service: Durante la fase de intercambio de LSDs se puede llenar la tabla mediante LSAs o cabeceras bogus LSA (no se que es).

Defensas integradas:
- Per-link authentication: Secreto compartido entre los routers de cada link (distinto en cada link). No existe una función de gestión de claves.
- Flooding: Las LSUs se envían por inundación, por lo que no se puede prevenir al existir múltiples caminos.
- Fight-Back: Si un router recibe un LSU con LSA que solo él debería enviar, vuelve a enviar con su información correcta.
- LSA: Un LSA tiene los links de un solo router, para causar daño un atacante tendría que falsificar el envío de muchos.
- Bidirectional transit links: Un link solo se considera válido si se recibe un aviso de ambos extremos.

Autenticación de mensajes:
- Null: Mensaje sin autenticación.
- Contraseña: Añade una contraseña en claro a cada LSU.
- Cifrados: MD5 o HMAC-SHA, no provee de confidencialidad ni defensa ante ataques de repetición. Estos solo funcionan cuando se reusan números de secuencia y se pueden forzar tirando una adyacencia.

#### Ataques típicos

- MaxAge LSA: Se envían los LSU con los LSA con la validez ya cumplida, lo que hace que desaparezcan del router. Esto provoca churn, agujeros negros, aumento de uso de CPU y inundación de LSAs. El router original puede hacer fight-back.
- Seq++: Sustituir LSAs mandando unos con un número de secuencia superior, lo que hace que sustituyan los verídicos provocando modificaciones en las tablas. MaxAge y Seq++ se combaten con respuestas de los routeres origen, pero si el atacante envía por debajo de la restricción MinLSInterval los cambios permanecen en la red, por lo los fight-back deben notificarse a los administradores.
- Disguised LSA: Envío de un LSA falso con checksum y número de secuencia idéntico antes del siguiente LSA. Provoca que no haya fight-back porque los LSA son "idénticos". La mitigación es randomizar los números de secuencia. 
- Remote false adjacency: Un atacante envía paquetes Hello a un router usando una dirección IP falsa, necesita conocer las claves criptográficas o que la red use Null. Esto crea un router fantasma al creer que hay un nuevo vecino, el atacante puede inyectar LSAs para controlar la red. La mitogación consiste en autenticación criptográfica y GTSM.
- Persistent poisoning: Envío de tramas LSA con el ID de la LSA coincidente, pero cambiando el ID del router origen. Esto provoca que se actualice esa LSA, es un fallo de diseño arreglado en versiones modernas.

#### Buenas prácticas

- Transit-Only Networks: Ocultar prefijos de enrutamiento de redes de tránsito (internas) de las tablas de enrutamiento. Evita ataques remotos, en Cisco se le llama supresión de prefijos.
- Interfaces no numeradas: Interfaces que comparten la IP de otra en el mismo host, no se genera ruta para ellas.
- Autenticación criptográfica: Usar diferentes claves en cada link.
- Mecanismo de seguridad TTL generalizado
- Reverse Path Forwarding: Se suele utilizar a la entrada de la red cuando se utiliza enrutamiento simétrico, comprueba que el paquete IP llega a través de una interfaz utilizada para enviar tráfico. Se configura en los routeres frontera.
- Fight back traps/notification: Notificar a los administradores que un router está usando fight-back. Indica entidades maliciosas, malas configuraciones o partición.
- Herramientas de comprobación de consistencia: Los LSA deben ser idénticos en todos los routeres.

## Exterior Gateway Protocol (EGP) Security Issues

Internet es una colección de AS, siendo un AS (Sistema Autónomo) con un prefijo IP común con una política de enrutamiento propia.

Dos variantes: Transit (Conecta múltiples AS para reenviar el tráfico) y Non-Transit (Se conecta a uno o varios AS para reenviar su propio tráfico).

### BGP 

Es el único EGP en uso en internet, mantiene una lista de caminos eficientes entre prefijos de red. Un camino es una lista de números de AS ordenadas.

e-BGP se usa para intercambiar rutas entre diferentes AS y el i-BGP se usa dentro de un AS para compartir las rutas aprendidas por e-BGP.

Los pares BGP intercambian datos mediante conexión TCP al puerto 179.

Preocupaciones de seguridad:
- DoS: Starvation, Blackhole, Delay, Churn...
- Wedgies: BGP no es determinista, un atacante puede forzar un estado no deseado interrumpiendo una sesión BGP.
- Eavesdropping: BGP se transmite en plano.

#### Peer Spoofing and TCP Resets

Inyectar tráfico en la sesión TCP entre dos peers con una dirección IP falsa (Reset como caso especial). Para realizarlo es necesario averiguar la dirección IP y enviar paquetes formados explícitamente.

Mitigación: Aleatorización del número de secuencia TCP inicial, número de puerto aleatorio, usar autenticación TCP, usar GTSM, usar IPsec.

#### TCP Resets with ICMP

Los mensajes de error pueden romper una conexión TCP. Enviar un mensaje de error ICMP falsificado al servidor BGP, solo es necesario el puerto destino y la dirección IP.

Mitigación: Igual que el anterior y filtrar los ICMP tipo 3.

#### Route Flapping

El route flapping es un problema de red en el que una ruta cambia repetidamente su disponibilidad. El atacante desactiva un router BGP repetidamente para que sus vecinos anuncien cambios continuos en sus rutas anunciadas, las rutas son purgadas de la red y causan cortes o degradación del tráfico.

Mitigación: Route Flap Damping y Graceful Restart.

#### Malicious Route Injection

Los prefijos de BGP no suelen estar autenticados, es posible anunciar un prefijo más específico que el que anuncia el AS real. Esto produce que el tráfico hacia ese prefijo vaya hacia el otro AS, el atacante puede robar ese tráfico o hacer MITM.

Mitigación: Filtrado de rutas y BGPsec (?).

### BGP TCP Session

La sesión TCP entre dos pares BGP debe protegerse para evitar inyección de tráfico y ataques reset.

Recomendaciones: Usar TCP-AO o TCP-MD5, implementar GTSM y considerar el uso de IPsec.

*IXP: Internet Exchange Point: Punto donde se comunican distintos ISP, operadores, etc.

#### Filtrado de Prefijos

Una empresa de tier 2 tiene varias relaciones de enrutamiento:
- Peering con otros proveedores Tier 2.
- Cliente de proveedores Tier 1.
- Proveedor para clientes downstream.

Filtrado a los clientes:
- Entrada: Solo aceptar los prefijos asignados al cliente, configurados manualmente.
- Salida: La mayoría solo necesita la ruta por defecto, si necesita la tabla entera se debe filtrar prefijos no enrutables, rutas demasiado específicas y la por defecto.

Filtrado con proveedores upstream:
- Entrada: La ruta por defecto, prefijos no enrutables globalmente, prefijos no signados por la IANA, rutas demasiado específicas, prefijos del AS local, prefijos LAN IXP.
- Salida: Permitir solo prefijos del AS local y downstreams y bloquear prefijos no enrutables globalmente, rutas muy específicas, prefijos LAN IXP, ruta por defecto.

- Upstream: Entidad que proporciona acceso a internet (ISP).
- Downstream: Entidad que recibe conectividad.


#### AS Path Filtering

- Solo aceptar las rutas que contienen ASN que pertenecen al cliente o viajan a través.
- Solo aceptar rutas con longitud apropiada al tipo de cliente.
- Rechazar rutas que incluyan ASN de proveedores ascendentes (?).
- Rechazar prefijos con números ASN privados, salvo excepciones.
- Rechazar prefijos si el primer ASN no es par.
- No anunciar prefijos si el servicio de tránsito no está previsto.