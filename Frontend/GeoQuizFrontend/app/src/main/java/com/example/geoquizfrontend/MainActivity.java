package com.example.geoquizfrontend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button GuestButton, LoginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GuestButton = (Button) findViewById(R.id.GuestB);
        LoginButton = (Button) findViewById(R.id.LoginB);
        GuestButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(
                        new Intent(MainActivity.this, GamescreenActivity.class)
                );
            }
        });
        LoginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(
                        new Intent(MainActivity.this, LoginActivity.class)
                );
            }
        });
    }
}