package com.formation_center.formation.center.service;


import com.formation_center.formation.center.dao.DbConnection;
import com.formation_center.formation.center.function.FunctionUse;
import com.formation_center.formation.center.model.ClassSession;
import com.formation_center.formation.center.model.TrainingCenter;
import com.formation_center.formation.center.repository.ClassSessionRepository;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.List;

@Service
public class ClassSessionService implements ClassSessionRepository {

    @Override
    public List<ClassSession> getAllClassSession() {
        DbConnection db = new DbConnection();
        Connection connection = db.ConnDb();
        FunctionUse functionUse = new FunctionUse();
        return functionUse.getAllClassSession(connection);
    }

    @Override
    public List<ClassSession> getClassSessionById(int id) {
        DbConnection db = new DbConnection();
        Connection connection = db.ConnDb();
        FunctionUse functionUse = new FunctionUse();
        return functionUse.getClassSessionById(connection, id);
    }

    @Override
    public void deleteClassSession(int id) {
        DbConnection db = new DbConnection();
        Connection connection = db.ConnDb();
        FunctionUse functionUse = new FunctionUse();
        functionUse.deleteClassSession(connection, id);
    }

    @Override
    public void addClassSession(String message, ClassSession classSession) {
        DbConnection db = new DbConnection();
        Connection connection = db.ConnDb();
        FunctionUse functionUse = new FunctionUse();
        functionUse.addClassSession(connection, classSession);
    }

    @Override
    public void updateClassSession(String message, String columnName, String value, int id) {
        DbConnection db = new DbConnection();
        Connection connection = db.ConnDb();
        FunctionUse functionUse = new FunctionUse();
        functionUse.updateClassSession(connection, columnName, value, id);
    }
}
