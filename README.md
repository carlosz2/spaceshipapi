# Spaceship API

Spaceship API es un proyecto de ejemplo que utiliza Spring Boot para gestionar una API REST de naves espaciales de series y películas. El proyecto también integra RabbitMQ para la mensajería asíncrona y está dockerizado para facilitar su despliegue.

## Requisitos

- Java 21 (última versión LTS)
- Maven 3.6+
- Docker (para ejecutar RabbitMQ y la aplicación)

## Funcionalidades

La API permite realizar las siguientes operaciones CRUD sobre las naves espaciales:

- Consultar todas las naves utilizando paginación.
- Consultar una única nave por ID.
- Consultar todas las naves que contienen, en su nombre, el valor de un parámetro enviado en la petición.
- Crear una nueva nave.
- Modificar una nave.
- Eliminar una nave.

## Características adicionales

- Test unitario de como mínimo una clase.
- Desarrollar un @Aspect que añada una línea de log cuando se consulta una nave con un ID negativo.
- Gestión centralizada de excepciones.
- Utilización de cachés.
- Utilización de H2 en memoria como base de datos.
- Scripts DDL gestionados con Flyway.
- Test de integración.
- Aplicación dockerizada.
- Documentación de la API.
- Seguridad del API.
- Implementación de un consumer/producer para RabbitMQ.

## Configuración

### RabbitMQ

Para ejecutar RabbitMQ, puedes usar Docker. Ejecuta el siguiente comando para iniciar un contenedor RabbitMQ:

```sh
docker run -d --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3-management