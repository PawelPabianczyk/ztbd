package pl.pk.ztbdoracle.model;

import javax.persistence.*;

@Entity
@Table(name = "rodzaj_przesylki")
public class ParcelTypeEntity {
    @Id
    private Long id;

    @OneToOne(mappedBy = "parcelType")
    private ParcelEntity parcel;

    @Column(name = "rodzaj_przesylki")
    private String parcelType;
}
