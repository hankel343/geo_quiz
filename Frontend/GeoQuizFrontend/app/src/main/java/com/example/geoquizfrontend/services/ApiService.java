package com.example.geoquizfrontend.services;

import com.example.geoquizfrontend.models.Quiz;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiService {
    @PUT("quizzes/{id}")
    Call<Quiz> PutCapitalQuizByPath(@Path("id") int id, @Body Quiz newQuiz);

    @POST("quizzes")
    Call<Quiz> PostCapitalQuizByBody(@Body Quiz newQuiz);

    @GET("quizzes/{id}")
    Call<Quiz> GetCapitalQuizByPath(@Path("id") String id);
}
