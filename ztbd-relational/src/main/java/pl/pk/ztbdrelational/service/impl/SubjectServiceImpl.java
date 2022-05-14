package pl.pk.ztbdrelational.service.impl;

import org.springframework.stereotype.Service;
import pl.pk.ztbdrelational.model.SubjectEntity;
import pl.pk.ztbdrelational.repository.SubjectRepository;
import pl.pk.ztbdrelational.service.SubjectService;

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
