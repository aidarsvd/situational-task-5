package kg.alatoo.weatherwatch.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import kg.alatoo.weatherwatch.entities.AlertEntity;
import kg.alatoo.weatherwatch.enums.AlertPriority;
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
public class AlertDto {

    Long id;

    @NotEmpty
    String alert;

    @NotNull
    AlertPriority priority;

    LocalDateTime alertDate;

    @NotNull
    Long sensorId;

    public static AlertDto toDto(AlertEntity entity) {
        return AlertDto.builder()
                .id(entity.getId())
                .alert(entity.getAlert())
                .priority(entity.getPriority())
                .alertDate(entity.getAlertDate())
                .sensorId(entity.getSensor().getId())
                .build();
    }

}
