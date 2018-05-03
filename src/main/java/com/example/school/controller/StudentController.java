package com.example.school.controller;

import com.example.school.model.Student;
import com.example.school.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;


    @GetMapping("/all")
    public Iterable<Student> getStudent() {
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable int id) {
        if (studentRepository.findById(id).isPresent()) {
            return studentRepository.findById(id);
        } else {
            return null;
        }
    }

    @GetMapping("/add/{name}/{year}")
    public Student addStudent(@PathVariable String name, @PathVariable int year) {
        Student student = new Student();
        student.setName(name);
        student.setYear(year);
        return studentRepository.save(student);
    }

    @GetMapping("update/{id}/{name}/{year}")
    public Student addStudent(@PathVariable int id, @PathVariable String name, @PathVariable int year) {
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setYear(year);

        return studentRepository.save(student);
    }

    @GetMapping("/above/{year}")
    public Iterable<Student> getAllStudentsAboveYear(@PathVariable int year) {
        return studentRepository.findAllByYearGreaterThan(year);
    }


}
