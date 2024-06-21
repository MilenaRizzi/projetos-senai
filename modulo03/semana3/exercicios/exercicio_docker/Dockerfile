# Imagem base da nossa image
# Ja tem o JDK 17 e já vem com o sistema operacional por padão
FROM openjdk:17-jdk-slim-buster

# Autor da imagem
LABEL authors="milena"

# Caminho de execução da aplicação
WORKDIR /app

# Copia o arquivo app.jar para dentro da pasta build
COPY target/exercicio_docker-0.0.1-SNAPSHOT.jar app.jar

# Comando de execução da aplicação que esta na pasta /app/buil
ENTRYPOINT java -jar app.jar