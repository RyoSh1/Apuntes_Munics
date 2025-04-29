# Hardening Applications

### Use cpulimit to limit a process

```
cpulimit -l 20 -p 36606 [20 - percentage 32478 pid]
```

### Create and configure a container

Primero crear el container, iniciar el container y asignamos un terminal.
```
lxc-create -t debian -n CONTAINER
lxc-start -n CONTAINER
lxc-attach -n CONTAINER /bin/sh
```
Creamos usuarios y contraseña para el root
```
passwd root
useradd -m user1
passwd user1
```
Configuramos el /etc/network/interfaces para configurar una conexión directa.
```
auto eth0
iface eth0 inet static
address 10.0.3.100
netmask 255.255.255.0
network 10.0.3.0
broadcast 10.0.3.255
gateway 10.0.3.1
```
Se puede modificar el puerto ssh en /etc/ssh/sshd_config
```
Port 222
```
También configuraciones del container en /var/lib/lxc/<name>/config

### Cgroup config

Creamos una carpeta en /sys/fs/cgroups
```
mkdir lab
cd lab

echo pid > cgroup.procs [Mete el proceso dentro]
```
Ahora una serie de comandos y utilidades.
```
cgroup.procs [Procesos del cgroup]
echo 1 > cgroup.freeze [Congelar todos los procesos del grupo]
echo 30000 100000 > cpu.max [limitar cpu]
```

### Configurar copias de comandos con apparmor

Para copiar un comando:
```
cp /usr/bin/ls /usr/bin/listar
```
Hay que crear la plantilla con easyprof, crear el fichero copiando la plantilla a mano y luego los siguientes comandos
```
aa-easyprof /usr/bin/listar [Crear el perfil]
aa-enforce /usr/bin/listar
apparmor_parser usr.bin.listar
aa-status
```
Podemos añadir permisos como los siguientes:
```
  # No read paths specified
        / r,
        /** r,
        deny /etc/** r,
        deny /etc/ r,
```
Despues restart apparmor
