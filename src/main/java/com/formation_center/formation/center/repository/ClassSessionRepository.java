package com.formation_center.formation.center.repository;

import com.formation_center.formation.center.model.ClassSession;
import com.formation_center.formation.center.model.TrainingCenter;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassSessionRepository {

    List<ClassSession> getAllClassSession();

    List<ClassSession> getClassSessionById(int id);

    void deleteClassSession(int id);

    void addClassSession(String message, ClassSession classSession);

    void updateClassSession(String message, String columnName, String value, int id);
}
