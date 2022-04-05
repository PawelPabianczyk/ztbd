package pl.pk.ztbdmongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Document("awizo")
public class NotificationEntity {
    @Id
    private String id;

    @Field("adres_id")
    private String addressId;

    @Field("data_dostarczenia_awizo")
    private LocalDate deliveryDate;

    @Field("termin")
    private LocalDate deadline;
}
