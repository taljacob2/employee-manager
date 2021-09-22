FROM openjdk:8
EXPOSE 8079
ADD build/libs/web.jar app/web.jar
ENTRYPOINT ["java","-jar","/app/web.jar"]