FROM openjdk:21-jdk-bullseye

WORKDIR /app

COPY . .

RUN ./gradlew build --no-daemon

EXPOSE 8080

CMD ["java", "-jar", "build/libs/crud-0.0.1-SNAPSHOT.jar"]