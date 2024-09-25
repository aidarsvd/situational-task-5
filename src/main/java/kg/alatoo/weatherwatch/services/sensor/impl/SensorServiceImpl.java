package kg.alatoo.weatherwatch.services.sensor.impl;

import kg.alatoo.weatherwatch.dto.SensorDto;
import kg.alatoo.weatherwatch.entities.SensorEntity;
import kg.alatoo.weatherwatch.exceptions.ApiException;
import kg.alatoo.weatherwatch.repositories.SensorRepository;
import kg.alatoo.weatherwatch.services.sensor.SensorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SensorServiceImpl implements SensorService {

    private final SensorRepository sensorRepository;

    @Override
    public List<SensorDto> getAll() {
        return sensorRepository.findAll().stream().map(SensorDto::toDto).toList();
    }

    @Override
    public SensorDto get(Long id) {
        return SensorDto.toDto(sensorRepository.findById(id).orElseThrow(() -> new ApiException("Sensor " + id + " is not found", HttpStatusCode.valueOf(404))));
    }

    @Override
    public boolean delete(Long id) {
        sensorRepository.deleteById(id);
        return true;
    }

    @Override
    public SensorDto create(SensorDto dto) {
        log.info("Creating new sensor: {}", dto);
        SensorEntity sensor = new SensorEntity();
        sensor.setModel(dto.getModel());
        sensor.setType(dto.getType());
        sensor.setStatus(dto.getStatus());
        return SensorDto.toDto(sensorRepository.save(sensor));
    }

    @Override
    public SensorDto update(Long id, SensorDto dto) {
        SensorEntity sensor = sensorRepository.findById(id).orElseThrow(() -> new ApiException("Sensor " + id + " is not found", HttpStatusCode.valueOf(404)));
        if (dto.getModel() != null){
            sensor.setModel(dto.getModel());
        }
        if (dto.getType() != null){
            sensor.setType(dto.getType());
        }
        if (dto.getStatus() != null){
            sensor.setStatus(dto.getStatus());
        }
        return SensorDto.toDto(sensorRepository.save(sensor));
    }
}
