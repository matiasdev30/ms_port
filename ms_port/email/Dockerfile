FROM openjdk:17-jdk-slim

WORKDIR /ms_email

# Copie o arquivo JAR do seu projeto para o diretório de trabalho no contêiner
COPY target/email-0.0.1-SNAPSHOT.jar /ms_email/ms_email.jar

# Comando para executar o aplicativo Java
ENTRYPOINT ["java", "-jar", "/ms_email/ms_email.jar"]
