# Use a base image with Java
FROM eclipse-temurin:17-jdk-alpine

ARG DB_URL
ARG DB_USERNAME
ARG DB_PASSWORD

ENV SPRING_DB_URL=${DB_URL}
ENV SPRING_DB_USERNAME=${DB_USERNAME}
ENV SPRING_DB_PASSWORD=${DB_PASSWORD}

#Temporary Volume
VOLUME /tmp

# Copy the built jar file into the image
COPY build/libs/demo-0.0.1-SNAPSHOT.jar app.jar

# Set the entry point to run your application
ENTRYPOINT ["java","-jar","/app.jar"]