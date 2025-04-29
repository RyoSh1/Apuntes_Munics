# Hardening File Systems

### Establish quotas on users home

Editar el /etc/fstab y añadir "usrquota,grpquota" en /home.
```
quotacheck -ugcvm /home
quotaon /home
edquota [Editar el fichero de quotas]
```
Para propagar la quota:
```
for i in $(seq -w 1 100); do 
    edquota -p usuario_referencia user$i
done

```
Para editar cuota temporal para usuarios o grupos:
```
edquota -t
edquota -tg
```
En el caso de querer modificar grupos:
```
groupadd files_limitados
usermod -g files_limitados user018
usermod -g files_limitados user019
edquota -g files_limitados
```

### Use ACLs to permit/block access to files

```
setfacl -m "u:user001:rw" /boot/grub/grub.cfg
getfacl /boot/grub/grub.cfg
```

### Create partitions and add disks

```
fdisk [Creación y particionado de discos]
```

### Work with crypted filesystems plain

```
cryptsetup open /dev/sdb1 cfplain --type plain
mkfs.ext4 /dev/mapper/cfplain
mkdir /crypt1
mount /dev/mapper/cfplain /cd crypt1/
touch a
umount /crypt1/
cryptsetup close cfplain
```


### Work with crypted filesystems LUKS

```
cryptsetup -y -v luksFormat --type luks /dev/sdb2
cryptsetup open /dev/sdb2 cfluks
mkfs.ext4 /dev/mapper/cfluks
mkdir /crypt2/
mount /cev/mapper/cfluks /crypt2
```
Ahora hay que añadir las keys (nspq):
```
cryptsetup luksAddKey /dev/sdb2 [3 veces]
```
Y cerramos como antes:
```
cd crypt2/
touch a
umount /crypt2/
cryptsetup close cfluks
```

### Work with logical volumes

```
pvcreate /dev/sdbX
pvdisplay
vgcreate NAME /dev/sda4 /dev/sdb1
vgextend NAME /dev/sdb2 [Añadir 1]
lvcreate -L 3G NAMEp -n NAMEl
lvdisplay
```
Ahora trabajamos con el como una partición
```
mkfs /dev/NAMEp/NAMEl
mount /dev/NAMEp/NAMEL /mnt
```
Se puede extender mediante:
```
lvextend -L +SIZE /dev/NAMEp/NAMEl
```

Para cifrar el volumen hay dos opciones. No recomenado:
```
cryptsetup -y open /dev/NAMEp/NAMEl NAME --type plain
mkfs /dev/mapper/volCifrado
mount /dev/mapper/volCifrad /mnt/
df -h
umount /mnt
cryptsetup close volCifrado
cryptsetup open /dev/NAMEp/NAMEl NAME2 --type plain
mount /dev/mapper/volCifrado /mnt/
...
lvremove /dev/NAME/NAME
```
Recomendada: Montar el grupo de volumenes y luego montar los volumenes lógicos (cifrar mediante plain o luks algunos de los físicos):
```
cryptsetup open -y /dev/sda4 cifra1 --type plain
cryptsetup open -y /dev/sdb1 cifra2 --type plain
cryptsetup open -y /dev/sdb3 cifra3 --type plain
cryptsetup luksFormat /dev/sdb2 cifra1 --type luks
cryptsetup open /dev/sdb2 CifradoLuks

pvcreate /dev/mapper/cifra1
pvcreate /dev/mapper/cifra2
pvcreate /dev/mapper/cifra3
pvcreate /dev/mapper/CifradoLuks
pvdisplay

vgcreate GrupoCifrado /dev/mapper/cifra1 /dev/mapper/cifra2 /dev/mapper/cifra3 /dev/mapper/CifradoLuks
vgdisplay -v

lvcreate -L 4G GrupoCifrado -n VolLogCifrado
mkfs /dev/GrupoCifrado/VolLogCifrado
mount /dev/GrupoCifrado/VolLogCifrado /mnt/
reboot
...
pvdisplay
fdsik -l (están ahi pero estan cifrados)
cryptsetup open /dev/sda4 c1 --type plain
vgdisplay
cryptsetup open /dev/sdb1 c2 --type plain
cryptsetup open /dev/sdb2 c3
cryptsetup open /dev/sda3 c4 --type plain
pvdisplay, vgdisplay, lvdisplay
mount /dev/GrupoCifrado/VolLogCifrado /mnt/
```

### ENCFS

```
mkdir .crypted
mkdir CLEAR
encfs /home/usuario/.crypted/ /home/usuario/CLEAR/

cp /var/log/debug  /var/log/syslog CLEAR/
ls .crypted/ [aparecen aqui]
fusermount -u /home/usuario/CLEAR [?]
encfsctl passwd .crypted/ [Cambiar contraseña]
```
