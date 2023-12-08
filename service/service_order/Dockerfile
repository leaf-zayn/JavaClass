FROM openjdk:8-jdk-alpine

WORKDIR /app

ADD target/service_order-0.0.1-SNAPSHOT.jar .

EXPOSE 8302

ENTRYPOINT ["java", "-jar","/app/service_order-0.0.1-SNAPSHOT.jar"]