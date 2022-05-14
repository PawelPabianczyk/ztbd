package pl.pk.ztbdmongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("adres")
public class AddressEntity {
    @Id
    private Long id;

    @Field("miasto")
    private String city;

    @Field("kod_pocztowy")
    private String postalCode;

    @Field("ulica")
    private String street;

    @Field("nr_budynku")
    private String buildingNumber;

    @Field("nr_lokalu")
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
