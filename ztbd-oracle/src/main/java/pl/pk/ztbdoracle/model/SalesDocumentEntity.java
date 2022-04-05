package pl.pk.ztbdoracle.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "dokument_sprzedazy")
public class SalesDocumentEntity {
    @Id
    private Long id;

    @OneToOne(mappedBy = "salesDocument")
    private PaymentEntity payment;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_id_zlecenia", referencedColumnName = "id")
    private OrderEntity order;

    @Column(name = "data_wystawienia")
    private LocalDate invoiceDate;

    @Column(name = "czy_faktura")
    private Boolean isInvoice;

    @Column(name = "nip")
    private String taxIdentifier;

    @Column(name = "nazwa_klienta")
    private String customerName;
}
