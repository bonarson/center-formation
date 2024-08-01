package com.formation_center.formation.center.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class ClassSession {
    private int id;
    private String dateSession;
    private String hour;
    private String subject;
    private String idTeacher;


}
