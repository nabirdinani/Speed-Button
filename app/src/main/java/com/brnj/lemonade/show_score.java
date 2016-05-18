package com.brnj.lemonade;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class show_score extends Activity {
    String raceScore;
    String timedScore;
    String arcadeScore;
    String redBlackScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        timedScore = intent.getStringExtra(timed_mode.SCORE);
        arcadeScore = intent.getStringExtra(arcade_mode.SCORE);
        //redBlackScore = intent.getStringExtra(redblack_mode.SCORE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_score);
        if (intent.getStringExtra(race_mode.SCORE) != null)
            updateTextView(intent.getStringExtra(race_mode.SCORE));
        else if (intent.getStringExtra(timed_mode.SCORE) != null)
            updateTextView(intent.getStringExtra(timed_mode.SCORE));
        else if (intent.getStringExtra(arcade_mode.SCORE) != null)
            updateTextView(intent.getStringExtra(arcade_mode.SCORE));
        else if (intent.getStringExtra(crazy_mode.SCORE) != null)
            updateTextView(intent.getStringExtra(crazy_mode.SCORE));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_show_score, menu);
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
    public void updateTextView(String toThis) {
        TextView textView = (TextView) findViewById(R.id.textView3);
        textView.setText(toThis);
    }
    public void endScreen(View view){
        Intent mainIntent = new Intent(this, MainActivity.class);
        startActivity(mainIntent);
    }
}
