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
---------------------------------------------------------------------------
# 🛠️ Sistema de Gestión de Incidencias (Pruebas y Depuración) - 1º DAM

Este repositorio contiene la evolución del proyecto de Base de Datos para la asignatura de **Entornos de Desarrollo**. Se ha implementado una arquitectura por capas introduciendo un componente de lógica de negocio (`IncidenciaServicio.java`) y se ha desplegado una suite completa de pruebas unitarias, pruebas de integración y sesiones de depuración controlada.

---

## 🧪 ¿Qué se ha probado en el sistema?

Se ha configurado un plan de pruebas automatizado utilizando **JUnit 5** y **Mockito** dentro de `IncidenciaAplicacionTests.java`. El software evalúa los siguientes escenarios críticos:

1. **Prueba Unitaria - Alta de Incidencia Válida:** Comprueba que al introducir una descripción correcta, el servicio procesa el registro y aplica la regla de negocio forzando de forma automática el estado inicial a `"Abierta"`.
2. **Prueba Unitaria - Validación de Descripción Vacía:** Asegura la robustez del código verificando que se lance una excepción controlada de tipo `IllegalArgumentException` si un usuario intenta dar de alta un ticket sin texto.
3. **Prueba Unitaria - Control del Flujo de Borrado:** Valida que el método de eliminación devuelva un booleano `false` de manera segura si se intenta borrar un identificador (ID) que no existe en el sistema MySQL, evitando caídas críticas.
4. **Prueba de Integración - Endpoint de Consulta:** Utiliza herramientas de simulación de red (`MockMvc`) para atacar directamente la ruta de la API REST (`GET /incidencias`), certificando que el servidor responde con un código de éxito `200 OK` y bajo una estructura de datos estándar.

---

## 🚀 Cómo ejecutar las pruebas en tu máquina (Linux / Ubuntu)

Para compilar el entorno y lanzar las pruebas automatizadas en local, abre tu terminal de Linux dentro del directorio raíz del proyecto (`ProyectoFFEOE`) y ejecuta los siguientes comandos:

1. **Limpiar compilaciones previas y descargar dependencias:**
```bash
   mvn clean
