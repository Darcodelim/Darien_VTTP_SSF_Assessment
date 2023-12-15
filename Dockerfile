FROM openjdk:21-bookworm AS builder

WORKDIR /src

COPY src src
COPY .mvn .mvn
COPY mvnw .
COPY pom.xml .
COPY events.json .

# compile the Java application
RUN ./mvnw package -Dmvn.test.skip=true

FROM openjdk:21-bookworm 

WORKDIR /app

# copy and rename to app.jar
COPY --from=builder /src/target/eventmanagement-0.0.1-SNAPSHOT.jar app.jar

ENV PORT=8080
ENV SPRING_REDIS_HOST=127.0.0.1
ENV SPRING_REDIS_PORT=6379
ENV SPRING_REDIS_DATABASE=0
ENV SPRING_REDIS_USERNAME=
ENV SPRING_REDIS_PASSWORD=


EXPOSE $PORT

ENTRYPOINT SERVER_PORT=${PORT} java -jar ./app.jar
