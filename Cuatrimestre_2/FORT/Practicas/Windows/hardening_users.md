# Hardening Users

### Block or permit root login

Con securetty podemos filtrar los tty permitidos
```
echo "tty3" > /etc/securetty
```
Es necesario añadir en /etc/pam.d/ login y lightdm el módulo:
```
auth required pam_securetty.so
```
restart lightdm y listo.

Para entrar en tty CTRL-Der + Fx

TODO: Required/Sufficient/Requisite...

### Filter becoming su

```
groupadd wheel
usermod -a -G wheel user001
```

Añadimos al /etc/pam.d/su lo siguiente:
```
auth sufficient pam_wheel.so group=suwheel root_only trust
auth requisite pam_wheel.so group=wheel root_only trust
```

### Passwords
Para comprobar cifrado de contraseñas /etc/pam.d/common-passwords. Añadiendo sha256 en vez de yescript tenemos nuevo cifrado.

Para cambiar todas las contraseñas:

```
for i in `seq -w 1 100`; do HSPASS=$(mkpasswd -m sha-256 "qwerty$i"); echo "user$i:$HSPASS" | chpasswd -e; done
```

### Password requisites

Para añadir requisitos en las contraseñas es posible simplemente utilizar el módulo pam_pwquality donde cada valor cuenta como un crédito.

```
pam_pwquality.so retry=3 minlen=10 dcredit=-2 ucredit=-1 ocredit=-1 remember=3
[d = dígitos, u = mayúsculas, o = especial]
```

### Restringed Bash

```
usermod --shell /bin/rbash user010
mkdir -p /home/user010/restricted_bin
ln -s /bin/ls /home/user010/restricted_bin/
```
Ahora es necesario modificar el /home/user010/.bashrc y cambiar el propietario del archivo para que no se pueda restaurar.
```
export PATH=/home/user010/restricted_bin
...
chown root:root /home/user010/.bashrc
```

### Permissions "as" on user

Editamos el /etc/sudoers y añadimos lo siguiente:
Para que user020 pueda gestionar el sistema de ficheros.

```
user020 ALL=(root:root) FILESYSTEM

```
Para que se puedan hacer pasar todos por user010.
```
ALL ALL=(user010:user010) ALL
```
Para grupos.
```
%adm ALL=(ALL:ALL) NOPASSWD: ALL
```

### Login without password

En el /pam.d/login y lightdm añadimos lo siguiente:
```
auth sufficient pam_succeed_if.so user = usuario quiet_success
```

## Extras

Comprobar grupos de un usuario "groups, id, "