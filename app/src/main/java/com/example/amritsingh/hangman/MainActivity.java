package com.example.amritsingh.hangman;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button newGame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // To set custom font onto a button (Easiest method)
        newGame = (Button) findViewById(R.id.newGame);
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/earth.otf");
        newGame.setTypeface(font);

        Button menu = (Button) findViewById(R.id.menu);
        menu.setTypeface(font);
        Button quit = (Button) findViewById(R.id.quit);
        quit.setTypeface(font);
        Button highScore = (Button) findViewById(R.id.highScore);
        highScore.setTypeface(font);

    }

    public void menuOption(View view) {
        System.out.println("Menu!!!");
    }

    public void buttonClick(View view) {
        newGame = (Button) findViewById(R.id.newGame);
        newGame.setTextSize(44);

        Intent i = new Intent(MainActivity.this, Stage2.class);
        MainActivity.this.startActivity(i);
        System.out.println("The Button has been pressed");
    }


}
