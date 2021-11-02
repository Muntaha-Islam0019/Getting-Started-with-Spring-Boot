package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// We want it to work upon Student type, and the primary key for Student was id which was long
@Repository // As, this interface is responsible for data access from the database
public interface StudentRepository
        extends JpaRepository<Student, Long> {
// JPA repository has a bunch of methods that's useful

    // Search for students by email.
    // The following line is not SQL, it's JPQL. Here, Student is the class.
    @Query("SELECT s FROM Student s where s.email = ?1")
    Optional<Student> findStudentByEmail(String email);

}
