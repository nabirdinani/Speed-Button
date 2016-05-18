package com.brnj.lemonade;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void startTimedGame(View view){
        Intent timedIntent = new Intent(this, timed_mode.class);
        startActivity(timedIntent);
    }
    public void startRaceGame(View view){
        Intent raceIntent = new Intent(this, race_mode.class);
        startActivity(raceIntent);
    }
    public void startArcadeGame(View view){
        Intent arcadeIntent = new Intent(this, arcade_mode.class);
        startActivity(arcadeIntent);
    }

    public void startCrazyGame(View view) {
        Intent crazyIntent = new Intent(this, crazy_mode.class);
        startActivity(crazyIntent);
    }
}
