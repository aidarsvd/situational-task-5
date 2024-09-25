package kg.alatoo.weatherwatch.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import kg.alatoo.weatherwatch.entities.DataEntity;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DataDto {

    Long id;

    @NotEmpty
    String data;

    @NotNull
    Long sensorId;

    LocalDateTime dataReceiveDate;

    public static DataDto toDto(DataEntity entity){
        return DataDto.builder()
                .id(entity.getId())
                .data(entity.getData())
                .sensorId(entity.getSensor().getId())
                .dataReceiveDate(entity.getDataReceiveDate())
                .build();
    }

}
