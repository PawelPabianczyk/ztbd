package pl.pk.ztbdoracle.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "oplata")
public class PaymentEntity {
    @Id
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_id_dokumentu_sprzedazy", referencedColumnName = "id")
    private SalesDocumentEntity salesDocument;

    @Column(name = "kwota")
    private BigDecimal amount;

    @Column(name = "czy_zaplacono")
    private Boolean isPaid;

    @Column(name = "data_zaplaty")
    private LocalDate paymentDate;

    @Column(name = "typ_platnosci")
    private BigDecimal paymentType;
}
