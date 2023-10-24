package com.example.geoquizfrontend;

import static com.example.geoquizfrontend.ApiClientFactory.GetCapitalQuizApi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.geoquizfrontend.models.GameData;
import com.example.geoquizfrontend.services.CountryService;
import com.example.geoquizfrontend.services.RandomNumberGenerator;
import com.google.android.material.color.utilities.Score;

import java.util.ArrayList;
import java.util.List;

public class ContinentsQuiz extends AppCompatActivity {

    TextView GameText, ScoreText;

    Button Opt0, Opt1, Opt2, Opt3;

    private int rounds = 4;

    private int score = 0;

    private String[] Continents = {
            "North America",
            "South America",
            "Europe",
            "Asia",
            "Africa",
            "Oceania",
            "Antarctica"
    };

    RandomNumberGenerator ansIdx = new RandomNumberGenerator(4);
    private List<GameData> countryDataList;

    private GameData key = null;
    private int correctAnsIdx = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continents_quiz);

        GameText = findViewById(R.id.gameText);
        ScoreText = findViewById(R.id.ScoreText);
        Opt0 = findViewById(R.id.opt0_btn);
        Opt1 = findViewById(R.id.opt1_btn);
        Opt2 = findViewById(R.id.opt2_btn);
        Opt3 = findViewById(R.id.opt3_btn);



        countryDataList = new ArrayList<>();
        CountryService countryService = new CountryService(this);
        countryService.getData(response -> {
            countryDataList = countryService.parseGameDataResponse(response);
            System.out.println(countryDataList.size());
        }, error -> {});

        new android.os.Handler(Looper.getMainLooper()).postDelayed(
                new Runnable() {
                    @Override
                    public void run() {

                        gameTick();
                    }
                },
        2000);
    }

    private void gameTick() {
        RandomNumberGenerator optionIdx = new RandomNumberGenerator(7);

        correctAnsIdx = ansIdx.generate();
        key = countryDataList.get(correctAnsIdx);
        GameText.setText("What continent is " + key.getName() + " on?");

        switch(correctAnsIdx) {
            case 0:
                Opt0.setText(key.getContinent());

                Opt1.setText(Continents[optionIdx.generate()]);
                Opt2.setText(Continents[optionIdx.generate()]);
                Opt3.setText(Continents[optionIdx.generate()]);
                break;
            case 1:
                Opt1.setText(key.getContinent());

                Opt0.setText(Continents[optionIdx.generate()]);
                Opt2.setText(Continents[optionIdx.generate()]);
                Opt3.setText(Continents[optionIdx.generate()]);
                break;
            case 2:
                Opt2.setText(key.getContinent());

                Opt0.setText(Continents[optionIdx.generate()]);
                Opt1.setText(Continents[optionIdx.generate()]);
                Opt3.setText(Continents[optionIdx.generate()]);
                break;
            case 3:
                Opt3.setText(key.getContinent());

                Opt0.setText(Continents[optionIdx.generate()]);
                Opt1.setText(Continents[optionIdx.generate()]);
                Opt2.setText(Continents[optionIdx.generate()]);
                break;
        }

        Opt0.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (correctAnsIdx == 0) {
                    updateScore();
                }

                checkGameOver();
                gameTick();
            }
        });
        Opt1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (correctAnsIdx == 1) {
                    updateScore();
                }

                checkGameOver();
                gameTick();
            }
        });

        Opt2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (correctAnsIdx == 2) {
                    updateScore();
                }

                checkGameOver();
                gameTick();
            }
        });

        Opt3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (correctAnsIdx == 3) {
                    updateScore();
                }

                checkGameOver();
                gameTick();
            }
        });
    }

    private void updateScore() {
        score += 1;
        ScoreText.setText(Integer.toString(score));
    }

    private void checkGameOver() {
        rounds--;
        if (rounds <= 0) {
            CapitalQuiz newCapitalQuiz = new CapitalQuiz();
            newCapitalQuiz.setScore(score);
            GetCapitalQuizApi().PostCapitalQuizByBody(newCapitalQuiz);
            Intent intent = new Intent(ContinentsQuiz.this, ResultScreen.class);
            intent.putExtra("DurationText", Integer.toString(score));
            startActivity(intent);
        }
    }
}