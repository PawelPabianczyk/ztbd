package pl.pk.ztbdpostgresql.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "przesylka")
public class ParcelEntity {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "zlecenie_id")
    private OrderEntity order;

    @ManyToOne
    @JoinColumn(name = "adresat_id")
    private SubjectEntity addressee;

    @OneToOne(mappedBy = "parcel")
    private ReceiptAckEntity receiptAck;

    @Column(name = "rodzaj_przesylki")
    private String parcelType;

    @Column(name = "wymiar_x")
    private Integer dimensionX;

    @Column(name = "wymiar_y")
    private Integer dimensionY;

    @Column(name = "wymiar_z")
    private Integer dimensionZ;

    @Column(name = "waga")
    private Integer weight;

    @Column(name = "data_nadania")
    private LocalDate postingDate;

    @Override
    public String toString() {
        return "ParcelEntity{" +
                "id=" + id +
                ", receiptAck=" + receiptAck +
                ", parcelType='" + parcelType + '\'' +
                ", dimensionX=" + dimensionX +
                ", dimensionY=" + dimensionY +
                ", dimensionZ=" + dimensionZ +
                ", weight=" + weight +
                ", postingDate=" + postingDate +
                '}';
    }
}
