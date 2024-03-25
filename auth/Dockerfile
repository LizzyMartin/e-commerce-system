FROM amazoncorretto:21-alpine-jdk

ENV ARTIFACT_NAME=auth-0.0.1-SNAPSHOT.jar
ENV APP_HOME=/usr/app/

WORKDIR $APP_HOME

COPY ./build/libs/${ARTIFACT_NAME} .

EXPOSE 8080
CMD java -jar $ARTIFACT_NAME
