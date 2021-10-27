package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// We want it to work upon Student type, and the primary key for Student was id which was long
@Repository // As, this interface is responsible for data access
public interface StudentRepository
        extends JpaRepository<Student, Long> {
// JPA repository has a bunch of methods that's useful

}
