package com.hristogetov.fitness_app_backend.controller;

import com.hristogetov.fitness_app_backend.entity.Measurement;
import com.hristogetov.fitness_app_backend.repository.MeasurementRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/measurements")
public class MeasurementController {

    private final MeasurementRepository measurementRepository;

    public MeasurementController(MeasurementRepository measurementRepository){
        this.measurementRepository = measurementRepository;
    }

    @GetMapping
    public List<Measurement> getAllMeasurements(){
        return measurementRepository.findAll();
    }

    @PostMapping
    public Measurement createMeasurement(@RequestBody Measurement measurement){
        return measurementRepository.save(measurement);
    }


    @DeleteMapping("/{id}")
    public void deleteMeasurement(@PathVariable Long id){
        measurementRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Measurement updateMeasurement(
            @PathVariable Long id,
            @RequestBody Measurement measurement
    ){
        Measurement existingMeasurement =measurementRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Measurement not found"
                        ));
        existingMeasurement.setDateMillis(measurement.getDateMillis());
        existingMeasurement.setWeightKg(measurement.getWeightKg());
        existingMeasurement.setChestCm(measurement.getChestCm());
        existingMeasurement.setWaistCm(measurement.getWaistCm());
        existingMeasurement. setNote(measurement.getNote());

        return measurementRepository.save(existingMeasurement);
    }
}
