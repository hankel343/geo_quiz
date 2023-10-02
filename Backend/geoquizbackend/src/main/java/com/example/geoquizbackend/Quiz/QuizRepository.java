package com.example.geoquizbackend.Quiz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
    Quiz findById(int id);



    @Transactional
    void deleteById(int id);
}


