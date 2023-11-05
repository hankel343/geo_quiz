package com.example.geoquizfrontend;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.geoquizfrontend.models.GameData;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PopulationHiLo extends AppCompatActivity {
    private TextView PopulationRules1, PopulationRules2, Countryone, PopulationOne, Countrytwo, PopulationTwo, PopScore, HighPopScore;
    private Button HigherBtn, LowerBtn;
    private int score = 0;
    private int highScore = 0;
    private int populationOne = 0;
    private int populationTwo = 1;
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

        ApiService apiService = ApiClientFactory.GetCapitalQuizApi();
        Call<ArrayList<GameData>> call = apiService.GetGameData(2);


        call.enqueue(new Callback<ArrayList<GameData>>() {
            @Override
            public void onResponse(Call<ArrayList<GameData>> call, Response<ArrayList<GameData>> response) {
                if (response.isSuccessful()) {
                    // assign game data objects here
                    // e.g.

                    ArrayList<GameData> dummy = response.body();
                    countryOne = dummy.get(0).getName();
                    countryTwo = dummy.get(1).getName();
                    populationOne = dummy.get(0).getPopulation();
                    populationTwo = dummy.get(1).getPopulation();
                    Countryone.setText(countryOne);
                    Countrytwo.setText(countryTwo);
                    PopulationTwo.setText(Integer.toString(populationTwo));
                }
            }

            @Override
            public void onFailure(Call<ArrayList<GameData>> call, Throwable t) {

            }
        });




        HigherBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(populationOne >= populationTwo){
                    PopulationTwo.setTextColor(Color.GREEN);
                    Countrytwo.setText(countryOne);
                    populationTwo = populationOne;
                    PopulationTwo.setText(Integer.toString(populationOne));
                    updateScore();
                }else{
                    resetScore();
                    PopulationTwo.setTextColor(Color.RED);
                    Countrytwo.setText(countryOne);
                    populationTwo = populationOne;
                    PopulationTwo.setText(Integer.toString(populationOne));
                }
                Call<ArrayList<GameData>> call = apiService.GetGameData(1);
                call.enqueue(new Callback<ArrayList<GameData>>() {
                    @Override
                    public void onResponse(Call<ArrayList<GameData>> call, Response<ArrayList<GameData>> response) {
                        if (response.isSuccessful()) {
                            // assign game data objects here
                            // e.g.

                            ArrayList<GameData> dummy = response.body();
                            countryOne = dummy.get(0).getName();
                            populationOne = dummy.get(0).getPopulation();
                            Countryone.setText(countryOne);
                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<GameData>> call, Throwable t) {

                    }
                });
            }
        });

        LowerBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(populationOne <= populationTwo){
                    PopulationTwo.setTextColor(Color.GREEN);
                    Countrytwo.setText(countryOne);
                    populationTwo = populationOne;
                    PopulationTwo.setText(Integer.toString(populationOne));
                    updateScore();
                }else{
                    resetScore();
                    PopulationTwo.setTextColor(Color.RED);
                    Countrytwo.setText(countryOne);
                    populationTwo = populationOne;
                    PopulationTwo.setText(Integer.toString(populationOne));
                }
                Call<ArrayList<GameData>> call = apiService.GetGameData(1);
                call.enqueue(new Callback<ArrayList<GameData>>() {
                    @Override
                    public void onResponse(Call<ArrayList<GameData>> call, Response<ArrayList<GameData>> response) {
                        if (response.isSuccessful()) {
                            // assign game data objects here
                            // e.g.

                            ArrayList<GameData> dummy = response.body();
                            countryOne = dummy.get(0).getName();
                            populationOne = dummy.get(0).getPopulation();
                            Countryone.setText(countryOne);
                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<GameData>> call, Throwable t) {

                    }
                });
            }
        });
    }
    private void updateScore() {
        score += 1;
        PopScore.setText("Score: " + Integer.toString(score));
    }
    private void resetScore() {
        if(score > highScore){
            highScore = score;
            HighPopScore.setText("High Score: " + Integer.toString(highScore));
        }
        score = 0;
        PopScore.setText("Score: " + Integer.toString(score));
    }
}