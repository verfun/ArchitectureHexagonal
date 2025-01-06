package fr.hexagonal.tdd.temperature.sensor.starter.config;

import fr.hexagonal.tdd.temperature.sensor.adapter.SensorRequestRepositoryAdapter;
import fr.hexagonal.tdd.temperature.sensor.adapter.TemperatureCaptorAdapter;
import fr.hexagonal.tdd.temperature.sensor.mapper.SensorRequestMapper;
import fr.hexagonal.tdd.temperature.sensor.ports.client.SensorServicePort;
import fr.hexagonal.tdd.temperature.sensor.ports.infrastructure.SensorRequestRepositoryPort;
import fr.hexagonal.tdd.temperature.sensor.ports.infrastructure.TemperatureCaptorPort;
import fr.hexagonal.tdd.temperature.sensor.services.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public SensorServicePort sensorServicePort(TemperatureCaptorPort temperatureCaptorPort, SensorRequestRepositoryPort sensorRequestRepositoryPort) {
        return new SensorService(temperatureCaptorPort, sensorRequestRepositoryPort);
    }

}
