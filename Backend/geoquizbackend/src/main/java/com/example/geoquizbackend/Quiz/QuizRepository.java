package com.example.geoquizbackend.Quiz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
    Quiz findById(long id);
    List<Quiz> findTopNByOrderByScoreDesc(int n);
    @Transactional
    void deleteById(long id);
}


