# Use a base image with Java
FROM eclipse-temurin:17-jdk-alpine

#Temporary Volume
VOLUME /tmp

# Copy the built jar file into the image
COPY build/libs/demo-0.0.1-SNAPSHOT.jar app.jar

# Set the entry point to run your application
ENTRYPOINT ["java","-jar","/app.jar"]