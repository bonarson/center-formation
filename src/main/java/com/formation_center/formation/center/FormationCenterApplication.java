package com.formation_center.formation.center;

import com.formation_center.formation.center.dao.DbConnection;
import com.formation_center.formation.center.model.TrainingCenter;
import com.formation_center.formation.center.service.TrainingCenterService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FormationCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(FormationCenterApplication.class, args);


        DbConnection db = new DbConnection();
        db.ConnDb();

        TrainingCenter trainingCenter = new TrainingCenter(0, "bbcs",
                "klnksv", "kln", "lvd");

        TrainingCenterService trainingCenterService = new TrainingCenterService();

    }

}
