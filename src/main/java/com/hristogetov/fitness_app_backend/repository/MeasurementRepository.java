package com.hristogetov.fitness_app_backend.repository;

import com.hristogetov.fitness_app_backend.entity.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasurementRepository extends JpaRepository<Measurement, Long> {
}
