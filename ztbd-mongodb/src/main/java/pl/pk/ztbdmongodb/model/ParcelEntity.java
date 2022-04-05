package pl.pk.ztbdmongodb.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Document("przesylka")
public class ParcelEntity {
    @Id
    private String id;

    @Field("zlecenie_id")
    private String orderId;

    @Field("wymiar_x_w_cm")
    private Integer dimensionX;

    @Field("wymiar_y_w_cm")
    private Integer dimensionY;

    @Field("wymiar_z_w_cm")
    private Integer dimensionZ;

    @Field("waga_w_g")
    private Integer weight;

    @Field("data_nadania")
    private LocalDate postingDate;

    @Field("rodzaj_przesylki")
    private ParcelTypeEntity parcelType;

    @Field("potwierdzenie_odbioru")
    private ReceiptAckEntity receiptAck;
}
