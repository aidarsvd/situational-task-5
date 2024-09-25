package kg.alatoo.weatherwatch.controllers;

import jakarta.validation.Valid;
import kg.alatoo.weatherwatch.dto.SensorDto;
import kg.alatoo.weatherwatch.services.sensor.SensorService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sensor")
@RequiredArgsConstructor
public class SensorController {

    private final SensorService sensorService;

    @GetMapping("/get-all")
    @PreAuthorize("hasAuthority('default')")
    public List<SensorDto> getAll() {
        return sensorService.getAll();
    }

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('sensor.create')")
    public SensorDto create(@Valid @RequestBody SensorDto dto) {
        return sensorService.create(dto);
    }


}
