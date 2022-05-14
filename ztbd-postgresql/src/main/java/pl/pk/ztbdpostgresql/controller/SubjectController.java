package pl.pk.ztbdpostgresql.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pk.ztbdpostgresql.service.SubjectService;

import static org.springframework.http.ResponseEntity.ok;


@RestController
@RequestMapping("subjects")
public class SubjectController {

    private final SubjectService service;

    public SubjectController(SubjectService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getSubject(@PathVariable Long id) {
        return ok(service.getSubject(id).toString());
    }
}
