package kg.alatoo.weatherwatch.services.data;

import kg.alatoo.weatherwatch.dto.DataDto;

import java.util.List;

public interface DataService {

    List<DataDto> getAll();

    boolean uploadData(DataDto dataDto);

    boolean deleteData(Long id);
}
