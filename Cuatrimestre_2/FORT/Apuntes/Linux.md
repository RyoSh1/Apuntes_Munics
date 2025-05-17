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

Grand Unified Boot Loader es el cargador por excelencia de Linux, puede cargar múltiples SO, tiene gran configuración y entiende diferentes tipos de ficheros y particiones, El menú se puede editar durante la carga y tiene un modo de rescate que permite acceder a los sistemas de ficheros.ç

Existen 2 versiones:
- Grub Legacy: Fichero de configuración menu.lst editable a mano y solo puede cargar firmware tipo BIOS.
- Grub 2: Versión instalada actualmente que genera un script no editable en grub.cfg y que permite cargar BIOS y UEFI.

Para instalar el grub con BIOS se debe usar:
```
grub-install device
```
Para instalarlo con UEFI:
```
grub-install --efi-directory dir
```

Para modificar el grub 2 se debe editar el grub.d y ejecutar grub-mkconfig o en versiones modernas editar el custom.cfg y usar update-grub.

### Vulnerabilidades

Si se pulsa c en el grub se puede acceder a la línea de comandos del grub, desde ahí se puede acceder al contenido de las particiones.

Se puede modificar las líneas de menú al pulsar e, con los parámetros adecuados se puede hacer que el sistema nos acceda en modo único sin contraseña (privilegios).

## Securizando el Grub

Para limitar el acceso a las funcionalidades del grub se puede definir superusuarios, al añadir esta funcionalidad automáticamente se limita el acceso al editor de menu o a la línea de comandos. Como extra: Definir superusers bloquea al acceso a E y a C pero no a las entradas.

También existe la variable users, la cual nos permite definir entradas en el menú del grub con limitaciones según usuario y contraseña. La opción --unrestructed permite definir acceso libre.

Se debe configurar contraseñas para los users y superusers, para que esta no sea visible se usa el comando password_pbkdf2.

Toda esta configuración se debe añadir manualmente al fichero grub.cfg.

## Otros cargadores

LILO

# Tema 2 : Protección del sistema de ficheros

## Conceptos básicos de ficheros y directorios

Todo lo que se guarde en el sistema es un fichero, gran parte de la seguridad en unix depende del acceso a estos ficheros, estos se guardan en una estructura jerárquica similar a un árbol pero es un grafo.

### Permisos

Los ficheros tienen un usuario dueño y un grupo dueño y tiene 3 sets de permisos rwx (lectura, escritura y ejecución). El primer set es el del usuario dueño, el segundo el del grupo dueño y el último para el resto de usuarios, los sets de permisos se representan por números de 3 cifras en octal.

Existen otros 3 permisos especiales:
- Sticky bit: En equipos modernos no tiene efecto pero anteriormente hacia que tras ejecutar un fichero ejecutable la memoria swap no se deasignaba al terminar.
- Setgid: El proceso que ejecuta el fichero obtiene las credenciales del grupo dueño durante la ejecución.
- Setuid: El proceso que ejecuta el fichero obtiene las credenciales del usuario dueño durante la ejecución.

Permisos en directorios:
- Lectura permite listar el contenido, escritura permite añadir borrar contenidos y ejecución permite que el contenido sea accesible.
- Setgid hace que los ficheros creados en ese directorio pasen a ser propiedad del grupo dueño.
- Sticky bit hace que solo el dueño o aquellos con permiso de escritura de un fichero pueden borrarlo aun teniendo permiso de escritura sobre el directorio.

### Otro tipos de ficheros

- Dispositivos de bloque: No tienen espacio asignado, solo dos números para indicarle al kernel que driver usar cuando accede al dispositivo.
- Dispositivos de caracter
- Links simbólicos: Fichero cuyo contenido es el path al fichero apuntado.
- fifo : Fichero first in first out. ?¿

Los links no simbólicos no son ficheros especiales, simplemente le ponen otro nombre a un fichero.

### Comandos para manear ficheros

- mv
- cp
- chown
- chmod
- chgrp
- mkdir
- mknod: Crea un fichero especial (directorio, dispositivo o fifo)
- mkinfo: Crea un fichero fifo.
- ln: Crea un link.
- rm
- rmdir
- ls
- cd
- umask: Setea la mascara de creación del fichero.

## Introducción a los sistemas de ficheros en Linux

### Discos y Particiones

Los discos son dispositivos de bloques y en ellos se crean particiones, los sistemas de ficheros se pueden crear sobre un equipo o particion mediante el comando mkfs. En el comando mkfs se puede indicar el tipo con -t y este utiliza su submétodo (mkfs.ext4).

### Sistemas de ficheros en particiones

Para poder acceder a un sistema de ficheros es necesario montarlo en un directorio, una vez montado este puede accederse bajo dicho directorio, es posible indicarle los modos de acceso. El directorio raíz se indica en el boot loader, los ficheros que se deben cargar en el arranque se definen en el fstab.

En el fstab se introducen líneas con  directorio, tipo, opciones de montado, dump y pass. 

Las principales opciones de montado son defaults, ro, rw, nosuid, nexec, noauto, usrquota.

En sistemas modernos se puede indicar el nombre del dispositivo o el UUID (obtenido con blkid), por ejemplo:
```
UUID="d39577d4-fb9b-4b18-be4e-53ff32dbf856" /home ext4 noatime 0 2
```

Existen dos aproximaciones en el uso de discos y particiones:
- Tradicional: Montar sistemas de ficheros en discos y montarlos sobre directorios.
- Lógico: Combinar dispositivos para crear volumenes lógicos, este espacio es editable a posteriori.

### LVM

Los volúmenes lógicos son más flexibles porque permite añadir dinamicamente espacio. Un volumen físico es un disco o una partición y consiste en una cabecera y X número de extensiones físicas, para crear un volumen físico en una partición se crea una partición y dentro el volumen físico con pvcreate partition.

Un grupo de volúmenes es una colección de PV agrupadas, estos se pueden crear usando el comando vgcreate con los volúmenes a continuación. vgextend sirve para ir añadiendo.

Los volúmenes lógicos se crean encima de los grupos de volúmenes dandole un nombre y especificando el tamaño (lvcreate). El comando lvdisplay los lista y lvresize sirve para reescalarlo.

Al crearlo tenemos un fichero especial /dev/Volumen/Datos donde se puede crear un sistema de ficheros y se puede montar, este se puede añadir al fstab para tenerlo desde el arranque.

## Posibles amenazas

Las principales amenazas son:
- Acceso no autorizado a información guardada.
- Llenado del sistema previniendo que otros usuarios participen.
- Corrupción del sistema.
- En red o memorias externas ganar acceso a ejecutables maliciosos con mayores privilegios.

Respecto al acceso no autorizado sería adecuado marcar los home como 700, no permitir lectura en configuraciones y no permitir escritura en los directorios del sistema. Para mejorar esta configuración se pueden utilizar las ACLs o cifrar los sistemas de ficheros.

Respecto al llenado de disco se pueden establecer quotas y en otros discos para evitar acceso de privilegios deberia usarse nosuid y noexec.

Para impedir corrupción del sistema se debe usar sistemas de ficheros fiables, kernel actualizado, permisos correctos y mantener el equipo en un entorno estable.

## ACLs

Las listas de control de acceso permiten definir permisos específicos sobre usuarios y grupos, se establecen con setfacl y se comprueban con getfacl. Para su uso debe estar activo el soporte de acl y especificar la opción en el fstab para asegurar que el sistema de ficheros se montó con la opcion activa.

Poner ejemplo

## Quotas

Las cuotas permiten limitar el espacio que un usuario o grupo puede usar en un sistema de ficheros, estos datos residen en los ficheros aquota.user. Se pueden establecer unos límites en los ficheros (inodos) o en bloques (espacio) y se configuran dos límites soft (al llegar sale un warning) y hard (el sistema bloquea escribir más).

Para activar las cuotas es necesario montar el disco con usrquota o grpquota e instalar los programas de quota.

### Quotas en sistemas ext4

Las cuotas en ext4 se guardan en el directorio raíz del sistema de archivos en unos ficheros llamados aquota.user y aquota.group. Existen dos métodos de creación:
- Quotacheck -ucvm partición: En Ext 4 se fuerza con las opciones c y m la creación de los ficheros.
- La opción Ext4 es configurar las cuotras desde el momento de la creación del sistema de archivos con la opción quota, en el montado y luego con quotaon y edquota. Las cuotas se administran como atributos extendidos.

## Cifrados

### Cifrado de particiones

El módulo dm-crypt crea un link entre /dev/mapper/X y el dispositivo real, este dispositivo virtual funciona como una interfaz segura para acceder a un dispositivo físico cifrado. Se propone una contraseña de la que se deriva la clave real, esta se almacena en la memoria del kernel

Dos modos de uso de cryptsetup:
- Plain : Crea un enlace entre el dispositivo cifrado y el dispositivo plain, las opciones de cifrado se utilizan directamente para crear un mapeo entre el disco cifrado y un dispositivo con nombre.
- LUKS : Crea una cabecera en el dispositivo con las opciones de cifrado y la master key cifrada con la contraseña. LUKS nos permite guardar varias contraseñas para el mismo dispositivo.

### Cifrado de LVMs

La forma más simple es crear los volúmenes físicos en dispositivos ya cifrados.

### encfs

Encfs permite cifrar directorios específicos, su funcionamiento es similar a lo anterior. Para cambiar la contraseña se usa encfsctl y la información importante (cifrado y clave) se encuentra en el sistema cifrado en .encfs6.xml.

## Bloqueando directorios y restringiendo acceso a dispositivos

Se pueden configurar listas negras para indicar dispositivos que tengan acceso restringido al sistema o a ciertos directorios.

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