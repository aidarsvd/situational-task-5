package kg.alatoo.weatherwatch.services.alert.impl;

import kg.alatoo.weatherwatch.dto.AlertDto;
import kg.alatoo.weatherwatch.entities.AlertEntity;
import kg.alatoo.weatherwatch.entities.SensorEntity;
import kg.alatoo.weatherwatch.exceptions.ApiException;
import kg.alatoo.weatherwatch.repositories.AlertRepository;
import kg.alatoo.weatherwatch.repositories.SensorRepository;
import kg.alatoo.weatherwatch.services.alert.AlertService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AlertServiceImpl implements AlertService {

    private final AlertRepository alertRepository;
    private final SensorRepository sensorRepository;

    @Override
    public AlertDto createAlert(AlertDto alertDto) {
        SensorEntity sensor = sensorRepository.findById(alertDto.getSensorId()).orElseThrow(() -> new ApiException("Sensor " + alertDto.getSensorId() + " is not found", HttpStatusCode.valueOf(404)));
        AlertEntity alert = new AlertEntity();
        alert.setSensor(sensor);
        alert.setAlert(alertDto.getAlert());
        alert.setPriority(alertDto.getPriority());
        return AlertDto.toDto(alertRepository.save(alert));
    }

    @Override
    public List<AlertDto> getAll() {
        return alertRepository.findAll().stream().map(AlertDto::toDto).toList();
    }
}
