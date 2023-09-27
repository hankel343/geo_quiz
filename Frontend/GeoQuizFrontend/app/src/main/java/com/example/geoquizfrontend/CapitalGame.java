package com.example.geoquizfrontend;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.*;
import android.os.Bundle;

public class CapitalGame extends AppCompatActivity {
    TextView CapitalText;
    Button CapitalA1, CapitalA2, CapitalA3, CapitalA4;
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capital_game);

        CapitalText = (TextView) findViewById(R.id.CapitalQuestion);
        CapitalA1 = (Button) findViewById(R.id.CapitalButtonA1);
        CapitalA2 = (Button) findViewById(R.id.CapitalButtonA2);
        CapitalA3 = (Button) findViewById(R.id.CapitalButtonA3);
        CapitalA4 = (Button) findViewById(R.id.CapitalButtonA4);

        CapitalA1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(getApplicationContext(),"Correct!", Toast.LENGTH_LONG).show();
            }
        });
        CapitalA2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(getApplicationContext(),"Incorrect!", Toast.LENGTH_LONG).show();
            }
        });
        CapitalA3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(getApplicationContext(),"Incorrect!", Toast.LENGTH_LONG).show();
            }
        });
        CapitalA4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(getApplicationContext(),"Incorrect!", Toast.LENGTH_LONG).show();
            }
        });
    }
}