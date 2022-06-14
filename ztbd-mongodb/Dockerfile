FROM openjdk:18.0-slim AS build
WORKDIR /src
COPY target/*.jar app.jar

ENV ROW_AMOUNT="5k"
ENV INDEXES="include_indexes"
ENV POSTGRES_URL="mongo"

ENTRYPOINT ["java", "-jar", "app.jar", "--import=data/5k/podmioty.json.log", "--collection=podmiot", "--import=data/5k/przesylki.json.log", \
                                        "--collection=przesylka", "--import=data/5k/zlecenia.json.log", "--collection=zlecenie"]