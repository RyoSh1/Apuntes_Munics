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



