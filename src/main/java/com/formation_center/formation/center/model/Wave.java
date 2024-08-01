package com.formation_center.formation.center.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Wave extends DateClass {
    private int idWave;
    private int idCourse;

    public Wave(int idWave, int idCourse, String startDate, String endDate) {
        super(startDate, endDate);
        this.idWave = idWave;
        this.idCourse = idCourse;
    }
}
