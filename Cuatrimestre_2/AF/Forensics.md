# Análisis Forense
1. [TLS](#tema-1--transport-layer-security-layer-protocol)
2. [Características principales](#caracteristicas-principales)
3. [Ejemplo de uso](#ejemplo-de-uso)
4. [Conclusión](#conclusion)

# Tema 1 : Análisis Forense

## Introducción

### Informática Forense



**Principio de Locard**:

### Funciones o ámbito de actuación

## Guías para el proceso de investigación forense

#### UNE

#### ISO

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

#### Ficheros

#### Chats inaccesibles

## Preparación de la adquisición

#### Extracción de chats mediante downgrade

#### Entorno de prueba

### Activación del debugging con ADB

#### Problema de la máquina virtual

## Adquisición

## Análisis

### Fichero cache4.db

#### Tablas contacts y users

#### Tabla dialogs

#### Tablas chats y enc_chats

#### Tabla messages

### Acceso a base de datos

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