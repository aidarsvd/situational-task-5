package kg.alatoo.weatherwatch.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Table(name = "ww_sensor_datas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    SensorEntity sensor;

    @Column(columnDefinition = "TEXT")
    String data;

    LocalDateTime dataReceiveDate;

    @PrePersist
    private void init() {
        this.dataReceiveDate = LocalDateTime.now();
    }

}
