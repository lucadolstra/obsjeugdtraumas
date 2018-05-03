package com.example.school.model;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class Grade  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name= "";
    private int grade;

    @ManyToOne
    @JoinColumn(name="studentId")
    private Student student;

}
