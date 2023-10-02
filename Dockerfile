# Använd en basbild med Java 17
FROM openjdk:17-jdk

# Ange arbetskatalogen inuti containern
WORKDIR /app

# Kopiera JAR-filen från din lokala katalog till containern
COPY demo-0.0.1-SNAPSHOT.jar /app/demo-0.0.1-SNAPSHOT.jar

# Sätt kommandot för att köra din Java-applikation
CMD ["java", "-jar", "demo-0.0.1-SNAPSHOT.jar"]
