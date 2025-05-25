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

...

# Tema 2 : Public Key Infraestructure



## Internet PKI Infraestructure



## Issues with the current PKI Infraestructure



## Infraestructure Improvements



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
- PEAP (Protected EAP): Similar al anterior, el cliente se autentica usando EAP dentro del túnel TLS.
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

# Tema 4 : Wireless LAN Security



## IEEE 802.11 WLAN standards




## IEEE 802.11 architecture



## WiFi Alliance


## Wi-Fi Security



## Robust Security Network Association



## 4-Way Handshake



## Ataques sobre WLANs



# Tema 4.2 : WPA3

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



## Autenticación



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
- Starvation:
- Congestión de la red:
- Agujero Negro:
- Delay:
- Looping:
- Eavesdrop:
- Partition:
- Cut:
- Instability:
- Churn:
- Overload:
- Resource Exhaustion:

Técnicas de ataque genéricas:
- Eavesdropping:
- Message Replay:
- Message Insertion:
- Message Deletion:
- Message Modification:
- Man in the Middle:
- Denial of Service:

Defensas integradas:
- Per-link authentication:
- Flooding:
- Fight-Back:
- LSA:
- Bidirectional transit links:

Autenticación de mensajes:
- Null:
- Contraseña:
- Cifrados:

#### Ataques típicos

- MaxAge LSA:
- Seq++:
- Disguised LSA:
- Remote false adjacency:
- Persistent poisoning

#### Buenas prácticas

- Transit-Only Networks:
- Interfaces no numeradas:
- Autenticación criptográfica:
- Mecanismo de seguridad TTL generalizado
- Reverse Path Forwarding:
- Fight back traps/notification:
- Herramientas de comprobación de consistencia:

## Exterior Gateway Protocol (EGP) Security Issues



### BGP 



#### Peer Spoofing and TCP Resets



#### TCP Resets with ICMP



#### Route Flapping



#### Malicious Route Injection



#### BGP TCP Session



#### Filtrado de Prefijos



#### AS Path Filtering