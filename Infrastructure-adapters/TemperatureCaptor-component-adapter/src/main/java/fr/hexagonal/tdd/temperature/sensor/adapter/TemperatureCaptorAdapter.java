package fr.hexagonal.tdd.temperature.sensor.adapter;

import fr.hexagonal.tdd.temperature.sensor.ports.infrastructure.TemperatureCaptorPort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class TemperatureCaptorAdapter implements TemperatureCaptorPort {
    @Override
    public double getTemperature() {
        // Simuler une température aléatoire
        return Math.random() * 50;
    }
}
