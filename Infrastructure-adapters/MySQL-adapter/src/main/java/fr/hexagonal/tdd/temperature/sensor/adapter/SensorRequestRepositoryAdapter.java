package fr.hexagonal.tdd.temperature.sensor.adapter;

import fr.hexagonal.tdd.temperature.sensor.entity.SensorRequestEntity;
import fr.hexagonal.tdd.temperature.sensor.mapper.SensorRequestMapper;
import fr.hexagonal.tdd.temperature.sensor.model.SensorRequest;
import fr.hexagonal.tdd.temperature.sensor.ports.infrastructure.SensorRequestRepositoryPort;
import fr.hexagonal.tdd.temperature.sensor.repository.SensorRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SensorRequestRepositoryAdapter implements SensorRequestRepositoryPort {

    private final SensorRequestRepository sensorRequestRepository;
    private final SensorRequestMapper sensorRequestMapper;

    @Override
    public void saveRequest(double temperature) {
        SensorRequestEntity sensorRequestEntity = sensorRequestMapper.mapToEntity(temperature, Optional.empty());
        sensorRequestRepository.save(sensorRequestEntity);
    }

    @Override
    public List<SensorRequest> getRequestHistory(Integer limit) {
        List<SensorRequestEntity> requestHistory = sensorRequestRepository.findLastCollection(limit);
        System.out.println(requestHistory.size());
        return sensorRequestMapper.mapToDomain(requestHistory);
    }
}
