package com.example.geoquizbackend.Professor;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfessorController {
    @Autowired
    ProfessorRepository professorRepository;
    @Operation(summary = "Get all professors", description = "Returns a list of all professors")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved")
    })
    @GetMapping(path = "/professors")
    List<Professor> getAllProfessors() { return professorRepository.findAll(); }
    @Operation(summary = "Get a professor by id", description = "Returns a professor as per the id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "Not found - The professor was not found")
    })
    @GetMapping(path = "/professors/{id}")
    Professor getProfessorById(@PathVariable long id) { return professorRepository.findById(id); }
    @Operation(summary = "Check if a professor exists by email", description = "Returns a boolean indicating whether a professor with the provided email exists")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved")
    })
    @GetMapping("/professors/exists")
    public ResponseEntity<Boolean> existsByEmail(@RequestParam String email) {
        boolean exists = professorRepository.existsByEmail(email);
        return ResponseEntity.ok(exists);
    }
    @Operation(summary = "Authenticate a professor", description = "Returns a professor if the provided email and password match a professor in the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "Not found - The professor was not found")
    })
    @GetMapping("/professors/authenticate")
    public ResponseEntity<Professor> authenticate(@RequestParam String email, @RequestParam String password) {
        Professor professor = professorRepository.findByEmailAndPassword(email, password);
        return ResponseEntity.ok(professor);
    }
    @Operation(summary = "Create a professor", description = "Creates a new professor and returns the created professor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully created"),
            @ApiResponse(responseCode = "400", description = "Bad request - The provided professor data is invalid")
    })
    @PostMapping(path = "/professors")
    ResponseEntity<Professor> createProfessor(@RequestBody Professor professor) {
        if (professor == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        try {
            Professor savedProfessor = professorRepository.save(professor);
            return new ResponseEntity<>(savedProfessor, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Operation(summary = "Update a professor", description = "Updates an existing professor and returns the updated professor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully updated"),
            @ApiResponse(responseCode = "400", description = "Bad request - The provided professor data is invalid"),
            @ApiResponse(responseCode = "404", description = "Not found - The professor was not found")
    })
    @PutMapping(path = "/professors/{id}")
    Professor updateProfessor(@PathVariable long id, @RequestBody Professor req) {
        Professor professor = professorRepository.findById(id);
        if (req == null) {
            return null;
        }

        professorRepository.save(req);
        return professorRepository.findById(id);
    }
    @Operation(summary = "Delete a professor", description = "Deletes a professor as per the id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully deleted"),
            @ApiResponse(responseCode = "404", description = "Not found - The professor was not found")
    })
    @DeleteMapping(path = "professors/{id}")
    String deleteProfessor(@PathVariable long id) {
        professorRepository.deleteById(id);
        return "Professor successfully deleted.";
    }
}
