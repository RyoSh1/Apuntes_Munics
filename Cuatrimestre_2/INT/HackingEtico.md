# Tema 1 : Test de Penetración

### Hackers

- White Hat: Hackers éticos, trabajan como especialistas de seguridad.
- Black Hat: Buscan obtener ganancias personales.
- Gray Hat: Buscan problemas y ayudan, pero solicitan una recompensa.

#### Hackers vs Crackers

Los crackers son como los Black Hat pero rompiendo y robando software.

#### Los otros "Hackers"

- Script Kiddies: Aquellos que no saben y usan scripts directos para entrar.
- Newbie: Inofensivo buscando información sobre hacking.
- Lammer: Se cree Hacker y no tiene conocimientos reales.

### Certificaciones



### Vulnerabilidades

Una vulnerabilidad es un fallo inherente de las tecnologías disponibles.

Colecciones típicas: CWE, NVD, OWASP.

### Ataques

Tipos de ataques: Interrupción, Intercepción, Modificación, Fabricación.

### Amenazas



### Vector de ataque

Rutas o medios utilizados para realizar los ataques, un vector de ataque le permite al atacante explotar o tomar ventaja de alguna vulnerabilidad o debilidad existente en el sistema.

### Modalidades de hacking

- White Box: Información previa detallada.
- Grey Box: Información parcial de la organización.
- Black Box: Auditorías sin información previa.

### Fases del Test de Penetración

1. Reconocimiento: Se recopila toda la información posible que será utilizada en las siguientes fases. Se buscan nombres de dominio, direcciones de correo, topologías de red, direcciones IP, etc.
    - Footprinting: Búsqueda en medios de acceso público.
    - Fingerprinting: Recabar información sobre topología, direcciones, nombres, estado de puertos, versiones, etc.
2. Enumeración: Utilizando la información previa se buscan vectores de ataque. Involucra el escaneo de puerto, servicios y vulnerabilidades.
3. Acceso: Acceso al sistema a través de la explotación de las vulnerabilidades detectadas.
4. Mantenimiento de acceso: Preservar el acceso al sistema comprometido.

### Blue team vs Red Team vs Purple Team

Blue Defensa, Red Ataque, Purple Mezcla y entrenamiento.

### PenTesting adicionales

Ingeniería social, Wardriving, Robo.

# Tema 2 : Reconocimiento y Enumeración

### Footprinting y Fingerprinting

- Footprinting: Instantánea de los elementos observables en la red.
- Fingerprinting: Escanear las máquinas disponibles.

#### Tipos de reconocimiento

- Activo: Conexión directa.
- Pasivo: No hay interacción.

## Capa de Enlace

#### ARP

Traducción de direcciones de red en direcciones MAC.

**ARPing**: Envía tramas ARP en la capa de enlace como Ping en capa de red.
```
arping X.X.X.X -c 1
```
**NetDiscover**: Alternativa a arping.
```
netdiscover -r X.X.X.X/24

netdiscover -p  # pasivo
```
**Nmap**: Permite evitar el envío de ping (-Pn disable host discovery, solo port scan), sondeo de lista (-sL).

Limitación que las solicitudes ARP no atraviesan routeres.

## Capa de Red

**fping**: versión optimizada de ping que escanea múltiples objetivos mediante un round-robin.

**hping3**: Además de ICMP permite varios varios tipos de paquetes, trazado de rutas, evasión de firewalls y ataques DDos.
```
hping3 --rand-source 192.168.56.4
```

**Nmap**: Permite un montón de opciones, con el parámetro -sn realizas un escaneo de red, son --disable-arp-ping se desactiva ARP.

## Capa de Transporte

En esta capa entra en juego TCP y UDP.

**hping3**: Es posible escanear puertos conocidos con el flag SYN, puertos conocidos por UDP o tiempos de vida.
```
hping3 --udp192.168.56.4 -p 53
```
**Nmap**: También es posible atacar losflags.


## Otros Vectores

### Registros Web

- Whois: Se encuentra bloqueada en la UE. Aunque se puede usar www.nic.es.

### Correos electrónicos

- TheHarvester: Recopilación de cuentas de correo, nombres de usuario y nombres de host/subdominio.

### Recopilación de información



## DNS y Dominios

### DNS

Sistemas implementados con una base de datos distribuida que permiten buscar la correspondencia entre nombre e IP.

Registro de recursos: Los datos almacenados del DNS.

### Dominios

**nslookup**: Búsqueda del servidor de nombres (activo y pasivo).

Un registro SPF es un registro TXT que especifica una lista de nombres de host / direcciones IP autorizados que el correo puede originar para un nombre de dominio dado. Permite verificar si un servidor DNS permite la extracción completa de registros.

### DNS - Zonas de Transferencia

Con el parámetro ns se puede obtener los servidores DNS autoritativos.

Comando dug

### DNSRECON

Herramienta de enumeración de DNS utilizada en ciberseguridad para recopilar información sobre dominios y servidores DNS. Es especialmente útil en auditorías de seguridad y pruebas de penetración.

## Google Hacking

Realizar búsquedas con operadores avanzados:
- filetype: Tipo de documento.
- site: Sitio, dominio o subdominio específico.
- inurl: Páginas con determinada palabra.
- allinurl: Páginas con varias palabras.
- intext: Palabra en el texto principal.
- allintext: Páginas que contengan todos los términos en el texto.
- intitle: Palabra o frase en el título.
- inanchor: Texto subrayado coincida con la palabra.
- related: Páginas similares.
- info: Conocida por goole.
- link: Muestra de páginas que se vinculen.
- cache: Caché de google.

Caracteres especiales para búsquedas:
- +: Inclusión
- -: Exclusión
- ": Coincidencia
- .: Sustitución char
- *: Sustitución string
- |: OR

A esto se le llama google dorks.

## SHODAN

Buscador especializado en buscar los banners de las webs. Operadores: after, before, os, port, net, hostname.

## Escaneo y estado de los puertos

Abierto, Cerrado, Filtrado, No-Filtrado, Abierto | Filtrado, Cerrado | Filtrado.

### Escaneos NMAP

- **Stealth**: Realiza conexión TCP incompleta SYN > SYN-ACK > RST.
- **XMAS**: Usa los flags PSH, FIN y URG, si está abierto no hay respuesta, si devuelve RST está cerrado y si da unreachable está filtrado. -sX.
- **Zombie**: Escaneo a través de una máquina intermedia. nmap -P0 -p--sI 192.168.1.2 192.168.1.150

## Fingerprint de Servicios

Banner grabbing: Peticiones para identificar el servicio y su versión.

## NMAP Script Engine

Automatización de tareas mediante nmap, interesante los enum o headers. -script.

## OS Fingerprinting

No sé que es P0f sinceramente. Creo que una herramineta de fingerprinting pasivo de sistemas operativos.

Activos: scapy, fping, LYNIS, SARA, DMITRY, XENMAP, XPROBE2.

## Medidas Defensivas

SpamHAUS Project.

# Tema 3 : Análisis de Vulnerbailidades

Identificar y analizar las vulnerabilidades en los sitemas de la red objetivo.

Vulnerabilidad local = Acceso local.
Vulnerabilidad remota = Acceso remoto.

## OpenVAS

Suite de software que ofrece un marco de trabajo para integrar servicios y herramientas para el escaneo y gestión de vulnerabilidades. El escaner utiliza la base de datos Network Vulnerability Test que se actualzia diariamente mediante OpenVAS NVT Feed.

3 niveles de alerta, los dos primeros informan sobre la vulnerabilidad y el riesgo bajo da recomendaciones.

## Nessus Vulnerability Scanner

Plataforma más confiable para el escaneo de vulnerabilidades, permite utilizar diversos escaners, asistentes para políticas y programas de escaneo y envía los resultados por correo.

## Nikto

Para test de intrusion sobre servidores web, el Scan Tuning permite especificar los tipos de test contra el objetivo. Upload, Interesting, Misconfig, Info Disclosure, Injection, File retrieval, DOS, Remote File, Command, SQL Injection.

libwhisker para sigilo. Macros para combinar plugins. Mutate para algo así.

# Tema 4 : Explotación de Vulnerabilidades

## SearchSploit

Herramienta de búsqueda en línea de comandos para Exploit-DB. Opción t para buscar por título, X para visionado básico del exploit, M para guardarlo, XML para nmap.

## Metassploit

Proyecto Open Source para el desarrollo y ejecución de exploits contra máquinas remotas.

### Módulos

- Auxiliares: Permiten obtener información sobre el objetivo.
- Exploit: Programas que explotan una o varias vulnerabilidades para gannar acceso.
- Payload: Acompaña a un exploit para realizar funciones específicas en el sistema objetivo.

Tipos de Payload:
- Singles: Payloads autónomos que realizan una tarea concreta en el sistema.
- Stagers: Encargados de crear conexión entre cliente y víctima.
- Stageds: Descargados y ejecutados por los Payloads del tipo Stagers.

Otros:
- Encoders: Para cifrado y evasión.
- Nops: Interrumpen la memoria para poder insertar payloads correctamente.
- Post: Para post explotación.

### Comandos más usados

- help
- back
- cheack
- connect
- exploit
- run
- irb
- jobs
- unload
- loadpath
- resource
- route
- info
- set
- unset
- sessions
- show
- setg
- save
- use
- use

### Meterpreter

Comandos principales:
- background
- bgrun
- channel
- close
- help
- irb
- migrate
- quit
- run
- use
- cat
- cd
- del
- download
- edit
- getlwd
- getwd
- lcd
- lpwd
- ls
- mkdir
- pwd
- rm
- rmdir
- upload
- execute
- getpid
- getprivs
- kill
- reboot
- reg
- shell
- shutdown
- sysinfo
- ipconfig
- portfwd
- route
- getsystem
- hashdump
- timestomp

# Tema 5 : Explotación o escalado de privilegios

Formas básicas de ganar privilegios: SetUID, archivos como root, etc.

## Escalado de privilegios con Metasploit



### getsystem con Linux



### UAC de Windows



### getsystem con Windows



## Escalado de privilegios en Linux - Automático


### LinPEAS



### LinEnum



### Linuxprivchecker.py



### Unix-privesc-check



### SUDO_KILLER



## Escalado de privilegios en Linux - Manual


### SUID



### Capabilities



### LD_PRELOAD y NOPASSWD



### sudo_inject



### Wildcard



### Buscando passwords



### TT Updating



## Escalado en sistemas Windows



## Buscando passwords en Windows



# Tema 6 : Enumeración WEB



### Gobuster



### wfuzz



### Burp Suite



### Privacidad sobre todas las cosas



# Tema 7 : Pivoting



## Proxychains



## Chisel



## FoxyProxy



## File Transfering



# Tema 8 : Borrado de Huellas



### Destrucción del sistema



### Destrucción de logs



### Ficheros peligrosos



### Búsqueda de nueva información



# Tema 9 : Directorio Activo



### Elementos dentro de AD



### Árboles vs Bosques



### Conceptos de tickets



### Enumeración



## Ataques

### Kerberoasting



### Pass-The-Ticket



### Pass-The-Hash



### Golden Ticket Attacks



### Silver Ticket Attacks



### DCSync Attack



### Overpass-The-Hash



### Elevación de privilegios


# Tonterías extra

Ghidra: Un decompilador de código máquina a C creado por la NSA.

Caido: Estilo Burpsuite pero más potente.

SnmpBulkwalk: herramienta para snmp escrita en GO que permite recuperar eficientemente un subárbol de información de un dispositivo de red mediante peticiones GETBULK.

msf-pattern...: Para cosas de patrones e introducción de datos en memoria.

Linux tiene 64 de TTL y Windows 128 de TTL