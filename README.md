<!-- ==================================================================================================== -->
<!-- =========================================== Description ============================================ -->

# **🧑🏻‍💻 Help Desk System 🧑🏻‍💻**

This project is a comprehensive, district-wide help desk application designed to revolutionize how educational institutions manage technical support requests. Built specifically for school districts, this system enables teachers, administrative staff, and faculty to submit, track, and manage technical support tickets through an intuitive, user-friendly interface.

The application addresses critical challenges in educational IT support, including slow response times, inefficient ticket routing, and lack of transparency in support request status.

By centralizing all technical support needs into a single platform, the system significantly improves operational efficiency and ensures that critical technical issues are resolved promptly, minimizing disruptions to the educational process.

<!-- ==================================================================================================== -->
<!-- ======================================= System Architecture ======================================== -->

## **System Architecture**

#### **1. Backend & Core Framework**

- **Java 21:** Primary programming language for robust enterprise application development

- **Spring Boot 3.5.6:** Comprehensive framework for enterprise-grade application development

    - **Spring Web MVC:** RESTful API endpoints

    - **Spring Data MongoDB:** Database integration

    - **Spring Validation:** Data integrity

    - **Spring Boot DevTools:** Enhanced development experience

#### **2. Database & Persistence**

- **MongoDB Atlas:** Cloud-based NoSQL database for flexible, scalable data storage

    - Document-based storage for complex ticket and user data

    - Automatic scaling and high availability

    - Geographic distribution for performance

#### **3. Frontend & User Interface**

- **JavaFX:** Desktop client application for administrative users and IT staff

    - **Gluon SceneBuilder:** Intuitive GUI design and layout
    
    - Native desktop experience with modern UI components

- **HTML5, CSS3, JavaScript:** Web interface for teacher and staff access

    - Responsive design for cross-device compatibility

    - Modern web standards for optimal user experience

#### **4. Development & Deployment**

- **Maven:** Comprehensive build automation and dependency management

- **Spring Boot DevTools:** Hot reload and development-time features

- **RESTful APIs:** Clean, standardized interfaces for future mobile applications

## **Installation**

- Navigate to the [Documentation](helpdesk/docs/installation/README.md)

<!-- ==================================================================================================== -->
<!-- ========================================== Project Setup =========================================== -->

## **Project Setup**

#### **1. Clone Repository**

```bash
# Clone
git clone https://github.com/khangdoan514/district-help-desk

# Change working directory
cd helpdesk
```

#### **2. Environment Setup**

1. Ensure [Java Development Kit (JDK) 23](https://www.oracle.com/java/technologies/downloads/) (or higher) is installed

2. Verify [Apache Maven 3.9+](https://maven.apache.org) is available

3. Download [SceneBuilder](https://gluonhq.com/products/scene-builder/)

4. Obtain MongoDB Atlas connection credentials

#### **3. Database Configuration**

- Create `src/main/resources/application.properties` and add the following lines:

```properties
spring.data.mongodb.uri="<your_mongodb_connection_string>"
logging.level.org.mongodb.driver=WARN
logging.level.org.springframework.data.mongodb=INFO
```

#### **4. Build and Run**

```bash
# Clean and compile the project
mvn clean compile

# Run the Spring Boot application
mvn spring-boot:run
```

#### **5. Verify Installation**

- Access the following endpoints to verify system status:

    - **Health Check:** `http://localhost:8080/health`

    - **Web Interface:** `http://localhost:8080`

<!-- ==================================================================================================== -->
<!-- ======================================== Project Structure ========================================= -->

## **Project Structure**

```bash
district-help-desk
├── CODE_OF_CONDUCT.md
├── LICENSE
├── README.md
└── helpdesk/                                               # Main working directory
    ├── HELP.md
    ├── pom.xml                                             # Manages dependencies & builds configurations
    ├── docs/                                               # Root documentation directory
    │   ├── api/
    │   ├── database/
    │   └── installation/
    │
    ├── src/
    │   ├── main/
    │   │   ├── java/
    │   │   │   └── dev/
    │   │   │       └── khang/
    │   │   │           └── helpdesk/
    │   │   │               ├── Application.java            # Spring Boot entry point
    │   │   │               ├── controller/                 # Handles HTTP requests (@Controller, @RestController)
    │   │   │               ├── model/                      # Defines data entities (@Entity)
    │   │   │               ├── repository/                 # Handles data access (@Repository)
    │   │   │               └── services/                   # Manages business logic (@Service)
    │   │   │
    │   │   └── resources/
    │   │       ├── application.properties                  # Spring Boot configurations
    │   │       ├── static/
    │   │       │   ├── css/
    │   │       │   ├── img/
    │   │       │   └── js/
    │   │       │
    │   │       └── templates/
    │   │           ├── fragments/                          # Thymeleaf
    │   │           └── index.html                          # Main html homepage
    │   │
    │   └── test/                                           # Unit & integration tests
    │
    └── target/                                             # Auto-generated build output
```