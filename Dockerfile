# Use a Java runtime base image
#THIS PART WILL BASICALLY COMPILE THE CODE
FROM maven:3.8.5-openjdk-17 AS build
#WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests


#THIS PART WILL RUN THE APPLICATION
FROM openjdk:17.0.1-jdk-slim
COPY --from=build /targert/muscleplay-0.0.1-SNAPSHOT.jar demo.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "muscleplay.jar"]

