# Stage 1: Build com Maven
FROM maven:3.9.6-eclipse-temurin-21-alpine AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Executar JAR com Amazon Corretto
FROM amazoncorretto:21-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar /app/prontuarioms-api.jar
ENTRYPOINT ["java", "-jar", "/app/prontuarioms-api.jar"]
