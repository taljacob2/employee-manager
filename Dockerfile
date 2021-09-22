FROM openjdk:8
COPY build/libs/web.jar app/web.jar
CMD ["java","-jar","/app/web.jar"]