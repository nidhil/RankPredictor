package com.example.nikhil.rankpredictor;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openRankPredictor(View view){
        Intent intent = new Intent(this, RankPredictionActivity.class);
        startActivity(intent);
    }

    public void openScores(View view){
        Intent intent = new Intent(this, MockUpActivity.class);
        startActivity(intent);
    }
}
