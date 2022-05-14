## Ustawienia bazy danych

### Zmiana ilości importowanych danych

Obecnie można zaimportować kolejno:

- 5k
- 20k
- 40k
  <br>rekordów do bazy danych.<br>
  Aby wybrać interesującą ilość należy zmienić w pliku:

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