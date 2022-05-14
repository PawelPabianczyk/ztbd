package pl.pk.ztbdrelational.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "zlecenie")
public class OrderEntity {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "nadawca_id")
    private SubjectEntity subject;

    @OneToMany(mappedBy = "order")
    private Set<ParcelEntity> parcels;

    @OneToOne(mappedBy = "order")
    private SalesDocumentEntity salesDocument;

    @Override
    public String toString() {
        return "OrderEntity{" +
                "id=" + id +
                ", parcels=" + parcels +
                ", salesDocument=" + salesDocument +
                '}';
    }
}
