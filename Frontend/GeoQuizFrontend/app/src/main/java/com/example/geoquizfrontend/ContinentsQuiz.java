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
import com.example.geoquizfrontend.models.QuizType;
import com.example.geoquizfrontend.services.ApiService;
import com.example.geoquizfrontend.services.CountryService;
import com.example.geoquizfrontend.services.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ContinentsQuiz extends AppCompatActivity {

    private TextView CapitalText, ScoreText, TimerText;
    static int score, question, questions, answer;
    private Button Continentbtn1, Continentbtn2, Continentbtn3, Continentbtn4, Continentbtn5, Continentbtn6, QuitBtn;
    private String Continent1, ContinentQuestion;
    private CountDownTimer countDownTimer;
    private long timeLeftInMilliseconds = 90000;
    private boolean timerRunning;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continents_quiz);

        CapitalText = (TextView) findViewById(R.id.gameText);
        ScoreText = (TextView) findViewById(R.id.ScoreText);
        TimerText = (TextView) findViewById(R.id.timer);
        Continentbtn1 = (Button) findViewById(R.id.opt0_btn);
        Continentbtn2 = (Button) findViewById(R.id.opt1_btn);
        Continentbtn3 = (Button) findViewById(R.id.opt2_btn);
        Continentbtn4 = (Button) findViewById(R.id.opt3_btn);
        Continentbtn5 = (Button) findViewById(R.id.opt4_btn);
        Continentbtn6 = (Button) findViewById(R.id.opt5_btn);
        QuitBtn = (Button) findViewById(R.id.quit_btn);

        questions = 5;
        question = 1;


        ApiService apiService = ApiClientFactory.GetGeoQuizApi();
        Call<ArrayList<GameData>> call = apiService.GetGameData(1);


        call.enqueue(new Callback<ArrayList<GameData>>() {
            @Override
            public void onResponse(Call<ArrayList<GameData>> call, Response<ArrayList<GameData>> response) {
                if (response.isSuccessful()) {
                    // assign game data objects here
                    // e.g.
                    ArrayList<GameData> ContinentGame = response.body();
                    Continent1 = ContinentGame.get(0).getContinent();
                    ContinentQuestion = ContinentGame.get(0).getName();
                    CapitalText.setText("What Continent is " + ContinentQuestion + " on?");
                    if(Continent1.equals("Americas")){
                        answer = 0;
                    }
                    if(Continent1.equals("Asia")){
                        answer = 1;
                    }
                    if(Continent1.equals("Europe")){
                        answer = 2;
                    }
                    if(Continent1.equals("Africa")){
                        answer = 3;
                    }
                    if(Continent1.equals("Oceania")){
                        answer = 4;
                    }
                    if(Continent1.equals("Antarctica")){
                        answer = 5;
                    }
                    startTimer();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<GameData>> call, Throwable t) {

            }
        });
        Continentbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startStop();
                if(answer == 0){
                    updateScore();
                    checkGameOver();

                    ApiService apiService = ApiClientFactory.GetGeoQuizApi();;
                    Call<ArrayList<GameData>> call = apiService.GetGameData(1);
                    call.enqueue(new Callback<ArrayList<GameData>>() {
                        @Override
                        public void onResponse(Call<ArrayList<GameData>> call, Response<ArrayList<GameData>> response) {
                            if (response.isSuccessful()) {
                                // assign game data objects here
                                // e.g.
                                ArrayList<GameData> ContinentGame = response.body();
                                Continent1 = ContinentGame.get(0).getContinent();
                                ContinentQuestion = ContinentGame.get(0).getName();
                                CapitalText.setText("What Continent is " + ContinentQuestion + " on?");
                                if(Continent1.equals("Americas")){
                                    answer = 0;
                                }
                                if(Continent1.equals("Asia")){
                                    answer = 1;
                                }
                                if(Continent1.equals("Europe")){
                                    answer = 2;
                                }
                                if(Continent1.equals("Africa")){
                                    answer = 3;
                                }
                                if(Continent1.equals("Oceania")){
                                    answer = 4;
                                }
                                if(Continent1.equals("Antarctica")){
                                    answer = 5;
                                }
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
                    Call<ArrayList<GameData>> call = apiService.GetGameData(1);
                    call.enqueue(new Callback<ArrayList<GameData>>() {
                        @Override
                        public void onResponse(Call<ArrayList<GameData>> call, Response<ArrayList<GameData>> response) {
                            if (response.isSuccessful()) {
                                // assign game data objects here
                                // e.g.
                                ArrayList<GameData> ContinentGame = response.body();
                                Continent1 = ContinentGame.get(0).getContinent();
                                ContinentQuestion = ContinentGame.get(0).getName();
                                CapitalText.setText("What Continent is " + ContinentQuestion + " on?");
                                if(Continent1.equals("Americas")){
                                    answer = 0;
                                }
                                if(Continent1.equals("Asia")){
                                    answer = 1;
                                }
                                if(Continent1.equals("Europe")){
                                    answer = 2;
                                }
                                if(Continent1.equals("Africa")){
                                    answer = 3;
                                }
                                if(Continent1.equals("Oceania")){
                                    answer = 4;
                                }
                                if(Continent1.equals("Antarctica")){
                                    answer = 5;
                                }
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
        Continentbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startStop();
                if(answer == 1){
                    updateScore();
                    checkGameOver();

                    ApiService apiService = ApiClientFactory.GetGeoQuizApi();
                    Call<ArrayList<GameData>> call = apiService.GetGameData(1);
                    call.enqueue(new Callback<ArrayList<GameData>>() {
                        @Override
                        public void onResponse(Call<ArrayList<GameData>> call, Response<ArrayList<GameData>> response) {
                            if (response.isSuccessful()) {
                                // assign game data objects here
                                // e.g.
                                ArrayList<GameData> ContinentGame = response.body();
                                Continent1 = ContinentGame.get(0).getContinent();
                                ContinentQuestion = ContinentGame.get(0).getName();
                                CapitalText.setText("What Continent is " + ContinentQuestion + " on?");
                                if(Continent1.equals("Americas")){
                                    answer = 0;
                                }
                                if(Continent1.equals("Asia")){
                                    answer = 1;
                                }
                                if(Continent1.equals("Europe")){
                                    answer = 2;
                                }
                                if(Continent1.equals("Africa")){
                                    answer = 3;
                                }
                                if(Continent1.equals("Oceania")){
                                    answer = 4;
                                }
                                if(Continent1.equals("Antarctica")){
                                    answer = 5;
                                }
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
                    Call<ArrayList<GameData>> call = apiService.GetGameData(1);
                    call.enqueue(new Callback<ArrayList<GameData>>() {
                        @Override
                        public void onResponse(Call<ArrayList<GameData>> call, Response<ArrayList<GameData>> response) {
                            if (response.isSuccessful()) {
                                // assign game data objects here
                                // e.g.
                                ArrayList<GameData> ContinentGame = response.body();
                                Continent1 = ContinentGame.get(0).getContinent();
                                ContinentQuestion = ContinentGame.get(0).getName();
                                CapitalText.setText("What Continent is " + ContinentQuestion + " on?");
                                if(Continent1.equals("Americas")){
                                    answer = 0;
                                }
                                if(Continent1.equals("Asia")){
                                    answer = 1;
                                }
                                if(Continent1.equals("Europe")){
                                    answer = 2;
                                }
                                if(Continent1.equals("Africa")){
                                    answer = 3;
                                }
                                if(Continent1.equals("Oceania")){
                                    answer = 4;
                                }
                                if(Continent1.equals("Antarctica")){
                                    answer = 5;
                                }
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
        Continentbtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startStop();
                if(answer == 2){
                    updateScore();
                    checkGameOver();

                    ApiService apiService = ApiClientFactory.GetGeoQuizApi();
                    Call<ArrayList<GameData>> call = apiService.GetGameData(1);
                    call.enqueue(new Callback<ArrayList<GameData>>() {
                        @Override
                        public void onResponse(Call<ArrayList<GameData>> call, Response<ArrayList<GameData>> response) {
                            if (response.isSuccessful()) {
                                // assign game data objects here
                                // e.g.
                                ArrayList<GameData> ContinentGame = response.body();
                                Continent1 = ContinentGame.get(0).getContinent();
                                ContinentQuestion = ContinentGame.get(0).getName();
                                CapitalText.setText("What Continent is " + ContinentQuestion + " on?");
                                if(Continent1.equals("Americas")){
                                    answer = 0;
                                }
                                if(Continent1.equals("Asia")){
                                    answer = 1;
                                }
                                if(Continent1.equals("Europe")){
                                    answer = 2;
                                }
                                if(Continent1.equals("Africa")){
                                    answer = 3;
                                }
                                if(Continent1.equals("Oceania")){
                                    answer = 4;
                                }
                                if(Continent1.equals("Antarctica")){
                                    answer = 5;
                                }
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
                    Call<ArrayList<GameData>> call = apiService.GetGameData(1);
                    call.enqueue(new Callback<ArrayList<GameData>>() {
                        @Override
                        public void onResponse(Call<ArrayList<GameData>> call, Response<ArrayList<GameData>> response) {
                            if (response.isSuccessful()) {
                                // assign game data objects here
                                // e.g.
                                ArrayList<GameData> ContinentGame = response.body();
                                Continent1 = ContinentGame.get(0).getContinent();
                                ContinentQuestion = ContinentGame.get(0).getName();
                                CapitalText.setText("What Continent is " + ContinentQuestion + " on?");
                                if(Continent1.equals("Americas")){
                                    answer = 0;
                                }
                                if(Continent1.equals("Asia")){
                                    answer = 1;
                                }
                                if(Continent1.equals("Europe")){
                                    answer = 2;
                                }
                                if(Continent1.equals("Africa")){
                                    answer = 3;
                                }
                                if(Continent1.equals("Oceania")){
                                    answer = 4;
                                }
                                if(Continent1.equals("Antarctica")){
                                    answer = 5;
                                }
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
        Continentbtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startStop();
                if(answer == 3){
                    updateScore();
                    checkGameOver();

                    ApiService apiService = ApiClientFactory.GetGeoQuizApi();
                    Call<ArrayList<GameData>> call = apiService.GetGameData(1);
                    call.enqueue(new Callback<ArrayList<GameData>>() {
                        @Override
                        public void onResponse(Call<ArrayList<GameData>> call, Response<ArrayList<GameData>> response) {
                            if (response.isSuccessful()) {
                                // assign game data objects here
                                // e.g.
                                ArrayList<GameData> ContinentGame = response.body();
                                Continent1 = ContinentGame.get(0).getContinent();
                                ContinentQuestion = ContinentGame.get(0).getName();
                                CapitalText.setText("What Continent is " + ContinentQuestion + " on?");
                                if(Continent1.equals("Americas")){
                                    answer = 0;
                                }
                                if(Continent1.equals("Asia")){
                                    answer = 1;
                                }
                                if(Continent1.equals("Europe")){
                                    answer = 2;
                                }
                                if(Continent1.equals("Africa")){
                                    answer = 3;
                                }
                                if(Continent1.equals("Oceania")){
                                    answer = 4;
                                }
                                if(Continent1.equals("Antarctica")){
                                    answer = 5;
                                }
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
                    Call<ArrayList<GameData>> call = apiService.GetGameData(1);
                    call.enqueue(new Callback<ArrayList<GameData>>() {
                        @Override
                        public void onResponse(Call<ArrayList<GameData>> call, Response<ArrayList<GameData>> response) {
                            if (response.isSuccessful()) {
                                // assign game data objects here
                                // e.g.
                                ArrayList<GameData> ContinentGame = response.body();
                                Continent1 = ContinentGame.get(0).getContinent();
                                ContinentQuestion = ContinentGame.get(0).getName();
                                CapitalText.setText("What Continent is " + ContinentQuestion + " on?");
                                if(Continent1.equals("Americas")){
                                    answer = 0;
                                }
                                if(Continent1.equals("Asia")){
                                    answer = 1;
                                }
                                if(Continent1.equals("Europe")){
                                    answer = 2;
                                }
                                if(Continent1.equals("Africa")){
                                    answer = 3;
                                }
                                if(Continent1.equals("Oceania")){
                                    answer = 4;
                                }
                                if(Continent1.equals("Antarctica")){
                                    answer = 5;
                                }
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
        Continentbtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startStop();
                if(answer == 4){
                    updateScore();
                    checkGameOver();

                    ApiService apiService = ApiClientFactory.GetGeoQuizApi();
                    Call<ArrayList<GameData>> call = apiService.GetGameData(1);
                    call.enqueue(new Callback<ArrayList<GameData>>() {
                        @Override
                        public void onResponse(Call<ArrayList<GameData>> call, Response<ArrayList<GameData>> response) {
                            if (response.isSuccessful()) {
                                // assign game data objects here
                                // e.g.
                                ArrayList<GameData> ContinentGame = response.body();
                                Continent1 = ContinentGame.get(0).getContinent();
                                ContinentQuestion = ContinentGame.get(0).getName();
                                CapitalText.setText("What Continent is " + ContinentQuestion + " on?");
                                if(Continent1.equals("Americas")){
                                    answer = 0;
                                }
                                if(Continent1.equals("Asia")){
                                    answer = 1;
                                }
                                if(Continent1.equals("Europe")){
                                    answer = 2;
                                }
                                if(Continent1.equals("Africa")){
                                    answer = 3;
                                }
                                if(Continent1.equals("Oceania")){
                                    answer = 4;
                                }
                                if(Continent1.equals("Antarctica")){
                                    answer = 5;
                                }
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
                    Call<ArrayList<GameData>> call = apiService.GetGameData(1);
                    call.enqueue(new Callback<ArrayList<GameData>>() {
                        @Override
                        public void onResponse(Call<ArrayList<GameData>> call, Response<ArrayList<GameData>> response) {
                            if (response.isSuccessful()) {
                                // assign game data objects here
                                // e.g.
                                ArrayList<GameData> ContinentGame = response.body();
                                Continent1 = ContinentGame.get(0).getContinent();
                                ContinentQuestion = ContinentGame.get(0).getName();
                                CapitalText.setText("What Continent is " + ContinentQuestion + " on?");
                                if(Continent1.equals("Americas")){
                                    answer = 0;
                                }
                                if(Continent1.equals("Asia")){
                                    answer = 1;
                                }
                                if(Continent1.equals("Europe")){
                                    answer = 2;
                                }
                                if(Continent1.equals("Africa")){
                                    answer = 3;
                                }
                                if(Continent1.equals("Oceania")){
                                    answer = 4;
                                }
                                if(Continent1.equals("Antarctica")){
                                    answer = 5;
                                }
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
        Continentbtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startStop();
                if(answer == 5){
                    updateScore();
                    checkGameOver();

                    ApiService apiService = ApiClientFactory.GetGeoQuizApi();
                    Call<ArrayList<GameData>> call = apiService.GetGameData(1);
                    call.enqueue(new Callback<ArrayList<GameData>>() {
                        @Override
                        public void onResponse(Call<ArrayList<GameData>> call, Response<ArrayList<GameData>> response) {
                            if (response.isSuccessful()) {
                                // assign game data objects here
                                // e.g.
                                ArrayList<GameData> ContinentGame = response.body();
                                Continent1 = ContinentGame.get(0).getContinent();
                                ContinentQuestion = ContinentGame.get(0).getName();
                                CapitalText.setText("What Continent is " + ContinentQuestion + " on?");
                                if(Continent1.equals("Americas")){
                                    answer = 0;
                                }
                                if(Continent1.equals("Asia")){
                                    answer = 1;
                                }
                                if(Continent1.equals("Europe")){
                                    answer = 2;
                                }
                                if(Continent1.equals("Africa")){
                                    answer = 3;
                                }
                                if(Continent1.equals("Oceania")){
                                    answer = 4;
                                }
                                if(Continent1.equals("Antarctica")){
                                    answer = 5;
                                }
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
                    Call<ArrayList<GameData>> call = apiService.GetGameData(1);
                    call.enqueue(new Callback<ArrayList<GameData>>() {
                        @Override
                        public void onResponse(Call<ArrayList<GameData>> call, Response<ArrayList<GameData>> response) {
                            if (response.isSuccessful()) {
                                // assign game data objects here
                                // e.g.
                                ArrayList<GameData> ContinentGame = response.body();
                                Continent1 = ContinentGame.get(0).getContinent();
                                ContinentQuestion = ContinentGame.get(0).getName();
                                CapitalText.setText("What Continent is " + ContinentQuestion + " on?");
                                if(Continent1.equals("Americas")){
                                    answer = 0;
                                }
                                if(Continent1.equals("Asia")){
                                    answer = 1;
                                }
                                if(Continent1.equals("Europe")){
                                    answer = 2;
                                }
                                if(Continent1.equals("Africa")){
                                    answer = 3;
                                }
                                if(Continent1.equals("Oceania")){
                                    answer = 4;
                                }
                                if(Continent1.equals("Antarctica")){
                                    answer = 5;
                                }
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
                Intent intent = new Intent(ContinentsQuiz.this, MainActivity.class);
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
            Intent intent = new Intent(ContinentsQuiz.this, ResultScreen.class);
            intent.putExtra("quizType", QuizType.CONTINENT);
            intent.putExtra("score", score);
            startActivity(intent);
        }
    }
}
