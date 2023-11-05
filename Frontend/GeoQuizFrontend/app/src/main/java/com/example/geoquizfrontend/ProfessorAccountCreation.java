package com.example.geoquizfrontend;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.geoquizfrontend.models.Professor;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfessorAccountCreation extends AppCompatActivity {

    Button SignUpBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor_account_creation);

        EditText editTextFirstName = findViewById(R.id.firstName_text);
        EditText editTextLastName = findViewById(R.id.lastName_text);
        EditText editTextEmail = findViewById(R.id.editTextEmailAddress);
        EditText editTextPassword = findViewById(R.id.Password_text);
        EditText editTextConfirmPassword = findViewById(R.id.passwordConfirm_text);

        SignUpBtn = (Button) findViewById(R.id.signup_btn);

        SignUpBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String firstName = editTextFirstName.getText().toString();
                String lastName = editTextLastName.getText().toString();
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();
                String confirmPassword = editTextConfirmPassword.getText().toString();

                if (!password.equals(confirmPassword)) {
                    Toast.makeText(getApplicationContext(), "Passwords do not match", Toast.LENGTH_SHORT).show();
                    return;
                }

                Professor professor = new Professor();
                professor.setFirstName(firstName);
                professor.setLastName(lastName);
                professor.setEmail(email);
                professor.setPassword(password);

                ApiService apiService = ApiClientFactory.GetCapitalQuizApi();
                Call<Professor> call = apiService.postNewProfessor(professor);

                call.enqueue(new Callback<Professor>() {
                    @Override
                    public void onResponse(Call<Professor> call, Response<Professor> response) {
                        if (response.isSuccessful()) {
                            // route to home page; success toast message
                            Professor returnedProfessor = response.body();

                            SharedPreferences sharedPreferences = getSharedPreferences("UserInfo", MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            assert returnedProfessor != null;
                            editor.putLong("id", returnedProfessor.getId());
                            editor.putString("firstName", returnedProfessor.getFirstName());
                            editor.putString("lastName", returnedProfessor.getLastName());
                            editor.putString("email", returnedProfessor.getEmail());
                            editor.apply();

                            Toast.makeText(getApplicationContext(), "Welcome, " + sharedPreferences.getString("firstName", ""), Toast.LENGTH_SHORT).show();
                            startActivity(
                                    new Intent(ProfessorAccountCreation.this, ProfessorAccountHome.class)
                            );
                        } else {
                            Toast.makeText(getApplicationContext(), "Failed to create account", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Professor> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Network error", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
