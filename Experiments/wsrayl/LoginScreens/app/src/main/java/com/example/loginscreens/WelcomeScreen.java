package com.example.loginscreens;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.jar.Attributes;
public class WelcomeScreen {

    @Override
    protected void onCreate(Bundle savedInstanceState) extends{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button firstButton = findViewById(R.id.Press1);

        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(),SecondScreen.class));
            }
        });



    }


}
