package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

// Made for adding students to the database.
@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student muntaha = new Student(
                    "Muntaha",
                    "muntaha.islam0019@gmail.com",
                    LocalDate.of(1999, Month.JULY, 19),
                    22
            );

            Student sameha = new Student(
                    "Sameha",
                    "sameha.kamrul@gmail.com",
                    LocalDate.of(2000, Month.DECEMBER, 2),
                    22
            );

            repository.saveAll(
                    List.of(muntaha, sameha)
            );
        };
    }
}
