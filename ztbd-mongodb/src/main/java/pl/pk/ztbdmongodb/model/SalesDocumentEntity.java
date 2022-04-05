package pl.pk.ztbdmongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Document("dokument_sprzedazy")
public class SalesDocumentEntity {
    @Id
    private String id;

    @Field("oplata")
    private PaymentEntity payment;

    @Field("zlecenie_id")
    private String orderId;

    @Field("data_wystawienia")
    private LocalDate invoiceDate;

    @Field("czy_faktura")
    private Boolean isInvoice;

    @Field("nip")
    private String taxIdentifier;

    @Field("nazwa_klienta")
    private String customerName;
}
