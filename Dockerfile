FROM openjdk:21-jdk-bullseye
VOLUME /tmp
COPY build/libs/crud-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]