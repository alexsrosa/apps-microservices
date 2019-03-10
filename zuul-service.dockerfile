# SEM BUILD
#FROM openjdk:10
#ENV APP_HOME=/usr/app/
#WORKDIR $APP_HOME
#COPY ./zuul-service/build/libs/*.jar ./app.jar
#EXPOSE 9090
#CMD ["java","-jar","app.jar"]

# COM BUILD
FROM openjdk:10
ENV APP_HOME=/usr/zuul-service
WORKDIR $APP_HOME
COPY ./zuul-service $APP_HOME
RUN ./gradlew clean assemble build -x test
EXPOSE 9090
CMD ["java","-jar","build/libs/*.jar"]