package com.amusoft.ultipedia;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by irving on 4/10/15.
 */
public class CustomArrayAdapter extends ArrayAdapter<ListItem> {
    private ArrayList<ListItem> objects;
    Context context;
    public  CustomArrayAdapter(Context context, int textViewResourceId,
                               ArrayList<ListItem> objects) {
        super(context, textViewResourceId, textViewResourceId, objects);
        this.objects = objects;
        this.context = context;
    }
    @SuppressLint("InflateParams")
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.score_item, null);
        }

        ListItem i = objects.get(position);
        if (i != null) {


            TextView tvName = (TextView) v.findViewById(R.id.name);

            TextView tvScore= (TextView) v.findViewById(R.id.score);

            if (tvName != null) {
                tvName.setText(i.getName());
            }


            if (tvScore != null) {
                tvScore.setText(i.getScore());
            }
        }
        return v;
    }
}
