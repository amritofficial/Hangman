package com.example.amritsingh.hangman;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class gameActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    TextView wordMain;
    getWord gw = new getWord();
    TextView hint;
    TextView scoreView;
    TextView levelView;
    TextView welcomeText;

    ImageView hangman;

    int bparts;

    ImageButton buttonA;
    ImageButton buttonB;
    ImageButton buttonC;
    ImageButton buttonD;
    ImageButton buttonE;
    ImageButton buttonF;
    ImageButton buttonG;
    ImageButton buttonH;
    ImageButton buttonI;
    ImageButton buttonJ;
    ImageButton buttonK;
    ImageButton buttonL;
    ImageButton buttonM;
    ImageButton buttonN;
    ImageButton buttonO;
    ImageButton buttonP;
    ImageButton buttonQ;
    ImageButton buttonR;
    ImageButton buttonS;
    ImageButton buttonT;
    ImageButton buttonU;
    ImageButton buttonV;
    ImageButton buttonW;
    ImageButton buttonX;
    ImageButton buttonY;
    ImageButton buttonZ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.setContentView(R.layout.activity_game);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        getBody.setParts(6);

        hangman = (ImageView) findViewById(R.id.hangman);

        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/ARDARLING.ttf");
        wordMain = (TextView) findViewById(R.id.wordMain);
        wordMain.setTypeface(font);

        hint = (TextView) findViewById(R.id.hint);
        hint.setTypeface(font);

        scoreView = (TextView) findViewById(R.id.score);
        levelView = (TextView) findViewById(R.id.level);

//        welcomeText = (TextView) findViewById(R.id.welcomeText);
//        welcomeText.setTypeface(font);

        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        System.out.println("The name from third  window is " + name);
//        if(!(name.equalsIgnoreCase(null))) {
//            welcomeText.setText("Welcome " + name);
//        }
//        else {
//            welcomeText.setText("Welcome");
//        }

//        welcomeText.setText("Welcome " + name);

        scoreView.setTypeface(font);
        levelView.setTypeface(font);

        buttonA = (ImageButton) findViewById(R.id.imageButtonA);
        buttonB = (ImageButton) findViewById(R.id.imageButtonB);
        buttonC = (ImageButton) findViewById(R.id.imageButtonC);
        buttonD = (ImageButton) findViewById(R.id.imageButtonD);
        buttonE = (ImageButton) findViewById(R.id.imageButtonE);
        buttonF = (ImageButton) findViewById(R.id.imageButtonF);
        buttonG = (ImageButton) findViewById(R.id.imageButtonG);
        buttonH = (ImageButton) findViewById(R.id.imageButtonH);
        buttonI = (ImageButton) findViewById(R.id.imageButtonI);
        buttonJ = (ImageButton) findViewById(R.id.imageButtonJ);
        buttonK = (ImageButton) findViewById(R.id.imageButtonK);
        buttonL = (ImageButton) findViewById(R.id.imageButtonL);
        buttonM = (ImageButton) findViewById(R.id.imageButtonM);
        buttonN = (ImageButton) findViewById(R.id.imageButtonN);
        buttonO = (ImageButton) findViewById(R.id.imageButtonO);
        buttonP = (ImageButton) findViewById(R.id.imageButtonP);
        buttonQ = (ImageButton) findViewById(R.id.imageButtonQ);
        buttonR = (ImageButton) findViewById(R.id.imageButtonR);
        buttonS = (ImageButton) findViewById(R.id.imageButtonS);
        buttonT = (ImageButton) findViewById(R.id.imageButtonT);
        buttonU = (ImageButton) findViewById(R.id.imageButtonU);
        buttonV = (ImageButton) findViewById(R.id.imageButtonV);
        buttonW = (ImageButton) findViewById(R.id.imageButtonW);
        buttonX = (ImageButton) findViewById(R.id.imageButtonX);
        buttonY = (ImageButton) findViewById(R.id.imageButtonY);
        buttonZ = (ImageButton) findViewById(R.id.imageButtonZ);

        buttonA.setEnabled(true);
        buttonB.setEnabled(true);
        buttonC.setEnabled(true);
        buttonD.setEnabled(true);
        buttonE.setEnabled(true);
        buttonF.setEnabled(true);


        startGame();

    }

    Array a = new Array();

    public String getLine(InputStream is) throws IOException {
        String text = "";
        BufferedReader reader;

        reader = new BufferedReader(new InputStreamReader(is));
        String line = null;
        ArrayList<String> al = new ArrayList<String>();
        String content = null;
        while (!((content = reader.readLine()) == null)) {
            al.add(content);
        }

        a.setArrayList(al);

        int ran = (int) (Math.random() * al.size() - 1);
        line = al.get(ran);
        al.remove(ran);   //here we are preventing repetition of line
        reader.close();

        return line;
    }

    public void startGame() {
        String line = null;
        String secretWord;
        String word = "GUESSIT";
        hint = (TextView) findViewById(R.id.hint);


        try {
            AssetManager assetManager = getBaseContext().getAssets();
            InputStream is = assetManager.open("words/hangwordsEasy.txt");
            line = getLine(is);

//            StringBuffer dashes = makeDashes(word);
//            gw.setword(word);
//            gw.setDashes(dashes);
//            wordMain.setText(makeDashes(word));

            String[] cont = line.split("::");
            secretWord = cont[0];

            gw.setword(secretWord);
            StringBuffer dashes = makeDashes(secretWord);
            gw.setDashes(dashes);
            hint.setText(cont[1]);
            wordMain.setText(dashes.toString());

            System.out.println("The secret word that is to be guessed is " + secretWord);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public void keyboardActions(View view) {
        String guess = null;

        String id = getResources().getResourceEntryName(view.getId());
        System.out.println("button has been clicked " + id);


        switch (id) {
            case "imageButtonA":
                guess = "A";
                try {
                    Drawable d = Drawable.createFromStream(getAssets().open("iconEdit/a.png"), null);
                    buttonA.setImageDrawable(d);
                    buttonA.setEnabled(false);
                    processGuess(guess);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case "imageButtonB":
                guess = "B";
                try {
                    Drawable d = Drawable.createFromStream(getAssets().open("iconEdit/b.png"), null);
                    buttonB.setImageDrawable(d);
                    buttonB.setEnabled(false);
                    processGuess(guess);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case "imageButtonC":
                guess = "C";
                try {
                    Drawable d = Drawable.createFromStream(getAssets().open("iconEdit/c.png"), null);
                    buttonC.setImageDrawable(d);
                    buttonC.setEnabled(false);
                    processGuess(guess);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case "imageButtonD":
                guess = "D";
                try {
                    Drawable d = Drawable.createFromStream(getAssets().open("iconEdit/d.png"), null);
                    buttonD.setImageDrawable(d);
                    processGuess(guess);
                    buttonD.setEnabled(false);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case "imageButtonE":
                guess = "E";
                try {
                    Drawable d = Drawable.createFromStream(getAssets().open("iconEdit/e.png"), null);
                    buttonE.setImageDrawable(d);
                    buttonE.setEnabled(false);
                    processGuess(guess);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case "imageButtonF":
                guess = "F";
                try {
                    Drawable d = Drawable.createFromStream(getAssets().open("iconEdit/f.png"), null);
                    buttonF.setImageDrawable(d);
                    buttonF.setEnabled(false);
                    processGuess(guess);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case "imageButtonG":
                guess = "G";
                try {
                    Drawable d = Drawable.createFromStream(getAssets().open("iconEdit/g.png"), null);
                    buttonG.setImageDrawable(d);
                    buttonG.setEnabled(false);
                    processGuess(guess);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case "imageButtonH":
                guess = "H";
                try {
                    Drawable d = Drawable.createFromStream(getAssets().open("iconEdit/h.png"), null);
                    buttonH.setImageDrawable(d);
                    buttonH.setEnabled(false);
                    processGuess(guess);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case "imageButtonI":
                guess = "I";
                try {
                    Drawable d = Drawable.createFromStream(getAssets().open("iconEdit/i.png"), null);
                    buttonI.setImageDrawable(d);
                    buttonI.setEnabled(false);
                    processGuess(guess);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case "imageButtonJ":
                guess = "J";
                try {
                    Drawable d = Drawable.createFromStream(getAssets().open("iconEdit/j.png"), null);
                    buttonJ.setImageDrawable(d);
                    buttonJ.setEnabled(false);
                    processGuess(guess);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case "imageButtonK":
                guess = "K";
                try {
                    Drawable d = Drawable.createFromStream(getAssets().open("iconEdit/k.png"), null);
                    buttonK.setImageDrawable(d);
                    buttonK.setEnabled(false);
                    processGuess(guess);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case "imageButtonL":
                guess = "L";
                try {
                    Drawable d = Drawable.createFromStream(getAssets().open("iconEdit/l.png"), null);
                    buttonL.setImageDrawable(d);
                    buttonL.setEnabled(false);
                    processGuess(guess);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case "imageButtonM":
                guess = "M";
                try {
                    Drawable d = Drawable.createFromStream(getAssets().open("iconEdit/m.png"), null);
                    buttonM.setImageDrawable(d);
                    buttonM.setEnabled(false);
                    processGuess(guess);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case "imageButtonN":
                guess = "N";
                try {
                    Drawable d = Drawable.createFromStream(getAssets().open("iconEdit/n.png"), null);
                    buttonN.setImageDrawable(d);
                    buttonN.setEnabled(false);
                    processGuess(guess);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case "imageButtonO":
                guess = "O";
                try {
                    Drawable d = Drawable.createFromStream(getAssets().open("iconEdit/o.png"), null);
                    buttonO.setImageDrawable(d);
                    buttonO.setEnabled(false);
                    processGuess(guess);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case "imageButtonP":
                guess = "P";
                try {
                    Drawable d = Drawable.createFromStream(getAssets().open("iconEdit/p.png"), null);
                    buttonP.setImageDrawable(d);
                    buttonP.setEnabled(false);
                    processGuess(guess);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case "imageButtonQ":
                guess = "Q";
                try {
                    Drawable d = Drawable.createFromStream(getAssets().open("iconEdit/q.png"), null);
                    buttonQ.setImageDrawable(d);
                    buttonQ.setEnabled(false);
                    processGuess(guess);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case "imageButtonR":
                guess = "R";
                try {
                    Drawable d = Drawable.createFromStream(getAssets().open("iconEdit/r.png"), null);
                    buttonR.setImageDrawable(d);
                    buttonR.setEnabled(false);
                    processGuess(guess);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case "imageButtonS":
                guess = "S";
                try {
                    Drawable d = Drawable.createFromStream(getAssets().open("iconEdit/s.png"), null);
                    buttonS.setImageDrawable(d);
                    buttonS.setEnabled(false);
                    processGuess(guess);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case "imageButtonT":
                guess = "T";
                try {
                    Drawable d = Drawable.createFromStream(getAssets().open("iconEdit/t.png"), null);
                    buttonT.setImageDrawable(d);
                    buttonT.setEnabled(false);
                    processGuess(guess);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case "imageButtonU":
                guess = "U";
                try {
                    Drawable d = Drawable.createFromStream(getAssets().open("iconEdit/u.png"), null);
                    buttonU.setImageDrawable(d);
                    buttonU.setEnabled(false);
                    processGuess(guess);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case "imageButtonV":
                guess = "V";
                try {
                    Drawable d = Drawable.createFromStream(getAssets().open("iconEdit/v.png"), null);
                    buttonV.setImageDrawable(d);
                    buttonV.setEnabled(false);
                    processGuess(guess);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case "imageButtonW":
                guess = "W";
                try {
                    Drawable d = Drawable.createFromStream(getAssets().open("iconEdit/w.png"), null);
                    buttonW.setImageDrawable(d);
                    buttonW.setEnabled(false);
                    processGuess(guess);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case "imageButtonX":
                guess = "X";
                try {
                    Drawable d = Drawable.createFromStream(getAssets().open("iconEdit/x.png"), null);
                    buttonX.setImageDrawable(d);
                    buttonX.setEnabled(false);
                    processGuess(guess);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case "imageButtonY":
                guess = "Y";
                try {
                    Drawable d = Drawable.createFromStream(getAssets().open("iconEdit/y.png"), null);
                    buttonY.setImageDrawable(d);
                    buttonY.setEnabled(false);
                    processGuess(guess);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case "imageButtonZ":
                guess = "Z";
                try {
                    Drawable d = Drawable.createFromStream(getAssets().open("iconEdit/z.png"), null);
                    buttonZ.setImageDrawable(d);
                    buttonZ.setEnabled(false);
                    processGuess(guess);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;


            default:
                break;

        }


    }

    getNumbers gn = new getNumbers();

    public void processGuess(String guess) throws IOException {
        int sc = gn.getScore();
        int level = gn.getLevel();
        scoreView = (TextView) findViewById(R.id.score);
        levelView = (TextView) findViewById(R.id.level);

        int bodyParts = getBody.getParts();
        System.out.println("The number of body parts " + bodyParts);

        if (sc == 0) {
            sc = 0;
        } else {
            sc = gn.getScore();
        }

        if (level == 0) {
            level = 1;
        } else {
            level = gn.getLevel();
        }

        boolean game = false;
        StringBuffer dashes = gw.getDashes();
        String secret = gw.getWord();
        String guesses = null;
        char letter;
        letter = guess.charAt(0);
        guesses += letter;
        if (secret.indexOf(letter) < 0) {
            --bodyParts;
            getBody.setParts(bodyParts);

            int id = getResources().getIdentifier("longstring", "raw", getPackageName());
            playSound(id);

            if (bodyParts == 5) {
                try {
                    Drawable d = Drawable.createFromStream(getAssets().open("mickeyMouse/M1.png"), null);
                    hangman.setImageDrawable(d);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (bodyParts == 4) {
                try {
                    Drawable d = Drawable.createFromStream(getAssets().open("mickeyMouse/M2.png"), null);
                    hangman.setImageDrawable(d);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bodyParts == 3) {
                try {
                    Drawable d = Drawable.createFromStream(getAssets().open("mickeyMouse/M3.png"), null);
                    hangman.setImageDrawable(d);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bodyParts == 2) {
                try {
                    Drawable d = Drawable.createFromStream(getAssets().open("mickeyMouse/M4.png"), null);
                    hangman.setImageDrawable(d);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bodyParts == 1) {
                try {
                    Drawable d = Drawable.createFromStream(getAssets().open("mickeyMouse/M5.png"), null);
                    hangman.setImageDrawable(d);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bodyParts == 0) {
                try {
                    Drawable d = Drawable.createFromStream(getAssets().open("mickeyMouse/M6.png"), null);
                    hangman.setImageDrawable(d);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("You lose!!!");
//                AlertDialog dialog = new AlertDialog.Builder(gameActivity.this).create();
//                dialog.setTitle("You Lose!!!");
//                dialog.setMessage("Do you wanna play again");
//                dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "NO",
//                        new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                Intent i = new Intent(gameActivity.this, MainActivity.class);
//                                gameActivity.this.startActivity(i);
//                            }
//                        });
//                dialog.show();
                AlertDialog.Builder builder = new AlertDialog.Builder(gameActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.score_layout, null);
                Typeface font = Typeface.createFromAsset(getAssets(), "fonts/ARDARLING.ttf");

                TextView lose = (TextView) mView.findViewById(R.id.lose);
                lose.setTypeface(font);

                TextView playAgain = (TextView) mView.findViewById(R.id.playAgain);
                playAgain.setTypeface(font);

//                ImageButton imageButton = (ImageButton) mView.findViewById(R.id.yes);

                builder.setView(mView);
                builder.show();
            }


            System.out.println("Wrong Guess");
        } else {
            int id = getResources().getIdentifier("stringshort", "raw", getPackageName());
            playSound(id);
            replaceCharacter(secret, dashes, letter);
        }

        if (secret.equals(dashes.toString())) {

            int id = getResources().getIdentifier("sucesslevel", "raw", getPackageName());
            playSound(id);
            game = true;
            sc += 100;
            level += 1;
            gn.setScore(sc);
            gn.setLevel(level);
            String stext = String.valueOf(sc);
            String ltext = String.valueOf(level);
            scoreView.setText(stext);
            levelView.setText(ltext);
            reEnableButtons();
            repeat();
            resetHangman();
        }
    }

    public StringBuffer makeDashes(String s) {
        StringBuffer dashes = new StringBuffer(s.length());
        for (int count = 0; count < s.length(); count++)
            dashes.append('-');
        return dashes;
    }

    public void replaceCharacter(String secret, StringBuffer dashes, char letter) {
        // buttonSound(); //this is to play correct guess sound
        //int bparts = getBody.getParts();
        boolean game = false;
        dashes = gw.getDashes();
        System.out.println("Replace Character " + dashes);
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == letter) {
                dashes.setCharAt(i, letter);
                //this will replace the label with the remaining dashes
                //and the correct letter
                wordMain.setText(dashes.toString());
            }

        }
    }


    public void repeat() throws NullPointerException {

        getBody.setParts(6);
        reEnableButtons();
        try {
            hint = (TextView) findViewById(R.id.hint);
            wordMain = (TextView) findViewById(R.id.wordMain);

            //answerDisplay.setText(null);
//            setButtonIcons();
//            setButtonVisibilityOn();

//            Y2.setVisible(false);
//            N2.setVisible(false);
//            int sT = gn.getScore();
//            l1.setText(String.valueOf(sT));
//            hangman.setImage(null);
            int score = gn.getScore();
            scoreView.setText(String.valueOf(score));
            String content = null;
            String secret = null;
            //String hint = null;
            StringBuffer dashes = null;
            boolean game = false;
            int bparts;
            char letter;
            String guess = null;

            ArrayList al = a.getArrayList();
            int ran = (int) (Math.random() * al.size() - 1);
            String word = (String) al.get(ran);
            if (word == null) {
                wordMain.setText("Game Completed Sucessfully");
                throw new NullPointerException();
            }
            al.remove(ran);

            bparts = 6;
            String[] cont = word.split("::");
            secret = cont[0];


            gw.setword(secret);
            dashes = makeDashes(secret);

            hint.setText(cont[1]);
            wordMain.setText(dashes.toString());

            gw.setDashes(dashes);
        } catch (Exception e) {
            //Hangman.gameCompleted();  //this will display a new window with congratulations
        }
       // getBody.setParts(6);
        reEnableButtons();
    }



    public void reEnableButtons() {

        buttonA.setImageDrawable(getResources().getDrawable(R.drawable.a));
        buttonA.setEnabled(true);

        buttonB.setImageDrawable(getResources().getDrawable(R.drawable.b));
        buttonB.setEnabled(true);

        buttonC.setImageDrawable(getResources().getDrawable(R.drawable.c));
        buttonC.setEnabled(true);

        buttonD.setImageDrawable(getResources().getDrawable(R.drawable.d));
        buttonD.setEnabled(true);

        buttonE.setImageDrawable(getResources().getDrawable(R.drawable.e));
        buttonE.setEnabled(true);

        buttonF.setImageDrawable(getResources().getDrawable(R.drawable.f));
        buttonF.setEnabled(true);

        buttonG.setImageDrawable(getResources().getDrawable(R.drawable.g));
        buttonG.setEnabled(true);

        buttonH.setImageDrawable(getResources().getDrawable(R.drawable.h));
        buttonH.setEnabled(true);

        buttonI.setImageDrawable(getResources().getDrawable(R.drawable.i));
        buttonI.setEnabled(true);

        buttonJ.setImageDrawable(getResources().getDrawable(R.drawable.j));
        buttonJ.setEnabled(true);

        buttonK.setImageDrawable(getResources().getDrawable(R.drawable.k));
        buttonK.setEnabled(true);

        buttonL.setImageDrawable(getResources().getDrawable(R.drawable.l));
        buttonL.setEnabled(true);

        buttonM.setImageDrawable(getResources().getDrawable(R.drawable.m));
        buttonM.setEnabled(true);

        buttonN.setImageDrawable(getResources().getDrawable(R.drawable.n));
        buttonN.setEnabled(true);

        buttonO.setImageDrawable(getResources().getDrawable(R.drawable.o));
        buttonO.setEnabled(true);

        buttonP.setImageDrawable(getResources().getDrawable(R.drawable.p));
        buttonP.setEnabled(true);

        buttonQ.setImageDrawable(getResources().getDrawable(R.drawable.q));
        buttonQ.setEnabled(true);

        buttonR.setImageDrawable(getResources().getDrawable(R.drawable.r));
        buttonR.setEnabled(true);

        buttonS.setImageDrawable(getResources().getDrawable(R.drawable.s));
        buttonS.setEnabled(true);

        buttonT.setImageDrawable(getResources().getDrawable(R.drawable.t));
        buttonT.setEnabled(true);

        buttonU.setImageDrawable(getResources().getDrawable(R.drawable.u));
        buttonU.setEnabled(true);

        buttonV.setImageDrawable(getResources().getDrawable(R.drawable.v));
        buttonV.setEnabled(true);

        buttonW.setImageDrawable(getResources().getDrawable(R.drawable.w));
        buttonW.setEnabled(true);

        buttonX.setImageDrawable(getResources().getDrawable(R.drawable.x));
        buttonX.setEnabled(true);

        buttonY.setImageDrawable(getResources().getDrawable(R.drawable.y));
        buttonY.setEnabled(true);

        buttonZ.setImageDrawable(getResources().getDrawable(R.drawable.z));
        buttonZ.setEnabled(true);
    }

    public void resetHangman() {
        hangman.setImageDrawable(null);
    }

    private void playSound(int id) {
        try {
            mMediaPlayer = MediaPlayer.create(this, id);
            mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    stop();
                }
            });

            mMediaPlayer.start();

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void stop() {
        if (mMediaPlayer != null) {
            if(mMediaPlayer.isPlaying())
                mMediaPlayer.stop();
            mMediaPlayer.reset();
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }


}
