## Ustawienia bazy danych

### Zmiana bazy danych

Aplikacja może obsługiwać dwa różne silniki bazodanowe:

- postgreSQL
- Oracle

Aby przełączyć się pomiędzy nimi należy wybrać jeden z dwóch dostępnych profili:

- postgres (domyślny)

```
mvn spring-boot:run -Dpostgres
```

- oracle

```
mvn spring-boot:run -Doracle
```

### Zmiana ilości importowanych danych

Obecnie można zaimportować kolejno:

- 5k
- 20k
- 40k

rekordów do bazy danych. Aby wybrać interesującą ilość należy zmienić w pliku:

```
src/main/resources/db/changelog/db.changelog-master.yaml
```

ścieżkę do odpowiedniego folderu:

```yaml
  - include:
      relativeToChangelogFile: true
      file: data/{ilosc_rekordow}/db.changelog.yaml
```

Domyślnie jest ustawiona wartość 5000 rekordów.