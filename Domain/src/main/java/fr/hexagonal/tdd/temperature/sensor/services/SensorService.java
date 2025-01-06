package fr.hexagonal.tdd.temperature.sensor.services;

import fr.hexagonal.tdd.temperature.sensor.model.SensorRequest;
import fr.hexagonal.tdd.temperature.sensor.ports.client.SensorServicePort;
import fr.hexagonal.tdd.temperature.sensor.ports.infrastructure.SensorRequestRepositoryPort;
import fr.hexagonal.tdd.temperature.sensor.ports.infrastructure.TemperatureCaptorPort;
import fr.hexagonal.tdd.temperature.sensor.model.SensorState;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class SensorService implements SensorServicePort {

    private final TemperatureCaptorPort temperatureCaptorPort;
    private final SensorRequestRepositoryPort sensorRequestRepositoryPort;

    @Override
    public double getTemperature() {
        var temperature = temperatureCaptorPort.getTemperature();
        addHistory(temperature);
        return temperature;
    }

    private void addHistory(double temperature) {
        sensorRequestRepositoryPort.saveRequest(temperature);
    }

    @Override
    public SensorState getSensorState(double temperature) {
        //
        if(temperature>=40)
            return SensorState.HOT;
        if(temperature < 22)
            return SensorState.COLD;
        return SensorState.WARM;
    }

    @Override
    public List<SensorRequest> getHistory() {
        return sensorRequestRepositoryPort.getRequestHistory(15);
    }
}
