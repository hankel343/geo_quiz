package com.example.geoquizbackend.Professor;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    Professor findById(long id);
    Professor findByEmail(String email);
    boolean existsByEmail(String email);
    Professor findByEmailAndPassword(String email, String password);
    @Transactional
    void deleteById(long id);
}
