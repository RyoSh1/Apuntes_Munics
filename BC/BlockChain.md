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



## PoS



## DPoS



## PoA



## PBFT



## PoB



## PoET



## PoH



## PoI



## PoA



## PoC



## Principales ataques a los protocolos de consenso




# Tema 5

## Definición de árbol de Merkle



## Funciones Hash. Protocolo SHA y uso en bitcoin



## Definición de criptografía de clave pública



## Definición de firma digital



## Definición de nivel de seguridad de bit



## Definición de algoritmo de Shor



## Definición de algoritmo de Grover



# Tema 6

## Definición de red P2P y Overlay P2P. Ventajas



## Definición DHT. Kademlia



## Deinición, funcionamiento, ventajas y limitaciones IPFS



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

