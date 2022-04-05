package pl.pk.ztbdoracle.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "awizo")
public class NotificationEntity {
    @Id
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_id_adresu_placowki", referencedColumnName = "id")
    private AddressEntity address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_id_potwierdzenia", referencedColumnName = "id")
    private ReceiptAckEntity receiptAck;

    @Column(name = "data_dostarczenia_awizo")
    private LocalDate deliveryDate;

    @Column(name = "termin")
    private LocalDate deadline;
}
