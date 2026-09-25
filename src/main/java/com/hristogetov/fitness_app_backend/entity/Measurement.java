package com.hristogetov.fitness_app_backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.security.MessageDigest;

@Entity
public class Measurement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long dateMillis;

    private Double weightKg;

    private Double chestCm;

    private Double waistCm;

    private String note;

    protected Measurement() {
    }

    public Measurement(Long dateMillis, Double weightKg, Double chestCm, Double waistCm, String note) {
        this.dateMillis = dateMillis;
        this.weightKg = weightKg;
        this.chestCm = chestCm;
        this.waistCm = waistCm;
        this.note = note;
    }



    public Long getId() {
        return id;
    }

    public Long getDateMillis() {
        return dateMillis;
    }

    public void setDateMillis(Long dateMillis) {
        this.dateMillis = dateMillis;
    }

    public Double getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(Double weightKg) {
        this.weightKg = weightKg;
    }

    public Double getChestCm() {
        return chestCm;
    }

    public void setChestCm(Double chestCm) {
        this.chestCm = chestCm;
    }

    public Double getWaistCm() {
        return waistCm;
    }

    public void setWaistCm(Double waistCm) {
        this.waistCm = waistCm;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
