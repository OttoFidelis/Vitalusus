FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get update && apt-get install -y openjdk-17-jdk maven && rm -rf /var/lib/apt/lists/*

COPY . .

RUN mvn clean install

FROM openjdk:17-jdk-slim

EXPOSE 8080

COPY --from=build target/vitalusus-0.0.1-SNAPSHOT.jar vitalusus.jar

ENTRYPOINT ["java", "-jar", "vitalusus.jar"]