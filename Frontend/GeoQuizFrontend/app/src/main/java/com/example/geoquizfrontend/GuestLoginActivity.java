package com.example.geoquizfrontend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GuestLoginActivity extends AppCompatActivity {

    private EditText initialsEditText;
    private Button goButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_login);

        initialsEditText = findViewById(R.id.initials_text);
        goButton = findViewById(R.id.go_btn);

        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String initials = initialsEditText.getText().toString();
                if (initials.isEmpty()) {
                    Toast.makeText(GuestLoginActivity.this, "Please enter your initials", Toast.LENGTH_SHORT).show();
                } else {
                    startActivity(
                            new Intent(GuestLoginActivity.this, GamescreenActivity.class)
                    );
                }
            }
        });
    }
}
