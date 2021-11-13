FROM openjdk:17
ADD target/docker-document-rest-api.jar docker-document-rest-api.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "docker-document-rest-api.jar"]