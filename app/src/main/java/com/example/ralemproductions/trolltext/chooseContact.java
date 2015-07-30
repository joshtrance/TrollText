package com.example.ralemproductions.trolltext;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


public class chooseContact extends Activity {

    //test

    private static final String TAG = "myLog";
    RalemContacts rContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_contact);

        rContacts = new RalemContacts(this);

        ListView contactListView = (ListView) findViewById(R.id.contactList);
        RalemContactsListAdapter contactAdapter = new RalemContactsListAdapter(this, rContacts);

        contactListView.setAdapter(contactAdapter);
        contactListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Intent intent=new Intent(chooseContact.this,Texting.class);
                intent.putExtra("number", rContacts.getNumber(position));

                startActivity(intent);
            }
    });
    }
    //public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    // TODO Auto-generated method stub
    //Toast.makeText(this, "NAME: " + rContacts.getName(position).toString() + "  NUMBER: " + rContacts.getNumber(position).toString(), Toast.LENGTH_SHORT).show();
    //}


}