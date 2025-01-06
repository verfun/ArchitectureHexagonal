package usecases;

import fr.hexagonal.tdd.temperature.sensor.model.SensorState;
import fr.hexagonal.tdd.temperature.sensor.ports.infrastructure.SensorRequestRepositoryPort;
import fr.hexagonal.tdd.temperature.sensor.ports.infrastructure.TemperatureCaptorPort;
import fr.hexagonal.tdd.temperature.sensor.services.SensorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetTemperatureDergeeUseCaseTest {

    @Mock
    TemperatureCaptorPort temperatureCaptorPort;
    @Mock
    SensorRequestRepositoryPort sensorRequestRepositoryPort;

    @InjectMocks
    SensorService sensorService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @ParameterizedTest
    @ValueSource(doubles = {40, 40.23, 54.2, 77})
    void should_sensor_have_HOT_state(double temperature) {
        var state = sensorService.getSensorState(temperature);
        assertEquals(SensorState.HOT, state, "The sensor should have a HOT state");
    }

    @ParameterizedTest
    @ValueSource(doubles = {-40.23, -0.12, 21})
    void should_sensor_have_COLD_state(double temperature) {
        var state = sensorService.getSensorState(temperature);
        assertEquals(SensorState.COLD, state, "The sensor should have a COLD state");
    }

    @ParameterizedTest
    @ValueSource(doubles = {22, 33, 38.1})
    void should_sensor_have_WARM_state(double temperature) {
        var state = sensorService.getSensorState(temperature);
        assertEquals(SensorState.WARM, state, "The sensor should have a WARM state");
    }

    @Test
    void should_return_last_15_request_value_from_history() {
        // TODO remove ths test to the API rest
        IntStream.range(1,30).forEach(i -> sensorService.getTemperature());
        assertEquals(15, sensorService.getHistory().size());
    }
}
