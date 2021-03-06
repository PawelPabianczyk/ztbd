package pl.pk.ztbdrelational.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "podmiot")
public class SubjectEntity {

    @Id
    private Long id;

    @OneToMany(mappedBy = "subject")
    private Set<OrderEntity> orders;

    @OneToMany(mappedBy = "addressee")
    private Set<ParcelEntity> parcels;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adres_id")
    private AddressEntity address;

    @Column(name = "nazwa")
    private String name;

    @Column(name = "imie")
    private String firstName;

    @Column(name = "nazwisko")
    private String surname;

    @Column(name = "nip")
    private String taxIdentifier;

    @Override
    public String toString() {
        return "SubjectEntity{" +
                "id=" + id +
                ", orders=" + orders +
                ", parcels=" + parcels +
                ", address=" + address +
                ", name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", taxIdentifier='" + taxIdentifier + '\'' +
                '}';
    }
}
