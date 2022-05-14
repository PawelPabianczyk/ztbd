package pl.pk.ztbdmongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Set;

@Document("zlecenie")
public class OrderEntity {
    @Id
    private Long id;

    @Field("nadawcaId")
    private String subject;

    @Field("przesylkaIds")
    private Set<String> parcels;

    @Field("faktura")
    private SalesDocumentEntity salesDocument;

    @Override
    public String toString() {
        return "OrderEntity{" +
                "id=" + id +
                ", parcels=" + parcels +
                ", salesDocument=" + salesDocument +
                '}';
    }
}
