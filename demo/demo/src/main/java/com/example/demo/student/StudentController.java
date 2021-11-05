package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// This class is going to have all the resources for the API

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;

    // Using dependency injection to connect the StudentService to studentService automatically using spring.
    // So the StudentService class has to be a spring bean (to be instantiated).
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping // Used in registering new student to the database.
    public void registerNewStudent(@RequestBody Student student) { // Take the request and map it into student.
        studentService.addNewStudent(student);
    }

    // Delete by ID.
    // The ID will be provided as a path of the url, for instance, DELETE http ... student/1
    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }

    //Update students.
    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email
    ) {
        studentService.updateStudent(studentId, name, email);
    }
}
