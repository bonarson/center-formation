package com.formation_center.formation.center.repository;

import com.formation_center.formation.center.model.TrainingCenter;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingCenterRepository {
    List<TrainingCenter> getAllTrainingCenter();

    List<TrainingCenter> getTrainingCenterById(int id);

    void deleteTrainingCenter(int id);

    void addTrainingCenter(String message, TrainingCenter trainingCenter);

    void updateTrainingCenter(String message, String columnName, String value, int id);

}
