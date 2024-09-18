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
