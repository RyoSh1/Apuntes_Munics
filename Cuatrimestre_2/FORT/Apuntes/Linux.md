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

Las aplicaciones pueden tener agujeros de seguridad que ya conocemos o que aún no conocemos, se deben eliminar las aplicaciones que no sean necesarias en el sistema. Esto puede ser complicado debido a las dependencias, pero existe software que detecta paquetes no utilizados.

## Limitando los recursos de las aplicaciones

Se pueden establecer límites en /etyc/security/limits.conf que afectan a la sesión del usuario, controla el número de procesos, memoria, sesiones o uso de CPU. Para que sea efectivo se debe configurar el módulo pam_limits. Existen límites hard que no pueden modificarse y límites soft que son modificables por el usuario de la sesión.

Para limitar el uso de CPU en porcentaje de un programa se puede utilizar cpulimit (utiliza signals), para limitar los recursos se utiliza prlimit, lo cual nos permite limitar el impacto mediante un máximo de tamaño de pila, número de ficheros abiertos, etc.

cgroup es una característica que nos permite limitar el uso de recursos para un set de procesos, permite limitar el espacio demoria, procesadores o dispositivos de un grupo, establecer una prioridad, monitorizar el uso o controlar los procesos.

Los cgroups son jerárquicos, puedes crear subgrupos dentro de otros cgroups, las restricciones se heredan tanto entre grupos como los procesos hijo de un proceso.

Para configurar un cgroup se crea una carpeta dentro de /sys/fs/cgroups, se añade el PID al procs y se añaden los límites.

## Ejecutando en jaulas chroot

Los procesos en linux solo conocen el directorio actual y el raíz, chdir permite cambiar el directorio de trabajo y chroot el directorio raíz. Los programas no pueden acceder a ficheros fuera de su chroot, por lo que es posible configurar entornos chrooted, para ello en linux debemos montar los diferentes directorios que necesitemos como proc, sys o dev para permitir que el programa acceda a ellos dentro de su nueva raíz.

## Entornos virtualizados

El siguiente paso es aislar el sistema operativo de la aplicación, para ello se pueden usar los entornos virtualizados (que no máquinas virtuales), también llamado virtualización basada en contenedores.

A diferencia de las VM los contenedores no proporcionan tanto aislamiento, debido a que comparten parte de la instancia del kernel y del sistema operativo. Linux tiene su propia virtualización basada en contenedores llamada lxc, la cual permite crear a partir de una plantilla. Para su control se utilizan los subcomandos de lxc y los containers se encuentran en /var/lib/lxc/name/rootfs.

En la configuración del contenedor se puede decidir la conexión de red, el arranque automático y otros ajustes. También se puede configurar para poder ejecutar lxc como un usuario normal.

## M.A.C

D.A.C viene de Control de Acceso Discrecional, lo que significa que el dueño decida quien puede hacer qué con sus archivos. M.A.C viene de Control de Acceso Mandatorio, lo que significa que el sistema impone una política sobre quien puede acceder a qué independientemente de los permisos del usuario.

En MAC se usa la aproximación del mínimo privilegio, primero se comprueba DAC y luego se comprueba MAC, siempre denegando el acceso si uno de los dos lo aplica. 

Las soluciones presentes en Linux para MAC son SELinux y apparmor.

### AppArmor

En apparmor el kernel impone restricciones a las rutas, puertos y mecanismos de entrada y salida, este viene instalado por defecto desde debian 10. Para comprobar si está habilitado se accede a su fichero y se usan el comando aa-status para los perfiles y ps -Z para ver el estado de procesos en confinamiento.

Por cada aplicación bajo apparmor tenemos un perfil en /etc/apparmor.d, este tiene 2 modos de operación: enforce que impone las restricciones y complain que hace que se haga log en las violaciones de restricciones.

Comandos: apparmor_parser -r, aa-disable, aa-enforce, aa-complain.

Se puede crear un perfil vacío con aa-easyprof y tras editarlo se puede cargar (preferible usar plantilla).

### SELinux

Security Enhanced Linux es una serie de parches para el kernel de Linux que permiten implementar MAC. En SELinux cada aplicación, fichero... está etiquetado y el acceso solo se permite si hay una regla específica en la política.

Una política es una colección de reglas y cada regla describe una interacción entre proceso y fichero.

Como en apparmor hay dos modos: refuerzo, el cual bloquea el acceso y permisivo, que genera un log; los comandos getenforce y setenforce nos permiten ver y aplicar el modo.

Para aplicar SELinux en Debian se debe tener Debian instalado en ext, descargar los paquetes, ejecutar selinux-activate para que el sistema se etiquete en el siguiente arranque y configruarlo en /etc/selinux/config.

Una vez en ejecución se crea lo que llamamos selinux context, este se puede administrar con chcon, restorecon, secon y runcon.

# Tema 4 : Protección de cuentas de usuario

## Introducción a usuarios y grupos

Un usuario es una entidad del sistema que puede crear sus propios ficheros, procesos y ejecutar programas. Los usuarios se identifican con un UID (0 root), todos los ficheros pertenecen a un usuario y las credenciales de los procesos indican quien está detrás. Los usuarios tienen un UID, un nombre para mappear y un grupo.

Existen pseudousuarios que existen para ejecutar servicios específicos y poseer esos ficheros. 

Los grupos son un conjunto de usuarios y se identifican con un GID, los usuarios pueden estar en varios grupos, aunque uno es el primario.

### Ficheros de definición de usuarios y grupos

La información se guarda en los ficheros passwd que contiene los usuarios y su shell y shadow que contiene las contraseñas en hash. Los grupos por su parte tienen los ficheros group y gshadow.

## Módulos PAM

Los módulos de autenticación enchufables aportan una forma de cambiar los mecanismos de autenticación sin modificar las aplicaciones, es una API generalizada para servicios de autenticación. Si borras un módulo te quedas fuera.

Los módulos PAM pueden realizar las siguientes tareas:
- Gestión de la autenticación.
- Gestión de cuentas (horarios, máquinas, etc.).
- Gestión de sesión (contabilidad, límites).
- Gestión de contraseñas.

Un módulo PAM es una pieza de código que implementa primitivas para un mecanismo en particular, las opciones son:
- sufficient: Si este módulo da acceso ya hay acceso y no se comprueba el resto.
- requisite: Si este módulo deniega acceso este se deniega y no se comprueba más.
- required: Este módulo es necesario y se comprueban el resto.
- optional: Solo se usa si el resultado del resto de módulos no es determinista.

### Configuración de los módulos PAM. Nueva sintaxis ¿?

Las acciones a tomar pueden ser:
- ignore: El estado del módulo no contribuye al código de retorno de la aplicación.
- bad: Debe considerarse como retorno negativo.
- die: Termina inmediatamente la pila y el módulo PAM y vuelve a la aplicación.
- ok: Debe considerarse como código de retorno positivo.
- done: Igual que OK pero termina la pila y el módulo.
- reset: Limpia la memoria del stack y empieza con el siguiente módulo.

Los módulos suelen estar localizados en lib/security y su configuración se lleva a cabo en /etc/pam.d o en el pam.conf.

En el pam.conf la sintaxis viene precedida del servicio.

### Módulos PAM comunes

- pam_deny: Bloquea autenticaciones.
- pam_getenv: Recupera variables de entorno definidas en PAM.
- pam_rhosts: Autenticación basada en archivos .rhosts.
- pam_unix: Autenticación mediante passwd y shadow.
- pam_winbind: Autenticación de AD a través de Samba/Winbind
- pam_permit: Permite acceso.
- pam_access: Control de acceso basado en reglas definidas en security/access.conf.
- pam_cracklib: Reglas de seguridad para contraseñas.
- pam_env: Carga variables de entorno.
- pam_debug: Registro de depuración detallado.
- pam_echo: Mensajes por pantalla.
- pam_exec: Ejecuta programas o scripts.
- pam_ftp: Autenticación anónima.
- pam_localuser: Autenticación con usuarios locales.

## Protección de la autenticación

La autenticación es el proceso de verificar si una entidad es quien dice ser, esto se puede comprobar con dispositivos físicos, medidas biométricas, certificados digitales o contraseñas.

### Refuerzo de contraseñas

Los refuerzos básicos de la contraseña es restringir el acceso al fichero shadow, guardar un bloque de texto cifrado con la contraseña y no la propia contraseña, usar un salt para producir diferentes hashes, utilizar algoritmos lentos y complejos y poner condiciones en la creación de la contraseña.

La configuración se realiza en los ficheros login, common-auth y common-password, los principales módulos serían: pam_unix, pam_pwquality, pam_pwhistory, pam_securetty, pam_faildelay, pam_google_authenticator.

### Doble factor

Explicación del google authenticator.

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

El mantenimiento de un sistema se basa en el proceso contínuo de aplicación de parches, información sobre vulnerabilidades y monitorización de la actividad del sistema.

La principal fuente de información de un sistema es el log, los logs de autenticación y de sistemas críticos siempre se deberían enviar a otras máquinas.

## Logs, logfiles y syslogd

En su proceso de control del sistema, systemd guarda los logs en el systemd-journald, esto guarda los datos en forma binaria y se puede consultar con journalctl.

Aún así en sistemas con systemd se pueden instalar programas de log tradicionales, que son más sencillos de configurar y revisar.

### Logs

Un log es una descripción de un evento que ha ocurrido sobre un proceso del sistema, normalmente un demonio del sistema centraliza su control. Normalmente se guardan en /var/log y el demonio es el syslogd o rsyslog, estos leen su fichero de configuración al iniciar para decidir que hacer con los mensajes.

### Configuración de logs

La configuración de los logs se hace en /var/syslog.conf y estos se clasifican según el servicio que lo ha generado y la severidad de la alerta.

Los servicios se dividen en : auth, authpriv, cron, daemon, ftp, kernel, lpr, mail, news, syslog, user, uucp.

Los niveles de severidad son: emerg, alert, crit, err, warning, notice, info, debug.

El formato de configuración es selector tabulador action y se define el selector como facility.severidad, pudiendo configurar una lista o usando el comodín asterisco. La acción puede ser escribir en un fichero, enviar a otra máquina o notificar usuarios, estas opciones son combinables.

#### Extensiones

Para recibir logs de otras máquinas es necesario aceptarlos, normalmente en /etc/default/syslog. En los sistemas Linux existen muchas funcionalidades distintas que permiten hacer diferentes configuraciones de log, pasar el log hacia la salida por pantalla, etc.

## Rotación de logs

El problema de los logs es que crecen con el tiempo y ocupan demasiado espacio, la solución es rotar los logs creando nuevos ficheros cuando se alcanza cierto tamaño o antigüedad (logrotate).

Logrotate se encarga de rotar, comprimir o eliminar archivos de log y normalmente se ejecuta con el cron a diario. En /etc/logrotate.conf se realiza su configuración permitiendo especificar opciones según el fichero.

## Lynis

Lynis es una herramienta de auditoría del sistema que normalmente viene incluida en los paquetes de distribución de Linux. Se encarga de escanear la configuración del sistema y se ejecuta desde línea de comandos, la salida es un resumen de lo que se ha comprobado.