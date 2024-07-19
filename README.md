# Proyecto CRUD con Spring Boot y PostgreSQL

Este proyecto implementa un CRUD utilizando Java 17 y Spring Boot 3.3.1, con PostgreSQL como base de datos relacional para la persistencia. Incluye manejo de excepciones mediante handlers y sigue el patrón de diseño MVC (Modelo-Vista-Controlador). En lugar de utilizar un ORM como Hibernate, se utiliza JDBC (Java Database Connectivity) para la interacción con la base de datos. Además, se han realizado pruebas simples utilizando Mockito.

## Características del Proyecto

- **Tecnologías Utilizadas:** Java 17, Spring Boot 3.3.1, PostgreSQL, JDBC.
- **Funcionalidades Implementadas:**
  - Operaciones CRUD para entidades de negocio.
  - Manejo estructurado de excepciones.
  - Patrón de diseño MVC para separación de responsabilidades.
  - Uso de JDBC para la conexión y operaciones con la base de datos.
  - Pruebas unitarias simples con Mockito para validar la lógica de negocio.

## Configuración y Uso

Para ejecutar este proyecto localmente, asegúrate de tener instalado:

- Java Development Kit (JDK) 17
- Maven (para la gestión de dependencias)
- PostgreSQL (puedes usar una instancia local o remota)

### Configuración de PostgreSQL

Edita el archivo `src/main/resources/application.properties` con la configuración de tu base de datos PostgreSQL:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/nombre_basedatos
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.datasource.driver-class-name=org.postgresql.Driver
