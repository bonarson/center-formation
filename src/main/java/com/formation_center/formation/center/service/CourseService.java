package com.formation_center.formation.center.service;

import com.formation_center.formation.center.dao.DbConnection;
import com.formation_center.formation.center.function.FunctionUse;
import com.formation_center.formation.center.model.Course;
import com.formation_center.formation.center.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.List;

@Service
public class CourseService implements CourseRepository {

    @Override
    public List<String> getAllCourse() {
        DbConnection db = new DbConnection();
        Connection connection = db.ConnDb();
        FunctionUse functionUse = new FunctionUse();
        return functionUse.getAllCourse(connection);
    }

    @Override
    public List<String> getCourseById(int id) {
        DbConnection db = new DbConnection();
        Connection connection = db.ConnDb();
        FunctionUse functionUse = new FunctionUse();
        return functionUse.getCourseById(connection, id);
    }

    @Override
    public void deleteCourse(int id) {
        DbConnection db = new DbConnection();
        Connection connection = db.ConnDb();
        FunctionUse functionUse = new FunctionUse();
        functionUse.deleteCourse(connection, id);

    }

    @Override
    public void addCourse(String message, Course course) {
        DbConnection db = new DbConnection();
        Connection connection = db.ConnDb();
        FunctionUse functionUse = new FunctionUse();
        functionUse.addCourse(connection, course);
    }

    @Override
    public void updateCourse(String message, String columnName, String value, int id) {
        DbConnection db = new DbConnection();
        Connection connection = db.ConnDb();
        FunctionUse functionUse = new FunctionUse();
        functionUse.updateCourse(connection, columnName, value, id);
    }
}
