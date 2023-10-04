package com.example.geoquizfrontend;

import static com.example.geoquizfrontend.ApiClientFactory.GetCapitalQuizApi;

import android.content.Intent;
import android.os.Bundle;
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

import java.util.HashMap;
import java.util.Map;

public class CapitalGame extends AppCompatActivity {
    private TextView CapitalText, ScoreText;

    static String whatQuestion, scoreText, whatAnswer;
    static int Score, question;
    private Button CapitalA1, CapitalA2, CapitalA3, CapitalA4;
    String URL_JSON_OBJECT = "https://b137d5c3-5a11-4d97-bcb0-56f3fb9dedc3.mock.pstmn.io/Object/1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capital_game);
        makeJsonObjReq();
        CapitalText = (TextView) findViewById(R.id.CapitalQuestion);
        ScoreText = (TextView) findViewById(R.id.ScoreText);
        CapitalA1 = (Button) findViewById(R.id.CapitalButtonA1);
        CapitalA2 = (Button) findViewById(R.id.CapitalButtonA2);
        CapitalA3 = (Button) findViewById(R.id.CapitalButtonA3);
        CapitalA4 = (Button) findViewById(R.id.CapitalButtonA4);
        question = 1;

        CapitalA1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(getWhatAnswer().toString().trim().equals("1")) {
                    Score = Score + 1;
                    scoreText = Integer.toString(Score);
                    ScoreText.setText("Score: " + scoreText);
                }
                question = question + 1;
                if (question > 5) {
                    //Put newPut = new Put();
                    //newPut.setScore(Score);
                    Intent intent = new Intent(CapitalGame.this, ResultScreen.class);
                    startActivity(intent);
                }
                whatQuestion = Integer.toString(question);
                URL_JSON_OBJECT = "https://b137d5c3-5a11-4d97-bcb0-56f3fb9dedc3.mock.pstmn.io/Object/" + whatQuestion;
                makeJsonObjReq();
            }

        });
        CapitalA2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(getWhatAnswer().toString().trim().equals("2")){
                    Score = Score + 1;
                    scoreText = Integer.toString(Score);
                    ScoreText.setText("Score: " + scoreText);
                }
                question = question + 1;
                if (question > 5) {
                    CapitalQuiz newCapitalQuiz = new CapitalQuiz();
                    newCapitalQuiz.setScore(Score);
                    GetCapitalQuizApi().PostCapitalQuizByBody(newCapitalQuiz);
                    Intent intent = new Intent(CapitalGame.this, ResultScreen.class);
                    startActivity(intent);
                }
                whatQuestion = Integer.toString(question);
                URL_JSON_OBJECT = "https://b137d5c3-5a11-4d97-bcb0-56f3fb9dedc3.mock.pstmn.io/Object/" + whatQuestion;
                makeJsonObjReq();
            }
        });
        CapitalA3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(getWhatAnswer().toString().trim().equals("3")){
                    Score = Score + 1;
                    scoreText = Integer.toString(Score);
                    ScoreText.setText("Score: " + scoreText);
                }
                question = question + 1;
                if (question > 5) {
                   CapitalQuiz newCapitalQuiz = new CapitalQuiz();
                   newCapitalQuiz.setScore(Score);
                   GetCapitalQuizApi().PostCapitalQuizByBody(newCapitalQuiz);
                    Intent intent = new Intent(CapitalGame.this, ResultScreen.class);
                    startActivity(intent);
                }
                whatQuestion = Integer.toString(question);
                URL_JSON_OBJECT = "https://b137d5c3-5a11-4d97-bcb0-56f3fb9dedc3.mock.pstmn.io/Object/" + whatQuestion;
                makeJsonObjReq();
            }
        });
        CapitalA4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                if(getWhatAnswer().toString().trim().equals("4")){
                    Score = Score + 1;
                    scoreText = Integer.toString(Score);
                    ScoreText.setText("Score: " + scoreText);
                }
                question = question + 1;
                if (question > 5) {
                  //  Put newPut = new Put();
                   // newPut.setScore(Score);
                    Intent intent = new Intent(CapitalGame.this, ResultScreen.class);
                    startActivity(intent);
                }
                whatQuestion = Integer.toString(question);
                URL_JSON_OBJECT = "https://b137d5c3-5a11-4d97-bcb0-56f3fb9dedc3.mock.pstmn.io/Object/" + whatQuestion;
                makeJsonObjReq();
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
                            CapitalText.setText("What country has the capital " + capital + "?");
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
}