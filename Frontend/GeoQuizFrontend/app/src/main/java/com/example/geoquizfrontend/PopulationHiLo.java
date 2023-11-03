package com.example.geoquizfrontend;

import androidx.appcompat.app.AppCompatActivity;
import static com.example.geoquizfrontend.ApiClientFactory.GetCapitalQuizApi;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.geoquizfrontend.models.GameData;
import com.example.geoquizfrontend.models.CapitalQuiz;
import com.example.geoquizfrontend.services.CountryService;
import com.example.geoquizfrontend.services.RandomNumberGenerator;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PopulationHiLo extends AppCompatActivity {
    private TextView PopulationRules1, PopulationRules2, Countryone, PopulationOne, Countrytwo, PopulationTwo, PopScore, HighPopScore;
    private Button HigherBtn, LowerBtn;
    private int score = 0;
    private int highScore = 0;
    private int populationOne = 0;
    private int populationTwo = 0;
    private String countryOne = "testing";
    private String countryTwo = "broken";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_population_hi_lo);

        PopulationRules1 = (TextView) findViewById(R.id.PopulationRules1);
        PopulationRules2 = (TextView) findViewById(R.id.PopulationRules2);
        Countryone = (TextView) findViewById(R.id.Countryone);
        PopulationOne = (TextView) findViewById(R.id.PopulationOne);
        Countrytwo = (TextView) findViewById(R.id.Countrytwo);
        PopulationTwo = (TextView) findViewById(R.id.Populationtwo);
        PopScore = (TextView) findViewById(R.id.PopScore);
        HighPopScore = (TextView) findViewById(R.id.HighPopScore);
        HigherBtn = (Button) findViewById(R.id.HigherBtn);
        LowerBtn = (Button) findViewById(R.id.LowerBtn);

        CapitalQuizApi apiService = ApiClientFactory.GetCapitalQuizApi();
        Call<GameData> call = apiService.GetGameData();



        call.enqueue(new Callback<GameData>() {
            @Override
            public void onResponse(Call<GameData> call, Response<GameData> response) {
                if (response.isSuccessful()) {
                    // assign game data objects here
                    // e.g.
                    GameData dummy = response.body();
                    countryTwo = dummy.getName();
                    populationTwo = dummy.getPopulation();
                    Countrytwo.setText(countryTwo);
                    PopulationTwo.setText(Integer.toString(populationTwo));
                    System.out.println(dummy.getPopulation());
                }
            }

            @Override
            public void onFailure(Call<GameData> call, Throwable t) {

            }
        });




        HigherBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(populationOne >= populationTwo){
                    PopulationOne.setTextColor(Color.GREEN);
                    Countryone.setText(countryTwo);
                    PopulationOne.setText(Integer.toString(populationTwo));
                    updateScore();
                }else{
                    resetScore();
                    PopulationOne.setTextColor(Color.RED);
                    Countryone.setText(countryTwo);
                    PopulationOne.setText(Integer.toString(populationTwo));
                }
            }
        });

        LowerBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(populationOne <= populationTwo){
                    PopulationOne.setTextColor(Color.GREEN);
                    Countryone.setText(countryTwo);
                    PopulationOne.setText(Integer.toString(populationTwo));
                    updateScore();
                }else{
                    resetScore();
                    PopulationOne.setTextColor(Color.RED);
                    Countryone.setText(countryTwo);
                    PopulationOne.setText(Integer.toString(populationTwo));
                }

            }
        });
    }
    private void updateScore() {
        score += 1;
        PopScore.setText("Score: " + Integer.toString(score));
    }
    private void resetScore() {
        if(score > highScore){
            HighPopScore.setText("High Score: " + Integer.toString(score));
        }
        score = 0;
        PopScore.setText("Score: " + Integer.toString(score));
    }
}