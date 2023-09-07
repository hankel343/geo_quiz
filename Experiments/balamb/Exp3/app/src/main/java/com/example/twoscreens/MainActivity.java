package com.example.twoscreens;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.*;
import java.util.*;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Button b1, b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.Meow);
        b2 = (Button) findViewById(R.id.Screen2);

        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(getApplicationContext(),"Meow :3", Toast.LENGTH_LONG).show();
            }
        });
        b2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(getApplicationContext(),"Welcome to Com S 309 Demo1!", Toast.LENGTH_LONG).show();
            }
        });
    }
}