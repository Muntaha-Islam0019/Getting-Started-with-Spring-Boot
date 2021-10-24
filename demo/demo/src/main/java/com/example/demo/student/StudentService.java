package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

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
