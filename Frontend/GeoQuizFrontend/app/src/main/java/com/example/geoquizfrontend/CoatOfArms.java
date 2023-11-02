package com.example.geoquizfrontend;

import static com.example.geoquizfrontend.ApiClientFactory.GetCapitalQuizApi;
import static com.example.geoquizfrontend.CountryNames.pngValues;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.geoquizfrontend.models.CapitalQuiz;
import com.example.geoquizfrontend.models.GameData;
import com.example.geoquizfrontend.services.CountryService;
import com.example.geoquizfrontend.services.RandomNumberGenerator;
import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CoatOfArms extends AppCompatActivity {
    TextView GameText, ScoreText, TimerText;
    Button Opt0, Opt1, Opt2, Opt3;
    ImageView coatOfArmsPNG;
    private CountDownTimer countDownTimer;
    private long timeLeftInMilliseconds = 60000;
    private boolean timerRunning;

    private int rounds = 4;
    private int score = 0;
    private String[] countryNames = CountryNames.countries;
    private String[] coatOfArms = pngValues;
    private List<GameData> countryDataList;
    RandomNumberGenerator ansIdx = new RandomNumberGenerator(4);
    RandomNumberGenerator pngIdx = new RandomNumberGenerator(pngValues.length);
    private GameData key = null;
    private int correctAnsIdx = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coat_of_arms);

        // text views
        GameText = findViewById(R.id.gameText);
        ScoreText = findViewById(R.id.ScoreText);
        TimerText = (TextView) findViewById(R.id.COAtimer);

        // buttons
        Opt0 = findViewById(R.id.opt0_btn);
        Opt1 = findViewById(R.id.opt1_btn);
        Opt2 = findViewById(R.id.opt2_btn);
        Opt3 = findViewById(R.id.opt3_btn);

        // set image view
        coatOfArmsPNG = findViewById(R.id.coatOfArms_id);

        CapitalQuizApi apiService = ApiClientFactory.GetCapitalQuizApi();
        Call<List<GameData>> call = apiService.GetGameDataALL();

        call.enqueue(new Callback<List<GameData>>() {
            @Override
            public void onResponse(Call<List<GameData>> call, Response<List<GameData>> response) {
                if (response.isSuccessful()) {
                    countryDataList = response.body();
                    gameTick();
                    startTimer();
                    updateTimer();
                }
            }

            @Override
            public void onFailure(Call<List<GameData>> call, Throwable t) {

            }
        });
    }

    private void gameTick() {
        RandomNumberGenerator optionIdx = new RandomNumberGenerator(countryNames.length);

        correctAnsIdx = ansIdx.generate();
        key = countryDataList.get(correctAnsIdx);
        GameText.setText("What country has the following coat of arms?");

        Picasso.get().load(pngValues[pngIdx.generate()]).into(coatOfArmsPNG);

        switch(correctAnsIdx) {
            case 0:
                Opt0.setText(key.getName());

                Opt1.setText(countryNames[optionIdx.generate()]);
                Opt2.setText(countryNames[optionIdx.generate()]);
                Opt3.setText(countryNames[optionIdx.generate()]);
                break;
            case 1:
                Opt1.setText(key.getName());

                Opt0.setText(countryNames[optionIdx.generate()]);
                Opt2.setText(countryNames[optionIdx.generate()]);
                Opt3.setText(countryNames[optionIdx.generate()]);
                break;
            case 2:
                Opt2.setText(key.getName());

                Opt0.setText(countryNames[optionIdx.generate()]);
                Opt1.setText(countryNames[optionIdx.generate()]);
                Opt3.setText(countryNames[optionIdx.generate()]);
                break;
            case 3:
                Opt3.setText(key.getName());

                Opt0.setText(countryNames[optionIdx.generate()]);
                Opt1.setText(countryNames[optionIdx.generate()]);
                Opt2.setText(countryNames[optionIdx.generate()]);
                break;
        }

        Opt0.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startStop();
                if (correctAnsIdx == 0) {
                    updateScore();
                }

                checkGameOver();
                timeLeftInMilliseconds = 60000;
                startStop();
                gameTick();
            }
        });
        Opt1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startStop();
                if (correctAnsIdx == 1) {
                    updateScore();
                }

                checkGameOver();
                timeLeftInMilliseconds = 60000;
                startStop();
                gameTick();
            }
        });

        Opt2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startStop();
                if (correctAnsIdx == 2) {
                    updateScore();
                }

                checkGameOver();
                timeLeftInMilliseconds = 60000;
                startStop();
                gameTick();
            }
        });

        Opt3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startStop();
                if (correctAnsIdx == 3) {
                    updateScore();
                }

                checkGameOver();
                timeLeftInMilliseconds = 60000;
                startStop();
                gameTick();
            }
        });
    }

    private void updateScore() {
        score += 1 + (5*(Math.toIntExact(timeLeftInMilliseconds) / 1000));
        ScoreText.setText("Score: " + Integer.toString(score));
    }

    private void checkGameOver() {
        rounds--;
        if (rounds <= 0) {
            CapitalQuiz newCapitalQuiz = new CapitalQuiz();
            newCapitalQuiz.setScore(score);
            GetCapitalQuizApi().PostCapitalQuizByBody(newCapitalQuiz);
            Intent intent = new Intent(CoatOfArms.this, ResultScreen.class);
            intent.putExtra("DurationText", Integer.toString(score));
            startActivity(intent);
        }
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
}