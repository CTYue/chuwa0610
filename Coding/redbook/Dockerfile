# Use a base image (e.g., OpenJDK for a Java project)
FROM openjdk:17-jdk-alpine

# Set the working directory
WORKDIR /app

# Copy the project files to the container
COPY . /app/

# Compile the project (if applicable)
RUN target/redbook-0.0.1-SNAPSHOT.jar /app/redbook-0.0.1-SNAPSHOT.jar

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run the application
# For a jar file, use the following line to run the jar file
ENTRYPOINT ["java", "-jar", "redbook-0.0.1-SNAPSHOT.jar"]
