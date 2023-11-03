package com.example.geoquizfrontend;

import androidx.appcompat.app.AppCompatActivity;
import static com.example.geoquizfrontend.ApiClientFactory.GetCapitalQuizApi;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.geoquizfrontend.models.GameData;
import com.example.geoquizfrontend.models.CapitalQuiz;
import com.example.geoquizfrontend.services.CountryService;
import com.example.geoquizfrontend.services.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PopulationHiLo extends AppCompatActivity {
    private TextView PopulationRules1, PopulationRules2, Countryone, PopulationOne, Countrytwo, Populationtwo, PopScore, HighPopScore;
    private Button HigherBtn, LowerBtn;
    private int score = 0;
    private int populationOne = 0;
    private int populationTwo = 0;
    private String countryOne = "broken";
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
        Populationtwo = (TextView) findViewById(R.id.Populationtwo);
        PopScore = (TextView) findViewById(R.id.PopScore);
        HighPopScore = (TextView) findViewById(R.id.HighPopScore);
        HigherBtn = (Button) findViewById(R.id.HigherBtn);
        LowerBtn = (Button) findViewById(R.id.LowerBtn);

        CapitalQuizApi apiService = ApiClientFactory.GetCapitalQuizApi();
        Call<ArrayList<GameData>> call = apiService.GetGameData(2);

        call.enqueue(new Callback<ArrayList<GameData>>() {
            @Override
            public void onResponse(Call<ArrayList<GameData>> call, Response<ArrayList<GameData>> response) {
                if (response.isSuccessful()) {
                    // assign game data objects here
                    // e.g.
                    ArrayList<GameData> dummy = response.body();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<GameData>> call, Throwable t) {

            }
        });

//        call.enqueue(new Callback<List<GameData>>() {
//            @Override
//            public void onResponse(Call<List<GameData>> call, Response<List<GameData>> response) {
//                if (response.isSuccessful()) {
//                    countryDataList = response.body();
//                    gameTick();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<GameData>> call, Throwable t) {
//
//            }
//        });
        HigherBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(populationOne >= populationTwo){
                    Populationtwo.setTextColor(Color.GREEN);
                    Countryone.setText(countryTwo);
                    PopulationOne.setText(Integer.toString(populationTwo));
                    updateScore();
                }
            }
        });

        LowerBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(populationOne <= populationTwo){
                    Populationtwo.setTextColor(Color.GREEN);
                    Countryone.setText(countryTwo);
                    PopulationOne.setText(Integer.toString(populationTwo));
                    updateScore();
                }else{

                }

            }
        });
    }
    private void updateScore() {
        score += 1;
        PopScore.setText(Integer.toString(score));
    }
}