# Gestión de la Seguridad de la Información

## Tema 1: Introducción

### Fundamentos

- Ciberseguridad : Disciplina basada en computadores que incluye tecnología, personas, información y procesos para asegurar operaciones en un contexto con adversarios.
- Seguridad de la información : Se encarga de la información sin tener en cuenta el formato (papel, digital, intelectual, etc.). Se trata de un contexto muy importante por su relevancia económica, técnica y socialmente, para empresas, govierno o formación.

Conceptos de la seguridad de la información:
- Identificar: Usar el conocimiento sobre la organización para minimizar el riesgo.
- Proteger: Diseñar controles para limitar el impacto de los posibles incidentes.
- Detectar: Implementar procesos para detectar eventos de ciberseguridad.
- Respuesta: Proceder con las acciones necesarias ante incidentes de seguridad.
- Recuperación: Planear ser resilientes y ser capaces de recuperar servicios comprometidos.

El objetivo de la seguridad de la información es minimizar la suma de dos costes: El coste causado por incidentes y el coste de los controles de seguridad. Por ello es necesario entender los riesgos de la información, identificar mejoras, situar recursos adecuadamente y cumplir con los requisitos.

#### GRC: Governanza, Riesgo y Cumplimiento

- Governanza es responsabilidad del consejo de administración y de la alta dirección.
- La gestión del riesgo es la coordinación de actividades que dirigen y controlan la empresa en el contexto del riesgo.
- Cumplimiento es el acto de mostrar adherencia a los requisitos definidos por leyes y regulaciones.

### Principales organizaciones

- INCIBE: Foco en personas y empresas privadas.
- CCN: Foco en el sector público.
- OSI (Oficina de Seguridad del Internauta): Problemas relacionados con operaciones en internet.
- ENISA (European Network and Information Security Agency): Busca garantizar un alto nivel de ciberseguridad en Europa, funciona como un cuerpo de certificación y busca la cooperación de la UE en respuesta a incidentes. CSIRT.
- NIST (National Institute of Standars and Technology): Guías varias en aspectos de ciberseguridad.
- ISO.
- ISACA: Establece y desarrolla guías y controles para la governanza de la información, el control, seguridad y auditorías profesionales. Crea el COBIT framework, similar a ITIL y muy usado en Estados Unidos.

#### Confidencialidad

Proteger la información de ser revelada a entidades no autorizadas.

La confidencialidad debe cubrir la información en guardado, procesado y en tránsito. Explicación inutil de personal y empresa.

#### Integridad

Proteger la información de ser modificada por entidades no autorizadas.

Integridad de datos es la propiedad de que la información no ha sido alterada de una manera no autorizada, la integridad de un sistema es la cualidad que determina si un sistema funciona como es debido libre de modificaciones no autorizadas.

#### Disponibilidad

La capacidad de acceder a la información para entidades autorizadas cuando sea necesario.

Debe cubrir dos aspectos: El posible borrado o cifrado de datos por parte no autorizada y el caso de denegaciones de servicio que hagan la información no accesible.

#### Otras definiciones

- Autenticidad: Una entidad es quien dice ser.
- No Repudio: Habilidad de probar que un hecho o acción ha sucedido.
- Fiabilidad: Comportamiento y resultado consistente.
- Responsabilidad (Accountability): Objetivo de seguridad que genera el requisito de trazabilidad de las acciones de una entidad.
- Garantía (Assurance):  Medidas que protegen y defienden la información y los sistemas de información garantizando su disponibilidad, integridad, autenticación, confidencialidad y no repudio.

#### Preguntas del Tema 1

En una compañía un trabajador copia ficheros confidenciales sin autorización a un USB. ¿Que objetivos de seguridad son violados?

A. Confidencialidad

Un usuario comparte su contraseña con un compañero para que acceda a unos ficheros en su ausencia.¿Que objetivos de seguridad son violados?

D. Autenticidad

Un hacker hace un DoS sobre un servidor web para hacerlo innaccesible. ¿Que objetivos de seguridad son violados?

C. Disponibilidad

Un empleado borra accidentalmente una base de datos crítica en la empresa. ¿Que objetivos de seguridad son violados?

C. Disponibilidad y presumiblemente D. Autenticidad

En una compañía se detecta que un usuario accede a una base de datos con tus credenciales, pero no se sabe si ha hecho cambios. ¿Que objetivos de seguridad son violados?

A. Confidencialidad, pero supongo que Autenticidad e Integridad.

Durante una auditoría se descubre que los logs han sido manipulados para ocultar actividad de unos usuarios. ¿Que objetivos de seguridad son violados?

B. Integridad. Pero también Confidencialidad.

Una empresa sufre ataque ransomware dejando todos los datos cifrados e inaccesibles. ¿Que objetivos de seguridad son violados?

C. Disponibilidad.

Una empresa tiene datos de empleados, clientes y productos. Cuales deben ser protegidos?

D. Todos.

#### Glosario

Expandir si es necesario.

## Tema 2: Análisis de Riesgos

### Introducción

El riesgo depende del impacto y su probabilidad (impacto por probabilidad). Para determinar estos valores es necesario comparar valores de distintas dimensiones y decidir si el daño producido en una dimensión es mayor al daño en otra (Valores relativos).

- Evaluación cuantitativa: Requieren mayor esfuerzo, pero permiten la suma clara de valores.
- Evaluación semi-cualitativa: Permiten establecer un orden relativo de cada activo mediante estimaciones de magnitud del riesgo, pero no permiten comparar valores.

La probabilidad se valora entre 0 y 5 según la posible ocurrencia en los próximos 12 meses (0%, 5, 10, 25, 50 y 100).

Factores de amenaza de OWASP:
- Habilidad: Nivel técnico del grupo de amenazas. Sin habilidades (1), Algunas habilidades (3), Usuario avanzado (5), Habilidades de programación y redes (6).
- Motivación: Que motivación tienen para encontrar y explotar la vulnerabilidad. Baja o ninguna (1), Posible recompensa (4), Alta recompensa (9)
- Oportunidad: Que recursos hacen falta para encontrar y aprovechar la vulnerabilidad. Acceso completo o muy costoso (0), Acceso especial o recursos (4), cierto acceso (7), Ni acceso ni recursos (9)
- Tamaño: Tamaño del grupo de agentes de amenazas. Desarrolladores (2), Administradores TI (2), Usuarios de internet (4), Socios (5), Usuarios autenticados (6), Usuarios anónimos de internet (9).

Factores de vulnerabilidad OWASP:
- Facilidad de descubrimiento.
- Facilidad de explotación.
- Conocimiento.
- Detección.

Los índices de probabilidad si se unen.

CVE es un estandar que identifica y documenta las vulnerabilidades conocidas de software y firmware, una vulnerabilidad explotable es aquella para la que existe un exploit, dichas vulnerabilidades pueden ser buscadas automaticamente.

El impacto se valora según el porcentaje del presupuesto de la organización a la que afecta, con valores del 1 al 5 (0,5%, 1, 2, 6 y más que 6)

Factores de impacto técnico de OWASP:
- Pérdida de confidencialidad.
- Pérdida de integridad.
- Pérdida de disponibilidad.

Factores de impacto empresarial OWASP:
- Daño financiero.
- Daño reputacional.
- No cumplimiento.
- Violación de la privacidad.

Los índices de impacto no se suman.

Formas de tratar el riesgo: Evitar el riesgo (cancelando la actividad por ejemplo), Reducir el riesgo (minimizar), transferir el riesgo, Aceptar el riesgo.

#### Tipos de controles

A nivel operacional:
- Controles físicos: Mitigaciones del mundo real.
- Controles de procedimiento: Políticas y procesos que controlan el comportamiento del personal.
- Controles técnicos: Controles tradicionales como firewall.

A nivel temporal:
- Controles preventivos: Protección directa mediante bloqueo de amenazas o vulnerabilidades.
- Controles directivos: Control de las acciones a tomar para proteger información.
- Controles detectivos: Detección y reporte de eventos no deseados
- Controles correctivos: En respuesta y arreglo de incidentes de seguridad.

### MAGERIT

Metodología de Análisis y Gestión de Riesgos para Tecnologías de la Información, preparado por el Consejo Superior de Administración Electrónica, provee de unos métodos que no dejan espacio a la improvisación para cumplir el cometido.

#### Objetivos

El objetivo directo de MAGERIT es dar conciencia de la existencia de riesgos y la necesidad de tratarlos, ofrecer unos métodos sistemáticos para analizar estos riesgos y ayudar en la descripción y planificación de medidas de control. Indirectamente busca preparar la organización para los procesos de evaluación, auditoría y certificación.

#### Libros

1. El método.
2. Catálogo de elementos: Tipos de activos, Dimensiones, Criterios, amenazas y salvaguardias.
3. Guía de técnicas: Compilación de técnicas para aplicar los métodos.

#### Dimensiones de seguridad

- Confidencialidad, Integridad y Disponibilidad (canónicas).
- Autenticidad: Una entidad es quien dice ser o su origen es garantizado. Como contras tenemos la manipulación de origen y el spoofing.
- Responsabilidad: Garatía de que siempre se puede determinar quién hizo qué y cuándo lo hizo.

#### Método de análisis de riesgos

1. Determinar los activos importante en la organización, sus relaciones y su valor.
2. Determinar las amenazas a las que los activos están expuestos.
3. Determinar las salvaguardas disponibles y su efectividad.
4. Estimar el impacto, definido como el daño al activo si aparece la amenaza.
5. Estimar el riesgo, definido como el impacto por la probabilidad.

#### Paso 1: Activos

Los activos principales son de dos tipos especiales: La información manipulada y los servicios provistos.

Los activos subordinados son: El equipamiento de ordenador (Software, Hardware, Comunicaciones, Media), el entorno (Equipamiento y muebles), los servicios de terceras partes, la localización física y los operarios.

Los activos se pueden agrupar o individualizar según los requisitos u objetivos de seguridad.

#### Paso 1.2: Dependencias

Los activos se organizan en árboles o grafos de dependencias, los activos de las capas superiores dependen de aquellos en las capas inferiores, es decir, los de la capa superior dependen de la inferior y los de la inferior tienen un impacto en la superior.

Modelado de dependencias: La información y los servicios deben colocarse en lo más alto, normalmente la información sobre los servicios(aunque depende del contexto). La aplicación depende de los datos que transporta.

Establecer dependencias es una tarea delicada.

#### Paso 1.3: Valoración de los activos

No confundir valor con coste, valor es la necesidad de protección de un activo, a más valor mayor protección debe tener. El valor principal suele estar en la información que maneja el sistema y en los servicios que presta, el resto pueden ir sin valor porque lo más importante es que soportan los activos principales.

- Replacement cost: Coste de repuesto de elementos defectuosos.
- Valor de personal: El valor del periodo de entrenamiento incrementa el coste de repuesto de un trabajador.
- Valor de datos personales: Debido a su control por parte de las leyes, los datos personales necesitan una serie de medidas de seguridad especiales. Es necesario clasificarlos con un nivel apropiado.
- Valores intangibles: Elementos con valor para la organización como la reputación, el conocimiento, independencia de criterio, privacidad personal o salud del personal.

Para valorar los activos es necesario disponer de distintos puntos de vista para lograr una vista general de cada activo, además de disponer de la persona directamente responsable de cada uno.

#### Paso 2: Amenazas

Elementos que causan un incidente en la organización, provocando daño en una propiedad o pérdidas intangibles en los activos.

- Catálogo de amenazas: Según su naturaleza, medioambiental, fallo de aplicaciones, accidentes humanos o daño deliberado.
- Una amenaza no afecta a todas las dimensiones de un activo, hay que valorar dos aspectos: Degradación (cantidad de daño producido) y probabilidad de que ocurra.

#### Impacto

El impacto es la pérdida de valor de un activo producida por un incidente. Factores a considerar: Coste de repuesto, coste de recuperación del valor, pérdida de ganancias, pérdida de operabilidad, sanciones provocadas, daño a otros activos, lesión de personal y daño medioambiental.

Valor de la interrupción del servicio: La disponibilidad no se valora con un valor simple, es necesario usar una estructura compleja de valoración.

#### Riesgo

El riesgo es la medida del daño probable que puede sufrir el sistema, impacto por su probabilidad de ocurrencia.

- Riesgo acumulado:
- Riesgo desviado:
DUDAS

#### Paso 3: Salvaguardas

Las salvaguardas o controles son procedimientos o mecanismos que reducen el riesgo, siendo seguridad, políticas de empresa u otras medidas.

Para la selección de controles, se debe argumentar la razón por la que no es necesario tomar cada control, sea porque no aplica o porque no es proporcional al riesgo (injustificada). Esto conforma un SOA.

Las salvaguardas pueden reducir la probabilidad de amenazas o limitar el impacto. Existen los siguientes tipos:  Prevención (PR), Disuasión (DR), Eliminación(EL), Minimización del impacto (IM), Corrección (CR), Recuperación (RC), Monitorización (MN), Detección (DC), Concienciación (AW) y Adminstración (AD).

Las salvaguardas se valoran en un porcentaje de efectividad real entre 0% y 100%.

#### Paso 3: Riesgo restante

El impacto residual es aquel que se calcula una vez aplicadas las salvaguardas, también se calcula la degradación residual.

El apetito del riesgo es el valor de riesgo que la empresa está dispuesta o decide permitir, es un nivel de aceptación acordado por la gestión de la empresa.

Tratamiento de riesgo: Eliminación, Mitigación, Compartición (Riesgos cuantitativos o cualitativos) y aceptación.

Aquí hay unas gráficas sin mucho sentido de impacto x probabilidad y el riesgo.

#### Documentación

- Documentación intermedia:
- Documentación final:

#### Roles

Se definen los siguientes roles:
- Órganos de gobierno.
- Consejo ejecutivo.
- Dirección corporativa.
- En el ENS:
    - RINFO: Responsable de información.
    - RSERV: Responsable de servicio.
    - CISO: Chief Information Security Officer.
    - RSIS: Responsable del sistema.
    - ASS: Administradores de sistemas.

Tabla RACI: Los roles anteriores reciben una calificación de las siguientes.
- Responsible: Los que realizan el trabajo.
- Accountable: Los que revisan el trabajo.
- Consulted: Los consultados.
- Informed: A los que se les informa.

### ISO 27005

- Gestión de riesgos: Actividades coordinadas para dirigir y controlar una organización respecto al riesgo.
    - Valoración del riesgo: Identificación, análisis y evaluación.
    - Tratamiento de riesgo.
    - Comunicación y consulta del riesgo.
    - Monitorización y revisión del riesgo.

#### 1. Contexto

1. Propósito:
2. Criterios básicos:
3. Alcance y límites:
4. Organización operativa:

#### 2. Evaluación de riesgos

Realizar una evaluación de los riesgos cibernéticos a los que se enfrenta una empresa u organización. Se utilizan para identificar, analizar y priorizar los riesgos para las operaciones de la organización , los activos, las personas y otras organizaciones derivadas.

- Activo de información:
- Dueño del activo:
- Inventario de activos:

1. Identificación de activos:
2. Identificación de amenazas:
3. Identificación de vulnerabilidades:
4. Identificación de controles existentes:

#### 2.2 Análisis de riesgo

1. Análisis de riesgo:
2. Evaluación de las consecuencias:
3. Evaluación de la probabilidad del incidente:
4. Evaluación del riesgo:

El "Responsable del riesgo" es una persona o entidad con la responsabilidad y la autoridad para gestionar un riesgo.

#### 3. Tratamiento del riesgo

El proceso de elegir e implementar medidas para modificar el riesgo.
- Identificación de opciones.
- Desarrollo de un plan de acción.
- Implementación del plan de acción.
- Identificación de riesgos residuales.

#### 4. Comunicación del riesgo y consulta

Se trata de la actividad de manejar riesgos mediante el intercambio de información con el personal de toma de decisiones.

#### 5. Monitorización y revisión

Los riesgos no son estáticos, es necesario detectar cambios y mantener soporto mediante sisteams externos.

## Tema 3: ISMS

### SGSI

Un Sistema de Gestión de la Seguridad de la Información se encarga de prevenir o reducir el nivel de riesgo de seguridad de información mediante controles, preparación ante incidentes y soporte de la continuidad de negocio.

#### Familia ISO

- 27000: Vocabulario.
- 27001: Requisitos para implantar un SGSI certificable.
- 27002: Buenas prácticas de gestión de la seguridad y recomendaciones a controles que implantar.
- 27003: Implementación de SGSI.
- 27004: Métricas y técnicas de medida.
- 27005: Gestión de riesgos.
- 27006: Acreditación de entidades.
- 27007: Auditar SGSI según 27000.
- 27011: Telecomunicaciones.
- 27031: Continuidad de negocio.
- 27032: Ciberseguridad.
- 27033: Seguridad en redes.
- 27034: Seguridad en aplicaciones.
- 27035: Gestión de incidentes.
- 27036: Relaciones con proveedores.
- 27037: Identificación, recolección, consolidación y preservación de evidencias digitales.
- 27038: Redacción digital.
- 27039: Selección, despliegue y operativa de IDS/IPS
- 27040: Seguridad de medios de almacenamiento.
- 27041: Idoneidad y adecuación de métodos de investigación.
- 27042: Guía para analizar e interpretar evidencias digitales.
- 27043: Principios y procesos de investigación.
- 27044: SIEM.
- 27799: Interpretación y aplicación en el sector sanitario.

### ISO 27001

Norma creada por la Organización Internacional de Estandarización y la Comisión Electrotécnica Internacional que especifica los requistos para establecer, implementar, mantener y mejorar de forma continua un SGSI. Provee un modelo de como proceder con un SGSI, además es una norma certificable, lo que significa que demuestra a partes interesadas que la organización está comprometida con la seguridad de la información.

Algo más¿?

### Ciclo de Deming (PDCA)

Se divide en 4 etapas:
1. Planificar (establecer el SGSI): Establecer políticas, objetivos, procesos y procedimientos relevantes para gestionar el riesgo de acuerdo con las políticas generales de una organización. 
2. Hacer (implementar y operar el SGSI): Implementar y operar la política, los controles, los procesos y procedimientos del SGSI.
3. Comprobar (monitorizar y revisar el SGSI): Evaluar y medir el desempeño del proceso en relación con la política e informar de resultados.
4. Actuar (mantener y mejorar el SGSI): Tomar medidas correctivas y preventivas basados en las auditoriar y revisiones realizadas.

El Ciclo de Deming específico de la ISO 27001 se divide en los siguientes bloques:
1. Sección 1: Alcance; Sección 2: Referencias Normativas; 3: Términos y definiciones.
2. PLAN
    - 4: Contexto de la organización.
    - 5: Liderazgo.
    - 6: Planificación.
    - 7: Soporte.
3. DO
   - 8: Operación.
4. CHECK
    - 9: Evaluación de rendimiento.
5. ACT
    - 10: Mejoras y acciones correctivas.

#### Alcance

Se especifican los requisitos para establecer, implementar, mantener y mejorar un SGSI en el contexto de la organización; también incluye los rquisitos de evaluación y tratamiento de riesgos. Cuando la organización acepta la conformidad con el documento, los requistos no pueden excluirse.

#### Referencias de normativa y Términos y Definiciones

Lo que dice el título.

#### Contexto de la organización

Organización interna (estructura, flujos, etc.) y externa (mercado, clientes, regulaciones), necesidades y expectativas de las partes interesadas (empleados, accionistas, clientes, etc.), Alcance de la seguridad sobre las actividades y base de procesos del SGSI.

#### Liderazgo

La alta dirección debe comprometerse con respecto al SGSI, para ello establece lo siguiente:
- Política de Seguridad de la información: Documento disponible como información documentada dentro de la organización que sirve como consulta para partes interesadas, debe mostrar el compromiso con los requisitos y la mejora contínua del SGSI.
- Funciones, responsabilidades y autoridades: Se deben establecer la delegación de funciones y responsabilidades según los requisitos de la ISO.

#### Planificación

Se deben planear las acciones para abordar riesgos y oportunidades, definiendo cómo integrar e implementar dichas acciones en procesos del SGSI y evaluando su eficacia.

- Evaluación de riesgos: Definir y aplicar un proceso de evaluación de riesgos de SI que establezca y mantega criterios de riesgos (incluyendo aceptación del riesgo y evaluación), Asegurar la reproducibilidad de las evaluaciones con resultados válidos y consistentes, identificación de los riesgos y sus propietarios, analisis de riesgos considerando consecuencias y probabilidad de ocurrencia (nivel de riesgo) y evaluación de riesgos según su prioridad para el tratamiento.
- Tratamiento de riesgos: Definir y aplicar un proceso de tratamiento de riesgo para determinar los controles necesarios, comparar los controles determinados, producir el SOA, formular el RTP y obtener la aprobación del propietario del riesgo.

*Conceptos*
-Propietario del activo: Responsables de la protección de la confidencialidad, integridad y disponibilidad del activo, requieren comprensión de las amenazas potenciales, realizan la evaluación de riesgos, implementan controles y establecen procedimientos de recuperación y respuesta.
-Propietario del riesgo: Persona o grupo con conocimiento en gestión de riesgo, que se responsabiliza de asegurar la implementación efectiva de las actividades de gestión de riesgo.
- Ambos colaboran entre sí, pero los propietarios de riesgo se centran en el proceso de gestión de riesgo en su conjunto y los propietarios de activos tienen una responsabilidad más específica en proteger activos específicos.

Declaración de aplicabilidad (SoA): Es la relación entre la evaluación y tratamiento de riesgos y la aplicación del SGSI. Se trata de definir cuál de los 93 controles sugeridos a partir de la ISO 27001 se aplican y cuales no, de forma jusificada incluyendo aquellos que ya estén implementados.

Plan de Tratamiento de Riesgos (RTP): Documenta el método seleccionado para tratar cada riesgo, controles ya en marcha, controles adicionales propuestos (y su plazo de aplicación).

Se deben establecer los objetivos de seguridad de la información en funciones y niveles relevantes y también se deben planificar los cambios, cuando se realicen, deberán llevarse a cabo tal y como fueron planeados.

En resumen, la organización debe mostrar el plan que describa cómo va a lograr sus objetivos de seguridad de la información, definiendo: Lo que hay que hacer, los recursos que se requieren, quién será el responsable de cada acción, cronograma para cuándo se completará cada acción y cómo se evaluarán los resultados del plan junto a su adecuación.

#### Soporte

Se deben establecer los recursos necesarios para la implementación, mantenimiento y mejora del SGSI:
- Determinar las competencias necesarias y proporcionar recursos para obtenerla.
- Asegurar que la conciencia de la organización sobre la política de seguridad de la información.
- Determinar las necesidades de comunicación del SGSI.
- Incluir y mantener toda la documentación necesaria para la norma ISO 27001 y el propio SGSI.

#### Operación

- Implementación y control de los procesos necesarios para satisfacer los requisitos de la planificación.
- Evaluación de los riesgos en intervalos planificados.
- Implementación del RTP.

#### Evaluación de rendimiento

- Determinar qué monitorizar, cómo y quien debe evaluar los resultados.
- Realizar auditorías internas en intervalos planeados para proporcionar información sobre si el SGSI es conforme a los requisitos de la organización.
- Revisión por parte de la dirección.

#### Mejoras

Mejora contínua y aplicación de acciones correctivas en el caso de que se produzcan no conformidades.

#### Preguntas del Tema 3 Parte 1

La actividad de aprobar y asegurar los recursos necesarios es una responsabilidad de...



La necesiadd de que se asegure que en las sucesivas evaluaciones de riesgo se generen resultados consistentes, válidos y comparables ¿es?



¿Qué requiere la ISO 27001 para el control de la información documentada?



### ISO 27002

La ISO 27002 es la que proporciona una guía detallada práctica para la aplicación de los controles enunciados en la ISO 27001.

Los controles se dividen en: Controles organizativos (Políticas, gestión, inventario, clasificación, etiquetado...), controles sobre las personas (Personas individuales: Selección, formación, responsabilidad, etc.), Controles físicos (Perímetros de seguridad, instalaciones, monitorización, etc.), Controles tecnológicos (Acceso a la información, autenticación segura, malware, etc.)

### Esquema Nacional de Seguridad

El ENS pasa por 4 evoluciones: 
- En 2007 reconoce el derecho de los ciudadanos a relacionarse con las Administraciones Públicas por medios electrónicos y regula aspectos básicos de las tecnologías de la información.
- En 2010 busca determinar mediante principios básicos la política de seguridad ante los medios electrónicos.
- En 2015 aparece recodigo en términos similares (artículo 156)
- Mismo año es modificado en evolución del entorno regulatorio de la UE.

La estrategia nacional de ciberseguridad (diciembre 2013) tiene como objetivo la prevención, defensa, detección y respuesta ante ciberamenazas. Se estructura en 5 capítulos: Ciberespacio y su seguridad, Próposito y principales rectores en España, Objetivos, Líneas de actuación (incluye la implantación del ENS) y la ciberseguridad en el Sistema de Seguridad Nacional.

Viene recogido o guiado por las Guías STIC del CCN, destacando la 802 (Auditoría), 804 (implementación), 808 (Verificación del cumplimiento de las medidas) y 809 (Declaración y certificación de conformidad).

#### Objetivo

El objetivo del ENS es garantizar la confianza y la seguridad de los sistemas, los datos, las comunicaciones y los servicios electrónicos, y establece principios comunes para que las Administraciones Públicas actúen de forma coherente en materia de seguridad de la información.

#### Alcance

El ENS se aplica a todas las administraciones públicas (Estado, CCAA, Entidades locales y organismos públicos), así como a los ciudadanos en sus relaciones con ellas o las interacciones entre las mismas. Es de aplicación en sedes electrónicas, registros y sistemas de información utilizados para acceso ciudadano, ejercicio de derechos, cumplimiento de deberes y consulta de estado de procedimientos o información.

#### Plan de adecuación

El plan de adecuación debe contener:
- Política de seguridad de la información.
- Categorización de los sistemas.
- Análisis de riesgos.
- Declaración de aplicabilidad.
- Insuficiencias del sistema.
- Plan de mejora de seguridad.

#### Política de seguridad de la información.

El primer paso es la elaboración de la PSI, que deberá ser aprobada por el titular del órgano superior competente. Esta desarrollará los principios mínimos establecidos por el ENS.
1. Organización e implantación del proceso de seguridad.
2. Análisis y gestión de los riesgos.
3. Gestión de personal.
4. Profesionalidad.
5. Autorización y control de los accesos.
6. Protección de las instalaciones
7. Adquisición de productos.
8. Seguridad por defecto
9. Integridad y actualización del sistema
10. Protección de la información almacenada y en tránsito
11. Prevención ante otros sistemas de información interconectados
12. Registro de actividad
13. Incidentes de seguridad
14. Continuidad de la actividad
15. Mejora continua del proceso de seguridad

Roles del marco organizativo:
- Responsable de la Información: Establece los requisitos de seguridad de la información gestionada. Ocupa el cargo maś alto.
- Responsable del Servicio: Decide sobre los requisitos de seguridad del servicio, en especial la disponibilidad.
- Responsable de la Seguridad: Chief Information Security Officer (CISO). Gestiona la seguridad de la información y los servicios.
- Responsable del Sistema: Encargado de desarrollar, operar y mantener el sistema de información.
- Administradores de la Seguridad del Sistema: Se encarga de la parte técnica de la implementación, gestión y mantenimiento de medidas de seguridad a aplicar.

Para el desarrollo de la política y definición del marco normativo se deben seguir las guías 801 y 805.

#### Análisis de riesgos.

EL artículo 13 establece la necesidad de llevar a cabo un proceso de análisis y gestión de riesgos en base a una metodología reconocida internacionalmente. MAGERIT como metofología, Pilar como herramienta.

#### Categorización de los sistemas.

1. Identificación de los servicios y de la información.
2. Valoración de cada uno de los servicios e información en función del impacto, en función del impacto en las dimensiones de seguridad (D.A.I.C.T).

Pueden verse afectados en una o más dimensiones y cada dimensión se valorará en los niveles BAJO, MEDIO o ALTO. Siguiendo la guía 803.

- Nivel BAJO: Se utiliza cuando se produce un perjuicio limitado, como la reducción apreciable de la capacidad (sigue desempeñándose), un daño menor a los activos, incumplimiento de ley subsanable o perjuicios menores a individuos.
- Nivel MEDIO: Se utiliza cuando las consecuencias supongan un perjuicio grave, es decir la reducción significativa de la capacidad de la organización (sigue desempeñándose, pero afectada), un daño significativo a los activos, el inclumplimiento material de alguna ley o un perjuicio de dificil reparación sobre individuos.
- Nivel ALTO: Se utiliza cuando las consecuencias de un incidente suponga un perjuicio muy grave sobre las funciones de la organización (anulación), un daño grave o irreparable sobre los activos, inclumplimiento de alguna ley o perjuicio grave sobre los individuos afectados.

Los sistemas de información reciben una determinación de categoría (Básica, Media y Alta), según si alguna de las dimensiones alcanza el nivel bajo, medio o alto.

#### Declaración de aplicabilidad.

Se trata de una relación de las 75 medidas de seguridad (controles) indicando para cada una si debe aplicarse o no (justificado). Las medidas se seleccionan en base a la categoría del sistema y las dimensiones a las que afecta.

Pasos a seguir:
1. Identificar tipos de activos.
2. Determinar dimensiones relevantes.
3. Determinar niveles.
4. Determinar categoría.
5. Seleccionar las medidas apropiadas entre las contenidas en el Anexo 1.

La guía 825 relaciona la ISO 27001 y controles de la 27002 con el ENS.

#### Insuficiencias del sistema.

Evaluación del grado de cumplimiento de las medidas previstas para identificar los puntos a corregir o mejorar.

#### Plan de mejora de seguridad.

El último paso para la planificación de la adecuación al ENS es elaborar un plan de mejora que busca subsanar las insuficiencias detectadas, debe indicarse:
- Descripción de la acción.
- Responsable de ejecución.
- Responsable de supervisión.
- Plazos previstos.
- Coste estimado.

#### Otros

- Implantación del ENS: Siguiendo las guías 821 y 822.
- Auditoría del ENS : Se deben realizar auditorias cada 2 años o cuando cambie considerablemente el sistema, siguienod las guías 802 y 808. Son objeto de auditar los roles y funciones del sistema de información, análisis de riesgos con revisión y aprobación anual, medidas de seguridad y que existe un SGSI documentado y aprobado.
- Conformidad con el ENS: En el art. 41 se señala que las entidades públicas mostraran los distintivos de seguridad de los que son acreedores. La categoría básica proporcionará una Declaración de Conformidad generada por la entidad responsable y la categoría media o alta obtendrá una Certificación de Conformidad proporcionada en una Auditoría por una entidad acreditada.

## Tema 4: Evaluación, Auditoría y Certificación

Beneficios de la certificación:

- Cumplimiento:
- Certificación:
- Acreditación:

ENAC:

Para el ENS...

### ISO

#### Ciclo de certificación



#### Requisitos: Documentos y problemas



### ENS



#### Adecuación



#### CoCENS



#### µCeENS



### Auditoría



#### Tipos de auditorías

- Interna:
- Externa:
- Combinada:
- Unión:

#### Conceptos de auditoría



#### Principios de auditoría



#### Encuesta de alcance y preauditoría



#### Planificación y preparación



#### Trabajo de campo



#### Análisis



#### Reporting



#### Hallazgos



#### Cierre



#### Preparaciones en una auditoría



### ISO 19001: 6.5 Realización de actividades de auditoría in situ

#### Reunión inicial



#### Recolección de información



#### Generar los hallazgos



#### Preparar las conclusiones



#### Reunión de clausura



### ISO 19001: 6.6 Preparación, aprobación y distribución del informe de auditoría.



#### Preparación del reporte



#### Aprobación y distribución



#### Completar la auditoría



#### Seguimiento



## Tema 5: Gestión de la Continuidad de Negocio



#### Conceptos básicos

- Recovery Point Objetive (RTO):
- Recovery Time Objetive (RTO):
- Work Recuperation Time (WRT):
- Maximum Tolerable Downtime (MTD):
- Disrupción:
- Desastre:
- Continuidad de negocio:
- Gestión de la continuidad de negocio (BCM):
- Sistema de gestión de la continuidad de negocio (BCMS):
- Plan de continuidad de negocio (BCP):
- Plan de recuperación de desastres (DRP):

### Planificación de la continuidad de negocio

### Backup, Recuperación y Virtualización

### Notas extra

## Tema 6: Gestión de Incidentes

### Conceptos

### Nist-ISO

### Linea Temporal

### SIEM (Seguridad de la Información y Gestión de Eventos)

## Revisión Prácticas

### Práctica 1

### Práctica 2

### Práctica 3

## Preguntas Foro

- ¿Qué representan las siglas CNA en el contexto del CVE?
    1. CVE Naming Association
    2. CVE Naming Administrator
    3. **CVE Numbering Authority**
    4. Cybersecurity Name Association

- ¿Cuál de las siguientes afirmaciones describe correctamente el contenido de la ficha técnica asociada a un identificador CVE?
    1. Proporciona un resumen técnico profundo y detallado sobre la explotación de la vulnerabilidad e incluye información sobre su severidad.
    2. **Ofrece una descripción técnica resumida, su identificador único, puntuación de severidad  y datos específicos como fecha o productos afectados.**
    3. Presenta únicamente la información del fabricante, la puntuación CVSS y las fechas de publicación del CVE.
    4. Solo contiene datos sobre la interacción del usuario y el impacto en la disponibilidad del sistema afectado.

- ¿ De que tratan los niveles presentes en la web IO Wargame ?

    1. Pivoting de máquinas.
    2. **Explotación Binaria.**
    3. Vulnerabilidades web.
    4. Cuestionarios de ciberseguridad.



- ¿Quién es el  fundador de THN?
    1. Brian Krebs
    2. **Mohit Kumar**
    3. Mikko Hyppönen
    4. Kevin Mitnick

- ¿Qué tipo de contenido se publica en la sección Vulnerabilities de The Hacker News?
    1.  Opiniones de expertos y casos de estudio
    2.  Alertas de fallos críticos, CVEs y enlaces a parches 
    3.  **Análisis de campañas de ransomware y APTs**
    4.  Noticias de regulaciones de privacidad

- ¿Por qué es útil The Hacker News para un gestor de seguridad?
    1.  Porque publica desafios de hacking
    2.  Porque traduce noticias a varios idiomas
    3.  **Porque permite enterarse rápido de amenazas y priorizar acciones.**
    4.  Porque ofrece cursos certificados



- En la fase de "Operations", ¿cuál es uno de los enfoques principales?
    1.  Escribir código nuevo
    2.  **Desplegar firewalls y monitorear comportamiento en producción.**
    3.  Hacer pruebas unitarias
    4.  Optimizar el SEO de la aplicación

- La fase de "Implementation" se enfoca principalmente en:
    1.  Verificar cumplimiento legal de la aplicación
    2.  Documentar la interfaz gráfica
    3.  **Aplicar prácticas de codificación segura y gestionar dependencias.**
    4.  Proteger la infraestructura con firewalls

- OWASP ZAP es una herramienta que puede ayudarnos, principalmente, en la fase de:
    1.  Operations
    2.  Security Gap Analysis
    3.  Implementation
    4.  **Verification**



- ¿Cuál de los siguientes riesgos NO se menciona explícitamente en la guía de INCIBE como amenaza para la identidad digital de una empresa?
    1.  Suplantación de identidad en redes sociales.
    2.  Registro abusivo de nombre de dominio (cybersquatting).
    3.  Fallos de cifrado en bases de datos externas.
    4.  Denegación de servicio distribuida (DDoS).

- Entre las recomendaciones preventivas que indica la guía, ¿cuál de las siguientes es correcta?
    1.  No interactuar con usuarios en redes sociales para evitar riesgos reputacionales.
    2.  Establecer políticas internas de uso de redes sociales para empleados.
    3.  Evitar registrar dominios relacionados con la marca para reducir visibilidad.
    4.  No utilizar doble factor de autenticación para simplificar accesos.

- Cuando se detecta un perfil falso que suplanta a la empresa en redes sociales, ¿cuál sería la respuesta más adecuada según la guía de INCIBE?
    1.  Ignorar el perfil para que pierda relevancia con el tiempo.
    2.  Publicar un enlace del perfil en la web corporativa alertando a clientes.
    3.  Contactar con la plataforma para solicitar la retirada del perfil.
    4.  Pedir a los empleados que lo reporten desde sus cuentas personales sin coordinación.



- ¿Cuál es la principal tendencia observada en el ranking de amenazas principales entre el ETL 2023 y el ETL 2024?
    1. El Ransomware se consolidó como la amenaza N.º 1 en 2024, superando el 50% de los incidentes globales.
    2. El Malware se convirtió en una de las tres principales amenazas en 2024, desplazando a las Amenazas contra Datos.
    3. **El DDoS/RDoS experimentó un aumento drástico, pasando del 21.4% de los incidentes en 2023 al 41.1% en 2024, y se consolidó como la amenaza N.º 1.**
    4. Las Amenazas contra Datos y la Ingeniería Social redujeron su volumen de incidentes en más del 50% en 2024


- ¿Qué tendencia táctica de gran sofisticación, visible en el ataque a XZ Utils, se ha destacado en el informe de 2024? 
    1. La disminución de los ataques de phishing asistidos por IA.
    2. **El aumento del uso de ingeniería social en ataques a la cadena de suministro (supply chain).**
    3. El abandono de las vulnerabilidades críticas a favor de las de severidad baja.
    4. La dependencia exclusiva de deepfakes para los ataques de extorsión.


- Según los informes de ENISA, ¿cuál fue la principal consecuencia de la inestabilidad geopolítica (conflictos, elecciones) en el panorama de amenazas del 2024?
    1. El Beneficio Financiero fue reemplazado por el Espionaje como única motivación.
    2. El Malware se multiplicó por diez, siendo la principal herramienta de espionaje.
    3. **La aceleración del DDoS/RDoS, subiendo al puesto N.º 1 de amenazas, impulsado por el hacktivismo ideológico.**
    4. La Administración Pública dejó de ser un objetivo para concentrarse en Banca y Finanzas.



- ¿Cuál es la principal diferencia entre IT y OT según la presentación?
    1.  IT prioriza la disponibilidad y OT la confidencialidad.
    2.  IT se centra en la seguridad física y OT en los datos.
    3.  IT prioriza la confidencialidad e integridad, mientras OT prioriza la seguridad física y continuidad de procesos.
    4.  Ambas gestionan la seguridad de forma idéntica.

- ¿Qué norma define requisitos técnicos certificables para sistemas industriales?
    1.  NIST SP 800-82.
    2.  NIST CSF 2.
    3.  IEC 62443.
    4.  MITRE ATT&CK.

- ¿Qué elemento suele representar el punto más vulnerable en una red OT?
    1.  El firewall perimetral.
    2.  Los controladores PLC.
    3.  Las estaciones HMI.
    4.  Los routers industriales.



- Según la presentación, ¿Cuál es el principal objetivo de la regulación UN R155?
    1. Estandarizar el hardware de las ECUs en los vehículos.
    2. Definir los protocolos de comunicación V2X.
    3. **Convertir la ciberseguridad en un requisito legal para la venta de vehículos nuevos.**
    4. Establecer los estándares de emisiones de CO₂ para vehículos nuevos.

- La norma ISO/SAE 21434 obliga a integrar la ciberseguridad en...
    1. Únicamente en la fase de diseño del software del vehículo.
    2. **Todo el ciclo de vida del vehículo, desde el diseño hasta el desmantelamiento.**
    3. Sólo durante la producción en la cadena de montaje.
    4. Exclusivamente en los sistemas de infoentretenimiento.

- ¿Qué fabricante de vehículos sufrió una vulnerabilidad que permitía a los atacantes controlar funciones como el motor o las puertas de forma remota, usando únicamente el número de bastidor (VIN)?
    1. Jaguar Land Rover (JLR)
    2. **Kia**
    3. CDK Global
    4. La Dirección General de Tráfico (DGT)





- En qué ámbito se aplica el Esquema Nacional de Seguridad?
    1. En todas las empresas privadas españolas
    2. Solo en las entidades financieras
    3. En las administraciones públicas y entidades que prestan servicios al sector público
    4. Únicamente en organismo de defensa y seguridad nacional

- Cuál es el objetivo principal del Esquema Nacional de Seguridad?
    1. Fomentar el uso de software libre en las administraciones públicas
    2. Garantizar la seguridad de la información y los servicios electrónicos en el sector público
    3. Regular la contratación pública de servicios tecnológicos
    4. Promover la interoperabilidad entre diferentes sistemas de información

- Según el ENS, las medidas de seguridad se agrupan en tres grandes marcos. Cuáles son?
    1. Marco legal, marco técnico y marco de cumplimiento
    2. Marco organizativo, marco operacional y medidas de protección
    3. Marco directo, marco de procesos y marco tecnológico
    4. Marco administrativo, marco funcional y marco técnico



- A partir de los niveles de seguridad, el ENS define las categorías de seguridad:
    1.  Verde, Amarilla y Roja.
    2.  **Básica, Media y Alta.**
    3.  Disponibilidad, Integridad, Confidencialidad, Autenticidad y Trazabilidad.
    4.  Bajo, Medio y Alto.

- Un sistema de información será de categoría MEDIA si...
    1.  Todas sus dimensiones de seguridad son de nivel MEDIO y ninguna de nivel superior.
    2.  Dos de las dimensiones de seguridad son de nivel BAJO, dos de nivel ALTO y una de nivel MEDIO.
    3.  **Al menos una de sus dimensiones de seguridad es de nivel MEDIO y ninguna de nivel superior.**
    4.  Ninguna de sus dimensiones de seguridad es de nivel MEDIO y alguna es de nivel superior.

- Cual de las siguientes afirmaciones acerca de las diferencias entre el ENS y la ISO 27001 es correcta:
    1.  La ISO 27001 solo tiene en cuenta la autenticidad y la trazabilidad, mientras que el ENS también considera la confidencialidad, integridad y disponibilidad.
    2.  El ENS y la ISO utilizan la misma clasificación en niveles bajo, medio y alto para las dimensiones de seguridad.
    3.  La ISO 27001 define categorías de seguridad para los sistemas de información, mientras que el ENS no establece ninguna clasificación.
    4.  **En ENS define niveles fijos (bajo, medio, alto) para cada dimensión de seguridad, mientras que la ISO 27001 deja el establecimiento de criterios de impacto y riesgo a la organización.**



- ¿Cuáles son las tres categorías de seguridad establecidas por el ENS?
    1.  Baja, Media, Crítica
    2.  **Básica, Media, Alta**  
    3.  Inicial, Intermedia, Avanzada

- ¿Cuál de las siguientes herramientas del CCN se utiliza para centralizar la gestión de la seguridad de los sistemas de información y verificar el cumplimiento del ENS?
    1.  PILAR
    2.  AMPARO
    3.  **INÉS**   

- ¿Qué tipo de medidas del ENS se centran en proteger activos concretos según su naturaleza y el nivel de seguridad requerido?
    1.  Marco organizativo
    2.  Marco operacional
    3.  **Medidas de protección**  



- ¿Qué significa ISMS (Sistema de Gestión de Seguridad de la Información)?
    1.  Un software antivirus para proteger sistemas informáticos
    2.  **Un enfoque sistemático para gestionar información sensible mediante procesos de gestión de riesgos**
    3.  Una certificación obligatoria para todas las empresas españolas
    4.  Un departamento de IT encargado de reparar ordenadores


- ¿Qué centro operacional se encarga de la monitorización continua 24/7, detección de amenazas y respuesta a incidentes de seguridad en tiempo real?
    1.  BIA (Business Impact Analysis)
    2.  **SOC (Security Operations Center)**
    3.  ENS (Esquema Nacional de Segurida4. 
    4.  RTO (Recovery Time Objective)


- ¿Qué regulación europea deben cumplir las empresas para garantizar la protección de datos personales y privacidad en todas sus operaciones en la Unión Europea?
    1.  DORA (Digital Operational Resilience Act)
    2.  NIS2 (Network and Information Security Directive) 
    3.  **GDPR (General Data Protection Regulation / RGP4. **
    4.  ENS (Esquema Nacional de Segurida4. 



- ¿Qué marcos o certificaciones utiliza el Banco Santander para garantizar la seguridad en distintos entornos internacionales?
    1.  ENS
    2.  NIST
    3.  ISO/IEC 27001
    4.  Todas las anteriores 

- ¿Qué normativa española es obligatoria para garantizar la seguridad en infraestructuras críticas como las de ADIF?
    1.  ISO/IEC 27002
    2.  NIS2
    3.  ENS (Esquema Nacional de Segurida4.  
    4.  GDPR

- ¿Qué certificación internacional es la base del ISMS implantado por Telefónica Tech?
    1.  PCI-DSS
    2.  GDPR
    3.  ISO/IEC 27001
    4.  Esquema Nacional de Seguridad (ENS)



- Según la guía CCN-STIC 803 la categoría final de seguridad de un sistema se determina por...
    1. El promedio de niveles de todas las dimensiones
    2. **El nivel más alto entre todas las dimensiones**
    3. El número de usuarios que tenga el sistema
    4. El presupuesto disponible

- ¿Qué serie de guías del CCN-STIC es la que sirve para adecuarnos al Esquema Nacional de Seguridad (ENS)?
    1. Serie 200
    2. **Serie 800**
    3. Serie 400
    4. Serie 900

- El objetivo de la guía 801 es definir...
    1. **Roles y responsables**
    2. Diseño del logo
    3. Presupuesto de marketing
    4. Calidad del servicio de atención al cliente



- ¿Cuál de las siguientes guías pertenece al bloque organizativo y define roles clave en la seguridad de la información dentro de organizaciones públicas?

    1. CCN-STIC-808.
    2. **CCN-STIC-801.**
    3. CCN-STIC-804.
    4. CCN-STIC-823.

- ¿Qué función principal cumple la guía CCN-STIC-808 en el contexto del ENS?

    1. Define los estándares técnicos para redes inalámbricas seguras.
    2. Proporciona el plan de adecuación al ENS de una organización.
    3. **Establece procedimientos para evaluar el grado de implementación de las medidas de seguridad obligatorias.**
    4. Regula la implantación de criptografía certificada.

- ¿Cuál es la principal utilidad de la herramienta LUCIA dentro de la gestión del ENS?

    1. Automatizar la auditoría técnica del cumplimiento del ENS.
    2. Configuración segura de aplicaciones web dentro del ENS.
    3. Análisis y protección de entornos cloud seguros.
    4. **Gestión integral de incidentes de seguridad y coordinación con el CCN-CERT**




- ¿Cuál es la principal función de la norma ISO/IEC 27001 en relación con el RGPD?
    1. Definir los derechos de los usuarios sobre sus datos personales
    2. **Proporcionar un marco de controles para proteger la información**
    3. Sustituir la necesidad de cumplir con el RGPD

- ¿Cuál de las siguientes afirmaciones es correcta?
    1. Estar certificado en ISO 27001 garantiza automáticamente el cumplimiento total del RGPD
    2. ISO 27001 solo se aplica a empresas tecnológicas
    3. **ISO 27001 ayuda a cumplir partes del RGPD, pero no lo reemplaza**

- ¿Qué control de la ISO 27001 ayuda directamente a cumplir con el artículo 33 del RGPD (notificación de brechas)?
    1. Control 8.24 – Uso de criptografía
    2. **Control 5.25 – Evaluación de incidentes de seguridad**
    3. Control 5.20 – Acuerdos con proveedores





- ¿Cuál de estos no es un derecho individual del RGPD?
    1.  Solicitar la rectificación de sus datos personales
    2.  Notificación de brechas a la autoridad por parte del responsable
    3.  Oponerse al tratamiento de sus datos personales
    4.  No ser objeto de decisiones únicamente automatizadas

- ¿Qué afirmación es correcta sobre anonimización y seudonimización?
    1.  Ambos quedan fuera del RGPD
    2.  Seudonimización excluye siempre la aplicación del RGPD
    3.  Anonimización irreversible queda fuera; seudonimización sigue dentro
    4.  Ninguna diferencia práctica

- ¿En qué ámbito territorial aplica el RGPD?
    1.  Solo empresas con sede en la UE
    2.  Empresas de la UE y también fuera si ofrecen bienes/servicios a personas en la UE
    3.  Solo administraciones públicas europeas
    4.  Únicamente comercios electrónicos



- ¿Cuáles obligaciones del GDPR solo guardan un vínculo indirecto con la ISO 27002 y no tienen un control de seguridad claro implementarlas?
    1. Notificar violaciones de datos y Realizar auditorías periódicas.
    2. Garantizar la seguridad de los datos y Notificar violaciones de datos.
    3. Obtener el consentimiento informado e Informar sobre el uso de datos.
    4. Garantizar la seguridad de los datos y Realizar auditorías periódicas.


- El GDPR exige notificar brechas de seguridad a la autoridad en 72 horas. ¿Qué control de ISO 27002 es esencial para tener el proceso definido y cumplir con este plazo?
    1. A.5.1 Políticas de Seguridad de la Información
    2. A.5.26 Respuesta a Incidentes de Seguridad de la Información
    3. A.8.16 Monitorización de Actividades
    4. A.5.37 Revisión Independiente de la Seguridad


- El GDPR exige un proceso de verificación, evaluación y valoración regulares de la eficacia de las medidas de seguridad. ¿Qué control de ISO 27002 se ajusta más con esta obligación?
    1. A.8.16 (Monitorización de Actividades)
    2. A.5.24 (Planificación de Gestión de Incidentes)
    3. A.5.27 (Lecciones Aprendidas de Incidentes)
    4. A.5.37 (Revisión Independiente de la Segurida4. .



- ¿Cuál de las siguientes oraciones sobre la continuidad de negocio es correcta?
    1.  La continuidad de negocio se garantiza únicamente mediante soluciones técnicas como copias de seguridad y redundancia de sistemas.
    2.  La continuidad de negocio depende exclusivamente del departamento de TI.
    3.  **La continuidad de negocio no se alcanza solo con aspectos técnicos; también requiere políticas y decisiones estratégicas.**
    4.  La continuidad de negocio solo es relevante en empresas grandes con infraestructura crítica.

- ¿Qué enfoque propone la norma ISO 27001 respecto a la continuidad de negocio dentro del SGSI?
    1.  Considerar la continuidad de negocio únicamente durante la fase de mejora del ciclo PDCA.
    2.  **Integrar la continuidad de negocio en todas las fases del ciclo PDCA: planificación, implementación, evaluación y mejora.**
    3.  Tratar la continuidad de negocio como un proceso independiente del SGSI.
    4.  Limitar la continuidad de negocio a la recuperación de datos tras un incidente.

- ¿Cuál de las siguientes acciones pertenece realmente a la fase de Implementación dentro del proceso de continuidad de negocio?
    1.  Definir métricas y umbrales de actuación para evaluar el rendimiento de los controles establecidos.
    2.  **Poner en marcha los controles seleccionados y capacitar al personal para su correcta aplicación.**
    3.  Evaluar periódicamente la continuidad de los proveedores y los riesgos asociados.
    4.  Configurar dashboards de monitorización para el seguimiento en tiempo real de incidentes.



- ¿Cuál fue el factor clave que permitió el acceso no autorizado a los datos de Iberdrola en el incidente de 2024?
    1. Una intrusión directa en los servidores internos de Iberdrola
    2. **La explotación de una vulnerabilidad en un proveedor externo**
    3. Un ataque DDoS contra la red corporativa
    4. La filtración de credenciales de empleados en redes sociales

- ¿Cuál fue el principal riesgo para los clientes derivado de la filtración de datos?
    1. Pérdida del servicio eléctrico
    2. Robo directo de dinero en cuentas bancarias
    3. **Suplantación e ingeniería social gracias a los datos personales expuestos**
    4. Manipulación de consumos energéticos

- Según el análisis del incidente, ¿qué aspecto fue considerado insuficiente por la AEPD al evaluar la actuación de Iberdrola?
    1. La velocidad con la que notificó el incidente
    2. La transparencia en la comunicación pública
    3. **La supervisión de seguridad aplicada a sus proveedores**
    4. La implantación de sistemas de monitorización en su red interna





- ¿Cuál de los siguientes es un indicador común de un ataque de ransomware en un equipo (host)?
    1.  Disminución en la velocidad de conexión a Internet.
    2.  **Archivos que cambian de nombre o de extensión de forma masiva.**
    3.  Aumento del espacio libre en disco duro.
    4.  Creación automática de copias de seguridad adicionales.

- ¿Qué característica hace que una herramienta como YARA sea útil para la investigación de ransomware?
    1.  Genera copias de respaldo automáticas.
    2.  **Usa reglas para identificar patrones de código o texto asociados a malware.**
    3.  Bloquea conexiones de red sospechosas en tiempo real.
    4.  Cifra los archivos sensibles del sistema.

- ¿Cuál de los siguientes comportamientos en la red podría indicar un ataque de ransomware en curso?
    1.  Tráfico saliente hacia dominios o IP desconocidas.
    2.  Conexiones frecuentes a servidores internos autorizados.
    3.  **Descenso en el uso del ancho de banda.**
    4.  Conexiones cifradas solo dentro de la red local.



- ¿Cuál de los siguientes es un indicador técnico común de un ataque de ransomware?
    1.  Disminución del uso de la memoria RAM
    2.  Creación de archivos con extension .xlsx
    3.  **Actividad inusual de cifrado de archivos con procesos no firmados**
    4.  Instalación automática de actualizaciones de software

- ¿Qué tipo de herramienta permite ejecutar archivos sospechosos en un entorno aislado para analizar su comportamiento?
    1.  EDR / XDR
    2.  Herramientas de monitoreo de red
    3.  Anti-malware NGAV
    4.  **Sandboxing / análisis de malware**

- ¿Cuál de las siguientes soluciones se clasifica como una herramienta forense?
    1.  **Sysinternals Suite**
    2.  Kaspersky Endpoint Security
    3.  Cuckoo Sandbox
    4.  CrowdStrike Falcon



- Herramienta desarrollada por el CCN-CERT para la gestión de ciberincidentes:
    1.  INES
    2.  **LUCIA**
    3.  PILAR


- El número de días tras el cual se procede a cerrar un ciberincidente sin respuesta se ve determinado por su...
    1.  Tipo
    2.  Estado
    3.  **Nivel de peligrosidad**


- En materia de ciberincidentes, un organismo afectado se comunicará con terceros...
    1.  De forma directa
    2.  **A través del CCN-CERT**
    3.  Dependiendo del tipo de ciberincidente



- Cual de estas opciones NO es un siem:
    1.  Splunk
    2.  Graylog
    3.  **Microsoft Defender** 
    4.  IBM QRADAR

- Un soar está compuesto por:
    1.  Orquestación, monitorización y respuesta a incidentes
    2.  **Orquestación, Automatización y Respuesta a incidentes** 
    3.  Monitorización y Respuesta a incidentes
    4.  Automatización, Monitorización y Respuesta a incidentes

- Un XDR puede...
    1.  Identificar amenazas
    2.  Recopilar datos
    3.  Contener amenazas
    4.  **Todas con correctas**
