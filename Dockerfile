FROM adoptopenjdk:11-jre-hotspot
COPY "target/logging-service.jar" logging-service.jar
ENTRYPOINT ["java", "-jar", "logging-service.jar"]