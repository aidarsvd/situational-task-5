package kg.alatoo.weatherwatch.services.alert;

import kg.alatoo.weatherwatch.dto.AlertDto;

import java.util.List;

public interface AlertService {
    AlertDto createAlert(AlertDto alertDto);

    List<AlertDto> getAll();

}
