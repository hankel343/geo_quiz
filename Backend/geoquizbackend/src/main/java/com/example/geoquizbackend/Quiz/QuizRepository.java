package com.example.geoquizbackend.Quiz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
    Quiz findByQuizId(int id);

    @Transactional
    void deleteByQuizId(int id);
}


