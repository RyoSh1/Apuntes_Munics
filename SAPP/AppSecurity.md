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



## Inyección XML y XPath