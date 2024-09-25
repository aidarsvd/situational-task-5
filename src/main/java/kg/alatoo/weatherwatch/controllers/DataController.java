package kg.alatoo.weatherwatch.controllers;

import jakarta.validation.Valid;
import kg.alatoo.weatherwatch.dto.DataDto;
import kg.alatoo.weatherwatch.dto.SuccessDto;
import kg.alatoo.weatherwatch.services.data.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/data")
@RequiredArgsConstructor
public class DataController {

    private final DataService dataService;

    @GetMapping("/get-all")
    public List<DataDto> getAll(){
        return dataService.getAll();
    }
    @PostMapping("/upload-data")
    public SuccessDto uploadData(@Valid @RequestBody DataDto dataDto) {
        return SuccessDto.builder().success(dataService.uploadData(dataDto)).build();
    }

    @DeleteMapping("/delete/{id}")
    public SuccessDto delete(@PathVariable Long id){
        return SuccessDto.builder().success(dataService.deleteData(id)).build();
    }

}
