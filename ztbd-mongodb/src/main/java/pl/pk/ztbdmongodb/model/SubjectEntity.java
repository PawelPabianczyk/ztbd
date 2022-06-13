package pl.pk.ztbdmongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document("podmiot")
public class SubjectEntity {
    @Id
    private String id;

    @Field("zlecenieIds")
    private List<String> orders;

    @Field("przesylkiIds")
    private List<String> parcels;

    @Field("adres")
    private AddressEntity address;

    @Field("nazwa")
    private String name;

    @Field("imie")
    private String firstName;

    @Field("nazwisko")
    private String surname;

    @Field("nip")
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
