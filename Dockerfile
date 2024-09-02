FROM gradle:7.6.0-jdk17 AS build
WORKDIR /app
COPY . .
RUN gradle build -x test
FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/build/libs/*.jar spring-boot.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/spring-boot.jar"]