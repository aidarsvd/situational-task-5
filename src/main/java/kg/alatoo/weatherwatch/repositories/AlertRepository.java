package kg.alatoo.weatherwatch.repositories;

import kg.alatoo.weatherwatch.entities.AlertEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertRepository extends JpaRepository<AlertEntity, Long> {
}
