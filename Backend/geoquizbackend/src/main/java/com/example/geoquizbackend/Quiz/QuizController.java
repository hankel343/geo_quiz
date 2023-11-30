package com.example.geoquizbackend.Quiz;

import com.example.geoquizbackend.Student.Student;
import com.example.geoquizbackend.Student.StudentRepository;
import com.example.geoquizbackend.User.User;
import com.example.geoquizbackend.User.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Autowired
    UserRepository userRepository;
    @Operation(summary = "Get all quizzes", description = "Returns a list of all quizzes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved")
    })
    @GetMapping(path = "/quizzes")
    List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }
    @Operation(summary = "Get a quiz by id", description = "Returns a quiz as per the id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "Not found - The quiz was not found")
    })
    @GetMapping(path = "/quizzes/{id}")
    Quiz getQuizById(@PathVariable long id) {
        return quizRepository.findById(id);
    }
    @Operation(summary = "Get top N quizzes", description = "Returns a list of the top N quizzes by score")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved")
    })
    @GetMapping(path = "/quizzes/top/{n}")
    List<Quiz> getTopNQuizzes(@PathVariable int n) {
        return quizRepository.findAllByOrderByScoreDesc().stream()
                .limit(n)
                .collect(Collectors.toList());
    }
    @Operation(summary = "Create a quiz", description = "Creates a new quiz and returns the created quiz")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully created"),
            @ApiResponse(responseCode = "400", description = "Bad request - The provided quiz data is invalid")
    })
    @PostMapping(path = "/quizzes")
    @ResponseBody
    public Quiz createQuiz(@RequestBody Quiz quiz, @RequestParam long userId) {
        if (quiz == null) {
            throw new IllegalArgumentException("Provided quiz is null.");
        }

        User user = userRepository.findById(userId);
        if (user == null) {
            throw new IllegalArgumentException("Student not found");
        }

        quiz.setUser(user);
        return quizRepository.save(quiz);
    }
    @Operation(summary = "Update a quiz", description = "Updates an existing quiz and returns the updated quiz")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully updated"),
            @ApiResponse(responseCode = "400", description = "Bad request - The provided quiz data is invalid"),
            @ApiResponse(responseCode = "404", description = "Not found - The quiz was not found")
    })
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
    @Operation(summary = "Delete a quiz", description = "Deletes a quiz as per the id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully deleted"),
            @ApiResponse(responseCode = "404", description = "Not found - The quiz was not found")
    })
    @DeleteMapping(path = "/quizzes/{id}")
    String deleteQuiz(@PathVariable long id) {
        quizRepository.deleteById(id);
        return "Quiz successfully deleted";
    }
}
