FROM openjdk:8-jdk-alpine

WORKDIR /app

ADD target/service_user-0.0.1-SNAPSHOT.jar .

EXPOSE 8304

ENTRYPOINT ["java", "-jar","/app/service_user-0.0.1-SNAPSHOT.jar"]