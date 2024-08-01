package com.formation_center.formation.center.endpoint;


import com.formation_center.formation.center.model.Course;
import com.formation_center.formation.center.model.TrainingCenter;
import com.formation_center.formation.center.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    private final CourseService courseService;

    @Autowired

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<String> getAllCourse() {
        return courseService.getAllCourse();
    }

    @GetMapping("/{id}")
    public List<String> getCourseById(@PathVariable int id) {
        return courseService.getCourseById(id);
    }

    @PostMapping
    public void addCourse(@RequestBody Course course) {
        String message = "New course added";
        courseService.addCourse(message, course);
    }

    @PutMapping("/{id}")
    public void updateCourse(
            @PathVariable int id,
            @RequestParam String columnName,
            @RequestParam String value) {
        String message = "course updated";
        courseService.updateCourse(message, columnName, value, id);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable int id) {
        courseService.deleteCourse(id);
    }
}
