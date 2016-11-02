package com.example.nikhil.rankpredictor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.widget.EditText;
import android.view.View;
import android.widget.TextView;
import java.lang.Float;

public class RankPredictionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank_prediction);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private float calulateScore(){
        EditText percentage12 = (EditText) findViewById(R.id.get_12_percentage);
        String percentage = percentage12.getText().toString();
        float percentile = Float.parseFloat(percentage);
        EditText expected_score = (EditText) findViewById(R.id.get_jee_marks);
        String expected_jee_marks = expected_score.getText().toString();
        float jee_marks = Float.parseFloat(expected_jee_marks);
        float score = normalize(percentile, jee_marks);
        return score;
    }
    private float normalize(float percentile, float jee_marks){
       float calculated_score = ((jee_marks*60) + (percentile * 40))/100;
        return  calculated_score;
    }

    public String calculateRank(){
    // predict the rank after recieving normalized score
        float score  = calulateScore();
        if(score >95 && score <=100)
            return "80000 - 100000";
        if(score > 100 && score <= 150)
            return "60000 - 80000";
        if(score > 150 && score <= 200)
            return "40000 - 60000";
        if(score > 200 && score <= 250)
            return "20000 - 400000";
        if(score > 250 && score <= 300)
            return "1000 - 20000";
        if(score > 300)
            return "below 1000";

        return "Above 100000";
    }

    public void submitRank(View view){
        float score = calulateScore();
        String rank = calculateRank();
        Intent intent = new Intent(this, ShowRankActivity.class);
        Bundle b = new Bundle();
        b.putFloat("Your Score", score);
        b.putString("Your Rank", rank);
        intent.putExtras(b);
        startActivity(intent);
    }

}
