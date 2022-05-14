package pl.pk.ztbdmongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Document("oplata")
public class PaymentEntity {
    @Id
    private Long id;

    @Field("czy_zaplacono")
    private Boolean isPaid;

    @Field("data_zaplaty")
    private LocalDate paymentDate;

    @Field("typ_platnosc")
    private String paymentType;

    @Override
    public String toString() {
        return "PaymentEntity{" +
                "id=" + id +
                ", isPaid=" + isPaid +
                ", paymentDate=" + paymentDate +
                ", paymentType='" + paymentType + '\'' +
                '}';
    }
}
