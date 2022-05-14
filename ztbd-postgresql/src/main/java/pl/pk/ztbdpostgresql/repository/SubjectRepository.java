package pl.pk.ztbdpostgresql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pk.ztbdpostgresql.model.SubjectEntity;

public interface SubjectRepository extends JpaRepository<SubjectEntity, Long> {
}
