# Fortificación de sistemas: Windows

## Capítulo 1: Arquitectura de seguridad

Windows 11 está diseñado con una arquitectura de múltiples capas de protección a nivel hardware y software.

### Seguridad basada en hardware

- **Trused Platform Module 2.0**: Chip dedicado que gestiona claves criptográficas y protege datos sensibles. Asegura el arranque del sistema, cifra los datos y proporciona una base para la autenticación segura. 
- **Secure Boot**: Garantiza el arranque solo con software firmado y verificado digitalmente. Previene la integridad del sistema desde el inicio.
- **Virtualización de seguridad**: Utiliza tecnologías de virtualización del hardware para crear un entorno aislado que protege las operaciones críticas del sistema, como la administración de credenciales y la protección de memoria.

### Seguridad en el núcleo del sistema 

- **Protección de Código Basada en Virtualización**: HVCI utiliza la virtualización para proteger la memoria del sistema operativo contra ataques de malware y explotación de vulnerabilidades.
- **Protección de la integridad de la memoria**: Asegura que los procesos críticos del sistema se ejecuten en un entorno seguro y aislado, reduciendo el riesgo de que el malware afecte a la memoria y a su integridad.

### Seguridad en el sistema de archivos

- **BitLocker**: Cifrado de disco completo para proteger los datos almacenados en el volumen.
- **Protección de datos con EFS**: El Sistema de Archivos Encriptado permite cifrar archivos individuales en el sistema de archivos NTFS, proporcionando una capa de seguridad adicional sin cifrar todo el disco.

### Seguridad en la red

- **Firewall de Windows**: El firewall integrado controla el tráfico de red entrante y saliente, aplicando reglas para permitir o bloquear conexiones según la configuración de seguridad del usuario y la organización.
- **Protección contra Amenazas de Red**: W11 incluye características de protección contra ataques de red como filtro de contenido, protección de intrusiones y control de acceso sobre aplicaciones.

### Gestión de Identidad y Acceso

- **Windows Hello**: Opciones de autenticación biométrica, como reconocimiento facial o huellas dactilares, así como PINs. 
- **Autenticación Multifactor (MFA)**: Capa adicional de seguridad al requerir múltiples formas de verificación antes de permitir el acceso al sistema.

### Actualizaciones y Parcheo de seguridad

- **Actualizaciones automáticas**: W11 está diseñado para gestionar automáticamente las actualizaciones del sistema operativo, incluyendo parches de seguridad y mejoras.
- **Windows Update for Business**: Gestión para organizaciones.

### Protección de la privacidad

- **Controles de privacidad mejorados**: W11 proporciona herramientas y configuraciones avanzadas para gestionar el acceso de las aplicaciones a datos personales y funcionalidades del sistema.
- **Transparencia en el manejo de datos**: W11 proporciona informes y herramientas para que los usuarios puedan ver y controlar cómo se recopilan y utilizan sus datos, promoviendo una mayor transparencia y confianza.

### Características de seguridad incorporadas en el diseño de W11

- **Hardware**:
    - TMP 2.0.
    - Secure Boot.
- **Identidad y acceso**:
    - Windows Hello.
    - MFA.
- **Datos y cifrado**:
    - BitLocker.
    - Protección de Datos de la Empresa: Protección cifrada de datos corporativos al cifrarlos y asegurando que solo se acceda con autorización.
- **Malware y amenazas**:
    - Microsoft Defender Antivirus: Protección en tiempo real contra malware, spyware y otras amenazas. Incluye capacidades avanzadas de detección y respuesta, aprovechando IA.
    - Control de aplicaciones de Windows Defender (WDAC): Control de ejecución de aplicaciones en los equipos de una organización.
- **Red**:
    - Firewall.
    - Protección contra vulnerabilidades de red.
- **Integridad y virtualización**:
    - Virtualización de Seguridad: Utiliza las capacidades de virtualización del hardware para crear un entorno aislado y seguridad
    - HVCI.
- **Actualizaciones y gestión**:
    - Actualizaciones automáticas: Gestiona automáticamente las actualizaciones del sistema operativo, asegurando recibir los últimos parches de seguridad.
    - Windows Update for Business: Permite gestionar el despliegue de actualizaciones en los entornos empresariales sin interrupciones significativas.
- **Privacidad y control de acceso**:
    - Controles de privacidad: Opciones avanzadas de gestión de permisos de las aplicaciones y acceso a datos personales.
    - Gestión de acceso a datos: Herramientas para controlar qué aplicaciones pueden acceder a datos sensibles.
- **Seguridad y monitoreo**:
    - Centro de seguridad de Windows: Panel centralizado para gestionar el estado de la seguridad del sistema.
    - Visor de Eventos y Registro de Seguridad: Permite a los administradores monitorear y registrar eventos de seguridad en el sistema, facilitando detección y respuesta.

### Importancia de mantener el sistema operativo actualizado


- ****:
- ****:
- ****:
- ****:
- ****:
- ****:

## Capítulo 2: Configuración y administración de cuentas de usuario



### 



### 



### 



### 

## Capítulo 3: Seguridad en la red y en internet



### 



### 



### 



### 



### 

## Capítulo 4: Defensa contra malware y amenazas



### 



### 



### 



### 



### 



### 



### 



### 



### 

## Capítulo 5: Cifrado y protección de datos



### 



### 



### 



### 

## Capítulo 6: Herramienta de administración y auditoría de seguridad



### 



### 



### 

## Capítulo 7: Proteción de la privacidad y control de acceso



### 



### 



### 



## Capítulo 8: Respuestas a incidentes y planes de recuperación



### 



### 



### 



### 



### 



### 



### 

## Capítulo 9: Mantenimiento y actualización de la seguridad



### 



### 



### 

## Capítulo 10: Seguridad avanzada y nuevas tecnologías



### Seguridad en ambientes de computación híbrida y remota



### Inteligencia artificial y seguridad en W11



### Futuro de la IA en la seguridad de W11



### Futuro de la seguridad en sistemas operativos Windows



## Capítulo 11: Control de aplicaciones con AppLocker y Políticas de Restricciones de software



### AppLocker



### Políticas de restricciones de Software (SRP)



### Comparación entre AppLocker y SRP

## Capítulo 12: Esquema Nacional de Seguridad y su aplicación en Windows 10



### Fundamientos del Esquema Nacional de Seguridad



### Aplicación del ENS en W10



### Implementación del ENS en W10



### Beneficios de cumplir con el ENS


Obviando todo lo anterior...

# Extra : Conceptos importantes

- VBS: Virtualización de seguridad, utiliza tecnologías de virtualización del hardware para crear un entorno aislado que protege las operaciones críticas del sistema como credenciales o protección de memoria.
- HVCI: Utiliza la virtualización para proteger la memoria del sistema operativo contra ataques de malware y explotación de vulnerabilidades.
- TMP: Chip dedicado que gestiona claves criptográficas y protege datos sensibles. Asegura el arranque del sistema y proporciona una base para auntenticación segura. En Bitlocker sirve para guardar la clave de inicio.
- Secure Boot: Garantiza que el sistema arranque solo con software firmado digitalmente y verificado.
- BitLocker: Herramienta de cifrado de disco completo que utiliza AES para proteger los datos en una unidad.
- EFS: Una característica integrada en el sistema de archivos NTFS que permite a los usuarios cifrar archivos y carpetas de manera transparente.
- MFA: Autenticación multifactor.
- Windows Hello: Tecnología de autenticación biométrica integrada en Windows 11 que permite a los usuarios iniciar sesión utilizando reconocimiento facial, huellas, PIN.
- Firewall: Monitorea y filtra el tráfico de red basado en reglas predefinidas y 
personalizadas, bloqueando conexiones no autorizadas mientras permite el tráfico 
legítimo.
- VPN: Red Virtual Privada.
- AppLocker:
- SRP: Políticas de restricciones del software, identifica los programas que se ejecutan en los equipos de un dominio y controla la capacidad de ejecución. Conjunto con AppLocker.
- Principio del menor privilegio:
- Windows Defender: Monitorea constantemente el sistema 
para detectar y neutralizar amenazas a medida que surgen. Esto incluye la vigilancia de 
archivos descargados, programas ejecutados y conexiones de red.
- Backup:
- RBAC: Control de acceso basado en roles (En vez de a usuarios individuales).
- FIDO: Un dispositivo FIDO2 es un método de autenticación seguro que permite a los usuarios iniciar sesión sin necesidad de contraseñas tradicionales. Se basa en estándares abiertos desarrollados por la FIDO Alliance y está diseñado para mejorar la seguridad y la facilidad de acceso a servicios en línea.
- Azure Active Directory: servicio de gestión de identidades y accesos basado en la nube de Microsoft.
- Capas de defensa: Perímetro, Red, Endpoint, Aplicación, Datos, Identidad y Acceso.
- DRA: Agente de recuperación de datos cifrados.
- IAM: Gestor de identidades y accesos.
- Tipos de registros de eventos: Sistema, Seguridad, Aplicaciones y Personalizados.
- Eventos clave: Inicio de sesión o cierre, Intentos fallidos de inicio, Campios en políticas, Acceso a objetos auditados.
- GPMC: Consola de administración de directivas de grupo.
- Fases de la respuesta a incidentes: Preparación, Identificación, Contención, Erradicación, Recuperación, Lecciones aprendidas.
- SOAR: Plataformas de Orquestación, Automatización y Respuesta de Seguridad.
- Regla 3-2-1: Mantener al menos tres copias de los datos, en dos tipos diferentes de 
almacenamiento, y una copia fuera del sitio (offsite).También Diarias incrementales, Semanales Diferenciales y Mensuales completas.
- Opciones de restauración en Windows 11: Restaurar sistema, Restablecer el PC, Recovery Drive, Historial de archivos.
- Windows Recovery Environment (WinRE): Entorno de recuperación avanzado que incluye herramientas para solucionar problemas, restaurar el sistema y acceder a copias de seguridad.
- WSUS: Windows Server Update Services,  solución de Microsoft para gestionar la distribución de actualizaciones y parches en entornos empresariales.
- MECM: Microsoft Endpoint Configuration Manager,  herramienta de Microsoft para la gestión de sistemas y dispositivos en entornos empresariales. 
- Windows Update for Business: Permite crear anillos de despliegue.