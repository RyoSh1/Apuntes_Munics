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