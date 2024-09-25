package kg.alatoo.weatherwatch.repositories;

import kg.alatoo.weatherwatch.entities.SensorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorRepository extends JpaRepository<SensorEntity, Long> {
}
