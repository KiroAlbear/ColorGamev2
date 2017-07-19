package com.example.admin.color_game;

import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.widget.ProgressBar;

/**
 * Created by Admin on 17/07/2017.
 */

public class TimeCounter extends CountDownTimer {

    ProgressBar progressBar;
    Intent intent;
    int score;
    Context context;

    public TimeCounter(long millisInFuture, long countDownInterval, ProgressBar progressBar, Context context, int score) {
        super(millisInFuture, countDownInterval);
        this.progressBar = progressBar;
        this.score = score;
        this.intent = intent;
        this.context = context;
    }

    @Override
    public void onTick(long millisUntilFinished) {
        int progress = (int) (millisUntilFinished / 1000);
        progressBar.setProgress(progressBar.getMax()-progress);
    }

    @Override
    public void onFinish() {

        progressBar.setProgress(progressBar.getMax());
        Intent intent = new Intent(this.context, FinalActivity.class);

        intent.putExtra("Score", score);
        context.startActivity(intent);

    }
}
