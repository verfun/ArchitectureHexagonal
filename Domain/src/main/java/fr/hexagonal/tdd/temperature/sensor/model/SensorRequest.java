package fr.hexagonal.tdd.temperature.sensor.model;

import java.time.LocalDateTime;
import java.util.UUID;

public record SensorRequest(UUID id,
                            String data,
                            String origin,
                            LocalDateTime date) {

    public SensorRequest(String data, String origin, LocalDateTime date) {
        this(null, data, origin, date);
    }
}
