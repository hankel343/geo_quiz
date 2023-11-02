package com.example.geoquizfrontend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class AccountHomeActivity extends AppCompatActivity {

    Button SignOutBtn, PlayQuizBtn, PastScoresBtn;
    TextView WelcomeText, EmailText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_home);

        SharedPreferences sharedPreferences = getSharedPreferences("UserInfo", MODE_PRIVATE);

        // retrieve the currently logged in user's data
        String firstName = sharedPreferences.getString("firstName", "");
        String email = sharedPreferences.getString("email", "");

        WelcomeText = (TextView) findViewById(R.id.welcome_text);
        WelcomeText.setText("Welcome, " + firstName);

        EmailText = (TextView) findViewById(R.id.email_text);
        EmailText.setText("Email: " + email);

        SignOutBtn = (Button) findViewById(R.id.playQuizzes_btn);
        PastScoresBtn = (Button) findViewById(R.id.pastScores_btn);
        SignOutBtn = (Button) findViewById(R.id.signOut_btn);
    }
}