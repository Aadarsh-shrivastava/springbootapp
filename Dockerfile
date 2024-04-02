
# Use the official Maven image to create a build artifact.
FROM maven:3.8.3-jdk-11-slim AS build

EXPOSE 8080

Add target/devops-integration.jar devops-integration.jar
ENTRYPOINT [ "java", "-jar", "/devops-integration.jar" ]