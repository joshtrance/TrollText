package com.example.ralemproductions.trolltext;

import android.app.Activity;
import android.database.Cursor;
import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * //
 * Created by ShaunDesktop on 7/28/2015.
 */
public class RalemContacts {

    private List<RalemContactData> contactDataList = new ArrayList<RalemContactData>();

    public RalemContacts(Activity currentActivity) {

        Cursor phones = currentActivity.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);

        while (phones.moveToNext())
        {
            String currentName=phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String currentPhoneNumber = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

            RalemContactData currentContactData = new RalemContactData();
            currentContactData.name = currentName;
            currentContactData.number = currentPhoneNumber;

            boolean alreadyContains = false;
            for(int loop = 0; loop < contactDataList.size(); loop++){
                if(currentPhoneNumber.equals(contactDataList.get(loop).number))
                { alreadyContains = true; break;}
            }

            if(!alreadyContains){
                contactDataList.add(currentContactData);
            }

        }

        Collections.sort(contactDataList, new RalemContactsComparator());

        phones.close();

    }

    public int ContactsCount(){
        return contactDataList.size();
    }
    public String getName(int i){
        return contactDataList.get(i).name;
    }
    public String getNumber(int i){
        return contactDataList.get(i).number;
    }

}

class RalemContactData{
    String name;
    String number;
}

class RalemContactsComparator implements Comparator<RalemContactData> {

    @Override
    public int compare(RalemContactData lhs, RalemContactData rhs) {
        return lhs.name.toLowerCase().compareTo(rhs.name.toLowerCase());
    }
}
