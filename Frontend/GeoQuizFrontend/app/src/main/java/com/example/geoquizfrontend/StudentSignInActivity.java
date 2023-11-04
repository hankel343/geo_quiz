package com.example.geoquizfrontend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class StudentSignInActivity extends AppCompatActivity {

    private MaterialButton signInBtn;
    private MaterialButton newUserBtn;
    private TextInputEditText emailInput;
    private TextInputEditText passwordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_sign_in);

        signInBtn = findViewById(R.id.sign_in_btn);
        newUserBtn = findViewById(R.id.new_user_btn);
        emailInput = findViewById(R.id.email_input);
        passwordInput = findViewById(R.id.password_input);

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailInput.getText().toString().trim();
                String password = passwordInput.getText().toString().trim();
            }
        });

        newUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(
                        new Intent(StudentSignInActivity.this, StudentAccountCreation.class)
                );
            }
        });

    }
}
