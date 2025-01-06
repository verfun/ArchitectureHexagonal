package fr.hexagonal.tdd.temperature.sensor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "fr.hexagonal.tdd.temperature.sensor")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
