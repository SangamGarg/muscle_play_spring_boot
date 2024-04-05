# Use a Maven base image to compile the code
FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

# Use a Java runtime base image to run the application
FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/muscleplay-0.0.1-SNAPSHOT.jar muscleplay.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "muscleplay.jar"]


