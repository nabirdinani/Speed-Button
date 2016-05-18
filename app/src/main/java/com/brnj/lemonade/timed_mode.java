package com.brnj.lemonade;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.app.ActionBar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


public class timed_mode extends Activity {
    public final static String SCORE = "com.example.myfirstapp.timed.SCORE";
    int currentScore = 0;
    Boolean gameStarted = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        ActionBar actionBar = getActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_timed_mode);
        startCountDown();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_timed_mode, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void startCountDown(){
        new CountDownTimer(5000, 1000) {
        public void onTick(long millisUntilFinished) {
                updateTextView("" + millisUntilFinished / 1000);

        }
            public void onFinish() {
                updateTextView("Go!");
                gameStarted = true;
                startGame();
            }
        }.start();
    }

    public void addToScore(View view){
        if(gameStarted) {
            Button button = (Button) findViewById(R.id.button);
            Random r = new Random();
            int buttonHeight;
            int buttonWidth;
            buttonHeight = button.getHeight();
            buttonWidth = button.getWidth();
            int xLeft = r.nextInt(480 - buttonHeight);
            int yUp = r.nextInt(800 - buttonWidth);
            int xRight = r.nextInt(430 + buttonHeight);
            int yDown = r.nextInt(800 + buttonHeight);

            button.setX(xLeft-15);
            button.setY(yUp-15);
            button.setX(xRight-10);
            button.setY(yDown-10);

            ++currentScore;
            updateScoreTextView("Current Score:" + currentScore);
        }
    }

    public void startGame(){
        updateTextView("");
        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setTextSize(30);
        textView.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_START);
        new CountDownTimer(60000, 1000) {
            public void onTick(long millisUntilFinished) {
                updateTextView("" + millisUntilFinished / 1000);
            }
            public void onFinish() {
                endGame();
            }
        }.start();
    }
    public void updateTextView(String toThis) {
        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText(toThis);
    }
    public void updateScoreTextView(String toThis) {
        TextView textView = (TextView) findViewById(R.id.textView3);
        textView.setText(toThis);
    }
    public void endGame(){
        Intent scoreIntent = new Intent(this, show_score.class);
        String score = "" + currentScore;
        scoreIntent.putExtra(SCORE, score);
        startActivity(scoreIntent);
    }
}
