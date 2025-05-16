# Tema 1 : Protección del Arranque

## El proceso de Arranque

El arranque es el proceso por el que el SO se carga y el sistema está listo para usarse por los usuarios. Sigue un proceso de activación de servicios.

El arranque es muy dependiente del hardware y se distingue entre 2 formas: 
- El arranque automático es el más común, no requiere intervención, el sistema se lanza por si solo y expone un entorno multiusuario al terminar.
- El arranque manual se realiza cuando hay un error y es necesario revisar el arranque.

### Pasos del arranque

1. Cargar y ejecutar el programa de arranque del firmware de la placa base.
2. Cargar y ejecutar el gestor de aranque, depende de BIOS/UEFI.
3. Cargar y ejecutar el kernel de linux.
4. Ejecutar los scripts de inicialización e iniciar los servicios del sistema.

#### Motherboard Firmware

El firmware de la placa base contiene código para iniciar el arranque del sistema, esto depende del tipo de firmware BIOS, que está presente en las máquinas x86 de intel y algunas amd64 y UEFI, presente en las nuevas amd64.

Este código no es capaz de cargar el kernel, sino que carga el boot loader.

#### Boot Loader

El boot loader es un programa sencillo que define dos cosas: Qué kernel cargar y que dispositivo usar como sistema de ficheros raíz. Si el cargador entiende sistemas de ficheros se puede indicar directamente la localización del kernel, sino es capaz es necesario otra configuración.

#### Cargando el Kernel

El Kernel se carga en memoria y se le transfiere el control, normalmente se situa en /boot/vmlinuz. El Kernel es modular, por lo que puede necesitar un mínimo sistema de ficheros para gestionar módulos necesarios para el arranque.

Este crea sus estructuras de datos, busca dispositivos y realiza rutinas de inicialización. Crea *init* el primer proceso usuario del sistema, que inicia varios servicios.

#### Scripts de inicialización

Los scripts de inicialización realizan tareas rutinarias de arranque e inician los servicios. Init lee su archivo de configuración (/etc/inittab) donde obtiene el nivel de ejecución al que arrancar (para cambiarlo systemctl set-default y systemctl -list-units --type target). Si ocurre un error el sistema arranca en modo usuario único y se crea una shell raíz con solo el sistema raíz montado. Directorios /etc/rcN.d para distintos niveles de ejecución.

### Firmware BIOS y UEFI

#### BIOS

La placa base ejecuta código en cierta posición de memoria donde reside el firmware, este contiene rutinas de inicialización y a veces un menú de configuración. Se definen los dispositivos de arranque en una lista por orden.

El firmware no entiende sistemas de ficheros, lo que hace es cargar el primer bloque del disco y ejecutar el código que haya ahí, el primer bloque de un disco tiene el Master Boot Record, el cual es un programa muy sencillo que lee la tabla de particiones, lee el primer bloque de aquella con el flag activo y lo ejecuta.

El sistema de particiones usado es MBR, para instalar el cargador se debe instalar en el Master Boot Record para tener prioridad nada más arrancar o en el primer bloque de una partición para arrancar cuando esté activo.

#### UEFI

Igual que BIOS hasta lo siguiente.

UEFI entiene el sistema de ficheros FAT, el cargador de un programa en este sistema de ficheros, el firmware es capaz de ejecutar programas .efi.

Los discos deben usar una tabla de particiones GPT, en esta debe existir una partición EFI en formato FAT16 o FAT32 que contiene los drivers y cargadores EFI, los SO guardan sus cargadores en un subdirectorio por lo que se pueden cargar a nivel firmware. 

Por defecto se ejecuta el /EFI/BOOT/BOOTX64.EFI.

Para instalar un cargador se debe copiar el ejecutable en la partición EFI e indicar que se carge desde el programa de configuración del firmware o con efibootmgr en Linux. Secure boot se puede usar para comprobar su firma.

### Particiones

Los discos se usan para crear sistemas de ficheros en ellos, si un disco tiene varios sistemas de ficheros los llamamos particiones y se pueden combinar varias particiones en un sistema de ficheros con software de gestión de volúmenes lógicos.

Nomenclatura: Discos sda, sdb..., Particiones sda1, sda2...

Cada disco tiene una tabla normalmente en su primer bloque que define las particiones. Formatos: MBR, BSD, Solaris VTOC, GUID (GPT)...

#### Particiones MBR

La tabla de particiones se sitúa en el primer sector del disco y un disco puede tener hasta 4 particiones llamadas primarias, una partición se puede llamar extendida para subdividirla en particiones lógicas.

El primer sector de una partición se llama Extended Boot Record, tiene el mismo formato que la tabla MBR pero solo se usan los dis primeras entradas y si se necesitan más particiones una de ellas se define como extendida.

Las particiones MBR están limitadas a 2TB, se editan con fdisk o cfdisk y el grub las llama normalmente hdN, msdosM.

#### Particiones GPT

Se definen como parte del estándar EFI, supera la limitación de espacio de MBR usando 64 bits para el Logical Block Addressing.

Existen dos copias de GPT, la primaria al inicio del disco y la secundaria al final. El primer sector del disco tendrá una tabla MBR para permitir el arranque desde sistemas BIOS, el segundo es la cabecera primaria GPT.

La tabla GPT tiene entradas de 128 bytes. Para acceder se utiliza parted, gdisk o versiones modernas de fdisk. Linux las nombra hdN, gptM.

## Securizando el firmware

Para acceder al firmware se suele utilizar una combinación de teclas en el arranque, en este programa podemos configurar el dispositivo de arranque. Se debería bloquear el arranque con dispositivos externos e instalar una contraseña

## El cargador Grub



### Vulnerabilidades



## Securizando el Grub



## Otros cargadores



# Tema 2 : Protección del sistema de ficheros

## Conceptos básicos de ficheros y directorios



### Permisos



### Otro tipos de ficheros



### Comandos para manear ficheros



## Introducción a los sistemas de ficheros en Linux

### Discos y Particiones



### Sistemas de ficheros en particiones



### LVM



## Posibles amenazas



## ACLs



## Quotas



### Quotas en sistemas ext4

## Cifrados

### Cifrado de particiones



### Cifrado de LVMs



### encfs



## Bloqueando directorios y restringiendo acceso a dispositivos



# Tema 3 : Protección de aplicaciones

## Identificando y eliminando aplicaciones no utilizadas



## Limitando los recursos de las aplicaciones



## Ejecutando en jaulas chroot



## Entornos virtualizados



## M.A.C



### AppArmor



### SELinux



# Tema 4 : Protección de cuentas de usuario

## Introducción a usuarios y grupos



### Ficheros de definición de usuarios y grupos



## Módulos PAM



## Vulnerbailidades relacionadas con las cuentas de usuario



## Protección de la autenticación



## Limitando privilegios. Shells restringidas



## Convirtiendose en Root



## sudo y sudoers



# Tema 5 : Protección de la red

## Introducción: Configuración de red en sistemas Debian

### Configuración básica de la red



### Configuración NIC



### Network Manager



### ?



## inetd



## Control de Acceso: tcpwrappers



## Control de Acceso: Filtrado de paquetes



### Iptables



### nftables



## Ejemplo: Securizando el servidor sshd



# Tema 6 : Mantenimiento

## Introducción



## Logs, logfiles y syslogd



## Rotación de logs



## Lynis