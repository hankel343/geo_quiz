package com.example.geoquizbackend.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    ResponseEntity<Student> createStudent(@RequestBody Student student) {
        if (student == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        try {
            Student savedStudent = studentRepository.save(student);
            return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
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
