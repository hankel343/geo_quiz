package com.example.geoquizbackend.Quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
    @GetMapping(path = "/quizzes/top/{n}")
    List<Quiz> getTopNQuizzes(@PathVariable int n) {
        return quizRepository.findAllByOrderByScoreDesc().stream()
                .limit(n)
                .collect(Collectors.toList());
    }
    @PostMapping(path = "/quizzes")
    @ResponseBody
    public Quiz createQuiz(@RequestBody Quiz quiz) {
        if (quiz == null) {
            throw new IllegalArgumentException("Provided quiz is null.");
        }

        return quizRepository.save(quiz);
    }
    @PutMapping(path = "/quizzes/{id}")
    Quiz updateQuiz(@PathVariable long id, @RequestBody Quiz req) {
        Quiz q = quizRepository.findById(id);
        if (q == null) {
            return null;
        }

        q.setScore(req.getScore());
        q.setDuration(req.getDuration());
        quizRepository.save(q);

        return quizRepository.findById(id);
    }
    @DeleteMapping(path = "/quizzes/{id}")
    String deleteQuiz(@PathVariable long id) {
        quizRepository.deleteById(id);
        return "Quiz successfully deleted";
    }
}
