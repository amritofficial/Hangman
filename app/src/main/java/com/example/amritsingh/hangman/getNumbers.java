package com.example.amritsingh.hangman;

/**
 * Created by Amrit Singh on 4/24/2017.
 */

public class getNumbers {

    private int Score;
    private int Level;

    public getNumbers(){
        this.Score = 0;
        this.Level = 1;
    }
    public void setScore(int s){
        this.Score = s;
    }
    public int getScore(){
        return this.Score;
    }

    public void setLevel(int d){
        this.Level = d;
    }
    public int getLevel(){
        return this.Level;
    }
}
