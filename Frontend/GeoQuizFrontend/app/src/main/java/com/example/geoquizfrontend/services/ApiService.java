package com.example.geoquizfrontend.services;

import com.example.geoquizfrontend.models.Quiz;
import com.example.geoquizfrontend.models.GameData;
import com.example.geoquizfrontend.models.Professor;
import com.example.geoquizfrontend.models.QuizType;
import com.example.geoquizfrontend.models.Student;
import com.example.geoquizfrontend.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    // country data endpoints
    @GET("countries/gameData")
    Call<ArrayList<GameData>> GetGameData(@Query("count") int count);
    @GET("users/{id}/quizzes")
    Call<Set<Quiz>> getQuizzesByUserId(@Path("id") long id);
    // quiz endpoints
    @POST("quizzes")
    Call<Quiz> createQuiz(@Body Quiz newQuiz, @Query("userId") long userId);
    @POST("quizzes")
    Call<Quiz> PostCapitalQuizByBody(@Body Quiz newQuiz, @Query("userId") long userId);
    @GET("/quizzes/top/{n}")
    Call<List<Quiz>> GetLeaderboardScores(@Path("n") int n);
    @GET("/quizzes/top/{type}/{n}")
    Call<List<Quiz>> getTopNQuizzesByType(@Path("type") QuizType type, @Path("n") int n);
    @GET("quizzes/{id}/user")
    Call<User> getUserFromQuizId(@Path("id") long id);
    @GET("quizzes/{id}")
    Call<Quiz> GetCapitalQuizByPath(@Path("id") String id);
    // student endpoints
    @GET("/students/exists")
    Call<Boolean> studentExistsByEmail(@Query("email") String email);
    @GET("/students/authenticate")
    Call<Student> authenticate(@Query("email") String email, @Query("password") String password);
    @POST("/students")
    Call<Student> postNewStudent(@Body Student newStudent);
    // professor endpoints
    @POST("/professors")
    Call<Professor> postNewProfessor(@Body Professor newProfessor);
    @GET("/professors/authenticate")
    Call<Professor> authenticateProfessor(@Query("email") String email, @Query("password") String password);
    @GET("/professors/exists")
    Call<Boolean> professorExistsByEmail(@Query("email") String email);
}
