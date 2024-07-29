FROM maven:3.8.3-openjdk-17 AS build

# Copy the project files
COPY src /home/app/src
COPY pom.xml /home/app

# Run Maven build with verbose logging and save logs
RUN mkdir -p /home/app/maven-logs && \
    mvn -f /home/app/pom.xml clean package -e -X > /home/app/maven-logs/build.log 2>&1 || \
    (mkdir -p /home/app/maven-reports && cp -r /home/app/target/surefire-reports /home/app/maven-reports/ && exit 1)

# Stage to run the application
FROM openjdk:17-jdk-slim
COPY --from=build /home/app/target/spring_rest_docker.jar /home/app/spring_rest_docker.jar
COPY --from=build /home/app/maven-logs /home/app/maven-logs
COPY --from=build /home/app/maven-reports /home/app/maven-reports
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/home/app/spring_rest_docker.jar"]
