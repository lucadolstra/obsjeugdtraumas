package com.example.school.controller;

        import com.example.school.model.Grade;
        import com.example.school.model.Student;
        import com.example.school.repository.GradeRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/grades")
public class GradeController {

    @Autowired
    private GradeRepository gradeRepository;

    @GetMapping("/")
    public Iterable<Grade> getGrades(){
        return gradeRepository.findAll();
    }

    @GetMapping("addgrade/{course}/{grade}/{id}")
    public Grade addGrade(  @PathVariable int grade) {
        Grade gr = new Grade();
        //gr.setCourse(course);
        gr.setGrade(grade);
        //gr.setStudent(student);
        return gradeRepository.save(gr);
    }

}
