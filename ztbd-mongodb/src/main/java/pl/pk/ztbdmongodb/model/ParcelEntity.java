package pl.pk.ztbdmongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Document("przesylka")
public class ParcelEntity {
    @Id
    private String id;

    @Field("adresatId")
    private String addressee;

    @Field("zlecenieId")
    private String order;

    @Field("wymiar_x")
    private Integer dimensionX;

    @Field("wymiar_y")
    private Integer dimensionY;

    @Field("wymiar_z")
    private Integer dimensionZ;

    @Field("waga")
    private Integer weight;

    @Field("data_nadania")
    private LocalDate postingDate;

    @Field("rodzaj_przesylki")
    private String parcelType;

    @Field("potwierdzenieOdbioru")
    private ReceiptAckEntity receiptAck;

    @Override
    public String toString() {
        return "ParcelEntity{" +
                "id=" + id +
                ", receiptAck=" + receiptAck +
                ", parcelType='" + parcelType + '\'' +
                ", dimensionX=" + dimensionX +
                ", dimensionY=" + dimensionY +
                ", dimensionZ=" + dimensionZ +
                ", weight=" + weight +
                ", postingDate=" + postingDate +
                '}';
    }
}
