package kg.alatoo.weatherwatch.controllers;

import kg.alatoo.weatherwatch.dto.SensorDto;
import kg.alatoo.weatherwatch.services.sensor.SensorService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
