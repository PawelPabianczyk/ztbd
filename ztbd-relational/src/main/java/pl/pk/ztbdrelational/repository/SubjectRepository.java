package pl.pk.ztbdrelational.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.pk.ztbdrelational.model.SubjectEntity;
import pl.pk.ztbdrelational.projection.*;

import java.time.LocalDate;
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

  @Query(
      "SELECT NEW pl.pk.ztbdrelational.projection.NotDeliveredSentParcelsView(p.id,s.firstName, s.surname,p.parcelType,p.postingDate, ra.deliveryDate)"
          + "FROM ReceiptAckEntity ra "
          + "JOIN ra.parcel p "
          + "JOIN p.order o "
          + "JOIN o.subject s "
          + "WHERE p.postingDate <= :date AND ra.deliveryDate > :date")
  List<NotDeliveredSentParcelsView> getNotDeliveredSentParcelsView(LocalDate date);

  @Query(
      "SELECT NEW pl.pk.ztbdrelational.projection.ParcelsSentBetweenDatesByCityView(a.city, count(a))"
          + "FROM ParcelEntity p "
          + "JOIN p.order o "
          + "JOIN o.subject s "
          + "JOIN s.address a "
          + "WHERE p.postingDate > :after AND p.postingDate <= :before "
          + "GROUP BY a.city "
          + "ORDER BY count(a) DESC")
  List<ParcelsSentBetweenDatesByCityView> getParcelsSentBetweenDatesByCityView(
      LocalDate after, LocalDate before);

  @Query(
      "SELECT NEW pl.pk.ztbdrelational.projection.AmountPaidBySubjectView(s.firstName, s.surname, sum(sd.amount))"
          + "FROM ParcelEntity p "
          + "JOIN p.order o "
          + "JOIN o.salesDocument sd "
          + "JOIN o.subject s "
          + "WHERE p.postingDate > :after AND p.postingDate <= :before "
          + "GROUP BY s.id, s.firstName, s.surname "
          + "ORDER BY sum(sd.amount) DESC")
  List<AmountPaidBySubjectView> getAmountPaidBySubjectView(LocalDate after, LocalDate before);

  @Query(
      "SELECT NEW pl.pk.ztbdrelational.projection.MaxAmountBySubjectView(s.firstName, s.surname, max(sd.amount))"
          + "FROM ParcelEntity p "
          + "JOIN p.order o "
          + "JOIN o.salesDocument sd "
          + "JOIN o.subject s "
          + "GROUP BY s.id, s.firstName, s.surname "
          + "ORDER BY max(sd.amount) DESC")
  List<MaxAmountBySubjectView> getMaxAmountBySubjectView(LocalDate after, LocalDate before);
}
