# ----- `FROM` (this section MUST be first) -----
FROM scratch
# ----- `FROM` (this section MUST be first) -----


# ----- Variables -----
# Port
ENV SPRING_DOCKER_PORT=8070
# Name
ARG APP_NAME=web.jar
ARG APP_PATH=app-dir/$APP_NAME
# ----- Variables -----


# ----- Build -----
EXPOSE $SPRING_DOCKER_PORT
ADD build/libs/$APP_NAME $APP_PATH
ENTRYPOINT ["java", "-jar", "app-dir/web.jar"]
# ----- Build -----
