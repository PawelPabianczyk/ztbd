package pl.pk.ztbdpostgresql.service.impl;

import org.springframework.stereotype.Service;
import pl.pk.ztbdpostgresql.model.SubjectEntity;
import pl.pk.ztbdpostgresql.repository.SubjectRepository;
import pl.pk.ztbdpostgresql.service.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository repository;

    public SubjectServiceImpl(SubjectRepository repository) {
        this.repository = repository;
    }

    @Override
    public SubjectEntity getSubject(Long id) {
        return repository.getById(id);
    }
}
