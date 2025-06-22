
# Stage 1 - Build
FROM maven:3.8.5-openjdk-17-slim AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2 - Production Image
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/productcatalogue-1.0.0.jar app.jar
EXPOSE 8080
HEALTHCHECK CMD curl --fail http://localhost:8080/products/health || exit 1
ENTRYPOINT ["java", "-jar", "app.jar"]
