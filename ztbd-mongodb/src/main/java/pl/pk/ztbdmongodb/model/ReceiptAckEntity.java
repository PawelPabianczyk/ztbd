package pl.pk.ztbdmongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Document("potwierdzenieOdbioru")
public class ReceiptAckEntity {
    @Id
    private String id;

    @Field("data_dostarczenia")
    private LocalDate deliveryDate;

    @Override
    public String toString() {
        return "ReceiptAckEntity{" +
                "id=" + id +
                ", deliveryDate=" + deliveryDate +
                '}';
    }
}
