package com.ralem.ralemproductions.trolltext;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.ralem.ralemproductions.trolltext.R;


public class dial extends Activity {

    private String currentNumber = "";
    private TextView callText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dial);
        callText = (TextView)findViewById(R.id.numberText);
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

    public void Pass() {
        try {

            Intent intentBundle = new Intent(dial.this, Texting.class);
            intentBundle.putExtra("number", currentNumber);
            intentBundle.putExtra("name", "Enemy");
            startActivity(intentBundle);

        } catch (ActivityNotFoundException activityException) {

        }
    }

    public void Button1(View view) {
        ClickButton("1");



    }

    public void Button2(View view) {
        ClickButton("2");


    }

    public void Button3(View view) {
        ClickButton("3");

    }

    public void Button4(View view) {
        ClickButton("4");

    }

    public void Button5(View view) {
        ClickButton("5");


    }

    public void Button6(View view) {
        ClickButton("6");


    }

    public void Button7(View view) {
        ClickButton("7");


    }

    public void Button8(View view) {
        ClickButton("8");


    }

    public void Button9(View view) {
        ClickButton("9");


    }

    public void Button0(View view) {
        ClickButton("0");

    }

    public void ButtonDelete(View view) {
        BackSpace();
    }

    public void ButtonCall(View view) {
        Pass();
    }
}
