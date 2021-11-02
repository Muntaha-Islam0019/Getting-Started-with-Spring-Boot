package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Mainly responsible for the business logic.
// In simple words; this will help to transit data between API layer to data access from database layer.
// So basically, it's the service layer.

// Telling that this class has to service as a spring bean.
@Service // @Component works the same but Service is better because of semantics.
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        // For test.
        // System.out.println(student);

        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());

        // If new student has a email that is already in the database, this will trigger.
        // A better way of handling it would be a custom exception.
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("Email already taken!");
        }

        studentRepository.save(student);
    }
}
