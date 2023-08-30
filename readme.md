# Microservicio The Best Travel

## 1. Acerca del microservicio

El Microservicio The Best Travel es una aplicación que proporciona a los usuarios la posibilidad de visualizar vuelos y hoteles junto a sus precios e información relevante.
Además, el usuario tiene la posibilidad de crear ticekts para comprar un vuelo, la posibilidad de crear una reservación en un hotel, o incluso de crear un tour, el cual incluirá tanto ticket de vuelo como reservación en hotel.

## 2. Tecnologías involucradas

El microservicio The Best Travel se desarrolló utilizando las siguientes tecnologías:

- **Java 17:** Lenguaje de programación en el que se creó esta aplicación.
- **Spring 3.0.5:** Framework de desarrollo de aplicaciones Java, se han tomando en cuenta módulos como Spring core, Spring Boot, Spring data JPA, Spring Cloud para configuraciones en la nube, Spring Security para gestionar permisos de acceso.
- **PostgreSQL:** Motor de bases de datos relacionales.
- **MongoDB:** Base de datos NoSQL para almacenar información de los usuarios.
- **Docker:** Tecnología empleada para crear imágenes tanto de bases de datos como del proyecto en sí.

## 3. Manual de instalación

Para poder instalar este microservicio será necesario Docker, pues esta aplicación utilizó imágenes de PostgreSQL y MongoDB para gestionar la información.

1.- Instalación mediante docker-compose: 

- Abra una terminal en el presente directorio

- Ejecute el comando "docker compose up"

- Espere alrededor de 3 minutos para que la aplicación y todas sus dependencias inicien.

### Guía de uso y postman:

Como este Microservicio ha implementado Oauth para manejo de seguridad, será necesario seguir una serie de pasos antes de tener la posibilidad de realizar una petición HTTP. 
Por favor, abra el archivo Word llamado "Guía de uso y Postman" para realizar este proceso.

