package com.example.geoquizfrontend;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.geoquizfrontend.models.GameData;
import com.example.geoquizfrontend.services.CountryService;

import java.util.List;

public class CoatOfArms extends AppCompatActivity {
    TextView GameText, ScoreText;
    Button Opt0, Opt1, Opt2, Opt3;

    private int rounds = 4;
    private int score = 0;
    private String[] countryNames = CountryNames.countries;
    private List<GameData> countryDataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coat_of_arms);

        // External API is timing out
//        CountryService countryService = new CountryService(this);
//        countryNames = countryService.getCountryNames();
//        countryService.getData(response -> {
//            countryDataList = countryService.parseGameDataResponse(response);
//            System.out.println(countryDataList.size());
//        }, error -> {});
    }
}