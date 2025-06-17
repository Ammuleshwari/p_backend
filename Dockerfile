# Use a Java runtime as the base image
FROM eclipse-temurin:21-jdk

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven wrapper and pom.xml files
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# Give execute permission to mvnw
RUN chmod +x mvnw

# Download dependencies
RUN ./mvnw dependency:go-offline

# Copy the rest of the project files
COPY . .

# Package the application
RUN ./mvnw package -DskipTests

# Run the Spring Boot application
CMD ["java", "-jar", "target/contactservice-0.0.1-SNAPSHOT.jar"]
