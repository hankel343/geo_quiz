package com.example.geoquizfrontend;

import static com.example.geoquizfrontend.ApiClientFactory.GetCapitalQuizApi;

import com.example.geoquizfrontend.ApiClientFactory;
import androidx.appcompat.app.AppCompatActivity;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_screen);
        YourScore = (TextView) findViewById(R.id.YourScore);
        DurationText = (TextView) findViewById(R.id.DurationText);
        GetCapitalQuizApi().GetCapitalQuizByPath("1").enqueue(new SlimCallback<CapitalQuiz>(Quiz->{
            YourScore.setText(Quiz.getScore());
        }));


    }
}