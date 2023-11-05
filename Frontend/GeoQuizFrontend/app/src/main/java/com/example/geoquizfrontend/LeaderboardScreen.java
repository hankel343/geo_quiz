package com.example.geoquizfrontend;

import static com.example.geoquizfrontend.ApiClientFactory.GetGeoQuizApi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.geoquizfrontend.models.CapitalQuiz;
import com.example.geoquizfrontend.models.GameData;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LeaderboardScreen extends AppCompatActivity {
    private TextView score1, score2, score3, score4, score5, score6, score7, score8, score9, score10;
    private Button UpdateLeaderboardbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard_screen);

        score1 = (TextView) findViewById(R.id.score1);
        score2 = (TextView) findViewById(R.id.score2);
        score3 = (TextView) findViewById(R.id.score3);
        score4 = (TextView) findViewById(R.id.score4);
        score5 = (TextView) findViewById(R.id.score5);
        score6 = (TextView) findViewById(R.id.score6);
        score7 = (TextView) findViewById(R.id.score7);
        score8 = (TextView) findViewById(R.id.score8);
        score9 = (TextView) findViewById(R.id.score9);
        score10 = (TextView) findViewById(R.id.score10);
        UpdateLeaderboardbtn = (Button) findViewById(R.id.Updatebtn);

        UpdateLeaderboardbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CapitalQuizApi apiService = ApiClientFactory.GetCapitalQuizApi();
                Call<ArrayList<GameData>> call = apiService.GetGameData(10);
                call.enqueue(new Callback<ArrayList<GameData>>() {
                    @Override
                    public void onResponse(Call<ArrayList<GameData>> call, Response<ArrayList<GameData>> response) {
                        if (response.isSuccessful()) {
                            // assign game data objects here
                            // e.g.
                            ArrayList<GameData> CapitalGame = response.body();
//                            score1.setText(Integer.toString());
//                            score2.setText(Integer.toString());
//                            score3.setText(Integer.toString());
//                            score4.setText(Integer.toString());
//                            score5.setText(Integer.toString());
//                            score6.setText(Integer.toString());
//                            score7.setText(Integer.toString());
//                            score8.setText(Integer.toString());
//                            score9.setText(Integer.toString());
//                            score10.setText(Integer.toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<GameData>> call, Throwable t) {

                    }
                });


            }
        });



    }
}