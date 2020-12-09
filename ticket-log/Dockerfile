FROM openjdk:11-jre
LABEL maintainer =  'Jefster Farlei'

WORKDIR /ticker-log
COPY target/ticket-log-1.0.0.jar .
COPY assets ./assets
EXPOSE 8400

ENTRYPOINT ["java", "-jar", "ticket-log-1.0.0.jar"]

