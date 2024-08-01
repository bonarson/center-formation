package com.formation_center.formation.center.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Course extends DateClass {
    private int idCourse;
    private String title;
    private String description;
    private double price;
    private String schedules;
    private int idTrainingCenter;
    private int idClassSession;

    public Course(int idCourse, String title,
                  String description, double price,
                  String schedules, String startDate,
                  String endDate, int idTrainingCenter,
                  int idClassSession) {

        super(startDate, endDate);
        this.idCourse = idCourse;
        this.title = title;
        this.description = description;
        this.price = price;
        this.schedules = schedules;
        this.idTrainingCenter = idTrainingCenter;
        this.idClassSession = idClassSession;
    }
}
