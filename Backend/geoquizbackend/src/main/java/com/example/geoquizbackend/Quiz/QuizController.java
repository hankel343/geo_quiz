package com.example.geoquizbackend.Quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuizController {

    @Autowired
    QuizRepository quizRepository;

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
            return "Provided quiz is null.";
        }

        quizRepository.save(quiz);
        return "Quiz successfully saved.";
    }

    @PutMapping(path = "/quizzes/{id}")
    Quiz updateQuiz(@PathVariable long id, @RequestBody Quiz req) {
        Quiz q = quizRepository.findById(id);
        if (q == null) {
            return null;
        }
        quizRepository.save(req);
        return quizRepository.findById(id);
    }

    @DeleteMapping(path = "/quizzes/{id}")
    String deleteQuiz(@PathVariable long id) {
        quizRepository.deleteById(id);
        return "Quiz successfully deleted";
    }
}
