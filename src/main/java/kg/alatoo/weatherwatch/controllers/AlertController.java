package kg.alatoo.weatherwatch.controllers;

import jakarta.validation.Valid;
import kg.alatoo.weatherwatch.dto.AlertDto;
import kg.alatoo.weatherwatch.services.alert.AlertService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alert")
@RequiredArgsConstructor
public class AlertController {

    private final AlertService alertService;

    @PostMapping("/create")
    public AlertDto create(@Valid @RequestBody AlertDto alertDto) {
        return alertService.createAlert(alertDto);
    }

    @GetMapping("/get-alerts")
    public List<AlertDto> getAll(){
        return alertService.getAll();
    }

}
