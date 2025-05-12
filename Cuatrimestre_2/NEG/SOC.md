# Apuntes del Examen

Clase 1...

Ideas tratadas en clase:

- Análisis de mercado : Donde investigar, 
- Análisis DAFO
- Resumen: Entrega del 21 de febrero.

- Modelo CANVAS: Tipos de Mercado, Algo, Canales de comunicación/Distribución/Postventa, Relaciones, Ingresos, 


# SOC

## Introducción a los SOC

### Funciones y herramientas

Tipos de centros de operaciones: EOC (Emergency Operations Center), MOC (Mission Operations Center), TOC (Tactical Operations Center), NOC (Network Operations Center).

SOC es un centro de operaciones de seguridad.

#### Funciones de los centros de operaciones

- Monitorización y gestión de los activos de la empresa en tiempo real.
- Securización y fortificación de activos.
- Respuesta a amenazas proactiva y/o reactivamente.
- Toma de decisiones frente a amenazas/incidentes/problemas.
- Recuperación y mantenimiento del negocio.
- Evaluación del riesgo y cumplimiento normativo.
- Reporting y procesos de mejora.

**Importante**: Velocidad de respuesta y posibilidad de toma de decisiones, para ello fundamental la formación, los medios y formar parte de la estrategia de la organización.

#### Ejemplos de servicios y funciones y herramientas de un SOC.

- Servicios: Database monitoring, Database monitoring, File integrity monitoring, Netflow analysis, Log management, DDOS mitigation, Encryptation services, Host hardening, Disaster recovery, Mobile device recovery, Malware impact analysis, Penetration testing, Forensic analysis, Fraud detection, Metrics and reporting, Policy and compliance, Risk evaluation.
- Herramientas: SIEM (Security Information & Event Management), Service Management (Ticketing), Network Flows tools, Packet Capture tools, IDS/IPS, Securing network devices, Hardering hosts devices, Digital Forensics tools, Malware Prevention, Report tools, Inventory assessment, Vulnerability-Assessment, Risk Rating, Risk-Assessment.

### Implementación de un SOC

Para poder implementar un SOC es necesario la transferencia de información (estrategia, procesos, políticas), conocimiento de cada sistema y dispositivo y establecimiento de la cadena de mando y comunicación.

El problema es que la seguridad está vista como un gasto, muchas empresas invierten en máquinas como IDS, FW, etc. Pero no en su vigilacia, gestión, mantenimiento o formación de los equipos.

- Formas de implementar un SOC: On-premise, Hybrid y Outsourcing.
- Criterios clave para tomar la decisión:
    - Medios y formación propia.
    - Políticas, procesos y documentación maduras.
    - Situación financiera.
    - Tolerancia al riegos.

### Fases de la Implementación de un SOC On-Premise

- Fase 1 (Tecnología): Personal encargado de analizar la organización para ver que herramientas, donde y cuantas se deben desplegar para obtener datos para el SOC
- Fase 2 (Securización): Securización, actualización y documentación de equipos. Conflictos por el control de equipos entre SOC y equipo TI.
- Fase 3 (Políticas): Revisión de la política de seguridad de empresa (uso de equipos, datos e internet). Mejor basarlo en estándares como ISO 27002. Definición de necesidades y procedimiento de comunicación.
- Fase 4 (Operación): Monitorización de los equipos, testeo y respuesta a incidentes. Permite conocer como funciona la organización y cómo aplicar los cambios previstos en la política de seguridad.
- Fase 5 (Inteligencia): Uso de herramientas de inteligencia que puedan actuar de forma proactiva anticipándose a los problemas.

### Inputs de un SOC

#### Eventos

Los eventos son observaciones registrables y pueden generarse de un log u otras fuentes de entrada

Muchos eventos pueden ser configurados para habilitar una notificación (alerta). Son eventos de interés que deben ser vigilados y pueden requerir intervención. Esta programación se realiza normalmente en el SIEM.

Muchas alertas pueden generar incidentes que deben ser registrados, normalmente en la herramienta de ticketing o Service Desk (CAU-CSD). El número de alertas debe ser reducido para no saturar el SOC.

#### Problemas

Uno o más incidentes sin raíz identificada y repetibles en el tiempo se convierten en un problema. La gestión de problemas se preocupa en investigar y solucionar la causa raíz de los incidentes y encontrar así soluciones permanentes.

La gestión de problemas puede no ser trivial y son decisivas herramientas de inteligencia como correlación, machine learning o deep learning.

## Infraestructura de un SOC

- Infraestructura de seguridad en la organización: Dispositivos que permiten mantener la confidencialidad, disponibilidad e integridad de la información como los Network Access Control (NAC), los IDS o los Data Loss Prevention (DLP).
- Infraestructura de seguridad en el SOC: Dispositivos y herramientas que permiten revisar y analizar la información recibida por el SOC.
    - Sistemas de gestión de eventos de seguridad, herramientas de gestión de incidencias y herramientas de ayuda instaladas en servidores específicos y propios del SOC.

### Fuentes de datos

Las principales fuentes de datos son los logs y el SIEM.

Los logs nos permiten realizar un triage y posterior diagnóstico de muchas amenazas/anomalías:
- Errores hardware
- Servicios con anomalías
- Fallos de autenticación
- Registro de tareas de administración
- Sistemas a los que se accede y acciones realizadas

#### Logs

Aspectos importantes a tener en cuenta con logs:
- Monitorizar el log para garantizar que está funcionando correctamente. Vigilar creación, borrado, acceso.
- Revisar almacenamiento y rendimiento. Es necesario configurar el correcto nivel de log en cada sistema.
- Sincronización temporal (TMP).
- Proteger la información sensible que no debe aparecer en logs.
- La información debe clasificarse en niveles de severidad para posteriormente poder filtrarla (debug, information, warn, error y fatal).

Los logs pueden suarse para detección de fraudes, análisis forense, auditorías o necesidades normativas (PCI, SOX, HIPAA).

logs de sistemas + logs transaccionales + correlación + análisis = SIEM.

El SIEM puede llevar a cabo tareas y detecciones más complejas derivadas de los procesos de correlación e inteligencia.

### Ticketing Systems

La herramienta de ticketing (Help Desk y/o Service Desk) puede contar con una base de datos de activos y una base de datos de conocimientos con información acerca de verdaderos positivos frente a falsos, relacionando los tickets involucrados.

El triage es el proceso de puntuación y ranking.

El sistema de ticketing también permite diseñar el proceso a seguir y los pasos del workflow de resolución que pueden ser vitales para reducir impacto y tiempo.

El ticket sirve para aglutinar toda la información relativa al ataque (pantallazos, logs, flujos de red...). Los sistemas de ticketing tienen también la facilidad de parsear eventos raw para incorporarlos, facilitando la búsqueda y visualización.

#### Implementación de un Ticketing System

La herramienta de ticketing permite filtrar por diversos campos y utiliza colores y efectos visuales para relatar los estados y transiciones de los eventos.

Es necesario seguir una política de etiquetado del asuto de los tiquets para determinar origen, tipo, severidad, etc...

Muchas veces el timestamp de un ticket es muy posterior al evento o amenaza y es necesario correlacionarlos.

## Estructura organizativa de un SOC

La ubicación del SOC dentro de la organización debe proporcionar la capacidad de influir en las decisiones de la organización que permitan mitigar y recuperar de forma óptima la actividad en una organicación. Es importante la velocidad de la respuesta y la posibilidad de toma de decisiones, para ello es fundamental los meedios, la formación y formar parte de la estrategia de la organización.

#### CIO

Director de sistemas de información: Es el máximo responsable del departamente IT y en algunos casos, del SOC. Muchas veces sus decisiones y planes añaden amenazas de seguridad y pueden introducir grandes riesgos en la organización. En ocasiones prima la reducción de costes y tiempo, frente a las necesidades de seguridad.

#### CISO

Director de seguridad de la información: Es el máximo responsable de la seguridad y por tanto del SOC. Responsable por las decisiones de seguridad corporativa, tanto de seguridad física como de las instalaciones, cumplimiento normativo y la continuidad del negocio. Mantiene la dirección informada delos riesgos y decisiones de seguridad que se toman.

#### CEO

Director ejecutivo: Se coordina, informa y planifica directamente con el CISO.

#### Analista de seguridad

- Forma la primera línea de staff.
- Responde a las fuentes de datos (teléfono, mail...).
- Revisa los eventos y alertas y realiza el primer triage.
- Dos niveles:
    - Analistas de primer nivel o junior, encargados de abrir los tickets y analizar que está ocurriendo siguiendo un procedimiento estricto.
    - Analistas de segundo nivel o senior, tratamiento de tickets escalados que necesitan un análisis más detallado o experimentado.

#### Ingenieros de seguridad

- Normalmente especializados en necesidades específicas de la organización, como IDS, proxy, Data Loss Prevention...
- Encargados de crear las reglas en el SIEM y en otros sistemas que permitan generar alertas. Ajuste de estas reglas para evitar falsos positivos.
- Revisión de los tickets cerrados por los analistas para verificar su calidad y mejorar el proceso.
- Formar a los analistas para favorecer el triage y cierre de casos "normales".

#### Arquitectos de seguridad

- Determinación de los requerimientos, planificación y seguimiento de los sistemas de seguridad con vistas a alcanzar los objetivos de la organización. Visión de alto nivel. 
- Asegurar que las incorporaciones tecnológicas van a ser bien gestionadas por el SOC, que están bien integradas con las herramientas y que ha recibido el correcto soporte y formación. 
- Responsable del análisis de riesgos, pruebas de vulnerabilidad, evaluación de seguridad e implantación de arquitecturas y plataformas de seguridad. 

## Operación de un SOC

### Respuesta a incidentes

La respuesta a incidentes debe seguir un proceso repetible, eficiente y lógico, que se basa normalmente en los siguientes pasos:  => Detección => Confirmación <=> Análisis <=> Contención => Recuperación <=> Revisión <=

### Métricas

Alguna métricas sobre el día a día del SOC, facilitan información sobre posibles problemas:
- Métricas sobre cumplimiento de SLA u objetivos.
- Estado de los tickets con prioridad alta.
- La duración de resolución de un determinado tipo de tickets puede denotar falta de formación o necesidades especiales en ese ámbito.

Gestión y monitorización de las colas de tickets. Falacia de la evidencia completa o "cherry picking" al seleccionar ciertos tickets más amigables o conocidos.

#### Clasificación de vulnerabilidades

Es necesario clasificar las vulnerabilidades para poder medir su posible impacto/riesgo (Simple, PCI, Severidad, CVSS).

CVSS es un sistema de clasificación público que permite valorar la gravedad de una vulnerabilidad de 0 a 10 (minor update 3.1 17/6/19).

La base de datos de vulnerabilidad nacional (NVD) es un repositorio de vulnerabilidades del gobierno USA, proporciona puntuaciones CVSS para casi todas las vulnerabilidades conocidas.

#### Clasificación de activos

Para dar respuesta eficaz a un posible ataque es necesario tener clasificados todos los activos y priorizarlos en base a unos criterios. Es necesario llevar un control  de las estadísticas de esos activos pues van a marcar la eficiencia de las contramedidas. Es un paso fundamental en los mecanismos de *disaster recovery* y planes de continuidad de negocio.

El punto de vista de los ingenieros puede ser muy diferente al del resto de departamentos como p.e los financieros. Es recomendable tener en cuenta la ISO 27001 y/o otros estándares internacionales específicos, como NERC CIP (industria de la energía eléctrica), IEC 62443 (control industrial) o NIST 800-82 (control industrial). Herramientas como Cyber Integrity pueden ayudar a gestionar y clasificar los activos. 

- Criterios de clasificación:
    - Impacto en los clientes o en el negocio
    - Impacto financiero de la caída o pérdida de servicio
    - Requisitos de alta disponibilidad (24x7)
    - Impacto en la seguridad
    - Tiempo medio entre fallos y probabilidad de fallo
    - Tiempo de sustitución de piezas o partes
    - Valor de reemplazo
    - Número de usuarios
    - Almacenamiento de información crítica
    - Impacto en la reputación de la organización.

#### Histórico de parches

Es necesario llevar a cabo una monitorización del historial de parches aplicados. Podremos saber el porcentaje de parches no aplicados en activos críticos.

### Inteligencia

La inteligencia se basa en el análisis de una gran colección de información externa (conoce al enemigo) e interna (conócete a ti mismo). El SOC puede tomar decisiones de protección como:
- Limitar el espacio de IPs que no pueden acceder a los servicios de la organización. En otros casos, es una buena política clasificar las IP exteras que acceden a la VPN, proxy, etc.
- Incorporar listas de IPs desde donde se hace spam o botnet, usar mecanismos de reputación, detectar actividad P2P, etc.
- Usar colecciones de información acerca de ataques, para detectar comportamiento o tráfico anómalo.

#### Blacklist

Los blacklist facilitan el reconocimiento de orígenes problemáticos en cuanto a spam, malware, etc.

También se puede incluir en la lista URIs que contienen tipicamente lugares de phising, pharming, etc. Sitios que capturan información personal o comprometida.

Otra opción es analizar el patrón y contenido p.e de los emails para detectar ataques que han ido modificando su dirección de mail, nombre e IPs, por lo que pueden no ser detectables por las blacklist. 

El estudio de ataques previos también puede facilitar la creación de blacklist propias.

#### Bases de datos externas

Muchas organizaciones y fabricantes comparten su información sobre ataques y amenazas para promocionar sus productos o informar a sus clientes. Por ejemplo:
- https://atlas.arbor.net: recursos públicos sobre vulnerabilidades 
detectadas por los productos de Netscout.
- http://www.securityfocus.com: Vulnerabilidades publicadas por Symantec.
- http://senderbase.org: reputación en tráfico de email (Cisco).
- http://spamhaus.org: Bases de datos en tiempo real de direcciones IP de PC secuestrados por exploits (XBL list).También listas para email (SBL list) o reputación de dominio (DBL list).

#### Organizaciones y partners industriales

En ocasiones pagar por información sobre seguridad puede ser necesario para tener un conocimiento más exacto de ciertos tipos o grupos de ataques. En esta línea están los Advanced Persistent Threat (APT), ataques muy elaborados, sofisticados y persistentes en el tiempo para el espionaje, afección de cadenas de suministro, ingeniería social, etc...

También es interesante participar en organizaciones que proporcionan recursos comunes y comparten información sobre seguridad como las Information Sharing and Analysis Center (ISAC) en distintos sectores industriales.

## Outsourcing del SOC

En primer lugar hay que definir que tipo de operaciones se van a externalizar y verificar que las funciones externalizadas no se van a solapar con las internas. Los servicioes de seguridad gestionada (MSS) pueden tener diferentes niveles de prestación: Analistas de seguridad, ingenieros especialistas de seguridad para IDS, gestión remota del perímetro, respuesta a incidentes, gestión de vulnerabilidades y parches...

### Tipos de MSSPs

La elección de un tipo u otro depende de la estrategia tecnológica, situación financiera y tolerancia al riesgo. Tipos:
- Strategic partners: Con experiencia previa y relaciones en el mundo de IT. La seguridad puede no ser su punto fuerte o no disponer de lo que se necesita.
- Pure play providers: Específicamente dedicados al negocio de la seguridad. Formación, competencia y precio en consecuencia.
- Boutique providers: Pequeños MSSPs orientados a un área específica de la seguridad (vulnerabilidades, gestión de red, gestión de email, DNS...)

### Ventajas y desventajas

#### Ventajas

- Un MSSP está diseñado para tratar con muchos tipos de eventos, está entrenado y formado para dar respuesta rápida en situaciones de estrés y cuenta con gran experiencia en la gestión de eventos de todo tipo de forma efectiva y eficiente. Cuentan con especialización vertical en muchos casos.
- El coste, en la mayoría de los casos, es mucho menor a tener un SOC propio (recursos humanos, tecnológicos, licencias, configuración y mantenimiento, formación, etc) además del dinamismo de este tipo de actividades (formación continua, certificaciones, etc…). Gestión 24/7.
- Supresión de los "reinos de taifas" en la monitorización y gestión del equipamiento. Coordinación de diversos departamentos involucrados.
- SLAs: El tiempo es un factor diferencial entre un sistema salvaguardado y otro atacado. Los MSSPs trabajan en función del nivel y tipo de servicio, garantizando los SLAs como factor fundamental.
- Documentación: Los procedimientos de un MSSP suelen estar bien documentados, las políticas bien definidas y los procesos internos bien documentados. Además genera reportes periódicos sobre su actividad que son revisados y actualizados constantemente.

#### Desventajas

- El MSSP puede tener un elevado número de clientes, esto dificulta el conocimiento de cada uno de ellos en particular, aunque facilita el general.
- Falta de recursos dedicados: En caso de una crisis con múltiples empresas, sectores, clientes afectados, tu organización es una más y pueden no ser suficientes los recursos involucrados para atender a todos los clientes simultáneamente.
- Problemas de almacenamiento de datos: capacidad, privacidad, problemas regulatorios del almacenamiento de datos, persistencia de los datos...

### Requisitos

- Antes de contratar un outsourcing es conveniente indagar que recursos técnicos, humanos y documentales va a ser necesario involucrar. Que cambios en mi red, sistemas y hosts son necesarios llevar a cabo. Entrega de documentación, automatizaciones, etc...
- Asegurar la certificación y formación del personal que va a suministrar el servicio.
- Asegurar que cuente con un adecuado balanceo entre tamaño y experiencia. A mayor tamaño más estabilidad pero menor personalización.
- Definir cómo se va a llevar a cabo la ejecución del servicio, cómo serán los canales de comunicación y que se va a comunicar.
- Que herramientas y portales de información o autoservicio va a poner a disposición del cliente y que se puede obtener en ellos.

### Prestación de servicios

Otro de los procesos importantes a tener en cuenta es cómo será el proceso de Disaster Recovery y cual es el plan que ejecutará el MSSP en los diversos escenarios que pueden suceder.

Del mismo modo es importante tener claro como va a ser la estrategia de salida o cambio de MSSP. Determinar el procedimiento de fin de contrato.