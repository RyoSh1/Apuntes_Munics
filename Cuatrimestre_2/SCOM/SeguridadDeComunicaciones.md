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



