package com.example.geoquizbackend.Quiz;

import com.example.geoquizbackend.Enums.QuizType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
    Quiz findById(long id);
    List<Quiz> findAllByOrderByScoreDesc();
    Page<Quiz> findAllByTypeOrderByScoreDesc(QuizType type, Pageable pageable);
    @Transactional
    void deleteById(long id);
}


