package com.formation_center.formation.center.service;

import com.formation_center.formation.center.dao.DbConnection;
import com.formation_center.formation.center.function.FunctionUse;
import com.formation_center.formation.center.model.Wave;
import com.formation_center.formation.center.repository.WaveRepository;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.List;

@Service
public class WaveService implements WaveRepository {
    @Override
    public List<Wave> getAllWave() {
        DbConnection db = new DbConnection();
        Connection connection = db.ConnDb();
        FunctionUse functionUse = new FunctionUse();
        return functionUse.getAllWave(connection);

    }

    @Override
    public List<Wave> getWaveById(int id) {
        DbConnection db = new DbConnection();
        Connection connection = db.ConnDb();
        FunctionUse functionUse = new FunctionUse();
        return functionUse.getWaveById(connection, id);
    }

    @Override
    public void deleteWave(int id) {
        DbConnection db = new DbConnection();
        Connection connection = db.ConnDb();
        FunctionUse functionUse = new FunctionUse();
        functionUse.deleteWave(connection, id);
    }

    @Override
    public void addWave(String message, Wave wave) {
        DbConnection db = new DbConnection();
        Connection connection = db.ConnDb();
        FunctionUse functionUse = new FunctionUse();
        functionUse.addWave(connection, wave);
    }

    @Override
    public void updateWave(String message, String columnName, String value, int id) {
        DbConnection db = new DbConnection();
        Connection connection = db.ConnDb();
        FunctionUse functionUse = new FunctionUse();
        functionUse.updateWave(connection, columnName, value, id);
    }
}
