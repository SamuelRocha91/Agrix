# <img src="https://blog.geekhunter.com.br/wp-content/uploads/2020/07/pngwing.com_.png" alt="Java Projects Logo" width="52" height="40" /> 🌱 Agrix - Gestión y Monitoreo de Granjas <img src="https://blog.geekhunter.com.br/wp-content/uploads/2020/07/pngwing.com_.png" alt="Java Projects Logo" width="52" height="40" />

![Estado: En Desarrollo](https://img.shields.io/badge/status-en%20desarrollo-yellow)

## 🌐 [![Português](https://img.shields.io/badge/Português-green)](https://github.com/SamuelRocha91/Agrix/blob/main/README.md) [![Español](https://img.shields.io/badge/Español-yellow)](https://github.com/SamuelRocha91/Agrix/blob/main/README_es.md) [![English](https://img.shields.io/badge/English-blue)](https://github.com/SamuelRocha91/Agrix/blob/main/README_en.md) [![Русский](https://img.shields.io/badge/Русский-lightgrey)](https://github.com/SamuelRocha91/Agrix/blob/main/README_ru.md) [![中文](https://img.shields.io/badge/中文-red)](https://github.com/SamuelRocha91/Agrix/Agrix/blob/main/README_ch.md) [![العربية](https://img.shields.io/badge/العربية-orange)](https://github.com/SamuelRocha91/Agrix/blob/main/README_ar.md)


## 📜 Introducción

El proyecto Agrix es un proyecto evaluativo desarrollado en el módulo de Java del curso de Desarrollo Web de Trybe. El proyecto involucró el uso de Java, Maven, Docker, MySQL y casi todo el ecosistema Spring. La aplicación fue construida con total libertad de implementación, abarcando desde la manipulación de código hasta la configuración.

La aplicación tiene como objetivo gestionar y monitorear las granjas participantes que buscan perfeccionar sus tecnologías y utilizar la tierra de manera responsable. El sistema incluye rutas para autenticación, autorización, registro de granjas, cultivos, fertilizantes y mucho más.


## 📈 Diagrama de la Base de Datos

![Diagrama de la base de datos](./images/diagrama.png)

## 🛤️ Rutas

![Diagrama de las rutas](./images/routeOne.png)  
![Diagrama de las rutas](./images/routesTwo.png)


## 🛠️ Funcionalidades Implementadas

- **Autenticación y Autorización**: Implementación de seguridad usando Spring Security para gestionar el acceso a las rutas de la aplicación.
- **Registro de Entidades**: Rutas para el registro de granjas, cultivos y fertilizantes.
- **Gestión de Inventario y Cultivos**: Funcionalidades para gestionar el inventario de fertilizantes y los cultivos en las granjas.
- **API REST**: Desarrollo de una API REST para interacción con el sistema.
- **Gestión de Errores**: Implementación de la gestión de errores usando Spring Web.
- **Docker**: Creación de un Dockerfile para configurar la aplicación para su ejecución en Docker.

## 📚 Habilidades Desarrolladas

Durante el desarrollo de este proyecto, se trabajaron las siguientes habilidades:

- **Spring Framework**: Uso de Spring para construir la aplicación e implementar la seguridad.
- **Spring Security**: Aplicación de conocimientos para añadir autenticación y autorización.
- **Java Web**: Desarrollo de una aplicación web utilizando Java.
- **API REST**: Creación de rutas de la API e implementación usando Spring.
- **Spring Data JPA**: Utilización para la persistencia de datos en la base de datos.
- **Docker**: Configuración de la aplicación para ser ejecutada en contenedores Docker.
- **JUnit**: Implementación de pruebas con el framework JUnit.

## 📋 Requisitos

- **Java 17**
- **Maven 3.8.1 o superior**
- **Docker** (opcional, para ejecución en contenedores)

## 🔧 Instalación y Ejecución

Siga las instrucciones a continuación para configurar y ejecutar el proyecto localmente:

### 1. Clona el repositorio

```bash
git clone git@github.com:SamuelRocha91/Agrix.git
```

### 2. Navega hasta el directorio del proyecto

```bash
cd agrix
```

### 3. Compila y ejecuta la aplicación

Para compilar y ejecutar la aplicación localmente, utiliza Maven:

```bash
mvn spring-boot:run
```

### 4. Ejecuta las pruebas

Para correr las pruebas automatizadas, utiliza el comando:

```bash
mvn test
```

### 5. Configuración de Docker

Para construir y ejecutar la aplicación usando Docker, sigue las instrucciones a continuación:

1. Construye Docker:

   ```bash
   docker compose up
   ```


## 🗂️ Estructura de Archivos

La estructura del proyecto está organizada de la siguiente manera:

```
.
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── betrybe/
│   │   │           └── agrix/
│   │   │               ├── controller/        # Controladores de la API
│   │   │               ├── model/             # Modelos de datos
│   │   │               ├── repository/        # Repositorios JPA
│   │   │               ├── service/           # Servicios de aplicación
│   │   │               └── AgrixApplication.java  # Clase principal
│   ├── test/
│   │   └── java/
│   │       └── com/
│   │           └── betrybe/
│   │               └── agrix/
│   │                   ├── controller/        # Pruebas de los controladores
│   │                   ├── service/           # Pruebas de los servicios
│   │                   └── repository/        # Pruebas de los repositorios
├── Dockerfile                # Dockerfile para configuración de la aplicación
├── pom.xml                   # Archivo de configuración de Maven
└── README.md                 # Documentación del proyecto
```

## 📦 Dependencias

Las principales dependencias del proyecto son:

- [Spring Boot](https://spring.io/projects/spring-boot): Framework para el desarrollo de aplicaciones Java.
- [Spring Security](https://spring.io/projects/spring-security): Framework para seguridad y autenticación.
- [Java JWT](https://github.com/auth0/java-jwt): Biblioteca para manipulación de JWT.
- [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/): Conector JDBC para MySQL.
- [JUnit](https://junit.org/junit5/): Framework para pruebas unitarias.

## 🚀 Mejoras Futuras

El proyecto está en desarrollo y se planea implementar las siguientes mejoras:

- **Refactorización de Capas**: Mejorar la separación entre las capas de control, servicio y persistencia.
- **Mejora de Docker**: Ajustar la configuración de Docker para optimizar la construcción y ejecución de la aplicación.
- **Pruebas Automatizadas**: Ampliar la cobertura de las pruebas automatizadas para garantizar una mayor robustez de la aplicación.

## Otros Proyectos

- 🗳️ [Sistema de Votação](https://github.com/SamuelRocha91/sistemaDeVotacao/blob/main/README_es.md)
- 🏛️ [Localizador de museus](https://github.com/SamuelRocha91/localizadorDeMuseus/blob/main/README_es.md)
- 📃 [Regras de progressão](https://github.com/SamuelRocha91/project_rule_of_progression/blob/main/README_es.md)
