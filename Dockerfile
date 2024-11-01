FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
COPY . .

RUN apt-get install maven -y
RUN mvn clean install

FROM openjdk:23-jdk

EXPOSE 8080

COPY --from=build /target/vitalsus-0.0.1-SNAPSHOT.jar vitalusus.jar

ENTRYPOINT ["java", "-jar", "vitalusus.jar"]