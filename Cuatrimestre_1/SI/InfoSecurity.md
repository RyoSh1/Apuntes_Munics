# Lectura 1: Encriptación

### 1. Encriptación

**Proceso de codificación de la información, conseguir que un mensaje sea más dificil de recuperar para un agente externo.**

#### **Shannon**

Un cifrado Shannon es aquel par de funciones que permiten obtener un texto cifrado a partir de una clave y un mensaje, obtener el texto plano a partir de el texto cifrado y la clave y que Encriptación y Decriptación sean invertibles entre sí.

#### **Secreto**

Único origen, único destino; si un intermediario recibe el mensaje cifrado este no debe ser capaz de leerlo correctamente.

En una colección de textos cifrados no debe existir ninguna pista de cómo obtener el texto original, además el atacante no debe tener ninguna preferencia por un texto plano en específico.

La probabilidad de obtener el texto cifrado a partir de un texto plano elegido por el atacante debe ser prácticamente idéntica a seleccionar un texto aleatorio.

#### Ejemplos

**One time pad**: Cifrado simétrico que utiliza una clave aleatoria del mismo tamaño que el mensaje. Cada carácter se combina con la clave mediante XOR.

**Variable-length one time pad**: Similar pero la clave no tiene porqué coincidir con la longitud del mensaje.

**Cifrado por sustitución**: Reemplazar cada símbolo por otro distinto.

**One time pad adictivo**: Variante en la que en lugar de usar XOR se usa adicción de aritmética modular.

~ El variable no es perfectamente seguro porque la clave variable da información sobre la longitud del texto original.

### 2. Perfect Security

**El concepto de máxima seguridad en una comunicación.**

#### Completamente seguro sí y solo sí:

1. c ⊥⊥ m - plano y cifrado son estadísticamente independientes.
2. No existe un test estadístico que distinga entre dos mensajes sus textos cifrados.
3. Información mútua y entropía igual a 0.

El espacio de claves debe ser como mínimo igual de grande que el espacio de mensajes.

### *Repaso rápido

**Entropía**: El desorden asociado a una variable aleatoria o a un conjunto de datos. Mide la información necesaria para predecir un estado.

### 3. Semantic Security & Computational Cipher

En la práctica insistimos que no debe existir ninguna ventaja en usar uno entre dos textos cifrados distintos.

Es propuesto como un *attack game* aspirante entre adversario.

**Attack game**: protocolo en el que A envía dos textos planos, B elige una clave aleatoria y lo cifra, A intenta obtener el cifrado.

**Semantic security**: Si no existe ninguna diferencia estadística entre los cifrados de los mensajes, *E* es semánticamente segura para cualquier adversario. Debe ser difícil computacionalmente predecir bits y recuperar el mensaje desde el cifrado. EL tiempo de ataque es proporcional a 1/*E*.

**Nested encryption**: Basado en 2 ideas, *collusion*, dos o más intermediarios para que el segundo no conozca la identidad del origen y *mixing, ordenar aleatoriamente los paquetes enviados desde distintos orígenes.

**Onion routing**: Nested encryption + source routing. A partir de i>=2 ya no se puede saber el origen, *mixing* asegura que haya aleatoriedad. 

#### Quantum key distribution

Para la seguridad perfecta, incluso con OTP es necesario compartir una llave. QKD soluciona este problema, no se puede medir el estado cuántico y este no se puede clonar.

1. Envío de fotones entrelazados que tienen una propiedad de polarización que está distribuida de manera aleatoria.
2. Alice y Bob reciben los fotones , pero lo hacen en bases aleatorias e intercambian la información de en qué base midieron los fotones.
3. Alice y Bob comparan las bases y trazan unos resultados que servirán como clave secreta.
4. Si alguien intenta interceptar los fotones alterará el estado cuántico.

## Secretismo teórico de la información
 
# Lectura 2: Cifrados de flujo

## Generadores Pseudoaleatorios

Un generador pseudoaleatorio es un algoritmo que genera supuesto número aleatorio, es seguro si distinguir entre un número aleatorio y uno generado es computacionalmente muy difícil.

### PGRs seguros

Un PGRs es seguro si no existe un test estadístico que afirme que un número generado es no aleatorio con una probabilidad no despreciable.

## Cifrados de flujo

Un cifrado de flujo se basa en la generación de valores aleatorios, es un pad de un solo uso que realiza un XOR con el mensaje caracter a caracter. Si el PRG es seguro entonces el cifrado es semánticamente seguro.

## Ataques en flujos de cifrado

Un flujo usado más de una vez es inseguro, esto se debe a que los espacios de mensaje de los idiomas comunes tienen la suficiente redundancia como para recuperar m. La clave usada para generar el flujo no debe usarse más de una vez.

Pese a todo existen mensajes que presentan una estructura similar entre sí (delta), ante esto se le puede aplicar un delta para modificar el mensaje.

## Composición de los PRGs

### Construcción paralela

Si existe un PGR que genera una cadena X , si usamos cada valor como clave para generar otra cadena tenemos una extensión del PGR.Como desventaja G' se degrada linearmente en n paralelismos. Aún así si G es seguro, G' es seguro.

## Construcción secuencial

En la construcción secuencial se elige una semilla inicial y cada paso del PGR genera un valor pseudoaleatorio y una nueva semilla para el siguiente paso. Si G es seguro, G' también.

## Casos de estudio

### Linear Congruential Generators (LCGs)

Son los disponibles en los SOs y librerías de desarrollo para generar números pseudoaleatorios, estos NO son robustos para criptografía. *as+b mod q*

Las semillas son sencillas de recuperar, w es normalmente potencia de 2, pero esto no significa que sea posible por búsqueda exhaustiva. Veremos que con ri, ri+1 podemos predecir el output ¿?

### Cryptoanálisis

Si un atacante puede recuperar el vector e puede romper la seguridad averiguando s y x, lo que le permitiría predecir el próximo output. El desafío radica en encontrar el punto más cercano a la red *u* lo cual es complejo y es lo que mantiene la seguridad.

### Subconjunto de sumas

La seguridad tiene mucho que ver con la solución de problemas matemáticos, para un PGR existe una funcion f que lo forma.¿?

### RC4

Tiene un generador interno formado por un array de 256 bytes y dos punteros. El problema de RC4 es que su salida tiene un bias, el segundo byte de salida y algunos pares están condicionados previamente.

**Preguntar a Rrrruby diferencia entre nested y onion y cómo tiene el receptor todas las públicas del camino**

# Lectura 3: Cifrados de bloque

1. Definición de Cifrados por Bloques
Un cifrado por bloques es un tipo de cifrado determinista que tiene una función de cifrado 
𝐸
E y una de descifrado 
𝐷
D, donde los espacios de mensajes y ciphertext (texto cifrado) son iguales. Se cifra un mensaje 
𝑚
m de longitud fija y se obtiene un ciphertext 
𝑐
=
𝐸
(
𝑘
,
𝑚
)
c=E(k,m) con la misma longitud, usando una clave 
𝑘
k.

Un cifrado se considera seguro si su función de cifrado es indistinguible de una permutación aleatoria sobre el espacio de mensajes.
Todos los cifrados por bloques son permutaciones en su espacio de mensajes, por lo que se comportan como cifrados de sustitución.
2. Indistinguibilidad Computacional
La seguridad de un cifrado por bloques se mide a través de un juego de ataque. En este juego, un adversario debe determinar si la función utilizada es una permutación aleatoria o una función de cifrado real.

El adversario interactúa con un desafiante que puede estar usando una función de cifrado 
𝐸
(
𝑘
,
⋅
)
E(k,⋅) o una permutación aleatoria.
El adversario envía consultas y recibe respuestas cifradas para intentar adivinar qué tipo de función se está usando.
Si la diferencia en la probabilidad de adivinación correcta es negligible, el cifrado es considerado seguro.
3. Modos de Operación de Cifrados por Bloques
El modo ECB (Electronic CodeBook) es una forma directa de cifrado por bloques donde cada bloque del mensaje se cifra de manera independiente. Sin embargo, este modo no es seguro desde el punto de vista semántico, ya que un atacante puede distinguir fácilmente entre bloques de mensaje iguales o diferentes al observar los bloques cifrados correspondientes.

4. DES y AES
DES (Data Encryption Standard)
DES fue desarrollado por IBM en 1977 y fue uno de los primeros cifrados por bloques ampliamente usados.
Problema: DES utiliza una clave de 56 bits, lo que lo hace vulnerable a ataques de fuerza bruta.
DES emplea una estructura Feistel, lo que implica dividir el texto en dos mitades y usar permutaciones y sustituciones controladas por la clave.
Expansión de claves: DES toma una clave de 56 bits y la expande a 16 subclaves de 48 bits para cada ronda de cifrado.
AES (Advanced Encryption Standard)
AES fue estandarizado en 2001 y usa bloques de 128 bits con claves de 128, 192 o 256 bits.
AES realiza múltiples rondas de permutaciones y sustituciones en una matriz de 4x4 bytes, con operaciones como:
SubBytes: Aplicación de una permutación fija a cada byte.
ShiftRows: Desplazamiento cíclico de las filas de la matriz.
MixColumns: Aplicación de una transformación lineal sobre las columnas de la matriz.
AES es mucho más seguro que DES debido a su tamaño de clave más grande y estructura más compleja.
5. Ataques a Cifrados por Bloques
Existen diferentes tipos de ataques diseñados para comprometer la seguridad de los cifrados por bloques:

Ataques Algorítmicos
Criptoanálisis lineal: Busca relaciones lineales entre el mensaje, la clave y el ciphertext.
Criptoanálisis diferencial: Estudia cómo las diferencias en los mensajes afectan las diferencias en los ciphertexts.
Ataques de Canal Lateral
Explotan el hecho de que las operaciones de cifrado consumen recursos físicos como tiempo y energía, lo cual puede revelar información sobre la clave. Ejemplos:

Ataques de tiempo: Miden el tiempo que tarda un proceso de cifrado para inferir información.
Ataques de poder: Analizan el consumo de energía del procesador durante las operaciones de cifrado.
Ataques Cuánticos
Los ordenadores cuánticos presentan una amenaza significativa, ya que podrían reducir el tiempo necesario para un ataque de fuerza bruta a 
𝑂
(
∣
𝐾
∣
)
O( 
∣K∣
​
 ) mediante el algoritmo de Grover. Esto implica que un ataque cuántico a AES podría realizarse en 
2
64
2 
64
  evaluaciones, lo que reduce drásticamente la seguridad actual de AES.
6. Funciones Pseudo-Aleatorias (PRFs)
Una función pseudo-aleatoria (PRF) es un mapeo determinista que, para un adversario, debería ser indistinguible de una función completamente aleatoria. Los cifrados por bloques pueden verse como PRFs si el espacio de salida es lo suficientemente grande.

El juego de ataque contra una PRF es similar al de un cifrado por bloques. Un adversario intenta distinguir entre una PRF y una función aleatoria basada en sus consultas al desafiante.

7. Relación entre PRGs, PRFs y Cifrados por Bloques
Los generadores pseudo-aleatorios (PRGs), las PRFs y los cifrados por bloques son los bloques fundamentales de la criptografía. A partir de una PRF, se pueden construir PRGs y viceversa. Además, un cifrado por bloques puede verse como una PRF si el espacio de salida es grande.

Construcciones Criptográficas
Luby-Rackoff: Permite construir un cifrado por bloques a partir de una PRF.
Even-Mansour: Es una construcción teórica que aplica una permutación aleatoria con dos claves y se considera segura si las claves son aleatorias.
8. Seguridad de DES y AES
DES es vulnerable a ataques de fuerza bruta. En 2007, se rompió DES en menos de 13 días.
AES es mucho más seguro que DES. Por ejemplo, para romper AES-128 con fuerza bruta se necesitarían 
2
72
2 
72
  días, lo que es prácticamente imposible con la tecnología actual.
Para fortalecer DES, se utiliza Triple DES (3DES), que aplica tres veces el cifrado con claves diferentes, mejorando significativamente su seguridad.

9. Ataques Avanzados
Ataques con claves relacionadas: Son ataques que explotan relaciones conocidas entre múltiples claves.
Ataques de inyección de fallos: Inducen errores deliberados en el hardware para obtener información sobre la clave.