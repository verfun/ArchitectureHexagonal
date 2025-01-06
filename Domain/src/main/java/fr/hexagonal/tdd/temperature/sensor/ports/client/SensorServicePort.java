package fr.hexagonal.tdd.temperature.sensor.ports.client;

import fr.hexagonal.tdd.temperature.sensor.model.SensorRequest;
import fr.hexagonal.tdd.temperature.sensor.model.SensorState;

import java.util.Collection;
import java.util.List;

public interface SensorServicePort {
    double getTemperature();
    SensorState getSensorState(double temperature);

    List<SensorRequest> getHistory();
}
