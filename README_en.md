# 🌱 Agrix - Farm Management and Monitoring

![Status: In Development](https://img.shields.io/badge/status-in%20development-yellow)

<h2>🌐</h2>
<ul>
  <li><a href="https://github.com/SamuelRocha91/Agrix" target="_blank">Português</a></li>
  <li><a href="https://github.com/SamuelRocha91/Agrix/blob/main/README_es.md" target="_blank">Español</a></li>
  <li><a href="https://github.com/SamuelRocha91/Agrix/blob/main/README_en.md" target="_blank">English</a></li>
  <li><a href="https://github.com/SamuelRocha91/Agrix/blob/main/README_ru.md" target="_blank">Русский</a></li>
  <li><a href="https://github.com/SamuelRocha91/Agrix/blob/main/README_ch.md" target="_blank">中文</a></li>
  <li><a href="https://github.com/SamuelRocha91/Agrix/blob/main/README_ar.md" target="_blank">العربية</a></li>
</ul>

## 📜 Introduction

The Agrix project is an evaluative project developed in the Java module of the Trybe Web Development course. The project involved the use of Java, Maven, Docker, MySQL, and almost the entire Spring ecosystem. The application was built with full implementation freedom, covering everything from code manipulation to configuration.

The application aims to manage and monitor participating farms that seek to improve their technologies and use the land responsibly. The system includes routes for authentication, authorization, farm registration, crop management, fertilizers, and more.

## 🛠️ Implemented Features

- **Authentication and Authorization**: Security implementation using Spring Security to manage access to the application's routes.
- **Entity Registration**: Routes for registering farms, crops, and fertilizers.
- **Inventory and Crop Management**: Features to manage the inventory of fertilizers and crops on the farms.
- **REST API**: Development of a REST API for system interaction.
- **Error Handling**: Implementation of error handling using Spring Web.
- **Docker**: Creation of a Dockerfile to configure the application for Docker execution.

## 📚 Skills Developed

During the development of this project, the following skills were worked on:

- **Spring Framework**: Using Spring to build the application and implement security.
- **Spring Security**: Applying knowledge to add authentication and authorization.
- **Java Web**: Developing a web application using Java.
- **REST API**: Creating API routes and implementation using Spring.
- **Spring Data JPA**: Using it for data persistence in the database.
- **Docker**: Configuring the application to run in Docker containers.
- **JUnit**: Implementing tests with the JUnit framework.

## 📋 Requirements

- **Java 17**
- **Maven 3.8.1 or higher**
- **Docker** (optional, for container execution)

## 🔧 Installation and Running

Follow the instructions below to set up and run the project locally:

### 1. Clone the repository

```bash
git clone git@github.com:SamuelRocha91/Agrix.git
```

### 2. Navigate to the project directory

```bash
cd agrix
```

### 3. Compile and run the application

To compile and run the application locally, use Maven:

```bash
mvn spring-boot:run
```

### 4. Run the tests

To run automated tests, use the command:

```bash
mvn test
```

### 5. Docker Setup

To build and run the application using Docker, follow the instructions below:

1. Build the Docker image:

   ```bash
   docker build -t agrix .
   ```

2. Run the Docker container:

   ```bash
   docker run -p 8080:8080 agrix
   ```

## 🗂️ File Structure

The project structure is organized as follows:

```
.
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── betrybe/
│   │   │           └── agrix/
│   │   │               ├── controller/        # API controllers
│   │   │               ├── model/             # Data models
│   │   │               ├── repository/        # JPA repositories
│   │   │               ├── service/           # Application services
│   │   │               └── AgrixApplication.java  # Main class
│   ├── test/
│   │   └── java/
│   │       └── com/
│   │           └── betrybe/
│   │               └── agrix/
│   │                   ├── controller/        # Controller tests
│   │                   ├── service/           # Service tests
│   │                   └── repository/        # Repository tests
├── Dockerfile                # Dockerfile for application configuration
├── pom.xml                   # Maven configuration file
└── README.md                 # Project documentation
```

## 📦 Dependencies

The main dependencies of the project are:

- [Spring Boot](https://spring.io/projects/spring-boot): Framework for developing Java applications.
- [Spring Security](https://spring.io/projects/spring-security): Framework for security and authentication.
- [Java JWT](https://github.com/auth0/java-jwt): Library for JWT manipulation.
- [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/): JDBC connector for MySQL.
- [JUnit](https://junit.org/junit5/): Framework for unit testing.

## 🚀 Future Improvements

The project is under development, and the following improvements are planned:

- **Layer Refactoring**: Improve the separation between control, service, and persistence layers.
- **Docker Enhancements**: Adjust Docker configuration to optimize the build and execution of the application.
- **Automated Testing**: Expand automated test coverage to ensure greater robustness of the application.
