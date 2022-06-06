package pl.pk.ztbdrelational.service;

import pl.pk.ztbdrelational.dto.ResultDto;

public interface ReportService {
  ResultDto getParcelsBySubject();

  ResultDto getParcelsByCity();

  ResultDto getAmountToPayBySubject();
}
