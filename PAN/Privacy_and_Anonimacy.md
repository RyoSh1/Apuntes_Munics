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





\textbf{Q4} Sea $g$ la función que calcula el histograma de edades (recuerda que $g = [g_1, \dots, g_{126}]$). Calcula $\Delta(\text{histograma})$. Ten en cuenta que cuando eliminas una fila y añades otra, como máximo cambian dos casillas del histograma.

\textbf{Q5} Escribe una función que genere una base de datos aleatoria con 4 columnas que representen los atributos discutidos anteriormente y $n$ filas, donde $n$ debe ser un parámetro. Para mayor comodidad, puedes reemplazar el atributo `Nombre' por un identificador aleatorio (de hecho, solo utilizaremos las otras 3 columnas). Puedes elegir cualquier distribución que prefieras para los tres atributos, por ejemplo, `Edad' puede obtenerse mediante una muestra uniforme de enteros entre 0 y 125, y `SB1' y `SB2' pueden ser muestras de distribuciones Bernoulli(1/2) (o sea, ceros y unos con probabilidad 1/2). También puedes elegir el formato de base de datos que te resulte más conveniente (por ejemplo, un dataframe, una matriz, 4 vectores, etc.).

\textbf{Q6} Escribe funciones que, tomando una base de datos como entrada, calculen versiones $\epsilon$-Privadas Diferenciales de las funciones en las preguntas Q1, Q2, Q3 y Q4.

\textbf{Q7} Supongamos que tenemos una función $g = [g_1, \dots, g_k]$ que produce $g(D) = [g_1(D), \dots, g_k(D)]$ cuando se aplica a la base de datos $D$; un curador aplica un mecanismo a $g(D)$ que devuelve $R = [R_1, \dots, R_k]$. Entonces, $E = R - g(D)$ denota el vector de errores.

Para tamaños de base de datos $n = 101, 1001$ y $10001$, realiza el siguiente experimento:
\begin{itemize}
    \item Para $m = 1$ hasta $100$, haz lo siguiente:
    \begin{enumerate}
        \item Genera una base de datos aleatoria $D(m)$.
        \item Mide los valores verdaderos de las funciones en Q1, Q2, Q3, Q4 aplicadas a $D(m)$. Almacena los vectores correspondientes $g(D(m))$.
        \item Para cada función, aplica el mecanismo con $\epsilon = 1$ y obtén el vector de errores $E(m)$.
    \end{enumerate}
\end{itemize}

Calcula/dibuja la desviación cuadrática media normalizada (NRMSD) para cada componente de los vectores de salida. Por ejemplo, cuando $g = g(\text{histogram})$, la NRMSD de su primera componente viene dada por
\[
\left( \sqrt{\frac{\sum_{m=1}^{100}(E^{(m)}_1)^2}{100}} \right) \Big/ \left( \frac{\sum_{m=1}^{100} g(\text{histogram})_1(D(m))}{100} \right)
\]
(la NRMSD mide la relación entre una estimación de la desviación típica del error y una estimación del valor medio; es una especie de relación ruido-a-señal).

Deberás hacer la representación para cada una de las funciones en Q1, Q2, Q3 y Q4 y para los tamaños de base de datos $n = 101, 1001,$ y $10001$. Discute los resultados. En particular, comenta cómo la utilidad de cada función se ve afectada por la aplicación del mecanismo Laplaciano.
