package com.formation_center.formation.center.service;

import com.formation_center.formation.center.dao.DbConnection;
import com.formation_center.formation.center.function.FunctionUse;
import com.formation_center.formation.center.model.TrainingCenter;
import com.formation_center.formation.center.repository.TrainingCenterRepository;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.List;

@Service
public class TrainingCenterService implements TrainingCenterRepository {

    @Override
    public List<TrainingCenter> getAllTrainingCenter() {
        DbConnection db = new DbConnection();
        Connection connection = db.ConnDb();
        FunctionUse functionUse = new FunctionUse();
        return functionUse.getAllTrainingCenter(connection);
    }

    @Override
    public List<TrainingCenter> getTrainingCenterById(int id) {
        DbConnection db = new DbConnection();
        Connection connection = db.ConnDb();
        FunctionUse functionUse = new FunctionUse();
        return functionUse.getTrainingCenterById(connection, id);
    }

    @Override
    public void deleteTrainingCenter(int id) {
        DbConnection db = new DbConnection();
        Connection connection = db.ConnDb();
        FunctionUse functionUse = new FunctionUse();
        functionUse.deleteTrainingCenter(connection, id);
    }

    @Override
    public void addTrainingCenter(String message, TrainingCenter trainingCenter) {
        DbConnection db = new DbConnection();
        Connection connection = db.ConnDb();
        FunctionUse functionUse = new FunctionUse();
        functionUse.addTrainingCenter(connection, trainingCenter);
    }

    @Override
    public void updateTrainingCenter(String message, String columnName, String value, int id) {
        DbConnection db = new DbConnection();
        Connection connection = db.ConnDb();
        FunctionUse functionUse = new FunctionUse();
        functionUse.updateTrainingCenter(connection, columnName, value, id);
    }


}
