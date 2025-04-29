# Hardening Network

### Configure interfaces and ftp/ssh services

Primero de todo se me borró parte del path:
```
echo 'export PATH=$PATH:/sbin' >> ~/.bashrc
source ~/.bashrc
```
Ahora sí, para configurar las interfaces manualmente editamos /etc/network/interfaces:
```
auto enp0s8
iface enp0s8 inet static
    address 192.168.2.15/24
```
Para habilitar ftp:
```
/usr/sbin/ftp -D
```

### Configure tcpwrappers

Para configurar tcp_wrappers editamos los ficheros /etc/hosts.allow y /etc/hosts.deny:
hosts.allow > hosts.deny > permit all
```
sshd: 192.168.12. 192.168.13. 192.168.14.
```
```
sshd: 192.168.12. 192.168.13. 192.168.14.
ALL: ALL
```

### Telnet and inetd service

Para activar el servicio telnet es necesario modificar /etc/inetd.conf:
```
telnet stream tcp nowait root /usr/sbin/tcpd telnetd
```
Y reiniar inetd:
```
/etc/init.d/inetutils-inetd restart
systemctl restart inetutils-inetd.service
kill -HUP pid de inetd
```
En hosts.allow/deny podemos filtrar con tcpwrappers:
```
ftpd: 192.168.2., 192.168.3., 192.168.4.
```
Extra:
```
telnet stream tcp nowait root /usr/sbin/telnetd telnetd
```

### Extra look at libraries used

Para mirar las librerías utilizamos:
```
ldd /usr/sbin/tcpd
```

### nftable configuration

Primero de todo, en caso de hacer un flush hay un comando de recuperación para no quedar sin conexión:
```

```
Esto es el sistema de filtrado de paquetes a nivel de kernel.

```
nft list ruleset [listar tablas y cadenas]
```
Las por defecto están en /etc/nftables.conf
```
nft add chain inet filter TELNETNOFTP [sin inet no va]
nft add rule chain filter TELNETNOFTP tcp dport 23 log
nft add rule chain filter TELNETNOFTP tcp dport 21 reject
nft add rule chain filter TELNETNOFTP tcp dport 23 accept
```
A mi me fue con esto:
```
nft add chain inet filter prerouting { type nat hook prerouting priority -100 \; }

nft add rule inet filter prerouting ip daddr { 192.168.2.10, 192.168.3.10, 192.168.4.10 } tcp dport 22 dnat to 10.0.3.100:222
```
Como digo qué paquetes van a cada una de esas cadenas (falta un jump, no?). Añadimos reglas a la tabla filter p.e.
```
nft add rule filter INPUT ip saddr '{192.168.12.105, 192.168.22.105}' jump TELNETNOFTP [Podemos ir mandando según queramos]
```
Para quitar reglas:
```
nft delete rule filter INPUT handle 25 
```

Para hacer NAT:
```

```

Hooks:
- input
- forward
- output


### Configure container to have static ip

Ya está hecho:
```
auto eth0
iface eth0 inet static
address 10.0.3.100
netmask 255.255.255.0
network 10.0.3.0
broadcast 10.0.3.255
gateway 10.0.3.1
```

## Extras

/etc/resolv.conf -> configuración del dns

/etc/hostname -> hostname

Si el network manager está deshabilitado y quieres hacerlo manual, en /etc/NetworkManager/NetworkManager.conf puedes poner:
```
[ifupdown] managed=false
``` 
Asignación de nombre de las tarjetas de red: Nombre que depende de la conexión física con la placa

### Inetd

/etc/services -> asocia cada puerto a cada nombre de conexión.
/etc/inetd.conf -> Qué hacer con cada conexión.
```
telnet stream tcp nowait root /usr/sbin/tcpd telnetd
ftp stream  tcp nowait  /usr/sbin/ftpd   ftpd
```

### Securize ssh

PermitRootLogin no

Para permitir módulos que pidan respuesta (como google auth):
ChallengeResponseAuthenticator yes
