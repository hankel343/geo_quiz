package com.example.geoquizfrontend;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Looper;
import android.widget.Button;
import android.widget.TextView;

import com.example.geoquizfrontend.models.GameData;
import com.example.geoquizfrontend.services.CountryService;
import com.example.geoquizfrontend.services.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class ContinentsQuiz extends AppCompatActivity {

    TextView GameText;

    Button Opt0, Opt1, Opt2, Opt3;

    private int rounds = 5;

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
    private List<GameData> countryDataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continents_quiz);

        GameText = findViewById(R.id.gameText);
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
                        gameLoop();
                    }
                },
        1000);
    }

    private void gameLoop() {
        while (rounds > 0) {
            gameTick();
            rounds--;
        }
    }

    private void gameTick() {
        RandomNumberGenerator optionIdx = new RandomNumberGenerator(7);
        RandomNumberGenerator ansIdx = new RandomNumberGenerator(4);

        int correctAnsIdx = ansIdx.generate();
        GameData key = countryDataList.get(correctAnsIdx);
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


    }
}