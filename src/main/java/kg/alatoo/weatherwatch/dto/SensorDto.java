package kg.alatoo.weatherwatch.dto;

import jakarta.validation.constraints.NotEmpty;
import kg.alatoo.weatherwatch.entities.SensorEntity;
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
public class SensorDto {

    Long id;

    @NotEmpty
    String model;

    @NotEmpty
    String type;

    @NotEmpty
    String status;

    LocalDateTime installationDate;

    LocalDateTime modifiedAt;

    public static SensorDto toDto(SensorEntity e) {
        return SensorDto.builder()
                .id(e.getId())
                .model(e.getModel())
                .type(e.getType())
                .status(e.getStatus())
                .installationDate(e.getInstallationDate())
                .modifiedAt(e.getModifiedAt())
                .build();
    }

}
