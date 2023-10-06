package com.example.geoquizfrontend;

import static com.example.geoquizfrontend.ApiClientFactory.GetCapitalQuizApi;

import com.example.geoquizfrontend.ApiClientFactory;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.example.geoquizfrontend.CapitalQuiz;
public class ResultScreen extends AppCompatActivity {
    private TextView YourScore, DurationText;
    int quizScore;
    private Button SeeScoreB;
    String stringQuizScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_screen);
        YourScore = (TextView) findViewById(R.id.YourScore);
        DurationText = (TextView) findViewById(R.id.DurationText);
        SeeScoreB = (Button) findViewById(R.id.SeeScoreB);

        Intent intent = getIntent();
        String getText = intent.getStringExtra("DurationText");
        DurationText.setText(getText);
        quizScore = Integer.parseInt(DurationText.getText().toString());
        CapitalQuiz newCapitalQuiz = new CapitalQuiz();
        newCapitalQuiz.setScore(quizScore);
        GetCapitalQuizApi().PutCapitalQuizByPath(1, newCapitalQuiz).enqueue(new SlimCallback<CapitalQuiz>(CapitalQuiz->{
        }));
        SeeScoreB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetCapitalQuizApi().GetCapitalQuizByPath("1").enqueue(new SlimCallback<CapitalQuiz>(CapitalQuiz -> {
                    quizScore = CapitalQuiz.getScore();
                    YourScore.setText("Score: " + Integer.toString(quizScore));
                }));

            }
        });
    }
}