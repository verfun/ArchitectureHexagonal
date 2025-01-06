package fr.hexagonal.tdd.temperature.sensor.controllers;


import fr.hexagonal.tdd.temperature.sensor.dto.SensorRequestDto;
import fr.hexagonal.tdd.temperature.sensor.mapper.SensorRequestDtoMapper;
import fr.hexagonal.tdd.temperature.sensor.model.SensorRequest;
import fr.hexagonal.tdd.temperature.sensor.model.SensorState;
import fr.hexagonal.tdd.temperature.sensor.ports.client.SensorServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sensor")
@RequiredArgsConstructor
public class SensorController {

    private final SensorServicePort sensorServicePort;
    private final SensorRequestDtoMapper sensorRequestMapper;

    @GetMapping("/temperature")
    public ResponseEntity<Double> getTemperature() {
        double temperature = sensorServicePort.getTemperature();
        return ResponseEntity.ok(temperature);
    }

    @GetMapping("/state")
    public ResponseEntity<SensorState> getSensorState() {
        double temperature = sensorServicePort.getTemperature();
        SensorState state = sensorServicePort.getSensorState((temperature));
        return ResponseEntity.ok(state);
    }

    @GetMapping("/history")
    public ResponseEntity<List<SensorRequestDto>> getHistory() {
        List<SensorRequest> sensorRequestList = sensorServicePort.getHistory();
        return ResponseEntity.ok(sensorRequestMapper.mapToDtoList(sensorRequestList));
    }
}
