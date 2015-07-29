package com.example.ralemproductions.trolltext;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


/**
 * Created by ShaunDesktop on 7/28/2015.
 */
public class RalemContactsListAdapter extends BaseAdapter {
    Activity context;
    String title[];
    String description[];

    public RalemContactsListAdapter(Activity activity, RalemContacts rContacts) {
        super();
        this.context = activity;
        String[] names = new String[rContacts.ContactsCount()];
        for(int loop = 0; loop < names.length; loop++){
            names[loop] = rContacts.getName(loop);
        }

        String[] numbers = new String[rContacts.ContactsCount()];
        for(int loop = 0; loop < numbers.length; loop++){
            numbers[loop] = rContacts.getNumber(loop);
        }

        this.title = names;
        this.description = numbers;
    }


    public RalemContactsListAdapter(Activity context, String[] title, String[] description) {
        super();
        this.context = context;
        this.title = title;
        this.description = description;
    }

    public int getCount() {
        // TODO Auto-generated method stub
        return title.length;
    }

    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    private class ViewHolder {
        TextView txtViewTitle;
        TextView txtViewDescription;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        ViewHolder holder;
        LayoutInflater inflater = context.getLayoutInflater();

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.ralem_contacts_list_view, null);
            holder = new ViewHolder();
            holder.txtViewTitle = (TextView) convertView.findViewById(R.id.textView1);
            holder.txtViewDescription = (TextView) convertView.findViewById(R.id.textView2);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.txtViewTitle.setText(title[position]);
        holder.txtViewDescription.setText(description[position]);

        return convertView;
    }

}
