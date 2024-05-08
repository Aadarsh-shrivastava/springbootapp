# Use the official Maven image to create a build artifact.
FROM maven:3.9.6-sapmachine-17 AS build

# Set the working directory in the container
WORKDIR /app

# Copy the source code
COPY . .

# Package the application
RUN mvn clean package

# Use the AdoptOpenJDK base image for runtime
FROM adoptopenjdk/openjdk17:alpine-jre

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/devops-integration.jar devops-integration.jar

# Expose port 8080
EXPOSE 8080

# Set the entrypoint for the container
ENTRYPOINT ["java", "-jar", "devops-integration.jar"]
