package kg.alatoo.weatherwatch.services.sensor;

import kg.alatoo.weatherwatch.dto.SensorDto;

import java.util.List;

public interface SensorService {

    List<SensorDto> getAll();

    SensorDto create(SensorDto dto);

    SensorDto update(Long id, SensorDto dto);

    SensorDto get(Long id);

    boolean delete(Long id);
}
