FROM openjdk:17
WORKDIR /app
COPY target/artribackend-0.0.1-SNAPSHOT.jar /app/my-application.jar
EXPOSE 8083
CMD ["java", "-jar", "/app/my-application.jar"]