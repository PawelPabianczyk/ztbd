package pl.pk.ztbdpostgresql.model;

import javax.persistence.*;

@Entity
@Table(name = "adres")
public class AddressEntity {
    @Id
    private Long id;

    @OneToOne(mappedBy = "address")
    private SubjectEntity subject;

    @Column(name = "miasto")
    private String city;

    @Column(name = "kod_pocztowy")
    private String postalCode;

    @Column(name = "ulica")
    private String street;

    @Column(name = "nr_budynku")
    private String buildingNumber;

    @Column(name = "nr_lokalu")
    private String apartmentNumber;

}
