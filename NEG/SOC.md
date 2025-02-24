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



#### CIO



#### CISO



#### CEO



#### Analista de seguridad



#### Ingenieros de seguridad



#### Arquitectos de seguridad



## Operación de un SOC

### Respuesta a incidentes



### Métricas



#### Clasificación de vulnerabilidades



#### Clasificación de activos



#### Histórico de parches



### Inteligencia



#### Blacklist



#### Bases de datos externas



#### Organizaciones y partners industriales

## Outsourcing del SOC



### Tipos de MSSPs



### Ventajas y desventajas



### Requisitos



### Prestación de servicios