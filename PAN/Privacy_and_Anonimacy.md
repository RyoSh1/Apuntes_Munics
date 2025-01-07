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

A partir de datos es sencillo inferir más datos, debido a que somos predecibles.

## Ejemplo de Facebook

Estudio realizado en 2013 por Michal Kosinski que se centra en como los likes de facebook se pueden usar para inferir información sensible y rasgos de personalidad de los usuarios. El modelo predijo a partir de datos que parecían inofensivos características como orientación sexual, rasgos de personalidad, afinidad política y religión; 10 likes eran suficientes para hacer inferencias precisas.

Conclusiones: La privacidad no depende solo de lo que compartimos explícitamente sino de como los datos pueden combinarse y analizarse.

## Cambridge Analytica

Este caso expuso como datos masivos de usuarios fueron recolectados y utilizados sin consentimiento para influir en decisiones políticas. El propósito de este caso fue obtener perfiles psicológicos detallados de millones de votantes, identificar preferencias políticas, miedos y vulnerabilidades y usar todos estos datos para diseñar campañas de publicidad política personalizada para influir en elecciones y referendos clave.

#### Deanonimizar

- **Data Linking**: Vínculo con datos externos, cuanto más dispersos (cantidad de atributos) más sencillo de vincular.

## Ejemplo Deanonimización Netflix

Este se trata de un famoso ejempo de como los dato supuestamente anónimos pueden vincularse a individuos usando información externa.

En 2006 Netflix lanzó un desafío público para mejorar su algoritmo de recomendaciones y publicaron un conjunto de datos que contenía valoraciones de películas, fechas e IDs y se encontraban anonimizados (ni nombres ni identificadores directos).

A través de datos auxiliares como valoraciones públicas en IMDb los atacantes descubrieron patrones coincidentes entre las valoraciones y las fechas, logrando reidentificar personas con pocas valoraciones públicas incluso con discrepancia en las fechas. Los usuarios que calificaban películas sensibles quedaron expuestos sin su conocimiento.

#### Principios de GPDR

- Licitud, imparcialidad y transparencia para el interesado.
- Limiticación de la finalidad: tratar los datos con los fines especificados explícitamente.
- Minimización de los datos: Solo procesar los datos absolutamente necesarios.
- Exactitud
- Limitación de almacenamiento: Solo el tiempo necesario para el fin especificado.
- Integridad y confidencialidad: Garantizada la seguridad, etc de los datos.
- Rendicion de cuentas: El responsable debe poder demostrar el cumplimiento con el GDPR.

# Tema 2: Ataques de reconstrucción de bases de datos

### Consultas de adversario

La denegación de respuestas puede revelar datos de la propia base, si denegamos un dato importante, pero permitimos el siguiente, el atacante sabrá información sobre la BD.

*Curated: Datos cuidadosamente seleccionados y con ruido añadido.

Los ataques de inferencia buscan reconstruir una base de datos curada.

### Curar respuestas

Responder a una consulta con una respuesta cierta viola la privacidad, por ello la respuesta debe ser una versión con ruido. Pero en orden de preservar la utilidad se debe controlar la distorsión.

## Caso Ficticio US Census Bureau Data

Caso presentado en 2018 por Simson Grafinkel que ilustra como los datos anonimizados del censo de los EEUU pueden ser reidentificados utilizando técnicas estadísticas modernas y datos auxiliares (en este caso se usaron datos ficticios).

Los censos recopilan información sensible de la población como edad, género, ingresos, nivel educativo,etc. Estos datos pueden ser explotados si se identifica a individuos. Para proteger la privacidad estos datos se publican de forma anonimizada eliminando identificadores directos como nombres o direcciones.

Los investigadores utilizaron datos auxiliares para realizar ataque de reidentificación, correlacionando atributos como edad, género, código postal, etc. Estas combinaciones pueden ser únicas para un individuo en áreas rurales o pequeñas.

Se demostró que incluso con datos anonimizados si estos presentan combinaciones únicas, se pueden utilizar cálculos como la media sobre poblaciones de datos pequñas para extraer información de individuos.

### Ataques de reconstrucción linear

1. Enviar todas las posibles consultas y guardar las respuestas.
2. Encontrar candidatos válidos.
3. Propiedades a satisfacer.
4. Consulta particular.
5. Desigualdad del triángulo inverso.
6. Razonamiento inverso.
7. Diferencias totales.

Corolario: A menos que haya un límite en las consultas de la base de datos es posible realizar una reconstrucción casi perfecta en 4E entradas. E es el máximo error que introduces en la respuesta. Reduciendo la precisión es estadísticamente posible reconstruir el vector secreto con muchas menos consultas.

#### Explicación Personal 

s - Query
a(s) - Respuesta de s
r(s) - Versión con ruido de a(s)
Para mantener utilidad |r(s) - a(s)| =< E
E - Es el límite
d - Vector secreto
c - Candidatos a vectores secretos
c^(k^t) - Un candidato que cumple que el error el menor que E (definitivo).

Teorema: Si un analista hace 2^n queries, podrá reconstruir la BD en todo menos 4E posiciones.

Como funciona: Tu tienes 2^n queries y 2^n candidatos de ser el vector secreto, por cada candidato compruebas todas las queries, si cumple todas, tienes el vector secreto d. Lo que consigues es una columna secreta, donde cada fila cumple o no cumple con tu query [1,0,0,1 ,1,1...]. 

### Ataques de reconstrucción linear probabilisticos

Consideran la distribución del ruido al evaluar candidatos, rechazando si respuestas asociadas tienen baja probabilidad bajo las distribuciones asumidas.

### Aircloak Diffix Challenge

Caso diseñado para evaluar la robustez de un sistema de anonimización basado en la privacidad diferencial llamado Diffix.

La solución se basó en introducir consultas "aleatorias" mientras que llevaban a cabo pocas condiciones, por ejemplo con 3 condiciones el ruido estaba bajo O(/n), esto garantizaba un ataque exitoso bajo la condición de O(n) ganando el premio.

# Introducción a la Privacidad diferencial

Escenario inicial: Un dataset D contiene una fila por cada usuario y un curador produce una salida R a partir de aplicar un mecanismo M al dataset.

A través de un estudio de los datos e información externa un atacante puede encontrar correlaciones entre los datos y obtener información sensible. La privacidad diferencial se encarga de proteger los datos , de tal forma que observar R no debe proporcionar más conocimiento del que se tiene previamente.

### Encontrar Diferencias

El mecanismo M debe ser capaz de producir un R de dos bases de datos (una le falta una fila) que sean indistinguibles. El diseño del mecanismo debe ser probabilístico.

Las distribuciones de ambas salidas deben ser similares, esto debe mantenerse para todos los posibles datasets vecinos (1 fila diferente).

Distribuciones similares: Introducimos un parámetro p como umbral de diferencia para valorar la privacidad, este parámetro se transforma en e elevado a epsilon para mejorar los cálculos.

## Configuración de la privacidad diferencial

Dependiendo de donde se ejecuta el mecanismo, existen dos modelos de privacidad diferencial:

- Central: Hay un agregador centralizado.
- Local: Cada usuario ejecuta el mecanismo por si solo.

La definición es idéntica, pero la local se tiene en cuenta como si los datasets tuvieran solo una fila.

DP limitado: Los conjuntos de datos vecinos tienen el mismo número de registros y difieren en el valor de una fila. Se usa cuando todos están presentes en ambos conjuntos.

DP No-Limitado: Los conjuntos vecinos difieren en la inclusión o exclusión de una fila. Se usa cuando alguno individuos no estan presentes en alguno de los conjuntos.

## Mis propios apuntes de explicación

PR() representa la probabilidad de que un evento específico ocurra. Pr[M(D) ∈ S] es la probabilidad de que el mecanismo M, aplicado al conjunto de datos D, produzca un resultado que esté dentro del conjunto de resultados S.

#### Ejemplo práctico de la privacidad

Si e=1 y el valor real es 50 (enfermos), entonces M(x) puede ser cualquier numero cercano a 50, pero con menos probabilidad confirme se aleja de este valor. 

Si el ruido generado sigue una distribución Laplaciana con media 0 y escala b = 1/e = 1, entonces:

La probabilidad de que M(x) = 51 es:

1/2b exp(-|51 - 50| / b) = 1/2 exp(-1) == 0.184

La probabilidad de x = 50 es 0.5

Perr >= 1 / (1 + e^e) = 0.26

### Parametro epsilon

Es un parámetro que controla el nivel de privacidad en un mecanismo de DP. Valores pequeños = Mayor privacidad (menos info a la salida), Valores grandes = Menos privacidad (expone más información).

Un mecanismo M satisface ε-DP si para cada conjunto de salidas S y cualquier par de conjuntos de datos vecinos D y D', se cumple que Pr1/Pr2 =< e^e

e^(epsilon) es una cota superior multiplicativa que relaciona las distribuciones de las salidas se un mecanismo sobre dos conjuntos de datos vecinos.

Ejemplo: Si epsilon = 1 , e = 2.718, lo que significa que la probabilidad de una salida no cambia más de un factor de ~2.7, independientemente de la presencia o ausencia de un individuo.

#### DP como un juego estadístico

Si un adversario intenta distinguir dos conjuntos de datos vecinos utilizando las salidas del mecanismo M, epsilon proporciona un límite sobre la capacidad del adversario para tomar decisiones correctas.

Una e-DP pequeña asegura que la probabilidad de error del adversario es alta, lo que equivale a más privacidad.

### Problemas con e-DP

Garantizar e-DP estricta puede ser complicado debido al ruido necesario para preservar la privacidad, para ello se utilizan mecanismos aproximados (relajación) como (ε,δ)-DP que permiten una pequeña probabilidad δ de fallar en cumplir ε-DP.

## Mecanismos de privacidad diferencial

#### Mecanismo de Laplace

Añade ruido Laplaciano proporcional a la sensibilidad de la función f y el parámetro de privacidad epsilon. La l-sesibilidad es el máximo cambio que puede haber a la salida al cambiar D por D'.

Fórmula: M(x) = f(x) + Lap(Δf/ε)

Donde Δf es la sensibilidad de f, es decir, el cambio máximo en la salida al modificar una sola fila en el conjunto de datos.

Ejemplo: Calculamos la sensibilidad ( max1 - max2) y dividimos eso entre nuestro valor de e. Por ejemplo para sensibilidad de 180 y e=0.1 -> Lap(1800).

#### Mecanismo de Respuesta aleatoria

Ideal para entradas binarias, responde con la verdad con probabilidad p y miente con probabilidad 1-p. Garantiza ε-DP ajustando p adecuadamente.

#### Mecanismo Exponencial

Diseñado para seleccionar entre resultados discretos basándose en una función de utilidad. La probabilidad de elegir un resultado está ponderada exponencialmente por su utilidad.

u es la utilidad y Δu es su sensibilidad.

#### Mecanismo Gaussiano

Similar al de Laplace, pero añade ruido Gaussiano. Útil para aproximaciones de DP ((𝜀,𝛿)-DP).

## Resumen Mecanismos


| Ataque   | Descripción | Ventaja | Desventaja |
|----------|----------|----------|----------|
| Mecanismo Laplaciano | Añade ruido Laplaciano (distribución de Laplace) proporcional a la sensibilidad de la query y el parámetro epsilon | Sencillo, eficiente en consultas con baja sensibilidad y no requieren grandes ajusts de ruido y garantiza epsilon-DP | Menos efectivo contra datos de alta dimensión, si la sensibilidad es alta puede degradar la calidad de los resultados |
| Mecanismo de respuesta aleatoria | Los usuarios introducen ruido directamente en sus respuestas antes de enviar datos al recolector, encuestas sensibles | Privacidad descentralizada, Adaptable y ligero de implementar  | Puede presentar ruido muy alto, escalabilidad limitada |
| Mecanismo exponencial  | Selecciona un elemento de un conjunto de opciones con probabilidad proporcional a su utilidad, añadiendo ruido a través de la distribución exponencial | Optimizado para elecciones discretas y permite priorizar resultados más útiles mientras mantiene privacidad | Limitación en queries continuas y requiere una sensibilidad compleja |
| Mecanismo Gaussiano | Añade ruido Gaussiano (distribución normal) proporcional a la sensibilidad de la query y al parámetro de privacidad | Escalabilida, flexible y adaptado a la privacidad aproximada (δ) | No garantiza la privacidad diferencial estricta sino aproximada, el ajuste de ruido puede ser más complejo |

IMPORTANTE VER LOS EJEMPLOS

## Propiedades de DP

### Robustez al Post-procesamiento

Si un mecanismo M satisface e-DP, cualquier función derivada o transformación basada en su salida también lo satisface. Esto implica que la privacidad no se reduce al realizar cálculos adicionales, por lo que un adversario no puede revertir el ruido agragado.

### Privacidad de grupo

Si un mecanismo satisface e-DP para conjuntos de datos que difieren en una sola fila, garantiza k-e-DP para conjuntos que difieren en k filas.

Proporciona una cota sobre la pérdida de privacidad para grupos de individuos en lugar de 1.

### Composición Secuencial

Si se ejecutan múltiples mecanismos independientes, el mismo conjunto de datos, la privacidad combinada es la suma de e. Cada consulta disminuye la privacidad, por lo que es importante limitarlo.

### Composición Paralela

Si diferentes mecanismos operan sobre peticiones disjuntas de los datos, la privacidad combinada es igual a la mayor e de ellos.

Permite realizar múltiples operaciones en paralelo sin afectar significativamente la privacidad.

# Cifrado Homomórfico

### Cifrado homomórfico

Hacer ejemplo

### Lattices

Una lattice n-dimensional es una combinación de enteros de n vectores base. Se usan en sistemas criptográficos resistentes contra computadoras cuánticas.

### Problemas difíciles en lattices

Problema del vector más corto (Encontrar la normal del vector más corto en la lattice), aproximación α de SVP y el problema de SVP independientes.

### Problema de aprendizaje con errores

Es un problema matemático de la teoría de lattices que es fundamental en sistemas resistentes a los ataques de computadoras cuánticas, se utiliza para diseñar esquemas criptográficos como el cifrado, las firmas digitales y el cifrado homomórfico.

#### Nota respecto a la reducción modular

Las transformaciones en módulo q seguirán la siguiente distribución de intervalos:
- Para números impares: [-(q-1)/2, (q-1)/2]
- Para números pares: [-q/2, q/2-1]

#### Búsqueda LWE < Decisión LWE

- Búsqueda: Dado poly(n) pares (ai,bi), buscar el vector s.
- Decisión: Dado poly(n) pares (ai,bi), decidir:
    - Han sido generados como (ai,bi = S(T) ai + ei mod q)...
    - Han sino generados como (ai,bi) donde a es muestra uniforme de Z(n,q) y b es muestra de Zq

Resolver decisión implica resolver búsqueda.

### Error

El cigrado homomórfico y los problemas LWE tienen un rango de contención del error, dependiendo de como sea la constante en operaciones como multiplicación, es necesario mantener el error controlado para que la salida del descifrado no quede corrupta.

### Cifrado simétrico usando LWE



### Cifrado homomórfico

Es una técnica criptográfica que permite realizar cálculos directamente sobre datos cifrados, sin necesidad de descifrarlos primero. Los resultados cuando se descifran son los mismos que si se hubieran realizado sobre los datos originales. Los cifrados pueden ser Parcialmente Homomórficos, Levemente homomórficos o Totalmente homomórficos.

### Añadir dos mensajes



### Suma o resta desde una constante



### Multiplicación



### Descomposición Gadget



### Cambio de claves





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

- Enmascaramiento de datos: Los datos se ocultan o alteran para evitar que los originales sean reconstruidos (cifrado, mezcla, sustitución, caracteres). Se puede realizar cambio estático (al replicar BD) o dinámico (al consultar).
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

- Datos de localización: Características que distinguen a una persona (identidad), Información espacial (coordenadas, nombres de lugares o proximidad física) e Información temporal (timestamps para rastrear movimiento).
- Desafíos: Correlaciones entre datos de posición, trayectoria y tiempo pueden comprometer la privacidad. Los datos en tiempo real son muchos y exigen procesamiento inmediato. 

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

El objetivo específico es desarrollar un sistema que es capaz de solucionar un problema para el cual ha sido diseñado.

## Machine Learning

Rama de la IA cuyo objetivo es desarrollar algoritmos de aprendizaje para máquinas, desarrolla modelos computacionales capaces de aprender a solucionar problemas complejos a partir de ejemplos. 

Es adecuado cuando no sabes como montar un algoritmo que solucione un problema, pero si tienes ejemplos de la solución.

### Tipos de aprendizaje

Existen muchos tipos con sus subtipos, diferenciamos como principales el supervisado, no supervisado y refuerzo.

Dentro del aprendizaje supervisado tenemos problemas de clasificación (etiqueta) y problemas de Regresión (valor contínuo como la edad).

#### Generalización y sobreentrenamiento

La generalización es el término usado para describir la capacidad de un modelo de predecir o clasificar nuevos datos.

Sobreentrenamiento define un modelo que ha sido entrenado demasiado bien, provocando que memorice los datos de entrenamiento, pero no sea capaz de predecir nuevos datos.

#### Preparación de datos

Antes de usar datos para entrenar un modelo es necesario prepararlos y "limpiarlos": 
- Normalización.
- Recodificación de valores no numéricos.
- Eliminación de ruido.
- Imputación de datos.

## Modelos lineales de aprendizaje supervisado

### Notaciones matemáticas y definiciones

Escalares (*x,y*), Vectores (**x,y**), Matrices (**X,Y**), Productos, Normales de vectores.

### Métodos de regresión lineal

El mecanismo de regresión se basa en predecir el valor de una o varias variables continuas dado el valor de un conjunto de variables explicativas representadas por un vector m-dimensional.

- Elementos:
    - Variables explicativas: Parámetros de entrada del modelo.
    - Ejemplos de entrenamiento: Set de n datos de las variables explicativas cuya predicción es conocida.
    - Modelo: Función parametrizada que representa la relación entre x y t (w).
    - Objetivo (error o coste): Función que indica como de bien se aproximan los datos entrenados.
    - Método de optimización que encuentra los parámetros óptimos minimizando la función objetivo.

- Proceso de entrenamiento:
    - El objetivo es construir un modelo que encuentre los parámetros óptimos **w** para predecir el valor **t** de un nuevo valor **x**.
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

Como podemos evaluar de forma realista las métricas, el objetivo es la generalización del error del modelo. Para ello tenemos varios métodos de estimación del error.

### Partición simple

Dividir el dataset en dos subsets (entrenamiento y test). Si los datos son pocos es un lujo usar eso como test, solo se realiza un test, por lo que el resultado no es adecuado.

### Sub ejemplos aleatorios

Realizar K experimentos usando diferentes subsets de los datos, cada subset se elige de forma aleatoria y el resto para entrenamiento. El estimador del error real se consigue con la media de los errores de los K experimentos.

### K-fold cross-validation

Se divide el dataset en K subsets disjuntos de aproximadamente el mismo tamaño, con ellos se realizan K experimentos usando cada subset como test y el resto como entrenamiento. El error de validación es calculado como la media de cada E.

#### Stratified K-fold cross-validation

Variante de K-fold donde cada set contiene aproximadamente el mismo numero de casos de cada clase del data set completo.

#### Dejar uno fuera

Caso extremo de K-fold donde se realizan N experimentos con N datos, dejando siempre uno solo para test.

### Cross-Validation

¿Cuantos subsets y experimentos se deben realizar?

- Si se elige un numero grande: El estimador de error va a ser preciso, la varianza del error va a ser alta y el tiempo computacional va a ser alto.
- Si se eligen pocos: Tiempo computacional reducido, Varianza pequeña y estimador impreciso.

## Modelos no lineales de aprendizaje supervisado

Permiten la creación de zonas complejas de decisión para separar datos de distintas clases (suelen funcionar mejor que los lineales).

### Redes de neuronas artificiales

Las neuronas se organizan en una serie de capas que define la arquitectura de la red. El entrenamiento se basa en encontrar los pesos óptimos a través de funciones de error como MSE o Cross-entropy. Métodos de gradiente descendiente se utilizan para minimizar la función de error.

#### Back propagation

La back-propagation de error es un método eficiente de calcular el gradiente necesario para optimizar los pesos en una red multicapa.

1. Con un bloque de datos de entrenamiento propaga la salida hacia delante para calcular el error.
2. Propaga hacia atrás el error para obtener el gradiente en cada peso.
3. Usa los gradientes para actualizar los pesos. 

#### Algoritmos avanzados

Adam, RMSprop, AdaGrad, Momentum.

#### Decisión de región

Si la red no tiene capas ocultas la región es un hiperplano, si tiene 1 capa oculta es convexa, con 2 capas se convierte en una combinación de regiones convexas

#### Capacidad representacional

Según el teorema de aproximación universal de G.Cybenko una red de una capa puede representar cualquier función continua, una sola capa puede ser masiva para adaptarse a los datos. Pero lo normal es que la arquitectura sea más profunda.

### Redes neuronales convolucionales

Un modelo de red profundo que es capaz de capturar de forma correcta las dependencias temporales y espaciales de una imagen aplicando filtros. Esta arquitectura es más adecuada para imágenes debido a la reducción del número parámetros usados y reuso de pesos. Adecuada para el tipo rejilla.

#### Capa convolucional

Es una capa con una serie de filtros (kernels) que se aplican en la imagen y se pueden aprender. Estos filtros se activan cuando se detecta una característica visual como bordes o colores, el objetivo es extraer características relevantes de la imagen. Esencialmente realiza el producto escalar entre filtros y regiones locales de la imagen.

Normalmente tiene más de una capa convolucional, la primera es la responsable de capturar características de bajo nivel y el resto de alto.

#### Capa RELU

Normalmente usada tras una capa convolucional para transformar la operación lineal que esta realiza, es una función de activación definida como max(0,x).

#### Capa de Pooling

Se encarga de reducir el tamaño de la salida de la capa convolucional. Esto ayuda a reducir el núemero de parámetros y controlar así el sobreentrenamiento. Lo normal es colocar esta capa entre capas convolucionales sucesivas.

Tipos de pooling:
    - Máximos: Devuelve el valor máximo de la parte cubierta por el filtro.
    - Media: Devuelve la media de todos los valores parte de la imagen cubierta por el filtro.

#### Capa completamente conectada

Esta capa permite aprender combinaciones no lineales de características de alto nivel dadas por la capa convolucional. La entrada a esta capa es transformada en plano a un vector columna, durante el proceso de entrenamiento es capaz de distinguir características dominantes y clasificarlas usando softmas.

#### Recomendaciones para un buen entrenamiento

- Normalizar los datos (desviación estándar por píxel).
- Aumentar los datos (rotando imágenes).
- Usar datos balanceados en todas las clases.
- Aleatorizar el orden de entrada en entrenamiento.
- Inicializar los pesos aleatoriamente.
- Usar un set de validación para evitar sobreentrenamiento.

# Aprendizaje federado

El aprendizaje federado es un enfoque colaborativo y distribuido para entrenar modelos de aprendizaje automático sin necesidad de compartir los datos originales de los usuarios.

#### Características principales

Los datos permanecen en los dispositivos locales, lo que mitiga riesgos de filtración o uso indebido. Es especialmente útil en situaciones donde los datos están dispersos o no pueden centralizarse debido a restricciones legales.

#### Diferencias con enfoques tradicionales

En lugar de recopilar datos en una plataforma centralizada, los nodos locales realizan el entrenamiento parcial del modelo. Los parámetros actualizados se comparten con un servidor central que coordina el entrenamiento y construye un modelo global.

### Descripción del método

- Flujo de trabajo: 
    1. El servidor coordina la inicialización del modelo y distribuye los parámetros a los nodos. 
    2. Los nodos son seleccionados para una ronda de entrenamiento y el modelo es compartido por el coordinador.
    3. Cada nodo entrena el modelo con sus datos locales y envía actualizaciones al servidor. 
    4. El coordinador recibe actualizaciones entrenadas y las agrega para mejorar el modelo global.
    5. Esto genera una nueva versión actualizada del modelo que repite los pasos anteriores.
    6. Si el modelo cumple un criterio de rendimiento se termina y se produce el modelo final.

- Datos no uniformes: Los datos en los nodos pueden estar distribuidos de manera desigual, lo que presenta desafios en términos de convergencia y precisión del modelo.
- Algoritmos optimizados: Equilibran eficiencia y precisión, aunque pueden ser menos efectivos en comparación con enfoques centralizados.


### Problemas de privacidad y Modelos de ataque

- Ataques de inferencia:
    - Ataques de inversión del modelo: Recuperar datos de entrenamiento a partir del modelo.
    - Ataques de inferencia de membresía: Determinar si un registro específico está en el conjunto de datos de entrenamiento o de alguno de los nodos.
- Tipos de ataque: Desde el cliente comprobando las versiones del modelo o desde el servidor comprobando las actualizaciones enviadas.
- Ataques de envenenamiento:
    - Los adversarios manipulan actualizaciones del modelo para desviarlo hacia una solución subóptima o inyectar modelos con puertas traseras.

### Mecanismos de Preservación de la privacidad

- Prevención de ataques de inferencia:
    - Cifrado homomórfico que permite entrenar modelos sobre datos cifrados.
    - Agregación segura usando computación multipartida para combinar actualizaciones sin exponer datos individuales.
    - Privacidad diferencial añadiendo ruido a los datos o modelos.
- Prevención de ataques de envenenamiento:
    - Técnicas de detección de anomalías en modelos.
    - Inspección de datos y actualizaciones enviadas por los participantes.

# Privacy Preserving Machine Learning

Privacy Enhancing Tools (PET) con el enfoque en aprencizaje automático.

El aprendizaje automático preservando la privacidad (PPML) busca proteger los datos sensibles durante el entrenamiento y uso de modelos. Sin embargo, estos sistemas tienen varias amenazas que comprometen tanto los datos como los modelos.

## Modelos de amenazas

- Actores implicados: 
    - Propietarios de datos sensibles.
    - Propietarios y consumidores del modelo.
    -  Adversarios interesados en explotar vulnerabilidades.
- Superficies de ataque: 
    - Durante el entrenamiento cuando el modelo se construye.
    - Durante la inferencia, uso del modelo entrenado.
    - Comportamiento del atacante: Pasivo (observador), Activo (Manipula el proceso de entrenamiento o inferencia).
- Tipos de ataques: Basados en conocimiento limitado o completo del modelo y datos.

## Tipos de ataques

- Inferencia sobre miembros de la población
    - Revelación estadística
    - Inversión de modelos
    - Inferencia de representantes de clase
- Inferencia sobre los miembros del conjunto de datos de entrenamiento.
    - Inferencia de membresía.
    - Inferencia de propiedades.
- Inferencia sobre parámetros del modelo.
    - Extracción del modelo (precisión de tarea).
    - Robo de funcionalidades.

### Ataque de inferencia de membresía

El objetivo es determinar si una entrada ha sido usado en el entrenamiento basandose en el comportamiento del modelo sobre datos no conocidos o datos de entrenamiento.

- Caja negra: asume conocimiento sobre la predición de salida.
- Caja blanca: tiene acceso a parámetros y gradientes.
- Contra generativos: Obtiene información sobre los datos de entrenamiento usando conocimiento sobre los componentes de generación de datos.
- Contra Federados: Deducir si un registro específico forma parte de cualquier participante.

- Es necesario cuantificar la fuga de información de miembros a través de los resultados de predicción del modelo.
    - Dado un modelo y un registro determinar si se utilizó.
    - Investigar dado el entorno más dificil -> Caja negra.
- Un problema de inferencia de membresía es un problema de clasificación.
    - Entrenar un modelo para distinguir el comportamiento entre entrenamiento y no.
    - Usar Shadow Training: Shadow models que imitan el comportamiento del modelo objetivo.
    - Entrenar el modelo de ataque en las entradas y salidas etiquetadas de los Shadow.

#### Generar datos para los modelos Shadow

- Síntesis de modelo: El atacante no tiene ni datos ni estadísticas, por lo que genera datos usando el modelo víctima, los datos generados con gran confianza deberían ser similares a los de entrenamiento.
- Síntesis estadística: El atacante puede tener infomación estadística sobre la población de entrenamiento, cada muestra tiene su propia distribución marginal.
- Datos reales ruidosos: El atacante debe tener acceso a datos similares a los usados en el entrenamiento de la víctima.

#### Entrenar el modelo de ataque

Para el entrenamiento se hacen consultas a los modelos shadow usando un set de entrenamiento/test disjunto, se etiquetan las salidas como in/out respectivamente, se crean particiones por cada etiqueta diferente (diferentes modelos de ataque) y el resultado es una clasificación binaria

#### Resultados del ataque de membresía

Los ataques son robustos incluso si las suposiciones de distribución de entrenamiento del atacante no son precisas, para la mayor parte de los ataques es posible entrenarse solo con conocimiento de caja negra.

Para modelos del mismo tipo el sobreentrenamiento hace que sea más vulnerable, otros problemas pueden ser la estructura, la generalización y la diversidad de los datos de entrenamiento.

### Ataques de reconstrucción

Los ataques de reconstrucción intentan recrear muestras de entrenamiento o sus etiquetas, puede ser parcial o completa y los datos creados pueden ser los ratos originales o representativos de las propiedades sensibles.

#### Inversión de modelos

Una alta generalización puede producir una alta probabildidad de inferir atributos de los datos, un gran poder de predicción es más susceptible a los ataques de reconstrucción.

- M. Fredrikson contra LR: El adversario no tiene acceso al modelo ni conocimiento sobre características. Utiliza estimación de probabilidad máxima a posteriori (MAP) para inferir los valores de las características sensibles, maximizando la probabilidad de observar parámetros conocidos.
- S.Hidano sobre LR: No se asumen conocimientos, se basa en la posibilidad de realizar un ataque de envenenamiento durante el entrenamiento para influir en las predicciones.
- M. Fredrikson contra MLP/Autoencoders: Formulado como un problema de optimización, el objetivo es usar el gradiente descendiente para recuperar datos de entrada que coincidan con las salidas observadas.

#### Inferencia de propiedades

Estos ataques buscan extraer propiedades del conjunto de datos de entrenamiento que no están explícitamente codificadas como características ni están relacionadas con la tarea principal del modelo. Permiten identificar vulnerabilidades en el sistema y posibilitan la creación de modelos similares al objetivo.

Perspectiva del adversario: Las propiedades inferidas pueden ser generales o específicas, este tipo de ataques puede ocurrir incluso en modelos bien generalizados.

### Ataques de extracción de modelo

El objetivo es potencialmente la construcción de un modelo sustituto que imita al original a través de la extracción de información. Principalmente el objetivo de los modelos de sustitución es:
- Extracción de la precisión para igualar la del modelo original en los test.
- Extracción de la fidelidad: igualar un conjunto de puntos de entrada no relacionados y crear una imitación.

No es estrictamente necesario conocer la arquitectura del modelo víctima mientras el sustituto tenga la misma o mayor complejidad, el objetivo es robar hiperparámetros y propiedades de la arquitectura.

Causas: El subentrenamiento aumenta el éxito del ataque, los modelos con mayor generalización o mayor número de clases son más dificiles de atacar.

- Extracción de precisión de tarea: inferir parámetros del modelo, 
    - Elegir entradas útiles: Elegir entradas sintéticas cerca del límite de decisión del modelo objetivo. Otras estrategias sería no utilizar datos sintéticos de otros dominios, tecnicas semisupervisadas o generar entradas aleatorias.

- Extracción de funcionalidad:
    - T.Orekondy: Basado en pares entrada/salida observados en consultas MLaaS, interactua con CNN de caja negra proveyendo imagenes de entrada y obteniendo predicciones, estas predicciones se utilizan para entrenar el modelo de imitación.
    - N.Papernot: La víctima es un DNN, los inpues los genera un adversario y se etiquetan por el DNN.

## Resumen de los ataques GPT

| Ataque   | Objetivo Principal | Ventaja | Desventaja |
|----------|----------|----------|----------|
| Ataque de inferencia de Membresía  | Determinar si un dato específico fue parte del entrenamiento.En clasificación usar Shadow Models.  | Detecta vulnerabilidades en términos de privacidad   | Solo indica si un dato estuvo en el entrenamiento, no qué datos |
| Inversión de modelo    | Recuperar datos sensibles o privados a partir del modelo | Revela vulnerabilidades en cuanto a datos sensibles  | Requiere un modelo accesible y puede no ser fácil de ejecutar |
| Inferencia de propiedades  | Inferir características estadísticas del conjunto de datos  | Detecta patrones generales en el modelo entrenado | Menos preciso que otros ataques y puede no revelar datos específicos |
|  Extracción de modelo  | Obtener una aproximación del modelo entrenado | Permite replicar el modelo o usarlo sin acceso directo | La precisión depende de la cantidad de consultas y puede no replicar completamente el modelo |

# PPML Parte 2

## Privacidad diferencial

Las técnicas de privacidad diferencial resisten los ataques de inferencia de membresía añadiendo ruido aleatorio a los datos de entrada, a la iteraciones del algoritmo de machine learning y a las salidas del algoritmo.

- Input: Se añade en la entrada del modelo, tras el entrenamiendo de machine learning la salida será diferancialmente privada. Requiere añadir más ruido al input porque los datos tienen mayor sensibilidad.
- Perturbación de algoritmo: Aplicado a modelos que utilizan varias iteraciones, se añade ruido en los cálculos internos del algoritmo, requiere un diseño distinto para cada algoritmo. Tiene menos sensitividad en los datos e introduce menos ruido.
- Perturbación objetiva: Modificar la función objetiva de aprendizaje, esto cambia el problema de optimización dificultando la extracción de información.
- Perturbación de salida: Usar un algoritmo de aprendizaje no privado y añadir ruido al modelo generado, antes de ser compartido o utilizado.

### Privacidad diferencial local

Los individuos envían sus datos al agregador tras privatizar los datos con las perturbaciones.

Mecanismos LDP: 
- Una dimensión: Respuesta aleatoria y estimación de frecuencia.
- Multidimensional: Laplace, Duchi, Piecewise.

### Generación de datos sintéticos para preservar la privacidad

- Necesidad de datos en ML: Los algoritmos de aprendizaje automático requieren grandes volúmenes de datos para alcanzar su máximo rendimiento. A menudo no es factible recopilar y compartir datos reales en cantidades suficientes debido a restricciones legales.
- Datos Sintéticos como Solución: Los datos sintéticos son generados artificialmente mediante algoritmos que imitan la distribución y las propiedades de los datos originales. Conservan características críticas de los datos reales y permiten resultados similares, incluso en escenarios raros o poco comunes. Garantizan la protección de la privacidad mientras se mantiene la utilidad de los datos para aplicaciones específicas. El objetivo es inferir las etiquetas a partir de los registros y las salidas.

#### Métodos de generación y preservación de privacidad

- Anonimización de datos: K-Anonimidad protege contra reidentificación y L-Diversidad evita problemas con la homogeneidad de datos sensibles en los grupos
- Privacidad diferencial: Introduce ruido aleatorio para proteger la información sensible mientras se generan: 
    - Histogramas sintéticos. 
    - Datos tabulares sintéticos (tablas completas)
    - Datos multimarginales (distribuciones complejas con privacidad garantizada).

### Técnicas de minado de datos para preservar la privacidad

Minado de datos: Herramientas y técnicas que se pueden usar cada vez que la información recogida es procesada y analizada para extraer conocimiento.

- Modelos descriptivos: Identificar relaciones entre datos y descripciones reconocibles por humanos.
- Modelos prescriptivos: Usados para predecir el futuro basandose en el pasado.

# Comunicaciones anónimas

Las redes de comunicación utilizan direcciones visibles para enrutar datos, estas direcciones suelen ser identificadores únicos, lo que compromete la privacidad al asociarse con personas físicas.

La anonimización protege tanto la privacidad del usuario como las comunicaciones frente a análisis de tráfico. Se extiende a técnicas como autenticación anónima, votación y transacciones electrónicas.

Niveles de anonimato: Privacidad total (nadie identifica a nadie), Privacidad parcial (Las agencias de seguridad pueden romper el anonimato bajo órdenes judiciales) y sin anonimato.

Conceptos clave según Pfitzmann y Hansen:

- Anonimato: Estado en el que un individuo no puede ser identificado dentro de un grupo. Requiere que haya sujetos con atributos iguales.
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

Construcción: Siempre se usan 3 nodos(in, mid, out), el de entrada es confiable y elegido por su estabilidad, los circuitos rotan periódicamente y se usan claves a corto y largo plazo para negociar cifrados y proteger datos. La clave a largo plazo se usa como identificador y la de corto plazo como clave onion.

Transferencia de datos: Los mensajes se dividen en paquetes fijos de 512B, los routers desencriptan una capa en cada salto y en las respuestas se hace el proceso inverso.

Servicios ocultos: 
- Permite que usuario y servidor no conozcan sus direcciones IP mutuas, el servidor selecciona nodos cebolla como "puntos de introducción" y publica un descriptor en una tabla hash distribuida (pk y direcciones de los puntos).
- El usuario elige un punto de introducción y un "punto de encuentro" aleatorio, se solicita a ese punto que introduzca cliente y servidor y si el servidor acepta se crea un circuito para conectarse de forma segura.