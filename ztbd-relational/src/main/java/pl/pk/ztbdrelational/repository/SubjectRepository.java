package pl.pk.ztbdrelational.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pk.ztbdrelational.model.SubjectEntity;

public interface SubjectRepository extends JpaRepository<SubjectEntity, Long> {
}
