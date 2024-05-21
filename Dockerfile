FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/docker-0.0.1.jar
COPY ${JAR_FILE} app_docker_proyecto.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app_docker_proyecto.jar"]
