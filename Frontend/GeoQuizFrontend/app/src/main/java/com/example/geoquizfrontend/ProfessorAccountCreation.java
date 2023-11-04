package com.example.geoquizfrontend;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.geoquizfrontend.ApiClientFactory;
import com.example.geoquizfrontend.CapitalQuizApi;
import com.example.geoquizfrontend.R;
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

                Professor professor = new Professor();
                professor.setFirstName(firstName);
                professor.setLastName(lastName);
                professor.setEmail(email);
                professor.setPassword(password);

                CapitalQuizApi apiService = ApiClientFactory.GetCapitalQuizApi();
                Call<Professor> call = apiService.postNewProfessor(professor);

                call.enqueue(new Callback<Professor>() {
                    @Override
                    public void onResponse(Call<Professor> call, Response<Professor> response) {
                        // Similar to the StudentAccountCreation class
                        // ...
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
