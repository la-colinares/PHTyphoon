FROM openjdk:21-jdk-slim AS build
WORKDIR /app
COPY server/build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]