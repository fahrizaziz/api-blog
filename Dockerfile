FROM openjdk:22-jdk-slim AS jdk

ARG JAR_FILE=target/Api-Blog-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} /

RUN ln -sfn /usr/share/zoneinfo/Asia/Jakarta /etc/localtime
RUN echo "Asia/Bangkok" > /etc/timezone

EXPOSE 9012