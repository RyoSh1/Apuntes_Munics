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

### Identificación

#### Revisión del entorno legal que protege el bien

#### Cadena de custodia

### Adquisición

#### Modos de adquisición

#### Clonado

#### Integridad

### Preservación

### Análisis

### Presentación de los resultados

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

#### Ficheros

#### Chats cifrados

#### Claves de cifrado

## Preparación de la adquisición

#### Entorno de prueba

### Activación del debugging con ADB

### Creación de backup

## Adquisición

## Análisis

### Acceso a base de datos

#### BD.wa.db - Tabla wa_contacts

#### BD.msgstore.db - Tabla messages

### Consultas para ver conversaciones

### Ficheros de la carpeta interna de Whatsapp

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