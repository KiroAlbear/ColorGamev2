package com.example.admin.color_game;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

public class PlayActivity extends AppCompatActivity {
//Button PlayButton;

    ImageButton left = null;
    ImageButton Right = null;
    Buttons_Class RightButton = null;
    Buttons_Class leftButton = null;
    Intent intent;
    ProgressBar progressBar;
    //    ScoreData scoreData;
    TimeCounter timeCounter;

    Colors_Textview colorGame;
    int Score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        Score = 0;
        left = (ImageButton) findViewById(R.id.cross);
        Right = (ImageButton) findViewById(R.id.right);
        final TextView textColor = (TextView) findViewById(R.id.textColor);
        final TextView bestscore = (TextView) findViewById(R.id.bestScore);
        progressBar = (ProgressBar) findViewById(R.id.Buffering);

       intent = new Intent(this, FinalActivity.class);


       timeCounter = new TimeCounter(3000, 1000, progressBar,this,Score);
        //        scoreData = new ScoreData(this.getBaseContext());
        leftButton = new Buttons_Class(left);
        RightButton = new Buttons_Class(Right);

        colorGame = new Colors_Textview(textColor);


        colorGame.ShowRandom();


        Right.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    RightButton.RightButtonColor();
                    if (colorGame.IsMatchedColors()) {
                        Score++;

//                        texttemp.setText("True");
                    } else {

//                        texttemp.setText("False");
                        intent.putExtra("Score", Score);

                        startActivity(intent);
                    }

                } else if (event.getAction() == MotionEvent.ACTION_UP) {

                    timeCounter.start();
                    RightButton.ColorClean();
                    colorGame.ShowRandom();

                }

                return false;
            }
        });

        left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    leftButton.LeftButtonColor();
                    if (colorGame.IsMatchedColors()) {

//                        texttemp.setText("False");
                        intent.putExtra("Score", Score);
                        startActivity(intent);
                    } else {
                        Score++;
//                        texttemp.setText("True");
                    }


                } else if (event.getAction() == MotionEvent.ACTION_UP) {

                    timeCounter.start();
                    leftButton.ColorClean();
                    colorGame.ShowRandom();

                }

                return false;

            }
        });


    }

}

