package com.example.geoquizbackend.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    private String success = "{\"Quiz successfully saved!\":\"success\"}";
    private String failure = "{\"The provided quiz is null.\":\"success\"}";

    @GetMapping(path = "/students")
    List<Student> getAllStudents() { return studentRepository.findAll(); }

    @GetMapping(path = "/students/{id}")
    Student getStudentById(@PathVariable long id) { return studentRepository.findById(id); }

    @PostMapping(path = "/students")
    String createStudent(@RequestBody Student student) {
        if (student == null) {
            return failure;
        }

        studentRepository.save(student);
        return success;
    }

}
