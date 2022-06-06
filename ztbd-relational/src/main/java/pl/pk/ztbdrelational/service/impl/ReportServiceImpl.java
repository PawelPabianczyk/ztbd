package pl.pk.ztbdrelational.service.impl;

import org.springframework.stereotype.Service;
import pl.pk.ztbdrelational.dto.ResponseDto;
import pl.pk.ztbdrelational.repository.SubjectRepository;
import pl.pk.ztbdrelational.service.ReportService;

import static java.lang.System.currentTimeMillis;

@Service
public class ReportServiceImpl implements ReportService {

  private final SubjectRepository repository;

  public ReportServiceImpl(SubjectRepository repository) {
    this.repository = repository;
  }

  @Override
  public ResponseDto getNumberOfParcelsForEverySubject() {

    long start = currentTimeMillis();
    long numOfRecords = repository.getNumberOfParcelsForEverySubject().size();
    long stop = currentTimeMillis();

    return new ResponseDto(stop - start, numOfRecords);
  }
}
