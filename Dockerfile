# Use the official Maven image to create a build artifact.
FROM maven:3.8.3-jdk-11-slim AS build

# Set the working directory.
WORKDIR /usr/src/app

# Copy the project files into the container.
COPY . .

# Package the application.
RUN mvn clean package

# Use the AdoptOpenJDK image for the runtime.
FROM adoptopenjdk/openjdk11:alpine-jre

# Set the working directory.
WORKDIR /usr/src/app

# Copy the packaged JAR file from the build stage.
COPY --from=build /usr/src/app/target/springbootapp-0.0.1-SNAPSHOT.jar /usr/src/app/springbootapp-0.0.1-SNAPSHOT.jar

# Specify the command to run on container start.
ENTRYPOINT ["java","-jar","/usr/src/app/springbootapp-0.0.1-SNAPSHOT.jar"]
