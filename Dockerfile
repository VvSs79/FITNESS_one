FROM openjdk:17
MAINTAINER Vv79
ADD ./target/fitness.jar /app/

CMD ["java", "-Xmx200m", "-jar", "/app/fitness-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080 8089

