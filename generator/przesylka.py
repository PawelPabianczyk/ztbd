import json

import generators
# import csv_files
import random
import datetime


def generate():
    n = 10

    adresy = []
    adres = {}
    podmioty = []
    podmiot = {}
    zlecenia = []
    zlecenie = {}
    przesylki = []
    przesylka = {}
    faktury = []
    faktura = {}
    oplaty = []
    oplata = {}
    potwierdzenia = []
    potwierdzenie = {}

    adresJSON = {}
    adresyJSON = []

    podmiotJSON = {}
    podmiotyJSON = []

    oplataJSON = {}
    oplatyJSON = []

    zlecenieJSON = {}
    zleceniaJSON = []

    przesylkaJSON = {}
    przesylkiJSON = []

    potwierdzenieJSON = {}
    potwierdzeniaJSON = []

    fakturaJSON = {}
    fakturyJSON = []

    #generuj n podmiotów
    for i in range(0, n):
        # ADRES
        id_adresu = str(i + 1)
        miasto = str(generators.random_city(1)[0])
        kod_pocztowy = str(generators.random_postcode())
        ulica = str(generators.random_streets(1)[0])
        nr_budynku = str(generators.random_house_number())
        nr_lokalu = str(generators.random_flat_number())

        adresJSON = {
            '_id': id_adresu,
            'miasto': miasto,
            'kod_pocztowy': kod_pocztowy,
            'ulica': ulica,
            'nr_budynku': nr_budynku,
            'nr_lokalu': nr_lokalu
        }
        adresyJSON.append(adresJSON)

        adres = id_adresu + ',' + miasto + ',' + kod_pocztowy + ',' + ulica + ',' + nr_budynku + ',' + nr_lokalu
        adresy.append(adres)



        # PODMIOT
        id_podmiotu = str(i + 1)
        id_adresu = str(i + 1)
        imie = generators.random_first_names(1)[0]
        nazwisko = generators.random_last_names(1)[0]
        nip = ''
        nazwa = ''

        if random.randrange(0, 5) > 2:
            nip = generators.random_nip()
            nazwa = imie + ' ' + nazwisko + ' z o.o.'


        # ile zlecen ma miec klient?
        # 0 1 2 3 4    40%
        if random.randrange(0, 5) > 2:
            # wiele zlecen
            ile = random.randrange(2, 5)
            zlecenieIds = []
            for j in range(0, ile):
                # ZLECENIA
                id_zlecenia = str(len(zleceniaJSON) + 1)
                zlecenieIds.append(id_zlecenia)
                nadawca_id = id_podmiotu
                przesylkaIds = []


                # OPLATA
                id_oplaty = str(len(oplatyJSON) + 1)
                data_nadania = generators.random_date()
                difference = datetime.date.fromisoformat('2021-10-31') - data_nadania
                if difference.days > 10:
                    czy_zaplacono = '1'
                else:
                    czy_zaplacono = str(random.randrange(0, 2))

                if czy_zaplacono == '1':
                    data_zaplaty = data_nadania
                else:
                    data_zaplaty = 'NULL'

                if random.randrange(0, 3) == 0:
                    typ_platnosci = 'gotówka'
                else:
                    typ_platnosci = 'przelew'

                # FAKTURA
                id_faktury = str(len(fakturyJSON) + 1)
                data_wystawienia = str(data_nadania)

                oplataJSON = {
                    '_id': id_oplaty,
                    'czy_zaplacono': czy_zaplacono,
                    'data_zaplaty': data_zaplaty,
                    'typ_platnosc': typ_platnosci
                }
                oplatyJSON.append(oplataJSON)
                oplata = id_oplaty + ',' + id_faktury + ',' + czy_zaplacono + ',' + str(data_zaplaty) + ',' + typ_platnosci
                oplaty.append(oplata)





                # ile przesylek w zleceniu
                # 0 1 2 3 4   40%
                if random.randrange(0, 5) > 2:
                    # wiele
                    yle = random.randrange(2, 5)
                    kwota = str(yle * 14.99)
                    przesylkaIds = []
                    for k in range(0, yle):
                        # PRZESYLKI
                        id_przesylki = str(len(przesylkiJSON) + 1)
                        przesylkaIds.append(id_przesylki)
                        adresat_id = str(random.randrange(1, n + 1))
                        id_rodzaj_przesylki = str(random.randrange(1, 4))
                        if id_rodzaj_przesylki == '1':
                            rodzaj_przesylki = 'list'
                            x = str(random.randrange(5, 50))
                            y = str(random.randrange(5, 50))
                            z = str(random.randrange(1, 20))
                            waga = str(random.randrange(1, 1000))
                        elif id_rodzaj_przesylki == '2':
                            rodzaj_przesylki = 'paczka'
                            x = str(random.randrange(5, 100))
                            y = str(random.randrange(5, 100))
                            z = str(random.randrange(1, 100))
                            waga = str(random.randrange(500, 50000))
                        else:
                            rodzaj_przesylki = 'paleta'
                            x = str(random.randrange(20, 100))
                            y = str(random.randrange(20, 100))
                            z = str(random.randrange(20, 100))
                            waga = str(random.randrange(25000, 200000))

                        # POTWIERDZENIA
                        # czy odebrane
                        czy_dostarczona = str(random.randrange(0, 10))
                        potwierdzenieJSON = {}
                        if czy_dostarczona != '0':
                            data_dostarczenia = str(data_nadania + datetime.timedelta(days=random.randrange(1, 3)))
                            id_potwierdzenia = str(len(potwierdzeniaJSON) + 1)
                            potwierdzenieJSON = {
                                '_id': id_potwierdzenia,
                                'data_dostarczenia': data_dostarczenia
                            }
                            potwierdzeniaJSON.append(potwierdzenieJSON)
                            potwierdzenie = id_potwierdzenia + ',' + id_potwierdzenia + ',' + data_dostarczenia
                            potwierdzenia.append(potwierdzenie)

                        przesylkaJSON = {
                            '_id': id_przesylki,
                            'adresatId': adresat_id,
                            'zlecenieId': id_zlecenia,
                            'wymiar_x': x,
                            'wymiar_y': y,
                            'wymiar_z': z,
                            'waga': waga,
                            'data_nadania': str(data_nadania),
                            'rodzaj_przesylki': rodzaj_przesylki,
                            'potwierdzenieOdbioru': potwierdzenieJSON
                        }
                        przesylkiJSON.append(przesylkaJSON)

                        przesylka = id_przesylki + ',' + id_zlecenia + ',' + adresat_id + ',' + rodzaj_przesylki\
                                    + ',' + x + ',' + y + ',' + z + ',' + waga + ',' + str(data_nadania)
                        przesylki.append(przesylka)

                # jedna przesylka
                else:
                    kwota = str(14.99)
                    przesylkaIds = []

                    # PRZESYLKI
                    id_przesylki = str(len(przesylkiJSON) + 1)
                    przesylkaIds.append(id_przesylki)
                    adresat_id = str(random.randrange(1, n + 1))
                    id_rodzaj_przesylki = str(random.randrange(1, 4))
                    if id_rodzaj_przesylki == '1':
                        rodzaj_przesylki = 'list'
                        x = str(random.randrange(5, 50))
                        y = str(random.randrange(5, 50))
                        z = str(random.randrange(1, 20))
                        waga = str(random.randrange(1, 1000))
                    elif id_rodzaj_przesylki == '2':
                        rodzaj_przesylki = 'paczka'
                        x = str(random.randrange(5, 100))
                        y = str(random.randrange(5, 100))
                        z = str(random.randrange(1, 100))
                        waga = str(random.randrange(500, 50000))
                    else:
                        rodzaj_przesylki = 'paleta'
                        x = str(random.randrange(20, 100))
                        y = str(random.randrange(20, 100))
                        z = str(random.randrange(20, 100))
                        waga = str(random.randrange(25000, 200000))

                    # POTWIERDZENIA
                    # czy odebrane
                    czy_dostarczona = str(random.randrange(0, 10))
                    potwierdzenieJSON = {}
                    if czy_dostarczona != '0':
                        data_dostarczenia = str(data_nadania + datetime.timedelta(days=random.randrange(1, 3)))
                        id_potwierdzenia = str(len(potwierdzeniaJSON) + 1)
                        potwierdzenieJSON = {
                            '_id': id_potwierdzenia,
                            'data_dostarczenia': data_dostarczenia
                        }
                        potwierdzeniaJSON.append(potwierdzenieJSON)
                        potwierdzenie = id_potwierdzenia + ',' + id_potwierdzenia + ',' + data_dostarczenia
                        potwierdzenia.append(potwierdzenie)

                    przesylkaJSON = {
                        '_id': id_przesylki,
                        'adresatId': adresat_id,
                        'zlecenieId': id_zlecenia,
                        'wymiar_x': x,
                        'wymiar_y': y,
                        'wymiar_z': z,
                        'waga': waga,
                        'data_nadania': str(data_nadania),
                        'rodzaj_przesylki': rodzaj_przesylki,
                        'potwierdzenieOdbioru': potwierdzenieJSON
                    }
                    przesylkiJSON.append(przesylkaJSON)

                    przesylka = id_przesylki + ',' + id_zlecenia + ',' + adresat_id + ',' + rodzaj_przesylki \
                                + ',' + x + ',' + y + ',' + z + ',' + waga + ',' + str(data_nadania)
                    przesylki.append(przesylka)


                fakturaJSON = {
                    '_id': id_faktury,
                    'oplata': oplataJSON,
                    'data_wystawienia': data_wystawienia,
                    'kwota': kwota
                }
                fakturyJSON.append(fakturaJSON)
                faktura = id_faktury + ',' + id_zlecenia + ',' + data_wystawienia + ',' + kwota
                faktury.append(faktura)


                zlecenieJSON = {
                    '_id': id_zlecenia,
                    'nadawcaId': nadawca_id,
                    'przesylkaIds': przesylkaIds,
                    'faktura': fakturaJSON
                }
                zleceniaJSON.append(zlecenieJSON)

                zlecenie = id_zlecenia + ',' + nadawca_id
                zlecenia.append(zlecenie)

        else:
            # ZLECENIA
            id_zlecenia = str(len(zleceniaJSON) + 1)
            nadawca_id = id_podmiotu
            przesylkaIds = []
            zlecenieIds = [id_zlecenia]

            # OPLATA
            id_oplaty = str(len(oplatyJSON) + 1)
            data_nadania = generators.random_date()
            difference = datetime.date.fromisoformat('2021-10-31') - data_nadania
            if difference.days > 10:
                czy_zaplacono = '1'
            else:
                czy_zaplacono = str(random.randrange(0, 2))

            if czy_zaplacono == '1':
                data_zaplaty = data_nadania
            else:
                data_zaplaty = 'NULL'

            if random.randrange(0, 3) == 0:
                typ_platnosci = 'gotówka'
            else:
                typ_platnosci = 'przelew'

            # FAKTURA
            id_faktury = str(len(fakturyJSON) + 1)
            data_wystawienia = str(data_nadania)

            oplataJSON = {
                '_id': id_oplaty,
                'czy_zaplacono': czy_zaplacono,
                'data_zaplaty': data_zaplaty,
                'typ_platnosc': typ_platnosci
            }
            oplatyJSON.append(oplataJSON)
            oplata = id_oplaty + ',' + id_faktury + ',' + czy_zaplacono + ',' + str(data_zaplaty) + ',' + typ_platnosci
            oplaty.append(oplata)



            # ile przesylek w zleceniu
            # 0 1 2 3 4   40%
            if random.randrange(0, 5) > 2:
                # wiele
                yle = random.randrange(2, 5)
                kwota = str(yle * 14.99)
                przesylkaIds = []
                for k in range(0, yle):
                    # PRZESYLKI
                    id_przesylki = str(len(przesylkiJSON) + 1)
                    przesylkaIds.append(id_przesylki)
                    adresat_id = str(random.randrange(1, n + 1))
                    id_rodzaj_przesylki = str(random.randrange(1, 4))
                    if id_rodzaj_przesylki == '1':
                        rodzaj_przesylki = 'list'
                        x = str(random.randrange(5, 50))
                        y = str(random.randrange(5, 50))
                        z = str(random.randrange(1, 20))
                        waga = str(random.randrange(1, 1000))
                    elif id_rodzaj_przesylki == '2':
                        rodzaj_przesylki = 'paczka'
                        x = str(random.randrange(5, 100))
                        y = str(random.randrange(5, 100))
                        z = str(random.randrange(1, 100))
                        waga = str(random.randrange(500, 50000))
                    else:
                        rodzaj_przesylki = 'paleta'
                        x = str(random.randrange(20, 100))
                        y = str(random.randrange(20, 100))
                        z = str(random.randrange(20, 100))
                        waga = str(random.randrange(25000, 200000))

                    # POTWIERDZENIA
                    # czy odebrane
                    czy_dostarczona = str(random.randrange(0, 10))
                    potwierdzenieJSON = {}
                    if czy_dostarczona != '0':
                        data_dostarczenia = str(data_nadania + datetime.timedelta(days=random.randrange(1, 3)))
                        id_potwierdzenia = str(len(potwierdzeniaJSON) + 1)
                        potwierdzenieJSON = {
                            '_id': id_potwierdzenia,
                            'data_dostarczenia': data_dostarczenia
                        }
                        potwierdzeniaJSON.append(potwierdzenieJSON)
                        potwierdzenie = id_potwierdzenia + ',' + id_potwierdzenia + ',' + data_dostarczenia
                        potwierdzenia.append(potwierdzenie)

                    przesylkaJSON = {
                        '_id': id_przesylki,
                        'adresatId': adresat_id,
                        'zlecenieId': id_zlecenia,
                        'wymiar_x': x,
                        'wymiar_y': y,
                        'wymiar_z': z,
                        'waga': waga,
                        'data_nadania': str(data_nadania),
                        'rodzaj_przesylki': rodzaj_przesylki,
                        'potwierdzenieOdbioru': potwierdzenieJSON
                    }
                    przesylkiJSON.append(przesylkaJSON)

                    przesylka = id_przesylki + ',' + id_zlecenia + ',' + adresat_id + ',' + rodzaj_przesylki \
                                + ',' + x + ',' + y + ',' + z + ',' + waga + ',' + str(data_nadania)
                    przesylki.append(przesylka)

            # jedna przesylka
            else:
                kwota = str(14.99)
                przesylkaIds = []

                # PRZESYLKI
                id_przesylki = str(len(przesylkiJSON) + 1)
                przesylkaIds.append(id_przesylki)
                adresat_id = str(random.randrange(1, n + 1))
                id_rodzaj_przesylki = str(random.randrange(1, 4))
                if id_rodzaj_przesylki == '1':
                    rodzaj_przesylki = 'list'
                    x = str(random.randrange(5, 50))
                    y = str(random.randrange(5, 50))
                    z = str(random.randrange(1, 20))
                    waga = str(random.randrange(1, 1000))
                elif id_rodzaj_przesylki == '2':
                    rodzaj_przesylki = 'paczka'
                    x = str(random.randrange(5, 100))
                    y = str(random.randrange(5, 100))
                    z = str(random.randrange(1, 100))
                    waga = str(random.randrange(500, 50000))
                else:
                    rodzaj_przesylki = 'paleta'
                    x = str(random.randrange(20, 100))
                    y = str(random.randrange(20, 100))
                    z = str(random.randrange(20, 100))
                    waga = str(random.randrange(25000, 200000))

                # POTWIERDZENIA
                # czy odebrane
                czy_dostarczona = str(random.randrange(0, 10))
                potwierdzenieJSON = {}
                if czy_dostarczona != '0':
                    data_dostarczenia = str(data_nadania + datetime.timedelta(days=random.randrange(1, 3)))
                    id_potwierdzenia = str(len(potwierdzeniaJSON) + 1)
                    potwierdzenieJSON = {
                        '_id': id_potwierdzenia,
                        'data_dostarczenia': data_dostarczenia
                    }
                    potwierdzeniaJSON.append(potwierdzenieJSON)
                    potwierdzenie = id_potwierdzenia + ',' + id_potwierdzenia + ',' + data_dostarczenia
                    potwierdzenia.append(potwierdzenie)

                przesylkaJSON = {
                    '_id': id_przesylki,
                    'adresatId': adresat_id,
                    'zlecenieId': id_zlecenia,
                    'wymiar_x': x,
                    'wymiar_y': y,
                    'wymiar_z': z,
                    'waga': waga,
                    'data_nadania': str(data_nadania),
                    'rodzaj_przesylki': rodzaj_przesylki,
                    'potwierdzenieOdbioru': potwierdzenieJSON
                }
                przesylkiJSON.append(przesylkaJSON)
                przesylka = id_przesylki + ',' + id_zlecenia + ',' + adresat_id + ',' + rodzaj_przesylki \
                            + ',' + x + ',' + y + ',' + z + ',' + waga + ',' + str(data_nadania)
                przesylki.append(przesylka)


            fakturaJSON = {
                '_id': id_faktury,
                'oplata': oplataJSON,
                'data_wystawienia': data_wystawienia,
                'kwota': kwota
            }
            fakturyJSON.append(fakturaJSON)
            faktura = id_faktury + ',' + id_zlecenia + ',' + data_wystawienia + ',' + kwota
            faktury.append(faktura)

            zlecenieJSON = {
                '_id': id_zlecenia,
                'nadawcaId': nadawca_id,
                'przesylkaIds': przesylkaIds,
                'faktura': fakturaJSON
            }
            zleceniaJSON.append(zlecenieJSON)

            zlecenie = id_zlecenia + ',' + nadawca_id
            zlecenia.append(zlecenie)


        podmiotJSON = {
            '_id': id_podmiotu,
            'adres': adresJSON,
            'zlecenieIds': zlecenieIds,
            'przesylkiIds': przesylkaIds,
            'imie': imie,
            'nazwisko': nazwisko,
            'nip': nip,
            'nazwa': nazwa
        }
        podmiotyJSON.append(podmiotJSON)

        podmiot = id_podmiotu + ',' + id_adresu + ',' + nazwa + ',' + imie + ',' + nazwisko + ',' + nip
        podmioty.append(podmiot)

    json_object = json.dumps(podmiotyJSON, indent=4, default=str)
    with open("generated_data/podmioty-"+str(n)+".json", "w") as outfile:
        outfile.write(json_object)

    json_object = json.dumps(zleceniaJSON, indent=4, default=str)
    with open("generated_data/zlecenia-"+str(n)+".json", "w") as outfile:
        outfile.write(json_object)

    json_object = json.dumps(przesylkiJSON, indent=4, default=str)
    with open("generated_data/przesylki-"+str(n)+".json", "w") as outfile:
        outfile.write(json_object)



    # adres
    header = 'ID,MIASTO,KOD_POCZTOWY,ULICA,NR_BUDYNKU,NR_LOKALU'
    rows = '\n'.join(adresy)
    csv_files.save_csv('adres-' + str(n), header + '\n' + rows)

    # podmiot
    header = 'ID,ADRES_ID,NAZWA,IMIE,NAZWISKO,NIP'
    rows = '\n'.join(podmioty)
    csv_files.save_csv('podmiot-' + str(n), header + '\n' + rows)

    # zlecenie
    header = 'ID,NADAWCA_ID'
    rows = '\n'.join(zlecenia)
    csv_files.save_csv('zlecenie-'+str(n), header + '\n' + rows)

    # przesylka
    header = 'ID,ZLECENIE_ID,ADRESAT_ID,RODZAJ_PRZESYLKI,WYMIAR_X,WYMIAR_Y,WYMIAR_Z,WAGA,DATA_NADANIA'
    rows = '\n'.join(przesylki)
    csv_files.save_csv('przesylka-'+str(n),  header + '\n' + rows)

    # oplata
    header = 'ID,FAKTURA_ID,CZY_ZAPLACONO,DATA_ZAPLATY,TYP_PLATNOSCI'
    rows = '\n'.join(oplaty)
    csv_files.save_csv('oplata-'+str(n), header + '\n' + rows)

    # faktura
    header = 'ID,ZLECENIE_ID,DATA_WYSTAWIENIA,KWOTA'
    rows = '\n'.join(faktury)
    csv_files.save_csv('faktura-' + str(n), header + '\n' + rows)

    # potwierdzenia_odbioru
    header = 'ID,PRZESYLKA_ID,DATA_DOSTARCZENIA'
    rows = '\n'.join(potwierdzenia)
    csv_files.save_csv('potwierdzenie_odbioru-' + str(n), header + '\n' + rows)


generate()
