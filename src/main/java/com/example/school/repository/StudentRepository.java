package com.example.school.repository;

        import com.example.school.model.Student;
        import org.springframework.data.repository.CrudRepository;
        import org.springframework.stereotype.Repository;

@Repository //isn't necessary
public interface StudentRepository extends CrudRepository<Student, Integer> {

    Iterable<Student> findAllByYearGreaterThan(int year);
}



