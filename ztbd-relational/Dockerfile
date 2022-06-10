FROM openjdk:18.0-slim AS build
WORKDIR /src
COPY target/*.jar app.jar

ENV PROFILE="postgres"
ENV ROW_AMOUNT="5k"
ENV INDEXES="include_indexes"
ENV POSTGRES_URL="postgres"

ENTRYPOINT ["java", "-jar", "app.jar"]