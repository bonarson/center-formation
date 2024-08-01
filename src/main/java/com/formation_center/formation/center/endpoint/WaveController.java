package com.formation_center.formation.center.endpoint;

import com.formation_center.formation.center.model.Wave;
import com.formation_center.formation.center.service.WaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wave")
public class WaveController {
    private final WaveService waveService;

    @Autowired

    public WaveController(WaveService waveService) {
        this.waveService = waveService;
    }

    @GetMapping
    public List<Wave> getAllWave() {
        return waveService.getAllWave();
    }

    @GetMapping("/{id}")
    public List<Wave> getWaveById(@PathVariable int id) {
        return waveService.getWaveById(id);
    }

    @PostMapping
    public void addWave(@RequestBody Wave wave) {
        String message = "New wave added";
        waveService.addWave(message, wave);
    }

    @PutMapping("/{id}")
    public void updateWave(
            @PathVariable int id,
            @RequestParam String columnName,
            @RequestParam String value) {
        String message = "wave updated";
        waveService.updateWave(message, columnName, value, id);
    }


    @DeleteMapping("/{id}")
    public void deleteWave(@PathVariable int id) {
        waveService.deleteWave(id);
    }

}
