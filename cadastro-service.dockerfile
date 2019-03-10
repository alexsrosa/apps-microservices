# SEM BUILD
#FROM openjdk:10
#ENV APP_HOME=/usr/app/
#WORKDIR $APP_HOME
#COPY ./cadastro-service/build/libs/*.jar ./app.jar
#EXPOSE 8080
#CMD ["java","-jar","app.jar"]

# COM BUILD
FROM openjdk:10
ENV APP_HOME=/usr/cadastro-service
WORKDIR $APP_HOME
COPY ./cadastro-service $APP_HOME
RUN ./gradlew clean assemble build -x test
EXPOSE 8080
CMD ["java","-jar","build/libs/*.jar"]