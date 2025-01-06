package fr.hexagonal.tdd.temperature.sensor.repository;

import fr.hexagonal.tdd.temperature.sensor.entity.SensorRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface SensorRequestRepository extends JpaRepository<SensorRequestEntity, UUID> {
    @Query(value = "SELECT * FROM sensor_request ORDER BY date DESC LIMIT :limit", nativeQuery = true)
    List<SensorRequestEntity> findLastCollection(@Param("limit") Integer limit);
}
