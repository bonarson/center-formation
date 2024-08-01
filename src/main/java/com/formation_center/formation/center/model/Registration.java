package com.formation_center.formation.center.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Registration {
    private int idRegistration;
    private String dateRegistration;
    private String status;
    private String idUser;
    private int idCourse;
}
