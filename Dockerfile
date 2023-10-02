# Använd en officiell Java-basbild
FROM openjdk:17-jdk

# Ange arbetsmapp i containern
WORKDIR /app

# Kopiera JAR-filen från den fullständiga sökvägen till containern
COPY /Users/dimazz/Desktop/To-Do-List-Grupp-7/demo/build/libs/demo-0.0.1-SNAPSHOT.jar app.jar

# Exponera port 8080
EXPOSE 8080

# Kör Java-applikationen
ENTRYPOINT ["java", "-jar", "app.jar"]
