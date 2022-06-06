package pl.pk.ztbdrelational.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pk.ztbdrelational.dto.ResponseDto;
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
  public ResponseEntity<ResponseDto> getParcelsBySubject() {
    return ok(service.getParcelsBySubject());
  }

  @GetMapping("/2")
  public ResponseEntity<ResponseDto> getParcelsByCity() {
    return ok(service.getParcelsByCity());
  }
}
