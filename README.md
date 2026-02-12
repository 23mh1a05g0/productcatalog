📦 Product Catalog REST API

A production-ready Spring Boot 3.x REST API for managing Products and Categories.

This project demonstrates:

Clean layered architecture (Controller → Service → Repository)

Spring Data JPA + Hibernate

Entity relationships (Many-to-One)

DTO pattern

Validation

Pagination

Global exception handling

PostgreSQL with Docker

Multi-stage Docker build

docker-compose setup

🚀 Tech Stack
Technology	Version
Java	17
Spring Boot	3.x
Spring Data JPA	Latest
Hibernate	6.x
PostgreSQL	15
Docker	Latest
Maven	3.9+
📁 Project Structure
productcatalog/
│
├── src/main/java/com/example/productcatalog
│   ├── controller
│   ├── service
│   ├── repository
│   ├── model
│   ├── dto
│   ├── exception
│   └── ProductcatalogApplication.java
│
├── src/main/resources
│   └── application.properties
│
├── Dockerfile
├── docker-compose.yml
└── pom.xml

🧠 Architecture Overview
Client
   ↓
Controller (REST Endpoints)
   ↓
Service (Business Logic)
   ↓
Repository (JPA)
   ↓
PostgreSQL Database

🗂 Database Schema
Category Table
Column	Type
id	BIGINT
name	VARCHAR
Product Table
Column	Type
id	BIGINT
name	VARCHAR
description	TEXT
price	DECIMAL
category_id	BIGINT (FK)

Relationship:

Product → ManyToOne → Category

🌐 API Endpoints

Base URL:

http://localhost:8080

📂 Category APIs
➤ Create Category
POST /api/categories

Request Body
{
  "name": "Electronics"
}

➤ Get All Categories
GET /api/categories

➤ Get Category By ID
GET /api/categories/{id}

➤ Update Category
PUT /api/categories/{id}

➤ Delete Category
DELETE /api/categories/{id}

📦 Product APIs
➤ Create Product
POST /api/products

Request Body
{
  "name": "iPhone 15",
  "description": "Latest Apple phone",
  "price": 999.99,
  "categoryId": 1
}

➤ Get All Products (Paginated)
GET /api/products?page=0&size=10

➤ Get Product By ID
GET /api/products/{id}

➤ Update Product
PUT /api/products/{id}

➤ Delete Product
DELETE /api/products/{id}

🔍 Pagination Example
GET /api/products?page=0&size=5

🛡 Validation

@NotBlank

@NotNull

@Positive

Global Exception Handler

Example Error Response:

{
  "timestamp": "2026-02-12T18:00:00",
  "status": 400,
  "error": "Validation Error",
  "message": "Price must be positive"
}

🐳 Running with Docker
1️⃣ Build & Run
docker-compose up --build

2️⃣ Stop Containers
docker-compose down

🐘 PostgreSQL Configuration

docker-compose automatically starts:

PostgreSQL container

Spring Boot application container

Environment variables used:

SPRING_DATASOURCE_URL
SPRING_DATASOURCE_USERNAME
SPRING_DATASOURCE_PASSWORD

🔥 Multi-Stage Docker Build

The Dockerfile:

Uses eclipse-temurin base image

Builds app using Maven

Creates lightweight runtime image

Copies generated JAR

🧪 Testing

Run locally:

mvn test


Includes:

Service layer tests

Integration tests

⚙ Local Development (Without Docker)

Run:

mvn spring-boot:run


Access:

http://localhost:8080

🧠 Advanced Hibernate Optimization Used

✔ EntityGraph for pagination
✔ Proper transactional boundaries
✔ Avoided FetchType.EAGER
✔ Avoided Open Session in View

🎯 Learning Outcomes

Real-world Spring Boot backend development

Proper layered architecture

Handling LazyInitializationException correctly

Pagination with JPA

Dockerizing Spring Boot apps

Connecting to PostgreSQL container

📌 Future Improvements

Swagger / OpenAPI documentation

Authentication (JWT)

Caching (Redis)

Sorting support

Filtering APIs

CI/CD integration

👨‍💻 Author

Kalesha Vali Dokuparthi.

🚀 Project Status

✅ Fully Working
✅ Dockerized
✅ Pagination Working
✅ PostgreSQL Integrated
✅ Production Ready