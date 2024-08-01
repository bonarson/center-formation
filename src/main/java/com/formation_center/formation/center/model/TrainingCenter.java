package com.formation_center.formation.center.model;

import com.formation_center.formation.center.dao.DbConnection;
import com.formation_center.formation.center.function.FunctionUse;
import com.formation_center.formation.center.repository.TrainingCenterRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.List;

@AllArgsConstructor
@Getter
@ToString

public class TrainingCenter {

    private int idTrainingCenter;
    private String name;
    private String address;
    private String contactDetails;
    private String equipment;

}
