package com.example.geoquizbackend.User;

import com.example.geoquizbackend.Quiz.Quiz;
import com.example.geoquizbackend.User.User;
import com.example.geoquizbackend.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.Set;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/{id}/quizzes")
    public Set<Quiz> getQuizzesByUserId(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        return user != null ? user.get().getQuizzes() : null;
    }
}
