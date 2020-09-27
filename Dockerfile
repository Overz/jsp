#FROM java:8
#FROM maven:alpine
#
## image layer
#WORKDIR /app
#ADD pom.xml /app
#RUN mvn verify clean --fail-never
#
## Image layer: with the application
#COPY . /app
#RUN flyway:clean clean flyway:migrate install -DskipTests=false
#EXPOSE 8080
#ADD ./target/jsp-1.0-SNAPSHOT.war /app
#ENTRYPOINT ["java","-jar","/app/jsp-1.0-SNAPSHOT.war"]