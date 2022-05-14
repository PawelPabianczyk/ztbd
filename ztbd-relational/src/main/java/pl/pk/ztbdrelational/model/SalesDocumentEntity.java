package pl.pk.ztbdrelational.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "faktura")
public class SalesDocumentEntity {
    @Id
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "zlecenie_id")
    private OrderEntity order;

    @OneToOne(mappedBy = "salesDocument")
    private PaymentEntity payment;

    @Column(name = "data_wystawienia")
    private LocalDate invoiceDate;

    @Column(name = "kwota")
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
