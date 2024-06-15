FROM openjdk:17-jdk-slim
WORKDIR /ms_users

# Copie o arquivo JAR do seu projeto para o diretório de trabalho no contêiner
COPY target/users-0.0.1-SNAPSHOT.jar /ms_users/ms_users.jar

# Comando para executar o aplicativo Java
ENTRYPOINT ["java", "-jar", "/ms_users/ms_users.jar"]
