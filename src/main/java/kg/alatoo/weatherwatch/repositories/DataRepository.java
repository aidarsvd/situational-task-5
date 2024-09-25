package kg.alatoo.weatherwatch.repositories;

import kg.alatoo.weatherwatch.entities.DataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataRepository extends JpaRepository<DataEntity, Long> {
}
