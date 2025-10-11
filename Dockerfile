# syntax=docker/dockerfile:1.6

########## STAGE 1: build ##########
FROM maven:3.9-eclipse-temurin-21-jammy AS build
WORKDIR /app

# 1) Cache das dependências baseado no pom.xml
COPY pom.xml .
RUN --mount=type=cache,target=/root/.m2 \
    mvn -q -B -DskipTests dependency:go-offline

# 2) Wrapper (normaliza CRLF do Windows)
COPY mvnw ./mvnw
COPY .mvn/ ./.mvn/
RUN sed -i 's/\r$//' mvnw && chmod +x mvnw

# 3) Código e build (usa o wrapper)
COPY src ./src
RUN --mount=type=cache,target=/root/.m2 \
    ./mvnw -q -B -DskipTests clean package

########## STAGE 2: runtime ##########
FROM eclipse-temurin:21-jre-jammy
RUN useradd -ms /bin/bash spring
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080

USER spring
ENTRYPOINT ["java","-XX:MaxRAMPercentage=75.0","-Djava.security.egd=file:/dev/./urandom","-jar","/app/app.jar"]