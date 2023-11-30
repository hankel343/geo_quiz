package com.example.geoquizfrontend;

import static com.example.geoquizfrontend.ApiClientFactory.GetGeoQuizApi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.geoquizfrontend.models.Quiz;
import com.example.geoquizfrontend.services.ApiService;

import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class StudentPastScores extends AppCompatActivity {

    Set<Quiz> pastQuizzes;
    final StudentPastScores activity = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_past_scores);

        SharedPreferences sharedPreferences = getSharedPreferences("UserInfo", MODE_PRIVATE);
        long userId = sharedPreferences.getLong("id", 0);

        ApiService apiService = GetGeoQuizApi();
        Call<Set<Quiz>> call = apiService.getQuizzesByUserId(userId);
        call.enqueue(new Callback<Set<Quiz>>() {
            @Override
            public void onResponse(Call<Set<Quiz>> call, Response<Set<Quiz>> response) {
                if (response.isSuccessful()) {
                    pastQuizzes = response.body();

                    TableLayout scoreTable = findViewById(R.id.scoreTable);
                    scoreTable.removeAllViews();

                    // create table header row
                    TableRow headerRow = new TableRow(activity);

                    TextView scoreHeaderTextView = new TextView(activity);
                    scoreHeaderTextView.setText("Score");
                    headerRow.addView(scoreHeaderTextView);

                    TextView durationHeaderTextView = new TextView(activity);
                    durationHeaderTextView.setText("Duration");
                    headerRow.addView(durationHeaderTextView);

                    scoreTable.addView(headerRow);

                    // create table data rows
                    for (Quiz quiz: pastQuizzes) {
                        TableRow row = new TableRow(activity);

                        TextView scoreTextView = new TextView(activity);
                        scoreTextView.setText(String.valueOf(quiz.getScore()));
                        row.addView(scoreTextView);

                        TextView durationTextView = new TextView(activity);
                        durationTextView.setText(String.valueOf(quiz.getDuration()));
                        row.addView(durationTextView);

                        scoreTable.addView(row);
                    }
                }
            }

            @Override
            public void onFailure(Call<Set<Quiz>> call, Throwable t) {

            }
        });


    }
}