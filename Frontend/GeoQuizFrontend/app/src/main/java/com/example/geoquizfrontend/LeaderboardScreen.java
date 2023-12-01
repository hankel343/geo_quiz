package com.example.geoquizfrontend;

import static com.example.geoquizfrontend.ApiClientFactory.GetGeoQuizApi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.geoquizfrontend.models.GameData;
import com.example.geoquizfrontend.models.Quiz;
import com.example.geoquizfrontend.models.QuizType;
import com.example.geoquizfrontend.models.Student;
import com.example.geoquizfrontend.models.User;
import com.example.geoquizfrontend.services.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LeaderboardScreen extends AppCompatActivity {
    private TextView score1, score2, score3, score4, score5, score6, score7, score8, score9, score10, Textuser1, Textuser2, Textuser3, Textuser4, Textuser5, Textuser6, Textuser7, Textuser8, Textuser9, Textuser10, CurrentLeaderboard;
    private Button UpdateLeaderboardbtn, FlagLeaderboard, CapitalLeaderboard, ContinentsLeaderboard, COALeaderboard, HigherLowerLeaderboard;
    private QuizType whichGame = QuizType.FLAG;
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
        CurrentLeaderboard = (TextView) findViewById(R.id.CurrentLeaderboard);
        UpdateLeaderboardbtn = (Button) findViewById(R.id.Updatebtn);
        FlagLeaderboard = (Button) findViewById(R.id.FlagLeaderboard);
        CapitalLeaderboard = (Button) findViewById(R.id.CapitalLeaderboard);
        ContinentsLeaderboard = (Button) findViewById(R.id.ContinentsLeaderboard);
        COALeaderboard = (Button) findViewById(R.id.COALeaderboard);
        HigherLowerLeaderboard = (Button) findViewById(R.id.HigherLowerLeaderboard);



        UpdateLeaderboardbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApiService apiService = ApiClientFactory.GetGeoQuizApi();
                Call<List<Quiz>> call = apiService.getTopNQuizzesByType(whichGame,10);
                call.enqueue(new Callback<List<Quiz>>() {
                    @Override
                    public void onResponse(Call<List<Quiz>> call, Response<List<Quiz>> response) {
                        if (response.isSuccessful()) {
                            // assign game data objects here
                            // e.g.
                            List<Quiz> Leaderboard = response.body();
                            score1.setText(Integer.toString(Leaderboard.get(0).getScore()));
                            score2.setText(Integer.toString(Leaderboard.get(1).getScore()));
                            score3.setText(Integer.toString(Leaderboard.get(2).getScore()));
                            score4.setText(Integer.toString(Leaderboard.get(3).getScore()));
                            score5.setText(Integer.toString(Leaderboard.get(4).getScore()));
                            score6.setText(Integer.toString(Leaderboard.get(5).getScore()));
                            score7.setText(Integer.toString(Leaderboard.get(6).getScore()));
                            score8.setText(Integer.toString(Leaderboard.get(7).getScore()));
                            score9.setText(Integer.toString(Leaderboard.get(8).getScore()));
                            score10.setText(Integer.toString(Leaderboard.get(9).getScore()));
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Quiz>> call, Throwable t) {

                    }
                });

            }
        });

        FlagLeaderboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whichGame = QuizType.FLAG;
                CurrentLeaderboard.setText("Flag Game Leaderboard");
            }
        });
        CapitalLeaderboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whichGame = QuizType.CAPITAL;
                CurrentLeaderboard.setText("Capital Game Leaderboard");
            }
        });
        ContinentsLeaderboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whichGame = QuizType.CONTINENT;
                CurrentLeaderboard.setText("Continent Game Leaderboard");
            }
        });
        COALeaderboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whichGame = QuizType.COAT_OF_ARMS;
                CurrentLeaderboard.setText("Coat of Arms Game Leaderboard");
            }
        });

    }
}