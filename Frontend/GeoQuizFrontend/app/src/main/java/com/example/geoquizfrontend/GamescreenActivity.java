package com.example.geoquizfrontend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class GamescreenActivity extends AppCompatActivity {
    Button flagGame, capitalGame, backBtn, continentsGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamescreen);

        capitalGame = (Button) findViewById(R.id.CapitalGameB);
        flagGame = (Button) findViewById(R.id.FlagGameB);
        continentsGame = (Button) findViewById(R.id.continents_btn);
        backBtn = (Button) findViewById(R.id.back_btn);

        capitalGame.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(GamescreenActivity.this, CapitalGame.class);
                startActivity(intent);
            }
        });
        flagGame.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(GamescreenActivity.this, FlagGame.class);
                startActivity(intent);
            }
        });

        continentsGame.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(GamescreenActivity.this, ContinentsQuiz.class);
                startActivity(intent);
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GamescreenActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}