package pl.pk.ztbdrelational.service;

import pl.pk.ztbdrelational.dto.ResponseDto;

public interface ReportService {
  ResponseDto getParcelsBySubject();

  ResponseDto getParcelsByCity();
}
