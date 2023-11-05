package com.example.geoquizfrontend;

import static com.example.geoquizfrontend.ApiClientFactory.GetGeoQuizApi;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import com.example.geoquizfrontend.models.Quiz;
import com.example.geoquizfrontend.models.GameData;

import com.example.geoquizfrontend.services.CountryService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CapitalGame extends AppCompatActivity {
    private TextView CapitalText, ScoreText, TimerText;

    static String whatQuestion, scoreText, whatAnswer;
    static int Score, question;
    private Button CapitalA1, CapitalA2, CapitalA3, CapitalA4, QuitBtn;
    private CountDownTimer countDownTimer;
    private long timeLeftInMilliseconds = 60000;
    private boolean timerRunning;
    String URL_JSON_OBJECT = "https://b137d5c3-5a11-4d97-bcb0-56f3fb9dedc3.mock.pstmn.io/Object/1";
    List<GameData> countryDataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capital_game);

        // Create CountryService object to retrieve raw game data
        countryDataList = new ArrayList<>();
        CountryService countryService = new CountryService(this);
        countryService.getData(response -> {
            countryDataList = countryService.parseGameDataResponse(response);
            System.out.println(countryDataList.size());
        }, error -> {});

        new android.os.Handler(Looper.getMainLooper()).postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        makeJsonObjReq();
                    }
                },
                3000);

        CapitalText = (TextView) findViewById(R.id.gameText);
        ScoreText = (TextView) findViewById(R.id.ScoreText);
        TimerText = (TextView) findViewById(R.id.timer);
        CapitalA1 = (Button) findViewById(R.id.opt0_btn);
        CapitalA2 = (Button) findViewById(R.id.opt1_btn);
        CapitalA3 = (Button) findViewById(R.id.opt2_btn);
        CapitalA4 = (Button) findViewById(R.id.opt3_btn);
        QuitBtn = (Button) findViewById(R.id.quit_btn);
        question = 1;

        startTimer();
        updateTimer();
        CapitalA1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startStop();
                if(getWhatAnswer().toString().trim().equals("1")) {
                    Score = Score + 1 + (5*(Math.toIntExact(timeLeftInMilliseconds) / 1000));
                    scoreText = Integer.toString(Score);
                    ScoreText.setText("Score: " + scoreText);
                }
                question = question + 1;
                if (question > 5) {
                    Quiz newQuiz = new Quiz();
                    newQuiz.setScore(Score);
                    GetGeoQuizApi().PostCapitalQuizByBody(newQuiz);
                    Intent intent = new Intent(CapitalGame.this, ResultScreen.class);
                    intent.putExtra("DurationText", scoreText);
                    startActivity(intent);
                }
                whatQuestion = Integer.toString(question);
                URL_JSON_OBJECT = "https://b137d5c3-5a11-4d97-bcb0-56f3fb9dedc3.mock.pstmn.io/Object/" + whatQuestion;
                makeJsonObjReq();
                timeLeftInMilliseconds = 60000;
                startStop();
            }

        });
        CapitalA2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startStop();
                if(getWhatAnswer().toString().trim().equals("2")){
                    Score = Score + 1 + (5*(Math.toIntExact(timeLeftInMilliseconds) / 1000));
                    scoreText = Integer.toString(Score);
                    ScoreText.setText("Score: " + scoreText);
                }
                question = question + 1;
                if (question > 5) {
                    Quiz newQuiz = new Quiz();
                    newQuiz.setScore(Score);
                    GetGeoQuizApi().PostCapitalQuizByBody(newQuiz);
                    Intent intent = new Intent(CapitalGame.this, ResultScreen.class);
                    intent.putExtra("DurationText", scoreText);
                    startActivity(intent);
                }
                whatQuestion = Integer.toString(question);
                URL_JSON_OBJECT = "https://b137d5c3-5a11-4d97-bcb0-56f3fb9dedc3.mock.pstmn.io/Object/" + whatQuestion;
                makeJsonObjReq();
                timeLeftInMilliseconds = 60000;
                startStop();
            }
        });
        CapitalA3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startStop();
                if(getWhatAnswer().toString().trim().equals("3")){
                    Score = Score + 1 + (5*(Math.toIntExact(timeLeftInMilliseconds) / 1000));
                    scoreText = Integer.toString(Score);
                    ScoreText.setText("Score: " + scoreText);
                }
                question = question + 1;
                if (question > 5) {
                   Quiz newQuiz = new Quiz();
                   newQuiz.setScore(Score);
                   GetGeoQuizApi().PostCapitalQuizByBody(newQuiz);
                   Intent intent = new Intent(CapitalGame.this, ResultScreen.class);
                   intent.putExtra("DurationText", scoreText);
                   startActivity(intent);
                }
                whatQuestion = Integer.toString(question);
                URL_JSON_OBJECT = "https://b137d5c3-5a11-4d97-bcb0-56f3fb9dedc3.mock.pstmn.io/Object/" + whatQuestion;
                makeJsonObjReq();
                timeLeftInMilliseconds = 60000;
                startStop();
            }
        });
        CapitalA4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                startStop();
                if(getWhatAnswer().toString().trim().equals("4")){
                    Score = Score + 1 + (5*(Math.toIntExact(timeLeftInMilliseconds) / 1000));
                    scoreText = Integer.toString(Score);
                    ScoreText.setText("Score: " + scoreText);
                }
                question = question + 1;
                if (question > 5) {
                    Quiz newQuiz = new Quiz();
                    newQuiz.setScore(Score);
                    GetGeoQuizApi().PostCapitalQuizByBody(newQuiz);
                    Intent intent = new Intent(CapitalGame.this, ResultScreen.class);
                    intent.putExtra("DurationText", scoreText);
                    startActivity(intent);
                }
                whatQuestion = Integer.toString(question);
                URL_JSON_OBJECT = "https://b137d5c3-5a11-4d97-bcb0-56f3fb9dedc3.mock.pstmn.io/Object/" + whatQuestion;
                makeJsonObjReq();
                timeLeftInMilliseconds = 60000;
                startStop();
            }
        });

        QuitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CapitalGame.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    private void makeJsonObjReq() {
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(
                Request.Method.GET,
                URL_JSON_OBJECT,
                null, // Pass null as the request body since it's a GET request
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("Volley Response", response.toString());
                        try {
                            // Parse JSON object data
                            String capital = response.getString("capital");
                            String capitalB1 = response.getString("buttonone");
                            String capitalB2 = response.getString("buttontwo");
                            String capitalB3 = response.getString("buttonthree");
                            String capitalB4 = response.getString("buttonfour");
                            String answerQ = response.getString("answer");
                            // Populate text views with the parsed data
                            CapitalText.setText("What country has the capital " + countryDataList.get(0).getCapital() + "?");
                            CapitalA1.setText(capitalB1);
                            CapitalA2.setText(capitalB2);
                            CapitalA3.setText(capitalB3);
                            CapitalA4.setText(capitalB4);
                            setWhatAnswer(answerQ);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Volley Error", error.toString());
                    }
                }
        ) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
//                headers.put("Authorization", "Bearer YOUR_ACCESS_TOKEN");
//                headers.put("Content-Type", "application/json");
                return headers;
            }

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
//                params.put("param1", "value1");
//                params.put("param2", "value2");
                return params;
            }
        };

        // Adding request to request queue
        VolleySingleton.getInstance(getApplicationContext()).addToRequestQueue(jsonObjReq);
    }
    public String getWhatAnswer()
    {
        return whatAnswer;
    }

    public void setWhatAnswer(String whatAnswer)
    {
        this.whatAnswer = whatAnswer;
    }
    public void startStop(){
        if(timerRunning){
            stopTimer();
        }else{
            startTimer();
        }
    }
    public void startTimer(){
        countDownTimer = new CountDownTimer(timeLeftInMilliseconds, 1000) {
            @Override
            public void onTick(long l) {
                timeLeftInMilliseconds = l;
                updateTimer();
            }

            @Override
            public void onFinish() {

            }
        }.start();

        timerRunning = true;
    }

    public void stopTimer(){
        countDownTimer.cancel();
        timerRunning = false;
    }

    public void updateTimer(){
        int minutes = (int) timeLeftInMilliseconds / 60000;
        int seconds = (int) timeLeftInMilliseconds % 60000 / 1000;

        String timeLeftText;

        timeLeftText = "" + minutes;
        timeLeftText += ":";
        if(seconds < 10) timeLeftText += "0";
        timeLeftText += seconds;

        TimerText.setText(timeLeftText);
    }

}
