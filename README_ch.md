# <img src="https://blog.geekhunter.com.br/wp-content/uploads/2020/07/pngwing.com_.png" alt="Java Projects Logo" width="52" height="40" /> 🌱 Agrix - 农场管理与监控 <img src="https://blog.geekhunter.com.br/wp-content/uploads/2020/07/pngwing.com_.png" alt="Java Projects Logo" width="52" height="40" /> 

![状态: 开发中](https://img.shields.io/badge/status-in%20development-yellow)

## 🌐 [![Português](https://img.shields.io/badge/Português-green)](https://github.com/SamuelRocha91/Agrix/blob/main/README.md) [![Español](https://img.shields.io/badge/Español-yellow)](https://github.com/SamuelRocha91/Agrix/blob/main/README_es.md) [![English](https://img.shields.io/badge/English-blue)](https://github.com/SamuelRocha91/Agrix/blob/main/README_en.md) [![Русский](https://img.shields.io/badge/Русский-lightgrey)](https://github.com/SamuelRocha91/Agrix/blob/main/README_ru.md) [![中文](https://img.shields.io/badge/中文-red)](https://github.com/SamuelRocha91/Agrix/Agrix/blob/main/README_ch.md)) [![العربية](https://img.shields.io/badge/العربية-orange)](https://github.com/SamuelRocha91/Agrix/blob/main/README_ar.md)


## 📜 介绍

Agrix 项目是 Trybe 的 Web 开发课程中的一个评估项目。该项目涉及使用 Java、Maven、Docker、MySQL 和几乎整个 Spring 生态系统。应用程序的构建完全自由，包括从代码处理到配置的各个方面。

该应用程序的目标是管理和监控参与的农场，帮助他们提高技术水平，并负责任地使用土地。系统包括用于身份验证、授权、农场注册、种植、肥料管理等的路由。

## 📈 数据库图

![数据库图](./images/diagrama.png)

## 🛤️ 路由

![路由图](./images/routeOne.png)  
![路由图](./images/routesTwo.png)

## 🛠️ 实现的功能

- **身份验证和授权**：使用 Spring Security 实现安全性，以管理对应用程序路由的访问。
- **实体注册**：用于注册农场、种植和肥料的路由。
- **库存和种植管理**：管理农场中肥料库存和种植的功能。
- **REST API**：开发 REST API 以与系统进行交互。
- **错误处理**：使用 Spring Web 实现错误管理。
- **Docker**：创建 Dockerfile 以配置应用程序在 Docker 中运行。

## 📚 开发的技能

在这个项目的开发过程中，练习了以下技能：

- **Spring Framework**：使用 Spring 构建应用程序并实现安全功能。
- **Spring Security**：应用知识添加身份验证和授权。
- **Java Web**：使用 Java 开发 Web 应用程序。
- **REST API**：创建 API 路由并使用 Spring 实现。
- **Spring Data JPA**：用于数据持久化。
- **Docker**：配置应用程序以在 Docker 容器中运行。
- **JUnit**：使用 JUnit 框架进行测试。

## 📋 要求

- **Java 17**
- **Maven 3.8.1 或更高版本**
- **Docker**（可选，用于容器运行）

## 🔧 安装和运行

请按照以下步骤在本地配置和运行项目：

### 1. 克隆仓库

```bash
git clone git@github.com:SamuelRocha91/Agrix.git
```

### 2. 进入项目目录

```bash
cd agrix
```

### 3. 编译和运行应用程序

要在本地编译和运行应用程序，请使用 Maven：

```bash
mvn spring-boot:run
```

### 4. 运行测试

要运行自动化测试，请使用以下命令：

```bash
mvn test
```

### 5. Docker 配置

要使用 Docker 构建和运行应用程序，请按照以下步骤操作：

1. 构建 Docker 镜像：

   ```bash
   docker build -t agrix .
   ```

2. 运行 Docker 容器：

   ```bash
   docker run -p 8080:8080 agrix
   ```

## 🗂️ 文件结构

项目结构如下：

```
.
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── betrybe/
│   │   │           └── agrix/
│   │   │               ├── controller/        # API 控制器
│   │   │               ├── model/             # 数据模型
│   │   │               ├── repository/        # JPA 仓储
│   │   │               ├── service/           # 应用服务
│   │   │               └── AgrixApplication.java  # 主类
│   ├── test/
│   │   └── java/
│   │       └── com/
│   │           └── betrybe/
│   │               └── agrix/
│   │                   ├── controller/        # 控制器测试
│   │                   ├── service/           # 服务测试
│   │                   └── repository/        # 仓储测试
├── Dockerfile                # 配置应用程序的 Dockerfile
├── pom.xml                   # Maven 配置文件
└── README.md                 # 项目文档
```

## 📦 依赖项

项目的主要依赖项包括：

- [Spring Boot](https://spring.io/projects/spring-boot): Java 应用程序开发框架。
- [Spring Security](https://spring.io/projects/spring-security): 安全和身份验证框架。
- [Java JWT](https://github.com/auth0/java-jwt): 用于处理 JWT 的库。
- [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/): MySQL 的 JDBC 连接器。
- [JUnit](https://junit.org/junit5/): 单元测试框架。

## 🚀 未来改进

该项目正在开发中，计划实施以下改进：

- **层次重构**：改进控制层、服务层和持久层之间的分离。
- **Docker 改进**：调整 Docker 配置以优化构建和运行应用程序。
- **自动化测试**：扩展自动化测试覆盖面，以确保应用程序的可靠性。

## 其他项目

- 🗳️ [Sistema de Votação](https://github.com/SamuelRocha91/sistemaDeVotacao/Agrix/Agrix/blob/main/README_ch.md)
- 🏛️ [Localizador de museus](https://github.com/SamuelRocha91/localizadorDeMuseus/Agrix/Agrix/blob/main/README_ch.md)
- 📃 [Regras de progressão](https://github.com/SamuelRocha91/project_rule_of_progression/Agrix/Agrix/blob/main/README_ch.md)
