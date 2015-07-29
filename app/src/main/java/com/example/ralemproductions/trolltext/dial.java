package com.example.ralemproductions.trolltext;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class dial extends Activity {

    private String currentNumber = "";
    private TextView callText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dial);
        callText = (TextView) findViewById(R.id.call);
        UpdateCallText();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

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
    public void ClickButton(String s) {

        currentNumber += s;
        UpdateCallText();
    }

    public void BackSpace() {
        if (currentNumber.length() <= 0) {
            return;
        }
        currentNumber = currentNumber.substring(0, currentNumber.length() - 1);
        UpdateCallText();
    }

    public void UpdateCallText() {
        callText.setText(currentNumber);
    }

    public void Call() {
        try {

            Intent intentBundle = new Intent(dial.this, Texting.class);
            intentBundle.putExtra("message", currentNumber);

            startActivity(intentBundle);

        } catch (ActivityNotFoundException activityException) {

        }
    }

    public void Button1(View view) {
        ClickButton("1");

        MediaPlayer player = MediaPlayer.create(this, R.raw.one);
        player.start();

    }

    public void Button2(View view) {
        ClickButton("2");

        MediaPlayer player = MediaPlayer.create(this, R.raw.two);
        player.start();
    }

    public void Button3(View view) {
        ClickButton("3");
        MediaPlayer player = MediaPlayer.create(this, R.raw.three);
        player.start();
    }

    public void Button4(View view) {
        ClickButton("4");

        MediaPlayer player = MediaPlayer.create(this, R.raw.four);
        player.start();
    }

    public void Button5(View view) {
        ClickButton("5");

        MediaPlayer player = MediaPlayer.create(this, R.raw.five);
        player.start();
    }

    public void Button6(View view) {
        ClickButton("6");

        MediaPlayer player = MediaPlayer.create(this, R.raw.six);
        player.start();
    }

    public void Button7(View view) {
        ClickButton("7");

        MediaPlayer player = MediaPlayer.create(this, R.raw.seven);
        player.start();
    }

    public void Button8(View view) {
        ClickButton("8");

        MediaPlayer player = MediaPlayer.create(this, R.raw.eight);
        player.start();
    }

    public void Button9(View view) {
        ClickButton("9");

        MediaPlayer player = MediaPlayer.create(this, R.raw.nine);
        player.start();
    }

    public void Button0(View view) {
        ClickButton("0");
        MediaPlayer player = MediaPlayer.create(this, R.raw.zero);
        player.start();
    }

    public void ButtonDelete(View view) {
        BackSpace();
    }

    public void ButtonCall(View view) {
        Call();
    }
}
