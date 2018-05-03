package com.example.school.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int year;

//    @OneToMany(mappedBy = "student")
//    private List<Grade> grades;




}
