package com.formation_center.formation.center.endpoint;

import com.formation_center.formation.center.model.Registration;
import com.formation_center.formation.center.model.TrainingCenter;
import com.formation_center.formation.center.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

    private final RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping
    public List<Registration> getAllRegistration() {
        return registrationService.getAllRegistration();
    }

    @GetMapping("/{id}")
    public List<Registration> getRegistrationById(@PathVariable int id) {
        return registrationService.getRegistrationById(id);
    }

    @PostMapping
    public void addRegistration(@RequestBody Registration registration) {
        String message = "New registration added";
        registrationService.addRegistration(message, registration);
    }

    @PutMapping("/{id}")
    public void updateRegistration(
            @PathVariable int id,
            @RequestParam String columnName,
            @RequestParam String value) {
        String message = "registration updated";
        registrationService.updateRegistration(message, columnName, value, id);
    }


    @DeleteMapping("/{id}")
    public void deleteRegistration(@PathVariable int id) {
        registrationService.deleteRegistration(id);
    }
}
