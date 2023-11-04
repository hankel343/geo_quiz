package com.example.geoquizfrontend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ProfessorAccountHome extends AppCompatActivity {

    Button SignOutBtn, CreateClassBtn, ViewClassesBtn;
    TextView WelcomeText, EmailText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor_account_home);

        SharedPreferences sharedPreferences = getSharedPreferences("UserInfo", MODE_PRIVATE);

        // retrieve the currently logged in user's data
        String firstName = sharedPreferences.getString("firstName", "");
        String email = sharedPreferences.getString("email", "");

        WelcomeText = (TextView) findViewById(R.id.welcome_text);
        WelcomeText.setText("Welcome, " + firstName);

        EmailText = (TextView) findViewById(R.id.email_text);
        EmailText.setText("Email: " + email);

        CreateClassBtn = (Button) findViewById(R.id.createClass_btn);
        ViewClassesBtn = (Button) findViewById(R.id.viewClasses_btn);
        SignOutBtn = (Button) findViewById(R.id.signOut_btn);

        CreateClassBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(
//                        new Intent(ProfessorAccountHome.this, CreateClassActivity.class)
//                );
            }
        });

        SignOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();

                startActivity(
                        new Intent(ProfessorAccountHome.this, MainActivity.class)
                );
            }
        });
    }
}
