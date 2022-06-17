FROM openjdk:18.0-slim AS build
WORKDIR /src
COPY target/*.jar app.jar

#ENV ROW_AMOUNT="5k"
#ENV INDEXES="include_indexes"
ENV MONGO_URL="mongo"

ENTRYPOINT ["java", "-jar", "app.jar"]