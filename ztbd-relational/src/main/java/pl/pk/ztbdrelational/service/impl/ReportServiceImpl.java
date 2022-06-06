package pl.pk.ztbdrelational.service.impl;

import org.springframework.stereotype.Service;
import pl.pk.ztbdrelational.dto.ResponseDto;
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
  public ResponseDto getParcelsBySubject() {
    long start = currentTimeMillis();
//    long numOfRecords = repository.getParcelsBySubject().size();
    List<ParcelsBySubjectView> results = repository.getParcelsBySubject();
    System.out.println(results.get(0));
    long stop = currentTimeMillis();

    return new ResponseDto(stop - start, results.size());
  }

  @Override
  public ResponseDto getParcelsByCity() {
    long start = currentTimeMillis();
//    long numOfRecords = repository.getParcelsByCity().size();
    List<ParcelsByCityView> results = repository.getParcelsByCity();
    long stop = currentTimeMillis();
    System.out.println(results.get(0));

    return new ResponseDto(stop - start, results.size());
  }
}
