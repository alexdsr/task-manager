# Task Manager API

## Overview
This lightweight Task Manager provides RESTful APIs to create, update, list, and delete tasks with a minimal backend architecture.

## Persistence Layer
Using **H2 in-memory database** for simplicity and fast prototyping. Suitable for internal tools and testing without requiring external DB setup.

## Endpoints
- POST /tasks
- GET /tasks
- PUT /tasks/{id}
- DELETE /tasks/{id}

## Technologies
- Java 17
- Spring Boot
- H2 Database
- Maven