package com.formation_center.formation.center.repository;

import com.formation_center.formation.center.model.Course;
import com.formation_center.formation.center.model.Registration;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistrationRepository {
    List<Registration> getAllRegistration();

    List<Registration> getRegistrationById(int id);

    void deleteRegistration(int id);

    void addRegistration(String message, Registration registration);

    void updateRegistration(String message, String columnName, String value, int id);
}
