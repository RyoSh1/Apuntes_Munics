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

**Nested encryption**:

**Onion routing**: