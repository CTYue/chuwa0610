# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY . /app



# If your application is a jar file, use the following line to copy the jar file
COPY target/redbook-0.0.1-SNAPSHOT.jar /app/redbook-0.0.1-SNAPSHOT.jar

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run the application
# For a jar file, use the following line to run the jar file
ENTRYPOINT ["java", "-jar", "redbook-0.0.1-SNAPSHOT.jar"]
