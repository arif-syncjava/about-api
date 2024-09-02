FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY build/libs/spring-boot.jar /app/spring-boot.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/spring-boot.jar"]