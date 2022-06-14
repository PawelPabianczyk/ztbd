package pl.pk.ztbdmongodb.service.impl;

import com.mongodb.client.model.Field;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import pl.pk.ztbdmongodb.dto.ResultDto;
import pl.pk.ztbdmongodb.service.ReportService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mongodb.client.model.Accumulators.sum;
import static com.mongodb.client.model.Aggregates.addFields;
import static com.mongodb.client.model.Aggregates.*;
import static com.mongodb.client.model.Indexes.descending;
import static com.mongodb.client.model.Projections.*;
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
    Bson addFieldsStage = addFields(new Field<>("arrSize", new Document("$size", "$przesylkiIds")));
    Bson sortStage = sort(descending("arrSize"));
    List<Bson> pipeline = List.of(addFieldsStage, sortStage);
    List<Document> results = new ArrayList<>();
    mongoTemplate.getCollection("podmiot").aggregate(pipeline).into(results);
    long stop = currentTimeMillis();

    return new ResultDto(stop - start, results.size());
  }

  @Override
  public ResultDto getParcelsByCity() {
    long start = currentTimeMillis();
    Bson group =
        group("$adres.miasto", sum("liczbaPrzesylek", new Document("$size", "$przesylkiIds")));
    Bson sortStage = sort(descending("liczbaPrzesylek"));
    List<Bson> pipeline = List.of(group, sortStage);
    List<Document> results = new ArrayList<>();
    mongoTemplate.getCollection("podmiot").aggregate(pipeline).into(results);

    long stop = currentTimeMillis();

    return new ResultDto(stop - start, results.size());
  }
  //
  //  @Override
  //  public ResultDto getAmountToPayBySubject() {
  //    long start = currentTimeMillis();
  //    List<AmountToPayBySubjectView> results = repository.getAmountToPayBySubjectView();
  //    long stop = currentTimeMillis();
  //    System.out.println(results.get(0));
  //
  //    return new ResultDto(stop - start, results.size());
  //  }
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
