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

### STP

Spanning tree protocol...

### NAT

...

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
- Desventaja: STP necesario para permitir un diseñ con enlaces redundantes en capa 2.

### Capa 3 hasta acceso

