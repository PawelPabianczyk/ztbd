## Budowanie obrazów
### Relational
- Ważne, żeby nazwa obrazu się zgadzała. Jeśli tutaj się zmieni, to trzeba też zmienić w *docker-compose.yml*
- Potrzebny jest gotowy plik *\*.jar* w katalogu target, więc np.:
```bash
cd ztbd-relational/
mvn clean package
docker build -t ztbd-sql .
```
## Docker Compose
- Uruchomienie wybranych serwisów, np.
```bash
docker compose up -d postgres-5k-indexes java-postgres-5k-indexes
```
- Zatrzymanie wybranych serwisów, np.
```bash
docker compose stop postgres-5k-indexes java-postgres-5k-indexes
```
- Usunięcie wszystkich serwisów
```bash
docker compose down
```