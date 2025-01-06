package fr.hexagonal.tdd.temperature.sensor.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record SensorRequestDto(@JsonProperty("temperature") String temperature, @JsonProperty("origin") String origin) {
}
