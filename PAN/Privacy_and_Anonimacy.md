# Tema 0: Repaso probabilidad

### Una sola variable aleatoria

#### Probabilidad en masa

La PMF es una función que asigna a cada valor posible de la variable aleatoria discreta una probabilidad, la probabilidad de la que la variable tome ese valor específico.

#### Función de densidad de probabilidad

Esta función describe la densidad de la probabilidad en un rango de valores (integral).

#### Distribución de Laplace

Es una distribución de probabilidad contínua similar a la normal, se usa en situaciones donde es probable observar valores externos con más frecuencia.

#### Operador de esperanza

Se trata del promedio ponderado de todos los valores que puede tomar una variable aleatoria ponderados por sus respectivas probabilidades.

### Más de una variable aleatoria

#### Bayes

El teorema de Bayes es una fórmula que describe la probabilidad de que un evento ocurra, basado en el conocimiento previo de condiciones relacionadas con el evento.

P(A|B) = P(B|A)*P(A) / P(B)

#### Independencia estadística

Dos variables son independientes si el resultado de una no tiene efecto sobre el resultado de la otra.

# Tema 1: Privacidad

## Privacidad

Habilidad de un individuo o grupo de ocultar a elección su propia información. Definición y alcance subjetivo.

### Privacidad y seguridad

Seguridad como medio de privacidad.

#### Coincidencias

- Existencia de adversarios estratégicos
- Principios de diseño de seguridad aplican privacidad.

#### Diferencias

- Trascendencia del dominio digital.
- Modelo de peligro (actores débiles y adversarios fuertes).
- No se puede asumir la existencia de terceros de confianza.
- Susceptibilidad a efecto de gobiernos o empleadores.

### Ataques de inferencia

A partir de datos es sencillo inferor más datos.

#### Deanonimizar

- **Data Linking**: Vínculo con datos externos, cuanto más dispersos más sencillo.

# Tema 2: Ataques de reconstrucción de bases de datos

### Consultas de adversario

La denegación de respuestas puede revelar datos de la propia base, si denegamos un dato importante, pero permitimos el siguiente, el atacante sabrá información sobre la BD.

*Curated: Datos cuidadosamente seleccionados.

Los ataques de inferencia buscan reconstruir una base de datos curada.

### Curar respuestas

Responder a una consulta con una respuesta cierta viola la privacidad, por ello la respuesta debe ser una versión con ruido. Pero en orden de preservar la utilidad se debe controlar la distorsión.

### Ataques de reconstrucción linear

1. Enviar todas las posibles consultas y guardar las respuestas.
2. Encontrar candidatos válidos.
3. Propiedades a satisfacer.
4. Consulta particular.
5. Desigualdad del triángulo inverso.
6. Razonamiento inverso.
7. Diferencias totales.

### Ataques de reconstrucción linear probabilisticos

### Aircloak Diffix Challenge





# Salto Parte 2


# Técnicas de anonimidad

## Introducción

La anonimización de datos es un mecanismo utilizado para sanitizar información con el objetivo de proteger la privacidad de las personas referenciadas en los datos. Esto implica tratar la información de identificación personal (PII) de manera que se evite su divulgación evitando riesgo de fugas de información al compartir datos con terceros o al hacerlos públicos. Existen regulaciones como GPDR o HIPAA que exigen estos procedimientos para proteger datos personales.

Elementos que deben ser anonimizados: 

- Identificadores: Atributos que identifican de forma única individuos.
- Cuasi-identificadores: Atributos que combinados pueden identificar individuos.
- Atributos sensibles: No deben vincularse con una persona.
- No sensibles: Irrelevantes en el análisis.

Enfoques comunes para la anonimización:

- Enmascaramiento de datos: Los datos se ocultan o alteran para evitar que los originales sean reconstruidos (cifrado, mezcla, sustitución, caracteres). Cambio estático (al replicar BD) o dinámico (al consultar).
- Pseudoanonimización: Sustituir identifiacores con pseudonimos artificiales, se mantiene un vínculo interno para revertir.
- Generalización: Reemplaza valores específicos con rangos o categorías, se necesita volumen de datos para garantizar ambigüedad sin perder utilidad.
- Intercambio: Permutaciones o mezcla entre filas de una misma columna.
- Perturbación de datos: Introducción de ruido o redondeo que cambia los datos, pero mantiene estadísticas.
- Datos sintéticos: En lugar de compartir datos reales se genera a través de modelos generativos datos sintéticos que imita los originales.

### K-Anonimidad

Un dataset es K-anonimo cuando existen K registros con el mismo cuasi-identificador (set de atributos), el valor de k determina la utilidad de los datos, a mayor k más generalización de datos.

Consideraciones:

- Los Cuasi-identificadores y los atributos sensibles deben ser distinguidos adecuadamente para que no revelen información sobre los atributos anonimizados.
- Los datos de un grupo deben estar diversificados para que no queden filas identificables.
- Es importante considerar la dimensionalidad de los datos, deben estar ni muy separados ni ser muy similares.

Ejemplo: Grupo [edad, código Postal] debe aparecer idéntico en K filas diferentes.

### L-Diversidad

Extensión de K que determina que un grupo k-anonimo debe tener L distintos registros sensibles para hacerlo más robusto en privacidad. Puede no ser eficaz si un valor dominante representa la mayoría.

Ejemplo: grupo [edad, código Postal], atributo sensible enfermedad debe tener L valores.

### T-Closeness

Mejora la L-diversidad asegurando que un atributo sensible tenga una distribución similar a la global. Se define un umbral T para valorar la distancia entre la distribución de un atributo sensible en un grupo.

Ejemplo: Si hay un 60% de personas saludables, en un subgrupo debe haber 60 +- T de distribución.

### Algoritmo de Mondrian

Algoritmo para aplicar la K-Anonimidad, la idea es realizar una partición multidimensional en los cuasi-identificadores para generar regiones distintas.

Por cada región:

- Los atributos numéricos se codifican usando rangos máximos y mínimos.
- Los atributos categóricos se define un conjunto que los represente.

### Privacidad de Geolocalización

La geolocalización es un tema clave debido al auge de los servicios basados en ubicación (LBS), pero estos aunque útiles generan riesgos de privacidad: Revelar actividades o hábitos personales, es necesario implementar mecanismos de privacidad para minimizar riesgos.

- Datos de localización: Características que distinguen a una persona, Información espacial (coordenadas, nombres de lugares o proximidad física) e Información temporal (timestamps para rastrear movimiento).
- Desafíos: Correlaciones entre datos de posición, trayectoria y tiempo pueden comprometer la privacidad. Los datos en tiempo real exigen procesamiento inmediato. 

Ataques y riesgos: 

1. Métodos de ataque:
    - Acceso a información pública o semipública.
    - Interceptar tráfico real.
    - Comprometer servidores o dispositivos.
2. Tipos de ataque:
    - Ataques de identidad para revelar PII.
    - Rastreo de ubicación pasada o presente.
    - Inferir relaciones entre individuos o grupos.
    - Cruzar contexto de bases de datos con información de ubicación.
3. Impacto: Análisis de rutinas o predicción de comportamientos y revelación de puntos sensibles de interés (POIs).

Métodos de Preservación:

1. Criptografía:
    - Claves compartidas para cifrar datos.
    - Servicios federados para distribuir la información.
2. Anonimización:
    - Técnicas como K-anonimidad, L o T para evitar identificar individuos específicos.
    - Uso de zonas mixtas, áreas donde los pseudónimos cambian para evitar rastreos.
3. Obfuscación:
    - Introducir ubicaciones falsas (dummies).
    - Representación de áreas en vez de coordenadas exactas.
    - Uso de ruido aleatorio para alterar ubicaciones.

# Introducción al Machine Learning

### Inteligencia Artificial

La inteligencia artificial tiene como objetivo desarrollar sistema que demuestren la flexibilidad y versatilidad de la inteligencia humana para resolver un amplio abanico de problemas complejos (general).

El objetivo específico es desarrollar un sistema que es capaz de solucionar un sistema para el cual ha sido diseñado.

## Machine Learning

Rama de la IA cuyo objetivo es desarrollar algoritmos de aprendizaje para máquinas, desarrolla modelos comutacionales capaces de aprender a solucionar problemas complejos mediante ejemplos. 

Es adecuado cuando no sabes como montar un algoritmo que solucione un problema, pero si tienes ejemplos de la solución.

### Tipos de aprendizaje

Existen muchos tipos con sus subtipos, diferenciamos como principales el supervisado, no supervisado y refuerzo.

Dentro del aprendizaje supervisado tenemos problemas de clasificación (etiqueta) y problemas de Regresión (valor contínuo como la edad).

#### Generalización y sobreentrenamiento

La generalización es el termino usado para describir la capacidad de un objeto de predecir o clasificar nuevos datos.

Sobreentrenamiento define un modelo que ha sido entrenado demasiado bien, provocando que memorice los datos de entrenamiento, pero no sea capaz de predecir nuevos datos.

#### Preparación de datos

Antes de usar datos para entrenar un modelo es necesario prepararlos y "limpiarlos": Normalización, Recodificación de valores no numéricos, Eliminación de ruido e imputación de datos.

## Modelos lineales de aprendizaje supervisado

### Notaciones matemáticas y definiciones

Escalares (*x,y*), Vectores (**x,y**), Matrices (**X,Y**), Productos, Normales de vectores.

### Métodos de regresión lineal

El mecanismo de regresión se basa en predecir el valor de variables continuas dado el valor de un conjunto de variables explicativas representadas por un vector m-dimensional.

- Elementos:
    - Variables explicativas: Parámetros de entrada del modelo.
    - Ejemplos de entrenamiento: Set de n datos de las variables explicativas cuya predicción ya se sabe.
    - Modelo: Función parametrizada que representa la relación entre x y t.
    - Objetivo (error o coste): Función que indica como de bien se aproximan los datos entrenados.
    - Método de optimización que encuentra los parámetros óptimos minimizando la función objetivo.

- Proceso de entrenamiento:
    - El objetivo es construit un modelo que encuentre los parámetros óptimos **w** para predecir el valor **t** de un nuevo valor **x**.
    - Esto requiere un set de datos de entrenamiento con n observaciones y valores predecibles.

#### Regresión linear

La regresión lineal se define como:  
~~~
y(x,w) = w0 + w1x1 + . . . + wmxm = xTw.
~~~

El error para cada i se calcula como:
~~~
ei = ti − yi(xi ,w)
~~~

#### Mínimos cuadrados

La función de error (objetivo) se define como la suma del cuadrado de los errores. (convexa)

### Métodos de clasificación lineal

La clasificación es similar a la regresión, salvo que el valor a predecir se encuentra en un conjunto pequeño de valores discretos. En la clasificación binaria solo tenemos 2 valores disponibles.

Se le llama supervisado porque los valores de salida se conocen en todo momento.

Tipos de problemas: Separables linearmente, No separables linearmente y Datos no separables.

#### Decisión de regiones

- Métodos de aprendizaje lineal: Las superficies de decisión que generan son funciones lineales (hiperplanos).
- Métodos de aprendizaje no lineal: Las superficies que generan son funciones no lineales.

#### Regresión logística

Para resolver el problema del método de mínimos cuadrados, la regresión logística propone el uso de una función logística o sigmoidea. Esto obliga a que la salida esté acotada en el intervalo (0,1), lo que también permite que pueda interpretarse como una probabilidad.

Para obtener el mínimo del error es necesario utilizar métodos iterativos basados en el gradiente descendiente.

#### Conclusiones

Mínimos cuadrados no es una buena solucion en general para clasificación porque es sensible a clases desbalanceadas.

Regresión logística es el método más robusto.

## Métricas para evaluación de errores

¿Cómo podemos evaluar el rendimiento de un modelo? La funcion de pérdidas es la que utilizamos para optimizar el modelo. Las métricas de evaluación se encargan de medir el rendimiento.

### Métricas para regresión

- Mínimos cuadrados (MSE): Otorga mayor peso a errores grandes al usar el cuadrado.
- Raíz de los mínimos cuadrados(RMSE): Facilita la interpretación porque el error obtenido es relativo a las unidades de los datos.
- Media del error absoluto(MAE): Trata todos los errores por igual, pero no es adecuada si quieres prestar más atención a errores potencialmente grandes.
- Media porcentual del error absoluto(MAPE):
    - Interpretación clara e independiente de la escala de los datos, resistente al error atípico.
    - Problemas con la división en valores iguales a 0 o generación de números muy grandes si los valores reales son excepcionalmente pequeños. Sesgado a predicciones menores a los valores reales.
- Media porcentual simétrica del error absoluto(SMAPE):
    - Simétrica respecto a valores grandes o pequeños y soluciona el problema de MAPE porque genera valores entre 0% y 100%.
    - Mantiene los problemas de dividir entre 0 y no trata simétricamente las sobre- y sub- predicciones.

### Métricas para clasificación supervisada

- Precisión: Tasa de acierto global del sistema.
- Sensibilidad: Tasa de acierto de los positivos.
- Especificación: Tasa de acierto de los negativos.
- Exactitud: Tasa de acierto de positivos sobre todos los clasificados como positivos.
- F1-score: Media armónica entre precisión y sensibilidad.
- ROC curve: Representa gráficamente la sensibilidad frente el ratio de falsos positivos.
- Area bajo ROC curve (AUC): La AUC indica como de bien están separadas las posibilidades de clases positivas y negativas.

En el caso de multiclases la precisión se calcula sobre el resultado global y el resto en el contexto de la propia clase.

- Macro-media: Media de la métrica sobre todas las clases.
- Media ponderada: Media de la métrica pero ponderada por el número de casos por clase.
- Micro-media: Por cada métrica los casos individuales de verdaderos positivos y falsos negativos y positivos se acumulan para cada clase.

## Metodologías para el análisis de resultados

Como podemos evaluar de forma realista las métricas, el objetivo es generalizar el error del modelo. Para ello tenemos varios métodos de estimación del error.

### Partición simple

Dividir el dataset en dos subsets (entrenamiento y test). Si los datos son pocos es un lujo usar eso como test, solo se realiza un test, por lo que el resultado no es adecuado.

### Sub ejemplos aleatorios

Realizar K experimentos usando diferentes subsets de los datos, cada subset se elige de forma aleatoria y el resto para entrenamiento. El estimador del error real se consigue con la media de los errores de los K experimentos.

### K-fold cross-validation

Se divide el dataset en K subsets disjuntos de aproximadamente el mismo tamaño, con ellos se realizan K experimento usando cada subset como test y el resto como entrenamiento. El error de validación es calculado como la media de cada E.

#### Stratified K-fold cross-validation

Variante de K-fold donde cada set contiene aproximadamente el mismo numero de casos de cada clase del data set completo.

#### Dejar uno fuera

Caso extremo de K-fold donde se realizan N experimentos con N datos, dejando siempre uno solo para test.

### Cross-Validation

¿Cuantos subsets y experimentos se deben realizar?

- Si se elige un numero grande: El estimador de error va a ser preciso, la varianza del error va a ser alta y el tiempo computacional va a ser alto.
- Si se eligen pocos: Tiempo computacional reducido, Varianza pequeña y estimador impreciso.

## Modelos no lineales de aprendizaje supervisado



### Redes de neuronas artificiales



#### Back propagation



#### Algoritmos avanzados



#### Decisión de región



#### Capacidad representacional



### Redes neuronales convolucionales


#### Capa convolucional



#### Capa RELU



#### Capa de Pooling



#### Capa completamente conectada



#### Recomendaciones para un buen entrenamiento



# Privacy Preserving Machine Learning



## Modelos de amenazas



## Tipos de ataques



### Inferencia sobre miembros de la población



####



####



####



### Inferencia sobre los miembros del dataset de entrenamiento



####



####



### Inferencia sobre los parámetros del modelo



####



####



# PPML Parte 2

## Privacidad diferencial



### Privacidad diferencial local



### Generación de datos sintéticos para preservar la privacidad



### Técnicas de minado de datos para preservar la privacidad



# Comunicaciones anónimas

Las redes de comunicación utilizan direcciones visibles para enrutar datos, estas direcciones suelen ser identificadores únicos, lo que compromete la privacidad al asociarse con personas físicas.

La anonimización protege tanto la privacidad del usuario como las comunicaciones frente a análisis de tráfico. Se extiende a técnicas como autenticación anónima, votación y transacciones electrónicas.

Niveles de anonimato: Privacidad total (nadie identifica a nadie), Privacidad parcial (Las agencias de seguridad pueden romper el anonimato bajo órdenes judiciales) y sin anonimato.

Conceptos clave según Pfitzmann y Hansen:

- Anonimato: Estado en el que un individuo puede ser identificado dentro de un grupo.
- No vinculación: Imposibilidad de relacionar múltiples usos de un servicio por un mismo usuario.
- No observabilidad: Los mensajes son indistinguibles del ruido aleatorio.
- Pseudoanonimato: Uso de un pseudónimo como identificador único, pero vinculado al usuario.

Modelos de ataque en redes:

- Atacante pasivo (Tipo 1): Observa los enlaces de comunicación.
- Atacante pasivo con envío (Tipo 2): Emite mensajes.
- Atacante activo (Tipo 3): Controla enlaces, puede borrar, retrasar o modificar mensajes.

Requisitos para el anonimato en redes:

- Tráfico de cobertura: Añadir tráfico adicional para ocultar transmisiones reales. Si el atacante controla este tráfico, el anonimato queda comprometido.
- Tráfico embebido: Los mensajes de los usuarios deben integrarse silenciosamente en el tráfico de cobertura. Requiere una tercera parte confiable que combine mensajes reales y falsos.
- Efectividad: Definida como la proporción de mensajes reales respecto al total, requiere coordinar suficientes usuarios y mensajes para minimizar retrasos y maximizar la eficiencia.

## Redes Mixtas

Redes de muchos nodos donde el paquete a la salida es una permutación de las entradas, mientras su contenido se mantiene inalterado. Si al menos un nodo oculta su shuffling la permutación es secreta,la honestidad de los nodos puede verificarse públicamente garantizando que las salidas son una permutación de las entradas.

Una red mixta debe funcionar aun en el supuesto de que un nodo falle o se vea comprometido.

### Modos de procesamiento

Cadena de descifrado: Cada mensaje es cifrado secuencialmente utilizando la clave pública de cada nodo, concatenando Address || Bloque || Random string. 

Desencriptación parcial: Cada nodo utiliza su clave privada para quitar una capa de encriptación del mensaje recibido, que luego se reordena de manera aleatoria antes de enviarse a la siguiente etapa.

Permutación: Los mensajes parcialmente desencriptados se mezclan en un orden aleatorio y se transmiten como un lote al siguiente nodo, asegurando que no se pueda rastrear la relación entre entrada y salida.

Para garantizar la comunicación bidireccional anónima se incluye información de ruta de retorno (RPI) y claves compartidas simétricas con el mensaje original. Cada nodo desencripta una capa de esta información revelando la siguiente direccion y clave.

Cadena de reencriptación: En este modelo los nodos no desencriptan los mensajes sino que los reencriptan usando cadenas aleatorias para cambiar su apariencia antes de enviarlos. Al final de todo se realiza una fase de desencriptación conjunta usando un esquema de claves compartidas.

Existen variaciones de estas redes utilizando esquemas híbridos que combinan claves simétricas y asimétricas.

### Topologías

- Cascada: 
    - Consiste en una secuencia fija de etapas, común para todos los remitentes y receptores. El primero nodo inicial la mezcla de mensajes en lotes de tamaño l, procesandolos de forma asíncrona. 
    - Desventajas: Una etapa defectuosa puede comprometer toda la red, es posible rastrear mensajes mediante análisis de tráfico (pasivo), Controlar varias etapas o inyectar tráfico (ataque activo).
- Enrutamiento libre: 
    - Las etapas estan interconectadas pero no dependen unas de otras. Un nodo puede recibir remitentes y enviar salidas directamente a otros nodos, la operación es asíncronas, pueden esperar a formar lotes o ser enviados más rápido según su ruta.
    - los mensajes pueden rastrearse debido al tráfico no uniforme y al tamaño decreciente de las "capas" de cifrado (pasivo), inundar la red con tráfico puede aislar mensajes objetivo (activo).

### Esquemas de verificación

- Criterios para verificar una red mixta: Los lotes de entrada se procesan correctamente y se permutan de forma adecuada. Los mensajes no deben ser alterados, añadidos ni eliminados.
- Niveles de verificación: Salidas de toda la red, salidas de cada etapa individual. Estos métodos no suelen aplicarse en topologías de enrutamiento libre.

Esquemas específicos de verificación:

- Red mixta verificable por el remitente: Detecta mensajes corruptos solo en la salida de la red, el remitente incluye un checksum cifrado con su clave privada. Cualquiera puede verificar la integridad desencriptando con la clave pública del remitente.
No detecta mensajes añadidos, detecta mensajes eliminados solo si el remitente verifica la presencia de su mensaje y no identifica etapas comprometidas.
- Red mixta verificable por etapas: Cada etapa verifica sus salidas usando subprotocolos adicionales.
Métodos: Crear copias del lote de entrada o repetir el proceso de mezcla, Pruebas de conocimiento cero o revelación controlada de secretos para validad operaciones, Mecanismos de recuperación para reiniciar operaciones si se detecta un comportamiento anómalo.

## Onion Routing

El Onion Routing se basa en el enrutamiento multinodo y cifrado en múltiples capas. Cada mensaje se cifra capa por capa con las claves de los nodos del camino hacia el receptor, cada nodo desencripta una capa para revelar información sobre el siguiente nodo y reenvía el mensaje.

Funcionamiento: No mezcla ni reordena como las redes mixtas, el orden de entrada/salida no es relevante.

- Entidades: Cliente, Onion Proxy (determina la ruta y construye la cebolla), Nodos intermedios y Nodos finales.

Respuesta: Los nodos añaden capas de cifrado en sentido inverso para enviar una respuesta al remitente.

### TOR

Tor es una mejora de Onion Routing, los usuarios se conectan a través de una aplicación (no es una red P2P), los nodos son proporcionados por voluntarios que donan ancho de banda y procesamiento.

Limitaciones: Vulnerable a ataques extremos si el atacante controla los nodos finales, identificando remitente, receptor y contenido. No oculta la identidad del remitente a nivel aplicación.

Construcción: Siempre se usan 3 nodos(in, mid, out), el de entrada es confiable y elegido por su estabilidad, los circuitos rotan periódicamente y se usan claves a corto y largo plazo para negociar cifrados y proteger datos.

Transferencia de datos: Los mensajes se dividen en paquetes fijos de 512B, los routers desencriptan una capa en cada salto y en las respuestas se hace el proceso inverso.

Servicios ocultos: 
    - Permite que usuario y servidor no conozcan sus direcciones IP mutuas, el servidor selecciona nodos cebolla como "puntos de introducción" y publica un descriptor en una tabla hash distribuida (pk y direcciones de los puntos).
    - El usuario elige un punto de introducción y un "punto de encuentro" aleatorio, se solicita a ese punto que introduzca cliente y servidor y si el servidor acepta se crea un circuito para conectarse de forma segura.