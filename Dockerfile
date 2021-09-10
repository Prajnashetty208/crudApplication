FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/crudApplication-0.0.1-SNAPSHOT.jar crud.jar
ENTRYPOINT ["java","-jar","/crud.jar"]