package com.formation_center.formation.center.endpoint;

import com.formation_center.formation.center.model.TrainingCenter;
import com.formation_center.formation.center.service.TrainingCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/training_center")
public class TrainingCenterController {

    private final TrainingCenterService trainingCenterService;

    @Autowired
    public TrainingCenterController(TrainingCenterService trainingCenterService) {
        this.trainingCenterService = trainingCenterService;
    }

    @GetMapping
    public List<TrainingCenter> getAllTrainingCenter() {
        return trainingCenterService.getAllTrainingCenter();
    }

    @GetMapping("/{id}")
    public List<TrainingCenter> getTrainingCenterById(@PathVariable int id) {
        return trainingCenterService.getTrainingCenterById(id);
    }

    @PostMapping
    public void addTrainingCenter(@RequestBody TrainingCenter trainingCenter) {
        String message = "New training center added";
        trainingCenterService.addTrainingCenter(message, trainingCenter);
    }

    @PutMapping("/{id}")
    public void updateTrainingCenter(
            @PathVariable int id,
            @RequestParam String columnName,
            @RequestParam String value) {
        String message = "Training center updated";
        trainingCenterService.updateTrainingCenter(message, columnName, value, id);
    }


    @DeleteMapping("/{id}")
    public void deleteTrainingCenter(@PathVariable int id) {
        trainingCenterService.deleteTrainingCenter(id);
    }
}
