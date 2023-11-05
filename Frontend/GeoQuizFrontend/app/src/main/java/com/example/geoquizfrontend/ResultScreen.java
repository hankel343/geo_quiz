package com.example.geoquizfrontend;

import static com.example.geoquizfrontend.ApiClientFactory.GetCapitalQuizApi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.geoquizfrontend.models.Quiz;
public class ResultScreen extends AppCompatActivity {
    private TextView YourScore, DurationText;
    int quizScore;
    private Button SeeScoreB, PlayAgainBtn;
    String stringQuizScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_screen);

        SharedPreferences sharedPreferences = getSharedPreferences("UserInfo", MODE_PRIVATE);

        YourScore = (TextView) findViewById(R.id.YourScore);
        DurationText = (TextView) findViewById(R.id.DurationText);
        SeeScoreB = (Button) findViewById(R.id.SeeScoreB);
        PlayAgainBtn = (Button) findViewById(R.id.playagain_btn);

        Intent intent = getIntent();
        String getText = intent.getStringExtra("DurationText");
        DurationText.setText(getText);
        quizScore = Integer.parseInt(DurationText.getText().toString());
        Quiz newQuiz = new Quiz();
        newQuiz.setScore(quizScore);
        GetCapitalQuizApi().PutCapitalQuizByPath(1, newQuiz).enqueue(new SlimCallback<Quiz>(CapitalQuiz->{
        }));
        SeeScoreB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetCapitalQuizApi().GetCapitalQuizByPath("1").enqueue(new SlimCallback<Quiz>(CapitalQuiz -> {
                    quizScore = CapitalQuiz.getScore();
                    YourScore.setText("Score: " + Integer.toString(quizScore));
                }));

            }
        });

        PlayAgainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(
                        new Intent(new Intent(ResultScreen.this, GamescreenActivity.class)
                ));
            }
        });
    }
}