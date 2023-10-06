package com.example.geoquizbackend.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping(path = "/students")
    List<Student> getAllStudents() { return studentRepository.findAll(); }

    @GetMapping(path = "/students/{id}")
    Student getStudentById(@PathVariable long id) { return studentRepository.findById(id); }

    @PostMapping(path = "/students")
    String createStudent(@RequestBody Student student) {
        if (student == null) {
            return "Provided student is null.";
        }

        studentRepository.save(student);
        return "Student successfully saved!";
    }

    @PutMapping(path = "/students/{id}")
    Student updateStudent(@PathVariable long id, @RequestBody Student req) {
        Student student = studentRepository.findById(id);
        if (req == null) {
            return null;
        }

        studentRepository.save(req);
        return studentRepository.findById(id);
    }

    @DeleteMapping(path = "students/{id}")
    String deleteStudent(@PathVariable long id) {
        studentRepository.deleteById(id);
        return "Student successfully deleted.";
    }
}
