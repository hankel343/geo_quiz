package com.example.twoscreens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import java.util.*;
import android.os.Bundle;

public class Screen2 extends AppCompatActivity {
    Button b4;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        b4 = (Button) findViewById(R.id.BacktoStart);
        text = findViewById(R.id.set_text);

        Intent intent = getIntent();
        String getText = intent.getStringExtra("text");
        text.setText(getText);
        b4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(Screen2.this, MainActivity.class);
                startActivity(i);
            }
        });



    }
}