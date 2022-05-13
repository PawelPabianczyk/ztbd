package pl.pk.ztbdpostgresql.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "potwierdzenie_odbioru")
public class ReceiptAckEntity {
    @Id
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "przesylka_id")
    private ParcelEntity parcel;

    @Column(name = "data_dostarczenia")
    private LocalDate deliveryDate;

}
