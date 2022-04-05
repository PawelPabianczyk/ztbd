package pl.pk.ztbdmongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Document("potwierdzenie_odbioru")
public class ReceiptAckEntity {
    @Id
    private String id;

    @Field("awizo")
    private NotificationEntity notification;

    @Field("data_dostarczenia")
    private LocalDate deliveryDate;

    @Field("czy_dostarczono")
    private Boolean isDelivered;
}
