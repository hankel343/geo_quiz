package com.example.geoquizbackend.Quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuizController {

    @Autowired
    QuizRepository quizRepository;

    private String success = "{\"Quiz successfully saved!\":\"success\"}";
    private String failure = "{\"The provided quiz is null.\":\"success\"}";

    @GetMapping(path = "/quizzes")
    List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    @GetMapping(path = "/quizzes/{id}")
    Quiz getQuizById(@PathVariable long id) {
        return quizRepository.findById(id);
    }

    @PostMapping(path = "/quizzes")
    String createQuiz(@RequestBody Quiz quiz) {
        if (quiz == null) {
            return failure;
        }

        quizRepository.save(quiz);
        return success;
    }
}
