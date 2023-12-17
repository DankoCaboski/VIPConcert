FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

ARG JAR_FILE=target/demo-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run the .jar file when the container launches
CMD ["java", "-jar", "app.jar"]