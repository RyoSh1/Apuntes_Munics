# Análisis Forense
1. [TLS](#tema-1--transport-layer-security-layer-protocol)
2. [Características principales](#caracteristicas-principales)
3. [Ejemplo de uso](#ejemplo-de-uso)
4. [Conclusión](#conclusion)

# Tema 1 : Análisis Forense

## Introducción

### Informática Forense

Proceso de indentificar, preservar, analizar y presentar las evidencias de una forma legal y aceptable, aplicando técnicas científicas y analíticas especializadas a infraestructura tecnológica.

**Principio de Locard**: Siempre que dos objetos entran en contacto transfieren parte del material que incorporan al otro.

### Funciones o ámbito de actuación

- Recopilación y preservación de pruebas digitales.
- Análisis de pruebas digitales.
- Recuperación de datos.
- Investigación de incidentes de seguridad.
- Análisis de redes y comunicaciones.
- Creación de informes.
- Asesoría y capacitación.
- Investigación y desarrollo.

## Guías para el proceso de investigación forense

Estándares que se utilizan como guía para realizar un análisis pericial completo, empezando por la adquisición de evidencias y terminando en el informe pericial correspondiente.

#### UNE

UNE 71505:2013: TI, Sistema de gestión de evidencias electrónicas. Formato estándar para el intercambio de evidenicas, algoritmos, etc.
- Parte 1: Vocabulario.
- Parte 2: Buenas prácticas.
- Parte 3: Formatos y mecanismos.

UNE 71506:2013: TI, Metodología para el análisis forense de las evidencias electrónicas.
UNE 197010:2015: Criterios generales para la elaboración de informes y dictámenes periciales sobre TIC.

#### ISO

- ISO/IEC 27037:2012: Guías para la identificación, recolección, adquisición y preservación de la evidencia.
- ISO/IEC 27042:2015: Guías para el análisis y la interpretación de la evidencia digital.

## Proceso de investigación forense

### Preparación

Preparación previa para poder adquirir las evidencias correctamente y que el proceso sea correcto a nivel legal. Permisos, Autorización por escrito, Contrato...

Asegurar la escena para evitar modificación o destrucción de las evidencias.

### Identificación

Detectar y localizar posibles fuentes de evidencia digital, su ubicación y su relación con el incidente. Incluye la evaluación preliminar de los dispositivos y medios para evitar la alteración.

#### Revisión del entorno legal que protege el bien

Se debe revisar el entorno legal que protege el bien, que consiste en analizar las normativas y regulaciones aplicables a la evidencia digital y al bien protegido, asegurando la recolección, adquisición y análisis de los datos de manera legal y admisibles judicialmente.

#### Cadena de custodia

Inicio de la cadena de custodia, procedimiento el cual garantiza la autenticidad de la prueba digital desde su obtención hasta que se aporta como hecho probatorio en un procedimiento judicial.

Es necesario documentar:
- Dónde, cuándo y quién descubrió y recolectó la evidencia.
- Dónde, cuándo y quién manejó la evidencia.
- Quién ha custodiado la evidencia, durante cuánto tiempo y cómo se ha almacenado.
-  Si existe un cambio de custodia, indicar cuándo y cómo se ha realizado, indicando número de caso y demás información.

### Adquisición

Recopilación de pruebas digitales de dispositivos electrónicos, utilizando técnicas y herramientas especializadas para garantizar la integridad y autenticidad de los datos. Puede incluir copias forenses, extracción lógica de datos o incluso captura en vivo de memoria. Debe documentarse completamente.

El orden de volatidad establece que se debe recolectar la información según el tiempo que permanece accesible. Ej. Respaldo < topología < registro < disco < archivos temporales < enrutamiento,caché arp, procesos < registros y caché.

#### Modos de adquisición

- Modo Live: Obtención de datos volátiles del equipo a analizar. Es un proceso complejo que puede invalidad pruebas dependiendo de los comandos, debe ser muy documentado.
- Modo Dead: Modo recomendado, tirar del cable y clonado.

#### Clonado

Copia exacta bit a bit de un disco incluyendo errores y sectores defectuosos. El objetivo es disponer de una copia sobre la que realizar el análisis sin alterar la prueba.

Existen múltiples herramientas software (importante asegurarse de no montar el disco desactivando el modo automático) y hardware (múltiples herramientas con variadas funcionalidades y precios).

#### Integridad

Es preciso asegurar que los datos clonados son copia exacta de los originales. MD5 o SHA-1 no se consideran seguros porque son vulnerables a ataques de colisión, si no es posible usar otros la alternativa es usar ambos.

### Preservación

Adecuado tratamiento y documentación de las evidencias garantizando la cadena de custodia. Documentar detalladamente los procesos realizados, almacenamiento seguro y control de acceso.

### Análisis

Herramientas: Autopsy (solución completa para el análisis de evidencias), Volatility (Análisis de memoria), SIFT (Distribución basada en Ubuntu con multitud de herramientas orientadas a forense), CAINE (entorno seguro con bloqueo de escritura).

SANS Institute: Compañia privada EEUU especializada en formación en ciberseguridad y formaciones, con reconocido prestigio y de gran tamaño. SysAdmin, Audit, Network y Security.

Otros: Paladin Forensic Suite, Parrot OS, Cellebrite, MOBILedit, EnCase.

### Presentación de los resultados

Recopilación y documentación de toda la información obtenida, generando si es el caso un informe pericial.

Los expertos en informática forense pueden ser llamados a testificar en juicios para presentar sus hallazgos. Deben comunicar de manera clara y efectiva información compleja a personal no técnico.

## La figura del perito

### El perito

El punto de referencia de creación del título de Perito es el real decreto de Romanones, 1901. Actualmente se exige que los peritos tengan titulación oficial para la materia nombrada.

- Perito informático: Profesional experto en tecnologías de la información y sistemas informáticos que posee conocimientos especializados y experiencia en el ámbito de la informática.
- Perito forense: Experto en ciencias forenses que puede especializarse en disciplinas como medicina, psicología, química, biología u odontología.
- Perito informático forense: Experto en informática forense especializado en la identificación, preservación, análisis y presentación de pruebas digitales en investigaciones y casos legales.
- Perito judicial: Profesional ditado de conocimientos especializados y reconocidos, a través de sus estudios superiores, que suminstra información u opinión fundada a los tribunales de justicia. Perito de oficio es el elegido por un juez o tribunal y perito de parte es el elegido por una de las partes y aceptado por la parte judicial.

#### Responsabilidades del perito, ética y privacidad

Los profesionales deben seguir estrictos códigos de conducta y ser conscientes de las leyes y regulaciones de privacidad aplicables.

#### Código deontológico

Código de ética profesional que recoge un conjunto de criterios, normas y valores. El conjunto de obligaciones morales del profesional y hace referencia a la ética (Obligado a guardar el secreto profesional), "Obrar según ciencia y conciencia".

Si hay alguna evidencia de comisión delictiva, aunque no sea objeto o mandato de la investigación, se debe informar del delito a las autoridades competentes (mandato civil).

#### Órdenes Jurisdiccionales

El perito judicial puede intervenir en: Civil, Penal, Contencioso administrativo y social (no militar).

#### Responsabilidades

El perito está sujeto a varios tipos de responsabilidades, dependiendo de la norma o legislación:
- Civil: Obligado a reparar el daño a un particular.
- Penal: Obligado a reparar el daño a la sociedad.
- Disciplinaria: Por no comparecer en juicio o vista cuando sea requerido judicialmente para ello.
- Profesional: Por no cumplir el código deontológio o el procedimiento disciplinario colegial.

#### Cuerpo Oficial de Peritos

Conformado por el conjunto de peritos colegiados, su creación y gestión es tarea de los Colegios profesionales. La lista de peritos se renueva anualmente y, se pone a la libre disposición de las autoridades judiciales, juntas de arbitraje, empresas, instituciones y cualquier persona interesada.

- Colexio Profesional de Enxeñaría Técnica en Informática de Galicia (CPETIG).
- Colexio Profesional de Enxeñaría en Informática de Galicia (CPEIG).

## Normativa 

### Normativa en España

- Ley Orgánica de Protección de Datos Personales y Garantía de los Derechos Digitales (LOPDGDD): Regula la protección de datos personales en España y garantiza los derechos digitales de los ciudadanos.
- Código Penal: Disposiciones específicas relacionadas con los delitos informáticos, como el acceso no autorizado a sistemas informáticos, interceptación ilegal de comunicaciones, distribución de malware y suplantación de identidad.
- Ley de Enjuiciamiento Civil (LEC): Regula los procedimientos y procesos en casos civiles en España, incluidos aspectos relacionados con la recopilación, presentación y valoración de pruebas, como las pruebas electrónicas.
- Ley de Enjuiciamiento Criminal (LECr): Establece las reglas y procedimientos para la investigación y enjuiciamiento de delitos en España.
- Ley de Servicios de la Sociedad de la Información y de Comercio Electrónico (LSSI): Regula diversos aspectos del comercio electrónico y los servicios en líea en España, incluida la responsabilidad de los prestadores de servicios de Internet y la retención de datos.
- Ley Orgánica de Protección de la Seguridad Ciudadana: Contiene disposiciones relacionadas con la vigilancia y la interceptación de comunicaciones en el contexto de la seguridad nacional y la lucha con el terrorismo.
- Ley de conservación de Datos relativos a las comunicaciones electrónicas y a las redes públicas de comunicaciones: Establece las obligaciones de los proveedores de servicios de comunicaciones electrónicas y las redes públicas de comunicaciones en relación con la conservación de ciertos tipos de datos (12 meses).

### Normativa en Europa

- Directiva 2006/24/CE (Directiva de Conservación de Datos): Trata las obligaciones de los proveedores de servicios de comunicaciones electrónicas de acceso público o de una red pública de comunicaciones en relación con la ocnservación de determinados datos generados, para garantizar que estén disponibles con fines de investigación de delitos. 
- Directiva 2013/40/UE: Orientada a combatir los ciberataques a nivel UE, establece las normas mínimas relativas a la definición de las infracciones penales y las sanciones aplicables en el ámbito de los ataques contra los sistemas de información.

# Tema 2 : Análisis Forense en Windows

## Introducción

Cada SO tiene sus peculiaridades, desde el punto de vista forense, pero algunos procedimientos son aplicables de manera legal. Windows representa el 71,47% de la cuota de mercado.

El proceso de análisis forense en Windows implica la identificación y extracción de datos relevantes de diversas fuentes, para reconstruir las actividades realizadas en el sistema y determinar posibles evidencias.

### Artefactos

Cualquier objeto, dato o elemento almacenado en un sistema informático que pueda proporcionar información valiosa para una investigación (ficheros, cadenas de registro, configuraciones, etc.).

Diferenciamos entre artefactos de aplicación y artefactos del sistema operativo.

## Archivos de registro (Logs)

Son artefactos que contienen información sobre eventos específicos, aplicaciones y servicios. En Windows, los logs se encuentran en distintas ubicaciones y formatos, se verán Event Logs, registros de aplicaciones, registros varios.

### Registros de eventos

Se encuentran en el visor de eventos, divididos en 4 categorías: Aplicación, Seguridad, Configuración y Sistema.

En versiones antiguas se encuentran como binarios (.evt) en \System32\config, en versiones modernas también son archivos binarios (.evtx) en \System32\winevt\Logs.

Evidencias: Inicios de sesión, cambios de configuración, programas, equipos, etc.

Nota: %WinDir% y %SystemRoot% son variables de entorno que en la mayoria de casos hacen referenia al directorio donde está instalado Windows. Pre NT se usaba WinDir y Post NT se usa SystemRoot, actualmente ambas.

### Registros de aplicaciones

Muchas aplicaciones tambié generan sus propios archivos de registro que pueden estar en la instalación de la aplicación, en la carpeta AppData (específicos del usuario) y en ProgramData (global).

### Registros varios sobre la instalación

En SystemRoot hay varios registros:
- setupact.log: acciones de instalación.
- setuperr.log: Errores de instalación.
- WindowsUpdate.log: Actualización del sistema y aplicaciones.
- \Debug\mrt.log: Eliminación de software malintencionado.
- \security\logs\scecomp.old: Componentes de Windows que no han podido ser instalados.
- \SoftwareDistribution\ReportingEvents.log: Eventos relacionados con la actualización.
- \Logs\CBS\CBS.log: Component-Based Servicing, el mecanismo utilizado por Windows para administrar actualizaciones, paquetes de características y componentes del SO.
- \INF\setupapi.dev.log: Acciones al detectar un nuevo dispositivo o al actualizar/reinstalar un driver existente.
- \INF\setupapi.app.log: Instalación de componentes o aplicaciones.
- \INF\setupapi.setup.log: Operaciones de instalación/configuración de Windows.
- \INF\setupapi.offline.log: Procesos o reparaciones hechas en modo offline.
- \PANTHER\*.log,xml: Acciones, errores y SID de cuando se actualiza desde una versión anterior de Windows.
- \$Windows.~BT\Sources\Panther\*.log,xml: Similar a la anterior pero oculta, protegida y de uso temporal.
- \Performance\Winsat\winsat.log: Utilización de la aplicación Windows System Assessment Tool (WINSAT),

## Papelera de reciclaje

Introducida por primera vez en Windows 95, almacena archivos borrados e información sobre la fecha y hora en la que fueron eliminados y la ubicación original.

El directorio originalmente estaba en C:\RECYCLER y en los nuevos es C:\$Recycle.Bin.

Es posible comprobar su contenido mediante comandos, los archivos que comienzan por $I contienen el nombre, ruta original y datos del archivo, los que empiezan por $R tienen el contenido del archivo original.

## Registro de Windows

Es una base de datos jerárquica que contiene información y configuracioes para el SO, el HW, las aplicaciones instaladas y preferencias del usuario. Funciona como un repositorio centralizado que facilita la administración del sistema, permitiendo que tanto las aplicaciones como los componentes accedan a configuraciones unificadas.

Contiene información importante desde el punto de vista forense.

- Frecuencia y tiempo de uso de aplicaciones: HKEY_CURRENT_USER\Software\Microsoft\Windows\CurrentVersion\Explorer\UserAssist
- Dispositivos USB conectados: HKEY_LOCAL_MACHINE\System\CurrentControlSet\Enum\USBStore
- Asociaciones de tipos de archivos y programas: \HKEY_CLASSES_ROOT\.pdf y \HKEY_CLASSES_ROOT\Acrobat.Document.2020\shell\Open\command


### HKEYS

El registro se divide en varias secciones principales llamadas Handle to Registry Key.

- HKEY_CLASSES_ROOT: Información sobre tipos de archivos, extenisones, asociaciones de programas y detalles de integración y comunicación entre aplicaciones mediante tecnologías OLE y COM.
- HKEY_CURRENT_USER: Almacena configuraciones y preferencias específicas del usuario que ha iniciado sesión actualmente.
- HKEY_LOCAL_MACHINE: guarda configuraciones y datos relacionados con el HW, el SW y los controladores del sistema en el equipo.
- HKEY_USERS: Almacena configruaciones y preferencias de todos los usuarios en el sistemas, identificados por sus respectivos identificadores de seguridad (SIDs).
- HKEY_CURRENT_CONFIG: Información sobre el perfil de hardware activo.

### Hives

El registro se agrupa en secciones lógicas conocidas como hives. Estas son un grupo de claves, subclaves y valores relacionados con una parte específica del SO o con configuraciones del usuario.

Los hives permiten organizar y estructurar la información del registro, facilitando su administración y mantenimiento. Este se respalda con archivos auxiliares, conocidos como Hive Files, que contienen copias de seguridad de los datos (Recuperación del sistema).

### Hive Files

Son los archivos de respaldo para todos los Hives, se encuentran en \System32\Config y los HKEY_CURRENT_USER en %UserProfile%.

- SAM: Security Account Manager, contiene información sobre cuentas de usuario, incluido nombres, ID y hash de contraseñas. No accesible en funcionamiento.
- SECURITY: Configuraciones de políticas locales, políticas de contraseñas, bloqueo de cuentas, privilegios y control de acceso.
- SOFTWARE: Detalles sobre las aplicaciones instaladas.
- SYSTEM: Hardware del sistema, configuraciones de servicios, información de arranque y otros aspectos del SO. Contiene la clave de cifrado de las contraseñas de SAM.
- DEFAULT: Configuración de usuario predeterminada.

## Listas MRU

Las listas MRU almacenan información sobre los elementos utilizados más recientemente en un SO o aplicaciones específicas. Permiten un acceso rápido a archivos, carpetas o elementos que el usuario ha utilizado recientemente, mejorando la eficiencia.

Fuente valiosa de información para determinar qué archivos o elementos ha accedido un usuario. Se encuentrar en diferentes partes del SO y Registro.

- OpenSavePidlMRU: Información sobre archivos abiertos o guardados a través de cuadros de diálogo comunes.
- RunMRU: Comandos ejecutados en el cuadro "Ejecutar" en orden de ejecución. 

## Shellbags

Lugares donde el SO almacena información relacionada con las preferencias de visualización de contenidos, estos se generan automáticamente cuando un usuario abre una carpeta del sistema usando el explorador de Windows y personaliza la vista de esa carpeta.

Proporcionan información sobre las carpetas a las que un usuario ha accedido, incluso si ya no existen.

- Bags: Información de las shellbags, cómo un usuario ha personalizado la vista y la disposición.
- BagMRU: Información sobre el historial de carpetas visitadas por un usuario.

## Herramientas

- MiTec Windows Registry Recovery: Permite leer archivos de registro hasta W10, los archivos se pueden exportar al formato REGEDIT4.
- ShellBags Explorer.

## Prefetch y Superfetch

### Prefetch

Es un componente de plataformas Windows, aparecido originalmente en Windows XP, que tiene como objetivo mejorar el rendimiento y la eficiencia de la carga de aplicaciones.

Realiza un seguimiento de las aplicaciones y archivos que se utilizan con frecuencia y almacena información sobre como se carga en memoria, esto se utiliza para optimizar la carga en futuras ejecuciones.

Para cada archivo o proceso sometido a prefetching se genera un fichero .pf que inlcuye las referencias a los ficheros y directorios que dicha aplicación utilizó en la carga y la huella temporal de la última ejecución.

Para el analista es una fuente valiosa de trazas de uso y eliminación de aplicaciones por parte de los usuarios y reconstrucción de la línea temporal. Aunque es importante tener en cuenta que entre la ejecución de un fichero y el correspondiente prefetch modificado hay una diferencia de varios segundos.

#### Inspección de prefetch

Para inspeccionar los prefetch se comprueba el registro PrefetchParameters (0 a 3 = deshabilitado, apps, boot, apps  boot) y después su ubicación por defecto, que es  %SystemRoot%\Prefetch. Esta información se actualiza constantemente con cada ejecución, por lo que es muy volatil.

### Superfetch

Aparece con Windows Vista y su funcionamiento se basa en la monitorización de forma continua del uso de los programas y en la optimización de la asignación de memoria, precargando en RAM los elementos que se utilizan con mayor frecuencia. 

Superfetch trabaja continuamente en tiempo real, a partir de Windows 1 se denomina SysMain.

## Sistemas de ficheros en Windows 

### Organización del almacenamiento de datos

Jerarquía de almacenamiento: Bit, Byte, Sector (unidad de almacenamiento direccionable más pequeña), Cluster (grupo de sectores contiguos).

El tamaño de los sectores y clusters se define en el encabezado del sistema de archivos, los sistemas asignan espacio a los archivos en clusters completos (aunque no lo llenen).

- Partición: división de bajo nivel de un disco físico en regiones separadas y contiguas sin incluir un sistema de arhcivos por sí misma.
- Volumen: Área de almacenamiento formateada con un sistema de archivos, es reconocido por el SO como área de almacenamiento utilizable (letras C:, D:). En Windows una partición puede contener un volumen y un volumen puede abarcar varias particiones o discos.

### Sistemas de archivos FAT

File Allocation Table, desarrollado en 1977 por Microsoft (variantes: FAT12, 16, 32 Y exFAT).

Componentes clave:
- El sector de arranque se ubica al inicio del volumen, contiene la información esencial sobre el sistema de archivos e incluye el BIOS Parameter Block (BPB), que proporciona detalles necesarios para acceder correctamente al volumen, como el tamaño del cluster.
- La Tabla de Asignación de Archivos actúa como un mapa del dispositivo de almacenamiento, donde cada entrada se corresponde a un cluster en el disco (Libre, Asignado, EOF y defectuoso).
- La región del directorio raíz se sitúa en FAT12 y FAT16 inmediatamente después de la región FAT y tiene un tamaño fijo, contiene entradas para archivos y subdirectorios, con metadatos como nombres, atributos, entradas de tiempo y número de cluster inicial. En FAT 32 se almacena en la región de datos, permitiendo que se expanda.
- La región de datos ocupa la mayor parte del volumen, está dividida en clusters los cuales almacenan los datos reales de archivos y directorios. La FAT se encarga de rastrear la secuancia de clusters que componen cada archivo.

#### Forense FAT

- Comportamiento de eliminación de archivos: en el sistema de archivos FAT, la eliminación de un fichero hace que su entrada de directorio se marque con un carácter especial (0xE5), pero el resto de información com tamaño y cluster de inicio, permanece intacto. Los datos reales no se modifican hasta ser sobreescritos.
- Retos de fragmentación: FAT es propenso a la fragmentación, donde los datos de un archivo se dispersan en clusters no contiguos. Al eliminar un archivo los punteros a sus cluster se cambian a 0.
- Espacio residual: Como los tamaños de los cluster son fijos, archivos pequeños o lo sobrante, no ocupa el espacio asignado, dejando sectores residuales.
- Artefactos de Timestamps: Resolución de tiempo con precisión limitada en la creación, modificación y acceso. Ambiguedad en la zona horaria porque se guardan en local.
- Almacenamiento de nombres de archivos: Convención de nombres 8.3, los nombres largos se almacenan mediante entradas de directorio especiales.
- Recuperación de entradas FAT: Para proteger contra la corrupción de datos se alamacena dos FATs, FAT1 es la principal y FAT2 funciona como copia de seguridad, los cambios se reflejan simultáneamente. Se puede deshabilitar en FAT32

### Sistemas de archivos NTFS

Desarrollado por Microsoft en 1993 con Windows NT, surge como reemplazo del sistema FAT. A diferencia de FAT está optimizado para discos duros y soporta volúmenes y archivos de mayor tamaño. 

#### Componentes clave NTFS

Componentes clave:
- Sector de arranque de partición: Ubicado al inicio de un volumen NTFS y almacenado en el registro $Boot. Contiene información esencial para iniciar el sistema operativo y detalles sobre eldiseño del sistema de archivos, incluido el BPB que especifica parámetros como bytes por sector, sectores por clúster y la ubicación de la MFT.
- Área de datos: Región del volumen que contiene los archivos de usuario y directorios. Se gestiona en clústeres y su asignación se controla mediante el fichero $Bitmap.
- Master File Table (MFT): El archivo $MFT reside en la zona MFT del área de datos y actúa como la base de datos central de NFTS, registrando la información de cada archivo y directorio del volumen. El archivo $MFTMirr es una copia de respaldo de los primeros cuatro registros.
- Tamaño de sector: El tamaño estándar es de 512b, que es la unidad de almacenamiento más pequeña en un disco.
- Tamaño de clúster: Varía según el tamaño del volumen, oscila entre 512b y 64KB.

#### MFT

El fichero $MFT contiene registros de cada archivo del sistema, incluido a si mismo. Almacena toda la información del archivo, ya sea en las entradas de la MFT o en áreas externas referenciadas.

La MFT reserva una cierta cantidad de espacio para cada registro (1024b), los atributos de un archivo se guardan en ese espacio.

NTFS reserva un área específica denominada zona MFT, para evitar fragmentación a medida que la MFT crece. Puede utilizarse para ficheros, pero solo después de que el resto se haya agotado.

#### Forense NTFS

- Eliminación Lógica: Al eliminar un archivo, la entrada MFT se marca como no usada, pero permanece intacta. Los clústeres de datos no se borran inmediatamente, solo si se sobreescriben.
- Espacio residual: Pueden quedar restos de archivos si el archivo nuevo no llena completamente el cluster. NTFS almacena archivos pequeños en la MFT, reduciendo el espacio residual en comparación con FAT.
- Análisis de Volume Shadow Copy: Función específica de NTFS que crea copias instantáneas de archivos o volúmenes. Permite recuperar versiones anteriores de arhcivos o datos eliminados o modificados.

# Tema 3 : Análisis forense de WhatsApp en Android

## Introducción

#### Directorios

- Almacenamiento externo (público): Cualquier usuario puede acceder, el ADB accede si el debugging está activo. /Android/media/com.whatsapp/WhatsApp (>11), /Whatsapp (antiguos).
- Almacenamiento interno (privado): Hay que ser root para acceder. /data/data/com.whatsapp/. 

#### Ficheros

Dentro del directorio privado:
- files: key (clave de cifrado).
- databases: BD contactos (wa.db) y BD chats (msgstore.db).

Dentro del público:
- Databases: Backups cifrados con AES256.

#### Chats cifrados

Los chats están en la zona privada y los backups en la pública pero cifrados. Nos permite extraerlos con un adb pull.

#### Claves de cifrado

Para descifrar las bases de datos se necesita la key, pero es necesario ser root para acceder.

Es posible hacer downgrade de WhatsApp (2.11.431) y acceder al contenido de todo.

## Preparación de la adquisición

#### Entorno de prueba

Cosas

### Activación del debugging con ADB

Igual que en Telegram

Otras opciones: recomendado que la plantalla no se bloquee y que no se apague mientras está conectado.

### Creación de backup

Si WhatsApp está recién instalado puede que no se disponga de todos los directorios, por lo que es recomendable conversar y hacer una copia de seguridad para forzar su inicialización.

## Adquisición

Ejemplo con Avilla Forensics.

### Creando un pack de ficheros de WhatsApp

Si somos root, se pueden utilizar los siguientes comandos para empaquetar toda la evidencia sin herramientas extra:
```
adb exec-out "su -c 'tar c /data/data/com.whatsapp/'" > 
wasap_ejemplo_basico.tar

adb exec-out "su -c 'am force-stop com.whatsapp;tar c /data/data/com.whatsapp/'" | tail -n +2 > whatsapp_practicas.tar 
```

## Análisis

### Acceso a base de datos

Las BD se pueden abrir con SQLiteBrowser (aunque permite solo lectura). En el menú "hoja de datos" se puede acceder a los valores de las tuplas de cada tabla.

#### BD.wa.db - Tabla wa_contacts

Datos de la libreta de contactos, como id, foto, estado, fechas, etc.

#### BD.msgstore.db - Tabla messages

Datos sobre atributos de los mensajes y sobre contenidos, como ID, estado, origen (from_me), timestamp, recipiente, etc.

Muchos de ellos ahora han cambiado de ubicación a message_media, message_location, etc. y han cambiado de nombre.

### Consultas para ver conversaciones

Para hacer consultas SQL elaboradas se pueden combinar wa-db y msgstore.db (ignorar el error: near line XXX...already exists). Acto seguido se puede crer una consulta SQÑ cuyo resultado visualice mejor los datos.

### Ficheros de la carpeta interna de Whatsapp

Me, Key, Status, Avatars y logs.

Para ver logs:
```
adb shell cat /data/data/com.whatsapp/files/Logs/whatsapp.log | 
grep "register"

adb shell cat /data/data/com.whatsapp/files/Logs/whatsapp.log | 
grep "status" 
```

# Tema 4 : Análisis forense de Telegram en Android

## Introducción

#### Directorios

Telegram emplea varios directorios para almacenar sus datos:
- Externo (público): Cualquier usuario puede acceder, en particular el ADB puede acceder si el debugging USB está activado en el dispositivo Android. /Android/media/org.telegram.messenger/Telegram (>11), /Telegram.
- Interno: Hay que ser root para acceder. /data/app/org.telegram.messenger/

#### Ficheros

Dentro de privado la carpeta files y files/account tiene las BD de chats.

#### Chats inaccesibles

La BD de chats está en zona privada, a diferencia de Whatsapp, no hay backups locales. Hay una única copia maestra en su servidor, existe una funcionalidad de exportar todos tus chats, pero no es un backup que se pueda restaurar.

## Preparación de la adquisición

#### Extracción de chats mediante downgrade

1. Borrar la APK de Telegram.
2. Instalar una versión antigua (1.3.17).
3. Acceder a la BD.
4. Reinstalar la original.

#### Entorno de prueba

### Activación del debugging con ADB

Se debe pulsar el número de compilación 8 veces y activar la depuración en las opciones de desarrollador.

Se conecta un USB y se acepta la autorización de depuración. En ciertos casos activar permisos de instalación vía USB.

#### Problema de la máquina virtual

Conectar el dispositivo y esperar a que lo detecte, esto puede dar problemas en algunos modelos.

## Adquisición

Pasos de Avilla Forensics.

## Análisis

### Fichero cache4.db

Es la BD principal, está en la carpeta files y se abre con SQLiteBrowser. Permite abrir en solo lectura y puede haber otros en el resto de cuentas.

La tabla de mensajes se llama messages_V2, la columna data guarda los BLOB y solo se pueden ver uno a uno con un editor hexadecimal.

#### Tablas contacts y users

La tabla contacts tiene información de los contactos y la tabla users del usuario.

#### Tabla dialogs

Contiene la información estadística de una conversación.

#### Tablas chats y enc_chats

La tabla chats contiene los ID, Nombres e información extra.

La tabla en_chats contien lo mismo de chats secretos.

#### Tabla messages

Tabla propia de los mensajes con: ID, ID dialogo, Estado de lectura, Estado de envío, Fecha del último estado, Datos (Mensaje y participantes), Estado recepción.

### Acceso a base de datos

Se puede crear un pequeño script para ver chats, pero no contempla chats secretos, grupos o canales. esto se debe a que los joins son distintos dependiendo del tipo de chat, algunas incluso hay que andar operando valores.

# Extra 1: Volatility

Volatility es un framework forense de memoria RAM, realiza análisis de dumps de memoria, identifica procesos, conexiones de red y módulos cargados y detecta malware en memoria.

### Versiones

- Volatility2: Requiere Python2.
- Volatility3: Se basa en Python3.

### Perfiles de memoria y Symbol Tables

- Volatility2: Los perfiles de memoria permiten interpretar correctamente la estructura interna de un volcado de memoria (Varian entre SO o versiones).
- Volatility3: Las Symbol Table se encargan de representar las estructuras de memoria del SO.

## Guía Volatility 2

1. **imageinfo**: Para conocer el perfil necesario.
2. **--profile=Win7SP1x64**: Para indicar el perfil.
3. **Comandos**: pslist (procesos), netscan (conexiones activas), cmdscan (historial de comandos), filescan (archivos cargados en memoria), clipboard (contenidos del portapapeles), hivelist (hives de registro en memoria), hashdump (hashes de usuarios para recuperar contraseñas).
4. **Comandos complejos**: dumpfiles -Q < offset > -D < carpeta > : fichero concreto de memoria, procdump -p <PID> -D <carpeta> : memoria correspondiente a un proceso, hivedump -o < offset > : sub-claves de un hive de registro.

**consoles** : Comando pro para el cmd.
**timeliner**: Todo el historial de comandos y cosas.
**getsids**: Obtener los SID de los procesos.

### Hashcat 

```
hashcat -m 1000 \
-a 3 3bf8787c73729d592047a8ff57f181bd \
-1 /usr/share/hashcat/charsets/standard/Castilian/es-ES_ISO-8859-1.hcchr \
-2 ?l?d?u?s -3 ?1?2 ?3?3?3?3?3?3 --potfile-disable
```

```
john --format=nt --mask= ?l?l?s?d?d?d?d?s hashes.txt
```

## Guía Volatility 3

vol -f <fichero> <comando>

1. **windows.info.Info**: Información sobre el volcado.
2. **windows.pslist**: Procesos en ejecución.
3. **windows.netscan**: Conexiones activas.
4. **windows.cmdscan**: Historial de comandos.
5. **windows.filescan**: Lista archivos cargados en memoria.
6. **windows.dumpfiles -virtaddr < offset >**: Extrae un fichero concreto de memoria.
7. **windows.dumpfiles --pid < PID >**: Memoria correspondiente a un proceso.
8. **windows.registry.hivelist**: Hives de registro cargados en memoria.
9. **windows.hashdump**: Hashes de usuarios.