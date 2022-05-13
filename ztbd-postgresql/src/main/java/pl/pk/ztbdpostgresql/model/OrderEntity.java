package pl.pk.ztbdpostgresql.model;

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
}
