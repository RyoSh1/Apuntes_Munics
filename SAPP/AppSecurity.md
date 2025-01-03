# Tema 1: Introducción

## Conceptos básicos

## HTTP

Protocolo utilizado para intercambiar recursos en Internet, como HTML.

### Peticiones y Respuestas

Las peticiones constan de una línea inicial, un conjunto de cabeceras y en algunos casos un cuerpo.

La respuesta contiene la línea de respuesta, cabeceras, línea en blanco y cuerpo.

### HTML

Lenguaje de marcado para crear páginas web, en HTML se pueden añadir recursos desde ficheros externos.

#### Frames

Ventanas independientes incrustadas dentro de la ventana general del navegador.

#### JavaScript

Lenguaje interpretado usado tradicionalmente para incluir contenido ejecutable dentro de un documento HTML.

#### JSON

Formato de intercambio de datos basado en JavaScript.

#### AJAX

Asynchronous JavaScript And XML es una técnica que permite ejecutar peticiones HTTP asíncronas en el navegador. Las principales API son XMLHttpRequest y Fetch.

#### CSS

Lenguaje que se utiliza para definir la apariencia de un documento HTML.

#### XML

Metalenguaje que permite definir lenguajes de marcas.

#### XPath

Lenguaje que permite construir expresiones que recorren y procesan un documento XML.

## Autenticación, autorización y control de acceso

- **User&Passwd**: Contraseñas robustas para prevenir ataques de fuerza bruta y deben guardarse en BD cifradas.
- **Smart Cards**: Autenticación mediante tarjetas con certificado digital (DNI).
- **Métodos biométricos**: Rasgos fisiológicos o comportamientos.
- **Certificado digital**: Pareja de claves pública y privada, funciona como un pasaporte.
- **Criptografía asimétrica**: Diferente clave de cifrado y descifrado.
- **Criptografía simétrica**: Misma clave.
- **2-Way Handshake**:
    1. Saludo.
    2. Servidor envía PUB.
    3. Cliente envía PUB y se genera *master-secret*.
    4. Conexión por clave simétrica.
- **X.509**: Estándar de certificados digitales, contiene información sobre persona/entidad, PUB e información de la certificadora (firmado PR).
- **Políticas de autenticación y control de acceso**: La autorización define las acciones que ese usuario puede ejecutar y el acceso a recursos. El control de acceso verifica los privilegios.

## Aplicaciones y servicios web *stateful*

El servidor mantiene información del cliente en una sesión.

**Sesión**: Datos relevantes del usuario. Una sesión puede persistirse en BD o se perderían al reiniciar el servidor.

### Servlets - HttpSession

- **getSession**: Obtener la sesión actual.
- **setAttribute**: Almacena un objeto en la sesión.
- **getAttribute**: Obtiene un objeto almacenado.

### Cookies

- Las Cookies aparecen en las cabeceras HTTP, el servidor las envía en la cabecera Set-Cookie y el cliente en la cabecera Cookie.
- Tienen muchos usos como sesión, personalización, tracking...
- Pueden tener parámetros adicionales: *Expires*, *Max-age* (ambas para persistencia), *Path*, *Secure* (https), *Http-only* (innacesible para JS), SameSite (Comprueba or/des).
- Otros: *Third Party Cookies* (AJAX a la web de publicidad), *URL rewriting* (Si no soporta cookies el navegador), *Sticky Sessions* (Técnica de replicación de aplicaciones con estado, los balanceadores de carga mantienen la sesión en el mismo servidor).

## Aplicaciones y servicios *stateless*

La información necesaria para identificar al usuario será enviada en el proceso de autenticación. Eficiente (Sin acceder a BD) y seguro (Los datos no son manipulados).

- JSON Web Tokens (JWT): Tokens con información del usuario que mantienen la integridad mediante criptografía, se pueden transmitir por cookies o por HTTP.

## Aplicaciones Web tradicionales y SPA

En las aplicaciones tradicionales cuando el usuario envía un formulario esto produce una recarga completa de la página, por lo que el servidor genera contenido HTML.

En las Single Page Application no se produce una recarga completa de la página sino que se modifica un fragmento del árbol DOM, permitiendo así interfaces más interactivas, estas aplicaciones trabajan con JSON y XML.

# 2.1 Marcos de Referencia

### MITRE

Organización sin ánimo de lucro encargada de registrar y publicar información relativa a vulnerabilidades y ataques conocidos.

Gestiona proyectos como el CWE y el CVE.

#### CWE

*Common Weakness Enumeration* es una clasificación de debilidades de software dirigida a desarrolladores y profesionales de la seguridad. Dividen en elementos: Clases, Vulnerabilidad Base, Variantes, Composiciones, Vistas y Categorías.

#### CVE

Common Vulnerabilities and Exposures es una lista de vulnerabilidades conocidas que han sido detectadas en programas o librerías, las entradas representan vulnerabilidades concretas en software conocido.

#### CNA

CVE Numbering Authorities son las entidades encargadas de asignar los identificadores en el CVE (Les interesa para desarrollar parches, Windows).

#### NVD

National Vulnerability Database es un proyecto del gobierno de EEUU encargado de recopilar y gestionar información sobre vulnerabilidades. Contiene los datos del CVE pero ampliados y con mejor buscador.

#### CAPEC

Common Attack Patern Enumeration and Clasification es un catálogo de patrones de ataque, una recopilación de métodos conocidos para explotar vulnerabilidades.

#### CVSS

Common Vulnerability Scoring System es una métrica estándar gestionada por el Forum of Incident Response and Security Teams para determinar la criticidad o impacto de las vulnerabilidades.

El algoritmo varía según: Métrica Base (Vector de acceso, Complejidad, Privilegios necesarios y métricas de impacto), Métrica temporal (Explotabilidad, Estado de la medida correctora) y Métrica de entorno (Métrica Base pero adaptada al entorno que sufre el problema).

#### CWSS

Common Weakness Scoring System es un mecanismo de clasificación de vulnerabilidades como CVSS, pero desarrollado por el MITRE (sin uso).
### OWASP

The Open Web Application Security Project es una comunidad abierta dedicada a promover y mantener materiales relacionados con la seguridad (Fundación OWASP).

Otros: OWASP Vulnerable Web Applications Directory, OWASP Testing Guide.

#### OWASP Top 10

Informe de los 10 riesgos de seguridad más importantes en aplicaciones web. Desde el último, cada entrada del Top 10 es un conjunto de entradas del CWE.

- Vulnerabilidades en el control de acceso.
- Problemas criptográficos.
- Inyección de código.
- Diseño inseguro.
- Configuración de seguridad incorrecta.
- Utilización de componentes obsoletos.
- Problemas de identificación y autenticación.
- Problemas de integridad en la aplicación o en los datos.
- Problemas en el log y en la monitorización.
- Falsificación de peticiones realizadas por el servidor.

# 2.2 Vulnerabilidad en el tratamiento de los datos de entrada

Una vulnerabilidad es una debilidad en alguno de los componentes de un sistema informático que puede ser explotada por un atacante. La debilidad más común consiste en validad de forma incorrecta los datos provenientes del usuario.

En este capítulo se ven aquellas vulnerabilidades que explotan debilidades en la validación de datos de entrada.

## Inyección de código

Cuando una aplicación interactúa con otra utiliza algún tipo de lenguaje, formato o protocolo de intercambio de información, esto se combina con datos que provienen del usuario. Las vulnerabilidades de inyección de código utilizan como datos de entrada palabras o tokens reservados en esos lenguajes para intentar cambiar la semántica del mensaje original.

## Inyección de SQL

Se produce SQL Injection cuando los datos de entrada del usuario se utilizan para componer una consulta SQL. Los datos incluyen comillas o punto y coma.

¿Qué se puede hacer con SQL Injection?
- Introducir una consulta completa en el primer campo y sustituir así la consulta original.
- Sustituir campos WHERE por búsquedas exhaustivas de información, obteniendo así otras cuentas.
- Modificaciones en la base de datos como borrados o inserciones.
- Modificaciones sutiles de datos (dificil detección).
- Database fingerprint: Descubrir qué base de datos almacena la información, se pueden analizar los mensajes de error.
- Blind SQL Injection: Tipo de inyección en la que el atacante genera consultas para descubrir información de forma progresiva. Se suele usar con diccionarios.

### Prevención de SQL Injection

La técnica más efectiva es usar consultas parametrizadas, así se evita la construcción de la consulta de forma manual. 

Las consultas parametrizadas se encargan de formatear los datos de entrada para generar consultas válidas en un gestor concreto. También se realiza el escapado de las palabras y caracteres reservados.

Que conste que muchas veces es posible escapar introducciendo dos tokens seguidos.

Las consultas parametrizadas permiten establecer parámetros cuando se trata de valores literales, pero no permiten establecer parámetros de consulta de identificadores (Tablas y columnas).

Otra técnica -> Listas Blancas: solo permiten valores válidos, esto acota el sistema y rechaza otros datos de entrada.

Manual: Como último recurso es posible escapar de forma manual todos los datos de las entradas, pero cada regla es diferente en cada BD.

### Referencias

SQL Injection tiene su propia entrada en la lista CWE. Dentro de Java también hay otra variante específica para la librería Hibernate.

La empresa Veracore (líderes en seguridad), ha encontrado esta funcionalidad en el 28% de aplicaciones.

## Inyección en ficheros de log

Los registros son históricos de los eventos, acciones, errores, etc. que se producen durante la ejecución de un programa. Log Injection se produce cuando en los registros se escriben mensajes generados a partir de datos de entrada y estos no han sido validados.

Consecuencias: Falsificación de registros para enmascarar otros ataques, Inyección de código ejecutable que pueda ser susceptible de ejecutarse en una herramienta de visualización.

Prevención: Procesar y escapar todas las entradas que provienen de usuario, por ejemplo utilizando las capacidades de la librería que genera los ficheros de log.

Referencias: Propia entrada en el CWE ( aplicaciones y servidores web).

## Inyección en las cabeceras HTTP

HTTP Header injection es el proceso de utilizar entradas de usuario incorrectamente escapadas para añadir cabeceras HTTP de forma dinámica e inesperada. El ataque más conocido es la inyección de saltos de línea para insertar contenido adicional (HTTP Response Spliting). Se puede combinar con JS.

Se pueden añadir cookies de forma dinámica para para incluir en ellos texto que puede introducir saltos de línea que rompan la petición e insertan contenido malicioso.

Prevención: Validar las entradas de forma que solo se permita un subconjunto de caracteres seguros (lista blanca). Codificar las entradas para escapar caracteres problemáticos, especial atencion a saltos de línea.

Referencias: Dos entradas relacionadas en el CWE.

## Inyección SMTP

Simple Mail Transfer Protocol es un protocolo que permite envío de correos electrónicos.

Se produce inyección cuando a través de entradas de usuario, el atacante consigue insertar cabeceras adicionales u otros elementos. 

Este tipo de técnicas se suelen utilizar para phising o enviar spam a múltiples destinatarios.

Prevención: Listas blancas de valores válidos, por ejemplo posibles destinatarios y escapado de caracteres reservados en los valores de un formulario.

Referencias: No hay una directa pero relacionadas.

## Inyección de comandos del SO

Inyección de comandos del SO cuando una aplicación al no poder realizar cierta funcionalidad a través de sus lenguaje necesita hacer llamadas directamente a traves del SO.

Prevención: Evitar en medida de lo posible este tipos de llamada y si no queda más remedio, validar los datos de entrada con listas blancas o escapados.

Referencias: Tiene entrada CWE y patrones de ataque.

## Inyección en LDAP

Lightweight Directory Access Protocolo, es un protocolo que permite el acceso a un servicio de directorio para buscar información en un entorno de red. Un directorio está formado por un conjunto de objetos con atributos organizados de forma jerárquica, para su acceso se usan filtros con sintaxis concreta.

La sintaxis permite expresiones complejas de operadores lógicos. Como en SQL, si los caracteres no se procesan es posible modificar la consulta y ejecutar un ataque.

También es posible ejecutar Blind LDAP Injection a través de filtros booleanos.

Prevención: Escapado de variables de entrada, listas blancas de valores válidos y consulta de permisos LDAP

Referencias: Dos relacionadas.

## Inyección XML y XPath

Se produce inyección en XML cuando los datos de entrada contienen caracteres reservados en ese lenguaje y genera un documento no esperado.

Si se añaden caracteres reservados el resultado es una modificación del documento, modificando datos sensibles.

XPath es un lenguaje de consulta de documentos XML y es posible inyectar código si no se procesa de forma adecuada.

Si tenemos una BD guardada en XML, podemos introducir datos en el XPath que nos permitiría acceder directamente sin autenticación.

Prevención: Validación adecuada de datos escapando conflictos en función de donde se va a añadir el contenido ( texto, atributos, comentarios...). Además de validar datos un mecanismo más general de validación es a través de XML Schemas o de DTT, pero ahi es necesario tener en cuenta otras vulnerabilidades.

Se pueden establecer tipos de datos, máximos y mínimos y máximo de ocurrencias. Importante procesar de forma adecuada *()='[]:,*/* y el espacio.

Referencias: 2 Entradas.

Conclusiones -> Siempre examen.

## Inyección de JavaScript

Es un tipo de ataque de inyección de código que inyecta código JS en el navegador del usuario cuando este está accediendo al sitio web afectado.

### Tipo 1: Reflected XSS

El servidor lee los datos de la petición HTTP y los inserta en la respuesta. Los datos insertados en la respuesta pueden contener código ejecutable. Puede ser propagable en correos.

### Tipo 2: Stored XSS

El atacante consigue insertar texto JS en la base de datos. Esos datos se pueden utilizar más adelante para generar contenido HTML.

### Tipo 0: DOM-based XSS

La inyección de código la realiza el navegador. Esto significa que, al contrario que en los tipos 1 y 2, la respuesta de la petición HTTP no contiene el script que se ha inyectado.

### Cross-Frame Scripting (XFS)

Ataque que combina inyección de código JS utilizando un iframe. El clickjacking es una ataque que consiste en superponer un iframe transparente (invisible) sobre la página que está viendo el usuario.

### Cross-Site History Manipulation (XSHM)

La manipulación del historial entre dominios es un ataque que se basa en el hecho de que el historial del navegador contiene entradas de todos los sitios web que el usuario ha visitado anteriormente. Se utiliza el objeto *history* usando history.length, history.go, etc.

### Prevención

Las reglas de escapado HTML son complicadas por lo que deberían usarse librerías de eficacia contrastada con funciones predefinidas. Reglas:

- Regla 0: Evitar siempre los datos inseguros en etiquetas script, comentarios, atributos, etiquetas y estilos CSS.
- Regla 1: Escapar contenido insertable.
- Regla 2: Escapar contenido insertado dentro de los valores de atributos, prevenit que se "rompa" el atributo.
- Regla 3: Escapado dentro de etiquetas script o de manejadores de eventos. Escapar entrecomillados con \xHH.
- Regla 4: Se debe escapar dentro de las hojas de estilo CSS utilizando \HH.
- Regla 5: Escapado de enlaces a URLs. No se recomienda  codificar toda la URL solo encoding de los valores de parámetro.

Se puede enviar la cabecera X-Frame-Options para evitar cargarse dentro de un iframe.

### Content Security Policy

Mecanismo que permite restringir los contenidos que el navegador puede cargar en un sitio web. Su principal funcionalidad es la de detener ataques de inyección de código.

## Inyección de entidades externas en XML

XML External Entities es un ataque que afecta al lenguaje XML y consiste en añadir referencias a elemnetox externos dentro de un documento XML con el objetivo de causar algún daño. Se puede referenciar otros ficheros XML, DTD y XML Schemas.

Blind XXE: Los resultados no se muestran en la salida de la petición. Si consigue acceder a un servicio interno de la organización se produce un Server Side Request Forgery (SSRF).

### Prevención

Los parsers XML ofrecen opciones para deshabilitar total o parcialmente el soporye de entidades externas. 

## Deserialización y carga dinámica

### Deserialización insegura

La serialización es un proceso que transforma un objeto de un lenguaje concreto en un flujo de texto o binario. Se produce deserialización insegura cuando no se valida si el flujo de datos de entrada va a crear objetos del tipo esperado.

Java permite utilizar los métodos XMLEncoder y XMLDecoder, sin las validaciones adecuadas este mecanismo puede ser muy peligroso porque podría llegar a permitir la ejecución de cualquier método de cualquier clase Java. 

### Prevención de la Deserialización insegura

Se pueden utilizar las siguientes técnicas:

- Validaciones de integridad a los objetos serializados.
- Listas blancas de objetos válidos.
- Aislar el cósigo que realiza la deserialización para permitir permisos mínimos.
- Monitorización de los procesos de deserialización.

### Carga dinámica insegura

El API reflection permite cerar objetos a partir de su nombre, esto permite cargar cualquier clase con tal de que su nombre termine de la forma adecuada.

## Desbordamiento de buffer y de pila



### Prevención



### Ensamblador x86

- El comando push coloca el operando en el principio de la pila.
- El comando pop elimina el elemento situado al principio de la pila.
- mov copia el dato referenciado en el segundo en la localización del primero.
- sub almacena en el primero el resultado de restarle el segundo.
- jmp transfiere el control a la direccion de memoria indicada.
- ret obtiene la dirección del stack y devuelve el control a esa dirección (pop + jmp).

## Validación de datos

Validar los datos a nivel seguridad siempre debe realizarse en el servidor, en java tenemos el paquete de javax validation (API de validación de clases y anotaciones).

Es posible crear nuevas personalizadas.

## Vulnerabilidades en la autenticación

Las vulnerabilidades en los mecanismos de autenticación permiten a un atacante obtener las credenciales de los usuarios de la aplicación.

Es importante no revelar si usuario o contraseña son incorrectos para no indicar parcialmente información.

Otra opción es utilizar autenticación multifactor, para completar con éxito el proceso de autenticación.

También es importante almacenar en la base de datos las contraseñas con su debida protección.

### Hash

Para no almacenar contraseñas en claro una técnica muy utilizada es Hash and Salt. Un hash es un algoritmo matemático que transforma un bloque de datos en una nueva serie de caracteres de longitud fija de forma unidireccional y no reversible. Las técnicas de hash enfocadas a guardar contraseñas deben ser lentas y evitar colisiones.

El proceso es el siguiente, a la hora de guardar la contraseña se utiliza el salt y se genera su hash, después se guarda salt y hash en la base de datos. Al verificar la contraseña se obtiene de la base de datos el salt y se utiliza con la contraseña proporcionada, si los hashes son iguales es correcta.

#### PBKDF2

Un algoritmo de hash muy utilizada, permite especificar un salt y el número de iteraciones que realizará para calcular el hash final.

#### Bcrypt

Bcrypt es una de las funciones más utilizadas, está diseñada para ralentizar ataques de fuerza bruta. En su diseño añade un factor de trabajo llamado rondas para ralentizar el hash y la mayoría de implementaciones utiliza un salt aleatorio en cada invocación.

### Escenarios

- Almacenamiento en texto plano.
- Almacenar un hash de la contraseña con SHA o MD5: Muy rápido por lo que vulnerable a Rainbow Tables.
- Concatenación de bytes fijos antes de la función de hash: Vulnerable si un atacante consigue obtener el salt.
- Salt diferente para cada uno de los usuarios: El atacante tendría que generar un diccionario diferente para cada salt.
- Usar Bcrypt y el factor de trabajo.

### Transmisión

La información de autenticación no debería transmitirse mediante un medio inseguro, como HTTP que se transmite en plano. Otros métodos de codificación sencillos como Base64 son también vulnerables.

Solución: HTTPS añade una capa de cifrado sobre TCP.

## Manejo de la sesión

### Secuestro de la sesión

Un atacante logra obtener una cookie de sesión valida de un usuario, por lo que es posible ejecutar acciones en su nombre. 

Para mitigarlo se puede usar HTTPS, no permitir acceso JS a las cookies o implementar caducidad de la sesión.

### Fijación de la sesión

Variante de secuestro de la sesión en la que la víctima se autentica usando un identificador de sesión que el propio atacante ha generado.

El atacante envía el identificador de sesión y URL a la víctima y es esta la que accede de forma voluntaria y se autentica.

Prevención: Generación de cookie de sesión cada vez que el usuario se autentica.

### Reescritura de URL

Si un atacante es capaz de  redirigir a la víctima hasta un sitio web que él controla puede capturar la URL origen a través de la cabecera HTTP Referer. Esto es susceptible a robo de sesión en navegadores que no soporten cookies.

### Política de mismo origen

La Same-origin Policy define una serie de reglas para restringir cómo un documento o sus scripts pueden interactuar con recursos de dominios diferentes.

Esto afecta a escrituras entre dominios, incrustación de elementos, acceso a document o window, interacciones entre objetos, etc.

También impone restricciones sobre las cabeceras HTTP, por defecto solo se pueden hacer peticiones AJAX al mismo dominio.

El almacenamiento del navegador y las cookies estan separadas por dominio y se pueden establecer límites de subdominio y rutas.

JSONP (con padding) es una técnica utilizada en JS para realizar llamadas asíncronas a dominios diferentes y acceder a servicios web que devuelven JSON pero consiguiendo devolver contenido JavaScript y no un objeto JSON.

### CORS (Intercambio de recursos de orígenes cruzados)

El intercambio de recursos de orígenes cruzados es un mecanismo que pemrite al navegador web solicitar recursos a dominios diferentes. Envía cabeceras HTTP adicionales para aceptar o denegar la solicitud, permite modificar el comportamiento por defecto de la política del mismo origen.

#### CORS en peticiones simples

HEAD, GET o POST y utilizan cabeceras HTTP estándar. El navegador envía la cabecera Origin y el servidor envía en la respuesta las cabeceras que empiezan con Access-Control-*.

#### CORS en peticiones complejas

Se consideran complejos los métodos PUT y DELETE y las peticiones con cabeceras no simples (Content-Type...).

La respuesta del servidor contiene Access-Control-Allow-Origin/Methods/Headers.

### Cross-Site Request Forgery

XRSF es una vulnerabilidad en la que el atacante utiliza el navegador web de la víctima para ejecutar una petición maliciosa en su nombre.

El ataque utiliza de manera automática la cookie con el identificador de sesión de la víctima, por lo que no es posible diferenciar cuando es la propia víctima la que ejecuta voluntariamente o no la acción. Explota la confianza de un sitio web en sus usuarios.

Este ataque explota el hecho de que las peticiones HTTP sean repetibles, mediante mecanismos como las cookies persistentes.

#### CRSF Login

Se trata de una variación de XRSF en la que el atacante abre una sesión en una cuenta diferente a la de la víctima y hace que esta opere sin percibir que no es la suya.

### Prevención de CSRF

Exiten dos tipos de defensas:

- Comprobar las cabeceras HTTP: La cabecera Origin incluye el nombre del dominio origen, la cabecera Referer apunta a la página de la que proviene el usuario y la cabecera Host establece el navegador con el nombre de dominio al que se envía una petición (puede ser modificada por un proxy).
- Añadir un token a las peticiones (CRSF Token): Un token único por sesión de valor aleatorio generado por un algoritmo criptográfico que se compara con el de la petición y en caso de no coincidencia, aborta la solicitud. 
- Otra opción al token es usar Double Submit Cookie: el servidor envía una cookie adicional con el token y espera recibir el token en la cookie y por otro medio como pueda ser un POST para compararlos.
- La política de mismo origen puede usarse para añadir en servidores con peticiones AJAX una cabecera personalizada y comprobar que las peticiones la incluyen.
- Cookies Samesite.
- Requerir información extra antes de realizar acciones importantes (Doble autenticación, CaptCha, móvil).

## Exposición de datos sensibles

Se trata de una vulnerabilidad con un amplio espectro de ataques, cualquier tipo de captura de información sin cifrar mientras esta transita por la red.

Vulnerabilidades explotadas: Información a través de comunicaciones sin cifrar, Algoritmos de encriptación débiles e Información expuesta por la aplicación como mensajes de error.

Información sensible expuesta: Trazas de errores, librerías, Sistema operativo, Sistema de ficheros, Código fuente.

### Ataque de intermediario

En un MITM el atacante es capaz de interferir en las comunicaciones entre cliente y servidor escuchando los mensajes del canal de comunicación e inyectando mensajes modificados.

Métodos de secuestro: Sniffing, SideJacking y EvilTwin.

## Control de acceso

Las directivas de control de acceso tienen como misión garantizar que los usuarios solo puedan acceder a aquellas funcionalidades a las que tienen autorización. Debe seguir el principio de menor privilegio o POLP, que consiste en limitar los permisos a los mínimos imprescindibles.

Cuando el control de acceso no existe un atacante podría acceder a zonas de la aplicación a las que no debería. Otro problema es si los roles de usuario se encuentran en una cookie o un token JWT y estos no están validados, en este caso el atacante podría realizar modificaciones en los datos y los roles.

#### Prevención

Por defecto la política debe ser la denegación de acceso, los controles de acceso deben implementarse en el servidor, se debe imponer la propiedad de "dueño" para que un usuario solo acceda a "sus registros" y se deberían incluir las pruebas de control de acceso como un elemento más.

### Atravesar directorios

Es una vulnerabilidad que permite a un atacante acceder a ficheros y directorios que no debería, comumente se utiliza a través de concatenación de cadenas y el uso de "../". Depende de como el servicio acceda al contenido del fichero.

Para evitarlo se deberían validar rutas y caracteres codificados, además de utilizar listas de rutas válidas.

### Redirecciones

Una redirección se produce cuando el servidor en la respuesta incluye un código 3XX y una cabecera location con la URL, es incontrolada cuando la redirección es un parámetro de entrada de la aplicación y la redirección es a una URL sin validar.

Se puede usar el parámetro "redir" para redireccionar de forma maliciosa a una víctima a través del sistema de autenticación de una aplicación web real.

Los forwards son similares a las redirecciones.

Para evitarlas: Evitar redirecciones, Validar URLs, no utilizar un parámetro sino una clave interna, utilizar una página intermedia que necesite autenticación.

## Configuración de seguridad incorrecta

Se considera configuración de seguridad incorrecta los siguientes elementos:

- Funcionalidades innecesarias habilitadas.
- Cuentas o páginas de error por defecto.
- Permitir llamadas desde métodos HTTP no controlados.
- Limitar el número de sesiones.
- Cerrar sesión por inactividad o bloquear tras un tiempo de uso.
- Limitar el número de registros de una consulta.
- Separar aplicaciones de usuario y gestión.

## Log y monitorización insuficiente

El registro de eventos en el log se utiliza para reproducir de forma fiel la causa de un error en una aplicación, por ello es necesario almacenar todos los pasos para permitir la detección y corrección del problema.

Deberían mantenerse en los registros de log los eventos relacionados con el inicio de sesión, con el control de acceso y las transacciones relevantes.

También es importante mantener una monitorización de recursos tanto físicos como lógicos en todo momento.

## Vulnerabilidades en las librerías de terceros

Es muy frecuente el uso de librerías de terceros para implementar funcionalidades que son comunes y repetibles en aplicaciones, por ello es necesario revisar de forma periódica las vulnerabilidades de estas librerías.

# Ciclos de desarrollo de software seguro

Para minimizar que se produzcan vulnerabilidades en el código se deben abordar desde las primeras fases del ciclo de desarrollo todos los aspectos relacionados con la seguridad.

### Metodología SDL

Secure Development Lifecycle es un proceso de desarrollo seguro de Microsoft. Define una fase previa al inicio del proyecto dedicada a formación y aprendicaje, una serie de tareas para las fases de desarrollo tradicionales y contramedidas cuando se produce alguna incidencia.

Existe una versión ágil que define los elementos que deben ejecutarse en cada sprint o iteración, los elementos que se deberían ejecutar periódicamente y aquellos que deberían ejecutarse una vez durante el desarrollo del proyecto.

![SDL](./images/SDL.png)

### Formación

Inicialmente debería impartirse formación específica en seguridad a todos los miembros del equipo, esta fonrmación debería ser continuada y periódica en el tiempo.

Los aspectos más susceptibles de formación son:

- Principios de diseño seguro.
- Modelado de amenazas.
- Codificación segura.
- Pruebas.
- Privacidad en datos confidenciales.

#### Análisis

Definición de los requisitos de seguridad, los umbrales de calidad que se espera obtener de la aplicación, modelado de casos de uso relacionados con la seguridad y evaluación de riesgos.

#### Diseño

Establecimiento de los requerimientos de diseño, Análisis de las superficies de ataque (puntos de ataque), Definición de las restricciones de acceso y modelado de amenaza.

#### Implementación

Se define un documento de buenas práctcias de implementación relacionado con aspectos de seguridad, se determina qué herramientas se utilizarán para analizar el código y ejecución de análisis estáticos periódicos con herramientas SAST.

### Herramientas SAST

Las herramientas SAST están diseñadas para analizar el código fuente o compilado con el objetivo de encontrar problemas de seguridad. Son útiles para detectar problemas como inyección de SQL o desbordamiento de buffer, indican las líneas exactas y se integran con los IDEs.

Su principal inconveniente es que no son capaces de detectar muchos tipos de vulnerabilidades y detectan un alto número de falsos positivos.

La herramienta SonarQube es una herramienta desarrollada para java e integrada con Maven que se utiliza para localizar problemas de código en general y que permite desarrollar políticas de calidad del código fuente.

Find Security Bug es un proyecto de software libre que permite encontrar vulnerabilidades en aplicaciones Java, se integra con SonarQube, Maven, etc. Los patrones de bugs que localiza los referencia con CWE y OWASP Top-10.

#### Pruebas

Durante la fase de pruebas y verificación se lleva a cabo:

- Revisión del código por otros miembros.
- Pruebas de caja negra.
- Análisis dinámico y fuzz testing utilizando herramientas de Dynamic Application Security Testing.
- Reevaluación de las superficies de ataque.

#### Revisión del código

Proceso de auditoría del código fuente, se aplica a todo el código general y no solo a las funcionalidades relacionadas con la seguridad, se lleva a cabo por otros miembros del equipo de desarrollo.

### Herramientas DAST

Son programas qeu realizan pruebas automáticas de caja negra sobre una aplicación. 

Simulan las acciones de un atacante, se ejecuta sobre cualquier lenguaje y proporcionan informes bastante detallados.

#### Pentesting

Tests de penetración manuales sobre el software simulando los ataques de una hacker. Pueden ser de caja blanca (info sobre la implementación) o de caja negra (sin información).

#### Release

Cuando el software está preparado para poner en funcionamiento se debe hacer una revisión final y elaborar un plan de contingencia.

# Mecanismos de autenticación, autorización y control de acceso

### Autenticación

Muchas funcionalidades que expone el servicio requieren que el usuario de la aplicación cliente se autentique, normalmente un punto de acceso.

### Autorización

El punto de acceso de autenticación podría devolver un token que autoriza a esa aplicación cliente a hacer peticiones al servicio en nombre del usuario. Se enviará ese token como parte de cada petición.

### Control de acceso

Comprobación que las peticiones se pueden ejecutar con el token de acceso. Es necesario validar el token de acceso y validar que ese usuario tiene permitido hacer esa petición.

## Autenticación en HTTP

Existen cabeceras estándares Authorization (petición) y WWW-Authenticate (respuesta) que se utilizan para autenticación y/o autorización.

### Basic

Cuando el servicio recibe la petición solo tiene que decodificar la cadena que sigue a Basic para obtener username/password (en claro, necesario HTTPS).

#### Digest

Digest define un esquema más complejo que permite no enviar la contraseña en cada petición. No es muy usado por ineficiencia.

## JSON Web Token



### Sesión web 



### JWT: Formato

Formato en JSON que contiene:

- Cabecera: Tipo de token y algoritmo de firma.
- Cuerpo: Claims sobre una entidad.
- Firma: Algoritmo de firma y resultado codificado.

#### base64url

Como la cabecera y el cuerpo pueden contener caracteres no ASCII y los algoritmos de firma generan datos binarios, se utiliza base64url que es base64 sustitullendo "+/=".

#### Cuerpo

Tipos de campos (claims) en el objeto JSON:

- Registrados: Estandarizados.
- Públicos: Cualquiera puede definirlos, hay roles definidos y el resto URIs.
- Privados: Cualquiera puede definirlos, contexto local.

#### Firma

Un JWT se puede firmar de forma simétrica o asimétrica. Con un algoritmo simétrico la "firma" es un MAC, garantiza integridad y autenticidad. Con un algoritmo asimétrico es una firma digital, adicionalmente garantiza no repudio.

### Algoritmos de firma

- Algoritmos simétricos: HMAC con distintos hash, Generación de firma, verificación de la firma.
- Algoritmos asimétricos: RSASSA con distintas funciones hash, variantes de ECDSA con distintas funciones hash y verificación de la firma con la pk o sk.

#### JWT cifrados

Si los datos del JWT son confidenciales los tokens se deben cifrar, el formato son 5 partes separadas por "." en base64url.

### Ejemplo

En la práctica el usuario envía user/passwd y si es correcto recupera sus roles, genera la cabecera, el cuerpo, los codifica y firma el "token de acceso".

Cuando se requiere autorización se envía una cabecera Authorization que contiene "Bearer" y el token de acceso.

EL token se guarda en memoria en una aplicación nativa y en la sesión web en una aplicación web.

## OAuth

OAuth es un estándar de autorización que permite a las aplicaciones cliente obtener acceso limitado a recursos protegidos en nombre de un usuario sin compartir su contraseña. Tras autorizar al cliente en el servicio de autorización se recibe un código que se intercambia por un token de acceso que permite obtener los datos del servidor de recursos.

#### Endpoints del servidor de autenticación

- Authorization (HTML): Formulario.
- Token (REST/JSON): Token de acceso.
- Introspection (REST/JSON): Verificación de tokens.

#### Registro de aplicaciones cliente

Usando las herramientas administrativas de la implementación de OAuth se debe registrar cada aplicación cliente.

#### Clientes confidenciales y públicos

- Confidenciales: Pueden guardar de forma segura el client_secret.
- Públicos: No pueden y no lo generan.

### Flujos

Ejemplo larguísimo.

### PKCE

¿?

### Aplicaciones y servicios corporativos ¿?

- Desktop: La primera vez que un usuario accede a una aplicación usará el flujo authorization code para obtener un token de acceso para el backend, redigiendo al usuaro al formulario de autenticación. Tras la autenticación satisfactoria el servidor de autorización devolverá la cookie en la respuesta.
- Móvil: Igual que desktop pero el formulario de autenticación en una app nativa se abrirá en un in-app browser tab.
- Formulario de autenticación: No tiene sentido que un usuario tenga que autorizar a una aplicación de la empresa a hacer uso de un servicio de la empresa.
- Acceso a la información del usuario: No existe un mecanismo estándar que permita recuperar información sobre el usuario del propietario del token de acceso.

## OpenID Connect

OIDC es un protocolo de autenticación y autorización construido por encima de OAuth complementándolo. Añade un nuevo tipo de token (id_token), estandariza la información acerca de un usuario, añade endpoints y añade el flujo hybrid.

El id_token es un token en formato JWT que contiene info sobre el usuario, en el flujo authorization code la respuesta al POST incluye el id_token.

### Claims y scopes

La información se modela como claims JWT, con independencia del flujo que se use se utilizan una serie de claims.

La petición de autenticación/autorización en los flujos OAuth incluye el parámetro scope que especifica los permisos que solicita la aplicación cliente (scope=read+write separados por blancos).

#### Autenticación y autorización



## SAML

Es un protocolo de autenticación y autorización que precede a OIDC, con un diseño complejo y antiguo basado en XML.

La mayor parte de los IdPs proporcionan una implementación de SAML además de OAuth/OIDC. Contempla varios escenarios de uso "perfiles", el perfil principal es "Web Browser SSO" y el soporte de los IdPs suele ir muy ligado al uso de LDAP.

#### Aplicaciones nativas

SAML se diseñó antes de la aparición de los dispositivos móviles actuales, no es apto para conseguir SSO en aplicaciones nativas.

## Kerberos y SPNEGO

### Kerberos

Es un protocolo de autenticación y autorización. Usa un protocolo complejo de criptografía simétrica entre cliente y servicio, el usuario se autentica en su máquina (usualmente user/passwd) y las aplicaciones que arrancan pueden solicitar tickets para los servicios que usen.

### SPENEGO

Se usa para utilizar Kerberos en aplicaciones web corporativas. Simple and Protected GSSAPI Negotiation Mechanism es un protocolo para que un cliente y servicio y negocien un sistema de seguridad que ambos soporten.

Uno de los usos más habituales es el equema Negotiate de las cabeceras HTTP Authorization y WWW-Authenticate que se usa para autenticar un navegador con una aplicación web usando Kerberos como esquema de auth y autor.

## Control de Acceso

### Control de acceso basado en Roles

Ek RBAC se basa en restringir la ejecución de una operación a un usuario según los roles que tenga. La aplicación cliente envía junto a la petición algún tipo de token, que es validado por el servicio para ejecutarse.

### Control de acceso basado en atributos

#### Motivación

Con RBAC cada operación que ejecuta el ususario está condicionada por la posesión de un rol o un conjunto de roles, cuando se da de alta un usuario es necesario otorgarle roles según los servicios que vaya a usar.

En entornos con muchos usuarios y mucha variedad de permisos esto se vuelve una tarea árdua.

#### ABAC

En el modelo ABAC se protege la ejecución de una operación con una política en función de los atributos del sujeto, el recurso y el entorno. Sujetos, recursos y entorno tienen atributos (nombre/valor).

Las políticas de control de acceso no están ancladas a las aplicaciones y servicios, pueden cambiar sin tener que actualizar/cambiar las mismas.

#### XACML

Extensible Access Control Markup Language es un estándar de OASIS que define:

- Lenguaje XML para definición de políticas.
- Arquitectura de control de acceso.
- Formato de peticiones/respuestas del PEP al PDP.
- A sus implementaciones (WS02 IS, OpenAM, etc.) también se les llama herramientas de Acces Management.
- Estas herramientas muchas veces tienen capacidades de SSO, identidad y autorización (Identity and Access Management).