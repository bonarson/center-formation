package com.formation_center.formation.center.repository;

import com.formation_center.formation.center.model.Wave;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WaveRepository {
    List<Wave> getAllWave();

    List<Wave> getWaveById(int id);

    void deleteWave(int id);

    void addWave(String message, Wave wave);

    void updateWave(String message, String columnName, String value, int id);

}
