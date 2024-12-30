# Memoria examen de prácticas Redes


### Usuarios y contraseñas
**Direcciones de todo el escenario**
- **AL** : 
- **DL** : 
- **FW** : 
- **CPE** :
- **ISP** :
- **Máquina de salto** :

**Acceso por consola**
~~~
munics
bayern
~~~

**Acceso por Telnet**
~~~
telnet XX
munics
~~~
### Como resetear equipos
**Switch**
Apagamos el switch durante unos segundos.
Mantenemos el botón MODE unos 15 seg hasta que las luces se pongan de color verde-ámbar-verde.
~~~
flash_init
dir flash
rename flash:config.text flash:config.text.old
~~~
Tras iniciar en la configuración de fábrica:
~~~
ena
rename flash:config.text.old flash:config.text
copy flash:config.text system:running-config
~~~
**Router**
Tecla Break en Putty al mostrarse la línea: 'entry point: 0x80008000, size: 0x6fdb4c'
~~~
confreg 0x2142
reset
~~~

### Configuración inicial
Partimos del laboratorio 4 ya configurado, esto significa:

#### AL-SW
Acceso por consola ya configurado
Telnet ya configurado
Vlan 741
Dirección IP: 10.2.241.1

#### DL-SW
Acceso por consola ya configurado

Telnet ya configurado

Vlan 741

Dirección IP: 10.2.241.2

#### FW
Acceso por consola ya configurado

Telnet ya configurado

Vlan 741

Dirección IP: 10.2.241.3

#### CPE
Acceso por consola ya configurado

Telnet ya configurado

Vlan 741

Dirección IP: 10.2.241.4

#### ISP
Acceso por consola ya configurado

Telnet ya configurado

Vlan 741

Dirección IP: 10.2.241.5

#### Máquina de salto

**\etc\netplan\00-installer-config.yaml**
Añadidas las interfaces y las direcciones de Servicios y Administración.

**Importante**
~~~
netplan try
netplan apply
~~~

#### Configuración de puertos
~~~
interface XX
switchport trunk encapsulation dot1q
switchport mode trunk
~~~
~~~
interface XX
switchport access vlan YY
~~~

### Fin de la configuración inicial

## Configuración de VLANs en switches

### Creación de VLANs y configuración básica de red
~~~
vlan X
name X
exit
~~~
### Aplicación de VLANs
~~~
interface range g0/X-Y
switchport mode access
switchport access vlan XX
exit
~~~
~~~
ip domain name munics.pri
~~~
#### En DL añadimos direcciones y OSPF (capa 3)
~~~
int vlan X
ip addr <ip> <mask>
ipv6 addr <ip/msk>
ipv6 addr FE80::1 link-local
ip ospf X area Y
ipv6 ospf X area Y
exit
~~~

### En DL
~~~
ip routing
ipv6 unicast-routing
~~~
#### Activación de OSPF
~~~
router ospf X
passive-interface default
no passive-interface vlan X
ipv6 router ospf 1
passive-interface default
no passive-interface vlan X
~~~

### Configuración de routers
~~~
ip domain-name munics.pri
ipv6 unicast-routing
~~~
#### Interfaz
~~~
int <int>
encapsulation dot1q <vlan number>
ip addr <ip> <mask>
ipv6 addr <ip/msk>
ipv6 addr FE80::2 link-local
exit
~~~
#### OSPF
~~~
router ospf 1
ipv6 router ospf 1
~~~
?¿
~~~
int XX
ip ospf 1 area 0
ip ospf 1 area 0
~~~
~~~
router ospf 1
passive-interface XX
ipv6 router ospf 1
passive-interface XX
~~~
#### Ruta por defecto
~~~
ip route 0.0.0.0 0.0.0.0 <ip>
ipv6 route ::/0 <ip6>
~~~

## Configuración de autenticación, autorización, SSH y protección de red
~~~
aaa new-model
aaa authentication login <name1> local
aaa authorization console
aaa authorization exec <name2> local
aaa authorization exec <name3> group radius local
~~~
#### Acceso por consola
~~~
line con 0
password <password>
authorization exec <name2>
login authentication <name1>
~~~
#### Acceso remoto
~~~
line vty 0 4
password XX
access-class <name> in ## si ACL
authroization exec <name3>
login authentication <name3>
transport input ssh
~~~
#### RADIUS conf
~~~
radius server <name>
address ipv6 <ip> auth-port 1812 acct-port 1813
key <key>
~~~

### Configuración del SSH
Aparte de los pasos anteriores, es necesario añadir en /etc/ssh/ssh_config las siguientes líneas:
~~~
HostKeyAlgorithms=+ssh-rsa
PubkeyAcceptedAlgorithms=+ssh-rsa
KexAlgorithms=+diffie-hellman-group1-sha1
Ciphers aes128-cbc
~~~
#### Local BD
~~~
username <> password <>
~~~

## Protección de equipos en capa de Acceso

### Port Security

#### Tabla MAC
~~~
switchport port-security maximum 10
switchport port-security
switchport port-security aging time 740
switchport port-security aging static
~~~
Esto para evitar errores:
~~~
errdisable recovery cause psecure-violation
errdisable recovery cause dhcp-rate-limit
errdisable recovery cause mac-limit
errdisable recovery cause arp-inspection
~~~

#### Fortificación de STP
~~~
spanning-tree portfast default
spanning-tree portfast bpduguard default
~~~
#### Fortificación de CDP
~~~
int range XX-YY
no cdp enable
~~~
#### Fortificación de DTP
Se ponen las interfaces en modo access y en el interfaz g0/20 se introduce la línea:
~~~
switchport nonegotiate
~~~
#### Fortificación de dhcp
~~~
ip dhcp snooping vlan 16-18
no ip dhcp snooping information option
int XX
ip dhcp snooping trust
int range XX-YY
ip dhcp snooping limit rate 5
~~~
#### Fortificación anti ARP spoofing
~~~
ip arp inspection vlan XX-YY
int X
ip arp inspection trust
~~~
#### Prevención de VLAN Hopping
~~~
int range <no usadas>
switchport mode access
switchport access vlan 199
shutdown
end
~~~
En ambas interfaces del segmento trunk cambiamos la vlan nativa
~~~
switchport trunk native vlan 200
switchport trunk allowed vlan 16-18,741
~~~

## Seguridad Perimetral
Este apartado se divide en ACLs y Zone-Based Firewalls
### Como configurar ACLs
**Standard**
~~~
access-list <number> permit/deny <ip> <mask>
~~~
**Extendidas**
~~~
ip access-list extended <name>
permit <prot> <ip> <mask wc> <ip> <mask wc> eq <port> 
deny ip any any
~~~
#### Aplicar ACLs
~~~
interface <interface-name> 
ip access-group <acl-number> {in|out}
~~~

#### CBACs
Se le pone cada protocolo:
~~~
ip inspect name <name> tcp
ip inspect name <name> udp
ip inspect name <name> icmp
~~~
#### Detalles
Si ponemos dos ACLs en una misma interfaz las lee de forma ¿?¿?

### Configuración de Zone-Based Firewall
Para configurar por zonas, se establece un punto central que delimita todas las zonas definidas, en nuestro caso creo que siempre es Firewall.
#### Definición de zonas
~~~
zone security <zone name>
description ...
~~~
#### Configuración de tráfico
Creamos una ACL y la aplicamos a un classMap y a una Policy.
~~~
ip access-list extended <acl name>
    permit ...
    permit ...
    deny any any

class-map type inspect <name classmap>
match access-group name <acl name>

policy-map type inspect <policy name>
class type inspect <name classmap>
inspect
class class-default
description

zone-pair security <acl name> source <zone1> destination <zone2>
service-policy type inspect <policy name>
~~~
#### Asignación a las interfaces
~~~
int XX
zone-member security <zone name>
~~~
### Configuración de NAT
Creamos una access list que se active y un pool de direcciones para mappear
~~~
access-list X permit <ip> <mask wc>
ip nat pool <name> <ip> <ip> netmask <mask>

ip nat inside source list X pool <pool name> OVERLOAD
~~~
#### Port forwarding
~~~
ip nat inside source static <prot> <ip IN> <port IN> <ip OUT> <port OUT>
~~~
## IDS/IPS (no creo que entre)
Primero si es necesario introducimos lo siguiente
~~~
delete flash:ipsdir/*
~~~
Ahora lo activamos
~~~
ip ips name ioips_pod2
ip ips config location flash:ipsdir

ip http serverip ips notify sdee
ip ips notify log
service timestamps log datetime msec
logging <ip>

ip ips signature-category
category all
retired true
exit

category ios_ips basic
retired false
exit
exit
confirm
~~~
**Aplicamos en una interfaz**
~~~
int XX
ip ips iosips_munics1 out ! ??
~~~
#### Pasar el archivo de firmas
~~~
scp -o KexAlgorithms=+diffie-hellman-group1-sha1 -o HostKeyAlgorithms=+ssh-rsa -o PubKeyAcceptedAlgorithms=+ssh-rsa -c aes128-cbc -0 IOS-S1035-CLI
~~~
### Activación de reglas
~~~
ip ips signature-definition
signature XXXX Y
status
enabled true
retired false
~~~