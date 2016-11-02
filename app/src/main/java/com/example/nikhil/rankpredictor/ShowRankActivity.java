package com.example.nikhil.rankpredictor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowRankActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_rank);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle b = getIntent().getExtras();
        float score = b.getFloat("Your Score");
        String rank = b.getString("Your Rank");
        TextView show_score = (TextView) findViewById(R.id.show_score);
        show_score.setText("" + score);
        TextView show_rank = (TextView) findViewById(R.id.show_rank);
        show_rank.setText("" + rank);

    }
}
