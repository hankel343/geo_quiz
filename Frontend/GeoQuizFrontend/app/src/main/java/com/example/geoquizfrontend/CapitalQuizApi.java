package com.example.geoquizfrontend;

import com.example.geoquizfrontend.models.CapitalQuiz;
import com.example.geoquizfrontend.models.GameData;
import com.example.geoquizfrontend.models.Student;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CapitalQuizApi {
    // country data endpoints
    @GET("countries/gameData")
    Call<ArrayList<GameData>> GetGameData(@Query("count") int count);
    // quiz endpoints
    @PUT("quizzes/{id}")
    Call<CapitalQuiz> PutCapitalQuizByPath(@Path("id") int id, @Body CapitalQuiz newCapitalQuiz);
    @POST("quizzes")
    Call<CapitalQuiz> PostCapitalQuizByBody(@Body CapitalQuiz newCapitalQuiz);
    @GET("quizzes/{id}")
    Call<CapitalQuiz> GetCapitalQuizByPath(@Path("id") String id);
    // student endpoints
    @GET("/students/exists")
    Call<Boolean> existsByEmail(@Query("email") String email);
    @GET("/students/authenticate")
    Call<Student> authenticate(@Query("email") String email, @Query("password") String password);
    @POST("/students")
    Call<Student> postNewStudent(@Body Student newStudent);
}
