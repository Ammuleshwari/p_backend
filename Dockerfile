FROM eclipse-temurin:21-jdk

WORKDIR /app

# Copy everything first
COPY . .

# Ensure mvnw is executable after it's fully copied
RUN chmod +x mvnw

# Download dependencies
RUN ./mvnw dependency:go-offline

# Package the app
RUN ./mvnw package -DskipTests

# Run the app
CMD ["java", "-jar", "target/contactservice-0.0.1-SNAPSHOT.jar"]
