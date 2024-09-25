package kg.alatoo.weatherwatch.services.sensor;

import kg.alatoo.weatherwatch.dto.SensorDto;

import java.util.List;

public interface SensorService {

    List<SensorDto> getAll();

}
