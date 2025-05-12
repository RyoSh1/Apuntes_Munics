# Tema 1 : Protección del Arranque

## El proceso de Arranque



### Pasos del arranque



### Firmware BIOS y UEFI



### Particiones



### Particiones MBR y GPT

## Securizando el firmware



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