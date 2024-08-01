package com.formation_center.formation.center.service;

import com.formation_center.formation.center.dao.DbConnection;
import com.formation_center.formation.center.function.FunctionUse;
import com.formation_center.formation.center.model.Registration;
import com.formation_center.formation.center.repository.RegistrationRepository;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.List;

@Service
public class RegistrationService implements RegistrationRepository {

    @Override
    public List<Registration> getAllRegistration() {
        DbConnection db = new DbConnection();
        Connection connection = db.ConnDb();
        FunctionUse functionUse = new FunctionUse();
        return functionUse.getAllRegistration(connection);
    }

    @Override
    public List<Registration> getRegistrationById(int id) {
        DbConnection db = new DbConnection();
        Connection connection = db.ConnDb();
        FunctionUse functionUse = new FunctionUse();
        return functionUse.getRegistrationById(connection, id);
    }

    @Override
    public void deleteRegistration(int id) {
        DbConnection db = new DbConnection();
        Connection connection = db.ConnDb();
        FunctionUse functionUse = new FunctionUse();
        functionUse.deleteRegistration(connection, id);
    }

    @Override
    public void addRegistration(String message, Registration registration) {
        DbConnection db = new DbConnection();
        Connection connection = db.ConnDb();
        FunctionUse functionUse = new FunctionUse();
        functionUse.addRegistration(connection, registration);
    }

    @Override
    public void updateRegistration(String message, String columnName, String value, int id) {
        DbConnection db = new DbConnection();
        Connection connection = db.ConnDb();
        FunctionUse functionUse = new FunctionUse();
        functionUse.updateRegistration(connection, columnName, value, id);
    }
}
