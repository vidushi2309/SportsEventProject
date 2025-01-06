# Sports Event Management and Performance Monitoring Platform

This project is a web-based platform designed to manage sports events and monitor athlete performance. Built with **Spring Boot** for the backend and **HTML, CSS, JavaScript** for the frontend, the application provides user role-based access (athletes, coaches, admins) and allows CRUD operations through a **MySQL database**.

---

## Features
- **Role-based authentication**: Secure login and registration with Spring Security.
- **Athlete Dashboard**: Displays registered events.
- **Coach Dashboard**: Manage athlete selections and monitor progress.
- **Admin Panel**: Create, update, and delete events, and manage user roles.
- **Event Registration**: Allows athletes to register for sports events.
- **Performance Monitoring**: Track and analyze athlete performance.
---

## Technology Stack
- **Backend**: Spring Boot
- **Frontend**: HTML, CSS, JavaScript
- **Database**: MySQL
- **Authentication**: JWT (JSON Web Tokens)


---

## Setup Guide

### 1. Clone the Repository
```bash
git clone https://github.com/vidushi2309/SportsEventProject/tree/project
cd SportsEventProject
```

### 2. Configure Database
- Database is already created with the name "auth" when AuthenticationApplication.java is run:
- Update `application.properties` in the backend to match your database configuration:
```properties
spring.datasource.username=yourusername
spring.datasource.password=yourpassword
```
### 3. Frontend is stored in "src\main\resources\static"

