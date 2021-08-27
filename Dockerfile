FROM openjdk:16-jdk-alpine
EXPOSE 8081
ADD target/SpringHL-0.0.1-SNAPSHOT.jar myapp.jar
ENTRYPOINT ["java","-jar","/myapp.jar"]