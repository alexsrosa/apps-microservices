FROM openjdk:10
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY ./build/libs/*.jar ./app.jar
EXPOSE 9090
CMD ["java","-jar","app.jar"]

# -- Efetuar o build
#FROM gradle:4.2.1-jdk8-alpine
#ENV APP_HOME=/usr/app/
#WORKDIR $APP_HOME
#COPY ./ $APP_HOME/zuul-service
#USER root
#RUN chown -R gradle $APP_HOME
#USER gradle
#CMD CD $APP_HOME/zuul-service
#RUN gradle build --stacktrace
#EXPOSE 9090
#CMD CD $APP_HOME/zuul-service/build/libs/
#COPY * ./app.jar
#CMD ["java","-jar","./build/libs/zuul-service-0.0.2-SNAPSHOT.jar"]