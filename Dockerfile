# ----- `FROM` (this section MUST be first) -----
FROM openjdk:8-jre-alpine
# ----- `FROM` (this section MUST be first) -----


# ----- Variables -----
# Port (MUST be the same as `SPRING_DOCKER_PORT` in `.env` file)
ENV SPRING_DOCKER_PORT=8070
# Name
ARG APP_NAME=web.jar
ENV APP_PATH=app-dir/$APP_NAME
# ----- Variables -----


# ----- Build -----
EXPOSE $SPRING_DOCKER_PORT
ADD build/libs/$APP_NAME $APP_PATH
ENTRYPOINT java -jar $APP_PATH
# ----- Build -----