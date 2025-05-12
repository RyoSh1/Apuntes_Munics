# Hardening Boot Procedure

### Check filesystem from grub

Pulsamos c durante el arranque para entrar en la línea de comandos.

```
ls [Check system disks]
set root=hd0,msdos1 [Set root for filesystem]
ls /
```

### Root command line from grub

Pulsamos e durante el arranque para entrar en el fichero de edición del grub.
```
linux... quiet init=/bin/sh
```
Otra opción desde comandos:
```
linux /boot/vmlinuz-...-amd64 ro quiet root=/dev/sda2 init=/bin/sh
initrd /boot/initrd.img...-amd64
boot
```

### Create Grub users

```
grub-mkpasswd-pbkdf2 [Generate hashed password]
...
sudo update-grub
```
/etc/grub.d/40_custom
```
set superusers="superpablo, superruby" 
password_pbkdf2 superpablo grub.pbkdf2.sha512...

set users="pablo"
password pablo pablo

```

Otra opción para limitar el acceso (/boot/grub/grub.cfg):
```
menuentry --users=user1  [Temporal]
```

### Grub entries

Se pueden añadir entradas al menú grub y limitar que usuarios pueden entrar en dichas entradas.
```
menuentry UserOnly --users=pablo {
        set root(hd0.msdos1)
        linux /vmlinuz root=/dev/sda1
        initrd /initrd.img
}
```


