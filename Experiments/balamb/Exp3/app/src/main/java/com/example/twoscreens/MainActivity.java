package com.example.twoscreens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Button b1, b2;
    EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.Meow);
        b2 = (Button) findViewById(R.id.SaveMessage);
        text = (EditText) findViewById(R.id.text);

        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(getApplicationContext(),"Meow :3", Toast.LENGTH_LONG).show();
            }
        });
        b2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String getText = text.getText().toString();
                Intent intent = new Intent(MainActivity.this, Screen2.class);
                intent.putExtra("text", getText);
                startActivity(intent);
            }
        });
    }
}