package com.example.school.controller;


import com.example.school.model.Teacher;
import com.example.school.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {

    @Autowired
    private TeacherRepository teacherRepository;


    @GetMapping("/")
    public Iterable<Teacher> getTeachers() {
        return teacherRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Teacher> getStudentById(@PathVariable int id) {
        if (teacherRepository.findById(id).isPresent()) {
            return teacherRepository.findById(id);
        } else {
            return null;
        }
    }



}



