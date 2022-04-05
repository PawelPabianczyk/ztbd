package pl.pk.ztbdmongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document("zlecenie")
public class OrderEntity {
    @Id
    private String id;

    @Field("dokument_sprzedazy")
    private SalesDocumentEntity salesDocument;

    @Field("przesylka_id")
    private String parcelId;

    @Field("adres_id")
    private String addressId;

    @Field("odleglosc_w_km")
    private Integer distance;

    @Field("imie_odbiorcy")
    private String recipientFirstName;

    @Field("nazwisko_odbiorcy")
    private String recipientSurname;
}
