FROM openjdk:8-jdk-alpine

WORKDIR /app

ADD target/service_wechat-0.0.1-SNAPSHOT.jar .

EXPOSE 8305

ENTRYPOINT ["java", "-jar","/app/service_wechat-0.0.1-SNAPSHOT.jar"]