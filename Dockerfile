FROM openjdk:18-slim
EXPOSE 8080
ADD build/libs/web.jar app/web.jar
ENTRYPOINT ["java", "-jar", "/app/web.jar"]