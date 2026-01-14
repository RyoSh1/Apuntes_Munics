# Gestión de la Seguridad de la Información

## Tema 1: Introducción

### Fundamentos

- Ciberseguridad : Disciplina basada en computadores que incluye tecnología, personas, información y procesos para asegurar operaciones en un contexto con adversarios.
- Seguridad de la información : Se encarga de la información sin tener en cuenta el formato (papel, digital, intelectual, etc.). Se trata de un contexto muy importante por su relevancia económica, técnica y social, para empresas, gobierno o formación.

Conceptos de la seguridad de la información:
- Identificar: Usar el conocimiento sobre la organización para minimizar el riesgo.
- Proteger: Diseñar controles para limitar el impacto de los posibles incidentes.
- Detectar: Implementar procesos para detectar eventos de ciberseguridad.
- Respuesta: Proceder con las acciones necesarias ante incidentes de seguridad.
- Recuperación: Planear ser resilientes y ser capaces de recuperar servicios comprometidos.

El objetivo de la seguridad de la información es minimizar la suma de dos costes: El coste causado por incidentes y el coste de los controles de seguridad. Por ello es necesario entender los riesgos de la información, identificar mejoras, situar recursos adecuadamente y cumplir con los requisitos. La "gestión" conlleva objetivos, planes, roles, recursos, operación, evaluación y mejoras.

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

Integridad de datos es la propiedad que define que la información no ha sido alterada de una manera no autorizada, la integridad de un sistema es la cualidad que determina si un sistema funciona como es debido libre de modificaciones no autorizadas.

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
- Conocimiento necesario.
- Detección de intrusiones.

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

Los índices de impacto no se suman, se calcula por separado el impacto técnico y el impacto de negocio.

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
- Responsabilidad: Garantía de que siempre se puede determinar quién hizo qué y cuándo lo hizo.

#### Método de análisis de riesgos

1. Determinar los activos importante en la organización, sus relaciones y su valor.
2. Determinar las amenazas a las que los activos están expuestos.
3. Determinar las salvaguardas disponibles y su efectividad.
4. Estimar el impacto, definido como el daño al activo si aparece la amenaza.
5. Estimar el riesgo, definido como el impacto por la probabilidad.

#### Paso 1: Activos

Los activos **principales** son de dos tipos especiales: La información manipulada y los servicios provistos.

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

- Documentación intermedia: Resultados de las entrevistas, Documentación de otras fuentes, Información ya existente y reportes de defectos encontrados.
- Documentación final:
    - Modelo de valor: Documento con activos, interdependencias y valor.
    - Mapa de riesgos: Informe que detalla las principales amenazas para cada activo, caracterizasas por su probabilidad y degradación causada.
    - Declaración de Aplicabilidad: Informe de contramedidas consideradas adecuadas para el sistema.
    - Evaluación de salvaguardias: Informe de salvaguardas existentes, clasificadas según su eficacia para reducir el riesgo enfrentado.
    - Informe de deficiencias o vulnerabilidades: Informe de salvaguardas necesarias, pero que son insuficientemente eficaces o ausentes.
    - Estado del riesgo: Informe que detalla para cada activo el impacto y riesgo residual potencial según la amenaza.

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

1. Propósito: Ayudar a informar a los responsables de la toma de decisiones y respaldar respuestas adecuadas a los riesgos.
2. Criterios básicos: Enfoque de gestión de riesgos, criterios de evaluación, criterio de impacto, criterio de probabilidad o apetito al riesgo.
3. Alcance y límites: Evaluación de la organización, su propósito, su negocio, su mision, sus valores y la estructura.
4. Organización operativa: Desarrollar los procesos, identificar las partes interesadas, definir los roles y responsabilidades, relaciones y caminos de desarrollo.

#### 2. Evaluación de riesgos

Realizar una evaluación de los riesgos cibernéticos a los que se enfrenta una empresa u organización. Se utilizan para identificar, analizar y priorizar los riesgos para las operaciones de la organización , los activos, las personas y otras organizaciones derivadas.

- Activo de información: Es cualquier información, tangible o intangible, que tiene valor, un ciclo de vida y debe ser protegida y gestionada.
- Dueño del activo: La persona responsable de controlar la producción, desarrollo, mantenimiento y seguridad de un activo. Propietario del activo de información es aquel responsable de que dicho información en específico es gestionada correctamente.
- Inventario de activos: Es una estructura de información que contiene los activos y sus características.

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

REVISAR DE NUEVO 27005, solo repite ideas.

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

Norma creada por la Organización Internacional de Estandarización y la Comisión Electrotécnica Internacional que especifica los requistos para establecer, implementar, mantener y mejorar de forma continua un SGSI. Provee un modelo de cómo proceder con un SGSI, además es una norma certificable, lo que significa que demuestra a partes interesadas que la organización está comprometida con la seguridad de la información.

La Seguridad deja de ser solo una cuestión técnica para ser parte del plan de negocio.

### Ciclo de Deming (PDCA)

Se divide en 4 etapas:
1. Planificar (establecer el SGSI): Establecer políticas, objetivos, procesos y procedimientos relevantes para gestionar el riesgo de acuerdo con las políticas generales de una organización. 
2. Hacer (implementar y operar el SGSI): Implementar y operar la política, los controles, los procesos y procedimientos del SGSI.
3. Comprobar (monitorizar y revisar el SGSI): Evaluar y medir el desempeño del proceso en relación con la política e informar de resultados.
4. Actuar (mantener y mejorar el SGSI): Tomar medidas correctivas y preventivas basados en las auditorías y revisiones realizadas.

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

Alta dirección supongo.

La necesidad de que se asegure que en las sucesivas evaluaciones de riesgo se generen resultados consistentes, válidos y comparables ¿es?

Un requisito.

¿Qué requiere la ISO 27001 para el control de la información documentada?

C

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

Beneficios de la certificación: Mejor seguridad a un menor coste, credibilidad y confianza pública, cumplimiento de leyes y regulación, cumplimiento de responsabilidades fiduciarias.

Cualquier organización puede crear un estándar y decir que cumple, no hay evidencia. Por eso existe:
- Certificación: Forma de demostrar que efectivamente una organización cumple con un estándar.
- Acreditación: Provista a las organizaciones que realizan certificaciones, los cuerpos de certificación necesitan ser validados por una autoridad acreditadora. Normalmente existe una autoridad acreditadora nacional.

ENAC: Entidad Nacional de ACreditación, realiza acreditación de la ISO 27001 (Confidencialidad, integridad y disponibilidad de los Sistemas de Información) y el ENS (Principios básicos y requisitos a implantar en los sistemas de administración pública).

Para el ENS existen empresas acreditadas en certificación de conformidad (AENOR, AAS, BDO, etc.)

### ISO

#### Ciclo de certificación

1. Revisión de la preparación.
2. Certificación.
3. Comienza el ciclo de auditorías de vigilancia: Se examinan los elementos fundamentales, interno, revisión de la gestión, acciones correctivas, etc.
4. Auditoría de recertificación: Se revisa todo el sistema, pero en menor profundidad que la original y con más enfoque en las mejoras.

#### Requisitos: Documentos y problemas típicos

No hay un listado de documentos requeridos, pero sí una información documentada requerida:
1. Alcance del ISMS.
2. Política de Seguridad de la información.
3. Proceso de evaluación de riesgos.
4. Proceso de tratamiento de riesgos.
5. Objetivos de seguridad de la información.
6. Evidencia de las competencias del personal TI.
7. Otros documentso relacionados con el SGSI necesarios.
8. Documentos de planificación y control operacional.
9. Resultados de las evaluaciones de riesgos.
10. Decisiones sobre el tratamiento de riesgos.
11. Evidencia del seguimiento y medición de la seguridad de la información.
12. Programa de auditoría interna sobre el SGSI.
13. Evidencias de las principales revisiones a la gestión del SGSI.
14. Evidencia de las no conformidades identificadas y acciones correctivas que surgan.
15. Otra información documentada.

Problemas típicos: Registro de activos incompleto, personal no incluido, método muy complejo, no aprovado por la gestión, localización o seguridad de servidores, incidentes no reportados, BCP sin testear, etc.

### ENS

Artículo 34 dice que se debe realizar una auditoría ordinaria cada al menos 2 años. Deberá realizarse dicha auditoría siempre que se produzcan modificaciones sustanciales en el sistema de información.

El plazo de adecuación es de 24 meses.

#### Adecuación

- Preparar y aprobar la política de seguridad, incluyendo definición de roles y asignación de responsabilidades.
- Categorizar los sistemas.
- Realizar análisis de riesgos y valoración de medidas de seguridad.
- Aprobar la declaración de aplicabilidad.
- Plan de adecuación para mejoras de la seguridad.
- Implementar, operar y monitorizar las medidas de seguridad.
- Auditar la seguridad.
- Informar sobre el estado de la seguridad.

#### CoCENS. Proceso de adecuación.

Consejo de Certificación del ENS, es un órgano colegiado por Ley y por la guía 809 creado para ayudar a la adecuada implantación del ENS.
1. Velar por la adecuada implantación del ENS.
2. Alentar los procesos de certificación de conformidad con el ENS.
3. Proponer para su análisis Normas, Criterios o Buenas Prácticas con el ENS.
4.
5.
6.

#### CoCENS. Proceso de adecuación.

La certificación y conformidad con el ENS conlleva:
1. Plan de Adecuación: Documento que debe incluir:
    - Alcance.
    - Categoría de los sistemas según las dimensiones.
    - Declaración de Aplicabilidad Provisional.
    - Análisis de Riesgos.
    - Declaración de Aplicabilidad y Perfil de Cumplimiento Específico.
    - Preparar y aprobar la Política de Seguridad.
2. Implementación de la seguridad: Hoja de ruta de documentos y medidas a elaborar, elaborar el Marco Normativo e implantación de Seguridad y aprobar el SGSI.
3. Declaración / Certificación de Conformidad: Auditoría formal cada 2 años en caso de categoría media o alta. Autoevaluación cada 2 años en el caso de categoría básica.
4. Informar sobre el Estado de Seguridad: Utilizar el proyecto INES para métricas e indicadores.
5. Vigilancia y mejora continua: Revisión de la Política de Seguridad, de la categorización de servicios e información, del SOA, del perfil de cumplimiento, de auditorías internas, del plan de mejora, etc. Actualización anual del análisis de riesgos.

#### µCeENS

Es una metodología innovadora que se beneficia de las novedades del Real Decreto para facilitar la Certificación de Conformidad en el ENS en base a un Perfil de Cumplimiento Específico (PCE). Esta metodología proporciona asistencia hasta después de su obtención, automatizado con las herramientas de governanza INES-AMPARO.

### Auditoría

Es un proceso sistemático, independiente y documentado para obtener evidencia y evaluarla objetivamente con el fin de determinar en qué medida se cumplen los criterios establecidos.

Referencias: ISO 27007 Orientación para organismos de certificación o ISO 27008 Técnicas de seguridad.

#### Tipos de auditorías

- Interna: Realizada por la propia organización para revisar la gestión o razones internas, forma la base de la propia declaración de conformidad. En empresas pequeñas se puede afirmar la responsabilidad sin bias de la auditoría.
- Externa: Pueden ser realizadas por una organización independiente que provee certificación o por una organización seecundaria que tiene cierto interes en la empresa.
- Combinada: Cuando dos o más sistemas de gestión de distintas disciplinas son auditados en conjunto.
- Unión: Cuando dos o mar organizaciones cooperan para auditar en conjunto a una tercera.

#### Conceptos de auditoría

- Evidencia: Registros verificados, resultados de información relevante para la auditoría.
- Hallazgos: Resultados de la evaluación de la evidencia recogida, puede indicar el resultado (conformidad).
- Conclusiones: Resultados de una auditoría, teniendo en cuenta los objetivos y los hallazgos.
- Cliente de auditoría: Organización que solicita una auditoría.
- Auditado: Organización auditada.
- Auditor: Aquellos que realizan la auditoría.

#### Principios de auditoría

- Integridad: En el sentido profesional, es decir honestidad, responsabilidad, aplicando legalidad y siendo imparcial.
- Presentación fidedigna: La obligación de presentar los resultados de forma precisa y digna, reportando problemas encontrados entre las partes involucradas.
- Cuidados personales: Aplicación de diligencia y juicio adecuados.
- Confidencialidad.
- Independencia: Para las auditorías internas, el auditor debe ser independiente de los operarios. En organizaciones pequeñas puede no ser posible y debe aplicarse la objetividad.
- Aproximación basada en la evidencia: Es la forma racional de llegar a conclusiones de auditoría, la evidencia debe ser verificable con ejemplos.

#### Encuesta de alcance y preauditoría

- Los auditores deben determinar los focos principales de auditoría y las áreas fuera de alcance. Esta información se obtiene mediante búsqueda de información, otras auditorías, reportes, SOA y RTP.
- Asegurar que el alcance tiene sentido en el contexto de la organización.
- Prestar especial atención a riesgos y controles de seguridad asociados con conductos de información hacia otras entidades.
- Identificar e intentar establecer contacto con los controladores del ISMS como el CISO, CEO y CIO.

#### Planificación y preparación

- El alcance del ISMS debe ser desgranado en detalles, generando una checklist de auditoría.
- El calendario general y los recursos de la auditoría se negocian y acuerdan entre la dirección de la organización y los auditores del SGSI en forma de calendario de auditoría. Un GANTT, por ejemplo.
- Los planes de auditoría suelen incluir puntos de control, para que los auditores proporcionesn actualizaciones provisionales, incluyendo la notificación preliminar de inconsistencias encontradas.

#### Trabajo de campo

- Revisión de documentación relacionada con el ISMS.
- Realización de pruebas para determinar si el ISMS implementado sigue la documentación.
- La evidencia de auditoría se recoge metódicamente usando la checklist, con elementos como entrevistas al personal, revisión de documentos y observación de los procesos en acción.
- Pruebas de cumplimiento técnicas suelen ser necesarias para verificar que los sistemas están configurados de acuerdo con las políticas de seguridad y estándares de la organización.

#### Análisis

- La evidencia acumulada es ordenada, completada, revisada y examinada en relación a los riesgos de información, los objetivos y los requisitos.
- Se generan hallazgos iniciales, con conclusiones y recomendaciones respecto a problemas encontrados.
- Es posible encontrar huecos en la evidencia, requiriendo unas nuevas pruebas de auditoría.

#### Reporting

Un reporte de auditoría contiene los siguientes elementos:
- Título e introducción, incluye el alcance, objetivos y contexto.
- Resumen ejecutivo con hallazgos clave.
- Listas de los recipientes específicos, con la clasificación de los documentos e instrucciones de circulación.
- Credenciales y métodos de auditoría utilizados.
- Análisis y hallazgos detallados.
- Conclusiones y recomendaciones.
- Declaración formal de los auditores sobre cualquier reserva.

#### Hallazgos

Se categorizan según su importancia o severidad:
- Reportes de no conformidades mayores: Afectan substancialmente a la capacidad del ISMS de lograr sus objetivos.
- Menores: Lo contrario.
- Observaciones o oportunidades de mejora.

#### Cierre

Además de cerrar los archivos de auditoría, el cierre implica atar cabos sueltos; es decir, preparar notas para futuras auditorías, realizar un seguimiento de acciones acordadas, etc.

#### Preparaciones en una auditoría

El líder del equipo auditor debe preparar un plan de auditoría que sirva como acuerdo entre el cliente, el equipo auditor y el auditado sobre cómo se desarrollará la auditoría. 

Este plan debe facilitar la coordinación y programación de actividades, adaptando su nivel de detalle al alcance y complejidad de la auditoría, y manteniendo suficiente flexibilidad para permitir cambios durante el proceso. 

El plan debe incluir los objetivos, criterios, alcance, unidades y procesos a auditar, fechas y lugares de las actividades, duración prevista, reuniones con la dirección, roles y responsabilidades del equipo, asignación de recursos, representante del auditado, idioma de trabajo, temas del informe, logística, confidencialidad y acciones de seguimiento. 

Antes de iniciar la auditoría el plan debe ser revisado y aceptado por el cliente y presentado al auditado; cualquier objeción debe resolverse entre las partes, y cualquier versión revisada debe ser aprobada antes de continuar.

El líder del equipo debe:
- Asignar a cada auditor las áreas, procesos o actividades que auditará, considerando independencia, competencia y uso eficiente de recursos, pudiendo ajustar estas asignaciones según avance la auditoría. 
- Preparar documentos de trabajo como listas de verificación, planes de muestreo y formularios para registrar evidencia, hallazgos y reuniones, sin que estos limiten el alcance de la auditoría. 

Todos los documentos deben conservarse hasta finalizar la auditoría y protegerse adecuadamente cuando contengan información confidencial.

### ISO 19001: 6.5 Realización de actividades de auditoría in situ

#### Reunión inicial

Debe mantenerse una reunión inicial con la gestión de la entidad auditada para confirmar el plan de auditoría, proveer de un resumen de los procesos a realizar y confirmar los canales de comunicación.

El jefe del equipo de auditoría debe comunicar:
- Participantes y su rol.
- Objetivos, alcance y criterios.
- Tiempos de acción.
- Métodos y procedimientos que se van a llevar a cabo.
- Confirmación de los canales de comunicación.
- Lenguaje a utilizar.
- Informes de progreso.
- Recursos necesarios.
- Temas de confidencialidad y seguridad de trabajo.
- Guías y métodos de reporte.
- Condiciones de terminación de la auditoría y sistemas de apelación.

#### Recolección de información

- Entrevistas: Son una de las principales fuentes de información y deben realizarse de forma que se adapte a la situación y personal entrevistado.
- Observación de actividades y del entorno.
- Revisión de documentos: Políticas, objetivos, procedimientos, instrucciones, registros generales, indicadores de rendimiento, bases de datos, etc.

La evidencia se genera a partir de ejemplos de la información disponible, por lo que siempre existe un elemento de incertidumbre en las auditorías.

#### Generar los hallazgos

- Evaluar la evidencia frente a los criterios de auditoría.
- Los hallazgos pueden indicar conformidad o no conformidad, pero también oportunidades de mejora.
- El equipo auditor debe reunirse periódicamente para revisar hallazgos, para registrar conformidades de areas/procesos, conformidades individuales con evidencia y no conformidades con su evidencia.
- Las no conformidades pueden clasificarse por gravedad, deben revisarse con el auditado para confirmar su exactitud y la comprensión de las mismas.
- Se deben resolver discrepancias; si no se resuelven, dejarlas registradas.

#### Preparar las conclusiones

El equipo auditor debe reunirse antes de la reunión final para:
- Revisar hallazgos y demás información frente a los objetivos.
- Acordar conclusiones, considerando la incertidumbre del proceso.
- Preparar recomendaciones y revisar el seguimiento posterior.

Las conclusiones pueden tratar:
- Grado de conformidad del sistema con los criterios.
- Eficacia de la implementación, mantenimiento y mejora del sistema.
- Capacidad de la revisión por la dirección para asegurar adecuación y mejora continua.

Las conclusiones pueden derivar en recomendaciones sobre mejoras, relaciones comperciales, futuras auditorías, etc.

#### Reunión de clausura

Dirigida por el líder del equipo auditor, el objetivo es presentar de forma clara los hallazgos y conclusiones para asegurar la comprensión y reconocimiento del auditado. Busca también acordar plazos para acciones correctivas o preventivas si son necesarias.

En auditorías pequeñas puede ser una reunión simple, en auditorías formales es una reunión estructurada con actas y registro de asistencia.

### ISO 19001: 6.6 Preparación, aprobación y distribución del informe de auditoría.

#### Preparación del reporte

El lider del equipo de auditoría debe ser el responsable de preparar todos los contenidos del reporte de auditoría. Este documento debe proveer un registro conciso, preciso y claro de todos los objetivos y procedimientos seguidos en el proceso.

Lista larga: objetivos, alcance, cliente, equipo de auditoría, criterios, hallazgos y conclusiones.

#### Aprobación y distribución

El informe de auditoría debe emitirse dentro del plazo acordado y avisar del retraso en caso necesario. Debe fecharse, revisarse y aprobarse de acuerdo con los procedimientos del programa.

A continuación, el informe aprobado debe distribuirse a los destinatarios designados por el cliente de auditoría. Este informe es propiedad del cliente, los destinatarios y auditores deben respetar y mantener la confidencialidad.

#### Completar la auditoría

- Se completa cuando todas las actividades descritas en el plan de auditoría han sido realizadas.
- Los documentos generados se deben guardar o destruir según se haya acordado, siguiendo los procedimientos necesarios.
- Salvo que lo requiera la Ley, los auditores no deben revelar ningún tipo de información sobre el proceso, es privado.
- Todo procedimiento adicional de información sobre el proceso debe informar a todas las partes involucradas.

#### Seguimiento

- Las conclusiones pueden indicar la necesidad de tomar medidas correctivas o preventivas, para esto se acuerda un margen de tiempo de ajuste que no entra dentro de la auditoría.
- La efectividad y completitud de las acciones correctivas se debe verificar.
- A veces se plantea un seguimiento por parte de miembros del equipo de auditoría.

## Tema 5: Gestión de la Continuidad de Negocio

Es el proceso de planear una continuación de las operaciones ante la ocurrencia de un incidente disruptivo. Se debe planear previamente y forma parte de la gestión general del riesgo, superponiendo partes con la seguridad de la información y la gestión TI.

#### Conceptos básicos

- Recovery Point Objetive (RTO): Define la pérdida de datos máxima tolerable que se acepta ante un desastre. Si no hay pérdida aceptable, debe ser 0.
- Recovery Time Objetive (RTO): Tiempo de recuperación objetivo para tener la infraestructura disponible. Determina el tiempo tolerable para recuperar los sistemas críticos.
- Work Recuperation Time (WRT): Determina el tiempo máximo tolerable para verificar el sistema, integridad de datos, comprobar las BD y asegurarse de que todo funciona bien.
- Maximum Tolerable Downtime (MTD): Determina la cantidad total de tiempo que un proceso de negocio puede ser interrumpido sin causar consecuencias aceptables. RTO + WRT.
- Disrupción: Una avería que tiene consecenciasen términos de tiempo y negocio, pero que no incluye fallos operativosq ue tengan que ser gestionados mediante procedimientos estándar.
- Desastre: Acontecimiento repentino e imprevisto que provoca la imposibilidad de llevar a cabo funciones críticas del negocio y provoca grandes daños. Una interrupción puede ser una disrupción o desastre dependiendo del tiempo.
- Continuidad de negocio (BC): Capacidad de una organización de continuar los servicios o productos a niveles aceptables tras un incidente disruptivo. Relación entre desastre y recuperación.
- Gestión de la continuidad de negocio (BCM): Proceso de obtención de BC, se basa en preparar la organización ante incidentes.
- Sistema de gestión de la continuidad de negocio (BCMS): Es un sistema gestor que permite controlar, evaluar y mejorar la gestión de la continuidad de negocio.
- Plan de continuidad de negocio (BCP): Es un documento guía que ayuda asegurar que se continúa con los procesos de negocio durante una emergencia o desastre, describe todos los pasos que deben seguirse durante un evento crítico y los aspectos de preparación, respuesta y recuperación. Se prepara según un análisis de impacto de negocio, el cual evalúa los riesgos y prioriza los sistemas en uso con fines de recuperación.
- Plan de recuperación de desastres (DRP): Es un plan para reestablecer las funciones de negocio en caso de desastre, paso a paso.
- Gestión de incidentes: Se trata de la porción de recuperación táctica de un BCP, es la primera respuesta para contener la propagación del incidente.
- BC/DR: Se trata de recuperar el negocio, una vez se contiene el incidente se inicia con el plan de continuidad o la recuperación de desastres.

### Planificación de la continuidad de negocio

#### Etapas

1. Prevención: Reducir la posibilidad de que esa amenaza ocurra.
2. Respuesta: Respuesta inicial a la interrupción.
3. Reanudación: Restaurar las operaciones a un nivel similar al normal.
4. Recuperación: Todos los pasos tomados para continuar las actividades principales de la organización.  
5. Restauración: Volver a la fase normal.

#### Elementos principales de BCM

1. Plan de continuidad de negocio (BCP). 
2. Equipos de recuperación: Son el personal que desempeñará las funciones más importantes tanto en la planificación como en la ejecución de los procedimientos de emergencia. Redactan y actualizan el BCP, Identifican nuevos riesgos, forman al personal, coordinan la comunicación entre departamentos y activan el BCP cuando se requiere.
3. Evaluación de riesgos e impacto: Propios de cada organización.
4. Procedimientosw de respuesta a desastres: Incluye cosas como notificar al equipo de recuperación, Diagnosticar servicios y equipos afectados, Contactar a los vendedores, Obtener fondos de emergencia, transpotar personal, etc.
5. Tecnología: Identificar e implementar las tecnologías que hacen posible la continuidad de negocio. Backups, cloud, ant-malware, etc.
6. Activos físicos y ubicaciones de backup: Disponer y securizar localizaciones y activos secundarios.
7. Lineas de comunicación: Es necesario tener medios de comunicación disponibles en caso de incidente para actuar con la mayor brevedad posible.
8. Pruebas y simulacros de recuperación: Se deben mantener pruebas sobre los BCP para identificar fortalezas y debilidades en el plan de continuidad.
9. Plan de actualización: Todos los componentes listados anteriormente sufren cambios constantes, por lo que es necesario evaluar y actualizar dichos planes. Periodicidad.

- Estándares: Modelo PDCA, ISO 22301:2012, ISO 22313:2012, ISO 22317:2015, NIST SP800-34, ITIL Service Continuity Management.

#### Fase 1: Inicio de proyecto

- Obtener apoyo de la alta dirección.
- Definir términos, objetivos y supuestos.
- Asignar responsabilidades.
- Familiarizar a los jefes de equipo y participantes con el proceso y los recursos necesarios.
- Proporcionar una hoja de ruta del proyecto con proyecciones.
- Definir el alcance.
- Identificar procesos y requisitos empresariales críticos.

#### Fase 2: Análisis del impacto y análisis de riesgos

- Análisis de impacto: Análisis detallado de todas las funcions y procesos determinando su impacto cuantitativo (monetario) y cualitativo (intangible). Se prioriza la recuperación de procesos críticos y de negocio.
- Análisis de riesgos: Identifica amenazas a la institución, estimando la probabilidad de ocurriencia, otorgando un rating, identificando controles y tomando decisiones de mitigación.

Normalmente el impacto se analiza antes que el riesgo, primero se mira las consecuencias de una interrupción y aquellas partes que causarían mayores pérdidas financiera u operativas y después se desarrolla una estrategia de mitigación para reducir la probabilidad de que un peligro tenga un impacto significativo.

#### Fase 3: Estrategias de recuperación

Desarrollo de estrategias basadas en el impacto y riesgo, mediante cálculos de coste/beneficio. El objetivo es lograr una respuesta controlada y efectiva, en el menor tiempo posible y efectivas en coste (o recursos) y Recuperar los procesos más críticos en el mínimo RTO.

#### Fase 4: Desarrollo del plan

Tareas de desarrollo del plan:
- Identificar los miembros del equipo de recuperación.
- Desarrollar roles y responsabilidades en el equipo.
- Determinar RTO de cada area funcional.
- Desarrollar tareas y procesos para cada función de negocio.
- Identificar requisitos de recursos.
- Planear notificaciones, mobilizaciones y activaciones.

#### Fase 5: Evaluación y entrenamiento

Es un programa contínuo en el que se tratan los componentes, los roles, la información del BCP y cómo se activa.

#### Fase 6: Mantenimiento y Testing

El BCP es un documento en constante cambio según las evoluciones que tenga el negocio que soporta.

Se recomienda realizar pruebas anualmente, demostrando el correcto funcionamiento del equipamiento, procedimientos, procesos y sistemas. Debe enfocarse en las capacidades, lagunas y deficiencias.

### Análisis del impacto en el negocio

El BIA es un proceso sistemático que determina y evalúa los potenciales efectos de una interrupción de las operaciones críticas de la empresa, resultado de un desastre o emergencia. El propósito es entender los productos clave de la organización y las actividades que los producen, determinar las prioridades para su recuperación, identificar recursos necesarios para la continuidad o recuperación y identificar las dependencias.

#### Entradas y Salidas

- Entradas: Una lista de las actividades de continuidad de negocio, mediante entrevistas, cuestionarios, talleres.
- Salidas: Se debe documentar e incluir identificación de productos, servicios, actividades, prioridades de recuperación y depenencias.

#### Pasos del BIA

1. Determinar los procesos empresariales y la criticidad de la recuperación. Se identifican los procesos empresariales soportados por el sistema y el impacto que produce una disrupción en ellos, además de el daño a elementos externos y el tiempo de inactividad estimado.
2. Identificar los recursos necesarios. Recursos necesarioas para reanudar los procesos de negocio de la forma más rápida posible.
3. Identificar las prioridades de recuperación de los recursos del sistema. Basándose en los resultados de las actividades previas, se pueden vincular los recursos de forma más precisa a los procesos y funciones de negocio, también se puede establecer unos niveles de prioridad para mantener un orden secuencial.

### BCP Testing

Permite el mantenimiento mediante acciones correctivas previas, permite probar elementos con mínimo coste, una atmósfera de baja presión para el aprendizaje y estimula la continuidad y recuperación a todos los niveles. Tipos: Lista de verificación (distribución de copias del BCP), estructurada paso a paso, simulaciones, paralela, interrupción del negocio.

- Walkthrough test: Discusión de los pasos a seguir en el plan de forma verbal, el objetivo es valorar la viabilidad, detectar fallos de diseño y mejorar el plan. Logra que todos los miembros del equipo lo conozcan.
- Desktop test: Funciona como un test y como entrenamiento, sirve para demostrar el conocimiento en el tema.
- Functional test: Movilización de personal a otros sitios, sirve como demostración de capacidades y sirve para usar las capacidades de comunicación necesarias.
- Full-scale test: Implementa todo o partes del BCP, procesar datos o transacciones con el backup, verifica que la respuesta ante crisis es válida, es ejecución real y requiere participación del equipo y de agentes externos.

### Mejores prácticas de un BCM

- Automatizar todos los aspectos del plan de continuidad de negocio.
- Incorporar tecnologías cloud.
- No asumir que la infraestructura virtualizada está plenamente protegida.
- Hacer pruebas es muy importante.
- Considerar la estrategia para la ubicación del centro de datos.
- Priorizar las funciones de continuidad para evitar gastos.
- Pensar en la recuperación ante desastres y la continuidad como servicios gestionados.
- Integrar la movilidad en el BCP.
- Involucrar al personal.
- Recurrir a ayuda de expertos is es necesario.

Elementos clave: Mantener el plan al día, asegurar que los procesos reflejan las necesidades de negocio, mantener un entrenamiento contínuo, tener al equipo de recuperación entrenado.

### Backup

- Backup: Copia de los datos de un ordenador guardados en otra localización para restaurar los originales en caso de pérdida.
- Backup software: Programas usados para crear backups, producen copias exactas de los ficheros, bases de datos o discos completos.
- Estrategia de backup: Requiere un repositorio de información, un espacio donde guardar las copias de seguridad para su trato posterior.

#### Replicación

- Replication: Es el proceso de mantener una copia de los datos mediante shadow o en caché.
- Shadowing: Es una estrategia de seguridad en la que se guarda una copia completa en una instalación alternativa de procesamiento.
- Electronic Vaulting: Transmisión electrónica de los datos copiados.

#### Esquema de rotación de backup

Un esquema de rotación de backup limita el número de backup de cada fecha, reescribiendo archivos que ya no son necesarios. Determina cuando cada pieza de restauración ya no es necesario su mantenimiento. La regla 3-2-1 determina que debe haber 3 copias, en 2 almacenamientos distintos, 1 de ellas en una localización remota.

#### Métodos de backup

1. Full backup: Captura todos los ficheros del disco o de cierta carpeta, es lento y ocupa mucho espacio por lo que se reserva solo a configuraciones completas seguras.
2. Mirror backup: Copia exacta de todos los datos, pero que no se encuentra comprimida por lo que no se protege con contraseña.
3. Incremental backup: Solo captura ficheros creados desde el último backup, se trata del método más económico. Es complicado restaurar todo porque habría que ir versión a versión.
4. Differential backup: Guarda los ficheros que han cambiado desde el último full backup en un fichero aparte, lo que produce que solo hagan falta 2 ficheros para la recuperación completa. 
5. Near CPD: Protección contínua de los datos. Backups incrementales automáticos en intervalos, permiten la restauración según el RTO.
6. Intent-logs: Es un mecanismo utilizado para que las operaciones informáticas sean más resistentes en caso de fallos. Antes de realizar una operación, se escribe un registro de la intención de realizarla (normalmente en un disco permanente), una vez realizada se escribe otro. Esto se usa en el caso de producirse un fallo para detectar qué operaciones estaban aún en proceso.

#### Medios de guardado de backup

RAID: Tecnología de almacenamiento virtual que combina múltiples discos físicos en una o más unidades lógicas para lograr redundancia o rendimiento. 0 = striping, 1 = mirroring, 5 = striping y paridad, 10 = 0 y 1.

1. Cinta magética: Fue durante mucho tiempo el medio para guardad datos a granel.
2. HDD: Progresivamente más barato por lo que su uso se ha extendido.
3. Almacenamiento óptico: Usan láseres para guardar y recuperar los datos, su principal desventaja es la degradación con el tiempo.
4. SDD: Utilizan circuitos integrados ensamblados.
5. Cloud backup: Utilizando proveedores de servicio.

### Recuperación

- Plan de recuperación de desastres: Su misión es restaurar los sistemas críticos de negocio a una condición normal o casi normal después de un incidente.

#### Instalaciones de procesamiento alternativas

Esto se perdió en un commit, pongo un resumen temporal.

1. Cold site: Tiene toda la infraestructura física (espacio, ventilación, etc.), pero no dispone del hardware, por lo que el RTO y RPO son muy altos.
2. Warm site: Punto intermedio, tiene la infraestructura física y algunos elementos del hardware, pero sin configurar, por lo que en caso de desastre es necesario llegar e instalar. El RPO y RTO puede ser de unas horas.
3. Hot site: Una copia exacta de la configuración utilizada en la sede original, lista para utilizarse en el instante de un desastre. Es costosa de mantener y a veces se comparte.
4. Acuerdo recíproco: Algunas empresas acuerdan mantener infraestructura extra entre ellas para en caso de desastre compartir los recursos temporalmente.

### Virtualización

Un problema de la recuperación de hardware es que a lo mejor esos equipos no tienen garantía de estar disponible o siquiera ser posible duplicar dicho hardware y que desplegar una copia en un hardware diferente puede llegar a ser muy complicado.

La virtualización establece una estandarización de recursos sin importar el hardware real sobre el que se montan. Permite una operabilidad más rápida, flexibilidad de hardware y es más sencilla de operar.

Como problemas, la integridad y confidencialidad aumentan en importancia, es necesario disponer de un ancho de banda amplio para el flujo de datos de replicación y requiere unas capacidades de gestión mayores.

#### Ciclo de vida típico

1. Se hace una solicitud de nuevo servidor al departamento TI.
2. De la pool de recursos se reserva y provisiona la máquina virtual.
3. Una vez iniciada se proveee el servicio solicitado en la VM.
4. Un tiempo más tarde se liberan los recursos.

Para provisionar una máquina virtual existen dos formas:
- Instalando el sistema directamente, clonando una VM o importando un servidor físico.
- Creando una plantilla preconfigurada.

#### Migración

- Servicio de migración: Es el proceso de mover una máquina virtual entre localizaciones, en este proceso todas las características de la máquina son completamente virtualizadas.
- Live migration: Migración en tiempo real, se trata de desplazar una VM entre distintos equipos físicos mientras se mantiene encendida. Usado para el balanceo de carga y el mantenimiento proactivo.

Pasos:
1. Pre-Migration: Existencia de la máquina.
2. Reservation: Se hace una solicitud de reserva de recursos desde la máquina A a la máquina B.
3. Iterative Pre-Copy: Durante la primera iteración se transfieren todas las páginas, en las siguientes iteraciones se copian aquellas corruptas en la transferencia.
4. Stop-and-Copy: La instancia A se suspende y el tráfico se redirecciona a la máquina B. El estado de CPU y cualquier inconsistencia se transfieren.
5. Commitment: B le transmite a A que la imagen es consistente, A confirma el commit, A descarta la VM y B se convierte en el host primario.
6. Activation: Código post migración se lanza para fijar drivers a la nueva máquina y anunciar el movimiento de la IP.

### Computación en la nube

Utilizan las ideas de migración y máquinas virtuales de forma dinámica adaptando los recursos a través de la red según los requisitos.

La computación en la nube se construye sobre un Service-Oriented Architecture (SOA), malla y tecnología de virtualización. Se trata de un servicio web desplegado en sedes especializadas.

Tipos de cloud: SaaS (Web, aplicaciones), PaaS (Desarrollo, frameworks), IaaS (Gestión de infraestructura virtual, servicio de infraestructura, servidores).

#### Modelos de despliegue

- Cloud Pública: Proporcionado por una tercera empresa, no se gestiona nada los datos se guardan y procesan en sus datacenters.
- Cloud Privada: Reside en la propia intranet de la compañia, normalmente se trata de un entorno virtualizado y se encuentra protegido por un firewall. Permite una mayor seguridad, mejora el balanceo de carga y mayor control de los datos que el resto de modelos.
- Cloud Híbrida: Cuando recursos de una cloud pública se utilizan desde una cloud privada o se usan en conjunto. Los recursos críticos se guardan en privado y los no esenciales en la nube pública.

- Amazon Elastic Compute Cloud (EC2): MUCHO TEXTO

#### BCM en Cloud privada

La organización mantiene el control de la seguridad, configuración y operación del sistema, tiene acceso limitado y gestión interna.

La virtualización es la base de la nube privada, aporta flexibilidad, continuidad operativa y aprovechamiento del hardware al estandarizar los recursos LÓGICA Y YA ESTÁ EXPLICADO.

Para prevenir contingencias se usan dos o más servidores de virtualización operando en Cold standby (copia idéntica apagada), Warm standby (Listo para encenderse pero sin uso) o Hot standby (Sincronizado en tiempo real). También existe la alta disponibilidad, el hipervisor replica continuamente la memoria en otro host, pero es costosa.

Replicar los datos entre sedes mejora la continuidad, pero requiere buena conectividad tanto para el proceso de backup como para la restauración. Esto puede dar conflicto con el negocio en empresas pequeñas.

#### BCM en Cloud híbrida o pública

La nube híbrida o pública permite externalizar servidores completos o servicios específicos, gracias a esto se pueden lograr altos niveles de disponibilidad y mínimos tiempos de pérdida. Es esencial mantener una conexión cifrada y segura desde la sede privada.

Opciones: Infraestructura como Servicio (IaaS), Plataforma como Servicio (PaaS), Software como servicio (SaaS), Seguridad como Servicio, Backup remoto (BaaS) o Recuperación de desastres como servicio (DRaaS).

Si los sistemas alquilados son virtuales se trata de IaaS, pudiendose usar como respaldo u operaciones diarias. Aunque mejora la protección, redundancia y las copias de seguridad, incluye una mayor latencia e introduce retos de seguridad de la información. Una variante utilizada es usar el proveedor como nodo central para replicar datos entre sedes.

## Tema 6: Gestión de Incidentes

### Conceptos

¿Qué es la gestión de incidentes?

Es el proceso para detectar, reportar, valorar, responder a, tratar con y aprender de los incidentes de seguridad de la información. El objetivo es garantizar que los eventos de seguridad se comuniquen de forma que se apliquen las acciones correctivas en el tiempo oportuno. Aunque el foco debe serguir siendo la prevención, se debe contar con la capacidad de reacción.

Vocabulario:
- Amenaza: Causa potencial de un incidente no deseado que puede resultar en daño en los sistemas u organizaciones.
- Evento: Ocurrencia o cambio de un conjunto particular de circunstancias, puede ocurrir una o varias veces y puede tener varias causas.
- Evento de seguridad de la información: Ocurrencia identificada de un estado en un sistema, servicio o red que indica una posible brecha de seguridad de la información, de las políticas, una falla de los controles o una situación desconocida que puede ser relevante a la seguridad.
- Incidente de seguridad de la información: Uno o varios eventos de seguridad de la información no deseados que comprometen las operaciones del negocio y por ende amenazan la seguridad de la información.
- Vulnerabilidad: Debilidad de un activo o control que puede ser explotada por amenazas.
- Equipo de respuesta a incidentes "IRT": Equipo de personas confiables y con habilidades apropiadas para manejar los incidentes durante su ciclo de vida. CERT (Equipo de respuesta a emergencias en computadores) y CSIRT (Equipo de respuesta a incidentes de seguridad en computadores) son términos comunes.
- Punto de Contacto PoC: Función o rol organizacional definido que sirve como coordinación o punto focal de información en todo lo concerniente a las actividades de gestión de incidentes.

#### Activos

Son los recursos que usa un SGSI par que las organizaciones funcionen y consigan los objetivos que se han propuesto por la alta dirección. Representan algún valor para la organización y se encuentran interrelacionados.

Clasificación de activos: De información pura (Datos digitales, activos intangibles y tangibles, software y SOs), Activos físicos (Infraestructura TI, Controles, Hardware y Activos de servicios TI), Activos humanos (Empleados y externos).

Valoración de los activos:
- Confidencialidad:
- Integridad:
- Disponibilidad:
- Trazabilidad:

#### Incidente de seguridad

Se define como incidente de seguridad cualquier evento que se produzca de forma accidental o intencional, que afecte o ponga en peligro las tecnologías de la información o los procesos que con ellas se realizan (los activos).

Los incidentes no ocurrirían si el presupuesto de seguridad fuera ilimitidad y el personal estuviera formado de forma perfecta. Aún así pueden cometerse errores, por lo que se desarrollan procedimientos estándares para responder a dichos incidentes.

Tipos de incidentes:
- Contenido abusivo: Spam.
- Contenido malicioso o malware: Software o firmware desarrollado para infiltrarse en un equipo o dañarlo sin conocimiento ni consentimiento del propietario.
- Obtención de información.
- Acceos indebido o intrusión.
- Disponibilidad: Ataques que impiden el acceso a un sistema.
- Seguridad/Confidencialidad de la información: Problemas relacionados con el acceso a información y/o modificación no autorizada.
- Fraude: Usos no autorizados, phishing y suplantación.
- Helpdesk: Consultas técnicas.
- Otros: No contrastadas.

Procedencia de las amenazas: Crimer organizados, Agentes gubernamentales, Hacktivismo, Amenaza interna.

Clasificación de los incidentes: Los parámetros más usados son la gravedad, el daño originado a la organización y el carácter de urgencia que la misma considera para dar solución al daño. Para cada incidencia registrada y considerando ambos factores se establece un orden de prioridad para gestionar incidencias de seguridad.

#### Respuesta a un incidente

- Consiste en controlar y minimizar cualquier tipo de daño a la organización y su información, preservando evidencia de lo ocurrido y documentado. Esto permite conocer el contexto, determinar su origen y posibles consecuencias.
- Coordinar las actividades para una recuperación rápida y eficiente de los procesos afectados, en conjunto con los equipos de TI, de manera que la organización pueda operar con normalidad en el menor tiempo posible y el menor impacto tolerable.
- Prevenir que eventos similares puedan ocurrir en el futuro erradicando la raíz del incidente, junto con el mantenimiento de una base de conocimiento que permita registrar lecciones aprendidas.
- Compartir información relacionada con incidentes de seguridad con otros CSIRT, con fines de difusión y prevención.

#### Resiliencia o ciber-resiliencia

- Resiliencia: Cualidad intrínseca de una organización que le permite enfrentarse de forma exitosa a cambios y eventos.
- Ciber-resiliencia: Capacidad de una empresa de adaptarse y continuar con sus funciones y su trabajo en situaciones de riesgo. Cómo gestionar la situación de forma eficiente.

#### Estado del arte de la ciber-resiliencia

TEXTO TEXTO TEXTO

#### Estrategia internacional en ciberseguridad

- Unión Europea: Establece cinco prioridades, la ciber-resiliencia, la reducción de la delincuencia en la red, el desarrollo de una política de ciberdefensa y capacidades correspondientes en el ámbito de la Política Común de Seguridad y Defensa (PCSD), el desarrollo de los recursos industriales y tecnológicos y el establecimiento de una política internacional coherente del ciberespacio en la UE.
- España: Aprobada en 2013 y actualizada en 2019, tiene alcance global y busca la aplicabilidad en Administraciones públicas, Empresas y Ciudadanos. No afronta directamente la Gobernanza y un Sistema de indicadores de ciberseguridad, pero si existe una estandarización de indicadores basados en el ENS.

#### Organismos de Seguridad en España



#### Organismos de Gestión de incidentes



#### Tratamientos de los incidentes



#### Actividades contempladas en un PRI



#### 1. Constitución del equipo de respuesta



#### Equipos de respuesta a incidentes de seguridad



#### SOC y CSIRT



#### Responsabilidades en los incidentes



#### 2. Guía de procedimientos



#### 3. Detección de un incidente



#### 4. Análisis de un incidente de seguridad



#### 5. Contención, erradicación y recuperación



#### 6. Identificación del atacante y posibles actuaciones legales



#### 7. Comunicación con terceros y relaciones públicas



#### 8. Documentación del incidente de seguridad



#### 9. Análisis y revisión a posteriori del incidente


### Nist-ISO. Incidentes y su respuesta



Frameworks:
- ISO 27035:
- NIST 800-61:
- SANS:
- RFC 2350:
- ENISA:
- ISACA:

#### NIST 800-61



#### Plan de respuesta ante incidentes



#### SOP



#### Fase 1: Preparación



#### Fase 2: Detección y análisis



#### Fase 3: COntención, erradicación y recuperación



#### Fase 4: Actividad post-morten



#### Compartición de información y coordinación



#### VERIS



#### ISO 27035



#### ISO 27035-2



#### ISO 27035-3



#### ISO 27035 vs NIST 800-61



#### Compartición de información NIST e ISO



#### Notifiación de un incidente en España



### Linea Temporal

Puntos clave en la respuesta a incidentes: Elaboración de una línea temporal, seguimiento de las evidencias y presentación de los resultados de manera continua o al final del incidente con un informe final.

#### Elaboración de la línea del tiempo

Es un documento donde se recogen todos los eventos que se creen relevantes para el análisis del incidente, siendo de obligada inclusión los timestamps de cada uno. Busca formar un relato de lo ocurrido en el incidente, correlación de datos y colaboración de equipo.

#### Datos relevantes por cada evento

- Timestamp: Representa el momento temporal de ocurrencia.
- Relevancia: Importancia del evento según su criticidad.
- Hostname/IP.
- Tipo de artefacto: Artefacto forense del cual se extrajo la información (eventos, logs, etc.)
- Detalles del artefacto: Datos específicos sobre el tipo de evento.
- Usuario: Usuario relacionado.
- Detalles: Datos relevantes pero no son recogidos por el resto de columnas.
- Comentario: Cualquier comentario considerado relevante.
- Evidencia: La evidencia de la cual se extrajo, incluyendo path completo si es posible.
- Analista: Nombre o iniciales de quien agregó el evento.
- Fecha agregado: Cuando fue agregado el evento a la timeline.

#### Presentación de resultados

Es importante generar documentación para comunicar los resultados. Existen varios tipos de presentación: Continuo, Parcial (informes regulares) y Final (todos los pasos)

La timeline es una herramienta interna que no se suele presentar en crudo.

#### Presentación de informe final

Informe escrito por el equipo de respuesta que recoge todos los detalles del mismo. Habitualmente incluye contexto del incidente, sumario ejecutivo con detalles relevantes y un apartado técnico.

### SIEM (Seguridad de la Información y Gestión de Eventos)

- SIM (Security Information Management): Sistema de gestión de recursos que incorpora toda la información, recolecta y almacena logs.
- SLM/SEM (Security Log/Event Management): Sistema de monitorización en tiempo real, notificaciones y dashboards.
    - SEC (Security Event Correlation): Busca patrones en los registros de seguridad de fomra que se detecten eventos que de otra forma serían independientes.
- SIEM (Security Information and Event Management): Todo lo anterior unificado. 

#### Funcionamiento de un SIEM

Gestión de logs más correlación de eventos, más alertas y notificaciones, más respuesta activa, más seguridad a nivel endpoint, más chequeo de normativa, más informes y cumplimiento.

Flujo de datos:
1. Generación de eventos.
2. Recolección de eventos.
3. Transporte de eventos: Uso de protocolos seguros como TLS.
4. Normalización y Enriquecimiento: Los eventos se transforman y enriquecen con datos adicionales.
5. Correlación y análisis: Los datos se almacenan para análisis histórico y cumplimeinto.
6. Alertas y Respuestas: Generación de alertas y posibles acciones automatizadas.

- Recolección de logs: Los logs vienen de fuentes como Syslog (protocolo estándar para envío de mensajes de log en red IP), Windows Event Forwarding (WEF, tecnología nativa de windows para eventos de seguridad), Agentes propiertarios (Propios del SIEM), APIs y SDKs (integración entre aplicaciones y SIEM) y capturas del tráfico de red (Network TAPs, Switched Port Analyzer SPAN).
- Normalización y enriquecimiento: Es esencial procesar los logs para su análisis y correlación, esto implica normalizarlos a un formato común mediante técnicas (regex). El resultado son esquemas comúnes de datos (ECS, CEF) los cuales se pueden enriquecer.

#### Correlación de eventos

- Reglas de correlación: COnjuntos de condiciones predefinidas basadas en eventos, requiere mantenimiento continuo.
- Análisis Estadístico: Evaluación de desviaciones respecto a patrones normales, puede generar falsos positivos.
- Análisis de comportamiento: Monitorización de actividades de usuarios y entidades (UEBA), requiere conjuntos de datos significativos y puede ser dificil de interpretar.
- Análisis de anomalías: Detección de eventos inusuales o inesperados, igual que el anterior machine learning.

#### Integraciones

- Con fuente de inteligencia: INdicadores de compromiso (IoCs, direcciones IP, hashes, URLs, etc.), Información contextual (Tácticas, técnicas y procedimientos, vulnerabilidades, etc.), Metadatos y contexto (Confianza y puntaje de riesgo, fecha y hora, etc.).
- Con un EDR (Endpoint Detection Response): Monitoriza y analiza actividades en los dispositivos finales para detectar comportamientos y responder, proporciona información granular sobre procesos, conexiones, cambios en archivos y actividad. Permite acciones como aislamiento de dispositivos, terminación de procesos o remediación de amenazas en tiempo real. El SIEM puede enviarle instrucciones.
- Con SOAR (Security Orchestration, Automation and Response): Orquesta tareas de seguridad para mejorar la eficiencia en la respuesta a incidentes, la integración se logra de manera directa, el SOAR consume datos y alertas del SIEM.

#### Desafíos tecnológicos de un SIEM

- Almacenamiento: Gran volumen de datos y alta velocidad en ingesta y consumo de información. Soluciones: Tecnología Big Data, Filtrado y agregación de datos, Almacenamiento jerarquizados, compresión y políticas de retención inteligentes.
- Procesamiento: Solición en arquitecturas distribuidas y paralelas.
- Dificultad en afinamiento de reglas: Puede dar falsos positivos, por lo que requiere afinación continua de reglas, uso de inteligencia artificial y machine learning y contextualización y enriquecimiento de datos.

#### Securización de un SIEM

Se trata de un objetivo atractivo debido a su sensibilidad y valor de información. Medidas: Autenticación fuerte, RBAC, Auditoría de accesos, cifrado de datos, integridad, etc.

#### Herramientas internas de un SIEM

Internamente el SIEM utiliza:
- Nmap: Network mapper por excelencia.
- PRADS: Sistema pasivo de detección.
- Fprobe: Convierte tráfico en flujos netflow.
- NFSen: Convierte NetFlow en representación gráfica.
- OSSec: LIDS (Log-based Intrusion Detection System) o HIDS (Host Intrusion Detection System).
- Suricata: IDS vs IPS.
- OpenVAS o Nessus: Escaner de vulnerabilidades.

#### Extras



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
