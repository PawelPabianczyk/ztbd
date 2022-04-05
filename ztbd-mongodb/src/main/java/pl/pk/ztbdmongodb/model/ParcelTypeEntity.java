package pl.pk.ztbdmongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document("rodzaj_przesylki")
public class ParcelTypeEntity {
    @Id
    private String id;

    @Field("rodzaj_przesylki")
    private String parcelType;
}
