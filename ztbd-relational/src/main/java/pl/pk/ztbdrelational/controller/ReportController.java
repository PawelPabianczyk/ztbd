package pl.pk.ztbdrelational.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pk.ztbdrelational.dto.ResultDto;
import pl.pk.ztbdrelational.service.ReportService;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("reports")
public class ReportController {

  private final ReportService service;

  public ReportController(ReportService service) {
    this.service = service;
  }

  @GetMapping("/1")
  public ResponseEntity<ResultDto> getParcelsBySubject() {
    return ok(service.getParcelsBySubject());
  }

  @GetMapping("/2")
  public ResponseEntity<ResultDto> getParcelsByCity() {
    return ok(service.getParcelsByCity());
  }

  @GetMapping("/3")
  public ResponseEntity<ResultDto> getAmountToPayBySubject() {
    return ok(service.getAmountToPayBySubject());
  }

  @GetMapping("/4")
  public ResponseEntity<ResultDto> getNotDeliveredSentParcels() {
    return ok(service.getNotDeliveredSentParcels());
  }

  @GetMapping("/5")
  public ResponseEntity<ResultDto> getParcelsSentBetweenDatesByCity() {
    return ok(service.getParcelsSentBetweenDatesByCity());
  }

  @GetMapping("/6")
  public ResponseEntity<ResultDto> getAmountPaidBySubject() {
    return ok(service.getAmountPaidBySubject());
  }
}
