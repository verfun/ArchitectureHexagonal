package fr.hexagonal.tdd.temperature.sensor.mapper;

import fr.hexagonal.tdd.temperature.sensor.entity.SensorRequestEntity;
import fr.hexagonal.tdd.temperature.sensor.model.SensorRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class SensorRequestMapper {
    public SensorRequestEntity mapToEntity(double temperature, Optional<String> origin) {
        return new SensorRequestEntity(temperature, LocalDateTime.now(), origin.orElse("/temperature"));
    }

    public List<SensorRequest> mapToDomain(List<SensorRequestEntity> requestEntities) {
        return requestEntities.stream()
                .map(this::mapToDomain)
                .toList();
    }

    private SensorRequest mapToDomain(SensorRequestEntity requestEntity) {
        return new SensorRequest(requestEntity.getData(), requestEntity.getOrigin(), requestEntity.getDate());
    }
}
