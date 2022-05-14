package pl.pk.ztbdpostgresql.model;

import com.opencsv.bean.CsvBindByName;

import javax.persistence.*;

@Entity
@Table(name = "adres")
public class AddressEntity {
    @Id
    @CsvBindByName
    private Long id;

    @OneToOne(mappedBy = "address")
    private SubjectEntity subject;

    @Column(name = "miasto")
    @CsvBindByName(column = "miasto")
    private String city;

    @Column(name = "kod_pocztowy")
    @CsvBindByName(column = "kod_pocztowy")
    private String postalCode;

    @Column(name = "ulica")
    @CsvBindByName(column = "ulica")
    private String street;

    @Column(name = "nr_budynku")
    @CsvBindByName(column = "nr_budynku")
    private String buildingNumber;

    @Column(name = "nr_lokalu")
    @CsvBindByName(column = "nr_lokalu")
    private String apartmentNumber;

}
