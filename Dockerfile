FROM openjdk:latest
ARG JAR_FILE=target/back-organization-0.0.1.jar
COPY ${JAR_FILE} data/back-organization-0.0.1.jar
EXPOSE 8010
ENTRYPOINT ["java","-jar","data/back-organization-0.0.1.jar"]
