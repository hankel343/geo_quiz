package com.example.geoquizbackend.Student;

import com.example.geoquizbackend.Quiz.Quiz;
import com.example.geoquizbackend.User.User;
import com.example.geoquizbackend.User.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    UserRepository userRepository;

    @Operation(summary = "Get all students", description = "Returns a list of all students")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved")
    })
    @GetMapping(path = "/students")
    List<Student> getAllStudents() { return studentRepository.findAll(); }
    @Operation(summary = "Get a student by id", description = "Returns a student as per the id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "Not found - The student was not found")
    })
    @GetMapping(path = "/students/{id}")
    Student getStudentById(@PathVariable long id) { return studentRepository.findById(id); }

    @Operation(summary = "Check if a student exists by email", description = "Returns a boolean indicating whether a student with the provided email exists")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved")
    })
    @GetMapping("/students/exists")
    public ResponseEntity<Boolean> existsByEmail(@RequestParam String email) {
        boolean exists = studentRepository.existsByEmail(email);
        return ResponseEntity.ok(exists);
    }
    @Operation(summary = "Authenticate a student", description = "Returns a student if the provided email and password match a student in the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "Not found - The student was not found")
    })
    @GetMapping("/students/authenticate")
    public ResponseEntity<Student> authenticate(@RequestParam String email, @RequestParam String password) {
        Student student = studentRepository.findByEmailAndPassword(email, password);
        return ResponseEntity.ok(student);
    }
    @Operation(summary = "Create a student", description = "Creates a new student and returns the created student")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully created"),
            @ApiResponse(responseCode = "400", description = "Bad request - The provided student data is invalid")
    })
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
    @Operation(summary = "Update a student", description = "Updates an existing student and returns the updated student")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully updated"),
            @ApiResponse(responseCode = "400", description = "Bad request - The provided student data is invalid"),
            @ApiResponse(responseCode = "404", description = "Not found - The student was not found")
    })
    @PutMapping(path = "/students/{id}")
    Student updateStudent(@PathVariable long id, @RequestBody Student req) {
        Student student = studentRepository.findById(id);
        if (req == null) {
            return null;
        }

        studentRepository.save(req);
        return studentRepository.findById(id);
    }
    @Operation(summary = "Delete a student", description = "Deletes a student as per the id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully deleted"),
            @ApiResponse(responseCode = "404", description = "Not found - The student was not found")
    })
    @DeleteMapping(path = "students/{id}")
    String deleteStudent(@PathVariable long id) {
        studentRepository.deleteById(id);
        return "Student successfully deleted.";
    }
}
