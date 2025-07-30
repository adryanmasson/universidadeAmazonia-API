**Universidade Amazônia API**

> A RESTful API built with Spring Boot for managing university data such as students, professors, courses, and grades.

---

## 🚀 Table of Contents

1. [🌟 Project Overview](#-project-overview)
2. [🛠️ Tech Stack](#️-tech-stack)
3. [📥 Prerequisites](#-prerequisites)
4. [🔧 Installation & Setup](#-installation--setup)
5. [⚙️ Running the Application](#️-running-the-application)
6. [📚 API Endpoints](#-api-endpoints)
7. [🔐 Security](#-security)
8. [💾 Database Configuration](#-database-configuration)
9. [📂 Project Structure](#-project-structure)
10. [📄 License Note](#-license-note)

---

## 🌟 Project Overview

This project was developed as part of a university course. It exposes REST endpoints to:

* Authenticate users (login).
* List subjects for a student by RA (student registration number).
* Retrieve grade details for a given student and subject.
* List students under a specific professor.
* Register grades for students in subjects.

The code follows clean architecture principles with controllers, services, repositories, and models, leveraging Spring Data JPA for persistence.

---

## 🛠️ Tech Stack

* **Language:** Java 17
* **Framework:** Spring Boot 3.4.5
* **Security:** Spring Security (BCrypt password encoding)
* **Persistence:** Spring Data JPA
* **Database:** MySQL (production), H2 (runtime tests)
* **Build:** Maven Wrapper (`./mvnw`)
* **Lombok:** Reduces boilerplate for models

---

## 📥 Prerequisites

* Java Development Kit (JDK) 17+
* Maven (or use the provided Maven Wrapper)
* MySQL server (or adjust to your database of choice)

---

## 🔧 Installation & Setup

1. **Clone the repository**

   ```bash
   git clone https://github.com/adryanmasson/universidadeAmazonia-api.git
   cd universidadeAmazonia-api
   ```

2. **Configure the database connection** Edit `src/main/resources/application.properties`:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/universidade
   spring.datasource.username=root
   spring.datasource.password=
   spring.jpa.hibernate.ddl-auto=none
   spring.jpa.show-sql=true
   ```

3. **Build the project**

   ```bash
   ./mvnw clean package
   ```

4. **Initialize the database**

   * Ensure `universidade.sql` is located at the project root.
   * **macOS/Linux (bash):**

     ```bash
     mysql -u <username> -p universidade < universidade.sql
     ```
   * **Windows PowerShell:**

     ```powershell
     mysql -u <username> -p universidade -e "source .\universidade.sql"
     ```

---

## ⚙️ Running the Application

* **Using Maven Wrapper:**

  ```bash
  ./mvnw spring-boot:run
  ```

* **Or run the JAR** in `target/`:

  ```bash
  java -jar target/universidadeAmazonia-0.0.1-SNAPSHOT.jar
  ```

The API will be available at [**http://localhost:8080**](http://localhost:8080).

---

## 📚 API Endpoints

### 1. Authentication

* **POST** `/api/login`

  **Request Body:**

  ```json
  {
  "identificador": "RP141516",
  "senha": "senha123"
  }
  ```

  **Response:** JWT token or error message.

### 2. Students

* **GET** `/api/alunos/{ra}/materias`

  List subjects for the student with RA `{ra}`.

* **GET** `/api/alunos/{ra}/materias/{idMateria}/notas`

  Get grade details for student `{ra}` in subject `{idMateria}`.

### 3. Professors

* **GET** `/api/professores/{id}/alunos`

  List students advised by professor with ID `{id}`.

### 4. Grades

* **POST** `/api/notas`

  **Request Body:**

  ```json
  {
    "idAluno": 1,
    "idMateria": 2,
    "np1": 8.5,
    "np2": 7.0,
    "rep": 0.0,
    "exame": 0.0
  }
  ```

  Register or update grades for a student.

---

## 🔐 Security

* Passwords are hashed with BCrypt via Spring Security.
* All endpoints are public by default; update `SecurityConfig.java` to enforce authentication and roles.

---

## 💾 Database Configuration

* Default MySQL settings are in `application.properties`.
* For in-memory testing with H2, add the H2 dependency in `pom.xml` and configure:

  ```properties
  spring.datasource.url=jdbc:h2:mem:testdb
  spring.datasource.driverClassName=org.h2.Driver
  spring.datasource.username=sa
  spring.datasource.password=
  spring.jpa.hibernate.ddl-auto=create-drop
  ```

---

## 📂 Project Structure

```text
universidadeAmazonia-api/
├── src/
│   └── main/
│       ├── java/com/example/universidadeAmazonia/
│       │   ├── controllers/                     # REST controllers
│       │   ├── models/                          # JPA entities
│       │   ├── repositories/                    # Spring Data repositories
│       │   ├── services/                        # Business logic
│       │   ├── SecurityConfig.java              # Spring Security setup
│       │   └── UniversidadeAmazoniaApplication.java  # Main class
│       └── resources/
│           └── application.properties
├── mvnw                                        # Maven Wrapper
├── pom.xml
├── universidade.sql                       # SQL script for schema and seed data (project root)
└── README.md
```

---

## 📄 License Note

This project currently has **no open-source license**. All rights reserved by the authors. For reuse or collaboration, please contact the contributors.
