FROM adoptopenjdk/openjdk11:alpine-jre
MAINTAINER baeldung.com
COPY target/client-service-0.0.1-SNAPSHOT.jar service.jar
ENTRYPOINT ["java", "-war", "/service.jar"]