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



## Hardware y Firmware

### Sensórica



### Sensores y actuadores comunes



### Cloud



### Seguridad de CPS y sistemas IoT/IIoT



# Tema 3 : Ciberseguridad de Sistemas de Control y Comunicaciones Industriales



## PLC



### Componentes



### Desarrollo y Funcionalidades



### RTU



## DCS



## Protocolos de comunicación



### Modbus



### OPC



## Diferencias con Redes de Comunicaciones Comerciales



# Tema 4 : Ciberseguridad de Tecnologías de la industria 4.0/5.0




## Tecnologías de la Industria 4.0



### Aplicaciones



### Seguridad