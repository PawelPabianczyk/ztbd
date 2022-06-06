package pl.pk.ztbdrelational.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.pk.ztbdrelational.model.SubjectEntity;
import pl.pk.ztbdrelational.projection.NumberOfParcelsView;

import java.util.List;

public interface SubjectRepository extends JpaRepository<SubjectEntity, Long> {

  @Query(
      "SELECT NEW pl.pk.ztbdrelational.projection.NumberOfParcelsView(s.firstName, s.surname, count(s))"
          + "FROM ParcelEntity p "
          + "JOIN p.order o "
          + "JOIN o.subject s GROUP BY s.id, s.firstName, s.surname "
          + "ORDER BY count(s) DESC")
  List<NumberOfParcelsView> getNumberOfParcelsForEverySubject();
}
