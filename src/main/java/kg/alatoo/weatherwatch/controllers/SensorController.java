package kg.alatoo.weatherwatch.controllers;

import jakarta.validation.Valid;
import kg.alatoo.weatherwatch.dto.SensorDto;
import kg.alatoo.weatherwatch.dto.SuccessDto;
import kg.alatoo.weatherwatch.services.sensor.SensorService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sensor")
@RequiredArgsConstructor
@Validated
public class SensorController {

    private final SensorService sensorService;

    @GetMapping("/get-all")
    @PreAuthorize("hasAuthority('default')")
    public List<SensorDto> getAll() {
        return sensorService.getAll();
    }

    @GetMapping("/get/{id}")
    @PreAuthorize("hasAuthority('default')")
    public SensorDto get(@PathVariable Long id) {
        return sensorService.get(id);
    }

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('sensor.create')")
    public SensorDto create(@RequestBody @Valid SensorDto dto) {
        return sensorService.create(dto);
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasAuthority('sensor.update')")
    public SensorDto update(@PathVariable Long id, @RequestBody SensorDto dto) {
        return sensorService.update(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('sensor.delete')")
    public SuccessDto delete(@PathVariable Long id){
        return SuccessDto.builder().success(sensorService.delete(id)).build();
    }

}
