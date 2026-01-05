# Test de ejemplo

## ¿Cuáles son las diferencias entre un permiso normal, signature, dangerous y signatureorsystem? ¿Es posible revocar los permisos de una aplicación después de haberla instalado? ¿En qué condiciones?

- Normal: Bajo riegso, se otorgan automáticamente en la instalación.
- Dangerous: acceso a datos sensibles que requieren aprobación explícita del usuario.
- Signature: Solo apps firmadas con el mismo certificado pueden suarlos (entre el mismo fabricante).
- SignatureOrSystem: Lo mismo pero también aplicable a apps preinstaladas.

la condición es Android 6.0 que incluye que se puedan revocar desde ajustes en cualquier momento.

## Como se ha visto en prácticas, APKTool es una herramienta que nos permite empaquetar y desempaquetar aplicaciones Android. A efectos de análisis de seguridad, ¿qué información de interés nos permite extraer de una aplicación?

Información extraíble con APKTool:
- Estructura del APK: Manifest, recursos y librerías.
- Código Smali: Representación legible del bytecode Dalvik.
- Dentro del Manifest: Permisos solicitados y configuración de componentes (actividades, servidicos y exportaciones).

## Indica cuáles son las ventajas del modo de cifrado basado en archivos (File Based Encryption) frente al modo de cifrado de disco completo (Full Based Encryption). ¿Alguno de estos dos sistemas protege el acceso a la información privada de una aplicación si el dispositivo está rooteado? ¿Cuál?¿Por qué?

Ventajas:
- FBE: Cifrado por archivo/clave independiente, permite desbloquear selectivamente archivos sin desbloquear todo el dispositivo.
- FDE: Cifrado monolítico de toda la partición /data.

Rooteados:
- FBE: Protege archivos privados de apps (unicas por usuario y app). Sin root el acceso está restringido por SELinux (debe ser).
- FDE: Vulnerable si el atacante obtiene acceso root, la clave maestra se guarda en memoria tras el desbloqueo.

## ¿Para qué sirve la herramienta androlyze de Androguard?

Es una herramienta interactiva que permita analizar APKs. permite extraer metadatos de la aplicación, analizar flujos de código y detectar malware mediante comparación con firmas.

## ¿Con qué mecanismos contamos para proteger una aplicación frente a ataques de ingenierı́a inversa?

- Obfuscación.
- Cifrado de código.
- Anti-debugging para detectar depuradores con comprobaciones en tiempo real.
- Root/Jailbreak detection: Bloquear ejecución en dispositivos modificados.

## ¿En qué se diferencia el análisis dinámico del estático de una aplicación móvil? ¿Es necesario realizar los dos? Justifica tu respuesta.

Siempre es necesario realizar los dos, el estático revela una serie de vulnerabilidades "superficiales" que luego se pueden verificar en el análisis dinámico, es decir supone una base sobre la que aplicar el dinámico. El estático examina código sin ejecutar aplicaciones, detectando claves hardcodeadas o permisos excesivos. El dinámico ejecuta la app para monitorizar el comportamiento, prestando atención a llamadas a APIs y tráfico de red.

## Describe el proceso para compartir información sensible de forma temporal con una aplicación que, en principio, no tiene permisos para acceder a dicha información. ¿Es posible hacerlo? Justifica tu respuesta.

Para compartir datos sensibles temporalmente se piede isar "FileProvider" para generar URIs con permisos de lectura/escritura limitados. Después un intent con Flag "FLAG_GRANT_READ_URI_PERMISSION" permite el acceso temporal a datos de otra app.

## ¿En qué consiste la gestión de aplicaciones móviles (Mobile Application Management, MAM)?

Sistema para gestionar apps empresariales (sin control total del dispositivo). Incluye la distribución segura, políticas de acceso y borrado remoto de datos corporativos.

## Enumera y describe brevemente las etapas de un análisis forense en un entorno móvil.

Respuesta de AF acortando el inicio: Preparación, Adquisición, Análisis y Presentación. En la teoría añade una etapa de examinación que se basa en sacar conclusiones de los datos de la adquisición.

## Indica las diferencias, en cuanto a la información que se puede obtener, cuando se lleva a cabo una adquisición de datos lógica en un móvil rooteado y en un móvil sin rootear.

- Sin root: Solo datos accesibles para el usuario o via APIs, como fotos, contactos y a veces SMS. Todo lo que esté limitado por permisos.
- Rooteado: Acceso a la partición /data, incluyendo bases de datos de apps, logs del sistema y almacenamiento restringido.

# Tema 1 : Vulnerabilidades y amenazas que afectan a los dispositivos móviles



## Vulnerabilidades y Amenazas



## OWASP Top Ten Mobile Risks



## Incidentes



# Tema 2 : Arquitecturas de los dispositivos móviles

## Sistema Operativo Android



### Arquitectura



### Gestor de paquetes



### Gestión de Usuarios



## Aplicaciones Android



### Componentes



### Intents



### Manifest



## Modelo de Seguridad Android



# Tema 3 : Analizando vulnerbailidades de aplicaciones y dispositivos



## Explotando componentes de las aplicaciones



## Aplicaciones potencialmente dañinas



## Security Testing



### Profiling



### Análisis estático



### Análisis dinámico



### Fuzz Testing



# Tema 4 : Desarrollando Aplicaciones Seguras



## Protección del código de la aplicación



## Gestión de los datos sensibles



## Fuga de logs e información sensible



# Tema 5 : Seguridad en el dispositivo y las comunicaciones



## Seguridad del dispositivo



### Bootloader



### Recuperación del Sistema Operativo



### Bloqueo de pantalla



### Debugging USB



### Permisos



## Seguridad en las configuraciones



### Securizar las comunicaciones



### PKI, SSL y Certificados



# Tema 6 : Análisis Forense en entornos móviles



## Metodologías


## Reporte Forense



## Herramientas



## Métodos de adquisición de datos



## Análisis de los datos



## Tipos de análisis según la evidencia adquirida



## Análisis en Android



# Tema 7 : Seguridad en empresas



## Gestión de la movilidad empresarial



### Gestión de los dispositivos móviles



### Gestión de las aplicaciones móviles



## Políticas de BYOD



## MDM y BYOD en Android

