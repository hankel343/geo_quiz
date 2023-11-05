package com.example.geoquizfrontend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.geoquizfrontend.models.Student;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentAccountCreation extends AppCompatActivity {

    Button SignUpBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_account_creation);

        EditText editTextFirstName = findViewById(R.id.firstName_text);
        EditText editTestLastName = findViewById(R.id.lastName_text);
        EditText editTextEmail = findViewById(R.id.editTextTextEmailAddress);
        EditText editTextPassword = findViewById(R.id.Password_text);
        EditText editTextConfirmPassword = findViewById(R.id.passwordConfirm_text);
        EditText editTextClassCode = findViewById(R.id.classCode_text);

        SignUpBtn = (Button) findViewById(R.id.signup_btn);

        SignUpBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String firstName = editTextFirstName.getText().toString();
                String lastName = editTestLastName.getText().toString();
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();
                String confirmPassword = editTextConfirmPassword.getText().toString();
                String classCode = editTextClassCode.getText().toString();

                if (!password.equals(confirmPassword)) {
                    Toast.makeText(getApplicationContext(), "Passwords do not match", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    Student student = new Student();
                    student.setFirstName(firstName);
                    student.setLastName(lastName);
                    student.setEmail(email);
                    student.setPassword(password);
                    student.setClassCode(classCode);

                    CapitalQuizApi apiService = ApiClientFactory.GetCapitalQuizApi();
                    Call<Student> call = apiService.postNewStudent(student);

                    call.enqueue(new Callback<Student>() {
                        @Override
                        public void onResponse(Call<Student> call, Response<Student> response) {
                            if (response.isSuccessful()) {
                                // route to home page; success toast message
                                Student returnedStudent = response.body();

                                SharedPreferences sharedPreferences = getSharedPreferences("UserInfo", MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.putLong("id", returnedStudent.getId());
                                editor.putString("firstName", returnedStudent.getFirstName());
                                editor.putString("lastName", returnedStudent.getLastName());
                                editor.putString("email", returnedStudent.getEmail());
                                editor.apply();

                                Toast.makeText(getApplicationContext(), "Welcome, " + sharedPreferences.getString("firstName", ""), Toast.LENGTH_SHORT).show();
                                startActivity(
                                        new Intent(StudentAccountCreation.this, StudentAccountHome.class)
                                );
                            } else {
                                Toast.makeText(getApplicationContext(), "Failed to create account", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<Student> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), "Network error", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }
}