FROM openjdk:17-slim

LABEL authors="esther"

WORKDIR /app

COPY target/xhs-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
