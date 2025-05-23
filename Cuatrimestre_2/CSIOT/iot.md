# Tema 1 : Introducción a la Ciberseguridad Industrial

## Conceptos básicos

#### Ciberseguridad Industrial

Disciplina de la ciberseguridad que incluye el conjunto de acciones para la protección y ataque sobre la seguridad de usuarios y entidades pertenecientes.

#### Infrestructura Crítica

Infraestructura indispensable que no permite soluciones alternativas, por lo que su perturbación tiene un gran impacto en los servicios esenciales.

#### Servicio Esencial

Aquel necesario para el mantenimiento de las funciones sociales básicas, salud, seguridad, bienestar social y económico o administración pública.

#### Infraestructuras estratégicas

Instalaciones, redes, sistemas y equipos físicos sobre los que funcionan los servicios esenciales.

#### Política de seguridad industrial

Conjunto de actividades destinadas a asegurar la funcionalidad, continuidad e integridad de las infraestructuras industriales con el fin de prevenir, neutralizar y mitigar el daño de ataques. Tiene que garantizar la integración de las actuaciones llevadas a cabo.

## Ley PIC

Ley de protección de las infraestructuras críticas que se encarga de definir las infraestructuras estratégicas en España y de diseñar unas medidas de prevención y protección eficaces.

Aportaciones:
- Sistema Nacional de Protección de Infraestructuras Críticas.
- Marco normativo del Sistema de Planificación PIC.
- Catálogo Nacional de Infraestructuras Críticas.
- CERT (Computer Emergency Response Team).

### Catálogo PIC

Información completa, actualizada y contrastada sobre la totalidad de las infraestructras estratégicas en territorio nacional. 3500 instalaciones de todas las áreas y contiene descripción, contacto, tipo, datos geográficos, localización, información de seguridad, riesgos evaluados, etc.

### Infraestructuras críticas

- Según EEUU: Gibraltar, Grifols, Gaseoducto Algeria.
- Galicia: Puertos y Refinerías.

## Implicaciones de los ciberataques en contornos industriales

- Cambios en sistema operativo o configuración de una aplicación: Introducción de canales de control, supresión de sistemas de alarma y cambios en comportamiento esperado y resultados.
- Cambios en la lógica de controladores industriales: Daño en equipos o instalaciones, mal funcionamiento de los procesos y deshabilitación de control.
- Envío de información errónea a operarios: Provoca acciones en respuesta a información errónea y puede ocultar actividades maliciosas.
- Alteración de los sistemas de seguridad tradicionales: Evasión de operaciones esperadas, backups o medidas de seguridad.
- Infección de software malicioso: Impacto en la producción al tener que detener el proceso y facilita el acceso a otros dispositivos.
- Robo de información: Extracción de secretos industriales.
- Alteración de información: Perjuicio de la farbicación de un producto.

## Ataques a infraestructuras industriales

- Australia 2000: Radiotransmisor contra aguas residuales.
- Aurora 2007: Control remoto de un generador Diesel (explosión).
- agent.btz 2008: Gusano que escanea el equipo y abre una backdoor instalado en bases militares estadounidenses mediante un pendrive.
- Operación Aurora 2009: Exploit Zero-Day de internet explorer que introducía un payload para extraer propiedad intelectual.
- Stuxnet 2010: Ataque sobre plantas nucleares iraníes que produce que las centrifugadoras giren sin control. Altera los PLCs Siemens mediante la inserción de un rootkit usando las contraseñas por defecto de SQL (Profibus), busca dispositivos que controlen la velocidad y que operen entre 800 y 1200Hz. Es capaz de firmarse a sí mismo.
- Night Dragon 2011: Descubierto por McAfee, extrae información sensible de empresas a través del acceso a servidores comporativos mediante SQL Injection.
- Shamoon 2012: Malware para Windows NT infiltrado en la red de Aramco que hizo que explotara una bomba lógica que sobreescribió los HDD de 30000 ordenadores. Aramco había gastado su presupuesto en los ICS, tuvo que comprar discos e hizo que subiera el precio.
- Smart Grid 2019: Primer ataque serio.
- Mayo 2020: Aprobación de una órden para proteger la red eléctrica EEUU.
- EEUU 2021: Ataque oleoducto.
- Salt Typhoon 2024: Ciberataque que accedió a ordenadores de múltiples empresas de telecomunicaciones, permitía leer metadats de llamadas, audios, SMSs e IPs. Se hizo famoso al robar comunicaciones de la presidencia americana.

# Tema 2 : Introducción a los sistemas ciberfísicos e IOT

Sistema Ciber-Físico: Sistema controlado y monitorizado mediante algoritmos computacionales y que se encuentra completamente integrado con internet y usuarios remotos.

IIoT: IoT en industria, conectar hardware industrial para mejorar eficiencia y automatización.

Cobots: Robots colaborativos.

## Hardware y Firmware

### Sensórica

Los sensores son sistemas de adquisición de datos mediante interfaces y multiplexores.

Tipos de sensores:
- Naturales: Responden con señales electro químicas basandose en el transporte de Iones.
- Artificiales: Señal eléctrico o fotónico.

Estímulo: Propiedad física convertida en señal, puede ser un voltaje/corriente/carga o una amplitud/frecuencia/código.

Transductor: Convierte un tipo de energía en otro, mientras que un sensor siempre a eléctrica.

Actuador: Cualquier elemento que actúe en respuesta a señales.

### Sensores y actuadores comunes

Tipos de sensores más comunes:
- Movimiento: aceleración y rotación en 3 ejes.
- Posición
- Ambientales: Temperatura, presión, humedad.
- Fisiológicos: Parámetros corporales.

Acelerómetro MEMS: Sensor basado en sistemas microelectromecánicos que detecta cambios en la velocidad usando micro-sensores y un microprocesador. Para vehículos.

Giroscopio: Se usa cuando no hay campo geomagnético y permite detectar la orientación actual o sus cambios a partir de la velocidad angular.

Magnetómetro: Sensor sensible al campo magnético de la tierra, también llamado compas. Mide en Teslas y permite navegación y realidad aumentada.

### Cloud

Los datos industriales se mandan a servidores con servicioes de automatización industrial en la nube

### Seguridad de CPS y sistemas IoT/IIoT

Los equipos IoT típicos tienen poca potencia computacional y suelen ser muy inseguros (sistemas sin parchear, poco cifrado...), por lo que son presa de ataques cibernéticos.

# Tema 3 : Ciberseguridad de Sistemas de Control y Comunicaciones Industriales

Un ICS (Sistema de Control Industrial) o IACS (Sistema de Control de Automatización Industrial) es un sistema formado por equipos interconectados que controlan, monitorizan y administran grandes sistemas de producción industrial. Suelen controlar infraestructuras críticas.

Sinónimos no correctos y áreas:
- PCS (Sistema de Control de Procesos) o PLC (Controlador Lógico Programable). Una unidad de proceso.
- DCS (Sistema de Control Distribuido). Localización individual.
- SCADA (Control de Supervisión y Adquisición de Datos). Área Grande Geográfica.

## PLC

Dispositivo electrónico que permite a los operarios tomar decisiones de control sobre elementos hardware. Creados en 1968 por General Motors para reemplazar los circuitos lógicos basados en relés.

Requisitos: Fáciles de programar, mantener y reparar, Pequeños, Más baratos que los relés y capaces de comunicarse con los dispositivos.

Evolución: Más potencia de procesado, Soporte para I/O digital y analógico, Distintas variantes de lazos de control y sporte para nuevos protocolos de comunicación.

### Componentes

Entradas, CPU, Salidas...Sistema I/O, Controlador, Módulo de comunicación, Fuente de poder.

### Desarrollo y Funcionalidades

Lo habitual es usar sobre los PLC software especializado basado en una interfaz WYSIWYG en la que se interconectan entradas y salidas.

## SCADA

Capa de software por encima de los PLC que funciona como interfaz de supervisión, aunque algunos permiten enviar comandos de alto nivel.

Funcionalidades: Adquisición de datos, Presentación de los mismos a través de un HMI (Interfaz Persona-Maquina) y control de sistemas dispersos geográficamente

### RTU

Remote Terminal Unit: Hardware de control que se comunica con un sistema SCADA a través de un nodo maestro (MTU). Un RTU suele ser un PLC, por su ubicación remota y conectividad los SCADA suelen mostrar solo los cambios de estado y no un flujo contínuo.

## DCS

Similar a un SCADA pero este sí muestra los datos en tiempo real, esto se debe a que se sitúa en lugares con alta conectividad.

## Protocolos de comunicación

Los protocolos de comunicación suelen ser muy específicos, optimizados para ser fiables y permiten operaciones en tiempo real y muy precisas. No suelen ofrecer funcionalidades básicas como la autenticación y el cifrado. Protocolos SCADA son los de comunicación de sistemas de supervisión y protocolos fieldbus los de control, actualmente ofrecen ambas.

### Modbus

Modicon Communication Bus, es el protocolo de control más antiguo y extendido (1979 Modicon). Estándar abierto y gratuito, transmite en plano, capa aplicación, sigue un modelo request/reply y es muy sencillo y con muchas variantes.

Problemas de seguridad:
- Ausencia e autenticación y cifrado: solo necesita una dirección y un código de función válidos.
- Modbus TCP no hace validación de integridad.
- Ciertas variantes usan un puerto serie, no se suprimen los broadcast y es muy facil hacer un DoS.

### OPC

Object Linking and Embedding for Process Control es un framework para comunicar sistemas basados en Windows que usan el protocolo OLE de Microsoft (normalmente sobre TCP/IP). Usan la API DCOM (distributed Component Object Model) por lo que no tienen que usar drivers específicos.

Fundamentalmente es como SCADA, actualmente se implementa la arquitectura OPC-UA.

Problemas de seguridad:
- Al usar DCOM y RPC es muy vulnerable a ataques.
- Al depender de Windows es vulnerable a exploits del sistema operativo o vulnerabilidades típicas de un Host Windows.
- Dificiles de parchear.

## Diferencias con Redes de Comunicaciones Comerciales

Las principales diferencias es que se utilizan para control de equipos físicos, tienen muchos estándares distintos, alta severidad en los fallos y fiabilidad requerida, eficientes, suelen estar formados por paquetes pequeños de tráfico periódico o asíncrono, requieren consistencia temporal y operan en entornos hostiles con altos niveles de polvo, calor, ruido o vibraciones.

### Seguridad

El impacto es mucho mayor porque conlleva consecuencias físicas, los errores suelen ser difíciles de diagnosticar y reparar porque se manifiestan como fallos de mantenimiento o parones.

Es complicado administrar los ICSs debido que hay mucho software desfasado, no hay entornos amigables de pruebas, los dispositivos pueden estar muy dispersos físicamente y normalmente no se pueden usar firewall o antivirus.

Los vectores de ataque suelen ser muy específicos debido al uso de protocolos variados o comandos no bloqueables.

# Tema 4 : Ciberseguridad de Tecnologías de la industria 4.0/5.0

- Industria 4.0: Evolución de las fábricas tradicionales hacia fábricas inteligentes diseñadas para ser más eficientes y tener una alta flexibilidad ante cambios.
- Industria 5.0: Busca personalizar productos a escala masiva, cooperación entre humanos y máquinas y utiliza Cognitive Computing.

Cognitive Computing: Paradigma computaciones que imita como los humanos tomamos decisiones utilizando IA y procesado de señal.

## Tecnologías de la Industria 4.0

Pilares: Simulación, Integración de sistemas, IoT, Ciberseguridad, Computación en la nube, Fabricación aditiva, Realidad aumentada y Big Data.

### Robótica y Autómatas

Permiten automatizar tareas industriales sistemáticas y los cobots pueden ayudar a los operarios en tareas puntuales.

#### Aplicaciones

Cadenas de montaje, carga pesada, exoesqueletos, soldadura remota, pintado automático, recogida de productos.

#### Ciberseguridad en Robótica

Arquitecturas y programación muy simples, Gran exposición a Shodan. los ataques pueden basarse en inducción de errores de precisión o calibrado atentando contra la seguridad del personal.

### UAVs, AGVs y AUVs

Conceptos:
- Unmanned Aerial Vehicle: Automatiza tareas desde el aire y en ubicaciones poco accesibles.
- Automatic Guided Vehicle: Robot para tareas de transporte, logística, inventariado o "picking".
- Autonomous Underwater Vehicle: Robot para tareas de reconocimiento y actuación remota.

#### Aplicaciones

Agricultura inteligente, Supervisión de infraestructuras críticas.

#### Ciberseguridad en UAVs

- Ataques Hardware: Adulteración de hardware o firmware durante la fabricación, entrega o mantenimiento.
- Ataques a las comunicaciones inalámbricas mediante Jamming o interceptación.
- Sensor spoofing (GPS, visión o LiDAR).

# Tema 5 : Ciberseguridad de dispositivos IIoT hardware, firmware y middleware.



## IoTSF



## PSA


# Tema 6 : Panorama de amenazas y enfoque sistemático

# Tema 7 : Cloud Xiaomi

# Tema 8 : Hackeando dispositivos de aspirado

# Tema 9 : Hackeando una smart home, bombillas y leds

# Tema 10 : Bluetooth LE

Bluetooth Low Energy es una solución de baja potencia y coste, robusta y segura, con perfiles estandarizados para cubrir casos de uso, permite desarrollar perfiles en aplicaciones y permite alta conectividad.

Arquitectura: GATT, ATT, SMP, GAP, L2CAP, HCI, Link Layer y Radio.

### Radio



## Topología



### Publicidad y descubrimiento de dispositivos



### Conexiones


### Versiones



## Transmisión del ATT y datos guardados en GATT DB

## Seguridad

## Ataques

### MITM

# Tema 11 : GPS Spoofing + SDR

## GPS



### ¿Cómo funciona?

### Transmisión de información


### Suplantación de identidad



## Software Defined Radio (SDR)



### Uso de SDR para aplicar ingeniería inversa sobre un protocolo inalámbrico



# Tema 12 : Seguridad en consolas

Las consolas incluyen múltiples vias de protección como Secure Boot, Hipervisor, cifrados, etc.

La principal medida de protección es realizar actualizaciones de firmware que fuerzan a los usuario a elegir si quieren una consola desactualizada y explotable o la experiencia gaming completa.

### Estrategias de ataque

Los ataques software se basan en desbordamientos de memoria o parámetros sin comprobar y los ataques hardware en timing o glitches.

Normalmente se combinan, otro vector a añadir es hacer downgrade cuando una vulnerabilidad es parcheada.

## XBOX 360

Tiene varias medidas de seguridad destacadas:
- Secure Boot: Verifica la autenticidad del firmware durante el arranque.
- Hypervisor: Ejecuta código en modo privilegiado aislando el sistema.
- eFuses: Fusibles físicos que se queman en cada actualización para evitar downgrade.
- Firmware: Actualizaciones obligatorias.
- Cifrado: Cifrado y descifrado en la lectura RAM.

### Ataque King Kong

Se trata en un error en el hypervisor que permitía ejecutar código no firmado, descubierto con el juego King King que escribía en memoria a través de shaders.

Un error en la instrucción cmphw ignoraba los 32 bits superiores permitiendo saltar verificaciones.

Se usaban los datos escritos en memoria para manipular el flujo de ejecución y llamar a syscalls con parámetros maliciosos.

### Timing Attack

El objetivo era hacer un bypass de los eFuses para hacer downgrade del firmware. Durante el arranque, el 2BL verifica el HMAC con una función CheckHMAC que compara los hashes byte a byte. Esta funcion no era constante en el tiempo y si un byte era incorrecto el bucle se detenía antes, ante esto se puede comprobar que si el byte era correcto tarda 0.22ms, sino tarda 0.21ms, por lo que era posible generar un HMAC válido.

### Glitch Attack

El objetivo era saltar la integridad del firmware durante el arranque, 2BL verifica el hash del 4BL antes de cargarlo y si falla no arranca.

Se usa un chip para enviar un pulso de voltaje anómalo a la CPU en el momento exacto que interrumpe la instrucción memcmp que compara hashes. Al entrar en estado inestable la CPU devuelve un TRUE. Esto debe ocurrir durante la ejecución de "IsHashValid".