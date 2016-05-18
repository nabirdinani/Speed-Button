package com.brnj.lemonade;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


public class crazy_mode extends Activity {

    public final static String SCORE = "com.example.myFirstapp.SCORE";
    int currentScore = 0;
    Boolean gameStarted = false;
    Button button = null;
    boolean doEndGame = false;
    CountDownTimer counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        ActionBar actionBar = getActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_crazy_mode);

        gameStarted = true;
        start();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.crazy_mode, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void moveButton() {
        if(gameStarted) {
            if(button == null) {
                button = (Button) findViewById(R.id.button);
                button.setVisibility(View.INVISIBLE);
                button = (Button) findViewById(R.id.bad_button);
                button.setVisibility(View.INVISIBLE);
            }
            else
                button.setVisibility(View.INVISIBLE);

            Random r = new Random();
            int buttonHeight;
            int buttonWidth;
            int buttonType;
            buttonType = r.nextInt(6);
            if(buttonType == 5) {
                button = (Button) findViewById(R.id.bad_button);
                button.setVisibility(View.VISIBLE);
            }
            else {
                button = (Button) findViewById(R.id.button);
                button.setVisibility(View.VISIBLE);
            }

            buttonHeight = button.getHeight();
            buttonWidth = button.getWidth();
            int xLeft = r.nextInt(480 - buttonHeight);
            int yUp = r.nextInt(800 - buttonWidth);
            int xRight = r.nextInt(480 + buttonHeight);
            int yDown = r.nextInt(800 + buttonHeight);

            button.setX(xLeft);
            button.setY(yUp);
            button.setX(xRight);
            button.setY(yDown);
        }
    }

    public void addToScore(View view) {
        ++currentScore;
        updateScoreTextView("Current Score:" + currentScore);
    }

    public void updateTextView(String toThis) {
        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText(toThis);
    }
    public void updateScoreTextView(String toThis) {
        TextView textView = (TextView) findViewById(R.id.textView3);
        textView.setText(toThis);
    }

    public void setEndGame(View view) {
        doEndGame = true;
    }
    public void endGame() {
        doEndGame = false;
        Intent showIntent = new Intent(this, show_score.class);
        String score = "" + currentScore;
        showIntent.putExtra(SCORE, score);
        startActivity(showIntent);
    }

    public void start() {
        counter = new CountDownTimer(30000, 500) {

            public void onTick(long millisUntilFinished) {

                if(doEndGame) {
                    this.cancel();
                    endGame();
                }
                else
                    moveButton();
            }

            public void onFinish() {
                this.start();
            }
        }.start();
    }
}
