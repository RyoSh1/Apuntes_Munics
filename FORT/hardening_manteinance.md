# Hardening Manteinance

### Create RSA Keys and connect via ssh

Para generar inicialmente las claves:
```
ssh-keygen [generar la clave en la máquina cliente]
ssh-copy-id user001@192.168.2.10 [copiar las claves desde cliente en objetivo]
```

### Manage Log into container



### Auth Logs sent to another machine and tty



### Different solutions for log sending



### Lynis

Primero ejecutamos Lynis:
```
sudo lynis audit system
```
Luego para arreglar los fallos que te indique podemos editar (para ssh) el /etc/ssh/sshd_config.