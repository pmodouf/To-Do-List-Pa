# Använd en officiell Java-basbild
FROM openjdk:17-jdk

# Ange arbetsmapp i containern
WORKDIR /app

# Kopiera JAR-filen från den lokala katalogen till containern
COPY demo/build/libs/demo-0.0.1-SNAPSHOT*.jar app/

# Exponera port 8080
EXPOSE 8080

# Kör Java-applikationen
ENTRYPOINT ["java", "-jar", "app.jar"]
