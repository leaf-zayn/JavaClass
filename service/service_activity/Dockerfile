FROM openjdk:8-jdk-alpine

WORKDIR /app

ADD target/service_activity-0.0.1-SNAPSHOT.jar .

EXPOSE 8303

ENTRYPOINT ["java", "-jar","/app/service_activity-0.0.1-SNAPSHOT.jar"]