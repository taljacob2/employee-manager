FROM scratch
EXPOSE 8080
ADD build/libs/web.jar app-dir/web.jar
ENTRYPOINT ["java","-jar","/app-dir/web.jar"]