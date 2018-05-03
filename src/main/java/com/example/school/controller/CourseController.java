package com.example.school.controller;


import com.example.school.model.Course;
import com.example.school.repository.CourseRepository;
import com.example.school.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rooms")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/")
    public Iterable<Course> getGrades(){
        return courseRepository.findAll();
    }

    @GetMapping("addgrade/{course}/{grade}/{id}")
    public Course addCourse(@PathVariable String name ) {
        Course course = new Course();
        course.setName(name);
        return courseRepository.save(course);
    }

}
