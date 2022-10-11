package hu.unideb.inf.orairest.Repository;

import hu.unideb.inf.orairest.Entities.AutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutoRepo extends JpaRepository<AutoEntity, Long> {
}
