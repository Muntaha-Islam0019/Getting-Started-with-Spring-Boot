package com.example.demo.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service // @Component works the same but Service is better because of semantics
public class StudentService {

    public List<Student> getStudents() {
        return List.of(
                new Student(
                        1L,
                        "Muntaha",
                        "muntaha.islam0019@gmail.com",
                        LocalDate.of(1999, Month.JULY, 19),
                        22
                )
        );
    }
}
