package pl.pk.ztbdoracle.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "przesylka")
public class ParcelEntity {
    @Id
    private Long id;

    @OneToOne(mappedBy = "parcel")
    private ReceiptAckEntity receiptAck;

    @OneToOne(mappedBy = "parcel")
    private OrderEntity order;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_id_rodzaju_przesylki", referencedColumnName = "id")
    private ParcelTypeEntity parcelType;

    @Column(name = "wymiar_x_w_cm")
    private Integer dimensionX;

    @Column(name = "wymiar_y_w_cm")
    private Integer dimensionY;

    @Column(name = "wymiar_z_w_cm")
    private Integer dimensionZ;

    @Column(name = "waga_w_g")
    private Integer weight;

    @Column(name = "data_nadania")
    private LocalDate postingDate;
}
