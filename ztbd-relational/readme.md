## Ustawienia bazy danych

### Zmiana bazy danych

Aplikacja może obsługiwać dwa różne silniki bazodanowe:

- postgreSQL
- Oracle

Aby przełączyć się pomiędzy nimi należy wybrać jeden z dwóch dostępnych profili:

- postgres (domyślny)
  - zmienna środowiskowa **INDEXES=include_indexes** do utworzenia indeksów
    - bez podania zmiennej indeksy nie zostaną utworzone
  - zmienna środowiskowa **ROW_AMOUNT=5k** do określenia ilości wierszy do zaimportowania
    - do wyboru (5k, 20k, 40k)

```
ROW_AMOUNT=5k INDEXES=include_indexes mvn spring-boot:run -Ppostgres
```

- oracle

```
mvn spring-boot:run -Poracle
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

### Indeksów na bazie danych

Obecnie indeksy na bazie danych są domyślnie włączone. Aby je wyłączyć należy zakomentować
poniższy kawałek kodu

```yaml
- include:
  relativeToChangelogFile: true
  file: indexes/db.changelog.yaml
```

w pliku:

```
src/main/resources/db/changelog/db.changelog-master.yaml
```

