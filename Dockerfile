FROM openjdk:latest
ARG JAR_FILE=target/api-back-organization-0.0.1.jar
COPY ${JAR_FILE} data/api-back-organization-0.0.1.jar
COPY libs/crm-commun-1.0.jar data/crm-commun-1.0.jar
EXPOSE 8010
ENTRYPOINT ["java","-jar","data/api-back-organization-0.0.1.jar"]
