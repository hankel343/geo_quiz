package com.example.geoquizbackend.Professor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfessorController {
    @Autowired
    ProfessorRepository professorRepository;
    @GetMapping(path = "/professors")
    List<Professor> getAllProfessors() { return professorRepository.findAll(); }
    @GetMapping(path = "/professors/{id}")
    Professor getProfessorById(@PathVariable long id) { return professorRepository.findById(id); }

    @GetMapping("/professors/exists")
    public ResponseEntity<Boolean> existsByEmail(@RequestParam String email) {
        boolean exists = professorRepository.existsByEmail(email);
        return ResponseEntity.ok(exists);
    }
    @GetMapping("/professors/authenticate")
    public ResponseEntity<Professor> authenticate(@RequestParam String email, @RequestParam String password) {
        Professor professor = professorRepository.findByEmailAndPassword(email, password);
        return ResponseEntity.ok(professor);
    }
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
    @PutMapping(path = "/professors/{id}")
    Professor updateProfessor(@PathVariable long id, @RequestBody Professor req) {
        Professor professor = professorRepository.findById(id);
        if (req == null) {
            return null;
        }

        professorRepository.save(req);
        return professorRepository.findById(id);
    }
    @DeleteMapping(path = "professors/{id}")
    String deleteProfessor(@PathVariable long id) {
        professorRepository.deleteById(id);
        return "Professor successfully deleted.";
    }
}
