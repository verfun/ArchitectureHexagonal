package fr.hexagonal.tdd.temperature.sensor.ports.infrastructure;


import fr.hexagonal.tdd.temperature.sensor.model.SensorRequest;

import java.util.List;

public interface SensorRequestRepositoryPort {
    void saveRequest(double temperature);
    List<SensorRequest> getRequestHistory(Integer limit);
}
