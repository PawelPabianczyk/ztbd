package pl.pk.ztbdmongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;
import java.time.LocalDate;

@Document("faktura")
public class SalesDocumentEntity {
    @Id
    private Long id;

    @Field("oplata")
    private PaymentEntity payment;

    @Field("data_wystawienia")
    private LocalDate invoiceDate;

    @Field("kwota")
    private BigDecimal amount;

    @Override
    public String toString() {
        return "SalesDocumentEntity{" +
                "id=" + id +
                ", payment=" + payment +
                ", invoiceDate=" + invoiceDate +
                ", amount=" + amount +
                '}';
    }
}
