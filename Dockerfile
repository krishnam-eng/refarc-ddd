FROM openjdk:11-jre-slim

WORKDIR /app

COPY library/build/libs/library-0.0.1-SNAPSHOT.jar /app

EXPOSE 8080

CMD ["java", "-jar", "/app/library-0.0.1-SNAPSHOT.jar"]

