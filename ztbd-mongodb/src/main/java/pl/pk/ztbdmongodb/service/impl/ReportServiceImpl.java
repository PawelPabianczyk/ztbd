package pl.pk.ztbdmongodb.service.impl;

import com.mongodb.client.model.Field;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import pl.pk.ztbdmongodb.dto.ResultDto;
import pl.pk.ztbdmongodb.service.ReportService;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Accumulators.sum;
import static com.mongodb.client.model.Aggregates.*;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Indexes.descending;
import static java.lang.System.currentTimeMillis;

@Service
public class ReportServiceImpl implements ReportService {

  private final MongoTemplate mongoTemplate;

  public ReportServiceImpl(MongoTemplate mongoTemplate) {
    this.mongoTemplate = mongoTemplate;
  }

  @Override
  public ResultDto getParcelsBySubject() {
    long start = currentTimeMillis();
    List<Document> results = new ArrayList<>();
    mongoTemplate
        .getCollection("podmiot")
        .aggregate(
            List.of(
                addFields(new Field<>("arrSize", new Document("$size", "$przesylkiIds"))),
                sort(descending("arrSize"))))
        .into(results);
    long stop = currentTimeMillis();
    return new ResultDto(stop - start, results.size());
  }

  @Override
  public ResultDto getParcelsByCity() {
    long start = currentTimeMillis();
    List<Document> results = new ArrayList<>();
    mongoTemplate
        .getCollection("podmiot")
        .aggregate(
            List.of(
                group(
                    "$adres.miasto",
                    sum("liczbaPrzesylek", new Document("$size", "$przesylkiIds"))),
                sort(descending("liczbaPrzesylek"))))
        .into(results);
    long stop = currentTimeMillis();
    return new ResultDto(stop - start, results.size());
  }

  @Override
  public ResultDto getAmountToPayBySubject() {
    long start = currentTimeMillis();
    List<Document> results = new ArrayList<>();
    mongoTemplate
        .getCollection("zlecenie")
        .aggregate(
            List.of(
                match(eq("faktura.oplata.czy_zaplacono", "1")),
                group("$nadawcaId", sum("suma", "$faktura.kwota")),
                sort(descending("suma"))))
        .into(results);
    long stop = currentTimeMillis();
    return new ResultDto(stop - start, results.size());
  }
  //
  //  @Override
  //  public ResultDto getNotDeliveredSentParcels() {
  //    long start = currentTimeMillis();
  //    List<NotDeliveredSentParcelsView> results =
  //        repository.getNotDeliveredSentParcelsView(LocalDate.now());
  //    long stop = currentTimeMillis();
  //
  //    return new ResultDto(stop - start, results.size());
  //  }
  //
  //  @Override
  //  public ResultDto getParcelsSentBetweenDatesByCity() {
  //    long start = currentTimeMillis();
  //    List<ParcelsSentBetweenDatesByCityView> results =
  //        repository.getParcelsSentBetweenDatesByCityView(
  //            LocalDate.now().minusYears(1), LocalDate.now());
  //    long stop = currentTimeMillis();
  //
  //    return new ResultDto(stop - start, results.size());
  //  }
  //
  //  @Override
  //  public ResultDto getAmountPaidBySubject() {
  //    long start = currentTimeMillis();
  //    List<AmountPaidBySubjectView> results =
  //        repository.getAmountPaidBySubjectView(
  //            LocalDate.now().minusYears(1), LocalDate.now());
  //    long stop = currentTimeMillis();
  //
  //    return new ResultDto(stop - start, results.size());
  //  }
  //
  //  @Override
  //  public ResultDto getMaxAmountBySubject() {
  //    long start = currentTimeMillis();
  //    List<MaxAmountBySubjectView> results =
  //        repository.getMaxAmountBySubjectView(
  //            LocalDate.now().minusYears(1), LocalDate.now());
  //    long stop = currentTimeMillis();
  //
  //    return new ResultDto(stop - start, results.size());
  //  }
}
