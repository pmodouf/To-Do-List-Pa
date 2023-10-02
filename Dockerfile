# Använd en officiell Java-basbild
FROM openjdk:17-jdk

# Ange arbetsmapp i containern
WORKDIR /app

# Kopiera alla .jar-filer från din byggmapp till containern
COPY demo/build/libs/*.jar app/
