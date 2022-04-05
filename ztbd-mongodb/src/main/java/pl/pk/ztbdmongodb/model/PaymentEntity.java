package pl.pk.ztbdmongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;
import java.time.LocalDate;

@Document("oplata")
public class PaymentEntity {
    @Id
    private String id;

    @Field("kwota")
    private BigDecimal amount;

    @Field("czy_zaplacono")
    private Boolean isPaid;

    @Field("data_zaplaty")
    private LocalDate paymentDate;

    @Field("typ_platnosci")
    private String paymentType;
}
