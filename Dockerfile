# Använd en officiell Java-basbild
FROM openjdk:17-jdk

# Ange arbetsmapp i containern
WORKDIR /app

# Kopiera .jar-filen från din byggmapp till containern
COPY target/min-app-0.0.1-SNAPSHOT.jar app.jar

# Exponera port 8080
EXPOSE 8080

# Kör Java-applikationen
ENTRYPOINT ["java", "-jar", "app.jar"]
