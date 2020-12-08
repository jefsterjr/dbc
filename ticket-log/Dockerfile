FROM openjdk:11-jre
LABEL maintainer =  'Jefster Farlei'

RUN useradd cidade && \
    mkdir /app && \
    chown cidade /app
USER cidade
WORKDIR /app

ENTRYPOINT ["java", "-jar", "target/cidade-1.0.0.jar"]

EXPOSE 8080
