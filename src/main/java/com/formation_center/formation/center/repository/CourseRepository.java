package com.formation_center.formation.center.repository;


import com.formation_center.formation.center.model.Course;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository {
    List<String> getAllCourse();

    List<String> getCourseById(int id);

    void deleteCourse(int id);

    void addCourse(String message, Course course);

    void updateCourse(String message, String columnName, String value, int id);

}
