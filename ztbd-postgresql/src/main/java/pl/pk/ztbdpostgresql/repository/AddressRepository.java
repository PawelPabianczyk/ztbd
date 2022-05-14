package pl.pk.ztbdpostgresql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pk.ztbdpostgresql.model.AddressEntity;

public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
}
