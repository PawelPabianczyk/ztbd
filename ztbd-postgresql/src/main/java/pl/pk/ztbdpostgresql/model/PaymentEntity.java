package pl.pk.ztbdpostgresql.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "oplata")
public class PaymentEntity {
    @Id
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "faktura_id")
    private SalesDocumentEntity salesDocument;

    @Column(name = "czy_zaplacono")
    private Boolean isPaid;

    @Column(name = "data_zaplaty")
    private LocalDate paymentDate;

    @Column(name = "typ_platnosci")
    private String paymentType;
}
