# tsg8assessment

RestFul Api With Spring Boot Web + Swagger integration.

Prerequisites

Before you begin, ensure you have the following prerequisites installed on your system:

Java Development Kit (JDK) 17 or later
Maven
PostgreSQL (optional, for running with PostgreSQL database)
Getting Started

To get started with the project, follow these steps:

Clone the Repository:

You can type the following commands into your terminal inside of a new project:

git clone https://github.com/davidgazaryan/tsg8assessment.git cd tsg8assessment

Locate pom.xml file in intellij or choice of ide:

Right-click on the pom.xml file and select "Maven" from the context menu.

In the submenu, select "Reload Project" to reload the Maven project.

Once the project is reloaded, IntelliJ will automatically download the required dependencies specified in the pom.xml file.

Setup your postgres db in application.properties file which is inside resources directory: spring.datasource.url=jdbc:postgresql://localhost:5432/your_database spring.datasource.username=your_username spring.datasource.password=your_password spring.jpa.hibernate.ddl-auto = update spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect

Locate main file to run: This is annotated by @SpringBootApplication and should be in the src folder. Run the project from there. You can then access the swagger ui by visiting http://localhost:8080/swagger-ui/index.html.