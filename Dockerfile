# Etapa de construção
FROM ubuntu:latest AS build

# Atualiza os repositórios e instala OpenJDK e Maven
RUN apt-get update && \
    apt-get install -y openjdk-17-jdk maven && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*


WORKDIR /app

COPY . .

RUN mvn clean install

FROM openjdk:17-jdk-slim

WORKDIR /app

EXPOSE 8080

COPY --from=build /app/target/todolist-1.1.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
