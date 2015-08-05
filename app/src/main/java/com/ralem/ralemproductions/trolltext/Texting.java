package com.ralem.ralemproductions.trolltext;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


import com.applovin.adview.AppLovinInterstitialAd;
import com.ralem.ralemproductions.trolltext.R;

import java.util.ArrayList;


public class Texting extends Activity {
    private TextView enemyName;
    private TextView enemyNumber;
    private SeekBar harass;
    public int harassometer;
    private static Texting inst;
    ArrayList<String> smsMessagesList = new ArrayList<String>();
    ListView smsListView;
    ArrayAdapter arrayAdapter;

    public static Texting instance() {
        return inst;
    }

    @Override
    public void onStart() {
        super.onStart();
        inst = this;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppLovinInterstitialAd.show(this);
        setContentView(R.layout.activity_texting);
        Intent intent = getIntent();
        harass = (SeekBar) findViewById(R.id.seekBar);
        enemyName = (TextView) findViewById(R.id.enemyName);
        enemyNumber = (TextView) findViewById(R.id.enemyNumber);
        enemyNumber.setText(intent.getStringExtra("number"));
        enemyName.setText(intent.getStringExtra("name"));

    harass.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        harassometer=progress;
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    });
    }

    public void refreshSmsInbox() {

    }




    public void Button1(View view){
        sendSMSMessage("Yes");


    }
    public void Button2(View view){
        sendSMSMessage("No");


    }
    public void Button3(View view){
        sendSMSMessage("Call me");


    }
    public void Button4(View view){
        sendSMSMessage("Thank you");


    }
    public void Button5(View view){
        sendSMSMessage("Give me 15");


    }
    public void Button6(View view){
        sendSMSMessage("HELP!");


    }


    protected void sendSMSMessage(String newMessage) {


        String message = newMessage;
        Intent intent = getIntent();

        try {
            SmsManager smsManager = SmsManager.getDefault();
            for(int i = 0; i <= harassometer; i++){
            smsManager.sendTextMessage((intent.getStringExtra("number")), null, message, null, null);
            }
            Toast.makeText(getApplicationContext(), intent.getStringExtra("number") +" sent " + harassometer+1 + " texts", Toast.LENGTH_LONG).show();

        }

        catch (Exception e) {
            Toast.makeText(getApplicationContext(), "SMS faild, please try again.", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }



}