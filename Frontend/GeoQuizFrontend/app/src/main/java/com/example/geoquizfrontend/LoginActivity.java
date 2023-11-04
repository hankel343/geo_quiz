package com.example.geoquizfrontend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    Button StudentLogin, ProfessorLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        StudentLogin = (Button) findViewById(R.id.student_btn);
        ProfessorLogin = (Button) findViewById(R.id.professor_btn);

        StudentLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(
                        new Intent(LoginActivity.this, StudentSignInActivity.class)
                );
            }
        });

        ProfessorLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(
                        new Intent(LoginActivity.this, ProfessorAccountCreation.class)
                );
            }
        });
    }
}