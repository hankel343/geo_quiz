package com.example.geoquizfrontend;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface CapitalQuizApi {

    @PUT("quizzes/{id}")
    Call<CapitalQuiz> PostPutByPath(@Path("id") String id);

    @GET("quizzes/{}")
    Call<List<CapitalQuiz>> GetAllTrivia();
}
