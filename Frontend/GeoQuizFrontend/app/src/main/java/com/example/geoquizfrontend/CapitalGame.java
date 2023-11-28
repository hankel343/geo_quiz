package com.example.geoquizfrontend;

import static com.example.geoquizfrontend.ApiClientFactory.GetGeoQuizApi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import com.example.geoquizfrontend.models.Quiz;
import com.example.geoquizfrontend.models.GameData;

import com.example.geoquizfrontend.services.ApiService;
import com.example.geoquizfrontend.services.CountryService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CapitalGame extends AppCompatActivity {
    private TextView CapitalText, ScoreText, TimerText;

    static String whatQuestion, scoreText, whatAnswer;
    static int score, question, questions, answer;
    private Button Countrybtn1, Countrybtn2, Countrybtn3, Countrybtn4, QuitBtn;
    private String country1, country2, country3, country4, capitalQuestion;
    private CountDownTimer countDownTimer;
    private long timeLeftInMilliseconds = 90000;
    private boolean timerRunning;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capital_game);


        CapitalText = (TextView) findViewById(R.id.gameText);
        ScoreText = (TextView) findViewById(R.id.ScoreText);
        TimerText = (TextView) findViewById(R.id.timer);
        Countrybtn1 = (Button) findViewById(R.id.opt0_btn);
        Countrybtn2 = (Button) findViewById(R.id.opt1_btn);
        Countrybtn3 = (Button) findViewById(R.id.opt2_btn);
        Countrybtn4 = (Button) findViewById(R.id.opt3_btn);
        QuitBtn = (Button) findViewById(R.id.quit_btn);

        questions = 5;
        question = 1;

        ApiService apiService = ApiClientFactory.GetGeoQuizApi();
        Call<ArrayList<GameData>> call = apiService.GetGameData(4);


        call.enqueue(new Callback<ArrayList<GameData>>() {
            @Override
            public void onResponse(Call<ArrayList<GameData>> call, Response<ArrayList<GameData>> response) {
                if (response.isSuccessful()) {
                    // assign game data objects here
                    // e.g.
                    answer = getRandomNumber(0, 3);
                    ArrayList<GameData> CapitalGame = response.body();
                    country1 = CapitalGame.get(0).getName();
                    country2 = CapitalGame.get(1).getName();
                    country3 = CapitalGame.get(2).getName();
                    country4 = CapitalGame.get(3).getName();
                    capitalQuestion = CapitalGame.get(answer).getCapital();
                    Countrybtn1.setText(country1);
                    Countrybtn2.setText(country2);
                    Countrybtn3.setText(country3);
                    Countrybtn4.setText(country4);
                    CapitalText.setText("What country has " + capitalQuestion + " as their capital?");
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
                                ArrayList<GameData> CapitalGame = response.body();
                                country1 = CapitalGame.get(0).getName();
                                country2 = CapitalGame.get(1).getName();
                                country3 = CapitalGame.get(2).getName();
                                country4 = CapitalGame.get(3).getName();
                                capitalQuestion = CapitalGame.get(answer).getCapital();
                                Countrybtn1.setText(country1);
                                Countrybtn2.setText(country2);
                                Countrybtn3.setText(country3);
                                Countrybtn4.setText(country4);
                                CapitalText.setText("What country has " + capitalQuestion + " as their capital?");
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
                                ArrayList<GameData> CapitalGame = response.body();
                                country1 = CapitalGame.get(0).getName();
                                country2 = CapitalGame.get(1).getName();
                                country3 = CapitalGame.get(2).getName();
                                country4 = CapitalGame.get(3).getName();
                                capitalQuestion = CapitalGame.get(answer).getCapital();
                                Countrybtn1.setText(country1);
                                Countrybtn2.setText(country2);
                                Countrybtn3.setText(country3);
                                Countrybtn4.setText(country4);
                                CapitalText.setText("What country has " + capitalQuestion + " as their capital?");
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

                    ApiService apiService = ApiClientFactory.GetGeoQuizApi();
                    Call<ArrayList<GameData>> call = apiService.GetGameData(4);
                    call.enqueue(new Callback<ArrayList<GameData>>() {
                        @Override
                        public void onResponse(Call<ArrayList<GameData>> call, Response<ArrayList<GameData>> response) {
                            if (response.isSuccessful()) {
                                // assign game data objects here
                                // e.g.
                                answer = getRandomNumber(0, 3);
                                ArrayList<GameData> CapitalGame = response.body();
                                country1 = CapitalGame.get(0).getName();
                                country2 = CapitalGame.get(1).getName();
                                country3 = CapitalGame.get(2).getName();
                                country4 = CapitalGame.get(3).getName();
                                capitalQuestion = CapitalGame.get(answer).getCapital();
                                Countrybtn1.setText(country1);
                                Countrybtn2.setText(country2);
                                Countrybtn3.setText(country3);
                                Countrybtn4.setText(country4);
                                CapitalText.setText("What country has " + capitalQuestion + " as their capital?");
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
                                ArrayList<GameData> CapitalGame = response.body();
                                country1 = CapitalGame.get(0).getName();
                                country2 = CapitalGame.get(1).getName();
                                country3 = CapitalGame.get(2).getName();
                                country4 = CapitalGame.get(3).getName();
                                capitalQuestion = CapitalGame.get(answer).getCapital();
                                Countrybtn1.setText(country1);
                                Countrybtn2.setText(country2);
                                Countrybtn3.setText(country3);
                                Countrybtn4.setText(country4);
                                CapitalText.setText("What country has " + capitalQuestion + " as their capital?");
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

                    ApiService apiService = ApiClientFactory.GetGeoQuizApi();
                    Call<ArrayList<GameData>> call = apiService.GetGameData(4);
                    call.enqueue(new Callback<ArrayList<GameData>>() {
                        @Override
                        public void onResponse(Call<ArrayList<GameData>> call, Response<ArrayList<GameData>> response) {
                            if (response.isSuccessful()) {
                                // assign game data objects here
                                // e.g.
                                answer = getRandomNumber(0, 3);
                                ArrayList<GameData> CapitalGame = response.body();
                                country1 = CapitalGame.get(0).getName();
                                country2 = CapitalGame.get(1).getName();
                                country3 = CapitalGame.get(2).getName();
                                country4 = CapitalGame.get(3).getName();
                                capitalQuestion = CapitalGame.get(answer).getCapital();
                                Countrybtn1.setText(country1);
                                Countrybtn2.setText(country2);
                                Countrybtn3.setText(country3);
                                Countrybtn4.setText(country4);
                                CapitalText.setText("What country has " + capitalQuestion + " as their capital?");
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
                                ArrayList<GameData> CapitalGame = response.body();
                                country1 = CapitalGame.get(0).getName();
                                country2 = CapitalGame.get(1).getName();
                                country3 = CapitalGame.get(2).getName();
                                country4 = CapitalGame.get(3).getName();
                                capitalQuestion = CapitalGame.get(answer).getCapital();
                                Countrybtn1.setText(country1);
                                Countrybtn2.setText(country2);
                                Countrybtn3.setText(country3);
                                Countrybtn4.setText(country4);
                                CapitalText.setText("What country has " + capitalQuestion + " as their capital?");
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

                    ApiService apiService = ApiClientFactory.GetGeoQuizApi();
                    Call<ArrayList<GameData>> call = apiService.GetGameData(4);
                    call.enqueue(new Callback<ArrayList<GameData>>() {
                        @Override
                        public void onResponse(Call<ArrayList<GameData>> call, Response<ArrayList<GameData>> response) {
                            if (response.isSuccessful()) {
                                // assign game data objects here
                                // e.g.
                                answer = getRandomNumber(0, 3);
                                ArrayList<GameData> CapitalGame = response.body();
                                country1 = CapitalGame.get(0).getName();
                                country2 = CapitalGame.get(1).getName();
                                country3 = CapitalGame.get(2).getName();
                                country4 = CapitalGame.get(3).getName();
                                capitalQuestion = CapitalGame.get(answer).getCapital();
                                Countrybtn1.setText(country1);
                                Countrybtn2.setText(country2);
                                Countrybtn3.setText(country3);
                                Countrybtn4.setText(country4);
                                CapitalText.setText("What country has " + capitalQuestion + " as their capital?");
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
                                ArrayList<GameData> CapitalGame = response.body();
                                country1 = CapitalGame.get(0).getName();
                                country2 = CapitalGame.get(1).getName();
                                country3 = CapitalGame.get(2).getName();
                                country4 = CapitalGame.get(3).getName();
                                capitalQuestion = CapitalGame.get(answer).getCapital();
                                Countrybtn1.setText(country1);
                                Countrybtn2.setText(country2);
                                Countrybtn3.setText(country3);
                                Countrybtn4.setText(country4);
                                CapitalText.setText("What country has " + capitalQuestion + " as their capital?");
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
                Intent intent = new Intent(CapitalGame.this, MainActivity.class);
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
            Intent intent = new Intent(CapitalGame.this, ResultScreen.class);
            intent.putExtra("score", score);
            startActivity(intent);
        }
    }
}
