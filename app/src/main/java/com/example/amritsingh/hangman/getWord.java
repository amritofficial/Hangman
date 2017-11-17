package com.example.amritsingh.hangman;

/**
 * Created by Amrit Singh on 4/23/2017.
 */

public class getWord {

    private String word;
    private StringBuffer dashes;
    private String name;

    public getWord(){
        this.word = "jonathan";
    }
    public  void setword(String s){
        this.word = s;
    }
    public String getWord(){
        return this.word;
    }
    public void setDashes(StringBuffer dashes){
        this.dashes = dashes;
    }
    public StringBuffer getDashes(){
        return this.dashes;
    }
}
