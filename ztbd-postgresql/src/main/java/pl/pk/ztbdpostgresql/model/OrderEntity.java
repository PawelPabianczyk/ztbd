package pl.pk.ztbdpostgresql.model;

import javax.persistence.*;

@Entity
@Table(name = "zlecenie")
public class OrderEntity {
    @Id
    private Long id;

    @OneToOne(mappedBy = "order")
    private SalesDocumentEntity salesDocument;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_id_przesylki", referencedColumnName = "id")
    private ParcelEntity parcel;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_id_adresu_placowki", referencedColumnName = "id")
    private AddressEntity address;

    @Column(name = "odleglosc_w_km")
    private Integer distance;

    @Column(name = "imie_odbiorcy")
    private String recipientFirstName;

    @Column(name = "nazwisko_odbiorcy")
    private String recipientSurname;
}
