package com.example.geoquizfrontend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.geoquizfrontend.models.Professor;
import com.example.geoquizfrontend.services.ApiService;
import com.google.android.material.button.MaterialButton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfessorSignInActivity extends AppCompatActivity {
    private MaterialButton signInBtn, newUserBtn;
    private EditText emailInput, passwordInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor_sign_in_actiivity);

        signInBtn = findViewById(R.id.sign_in_btn);
        newUserBtn = findViewById(R.id.new_user_btn);

        emailInput = findViewById(R.id.email_input);
        passwordInput = findViewById(R.id.password_input);

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailInput.getText().toString().trim();
                String password = passwordInput.getText().toString().trim();

                ApiService api = ApiClientFactory.GetGeoQuizApi();
                Call<Boolean> call = api.professorExistsByEmail(email);

                call.enqueue(new Callback<Boolean>() {
                    @Override
                    public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                        if (response.isSuccessful()) {
                            boolean exists = response.body();
                            if (exists) {
                                Call<Professor> authenticateCall = api.authenticateProfessor(email, password);
                                authenticateCall.enqueue(new Callback<Professor>() {
                                    @Override
                                    public void onResponse(Call<Professor> call, Response<Professor> response) {
                                        if (response.isSuccessful()) {
                                            // The professor's information is retrieved
                                            Professor professor = response.body();

                                            SharedPreferences sharedPreferences = getSharedPreferences("UserInfo", MODE_PRIVATE);
                                            SharedPreferences.Editor editor = sharedPreferences.edit();
                                            editor.putLong("id", professor.getId());
                                            editor.putString("firstName", professor.getFirstName());
                                            editor.putString("lastName", professor.getLastName());
                                            editor.putString("email", professor.getEmail());
                                            editor.apply();

                                            Toast.makeText(ProfessorSignInActivity.this, "Welcome, " + sharedPreferences.getString("firstName", ""), Toast.LENGTH_SHORT).show();
                                            startActivity(
                                                    new Intent(ProfessorSignInActivity.this, ProfessorAccountHome.class)
                                            );
                                        } else {
                                            // The professor is not authenticated
                                            Toast.makeText(ProfessorSignInActivity.this, "Incorrect password", Toast.LENGTH_SHORT).show();
                                        }
                                    }

                                    @Override
                                    public void onFailure(Call<Professor> call, Throwable t) {
                                        // Handle the error
                                    }
                                });
                            } else {
                                Toast.makeText(ProfessorSignInActivity.this, "No account associated with email: " + email, Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<Boolean> call, Throwable t) {
                        // Handle the error
                    }
                });
            }
        });

        newUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(
                        new Intent(ProfessorSignInActivity.this, ProfessorAccountCreation.class)
                );
            }
        });
    }
}