FROM openjdk:8-jdk-alpine

WORKDIR /app

ADD target/service_gateway-0.0.1-SNAPSHOT.jar .

EXPOSE 8333

ENTRYPOINT ["java", "-jar","/app/service_gateway-0.0.1-SNAPSHOT.jar"]