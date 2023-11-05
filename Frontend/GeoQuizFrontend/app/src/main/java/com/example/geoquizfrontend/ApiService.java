package com.example.geoquizfrontend;

import com.example.geoquizfrontend.models.Quiz;
import com.example.geoquizfrontend.models.GameData;
import com.example.geoquizfrontend.models.Professor;
import com.example.geoquizfrontend.models.Student;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    // country data endpoints
    @GET("countries/gameData")
    Call<ArrayList<GameData>> GetGameData(@Query("count") int count);
    // quiz endpoints
    @PUT("quizzes/{id}")
    Call<Quiz> PutCapitalQuizByPath(@Path("id") int id, @Body Quiz newQuiz);
    @POST("quizzes")
    Call<Quiz> PostCapitalQuizByBody(@Body Quiz newQuiz);
    @GET("quizzes/{id}")
    Call<Quiz> GetCapitalQuizByPath(@Path("id") String id);
    // student endpoints
    @GET("/students/exists")
    Call<Boolean> existsByEmail(@Query("email") String email);
    @GET("/students/authenticate")
    Call<Student> authenticate(@Query("email") String email, @Query("password") String password);
    @POST("/students")
    Call<Student> postNewStudent(@Body Student newStudent);
    // professor endpoints
    @POST("/professors")
    Call<Professor> postNewProfessor(@Body Professor newProfessor);

}
