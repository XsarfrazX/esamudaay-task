FROM openjdk:8-jdk-alpine
MAINTAINER Sarfraz
COPY target/task-0.0.1.jar task-0.0.1.jar
RUN ls
ENTRYPOINT ["java","-jar","/task-0.0.1.jar"]