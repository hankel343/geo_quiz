package com.example.geoquizfrontend;

import com.example.geoquizfrontend.models.CapitalQuiz;
import com.example.geoquizfrontend.models.Student;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface CapitalQuizApi {

    @PUT("quizzes/{id}")
    Call<CapitalQuiz> PutCapitalQuizByPath(@Path("id") int id, @Body CapitalQuiz newCapitalQuiz);

    @POST("quizzes")
    Call<CapitalQuiz> PostCapitalQuizByBody(@Body CapitalQuiz newCapitalQuiz);

    @GET("quizzes/{id}")
    Call<CapitalQuiz> GetCapitalQuizByPath(@Path("id") String id);

    @POST("/students")
    Call<Student> postNewStudent(@Body Student newStudent);
}
