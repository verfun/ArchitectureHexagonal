package fr.hexagonal.tdd.temperature.sensor.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "sensor_request")
@NoArgsConstructor
public class SensorRequestEntity {
    @Id
    @GeneratedValue
    private UUID id;
    private String data;
    private String origin;
    private LocalDateTime date;

    public SensorRequestEntity(double temperature, LocalDateTime date, String origin) {
        this.data = String.valueOf(temperature);
        this.date = date;
        this.origin = origin;
    }
}
