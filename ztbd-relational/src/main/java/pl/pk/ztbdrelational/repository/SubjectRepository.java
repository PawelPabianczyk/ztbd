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

  /**
   * SELECT pod.imie, pod.nazwisko, SUM(f.kwota) AS “suma” FROM faktura f JOIN zlecenie z ON
   * f.zlecenie_id = z.id JOIN podmiot pod ON z.nadawca_id = pod.id JOIN przesylka p ON z.id =
   * p.zlecenie_id WHERE p.data_nadania >= “2021-01-01” AND p.data_nadania <= “2022-01-01” GROUP BY
   * pod.id ORDER BY “suma” DESC;
   */
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
}
