package com.example.nikhil.rankpredictor;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MockUpActivity extends AppCompatActivity {

    Question currentQues;
    List<Question> quesList;
    int qid = 0;
    TextView quesText;
    RadioButton r_optA, r_optB, r_optC, r_optD;
    Button nextBtn;
    ArrayList<String> results;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mock_up);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        MockUpHelper dbase = new MockUpHelper(this);
        dbase.onCreate(db);
        try {
            quesList = dbase.getAllQuestions();
            currentQues = quesList.get(qid);
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }

        quesText = (TextView) findViewById(R.id.ques_text);
        r_optA = (RadioButton) findViewById(R.id.r_optA);
        r_optB = (RadioButton) findViewById(R.id.r_optB);
        r_optC = (RadioButton) findViewById(R.id.r_optC);
        r_optD = (RadioButton) findViewById(R.id.r_optD);
        nextBtn = (Button) findViewById(R.id.next_button);

        setView();
        nextBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                RadioGroup rGroup = (RadioGroup) findViewById(R.id.r_group);
                RadioButton answer = (RadioButton) findViewById(rGroup.getCheckedRadioButtonId());
                if(answer != null){
                    nextBtn.setEnabled(true);
                }
                else nextBtn.setEnabled(true);
                String c;
                if(answer != null){ c = answer.getText().toString();
                currentQues.saveAnswer(c);
                }
                int i = currentQues.getCountA();
                if(qid < 10) {
                    currentQues = quesList.get(qid);
                    setView();
                }
                else{
                    Intent intent = new Intent(MockUpActivity.this, ShowResultActivity.class);
                    Bundle b = new Bundle();
                    //b.putStringArrayList("result", results);
                    intent.putExtras(b);
                    startActivity(intent);

                }
                rGroup.clearCheck();
            }
        });



    }

    private void setView(){
        quesText.setText(qid + currentQues.getQuestion());
        r_optA.setText(currentQues.getOptA());
        r_optB.setText(currentQues.getOptB());
        r_optC.setText(currentQues.getOptC());
        r_optD.setText(currentQues.getOptD());
        qid++;
    }
}
