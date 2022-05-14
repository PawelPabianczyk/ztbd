package pl.pk.ztbdrelational.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pk.ztbdrelational.model.AddressEntity;

public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
}
