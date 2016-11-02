package com.example.nikhil.rankpredictor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class ShowResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_result);

        TextView showResult = (TextView) findViewById(R.id.textView3);
        showResult.setText("this is result activity");
    }
}
