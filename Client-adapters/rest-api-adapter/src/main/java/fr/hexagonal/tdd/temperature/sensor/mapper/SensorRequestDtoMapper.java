package fr.hexagonal.tdd.temperature.sensor.mapper;

import fr.hexagonal.tdd.temperature.sensor.dto.SensorRequestDto;
import fr.hexagonal.tdd.temperature.sensor.model.SensorRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SensorRequestDtoMapper {
    public List<SensorRequestDto> mapToDtoList(List<SensorRequest> sensorRequests) {
        return sensorRequests.stream()
                .map(this::mapToDto)
                .toList();
    }

    private SensorRequestDto mapToDto(SensorRequest sensorRequest) {
        return SensorRequestDto.builder()
                .temperature(sensorRequest.data())
                .origin(sensorRequest.origin())
                .build();
    }
}
