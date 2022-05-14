package pl.pk.ztbdrelational.model;


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


    @Override
    public String toString() {
        return "AddressEntity{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", street='" + street + '\'' +
                ", buildingNumber='" + buildingNumber + '\'' +
                ", apartmentNumber='" + apartmentNumber + '\'' +
                '}';
    }
}
