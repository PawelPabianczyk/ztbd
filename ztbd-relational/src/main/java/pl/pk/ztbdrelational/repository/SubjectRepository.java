package pl.pk.ztbdrelational.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.pk.ztbdrelational.model.SubjectEntity;
import pl.pk.ztbdrelational.projection.AmountToPayBySubjectView;
import pl.pk.ztbdrelational.projection.ParcelsByCityView;
import pl.pk.ztbdrelational.projection.ParcelsBySubjectView;

import java.util.List;

public interface SubjectRepository extends JpaRepository<SubjectEntity, Long> {

  @Query(
      "SELECT NEW pl.pk.ztbdrelational.projection.ParcelsBySubjectView(s.firstName, s.surname, count(s))"
          + "FROM ParcelEntity p "
          + "JOIN p.order o "
          + "JOIN o.subject s GROUP BY s.id, s.firstName, s.surname "
          + "ORDER BY count(s) DESC")
  List<ParcelsBySubjectView> getParcelsBySubject();

  @Query(
      "SELECT NEW pl.pk.ztbdrelational.projection.ParcelsByCityView(a.city, count(a))"
          + "FROM ParcelEntity p "
          + "JOIN p.order o "
          + "JOIN o.subject s "
          + "JOIN s.address a GROUP BY a.city "
          + "ORDER BY count(a) DESC")
  List<ParcelsByCityView> getParcelsByCity();

  @Query(
      "SELECT NEW pl.pk.ztbdrelational.projection.AmountToPayBySubjectView(s.firstName, s.surname, sum(sd.amount))"
          + "FROM OrderEntity o "
          + "JOIN o.subject s "
          + "JOIN o.salesDocument sd "
          + "JOIN sd.payment p "
          + "WHERE p.isPaid = false "
          + "GROUP BY s.id, s.firstName, s.surname "
          + "ORDER BY sum(sd.amount) ")
  List<AmountToPayBySubjectView> getAmountToPayBySubjectView();
}
