package com.example.nikhil.rankpredictor;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by nikhil on 28-10-2016.
 */

public class Question {
    private int id;
    private String question;
    private String optA;
    private String optB;
    private String optC;
    private String optD;
    private int countA;
    private int countB;
    private int countC;
    private int countD;

    public Question(){
        id = 0;
        question = "";
        optA = "";
        optB = "";
        optC = "";
        optD = "";
        countA = 0;
        countB = 0;
        countC = 0;
        countD = 0;
    }

    public Question(String Question, String OptA, String OptB, String OptC, String OptD){
        question = Question;
        optA = OptA;
        optB = OptB;
        optC = OptC;
        optD = OptD;
    }

    public void saveAnswer(String answer){
        if(answer == getOptA()) countA++;
        if(answer == getOptB()) countB++;
        if(answer == getOptC()) countC++;
        if(answer == getOptD()) countD++;

    }

    public String getOptA() {
        return optA;
    }

    public void setOptA(String opta) {
        optA = opta;
    }

    public void setOptB(String optB) {
        this.optB = optB;
    }

    public String getOptB() {
        return optB;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOptC() {
        return optC;
    }

    public void setOptC(String optC) {
        this.optC = optC;
    }

    public String getOptD() {
        return optD;
    }

    public void setOptD(String optD) {
        this.optD = optD;
    }

    public int getCountA() {
        return countA;
    }

    public void setCountA(int countA) {
        this.countA = countA;
    }

    public int getCountB() {
        return countB;
    }

    public void setCountB(int countB) {
        countB = countB;
    }

    public int getCountC() {
        return countC;
    }

    public void setCountC(int countC) {
        countC = countC;
    }

    public int getCountD() {
        return countD;
    }

    public void setCountD(int countD) {
        countD = countD;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}

