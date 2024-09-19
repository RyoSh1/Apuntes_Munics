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
- SQL(7)