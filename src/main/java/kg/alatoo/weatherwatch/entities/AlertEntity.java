package kg.alatoo.weatherwatch.entities;

import jakarta.persistence.*;
import kg.alatoo.weatherwatch.enums.AlertPriority;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Table(name = "ww_alerts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AlertEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(columnDefinition = "TEXT")
    String alert;

    @ManyToOne
    SensorEntity sensor;

    @Enumerated(EnumType.STRING)
    AlertPriority priority;

    LocalDateTime alertDate;

    @PrePersist
    private void init() {
        this.alertDate = LocalDateTime.now();
    }

}
