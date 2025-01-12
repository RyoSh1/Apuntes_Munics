# Tema 1: Blockchain y Bitcoin

SCIHUB
## Contexto

Las Tecnólogías de Registro Distribuido son una solución para la difusión y acceso a la información de forma segura y verificada.

Ejemplo Libro contable: Es una alusión a las entidades confiables, es una forma de mantener registrada la actividad económica, es importante que tenga las siguientes características: Inmutabilidad, marcas de tiempo, precisión y completitud.

## Bitcoin

### Historia

- Movimiento Cypherpunk: /0s, defiende la libertad de expresión, el acceso a la información y la privacidad. Estos deben ser promovidos y protegidos mediante la tecnología y criptografía.

- Trabajos previos: 
    - Diffie-Hellman para el intercambio de claves.
    - RSA como sistema de criptografía de clave pública.
    - Árboles de Merkle una estructura de datos para veríficar la integridad de un conjunto de forma eficiente y segura.
    - Publicación de David Chaum "Blind signature for untraceable payments": Sistema de pago ideal (Anonimicidad de pago, tiempo o beneficiario, Capacidad de comprobación, Denuncia de robos).
    - Listas de correos (EFF o Open Privacy).
    - Manifiesto criptoanarquista (uso de la criptgrafía para privacidad y libertad individual). Timothy C
    - PGP (Pretty Good Privacy).
    - El Cyphernomicon: Similar a BSUP pero de Timothy.
    - Magic Money (Dinero digital por correo).
    - Stuart Haber y W Scott Storneta , timestamping de documentos.
    - Adam Back desarrolla HashCat.
    - Wei Dai B-Money para pagos electrónicos (descentralizado).
    - Nick Szabo Bit Gold mecanismo de control de inflacción.

- En 2008 aparece Bitcoin en una lista de correo, "Satoshi Nakamoto" publica Bitcoin...
- 2009 se crea el primer bloque (génesis).
- Bitcoin 0.1.0 la primera versión del software, alfa experimental. Aparece blockchain y la confianza entre pares desconocidos.
- ...

### Funcionamiento Bloque



### Funciones Hash

Son huellas digitales de los datos, algoritmos que transforman una entrada en una salida de caracteres única de longitud fija; determinista y eficiente computacionalmente.

Propiedades: Resistente a la preimagen (x no obtenible con hash(x)), Resistente a colisiones (no es factible encontrar x e y con hashes iguales), Efecto avalancha (Cambiar x cambia mucho hash(x)) y Compatibilidad con puzzles (con hash(x) y parte de x sigue siendo dificil).

### Criptografía asimétrica

Generación de claves privada y pública e intercambio de claves públicas para el paso de mensajes. Firma digital para la firma de mensaje y la verificación de su validez.

Propiedades: No se pueden obtener una con la otra, no son falsificables y las firmas válidas verifican.

### Blockchain

Blockchain es una tecnología que permite almacenar datos de manera segura y transparente en una cadena de bloques. Cada bloque contiene un conjunto de transacciones o información, está vinculado al bloque anterior mediante criptografía y es validado por una red descentralizada de nodos.

#### Redes P2P

### Ventajas Bitcoin

- No controlado por ningún gobierno o institución.
- Medio de intercambio para almacenar y transferir valor.
- Uso de criptografía avanzada.
- Código abierto.
- Su ledger está formado por una red de miles de ordenadores (blockchain).
- Todas las transacciones se pueden ver en tiempo real. Aunque no aparezca tu nombre, se puede conocer la vinculación.

### Desventajas

- Sostenibilidad: Consumo intensivo, alto uso de recursos, emisiones de carbón, residuos electrónicos.
- Vehículo de evasión fiscal y blanqueo.
- Volatilidad (extra).

### Carteras/Wallets

Software que permite almacenar, enviar y recibir criptomonedas (similar a cuenta bancaria). Almacena las claves públicas y privadas que permiten administrar las monedas e interactuar con las redes blockchain.

Hot son online y Cold son hardware.

### Direcciones

Conjunto de números y letras que identifican una cartera. Existen distintos tipos:
- Empiezan por el número 1 para direcciones estándar (P2PKH, Pay to Public Key Hash) (legacy).
- Empiezan por el por el número 3 para las direcciones multifirma (P2SH, Pay to Script Hash).
- Empiezan por por bc1q las direcciones de tipo SegWit (bech32).
- Empiezan por bc1p las direcciones Taproot (P2TR, Pay to Taproot).

# Continuación Tema 1 Bitcoin después de 2008

## Historia

### Fork

En 2013 se produce el primer frok por incompatibilidad de versiones del software que generó desacuerdos entre los mineros.

- Hard Fork: Cambio en el protocolo de la blockchain que genera dos ramas, una que sigue con el anterior y otra con el nuevo.
- Soft Fork: Actualización del protocolo compatible hacia atrás. Continúa aceptando transacciones creadas por el conjunto de reglas anterior.

Conceptos (forks?):
- BTC: Bloques de 1MB cada 10 min.
- Bitcoin Cash (BCH): Bloques de 8MB cada 10 min.
- Bitcoin Gold (BTG): Bloques de 1MB cada 10 min.
- Bitcoin Private (BTCP): bloques de 2MB cada 2.5 min.

En 2014 colapsa Mt.Goc, una plataforma de exchanges de Bitcoin. Se declaró en bancarrota y se perdieron 850000 bitcoins, fue un escándalo.

En 2021:
- Zug (Suiza): Bitcoin como medio de pago de impuestos.
- El Salvador: Moneda de curso legal.
- China prohibe transacciones.
- BlackRock quiere aprobar un fondo cotizado en bolsa de bitcoin al contado.

## Blockchain

Blockchain es un registro, un libro de contabilidad público compartido entre todos los nodos de una red. Se actualiza bajo el consenso de todos los usuarios del sistema y una vez introducida información, esta es permanente.

### Sistemas e infraestructura

#### Permisionada vs no permisionada

#### Configuración

#### Métricas de evaluación

## Ethereum

#### NFT

#### Tipos de cuentas

## Smart contracts

### DApps

### DAOs














# Contenidos Examen Final

# Tema 1

## Problema del doble gasto

El problema del doble gasto ocurre cuando una misma unidad de moneda se gasta más de una vez, esto es un problema en los datos digitales porque estos son fácilmente replicables.

Bitcoin soluciona esto mediante la implementación de un sistema de consenso descentralizado. La blockchain es como un libro mayor, es una base de datos distribuida donde se registran todas las transacciones, cada nodo posee una copia de este libro.

## Características de un buen libro mayor

- Exactitud y precisión.
- Integridad y seguridad.
- Transparencia.
- Inmutabilidad.
- Consistencia.
- Auditabilidad.
- Disponibilidad y accesibilidad.
- Escalabilidad.
- Claridad y simplicidad.
- Respaldo y recuperación.
- Confidencialidad e interoperabilidad.

## Problema del general bizantino

Se trata de un desafío donde varios participantes deben llegar a un acuerdo, pero algunos pueden ser traidores o fallar en comunicar correctamente. El objetivo es que los participantes honestos logren consensuar una decisión, a pesar de la posibilidad de fallos o engaños.

## Historia del Bitcoin, trabajos previos relevantes

- Movimiento Cypherpunk: /0s, defiende la libertad de expresión, el acceso a la información y la privacidad. Estos deben ser promovidos y protegidos mediante la tecnología y criptografía.

- Trabajos previos: 
    - Diffie-Hellman para el intercambio de claves.
    - RSA como sistema de criptografía de clave pública.
    - Árboles de Merkle una estructura de datos para veríficar la integridad de un conjunto de forma eficiente y segura.
    - Publicación de David Chaum "Blind signature for untraceable payments": Sistema de pago ideal (Anonimicidad de pago, tiempo o beneficiario, Capacidad de comprobación, Denuncia de robos).
    - Listas de correos (EFF o Open Privacy).
    - Manifiesto criptoanarquista (uso de la criptgrafía para privacidad y libertad individual). Timothy C
    - PGP (Pretty Good Privacy).
    - El Cyphernomicon: Similar a BSUP pero de Timothy.
    - Magic Money (Dinero digital por correo).
    - Stuart Haber y W Scott Storneta , timestamping de documentos.
    - Adam Back desarrolla HashCat.
    - Wei Dai B-Money para pagos electrónicos (descentralizado).
    - Nick Szabo Bit Gold mecanismo de control de inflacción.

## Cronología del Bitcoin

- En 2008 aparece Bitcoin en una lista de correo, "Satoshi Nakamoto" publica Bitcoin...
- 2009 se crea el primer bloque (génesis).
- Bitcoin 0.1.0 la primera versión del software, alfa experimental. Aparece blockchain y la confianza entre pares desconocidos.
- ...

## ¿Como se realiza una transacción en Bitcoin?

1. Validación de transacciones: Los mineros reciben nuevas transacciones de la red y las validan para asegurarse de que son legítimas y cumplen las normas de la red.
2. Creación de un bloque: Los mineros osn los encargados de generar nuevos bloques añadiendolos al final de la blockchain.
3. Mecanismo de consenso: El minero utiliza su potencia de cálculo para intentar encontrar una solución al puzzle matemático asociado al bloque.
4. Difusión de la solución: Cuando un minero ha encontrado una solición válida, el bloque recien minado se transmite a la red y otros nodos verifican que dicha solución es correcta.
5. Adición del bloque a la blockchain: Una vez que se verifica que la solución es válida, el nuevo bloque se añade a la blockchain y el minero recibe la recompensa por minar ese bloque.

## Definición de funciones Hash

Son huellas digitales de los datos, algoritmos que transforman una entrada en una salida de caracteres única de longitud fija; determinista y eficiente computacionalmente.

Propiedades: Resistente a la preimagen (x no obtenible con hash(x)), Resistente a colisiones (no es factible encontrar x e y con hashes iguales), Efecto avalancha (Cambiar x cambia mucho hash(x)) y Compatibilidad con puzzles (con hash(x) y parte de x sigue siendo dificil).

## Definición Criptografía asimétrica

Generación de claves privada y pública e intercambio de claves públicas para el paso de mensajes. Firma digital para la firma de mensaje y la verificación de su validez.

Propiedades: No se pueden obtener una con la otra, no son falsificables y las firmas válidas verifican.

## Ventajas y desventajas Bitcoin

### Ventajas Bitcoin

- No controlado por ningún gobierno o institución.
- Medio de intercambio para almacenar y transferir valor.
- Uso de criptografía avanzada.
- Código abierto.
- Su ledger está formado por una red de miles de ordenadores (blockchain).
- Todas las transacciones se pueden ver en tiempo real. Aunque no aparezca tu nombre, se puede conocer la vinculación.

### Desventajas

- Sostenibilidad: Consumo intensivo, alto uso de recursos, emisiones de carbón, residuos electrónicos.
- Vehículo de evasión fiscal y blanqueo.
- Volatilidad (extra).

## Definición de wallets. Tipos y principales características

Software que permite almacenar, enviar y recibir criptomonedas (similar a cuenta bancaria). Almacena las claves públicas y privadas que permiten administrar las monedas e interactuar con las redes blockchain.

Las Hot son online, permiten transferencia instantánea.

Las Cold son hardware, más seguras.

# Tema 2

## Forks en Bitcoin. Diferencias entre hard y soft fork

En 2013 se produce el primer frok por incompatibilidad de versiones del software que generó desacuerdos entre los mineros.

- Hard Fork: Cambio en el protocolo de la blockchain que genera dos ramas, una que sigue con el anterior y otra con el nuevo.
- Soft Fork: Actualización del protocolo compatible hacia atrás. Continúa aceptando transacciones creadas por el conjunto de reglas anterior.

## Historia reciente de Bitcoin

En 2014 colapsa Mt.Goc, una plataforma de exchanges de Bitcoin. Se declaró en bancarrota y se perdieron 850000 bitcoins, fue un escándalo.

En 2021:
- Zug (Suiza): Bitcoin como medio de pago de impuestos.
- El Salvador: Moneda de curso legal.
- China prohibe transacciones.
- BlackRock quiere aprobar un fondo cotizado en bolsa de bitcoin al contado.

## Definición exploradores de bloques y faucets

- Exploradores de bloques: Son herramientas en línea que permiten visualizar y analizar las transacciones, bloques y direcciones en una blockchain.
- Faucets: Son servicios que regalan pequeñas cantidades de criptomonedas (generalmente para aprendizaje o pruebas) a cambio de completar tareas sencillas o como incentivo.

## Definición blockchain y propiedades

Blockchain es un registro, un libro de contabilidad público compartido entre todos los nodos de una red. Se actualiza bajo el consenso de todos los usuarios del sistema y una vez introducida información, esta es permanente.

## Subsistemas e infraestructura blockchain

- Dispositivos clientes: Dispositivos de usuario que inician o reciben transacciones.
- Redes de acceso: Dispositivos en el sistema de red ubicados entre los dispositivos cliente e Internet. Actúan como middleware para proporcionar conectividad y seguridad.
- Almacenamiento distribuido: Dispositivos de almacenamiento distribuidos a través de la red que almacenan el ledger.
- Nodos validadores: Nodos distribuidos en la red responsables de verificar transacciones y aprobar modificaciones en la blockchain.
- Centros de cálculo/computación: Infraestructura utilizada para minería, procesamiento y almacenamiento de datos y comunicaciones.
- Red central: Constituida por el equipo proveedor de servicios, habilita el intercambio de información y difusión de las transacciones.

## Resumen de distintos tipos de blockchain

- Permisionada: Participantes conocidos, no minado, no necesidad de criptomoneda nativa y uso de tecnología de bases de datos distribuida.
- No permisionada: Participantes desconocidos, seguridad basada en incentivos, criptomoneda nativa, "crypto-economics".

## Aspectos de diseño de una blockchain

- Frecuencia de bloque: Tiempo entre dos bloques sucesivos.
- Tamaño del bloque: Cantidad de transacciones que caben en un bloque.
- Tipo de carga de trabajo: Smart contracts
- Configuración de los nodos
- Tamaño de la red: Número de nodos.
- Cantidad de carga de trabajo: Cantidad de transacciones a procesar.
- Cantidad de mineros: Nodos que participan activamente.
- Cliente blockchain y API
- Rendimiento: Número de transacciones exitosas por segundo.
- Latencia: Diferencia temporal entre envío y finalización de una transacción.
- Escalabilidad: Cambio de rendimiento y latencia al alterar un parametro (WTF).

## Definición de DLT

Es una tecnología que permite registrar, compartir y sincronizar datos en múltiples nodos de una red distribuida, eliminando la necesidad de una autoridad central.

## Ethereum: Definición, Tokens, NFTs, Bitcoin vs Ethereum, ether y tipos de cuentas



## Definición de smart contracts. Uso del gas en ethereum. Limitaciones smart contracts



## Herramientas de desarrollo. Ejemplo de arquitectura con Ethereum



## Definición de DApps

Son aplicaciones descentralizadas que operan sobre una red blockchain, utilizando contratos inteligentes para funcionar sin intermediarios.

## Definición de DAO

Es una organización gestionada colectivamente por sus miembros a través de reglas codificadas en contratos inteligentes en una blockchain. Funciona de manera autónoma, sin necesidad de una autoridad central, y las decisiones se toman mediante votaciones de los participantes.

# Tema 3



## Capas de blockchain/DLTs, modelo de referencia y procesos



## Trilema blockchain

Se trata de un desafío que describe la dificultad de balancear:

- Descentralización:  El número de nodos completos que participan en la red.
- Seguridad: La cantidad de recursos necesarios para corromper el consenso.
- Escalabilidad: Número de cálculos que la red puede procesar por segundo.

## PoW

Es el protocolo de consenso de Bitcoin, establece una competición criptográfica de resolución de puzzles entre nodos validadores o mineros.

Resolver el puzzle consiste en determinar un rango de entrada que da como resultado un objetivo predefinido. El nonce es la entrada que los mineros compiten por encontrar, el que lo encuentra recibe una recompensa.

La escalabilidad de Bitcoin se limita a validar 1MB de datos de transacción cada 10 min, en teoría es adecuada para establecer consenso, pero en la práctica los equipos de minería han provocado que esté centralizada de facto.

## PoS

Los validadores (no mineros) son seleccionados para crear bloques y validar transacciones según la cantidad de tokens que tienen en "stake" (bloqueadas como garantía). Cuanto mayor sea su participación, mayores serán sus probabilidades de ser seleccionados (lotería). Los nuevos bloques son "forjados" en vez de minados.

## DPoS

Versión de PoS donde los usuarios votan delegados que se encargan de validar transacciones y crear bloques en su nombre. Es más rápido y eficiente, pero menos descentralizado.

## PoA

Los validadores son entidades autorizadas y confiables que deben verificar las transacciones. Es eficiente y rápido, pero depende de la confianza en los validadores seleccionados, lo que lo hace menos descentralizado.

## PBFT

Los nodos se comunican entre sí para nombrar un lider y llegar a un consenso incluso si algunos son maliciosos o fallan (1/3). Es adecuado para redes pequeñas como empresas y permite alta velocidad y tolerancia a fallos. Se utiliza un round robin para modificar el lider.

## PoB

Los participantes "queman" (destruyen) una cantidad de criptomonedas enviándolas a una dirección no recuperable. Esto les da derecho a validar bloques, incentivando la inversión a largo plazo.

## PoET

Sistema de lotería transaparente que genera u8n tiempo de espera en cada nodo, estos esperan un período de tiempo aleatorio y el primero en terminar ese tiempo gana el derecho a minar el bloque. Usa hardware seguro para garantizar tiempos justos. Consume menos energía porque permite que los equipos hagan otras tareas mientras "duermen".

## PoH

Propuesto por Solana para mejorar la velocidad y el rendimiento. Introduce una forma verificable de registrar el tiempo en la blockchain, creando un historial cronológico de eventos. 

## PoI

Usado por NEM, mide la importancia de los nodos en función de su actividad económica, su participación en la red y otros factores. Los nodos con mayor importancia tienen más probabilidad de validar bloques.

## PoA

Es un híbrido entre Proof of Work (PoW) y Proof of Stake (PoS). Los mineros en PoW compiten por resolver un problema matemático para iniciar la creación de un bloque. Sin embargo, después de encontrar el bloque inicial, un grupo de validadores (elegidos según su stake) completa el proceso verificando las transacciones. Combina la seguridad de PoW con la eficiencia de PoS.

## PoC

Los participantes utilizan el espacio en disco para almacenar posibles soluciones de minería. Cuanto más almacenamiento tenga un nodo, mayores son sus probabilidades de minar bloques. Los mineros generan una lista de los posibles hashes en un proceso llamado plotting que se encapsulan en scoops. Estos ‘plots’ se almacenan en el disco duro.

## Principales ataques a los protocolos de consenso

- Ataques del 51% (o 33.3%): Se producen cuando un actor o grupo controla más del 51% del poder computacional o la participación en la red, permitiéndoles manipular la blockchain para realizar acciones maliciosas, como reescribir el historial de transacciones o ejecutar un doble gasto.
- Ataques Sybil: Un atacante crea múltiples nodos o identidades falsas para obtener influencia desproporcionada en la red, lo que puede usarse para sobrecargarla, manipular procesos de consenso o influir en votaciones. 
- Ataques Eclipse: El atacante aísla un nodo específico al controlar todos los nodos con los que puede comunicarse, manipulando su percepción del estado de la blockchain y facilitando acciones maliciosas como el doble gasto.
- Ataques de Jamming: Consisten en saturar la red con tráfico malicioso para dificultar o impedir la comunicación legítima entre nodos, lo que puede ralentizar la red o incluso paralizarla.
- Ataques de desconexión: Buscan interrumpir la comunicación entre nodos, haciendo que la red no pueda alcanzar consenso ni procesar transacciones, lo que provoca una interrupción en su funcionamiento. 
- Ataques de rollback: Implican minar una cadena alternativa más pesada que la actual para revertir el historial de transacciones, permitiendo realizar acciones como el doble gasto.
- Ataques de Stake Grinding: En este ataque, un participante intenta manipular el proceso de selección del próximo validador de bloques, comprometiendo la aleatoriedad y la equidad del consenso.
- Ataques de validador malicioso: Ocurren cuando uno o más validadores en un sistema autorizado (como PoA) actúan de forma maliciosa o en colusión para manipular transacciones o perjudicar a la red. 

# Tema 5

## Definición de árbol de Merkle

Estructura basada en hashes en forma de árbol, cuyos nodos contienen información sobre los niveles inferiores y al intentar modificarlos cambiará la estructura entera. Se trata de un medio eficiente para generar una estructura de datos distribuida con alta seguridad y resistencia a alteraciones, tiene un alto nivel de transmisión de datos, son computacionalmente eficientes y poco costosos y permiten diseccionar en componentes para realizar búsquedas de verificación más rápidas.

## Funciones Hash. Protocolo SHA y uso en bitcoin

Una función hash es un algoritmo que convierte una entrada en una cadena fija de bits de forma eficiente, determinista, no reversible y uniforme, actuando como un identificador único y difícilmente corruptible.

El SHA (Secure Hash Algorithm), desarrollado por el NIST, incluye variantes como SHA-1 y SHA-2 (con tamaños de 224 a 512 bits), y utiliza operaciones como suma, XOR y desplazamientos para generar hashes seguros.

En Bitcoin, las funciones hash (principalmente SHA-256) se emplean para:

- Direcciones: Crear direcciones más cortas y seguras a partir de claves públicas, usando hashes múltiples y checksums.
- Minería (PoW): Validar bloques mediante el cálculo repetido de hashes hasta encontrar uno que cumpla un patrón específico, combinando el hash del bloque previo, las transacciones (Árbol de Merkle) y un nonce. Los nodos verifican estos cálculos con un hash único.

## Definición de criptografía de clave pública

Es un método criptográfico que utiliza un par de claves: una clave pública para cifrar datos o verificar firmas y una clave privada para descifrar datos o generar firmas. Es fundamental para la seguridad en redes como las blockchains, ya que permite comunicaciones seguras sin necesidad de compartir previamente una clave secreta.

## Definición de firma digital

Es un mecanismo criptográfico que garantiza la autenticidad e integridad de un mensaje o documento. Utiliza criptografía de clave pública: el emisor genera una firma con su clave privada, y los receptores pueden verificarla usando la clave pública del emisor.

## Definición de nivel de seguridad de bit

Es una medida que indica la resistencia de un sistema criptográfico frente a ataques. Representa el nivel de seguridad que un atacante necesitaría romper para comprometer la el sistema (fuerza bruta).

## Definición de algoritmo de Shor

Es un algoritmo cuántico que permite factorizar números enteros grandes y calcular logaritmos discretos de manera eficiente (en tiempo polinómico). Esto lo hace una amenaza para los sistemas criptográficos tradicionales como RSA y ECC, que dependen de la dificultad de estos problemas.

## Definición de algoritmo de Grover

Es un algoritmo cuántico diseñado para buscar en una base de datos no estructurada con una velocidad cuadráticamente más rápida que los métodos clásicos. Reduce el esfuerzo de búsqueda de N operaciones raíz de N, impactando en la seguridad de algunos esquemas de cifrado simétrico.

# Tema 6

## Definición de red P2P y Overlay P2P. Ventajas

Sistemas descentralizados en los que los nodos se comunican directamente sin depender de un servidor central, los nodos actúan como clientes y servidores, compartiendo recursos entre ellos. Puede ser peer-to-peer o superpuesta.

Overlay es una red virtual superpuesta a una o más redes subyacentes que conecta nodos de forma lógica en un sistema P2P. Puede ser estructurada (organizada según protocolos específicos para facilitar búsquedas) o no estructurada (conexiones aleatorias). Estas redes mejoran la eficiencia, escalabilidad y búsqueda en sistemas P2P mediante el uso de algoritmos como las tablas hash distribuidas (DHT).

Ventajas: Mayor resistencia a la censura y a los ataques dirigidos a un punto, al no disponer de un servidor central desaparecen los costes de mantenimiento y la dependencia en una entidad central y la carga de trabajo se distribuye en los nodos, lo que resulta en una mayor escalabilidad y capacidad de manejo de tráfico.

## Definición DHT. Kademlia

Es una estructura descentralizada que asigna datos y recursos a nodos de una red P2P utilizando una función hash. Los nodos almacenan información de claves y recursos, y las búsquedas se realizan mediante algoritmos de enrutamiento eficientes. Beneficios clave incluyen redundancia, resistencia a la censura y búsquedas rápidas sin servidores centralizados.

Es un protocolo DHT que asigna IDs únicos a nodos y recursos mediante funciones hash. Utiliza tablas de enrutamiento divididas en buckets, organizadas por distancia de clave, para buscar recursos. El algoritmo de búsqueda XOR permite localizar eficientemente nodos cercanos a una clave, con redundancia y estabilidad que garantizan resistencia a fallos y cambios en la red.

## Definición, funcionamiento, ventajas y limitaciones IPFS

IPFS es un sistema de archivos distribuido y descentralizado basado en tecnología P2P que facilita el intercambio y almacenamiento eficiente de archivos en la web. Utiliza identificadores basados en el contenido (hashes) en lugar de ubicaciones físicas, lo que mejora la resistencia a la censura, la integridad de los datos y la eficiencia en la distribución.

Funcionamiento de IPFS:

- División en bloques: Los archivos se dividen en bloques, cada uno con un hash único.
- Almacenamiento con DHT: Los bloques se asignan a nodos en la red usando una Tabla Hash Distribuida (DHT). Los hashes actúan como claves para localizar el contenido.
- MerkleDAG: Utiliza una estructura basada en MerkleDAG, donde los bloques están conectados mediante enlaces que organizan y aseguran los datos.
- Resolución de nombres: Los archivos tienen un hash único para su acceso directo, y nombres legibles pueden asignarse mediante IPNS, facilitando actualizaciones sin cambiar el hash.

Ventajas IPFS:

- Descentralización: Elimina la dependencia de servidores centralizados, mejorando la resistencia a fallos y censura.
- Eficiencia: Optimiza el almacenamiento con deduplicación de datos y permite entrega rápida al utilizar múltiples fuentes.
- Integridad y versionado: Cada archivo es identificable por un hash único, y se puede acceder a versiones anteriores.
- Seguridad: Facilita auditorías de integridad, intercambio seguro de archivos y distribución confiable de actualizaciones.
- Blockchain/DLT: IPFS complementa blockchains al almacenar grandes cantidades de datos off-chain, reduciendo costes y congestionamientos.

Limitaciones:

- Escalabilidad: Gestionar grandes volúmenes de datos requiere planificación y no está diseñado para operaciones complejas como consultas en bases de datos.
- Redundancia: Aunque implementa deduplicación, puede haber redundancia si múltiples nodos almacenan el mismo archivo.
- Seguridad: Es crucial garantizar que los archivos sean auténticos y no maliciosos.
- Acceso a versiones antiguas: La gestión de versiones anteriores puede complicar el acceso eficiente y el almacenamiento.

## Definición OrbitDB



## Retos redes P2P



## Retos blockchain/DLTs



## Soluciones capa 1



## Sharding



## Soluciones capa 2: side chains, state channels y rollups



## Bridging L1 a L2



# Tema 7

## Ethereum



# Tema 8

## Tipos de blockchain/DLTs



## Hyperledger



## Quorum



## Polkadot



## IOTA



## Corda



## HEDERA



## Metodología para determinar el uso de una blockchain/DLT 

# Tema 9

## Aspectos legales. Blockchain/DLTs y GDPR 

# Tema 10

## Motivación y definición Green blockchain/DLT



## Componentes sw Green blockchain/DLT 

# Tema 11

## Beneficios y retos del uso de blockchain/DLT con tecnologías de la industria 4.0/5.0 

# Tema 12


## Elementos de la pila blockchain/DLT más susceptibles a ataques



## Honeypots, vectores de ataque nodos blockchain/DLT



## Vectores de ataque de una DApp



## Ataques smart contracts



## Ejemplos de ataques relevantes

