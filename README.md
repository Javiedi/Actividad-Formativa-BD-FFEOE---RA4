# Sistema de Gestión de Incidencias - FFEOE

Este proyecto es una API REST desarrollada en **Spring Boot** para automatizar el control y resolución de incidencias técnicas dentro de la empresa FFEOE.

## 🛠️ Tecnologías utilizadas
* Java 17
* Spring Boot (Spring Data JPA, Spring Web)
* MySQL (Base de datos)
* Hibernate / Jackson

## 🚀 Instrucciones de despliegue y arranque

### 1. Requisitos previos
Es necesario tener instalado en el sistema:
* Java 17 o superior.
* Servidor MySQL (XAMPP / phpMyAdmin).

### 2. Configuración de la Base de Datos
1. Abre tu gestor de MySQL y crea una base de datos vacía llamada `db_practicas`.
2. Revisa el archivo `src/main/resources/application.properties` y asegúrate de que las credenciales de conexión (`username` y `password`) coinciden con tu entorno local.

### 3. Arranque del proyecto
Para compilar y arrancar la aplicación desde la terminal, ejecuta:
```bash
mvn spring-boot:run
