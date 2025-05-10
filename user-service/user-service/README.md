User Service API
A Spring Boot application for managing users with CRUD operations, built as a learning project to master Spring Boot features like controllers, profiles, properties, and API documentation.
Overview

Purpose: Develop a RESTful API for user management, exploring Spring Boot 3.4.5 with Java 23.
Package: com.mini_projects.user_service
Tech Stack:
Spring Boot 3.4.5
Java 23
Maven
MapStruct 1.5.5.Final
Lombok
Springdoc OpenAPI 2.6.0


Features:
CRUD operations for users
Environment-specific profiles (dev, prod)
Property injection with @Value and @ConfigurationProperties
Swagger UI for API testing
Global exception handling



Progress (Days 1–4)
Day 1: Project Setup and Basic Controller

Initialized Spring Boot project with Maven.
Created UserController with GET /api/users/welcome endpoint.
Set up User entity, UserService, and in-memory UserRepository.
Learned @RestController, @RequestMapping, and dependency injection.
Files:
pom.xml
src/main/java/com/mini_projects/user_service/domain/user/controller/UserController.java
src/main/java/com/mini_projects/user_service/domain/user/model/User.java



Day 2: CRUD Operations

Added CRUD endpoints in UserController:
POST /api/users: Create user
GET /api/users/{id}: Get user by ID


Implemented UserService with MapStruct for DTO mapping.
Added UserNotFoundException and basic error handling.
Tested with Postman.
Files:
src/main/java/com/mini_projects/user_service/domain/user/service/UserService.java
src/main/java/com/mini_projects/user_service/domain/user/mapper/UserMapper.java
src/main/java/com/mini_projects/user_service/exception/UserNotFoundException.java



Day 3: Exception Handling and Swagger

Added GlobalExceptionHandler for consistent error responses.
Integrated springdoc-openapi-ui for Swagger UI at /swagger-ui.html.
Configured Swagger with API title, version, and contact info.
Tested endpoints with Swagger and Postman.
Files:
src/main/java/com/mini_projects/user_service/exception/GlobalExceptionHandler.java
src/main/resources/application.properties



Day 4: Profiles and Properties

Set up dev and prod profiles with different logging levels and welcome messages.
Fixed @Profile misuse by moving dev-only logic to DevOnlyService.
Standardized app.welcomeMessage for @Value and @ConfigurationProperties.
Resolved property binding issues for AppConfig and UserService.
Tested profile-specific behavior with Postman and Swagger.
Files:
src/main/resources/application-dev.properties
src/main/resources/application-prod.properties
src/main/java/com/mini_projects/user_service/config/AppConfig.java
src/main/java/com/mini_projects/user_service/domain/user/service/DevOnlyService.java
Day4_Notes.md



Setup Instructions

Prerequisites:

Java 23
Maven 3.8+
Git
Postman or Swagger UI for testing


Clone Repository:
git clone https://github.com/your-username/user-service.git
cd user-service


Build Project:
mvn clean install


Run Application:

Dev Profile:mvn spring-boot:run -Dspring-boot.run.profiles=dev


Prod Profile:mvn spring-boot:run -Dspring-boot.run.profiles=prod




Access API:

Swagger UI: http://localhost:8080/swagger-ui.html
Endpoints:
POST /api/users: Create user
GET /api/users/{id}: Get user
GET /api/users/welcome: Welcome message (profile-specific)
GET /api/users/dev-message: Dev-only endpoint (404 in prod)




Test with Postman:

Import collection from postman_collection.json (if created).
Test CRUD and profile-specific endpoints.



Project Structure
user-service/
├── src/
│   ├── main/
│   │   ├── java/com/mini_projects/user_service/
│   │   │   ├── config/
│   │   │   │   └── AppConfig.java
│   │   │   ├── domain/user/
│   │   │   │   ├── controller/
│   │   │   │   │   └── UserController.java
│   │   │   │   ├── dto/
│   │   │   │   │   ├── UserDTO.java
│   │   │   │   │   └── UserRequestDTO.java
│   │   │   │   ├── mapper/
│   │   │   │   │   └── UserMapper.java
│   │   │   │   ├── model/
│   │   │   │   │   └── User.java
│   │   │   │   ├── repository/
│   │   │   │   │   └── UserRepository.java
│   │   │   │   ├── service/
│   │   │   │   │   ├── UserService.java
│   │   │   │   │   └── DevOnlyService.java
│   │   │   ├── exception/
│   │   │   │   ├── GlobalExceptionHandler.java
│   │   │   │   ├── UserNotFoundException.java
│   │   │   │   └── ErrorResponse.java
│   │   │   └── UserServiceApplication.java
│   │   ├── resources/
│   │   │   ├── application.properties
│   │   │   ├── application-dev.properties
│   │   │   └── application-prod.properties
├── pom.xml
├── README.md
└── Day4_Notes.md

Next Steps

Integrate H2/PostgreSQL for persistent storage.
Add unit tests for controllers, services, and profiles.
Implement authentication (e.g., Spring Security).
Explore Spring Cloud Config for externalized configuration.

Contact

Author: Ajay Nag Karanam
Email: ajaynagkaranam@gmail.com

Built with ☕ and Spring Boot enthusiasm!