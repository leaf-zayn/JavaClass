FROM openjdk:8-jdk-alpine

WORKDIR /app

ADD target/service_vod-0.0.1-SNAPSHOT.jar .

EXPOSE 8301

ENTRYPOINT ["java", "-jar","/app/service_vod-0.0.1-SNAPSHOT.jar"]