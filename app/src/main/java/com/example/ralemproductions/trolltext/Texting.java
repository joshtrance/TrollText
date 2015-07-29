package com.example.ralemproductions.trolltext;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;



import java.util.ArrayList;


public class Texting extends Activity {
    private TextView enemyName;
    private TextView enemyNumber;
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
        setContentView(R.layout.activity_texting);
        Intent intent = getIntent();

        enemyName = (TextView) findViewById(R.id.enemyName);
        enemyNumber = (TextView) findViewById(R.id.enemyNumber);
        enemyNumber.setText(intent.getStringExtra("trollNumber"));
        enemyName.setText(intent.getStringExtra("trollName"));


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
            smsManager.sendTextMessage((intent.getStringExtra("trollnumber")), null, message, null, null);
            Toast.makeText(getApplicationContext(), "SMS sent.", Toast.LENGTH_LONG).show();
        }

        catch (Exception e) {
            Toast.makeText(getApplicationContext(), "SMS faild, please try again.", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }



}