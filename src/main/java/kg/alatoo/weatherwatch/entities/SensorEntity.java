package kg.alatoo.weatherwatch.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Table(name = "ww_sensors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SensorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String model;

    String type;

    LocalDateTime installationDate;

    String status;

    LocalDateTime modifiedAt;

    @PrePersist
    private void init() {
        this.installationDate = LocalDateTime.now();
    }

    @PreUpdate
    private void preUpdate() {
        this.modifiedAt = LocalDateTime.now();
    }

}
