# Använd en basbild med Java 17
FROM openjdk:17-jdk

# Ange arbetskatalogen inuti containern
WORKDIR /app

# Kopiera hela demo-mappen till containern
COPY demo /app/demo

# Sätt kommandot för att köra din Java-applikation
CMD ["java", "-jar", "/app/demo/build/libs/demo-0.0.1-SNAPSHOT.jar"]

