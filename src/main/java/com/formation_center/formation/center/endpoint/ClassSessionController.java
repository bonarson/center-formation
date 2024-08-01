package com.formation_center.formation.center.endpoint;

import com.formation_center.formation.center.model.ClassSession;
import com.formation_center.formation.center.model.TrainingCenter;
import com.formation_center.formation.center.service.ClassSessionService;
import com.formation_center.formation.center.service.TrainingCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/class_session")
public class ClassSessionController {
    private final ClassSessionService classSessionService;

    @Autowired
    public ClassSessionController(ClassSessionService classSessionService) {
        this.classSessionService = classSessionService;
    }

    @GetMapping
    public List<ClassSession> getAllClassSession() {
        return classSessionService.getAllClassSession();
    }

    @GetMapping("/{id}")
    public List<ClassSession> getClassSessionById(@PathVariable int id) {
        return classSessionService.getClassSessionById(id);
    }

    @PostMapping
    public void addClassSession(@RequestBody ClassSession classSession) {
        String message = "New classSession added";
        classSessionService.addClassSession(message, classSession);
    }

    @PutMapping("/{id}")
    public void updateClassSession(
            @PathVariable int id,
            @RequestParam String columnName,
            @RequestParam String value) {
        String message = "class session updated";
        classSessionService.updateClassSession(message, columnName, value, id);
    }

    @DeleteMapping("/{id}")
    public void deleteClassSession(@PathVariable int id) {
        classSessionService.deleteClassSession(id);
    }
}
