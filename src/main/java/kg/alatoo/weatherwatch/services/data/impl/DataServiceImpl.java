package kg.alatoo.weatherwatch.services.data.impl;

import kg.alatoo.weatherwatch.dto.DataDto;
import kg.alatoo.weatherwatch.entities.DataEntity;
import kg.alatoo.weatherwatch.entities.SensorEntity;
import kg.alatoo.weatherwatch.exceptions.ApiException;
import kg.alatoo.weatherwatch.repositories.DataRepository;
import kg.alatoo.weatherwatch.repositories.SensorRepository;
import kg.alatoo.weatherwatch.services.data.DataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class DataServiceImpl implements DataService {

    private final DataRepository dataRepository;
    private final SensorRepository sensorRepository;

    @Override
    public List<DataDto> getAll() {
        return dataRepository.findAll().stream().map(DataDto::toDto).toList();
    }

    @Override
    public boolean uploadData(DataDto dataDto) {
        SensorEntity sensor = sensorRepository.findById(dataDto.getSensorId()).orElseThrow(() -> new ApiException("Sensor " + dataDto.getSensorId() + " is not found", HttpStatusCode.valueOf(404)));
        DataEntity data = new DataEntity();
        data.setSensor(sensor);
        data.setData(dataDto.getData());
        dataRepository.save(data);
        return true;
    }

    @Override
    public boolean deleteData(Long id) {
        dataRepository.deleteById(id);
        return true;
    }
}
