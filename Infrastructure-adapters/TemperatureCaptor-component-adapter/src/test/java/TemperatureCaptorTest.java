import fr.hexagonal.tdd.temperature.sensor.adapter.TemperatureCaptorAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TemperatureCaptorTest {

    @InjectMocks
    TemperatureCaptorAdapter sensorService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void should_return_value_of_temperature_degree() {
        var result = sensorService.getTemperature();
        assertTrue(!Double.isNaN(result), "The result should not be NaN");
        assertTrue(!Double.isInfinite(result));
    }

    @Test
    void should_return_valid_temperature_Celsius_degree_for_human() {
        var temperature = sensorService.getTemperature();
        double minTemperature = -100.0; // Minimum valid range
        double maxTemperature = 100.0; // Maximum valid range

        // Assert that the temperature is within the range
        assertTrue(temperature >= minTemperature && temperature <= maxTemperature,
                "Temperature " + temperature + "°C is out of the valid range ("
                        + minTemperature + "°C to " + maxTemperature + "°C)");
    }
}
