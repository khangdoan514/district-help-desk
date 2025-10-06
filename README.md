# **🧑🏻‍💻 Help Desk System 🧑🏻‍💻**

This project is a comprehensive, district-wide help desk application designed to revolutionize how educational institutions manage technical support requests. Built specifically for school districts, this system enables teachers, administrative staff, and faculty to submit, track, and manage technical support tickets through an intuitive, user-friendly interface.

The application addresses critical challenges in educational IT support, including slow response times, inefficient ticket routing, and lack of transparency in support request status.

By centralizing all technical support needs into a single platform, the system significantly improves operational efficiency and ensures that critical technical issues are resolved promptly, minimizing disruptions to the educational process.

## **🛠️ Technology Stack 🛠️**

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

## **🏗️ System Architecture 🏗️**

#### **1. Multi-Tier Architecture**

#### **2. Component Structure**

- Desktop Client: JavaFX application for IT administrators and support staff

- Web Interface: Browser-based access for teachers and general staff

- REST API: Spring Boot backend serving both frontend interfaces

- Cloud Database: MongoDB Atlas providing reliable, scalable data storage

## **🚀 Quick Start 🚀**

#### **1. Clone Repositor**

```bash
git clone https://github.com/khangdoan514/district-help-desk
cd helpdesk
```

#### **2. Environment Setup**

- Ensure Java 21+ is installed

- Verify Maven 3.6+ is available

- Obtain MongoDB Atlas connection credentials

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

    - **Web Interface:** `http://localhost:8080/`