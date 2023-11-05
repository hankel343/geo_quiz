package com.example.geoquizfrontend;

import static com.example.geoquizfrontend.ApiClientFactory.GetGeoQuizApi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.geoquizfrontend.models.Quiz;
import com.example.geoquizfrontend.services.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResultScreen extends AppCompatActivity {
    private TextView YourScore, DurationText;
    int quizScore;
    private Button PlayAgainBtn;
    String stringQuizScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_screen);

//        SharedPreferences sharedPreferences = getSharedPreferences("UserInfo", MODE_PRIVATE);

        YourScore = (TextView) findViewById(R.id.YourScore);
        PlayAgainBtn = (Button) findViewById(R.id.playagain_btn);

        Intent intent = getIntent();
        quizScore = intent.getIntExtra("score", quizScore);
        YourScore.setText("Score: " + Integer.toString(quizScore));

        Quiz newQuiz = new Quiz();
        newQuiz.setScore(quizScore);

        ApiService apiService = GetGeoQuizApi();
        Call<Quiz> call = apiService.PostCapitalQuizByBody(newQuiz);
        call.enqueue(new Callback<Quiz>() {
            @Override
            public void onResponse(Call<Quiz> call, Response<Quiz> response) {
                if (!response.isSuccessful()) {

                }
                Quiz quiz = response.body();
            }

            @Override
            public void onFailure(Call<Quiz> call, Throwable t) {

            }
        });

        PlayAgainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(
                        new Intent(new Intent(ResultScreen.this, GamescreenActivity.class)
                ));
            }
        });
    }
}