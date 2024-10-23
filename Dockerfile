# Use an official Java runtime as a parent image
FROM openjdk:17-jdk-slim
VOLUME /tmp
COPY target/cloud-usage-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]