## Budowanie obrazów
### Relational
- Ważne, żeby nazwa obrazu się zgadzała. Jeśli tutaj się zmieni, to trzeba też zmienić w *docker-compose.yml*:
    - SQL: **ztbd-sql**
    - NoSQL: **ztbd-nosql**
- Potrzebny jest gotowy plik *\*.jar* w katalogu target, więc np.:
```bash
cd ../ztbd-relational/
mvn clean package
docker build -t ztbd-sql .
```
## Docker Compose
- Uruchomienie wszystkich serwisów z pliku, np.
```bash
docker compose -f docker-compose-5k.yml up -d
```
- Uruchomienie wybranych serwisów, np.
```bash
docker compose -f docker-compose-5k.yml up -d postgres-5k java-postgres-5k
```
- Zatrzymanie wybranych serwisów, np.
```bash
docker compose -f docker-compose-5k.yml stop postgres-5k java-postgres-5k
```
- Usunięcie wszystkich serwisów
```bash
docker compose down
```