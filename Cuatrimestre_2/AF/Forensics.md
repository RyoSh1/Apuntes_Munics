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

#### Responsabilidades del perito, ética y privacidad

#### Código deontológico

#### Órdenes Jurisdiccionales

#### Responsabilidades

#### Cuerpo Oficial de Peritos

## Normativa 

### Normativa en España

### Normativa en Europa

# Tema 2 : Análisis Forense en Windows

## Introducción

### Artefactos

## Archivos de registro (Logs)

### Registros de eventos

### Registros de aplicaciones

### Registros varios sobre la instalación

## Papelera de reciclaje

## Registro de Windows

### HKEYS

### Hives

### Hive Files

## Listas MRU

## Shellbags

## Herramientas

## Prefetch y Superfetch

### Prefetch

#### Inspección de prefetch

### Superfetch

## Sistemas de ficheros en Windows 

### Organización del almacenamiento de datos

### Sistemas de archivos FAT

#### Forense FAT

### Sistemas de archivos NTFS

#### Componentes clave NTFS

#### MFT

#### Forense NTFS

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