package com.example.geoquizbackend.Professor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
public interface ProfessorRepository {

    Professor findById(long id);

    @Transactional
    void deleteById(long id);
}
