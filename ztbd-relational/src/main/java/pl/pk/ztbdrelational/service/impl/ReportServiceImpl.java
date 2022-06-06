package pl.pk.ztbdrelational.service.impl;

import org.springframework.stereotype.Service;
import pl.pk.ztbdrelational.dto.ResultDto;
import pl.pk.ztbdrelational.projection.AmountToPayBySubjectView;
import pl.pk.ztbdrelational.projection.ParcelsByCityView;
import pl.pk.ztbdrelational.projection.ParcelsBySubjectView;
import pl.pk.ztbdrelational.repository.SubjectRepository;
import pl.pk.ztbdrelational.service.ReportService;

import java.util.List;

import static java.lang.System.currentTimeMillis;

@Service
public class ReportServiceImpl implements ReportService {

  private final SubjectRepository repository;

  public ReportServiceImpl(SubjectRepository repository) {
    this.repository = repository;
  }

  @Override
  public ResultDto getParcelsBySubject() {
    long start = currentTimeMillis();
    List<ParcelsBySubjectView> results = repository.getParcelsBySubject();
    long stop = currentTimeMillis();

    return new ResultDto(stop - start, results.size());
  }

  @Override
  public ResultDto getParcelsByCity() {
    long start = currentTimeMillis();
    List<ParcelsByCityView> results = repository.getParcelsByCity();
    long stop = currentTimeMillis();

    return new ResultDto(stop - start, results.size());
  }

  @Override
  public ResultDto getAmountToPayBySubject() {
    long start = currentTimeMillis();
    List<AmountToPayBySubjectView> results = repository.getAmountToPayBySubjectView();
    long stop = currentTimeMillis();
    System.out.println(results.get(0));

    return new ResultDto(stop - start, results.size());
  }
}