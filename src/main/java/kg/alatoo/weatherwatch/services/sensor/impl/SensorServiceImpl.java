package kg.alatoo.weatherwatch.services.sensor.impl;

import kg.alatoo.weatherwatch.dto.SensorDto;
import kg.alatoo.weatherwatch.repositories.SensorRepository;
import kg.alatoo.weatherwatch.services.sensor.SensorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
}
