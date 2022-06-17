package pl.pk.ztbdmongodb.service;

import pl.pk.ztbdmongodb.dto.ResultDto;

public interface ReportService {
  ResultDto getParcelsBySubject();

  ResultDto getParcelsByCity();

  ResultDto getAmountToPayBySubject();

  ResultDto getNotDeliveredSentParcels();
//
//  ResultDto getParcelsSentBetweenDatesByCity();
//
//  ResultDto getAmountPaidBySubject();
//
//  ResultDto getMaxAmountBySubject();
}
