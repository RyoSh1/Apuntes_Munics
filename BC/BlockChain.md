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