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
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class Stage2 extends AppCompatActivity {

    ToggleButton tMickey;
    ToggleButton tCyote;
    ToggleButton tMario;

    ToggleButton easy;
    ToggleButton medium;
    ToggleButton hard;


    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.setContentView(R.layout.activity_stage2);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage2);

        //Typeface font = Typeface.createFromAsset(getAssets(), "fonts/ARDARLING.ttf");

        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/earth.otf");

        et = (EditText) findViewById(R.id.editText2);
        et.setTypeface(font);

        System.out.println("The Stage 2 has been created ");

        tMickey = (ToggleButton) findViewById(R.id.tMickey);
        tMickey.setTypeface(font);
        tCyote = (ToggleButton) findViewById(R.id.tCyote);
        tCyote.setTypeface(font);
        tMario = (ToggleButton) findViewById(R.id.tMario);
        tMario.setTypeface(font);

        easy = (ToggleButton) findViewById(R.id.easy);
        easy.setTypeface(font);
        medium = (ToggleButton) findViewById(R.id.Medium);
        medium.setTypeface(font);
        hard = (ToggleButton) findViewById(R.id.Hard);
        hard.setTypeface(font);

        Button startGame;


        tMickey.setChecked(true);
        tMickey.setTextColor(Color.CYAN);
        tMickey.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked) {
                    tCyote.setChecked(false);
                    tMario.setChecked(false);

                    System.out.println("Mickey Selected!!!");
                    tMickey.setTextColor(Color.CYAN);
                    tCyote.setTextColor(Color.YELLOW);
                    tMario.setTextColor(Color.YELLOW);
                }
            }
        });

        tCyote.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    tMario.setChecked(false);
                    tMickey.setChecked(false);

                    System.out.println("Cyote Selected!!!");
                    tCyote.setTextColor(Color.CYAN);
                    tMickey.setTextColor(Color.YELLOW);
                    tMario.setTextColor(Color.YELLOW);
                }
            }
        });

        tMario.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    tCyote.setChecked(false);
                    tMickey.setChecked(false);

                    System.out.println("Mario Selected!!!");
                    tMario.setTextColor(Color.CYAN);
                    tMickey.setTextColor(Color.YELLOW);
                    tCyote.setTextColor(Color.YELLOW);
                }
            }
        });


        easy.setChecked(true);
        easy.setTextColor(Color.CYAN);
        easy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    medium.setChecked(false);
                    hard.setChecked(false);

                    System.out.println("Easy Selected!!!");
                    easy.setTextColor(Color.CYAN);
                    medium.setTextColor(Color.YELLOW);
                    hard.setTextColor(Color.YELLOW);
                }
            }
        });

        medium.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    easy.setChecked(false);
                    hard.setChecked(false);

                    System.out.println("Medium Selected!!!");
                    medium.setTextColor(Color.CYAN);
                    easy.setTextColor(Color.YELLOW);
                    hard.setTextColor(Color.YELLOW);
                }
            }
        });

        hard.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    easy.setChecked(false);
                    medium.setChecked(false);

                    System.out.println("Hard Selected!!!");
                    hard.setTextColor(Color.CYAN);
                    medium.setTextColor(Color.YELLOW);
                    easy.setTextColor(Color.YELLOW);
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity.class));
    }


    public void startGameFunction(View view){
        String text = String.valueOf(et.getText());
        if(text.isEmpty()) {
            text = "User";
        }
        Intent i = new Intent(Stage2.this, gameActivity.class);
        i.putExtra("name", text);
        Stage2.this.startActivity(i);

    }

    public void changeColor(View view) {

    }

}
