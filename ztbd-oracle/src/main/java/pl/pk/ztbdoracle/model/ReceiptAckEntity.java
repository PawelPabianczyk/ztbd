package pl.pk.ztbdoracle.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "potwierdzenie_odbioru")
public class ReceiptAckEntity {
    @Id
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_id_przesylki", referencedColumnName = "id")
    private ParcelEntity parcel;

    @OneToOne(mappedBy = "receiptAck")
    private NotificationEntity notification;

    @Column(name = "data_dostarczenia")
    private LocalDate deliveryDate;

    @Column(name = "czy_dostarczono")
    private Boolean isDelivered;
}
