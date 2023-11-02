package com.example.geoquizfrontend;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class PopulationHiLo extends AppCompatActivity {
    private TextView PopulationRules1, PopulationRules2, Countryone, PopulationOne, Countrytwo, Populationtwo, PopScore, HighPopScore;
    private Button HigherBtn, LowerBtn;
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

        
    }
}