# Diseño de Redes Seguras

## *Repaso Inicial

### OSPF

Protocolo de enrutamiento dinámco que pertenece a la categoría de los protocolos de estado de enlace; cada router que usa OSPF comparte información sobre las conexiones que tiene con otros router de la red.

**Funcionamiento**: Descubrimiento de vecinos mediante 

**Intercambio de información**: Routers vecinos se comunican y comparten su información de enlace, creando una especie de mapa completo de la red.

**Cálculo de ruta**: Dijkstra para la ruta más corta.

**Actualizaciones rápidas**: Actualización antre fallos.

#### Mensajes en OSPF

LSA (Link State Advertisements)

1. **Hello**: Periódicos, descubrimiento de routers, área a la que pertenece, tipo de red y lista de routers vecinos.
2. **DBD**: Resumen de la base de datos de rutas conocidas.
3. **LSR**: Link State Request, Solicitud de detalles de un estado de enlace cuando un router descubre que su BD está incompleta.
4. **LSU**: Link State Update, incluye múltiples LSAs, los detalles sbre las rutas y el estado de las conexiones.
5. **LSAck**: Recepción de los LSAs enviados por otros routers.

### Modelo OSI

1. **Capa Física**: Transmisión de datos en forma de bits en medios físicos como cable o WiFi.
2. **Capa Enlace**: Transferencia fiable sobre el medio físico, se detectan errores y se crean tramas.
3. **Capa Red**: Direccionamiento de paquetes.
4. **Capa Transporte**: Asegura la entrega sin errores, de forma completa y ordenada.
5. **Capa Sesión**: Gestiona las sesiones entre dispositivos.
6. **Capa Presentación**: Traducción y formateo de datos para su correcta interpretación.
7. **Capa Aplicación**: Proporciona interfaces y servicios de red para los usuarios.

### IP

- Clase A:
10.0.0.0 - 10.255.255.255
Máscara de red: 255.0.0.0 o /8

- Clase B:
172.16.0.0 - 172.31.255.255
Máscara de red: 255.240.0.0 o /12

- Clase C:
192.168.0.0 - 192.168.255.255
Máscara de red: 255.255.0.0 o /16

- Multicast Clase D:
224.0.0.0 - 239.255.255.255

- Clase E (Experimental/Reservado):
240.0.0.0 - 255.255.255.255

- Rango público:
1.0.0.0 - 223.255.255.255

- Loopback (localhost):
127.0.0.0 - 127.255.255.255

- Link-Local:
169.254.0.0 - 169.254.255.255

### STP

Spanning tree protocol es un protocolo de red que previene bucles en una red conmutada (switches, capa 2) al asegurar un único camino activo entre la topología de la red.

El problema de la congestión puede surgir debido a una tormenta de broadcasts, multiplicidad de tramas... y provocar el colapso.

STP reacciona a fallos en switches on enlaces reconfigurando la red y activando los caminos redundantes, garantizando conectividad.

#### Proceso STP

1. Root Bridge: Todos los switches envían mensajes BPDU (Bridge Protocol Data Units) intercambiando información sobre sus identificadores y prioridades. El switch con la Bridge ID más baja (Prioridad y MAC)es elegido como Root Bridge (p.d 32768).
2. Asignación de puertos:
    - Root Port: Cada switch selecciona un puerto hacia el Root Bridge, es el camino más corto (determinado por coste).
    - Designated Port: En cada segmento de red se elige el puerto con el mejor camino hacia el Root Bridge, este se mantiene activo para reenviar tramas.
    - Non-Designated Ports: Cualquier otro puerto será bloqueado para evitar bucles.
3. Estado de los puertos:
    - Blocking: Puerto bloqueado.
    - Listening: Esperando BPDU.
    - Learning: Learning (MAC).
    - Forwarding: Reenviando tramas y operativo.
    - Disabled: Desactivado.

### NAT

Network Address Translation es una técnica utilizada en redes para modificar la dirección IP en los encabezados de los paquetes mientras viajan a través de un router o firewall, sirve para que múltiples dispositivos de una red local compartan una única dirección IP pública.

¿Cómo se realiza el mapeo? - El router NAT mantiene una tabla de traducción que mapea las direcciones IP privadas y los números de puerto internos a la dirección IP pública y el número de puerto externo. Cuando llega un paquete externo el router NAT recibe la dirección pública con el puerto asignado y lo traduce hacia la dirección privada correspondiente a ese puerto.

El contenido de una tabla NAT normalmente tiene los siguientes campos: IP Privada, Puerto interno, IP pública, puerto externo.

El puerto asignado hacia el exterior es asignado dinámicamente por el router.

### VLAN

Virtual Local Area Network son una forma de segmentar las redes en un mismo switch físico o a través de varios switches, creando redes lógicas independientes.

Para mantener los paquetes de datos separados estos vienen etiquetados con la VLAN a la que pertenecen, esto lo hace el switch desde la interfaz en la que entra el paquete inicial (física o virtual).

Trunking es el tráfico de varias VLAN ya etiquetadas a través de un mismo cable físico hacia otro switch o router.

## Modelo Jerárquico

### 1. Capa de acceso

Proporciona acceso a los usuarios al segmento local de la red(Ethernet o WiFi).
El switch clasifica los paquetes(p.e etiqueras de prioridad).

### 2. Capa de distribución

Centraliza la conectividad de red en un edificio, realiza el filtrado de paquetes, transición entre enrutamiento estático y dinámico, aplicació de QoS.

### 3. Capa núcleo

Parte central de la red, se encarga de conmutar paquetes a alta velocidad., evitar la manipuación de paquetes.

### Implementación tradicional

- Enlaces de capa 2 dentro de *acceso* y entre acceso y distrubución.
- Enlaces de capa 3 entre distribución y core.
Distribución es la capa frontera entre capas 2 y 3: - En distribución se lleva a cabo el enrutamiento entre las VLAN y el core.
- Desventaja: STP necesario para permitir un diseño con enlaces redundantes en capa 2.

#### Per VLAN STP

Un truco para mejorar el balanceo de carga es crear un router virtual entre los dos routers, por ejemplo con HSRP y configurar como switch root ambos routers, es decir creas dos topologías en vez de una única, así los enlaces se siguen usando y en caso de caida de algún enlace se mantienen los procesos de búsqueda por VLAN.

### Capa 3 hasta acceso

Llevas la capa 3 hasta acceso haciendo que no sea necesario el uso de STP, las VLAN pasan a ser locales a cada switch de capa de acceso y aumenta el coste de instalación.

### Virtual Switches

Los switches se comportan como uno solo, utiliza *Etherchannel* que es una tecnología que permite agrupar enlaces físicos en uno lógico.

### Núcleo colapsado

Se combinan las capas de distribución y núcleo en los mismos dispositivos de red físicos. Utilizado en redes pequeñas, se incluyen dos equipos en capa distribución por redundancia.

### Modelo jerárquico en WAN

Varias opciones: en estrella extendida, en anillo o en malla completa.

## Patrones de Diseño

Permiten crear una arquitectura global de red de forma modular en base a áreas funcionales, podemos dividirlo en: Campus, Centro de Proceso de Datos, Sucursal y Acceso remoto.

### Campus corporativo

Infraestructura de red de la sede principal de la organización, se basa en el Modelo Jerárquico. En las redes actuales incorpora un submódulo adicional que es el Data Center.

En cada edificio de la sede habrá un *Building Block* que está compuesto por: Building Access (conectividad de usuarios) y Building Distribution (Enrutamiento basado en políticas).

El Campus Core interconecta todos los módulos de la red.

### Frontera corporativa

Componentes que interconectan el área de Campus con el exterior, bien con internet o con los módulos remotos.

Consta de los siguientes componentes:
- E-commerce (servicios, aplicaciones, bases de datos, firewalls y routers...).
- Definición de la DMZ y control de acceso a internet.
- Conectividad con otras sedes de la organización(Tecnologías como SD-WAN).
- Acceso remoto mediante VPNs.

### Módulo frontera de proveedor de servicios

Implementado por los proveedores de servicios de comunicaciones.

### Módulos remotos

- Módulo de sucursal: Infraestructura de red de una oficina pequeña con acceso a la sede principal. WAN para acceder a los servicios corporativos.
- Módulo CPD Remoto: Puede constituir un centro de respaldo o delegar la actividad de una determinada área geográfica. Requiere infraestructura de red, servicios interactivos y elementos de gestión.
- Módulo de teletrabajador: Acceso a internet que disponga y VPNs de acceso.

## Aproximaciones de Seguridad Perimetral

### Division por zonas

Reestricción de acceso entre las distintas partes de la red para agrupar lógicamente dispositivos con mismás poíticas y requisitos de seguridad. Las zonas se separan mediante puntos de interfaz.

#### Tipos de zonas:

- Zona pública: Zona externa que no está bajo control de la organización.
- DMZ: Alberga los servicios públicos de la empresa, aquí se encuentran los proxies.
- Zona restringida o privada: Zona interna que contiene los servicios de datos críticos.

Además de la división en zonas y la utilización de dispositivos de seguridad específicos, es necesario usar configuraciones adecuadas y tecnologías de seguridad como:
- Acceso seguro a la red: Es necesario controlar y proteger los dispositivos finales de los usuarios de la organización.
- VPN: Facilita la conectividad con la sede principal de la organización a través de una red insegura.
- Protección de infraestructura: Limitar el acceso a usuarios y dispositivos autorizados.
- Gestión de Red y Seguridad: Herramientas de gestión centralizada.

# Fortificación de los dispositivos de red

## Arquitectura interna de los dispositivos de red

Los dispositivos de red forman parte del perímetro de seguridad de una red, por lo que están expuestos a un gran número de amenazas. Además estos equipos operan en base a su configuración y a información que reciben de otros routers o switches (Enrutamiento o BPDUs).

Es necesario verificar que la información que llega de otros equipos es auténtica, para evitar envenenamiento de la red.

Dividimos un dispositivo de red en 3 planos:
- Plano de Gestión: Tráfico recibido para su administración (SSH, Telnet).
- Plano de Control: Relacionado con la toma de decisiones en los envíos (STP, HSRP...).
- Plano de Datos: Envío de datos de los usuarios (políticas de seguridad).

### Introducción: Seguridad en el plano de gestión.

#### Objetivos
- Permitir el acceso a usuarios autenticados (Contraseñas de línea, Usuarios locales o AAA). Listas de métodos (4 max).
- Gestión de la identidad (ISE, FREERADIUS...).
- Proteger la sincronización horaria (importante).
- Monitorización segura (Syslog, SNMPv/v3).
- Proteger el sistema de ficheros (archivos de configuración).
- Limitar el acceso físico a los dispositivos.

#### Buenas prácticas
- Reforzar directivas de contraseñas.
- Definir grupos de usuario.
- Desplegar servicios AAA.
- Proteger NTP.
- Redes e IPs diferenciadas para restringir inicios de sesión.
- Deshabilitar servicios no necesarios.

*Vistas: Un conjunto disjunto de comandos, se asigna un rol a una vista y un rol a X usuarios.

### Introducción: Seguridad en el plano de control.

#### Objetivos

- Limitar el daño que un atacante podría infringir al enviar tráfico directamente a las IPs del dispositivo.

- Controlar la información relacionada con la toma de decisiones de envío.

#### Buenas Prácticas

- Para proteger la CPU: En router y utilizando mecanismos de caché.
- Para proteger el "camino de datos": Paquetes relacionados con la toma de decisiones de envío que son recibidos o enviados por los equipos de red.

#### CPPr (Control PLane Protection)

Clasificación detallada del tráfico, utilizando 3 subinterfaces:
- Host: Maneja el tráfico hacia una interfaz física o lógica del router.
- Transit: Gestiona el tráfico del plano de datos que necesita intervención de la CPU (opc IP, cifrado).
- CEF-Exception: Relacionado con el tráfico que procesa CEF en el que se producen excepciones.

Se pueden establecer filtros y limitar el tráfico.

### Introducción: Seguridad en el plano de datos.

#### Objetivos

- Implementar políticas de seguridad que definen que flujos de tráfico de usuarios están permitidos o denegados.

-Se utilizan: ACLs, VLANs, priv VLANs, IPS, Firewalls.

#### Buenas Prácticas

- Implementación de ACLs para filtrar el tráfico.
- Firewall para control de acceso y control de zonas.
- IPS en equipos de red o en equipos dedicados.
- TCP *Intercept*: técnica de detección de sesiones TCP malformadas.
- Unicast Reverse Path Forwarding: Comprueba la dirección IP de los paquetes entrantes y analiza si concuerda con la interfaz de entrada.
- Mecanismos de seguridad en capa 2.

## Protección en el Plano de Gestión

Protección de la infraestructura de red, evitar el acceso no autorizado. Para ello es necesario establecer políticas de seguridad, proteger el acceso de gestión, utilizar ssh y ACLs, realizar backups de las configuraciones, monitorizar la red y desactivar servicios no necesarios.

1. Seguir la plítica de acceso al router.
2. Proteger el acceso físico.
3. Usar contraseñas fuertes.
4. Control de acceso al router.
5. Acceso seguro a la gestión.
6. Uso de protocolos de gestión segura.
7. Reforzar la seguridad de las conexiones virtuales.
8. Implementar sistema de logging.
9. Copias de seguridad periódicas.
10. Desactivar servicios no necesarios.

### Política de seguridad en un router

La politica de seguridad en un router debe contestar las siguientes cuestiones:

- Como se cifran contraseñas y su complejidad.
- Como se configura la autenticación.
- Como se definen los parámetros de acceso.
- Cómo se gestionan servicios no necesarios.
- Filtrado de tráfico.
- Seguridad en protocolos de enrutamiento.
- Mantenimiento de configuraciones.
- Gestión de cambios.
- Actualizaciones de seguridad.

### Cifrado de contraseñas

Existen varios métodos de obtención de contraseñas por parte de un atacante:

- Información personal.
- Sniffing TFTP.
- Fuerza bruta.
- Claves de invitado.
- Herramientas.

Puertos que requieren claves:

- Puertos consola.
- Puertos auxiliares.
- Conexiones de terminal virtual.
- Acceso al modo privilegiado.

En redes grandes se usa RADIUS. BD local en redes pequeñas. 0 a 15 en privilegios.

## Autenticación, Autorización y Auditoría (AAA)

En una red corporativa podemos controlar "Quién" se conecta *Autenticación*, "Qué" puede hacer *Autorización* y se implementan sistemas de *Auditoría*.

**AAA** es un framework que controla el acceso de gestión a los dispositivos de una red utilizando los métodos de usuarios nombrados anteriormente.

- Ventajas: Flexibilidad y control de acceso, escalabilidad, backup, autenticación estandarizada.

- Autenticación: Local AAA, Servidor AAA.

#### AAA basada en servidor

- **RADIUS: Remote Dial-in User Services**
    - Conexión entre router/switch y servidor AAA.
    - Solo cifra la clave del usuario usando MD5 derivado y clave secreta, resto en plano.
    - Estándar IETF.
    - Se usa en los ISP porque permite información de facturación. Los Proxy utilizan RADIUS.
    - Utiliza UDP, puertos 1645/1812 autenticación.

- Autenticación:
    1. Habilitar globalmente AAA.
    2. Especificar servidor.
    3. Clave de cifrado entre servidor de acceso a red y AAA.
    4. Lista de métodos de autenticación.

- Autorización:
    - Objetivo asegurar el acceso al dispositivo.
    - Permitir o no acceso a los usuarios autenticados a distintas áreas de la red.
    - RADIUS no separa autenticación de autorización.
    - Se puede permitir o no la ejecución de determinados comandos.

- Auditoría:
    - El servicio de Accounting AAA permite rastrear el uso de recursos, recoger información de BDs y producir informes.
    - El servidor AAA es un repositorio de información de eventos.
    - Las sesiones se monitorizan y se almacena su información.
    - Necesario definir listas de métodos.

### Configuración de SSH

SSH proporciona confidencialidad e integridad en las comunicaciones frente a Telnet. Los pasos a seguir son los siguientes:

1. Asegurar una versión IOS compatible.
2. Nombre de host único.
3. Nombre de dominio correcto.
4. Routers configurados con autenticación AAA local.

### Servicios de restauración y backup

El objetivo es realizar copias de seguridad de IOS y de las configuraciones.

Herramientas básicas: Backups de configuración, Backups de software, Inventario de hardware, Herramientas de despliegue (FTP, TFTP, SCP).

#### Servicios no usados

Es importante desactivar los siguientes servicios: DNS, CDP, NTP, BOOTP, DHCP, Proxy ARP, Source routing, IP redirects y HTTP service.

### Protección del plano de control

La protección del plano de control afecta al plano de gestión y al de datos. Si este se corrompe puede llegar a ser imposible recuperar la estabilidad de la red.

Los paquetes del plano de control son generados y recibidos por los propios dispositivos de red y permiten el funcionamiento de la propia infraestructura.

#### Minimizar el tráfico de control

Tipos de paquetes que deben ser procesados por la CPU:

- Tráfico dirigido a la IP del propio equipo de la red.

- Tráfico del plano de datos que requiere procesamiento especial:
    - Paquetes que coinciden con una ACL y generan un syslog.
    - Unicast Reverse Path Forwarding.
    - Opciones IP.
    - Fragmentación.
    - Expiración de TTL.
    - Paquetes que generan "ICMP unreachable".
    - Tráfico no IP.

#### Control Plane Policing

Permite identificar el tipo y el ratio de tráfico que puede alcanzar el plano de control.

#### Control Plane Protection

Funcionalidad similar a CoPP que proporciona una mayor granularidad sobre el control de tráfico, dividiendo la interfaz control-plane en tres subinterfaces: Hots, Transit, CEF-Exception.

La configuración es similar pero más compleja.

# Tema 3 Seguridad LAN en entornos Ethernet

### Configuraciones de seguridad básicas

- Contraseñas Seguras.
- Configuración de banners.
- Acceso seguro a la consola (físico y lógico).
- Acceso seguro a través de líneas VTY.
- Deshabilitar el demon HTTP.
- Deshabilitar los servicios no necesarios.
- Utilizar SNMPv3.
- Asegurar la topología de spanning tree: identificar el Root Bridge, activar el root-guard, utilizar BPDU guard.
- Reducir al mínimo el uso de CDP/LLDP.
- Configurar sistema básico de logging.

#### Configuración básica de los switches

- Desactivar la negociación de trunking.
- Eliminar las VLANs no utilzadas manualmente.
- Configurar los puertos no utilizados.
- Enlaces troncales.
- Seguridad en los puertos de acceso.
 
### Vulnerabilidades mitigables en capa 2

- Análisis Pasivo: Recopilación de información sin inyección de tráfico (Escucha de tráfico en un puerto).
- Análisis Activo: Inyectar tráfico a nivel de capa 3 en la red.

## Ataques típicos en Redes de Campus

Tipos de ataques: 

- Accesos no autorizados desde dispositivos falsos.
- Ataques de explotación de la operativa MAC Ethernet.
- Ataques de suplantación.
- Ataques dirigidos contra las VLAN.

### Accesos no autorizados desde dispositivos falsos

Conexión de un punto de acceso no autorizado a la infraestructura de la red, se trata de una brecha de seguridad debido a que si se conecta a una red interna se crea un punto de entrada detras del "firewall" de la organización.

Un atacante con acceso físico a la red podría conectar un switch con la intención de alterar el funcionamiento de STP, hacer sniffing, etc.

### MAC flooding o Saturación de la tabla de envío

Ataque que consiste en sobrecargar la tabla CAM de forma que las tramas convencionales se envíen por todos los puertos. Si un atacante introduce en el switch un número muy alto de direcciones MAC inválidas no se podrán aprender las direcciones asignadas a los puertos correctos, debido a esto el tráfico se enviará por todos los puertos excepto por el que entró.

Objetivo: Recibir todo el tráfico o DoS.

###  ARP spoofing attack

La respuesta ARP un dispositivo legítimo contiene la dirección MAC del propio equipo como respuesta a una petición. En el ataque ARP spoofing, un atacante utiliza su dirección MAC para que aparezca como destino de una IP que no es la suya, provocando que este robe la información.

Pueden utilizarse mensajes tipo "gratuituos arp" para envenenar las cachés arp de los dispositivos del dominio de broadcast.

ARP no utiliza autenticación.

### DHCP Spoofing attack

Un atacante puede generar respuestas DHCP como si fuera un servidor válido. Para esto primero agota todas las direcciones IP ofertadas por el servidor mediante peticiones con direcciones MAC falsas (prioridad si el DHCP está en otra VLAN). Después envía a los usuarios las direcciones IP y máscara como respuesta.

Si el atacante define como camino por defecto y como servidor DNS su máquina mantendrá el direccionamiento de la red y capturará todo el tráfico tanto exterior como interior (Man-in-the-middle).

### Ataques de salto VLAN

Ataques que permiten que un sistema final envíe y/o reciba paquetes de una VLAN que no debería ser accesible para este equipo.

**Switch Spoofing**: El atacante configura su equipo para establecer un enlace trunk utilizando el protocolo DTP. Al activarse el puerto como troncal este envía y acepta tráfico desde y hacia cualquier VLAN.

**Double Tagging**: Se generan tramas con dos cabeceras 802.1Q. El primer switch verá que la etiqueta es de la VLAN nativa y tratará el paquete como si fuese de una trama sin etiquetar, al llegar al segundo switch este lee la etiqueta de la segunda VLAN tratandola como si lo fuese.

Las prevenciones se definen en la sección de buenas prácticas.

## Fundamentos de Spanning Tree Protocol

### Introducción a STP

Spanning Tree Protocol es un protocolo que bloquea determinados puertos para crear un árbol lógico mientras existe una estructura de grafo cíclico a nivel físico, es decir, un camino activo entre todos los dispositivos del segmento.

Problemas derivados de la topología redundante: Tormentas de broadcast, Transmisión de tramas múltiple, inestabilidd de las tablas MAC.

STP utiliza Bridge Data Protocol Units para mantener un camino activo para cada segmento de red, restableciendo la conectividad activando rutas previamente inactivas.

### Estándares Spanning Tree

- Versión riginal de STP desarrollada en 1985 y estandarizada en 1990 (802.1D), solo 1 LAN o VLAN.

- Common Spanning Tree: una única instancia de ST y la convergencia de la red es lenta debido a los temporizadores.

- Cisco PVST y PVST+: Es una mejora patentada por Cisco que proporciona una instancia de ST independiente para cada VLAN, admite mejoras de seguridad en puertos.

- Multiple Spanning Tree o 802.1s: Asigna múltiples VLANs que tienen los mismos requisitos de flujo de tráfico en la misma instancia de ST para reducir el número de instancias. La implementación de Cisco permite 16 instancias de RSTP (802.1w).

- Rapid STP: Convergencia más rápida que STP, pero solo tiene una instancia STP.

- Cisco PVRST+: Una mejora de RSTP que proporciona una instancia independiente de 802.1w por VLAN.

### Operación STP

1. Elegir un Root Bridge
2. Seleccionar el Root Port en todos los no Root Bridges. 
3. Seleccionar el puerto designado en cada segmento.

- Root Port: Ruta de menor coste desde el puerto no raíz hasta el puente raíz. Reenvian tráfico de datos hacia el Root Bridge, la dirección MAC origen de las tramas puede rellenar la tabla MAC, solo un Root Port por Bridge.
- Puerto Designado: En los Root Bridge todos son designados, solo hay un designado por segmento, los designados pueden introducir direcciones en la tabla MAC.
- Puerto NO Designado: No reenvía tramas de datos y no rellena la tabla MAC.
- Disabled Port: Deshabilitado.

### Bridge Protocol Data Units

Son los paquetes que intercambian información, se envían cada 2 segundos, la MAC origen es la del puerto que envía y la MAC destino es 01-80-C2-00-00-00 (multicast).

Dos tipos: 

- BPDUs de configuración: Utilizados para calcular y mantener el árbol STP.
- TCN: Se utilizan para informar a todo el segmento de red o VLAN de un cambio de la topología.

Campos: Prot ID, Version, msg type, Flags, RB ID, RP Cost, Sender Bridge ID, Port ID, Msg Age, Max Age, Hello time, Forward Delay.

#### Elección del Root Bridge

Cada switch tiene un Bridge ID único (Bridge Priority, Dirección MAC), se selecciona como Root el switch con el BID inferior. Cuando se arranca todos son raíz y envían BPDUs por todos los puertos, cuando reciben BPDUs deciden si estos tienen BID mejor.

#### Elección del Root Port

Se determina el coste del camino sumando todos los enlaces entre switch local a Root Bridge. (10 Gbps - 1, 1Gb - 4, 100 Mb - 19, 10 Mb - 100)

Cuando dos puertos tienen el mismo coste se selecciona el menor Port ID (Prio + número). Esta información es la que recibe en las BPDUs.

#### Elección de los Designated Ports

Después de elegir el Root Bridge y los Root Ports es necesario determinar los puertos designados de cada enlace, se elige en base al Path Cost del switch, en caso de empate menor BID y menor PID.

### Estados de los puertos

Cuando un puerto está "shutdown" está en estado desactivado, cuando se activa pasa a estado bloqueo y después puede evolucionar a los otros.

- Blocking: Puerto no designado y no participa en el reenvío de tramas. Recibe BDPUs para determinar la ubicación y el ID del switch raíz y que roles de puerto debe asumir cada switch en la topología.
- Listening: El puerto puede participar en el reenvío de tramas según las BPDUs recibidas. El puerto no solo recibe sino que también transmite sus propias BPDUs e informa a los switches adyacentes que el puerto del switch se prepara para participar en la topología activa.
- Learning: Se prepara para participar en el reenvío de tramas, rellena la tabla CAM.
- Forwarding: Se considera parte de la topología activa, envía y recibe BPDUs.
- Disabled: Desactivado, no participa en nada.

### Per-VLAN STP Plus

PVST+ es una implementación de Cisco que propociona una instancia STP separada para cada VLAN. En el campo prioridad se transporta el VLAN ID (VID).

### Vulnerabilidades de STP

- Es un protocolo no autenticado.
- Los switches emiten y aceptan BPDUs por todos sus puertos.
- Si el atacante es capaz de establecer un enlace troncal se convierte en el raíz de todas las VLANs.
- Solución: Utilizar los mecanismos de defensa.

## Medidas de Seguridad

### Ataques de capa 2 y contramedidas

- MAC Address Flooding.
- VLAN Hopping.
- Ataques entre dispositivos de la misma VLAN.
- DHCP Starvation y Spoofing
- Spanning-tree.
- MAC Spoofing.
- ARP Spoofing.
- Manipulación de CDP.
- Ataques a SSH y Telnet.

### Port Security

Es una característica de los Switches Cisco que permite restringir en un puerto las direcciones MAC a aprender en lista o en número. Sticky learning es una característica que convierte dinámicamente las direcciones aprendidas en direcciones "seguras".

Port Security supone una protección ante MAC Flooding y MAC Spoofing.

### DHCP Snooping

Para evitar los ataques de DHCP Spoofing existe la funcionalidad DHCP Snooping. Esta permite definir qué puertos del switch pueden responder a peticiones DHCP, identificandose como fiables o no fiables.

Los puertos fiables permiten enviar todo tipo de mensajes DHCP y los no fiables solo peticiones, si un dispositivo intenta enviar respuestas DHCP por un puerto no fiable este se deshabilita.

Para cada puerto no fiable se construye una Binding Table, estas tienen una entrada por cada dispositivo configurado por el servidor DHCP.

### Dynamic ARP Inspection

Es una técnica que previene el ataque de ARP Spoofing, asegurando que solamente se enviarán respuestas ARP válidas. Se verifican la dirección MAC e IP asociada entes de enviarse al equipo destino, sino se descartan.

DAI determina la validez de una respuesta ARP en función de los vínculos almacenados en las tablas de DHCP Snooping.

DAI: Envía los paquetes ARP recibidos por interfaces fiables sin hacer comprobaciones y comprueba los de las interfaces no fiables.

### Protección de STP

#### BPDU guard

Se utiliza para proteger una red conmutada de los posibles problemas generados de la recepción de BPDUs por puertos que no deberían (al añadirse un switch a la red).

BPDU Guard pone una interfaz para STP PortFast en el estado err-disable tras recibir una BPDU. Desactiva las interfaces como medida preventiva para evitar bucles. EL administrador debe reactivar manualmente la interfaz después de reparar la configuración no valida.

#### BPDU Filtering

BPDU Filtering impide que un switch envíen BPDUs en interfaces con PortFast habilitado. Cuando está aplicado globalmente hace que todos los puertos con PortFast al recibir BPDUs se desactivan perdiendo el estatus PortFast y funcionando como cualquier otro puerto STP. 

BPDU Guard no tiene efecto si está activado Filtering.

#### Root guard

Root Guard es útil para evitar bucles de capa 2 durante los cambios topológicos o fallos en la red. Esta característica fuerza a una interfaz a convertirse en un puerto designado, si el bridge recibe BPDUs superiores por un puerto con Root Guard activado, este cambiará a root-inconsistent, equivalente al listening, por lo que no reenviará tráfico por ahí.

# Tema 4 Firewalls

Los Firewall son dispositivos que filtran el tráfico entre redes, permiten establecer requisitos de seguridad en cada red; analizar, registrar y bloquear tráfico y actuar en distintas capas OSI.

Aportaciones: 

- Ayuda a implementar políticas de control de acceso.
- Es la primera línea de defensa.
- Minimiza problemas de vulnerabilidades conocidas de protocolos al limitar la conectividad entre redes.
- Ayuda a implementar las políticas de seguridad.
- Permiten guardar log del tráfico de red.

Limitaciones:

- Ineficaces ante bugs en aplicaciones o servicios.
- No protege contra ataques mediante conexiones autorizadas.
- Solo protege contra conexiones que lo atraviesan.
- Pueden ser molestos para los usuarios.
- Deben configurarse, administrarse y monitorizarse adecuadamente.

## Tecnologías Firewall

### Filtrado estático de paquetes

Operan normalmente en la capa 3 y 4, filtran en base a características del paquete sin guardar información de contexto.

- Dirección IP origen.
- Dirección IP destino.
- Tipo de tráfico (UDP, TCP, etc.)
- Características de capa 4 (TCP flags, ICMP command)
- Interfaz por la que llega o se recibe.

Están dirigidos por un conjunto de reglas que se ejecutan en orden:

- Parte de matching con la que deben coincidir paquete y regla.
- Acción a realizar(Aceptar, Denegar, Descartar, etc.)

### Filtrado dinámico de paquetes o Stateful Packet Filtering

El firewall no analiza los paquetes individualmente, sino en su contexto. Se filtran conexiones no paquetes y añaden conocimiento de sesión.

Operativa:

- Mantienen una tabla con el estado de las conexiones salientes, que utilizan para validar los paquetes entrantes (más adecuado para TCP, con UDP es impreciso).
- Mayor carga.
- Permiten paquetes de entrada solo si están relacionados con una conexión existente previamente autorizada: Conexiones TCP, Respuestas a UDP, Errores y respuestas ICMP .

#### Conclusiones sobre los Firewall de filtrado de paquetes

- Permiten el control de la mayor parte de protocolos empleados actualmente y son eficientes, solo examinan ciertos campos del paquete.
- Controlan el tráfico de red: Bloqueo/Autorización de servicios y reducción de la carga en la red interna.
- Protección frente a múltiples ataques que aprovechan vulnerabilidades de TCP/IP.

#### Buenas prácticas en Firewalls de filtrado de paquetes

Se recomienda bloquear:

- Tráfico hacia el propio firewall de orígenes no autenticados.
- Tráfico ICMP.
- Tráfico con direcciones no válidas: Tráfico entrante desde una IP interna, tráfico entrante con dirección privada, tráfico de entrada o salida con dirección broadcast y direcciones marcianas.
- Paquetes especiales.
- En general todo el tráfico, salvo aquel necesario (política restrictiva).

#### Limitaciones en Firewalls de filtrado de paquetes

- Problemas al gestionar cierto tipo de protocolos.
- No impiden ataques que aprovechan vulnerabilidades a nivel de aplicación.
- Capacidad de logging limitada.
- No soportan autenticación de usuarios.

## Firewall de Capa de aplicación

### Filtrado de Capa de Aplicación

El filtrado a nivel aplicación examina el contenido del paquete no solo las cabeceras IP y de capa 4, tiene una mayor capacidad de análisis (Mejor gestión de conexiones, escaneo de malware, bloqueo de ataques a nivel de aplicación, bloqueo de contenidos y bloqueo de comandos). También utiliza información de capas inferiores.

#### Ventajas

- Mejor control de las conexiones para ciertos protocolos: Es habitual que firewall de filtrado de paquetes incorporen conocimiento a nivel de aplicación para ciertos protocolos.
- Identificación de ataques a nivel de aplicación.
- Mayor capacidad de logging.
- Identificación de protocolos a nivel aplicación.

#### Limitaciones

- Soporte limitado de aplicaciones y protocolos: El filtrado de capa 7 es complejo, normalmente solo hay para ciertos protocolos y existen problemas con protocolos nuevos o propietarios.
- Menor rendimiento porque deben analizar el contenido del paquete, esto supone un problema con aplicaciones en tiempo real.
- Siguen sin solucionar el problema de autenticación a nivel de usuario.

#### En dispositivos basados en IOS

Los routers basados en IOS pueden llevar tareas que van más allá del filtrado de paquetes convencional, como **stateful inspection** que incluye parámetros que van desde capa 3 a capa 7.

Context-Based Access Control es la funcionalidad que implementa stateful inspection:

- Analiza diferentes parámetros de distintos protocolos de capa 7.
- También implementa un modo de operación sencillo, basado en el análisis de la información de protocolos de capa 3 y 4: TCP/UDP generic stateful inspection (equivalentes al comportamiento del filtrado dinámico de paquetes).

## Zone-Based Firewall (ZBFW)

La configuración de firewalls basada en zonas de seguridad es la aproximación más habitual en la mayor parte de fabricantes de estos dispositivos. Es una tecnología que permite la configuración de un router siguiendo la misma filosofía que un firewall hardware, estableciendo zonas de seguridad, el router funciona como frontera y define que tráfico se puede enviar entre zonas.

Por defecto las interfaces que pertenecen a la misma zona se pueden comunicar entre ellas y las que pertenecen a diferentes zonas no pueden intercambiar paquetes.

#### Zonas especiales: Self & Default

- La Self-zone es una zona que incluye todas las IPs de los routers. El tráfico desde y hacia esta zona se permite para dar soporte a Gestión y Plano de control. Después de aplicar una política a un par self--otra la comunicación debe definirse explícitamente.
- La default-zone es una zona de seguridad que incluye todas las interfaces que no son miembros de otra zona de seguridad de forma explícita. Se pueden aplicar políticas en pares que la incluyan.

### Configuración

1. Creación de zonas.
2. Definición de un método de clasificación de tráfico (class map).
3. Definición de la política de inspección.
4. Aplicación de la política a los flujos de tráfico entre zonas.
5. Asociar las interfaces de red a las zonas.

## Traducción de direcciones

### Network Address Translation (NAT)

Separa direcciones IP internas de externas, esto permite ahorrar direcciones IP, garantizar el control del firewall sobre las conexiones con el interior, ocultar el esquema de direccionamiento interno y ayuda a restringir el tráfico entrante.

Tipos:

- NAT estático: Cada IP privada tiene asociada una IP pública.
- NAT dinámico: Conexiones basadas en un "pool" de direcciones.
- Port Address Translation (PAT o NAT con sobrecarga): Se utiliza una IP pública única y se realiza el mapeo basandose en el número de puerto.

# Tema 5 Servidores Proxy

## Conceptos

### Servidores Proxy

Un proxy es un dispositivo o software que actúa como intermediario entre un dispositivo final y otro cliente o servidor que proporciona o solicita un servicio. Puede ser independiente o estar integrado en el firewall.

Se crearon para proporcionar servicio de caché, pero también ayudan a realizar tareas de log registrando las actividades. Hoy en día se utilizan para seguridad (Filtrado de contenidos en capa 7 y aplicación de políticas de acceso a internet).

No funcionan como routers, se debe establecer una conexión con el proxy y este con el servidor remoto, es un complemento a los firewall y es resistente a ataques capa 3.

#### Características

- Son específicos para cada tipo de protocolo de capa de aplicación.
- Es necesario un agente/servidor proxy para cada tipo de aplicación.
- Facilitan el proceso de autenticación de usuarios (obligación de autenticación, filtro de contenido, gran capacidad de logging).
- Cuando se utiliza un proxy para controlar las peticiones desde internet a un servidor en la DMZ se usa un proxy inverso.

#### Limitaciones

- Requiere una configuración desde el software del cliente.
- Proporcionan menor rendimiento: Introducen latencia y requieren más recursos (optimizable con appliances específicos).
- Problemas con protocolos de capa 7 cifrados (instalación de una PKI para proporcionar certificados a los clientes).
- Soporte limitado de protocolos de capa de aplicación.

## Topologías

#### Directrices

- Los proxys solo filtran el tráfico de ciertas aplicaciones (suelen colocarse detrás de un firewall). Proxy directo es aquel que filtra las redes internas hacia internet.
- Suele aplicarse a tráfico que no presenta restricciones temporales.
- Objetivos: Reducir la carga del Firewall. Análisis y bloqueo de contenidos no autorizados y prevención frente a malware.

#### Topología 1: Proxy HTTP Directo

El firewall solamente permite HTTP desde el proxy, el resto de peticiones las deniega. Es obligatorio que el tráfico pase a través del proxy (filtro de contenidos).

#### Topología 2: Proxy Transparente

El firewall enruta todo el tráfico de los PCs al servidor proxy, que filtra las conexiones y enruta los paquetes hacia el CPE. Los clientes no son conscientes del análisis.

#### Topología 3: Proxy inverso

Las peticiones al servidor y las respuestas son filtradas a través de un proxy inverso, los usuarios no son conscientes de que la petición es analizada.

# Tema 6 IDS / IPS

## Introducción

Un sistema de seguridad de red debe estar preparado para mitigar amenazas de malware de manera inmediata, esto es algo que se escapa del alcance de los firewall.

Esto incluye a los ataques Zero Day, ataques que explotan vulnerabilidades desconocidas y que aún no han sido parcheadas. Una opción sería tener un administrador supervisando continuamente la red.

#### Definiciones

Detección de intrusiones: Proceso de monitorización de los evento ocurridos en un sistema o red, buscando signos de posibles violaciones de las políticas de seguridad.

Intrusion Detection System: Sistema que automatiza el proceso de detección de intrusiones.

Inrtusion Prevention System: IDS con la capacidad de bloquear incidencias.

### IDS

Los IDS se diseñaron para analizar el tráfico de forma pasiva, lo que analiza es una copia del tráfico original. Compara el flujo de tráfico capturado con firmas conocidas de códigos maliciosos u otros tipos de ataques. Los IDS offline utilizan conexiones en modo promiscuo.

Ventaja: No afectan al tráfico al ser una copia. Desventaja: No detiene paquetes maliciosos.

Cuando detecta el ataque envía una alarma a la consola de gestión.

### IPS

Los IPS se basan en los IDS pero se colocan inline, no permiten entrar los paquetes sin ser analizados y es capaz de detectar y abortar ataques de inmediato.

Lo malo es que afecta al rendimiento de la red, puede introducir latencia y jitter.

### IDPS

Los IDPS detectan y evitan las intrusiones, recogen eventos de red o sistema y los analizan en busca de indicios de intrusión. Analizan y monitorizan la información de capas 3 y 4, el contenido de los paquetes y ataques sofisticados.

Cuando detectan una intrusión... De forma pasiva registran la información de los problemas detectados y lanza notificaciones y alarmas. De forma activa recopila información adicional y evita el éxito del ataque bloqueandolo, cambiando el entorno de seguridad (FW) o cambiando el contenido de los paquetes.

#### Tipos de IDPS

- Basados en Red.
- Basados en equipos.

### Arquitectura de Red

Localización del IDPS de red:

- Delante del firewall interno: Detección y documentación de ataques que se sufren desde el exterior.
- Detrás del firewall externo: Ataques que han penetrado el firewall externo, ataques contra servidores públicos o desde servidores públicos comprometidos.
- En subredes críticas: Ataques contra sistemas críticos. Permiten perfilar la monitorización específicamente.
- En subredes internas principales: Monitorización de gran cantidad de tráfico y actividad sospechosa desde el interior.

#### IDPS distribuidos

Componentes de la arquitectura distribuida:

- Sensor/Agente: Monitorizan y analizan la actividad.
- Servidor de gestión: Centraliza la información procedente de los sensores, realiza análisis de más complejidad y correlaciona eventos.
- Base de datos: Almacena los eventos registrados.
- Consola: Interfaz para usuarios y administradores.

## Métodos de detección de intrusiones

### Detección basada en firmas

Compara los eventos observados con patrones correspondientes a ataques conocidos. 

- El IDS incorpora estos patrones en forma de reglas, que pueden ser elaboradas por el fabricante o el creador del sistema y deben mantenerse actualizadas.
- Suelen agruparse en base al servicio, tipo de ataque, objetivo, etc.

#### Tipos

- Pattern Matching: Busca secuencias que coincidan con ataques conocidos, pueden realizarse con o sin estado.
- Análisis de protocolo: Comprueba si se siguen las reglas y normas de un protocolo.
- Heurístico: Detectan comportamientos más complejos que suponen un ataque.

#### Ventajas

- Sistema sencillo.
- Efectivo contra ataques conocidos.
- Bajo número de falsos positivos.
- La detección puede incluir información útil del tipo de ataque y bloqueo.

#### Problemas

- Ineficaz contra nuevos ataques
- Necesario actualizaciones constantes.
- Problemas contra ataques de eventos múltiples que por separado no supongan una amenaza.

### Detección basada en anomalías

Detecta eventos que se desvían de la actividad normal, es decir, mantiene perfiles de actividad normal por usuario, aplicación, etc. Pero necesita de un período de entrenamiento. Puede ser estático o dinámico.

Existen varias técnicas: Estadísticas, detección de umbrales o redes de neuronas.

#### Ventajas

- Detectan técnicas de ataque no conocidas, puede usarse para aprender firmas de nuevos ataques.
- Especialmente eficaces contra ataques desde el interior y APTs.

#### Inconvenientes

- Ratio de falsos positivos elevado.
- Requiere periodo de aprendizaje.
- Las alarmas son complejas de entender.

#### Ventajas de los IDPS

- Detectan problemas que no han podido ser evitados por otras medidas de seguridad.
- Identifica y bloquea la actividad de reconocimiento previa a un ataque.
- Documenta posibles amenazas.
- Identifica problemas en la política de seguridad.
- Disuade a los usuarios de violar las políticas de seguridad.

#### Limitaciones de los IDPS

- No son totalmente precisos (FP / FN).
- La respuesta no es inmediata.
- Problemas con nuevos ataques o variantes, ataques expertos o ataques diseñados para evadir IDS.
- Configuración y ajuste complejo.
- Complementan, no reemplazan otras medidas de seguridad.

## Network-Based IDPS

Monitoriza el tráfico de red y analiza los distintos protocolos. Como sensores utiliza tarjetas de red en modo promiscuo. Appliance vs Software.

Arquitecturas de red:

- In-line: Todo el tráfico pasa a través de él, situado entre conexiones de redes, puede bloquear conexiones. Puede ir detrás o antes del firewall o en dispositivos híbridos.
- Pasivos o IDS: Monitorizan una copia del tráfico, facilita la detección de intrusiones, pero no permite la prevención. SPAN es un modo de puerto switch que reenvia el tráfico del resto de puertos y Network TAP es una conexión directa entre el sensor y la red física.

Tipos de eventos detectados: 

- Ataques a capa de aplicación (buffer, contraseñas, malware, etc.).
- Ataques a la capa de transporte (escaneo de puertos).
- Ataques a capa de red.
- Uso de servicios no esperados.
- Violaciones a la política de seguridad.

Capacidades de prevención:

- Sensores inline (firewalling, limitación de ancho de banda anti-DoS, modificación de contenido malicioso).
- Sensores pasivos (finalización de conexiones).
- Ambos: Reconfiguración de otros dispositivos o ejecución de programas predefinidos.

#### Limitaciones

- No detectan ataques cifrados.
- Capacidad de análisis limitada si el volumen de tráfico es elevado.
- Problemas en redes conmutadas (SPAN).
- Muchas veces no se sabe si el ataque ha tenido éxito o no.
- Ataques contra el propio IDPS: DDOS o Blinding.

## Host-Based IDPS

Monitoriza los eventos que ocurren en un host, buscando actividades sospechosas (Tráfico, procesos, carga, accesos al sistema, etc.)

Los agentes se situan en el host monitorizando los evento y envían información a los servidores de gestión.

Tipos de eventos detectados:

- Análisis de código ejecutado.
- Tráfico de red.
- Actividad sospechosa en el sistema de archivos (integridad en archivos de configuración, permisos o accesos ilegales).
- Usos indebidos del sistema.
- Cambios en la configuración de red.

Capacidades de prevención:

- Evitar la ejecución de malware.
- Controlar y bloquear tráfico de red.
- Bloquear acceso, ejecución, modificación o borrado de archivos.
- Control de procesos.

#### Problemas

- Consume recursos.
- Retardos en alertas (análisis periódicos).
- Si el host es comprometido se puede desactivar.
- Escaneos de red y otros ataques pasan desapercibidos.
- Conflictos con otras tecnicas de protección en los host.
- Problemas con cambios de configuración legítimos.
- Problemas con la actualización del agente.

# Tema 7 Monitorización

La monitorización es la disciplica que controla el rendimiento y el correcto funcionamiento de la red. Se encarga de verificar el comportamiento previsto, caracterizar el rendimiento, identificar la cantidad de tráfico y su circulación y la resolución de problemas.

## Network Time protocols

Mantener una configuración de tiempo consistente es clave para aspectos relacionados con seguridad o resolución de problemas. El reloj de un sistema se arranca en el momento que este se inicia, pero puede ser configurado desde distintos orígenes.

El reloj interno marca la hora en base a UTC, pero se adapta al contexto. El reloj también puede saber si la hora se ha aprendido desde una fuente autoritativa.

### Configuración manual del reloj del sistema

Si se está utilizando NTP el calendario se actualiza periódicamente compensando la desviación horaria. Si el sistema no tiene batería la hora es constante dependiendo de su fabricación. En caso de no tener NTP se recomienda usar el comando calendar en equipos Cisco.

### Network Time Protocol

NTP es un protocolo de capa de aplicación diseñado para sincronizar la hora en una infraestructura de red completa. Encapsula sus mensajes UDP y utiliza el puerto 123, sigue el paradigma cliente-servidor (con masters).

Arquitectura: Existe una fuente de información de hora autoritativa que se conecta a un servidor principal (esta es la hora que se distribuye).

Las asociaciones se configuran de forma estática, cada dispositivo tiene el resto de IP para asociarse, entre ellos intercambian mensajes NTP para mantener la precisión. En una LAN se pueden enviar broadcast.

Se utiliza el concepto de Stratum para indicar el número de saltos que hay desde una máquina hasta la fuente autoritativa.

NTP funciona bien sobre rutas no determinísticas porque hace estimaciones basadas en la relación entre cliente y servidor mediante 3 variables: Retardo de red, dispersión de tiempo entre el intercambio de paquetes y el clock offset (corrección). Para evitar errores de sincronización NTP compara información de varias fuentes y no sincroniza con máquinas cuya hora no esté sincronizada consigo misma.

### Modos NTP

Un dispositivo puede desempeñar más de un rol simultáneamente (normalmente cliente y servidor). Los roles son:

- Server: Proporciona información de tiempo precisa a los clientes.
- Client: Se sincroniza con un servidos, modo habitual cuando no se quiere (en pricipio) proporcionar información.
- Peers: Solamente intercambian información de sincronización temporal.
- Broadcast/multicast: Modo especial de server que envía las actualizaciones de sincronización mediante inundacion en la LAN.

Operativa cliente-servidor: El cliente envía un mensaje NTP a uno o más servidores y procesa sus respuestas. El servidor intercambia direcciones y puertos, sobrescribe campos del mensaje, recalcula el checksum y devuelve el mensaje. La informaciónd el mensaje permite determinar la hora del servidor respecto a la local y facilita el cálculo de la precisión y la fiabilidad.

- **Peer mode**: Se basa en la configuración de un grupo de peers de bajo nivel de stratum que funcionan como backups. Cada peer opera con una o más fuentes de información, si pierde sus referencias los otros peers lo reconfigurarán. Se conoce como push-pull operation.
- **Broadcast/Multicast Mode**: Se aplica en entornos donde las necesidades de precisión son modestas. No se necesita especificar la IP del servidor, se encuentran en la misma subred, se configuran cliente y servidor con la IP de broadcast.
#### Otras opciones de configuración

NTP se activa en todas las interfaces una vez que está configurado, es posible desactivar por interfaz. También se puede limitar el número de asociaciones o establecerse como una fuente autoritativa de un determinado nivel (solo si no existe otra fiable).

### Principios de Diseño NTP

- Estructura plana: Todos los routers son peer de los demás routers. Cada router actúa como cliente y servidor, 2 o 3 deberían estar sincronizados con una fuente externa. 
    - Ventaja: Modelo estable.
    - Desventajas: Administración pesada, convergencia lenta y poca estabilidad. No recomendado en redes de campus.
- Diseño Jerárquico de NTP: Utilizado en los ISPs, cada ISP tiene múltiples servidores de stratum 1 que se sincronizan con otros dispositivos del ISP y sincronizan a sus clientes.
    - Consecuencias: Menor carga y menor tiempo de convergencia.
    - Válido para organizaciones de gran tamaño.

### Protección de NTP

NTP es un protocolo fácil de comprometer, es un objetivo habitual por su relación con certificados digitales o Kerberos (Hora). Se puede mejorar la seguridad con ACLs para filtrar peticiones validas.

Configuración de autenticación: Claves, autenticación NTP, claves válidas y servidores.

No todos los clientes deben ser autenticados, NTP solamente autentica orígenes, además debe contestar a dispositivos no autenticados así que es necesario ACLs.

#### Versiones de NTP

Actualmente se utilizan las versiones 3/4 o propietarias, pero los clientes antiguos se pueden comunicar y sincronizar con servidores nuevos.

La versión 4 es una extensión que soporta IPv4/IPv6 y proporciona seguridad completa mediante criptografía de clave pública y certificados digitales.

## Syslog

System Message Logging es un proceso que permite a un dispositivo informar de mensajes de error y notificación importantes. Los mensajes permiten identificar el tipo y la gravedad de un problema o notificar de cambios en la configuración, utiliza el puerto UDP 514.

#### Niveles de severidad de Syslog

0 -> Emergency, 1 -> Alert, 2 -> Critical, 3 -> Error, 4 -> Warning, 5 -> Notice, 6 -> Informational, 7 -> Debugging.

#### Syslog Facilities

Son identificadores de servicio que permiten especificar los datos del estado del sistem apara la notificación de mensajes de evento y error.

#### Formato de mensajes Syslog

Los mensajes comienzan con un "%" y se componen de:

- Facility - Severity - Mnemonic - Message-text.

### Configuración 

Para configurar el servidor de syslog se utiliza el comando logging y para determinar el nivel de gravedad logging trap...

## SNMP

Es un protocolo estándar de gestión de red. Consta de dos elementos: una aplicación de gestión de red y los agentes SNMP.

SNMP define como se intercambia la información de gestión entre las aplicaciones de gestión de red y los agentes de administración (Objetos de la base de datos = MIB).

La aplicación de gestion de red (Network Management System) sondea periódicamente los agentes SNMP y utiliza UDP como mecanismo para recuperar y enviar la información de gestión.

Los agentes SNMP residen en los equippos gestionados y responden a las peticiones SNMP y generan "traps" para informar al administrador de los determinados eventos. El agente recopila datos y los almacena localmente en la MIB.

### Versiones SNMP

#### SNMP v1

Se utilizan 5 mensajes básicos para transferir datos entre el agente y la estación administradora: 

- Get Request: Valor de una variable MIB.
- Get Next Request: Recupera la siguiente instancia de objeto de una tabla o lista.
- Set Request: Configurar una variable.
- Get Response: Usada por un agente para responder a los Get desde el NMS.
- Trap: Utilizado por los agentes para transmitir una alarma no solicitada al NMS. 

#### SNMP v2

Introduce dos nuevos tipos de mensaje:

- Get Bulk Request: Reduce las peticiones y respuestas repetitivas al recuperar grandes cantidades de datos.
- Inform Request: Alerta NMS de situaciones especícificas, respondido con un Inform Response.

Detalles: Ni v1 ni v2 ofrecen características de seguridad como autenticación de origen o cifrado. En SNMPv2 hay 2 implementaciones, la primera no fue aprobada por el IETF.

#### SNMP v3

- Agrega métodos para garantizar la transmisión segura de los datos críticos.
- Presenta tres niveles de sguridad:
    - noAuthNoPriv: No se requiere autenticación y no se proporciona confidencialidad.
    - authNoPriv: Autenticación basada en firmas pero sin cifrados.
    - authPriv: Autentica el paquete mediante HMAC y cifra usando CBD-DES.
- Los niveles de seguridad determinan a que objetos SNMP se puede tener acceso.
- En Cisco v > IOS 12.0

#### Recomendaciones SNMP

- Configuración en modo read-only para los NMS, se deben separar las cominidades y credenciales de los sistemas que necesiten escritura.
- Se deben utilizar vistas: *setup snmp view* permite controlar a qué MIBs y a qué parte puede acceder un usuario.
- Controlar acceso mediante ACLs.
- SNMPv3 siempre que sea posible, sino cuidado con los nombres de comunidad en v1/v2.

#### Configuración SNMPv3

1. Configurar listas de acceso SNMP.
2. Configurar las vistas SNMPv3 para limitar el acceso a MIBs específicas.
3. Configurar grupos de seguridad.
4. Configurar usuarios.
5. Configurar receptores de traps.
6. Configurar la persistencia de ifindex para evitar los cambios del mismo.