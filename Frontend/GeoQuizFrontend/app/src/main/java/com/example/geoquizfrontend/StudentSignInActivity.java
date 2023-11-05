package com.example.geoquizfrontend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.geoquizfrontend.models.Student;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

                ApiService api = ApiClientFactory.GetCapitalQuizApi();
                Call<Boolean> call = api.existsByEmail(email);

                call.enqueue(new Callback<Boolean>() {
                    @Override
                    public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                        if (response.isSuccessful()) {
                            boolean exists = response.body();
                            if (exists) {
                                Call<Student> authenticateCall = api.authenticate(email, password);
                                authenticateCall.enqueue(new Callback<Student>() {
                                    @Override
                                    public void onResponse(Call<Student> call, Response<Student> response) {
                                        if (response.isSuccessful()) {
                                            // The student's information is retrieved
                                            Student student = response.body();

                                            SharedPreferences sharedPreferences = getSharedPreferences("UserInfo", MODE_PRIVATE);
                                            SharedPreferences.Editor editor = sharedPreferences.edit();
                                            editor.putLong("id", student.getId());
                                            editor.putString("firstName", student.getFirstName());
                                            editor.putString("lastName", student.getLastName());
                                            editor.putString("email", student.getEmail());
                                            editor.putString("classCode", student.getClassCode());
                                            editor.putFloat("grade", student.getGrade());
                                            editor.apply();

                                            Toast.makeText(StudentSignInActivity.this, "Welcome, " + sharedPreferences.getString("firstName", ""), Toast.LENGTH_SHORT).show();
                                            startActivity(
                                                    new Intent(StudentSignInActivity.this, StudentAccountHome.class)
                                            );
                                        } else {
                                            // The student is not authenticated
                                            Toast.makeText(StudentSignInActivity.this, "Incorrect password", Toast.LENGTH_SHORT).show();
                                        }
                                    }

                                    @Override
                                    public void onFailure(Call<Student> call, Throwable t) {
                                        // Handle the error
                                    }
                                });
                            } else {
                                Toast.makeText(StudentSignInActivity.this, "No account associated with email: " + email, Toast.LENGTH_SHORT).show();
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
            public void onClick(View v) {
                startActivity(
                        new Intent(StudentSignInActivity.this, StudentAccountCreation.class)
                );
            }
        });

    }
}
