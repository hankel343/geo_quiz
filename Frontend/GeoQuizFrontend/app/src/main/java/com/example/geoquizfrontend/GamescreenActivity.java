package com.example.geoquizfrontend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GamescreenActivity extends AppCompatActivity {
    Button flagGame, capitalGame, continentsGame, coatOfArmsGame, AccountHome, populationHiLo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamescreen);

        SharedPreferences sharedPreferences = getSharedPreferences("UserInfo", MODE_PRIVATE);
        boolean isLoggedIn = sharedPreferences.getString("email", null) != null;

        capitalGame = (Button) findViewById(R.id.CapitalGameB);
        flagGame = (Button) findViewById(R.id.FlagGameB);
        continentsGame = (Button) findViewById(R.id.continents_btn);
        coatOfArmsGame = (Button) findViewById(R.id.coatOfArms_btn);
        AccountHome = (Button) findViewById(R.id.Account_btn);
        populationHiLo = (Button) findViewById(R.id.PopulationHiLo_btn);
        
        // set text according to who is logged in
        AccountHome.setText(isLoggedIn ? "Account" : "Home");

        capitalGame.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(
                        new Intent(GamescreenActivity.this, CapitalGame.class)
                );
            }
        });
        flagGame.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(
                        new Intent(GamescreenActivity.this, FlagGame.class)
                );
            }
        });

        continentsGame.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(
                        new Intent(GamescreenActivity.this, ContinentsQuiz.class)
                );
            }
        });

        coatOfArmsGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(
                        new Intent(GamescreenActivity.this, CoatOfArms.class)
                );
            }
        });

        populationHiLo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(
                        new Intent(GamescreenActivity.this, PopulationHiLo.class)
                );
            }
        });

        AccountHome.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (isLoggedIn) {
                    startActivity(
                            new Intent(GamescreenActivity.this, StudentAccountHome.class)
                    );
                } else {
                    startActivity(
                            new Intent(GamescreenActivity.this, MainActivity.class)
                    );
                }
            }
        });
    }
}