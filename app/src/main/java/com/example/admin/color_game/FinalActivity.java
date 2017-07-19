package com.example.admin.color_game;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FinalActivity extends AppCompatActivity {
    Button FinalButton;
    TextView ScoreText;
    TextView BestScoreText;
    ScoreData scoreData;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        FinalButton = (Button) findViewById(R.id.finalButton);
        Bundle bundle = getIntent().getExtras();
        score = bundle.getInt("Score");
        ScoreText = (TextView) findViewById(R.id.Score);

        ScoreText.setText(String.valueOf(score));
        BestScoreText = (TextView) findViewById(R.id.bestScore);

        scoreData = new ScoreData(this.getBaseContext());

        if (scoreData.ReadeScore() == null) {

            scoreData.WriteScore(String.valueOf(score));
//            ScoreText.setText(String.valueOf(score));
            BestScoreText.setText(String.valueOf(score));


        } else if((Integer.parseInt(scoreData.ReadeScore()))<score) {

//            ScoreText.setText(String.valueOf(score));
            BestScoreText.setText(String.valueOf(scoreData.ReadeScore()));
            scoreData.WriteScore(String.valueOf(score));
        }
        else if((Integer.parseInt(scoreData.ReadeScore()))>=score){
//            ScoreText.setText(String.valueOf(score));
            BestScoreText.setText(scoreData.ReadeScore());
        }

        FinalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
