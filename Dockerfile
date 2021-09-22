FROM scratch
EXPOSE 8080
ADD build/libs/web.jar bezkoder-app/web.jar
ENTRYPOINT ["java","-jar","/bezkoder-app/web.jar"]
