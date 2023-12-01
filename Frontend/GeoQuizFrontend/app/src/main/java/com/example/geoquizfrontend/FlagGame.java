package com.example.geoquizfrontend;

import static com.example.geoquizfrontend.ApiClientFactory.GetGeoQuizApi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.geoquizfrontend.models.GameData;
import com.example.geoquizfrontend.models.QuizType;
import com.example.geoquizfrontend.services.ApiService;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FlagGame extends AppCompatActivity {

    private TextView ScoreText, TimerText, FlagQuestion;
    static int score, question, questions, answer;
    private Button Countrybtn1, Countrybtn2, Countrybtn3, Countrybtn4, QuitBtn;
    private String country1, country2, country3, country4, FlagCode;
    private CountDownTimer countDownTimer;
    private long timeLeftInMilliseconds = 90000;
    private boolean timerRunning;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flag_game);

        FlagQuestion = findViewById(R.id.FlagQuestion);
        ScoreText = (TextView) findViewById(R.id.ScoreText);
        TimerText = (TextView) findViewById(R.id.timer);
        Countrybtn1 = (Button) findViewById(R.id.opt0_btn);
        Countrybtn2 = (Button) findViewById(R.id.opt1_btn);
        Countrybtn3 = (Button) findViewById(R.id.opt2_btn);
        Countrybtn4 = (Button) findViewById(R.id.opt3_btn);
        QuitBtn = (Button) findViewById(R.id.quit_btn);

        questions = 5;
        question = 1;

        ApiService apiService = GetGeoQuizApi();
        Call<ArrayList<GameData>> call = apiService.GetGameData(4);
        call.enqueue(new Callback<ArrayList<GameData>>() {
            @Override
            public void onResponse(Call<ArrayList<GameData>> call, Response<ArrayList<GameData>> response) {
                if (response.isSuccessful()) {
                    answer = getRandomNumber(0, 3);
                    ArrayList<GameData> FlagGame = response.body();
                    FlagCode = FlagGame.get(answer).getFlag();
                    FlagQuestion.setText(FlagCode);
                    country1 = FlagGame.get(0).getName();
                    country2 = FlagGame.get(1).getName();
                    country3 = FlagGame.get(2).getName();
                    country4 = FlagGame.get(3).getName();
                    Countrybtn1.setText(country1);
                    Countrybtn2.setText(country2);
                    Countrybtn3.setText(country3);
                    Countrybtn4.setText(country4);
                    startTimer();

                }
            }

            @Override
            public void onFailure(Call<ArrayList<GameData>> call, Throwable t) {

            }
        });
        Countrybtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startStop();
                if(answer == 0){
                    updateScore();
                    checkGameOver();

                    ApiService apiService = ApiClientFactory.GetGeoQuizApi();;
                    Call<ArrayList<GameData>> call = apiService.GetGameData(4);
                    call.enqueue(new Callback<ArrayList<GameData>>() {
                        @Override
                        public void onResponse(Call<ArrayList<GameData>> call, Response<ArrayList<GameData>> response) {
                            if (response.isSuccessful()) {
                                // assign game data objects here
                                // e.g.
                                answer = getRandomNumber(0, 3);
                                ArrayList<GameData> FlagGame = response.body();
                                FlagCode = FlagGame.get(answer).getFlag();
                                FlagQuestion.setText(FlagCode);
                                country1 = FlagGame.get(0).getName();
                                country2 = FlagGame.get(1).getName();
                                country3 = FlagGame.get(2).getName();
                                country4 = FlagGame.get(3).getName();
                                Countrybtn1.setText(country1);
                                Countrybtn2.setText(country2);
                                Countrybtn3.setText(country3);
                                Countrybtn4.setText(country4);;
                                timeLeftInMilliseconds = 90000;
                                startStop();
                            }
                        }

                        @Override
                        public void onFailure(Call<ArrayList<GameData>> call, Throwable t) {

                        }
                    });
                }else{
                    checkGameOver();

                    ApiService apiService = ApiClientFactory.GetGeoQuizApi();
                    Call<ArrayList<GameData>> call = apiService.GetGameData(4);
                    call.enqueue(new Callback<ArrayList<GameData>>() {
                        @Override
                        public void onResponse(Call<ArrayList<GameData>> call, Response<ArrayList<GameData>> response) {
                            if (response.isSuccessful()) {
                                // assign game data objects here
                                // e.g.
                                answer = getRandomNumber(0, 3);
                                ArrayList<GameData> FlagGame = response.body();
                                FlagCode = FlagGame.get(answer).getFlag();
                                FlagQuestion.setText(FlagCode);
                                country1 = FlagGame.get(0).getName();
                                country2 = FlagGame.get(1).getName();
                                country3 = FlagGame.get(2).getName();
                                country4 = FlagGame.get(3).getName();
                                Countrybtn1.setText(country1);
                                Countrybtn2.setText(country2);
                                Countrybtn3.setText(country3);
                                Countrybtn4.setText(country4);
                                timeLeftInMilliseconds = 90000;
                                startStop();
                            }
                        }

                        @Override
                        public void onFailure(Call<ArrayList<GameData>> call, Throwable t) {

                        }
                    });
                }
            }
        });
        Countrybtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startStop();
                if(answer == 1){
                    updateScore();
                    checkGameOver();

                    ApiService apiService = ApiClientFactory.GetGeoQuizApi();;
                    Call<ArrayList<GameData>> call = apiService.GetGameData(4);
                    call.enqueue(new Callback<ArrayList<GameData>>() {
                        @Override
                        public void onResponse(Call<ArrayList<GameData>> call, Response<ArrayList<GameData>> response) {
                            if (response.isSuccessful()) {
                                // assign game data objects here
                                // e.g.
                                answer = getRandomNumber(0, 3);
                                ArrayList<GameData> FlagGame = response.body();
                                FlagCode = FlagGame.get(answer).getFlag();
                                FlagQuestion.setText(FlagCode);
                                country1 = FlagGame.get(0).getName();
                                country2 = FlagGame.get(1).getName();
                                country3 = FlagGame.get(2).getName();
                                country4 = FlagGame.get(3).getName();
                                Countrybtn1.setText(country1);
                                Countrybtn2.setText(country2);
                                Countrybtn3.setText(country3);
                                Countrybtn4.setText(country4);;
                                timeLeftInMilliseconds = 90000;
                                startStop();
                            }
                        }

                        @Override
                        public void onFailure(Call<ArrayList<GameData>> call, Throwable t) {

                        }
                    });
                }else{
                    checkGameOver();

                    ApiService apiService = ApiClientFactory.GetGeoQuizApi();
                    Call<ArrayList<GameData>> call = apiService.GetGameData(4);
                    call.enqueue(new Callback<ArrayList<GameData>>() {
                        @Override
                        public void onResponse(Call<ArrayList<GameData>> call, Response<ArrayList<GameData>> response) {
                            if (response.isSuccessful()) {
                                // assign game data objects here
                                // e.g.
                                answer = getRandomNumber(0, 3);
                                ArrayList<GameData> FlagGame = response.body();
                                FlagCode = FlagGame.get(answer).getFlag();
                                FlagQuestion.setText(FlagCode);
                                country1 = FlagGame.get(0).getName();
                                country2 = FlagGame.get(1).getName();
                                country3 = FlagGame.get(2).getName();
                                country4 = FlagGame.get(3).getName();
                                Countrybtn1.setText(country1);
                                Countrybtn2.setText(country2);
                                Countrybtn3.setText(country3);
                                Countrybtn4.setText(country4);
                                timeLeftInMilliseconds = 90000;
                                startStop();
                            }
                        }

                        @Override
                        public void onFailure(Call<ArrayList<GameData>> call, Throwable t) {

                        }
                    });
                }
            }
        });
        Countrybtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startStop();
                if(answer == 2){
                    updateScore();
                    checkGameOver();

                    ApiService apiService = ApiClientFactory.GetGeoQuizApi();;
                    Call<ArrayList<GameData>> call = apiService.GetGameData(4);
                    call.enqueue(new Callback<ArrayList<GameData>>() {
                        @Override
                        public void onResponse(Call<ArrayList<GameData>> call, Response<ArrayList<GameData>> response) {
                            if (response.isSuccessful()) {
                                // assign game data objects here
                                // e.g.
                                answer = getRandomNumber(0, 3);
                                ArrayList<GameData> FlagGame = response.body();
                                FlagCode = FlagGame.get(answer).getFlag();
                                FlagQuestion.setText(FlagCode);
                                country1 = FlagGame.get(0).getName();
                                country2 = FlagGame.get(1).getName();
                                country3 = FlagGame.get(2).getName();
                                country4 = FlagGame.get(3).getName();
                                Countrybtn1.setText(country1);
                                Countrybtn2.setText(country2);
                                Countrybtn3.setText(country3);
                                Countrybtn4.setText(country4);;
                                timeLeftInMilliseconds = 90000;
                                startStop();
                            }
                        }

                        @Override
                        public void onFailure(Call<ArrayList<GameData>> call, Throwable t) {

                        }
                    });
                }else{
                    checkGameOver();

                    ApiService apiService = ApiClientFactory.GetGeoQuizApi();
                    Call<ArrayList<GameData>> call = apiService.GetGameData(4);
                    call.enqueue(new Callback<ArrayList<GameData>>() {
                        @Override
                        public void onResponse(Call<ArrayList<GameData>> call, Response<ArrayList<GameData>> response) {
                            if (response.isSuccessful()) {
                                // assign game data objects here
                                // e.g.
                                answer = getRandomNumber(0, 3);
                                ArrayList<GameData> FlagGame = response.body();
                                FlagCode = FlagGame.get(answer).getFlag();
                                FlagQuestion.setText(FlagCode);
                                country1 = FlagGame.get(0).getName();
                                country2 = FlagGame.get(1).getName();
                                country3 = FlagGame.get(2).getName();
                                country4 = FlagGame.get(3).getName();
                                Countrybtn1.setText(country1);
                                Countrybtn2.setText(country2);
                                Countrybtn3.setText(country3);
                                Countrybtn4.setText(country4);
                                timeLeftInMilliseconds = 90000;
                                startStop();
                            }
                        }

                        @Override
                        public void onFailure(Call<ArrayList<GameData>> call, Throwable t) {

                        }
                    });
                }
            }
        });
        Countrybtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startStop();
                if(answer == 3){
                    updateScore();
                    checkGameOver();

                    ApiService apiService = ApiClientFactory.GetGeoQuizApi();;
                    Call<ArrayList<GameData>> call = apiService.GetGameData(4);
                    call.enqueue(new Callback<ArrayList<GameData>>() {
                        @Override
                        public void onResponse(Call<ArrayList<GameData>> call, Response<ArrayList<GameData>> response) {
                            if (response.isSuccessful()) {
                                // assign game data objects here
                                // e.g.
                                answer = getRandomNumber(0, 3);
                                ArrayList<GameData> FlagGame = response.body();
                                FlagCode = FlagGame.get(answer).getFlag();
                                FlagQuestion.setText(FlagCode);
                                country1 = FlagGame.get(0).getName();
                                country2 = FlagGame.get(1).getName();
                                country3 = FlagGame.get(2).getName();
                                country4 = FlagGame.get(3).getName();
                                Countrybtn1.setText(country1);
                                Countrybtn2.setText(country2);
                                Countrybtn3.setText(country3);
                                Countrybtn4.setText(country4);;
                                timeLeftInMilliseconds = 90000;
                                startStop();
                            }
                        }

                        @Override
                        public void onFailure(Call<ArrayList<GameData>> call, Throwable t) {

                        }
                    });
                }else{
                    checkGameOver();

                    ApiService apiService = ApiClientFactory.GetGeoQuizApi();
                    Call<ArrayList<GameData>> call = apiService.GetGameData(4);
                    call.enqueue(new Callback<ArrayList<GameData>>() {
                        @Override
                        public void onResponse(Call<ArrayList<GameData>> call, Response<ArrayList<GameData>> response) {
                            if (response.isSuccessful()) {
                                // assign game data objects here
                                // e.g.
                                answer = getRandomNumber(0, 3);
                                ArrayList<GameData> FlagGame = response.body();
                                FlagCode = FlagGame.get(answer).getFlag();
                                FlagQuestion.setText(FlagCode);
                                country1 = FlagGame.get(0).getName();
                                country2 = FlagGame.get(1).getName();
                                country3 = FlagGame.get(2).getName();
                                country4 = FlagGame.get(3).getName();
                                Countrybtn1.setText(country1);
                                Countrybtn2.setText(country2);
                                Countrybtn3.setText(country3);
                                Countrybtn4.setText(country4);
                                timeLeftInMilliseconds = 90000;
                                startStop();
                            }
                        }

                        @Override
                        public void onFailure(Call<ArrayList<GameData>> call, Throwable t) {

                        }
                    });
                }
            }
        });
        QuitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FlagGame.this, GamescreenActivity.class);
                startActivity(intent);
            }
        });
    }
    public static int getRandomNumber(int min, int max) {
        return (new Random()).nextInt((max - min) + 1) + min;
    }
    public void startStop(){
        if(timerRunning){
            stopTimer();
        }else{
            startTimer();
        }
    }
    public void startTimer(){
        countDownTimer = new CountDownTimer(timeLeftInMilliseconds, 1000) {
            @Override
            public void onTick(long l) {
                timeLeftInMilliseconds = l;
                updateTimer();
            }

            @Override
            public void onFinish() {

            }
        }.start();

        timerRunning = true;
    }

    public void stopTimer(){
        countDownTimer.cancel();
        timerRunning = false;
    }

    public void updateTimer(){
        int minutes = (int) timeLeftInMilliseconds / 60000;
        int seconds = (int) timeLeftInMilliseconds % 60000 / 1000;

        String timeLeftText;

        timeLeftText = "" + minutes;
        timeLeftText += ":";
        if(seconds < 10) timeLeftText += "0";
        timeLeftText += seconds;

        TimerText.setText(timeLeftText);
    }
    private void updateScore() {
        score += 1 + (5*(Math.toIntExact(timeLeftInMilliseconds) / 1000));
        ScoreText.setText("Score: " + Integer.toString(score));
    }
    private void checkGameOver() {
        question += 1;
        if (question > questions) {
            Intent intent = new Intent(FlagGame.this, ResultScreen.class);
            intent.putExtra("score", score);
            intent.putExtra("quizType", QuizType.FLAG);
            startActivity(intent);
        }
    }
}