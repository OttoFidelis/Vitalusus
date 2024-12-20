FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
COPY . .
RUN rm -rf /target

RUN apt-get install maven -y
RUN mvn clean install

FROM openjdk:17-jdk-slim

EXPOSE 8080

COPY --from=build /target/vitalusus-0.0.1-SNAPSHOT.jar vitalusus.jar

ENTRYPOINT ["java", "-jar", "vitalusus.jar"]