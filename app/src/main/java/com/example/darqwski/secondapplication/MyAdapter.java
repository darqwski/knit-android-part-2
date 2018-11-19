package com.example.darqwski.secondapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Darqwski on 2018-11-19.
 */

public class MyAdapter  extends ArrayAdapter<Article> {

    ArrayList<Article> items;

    public MyAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public MyAdapter(Context context, int resource, ArrayList<Article> items) {
        super(context, resource, items);
        this.items= items;
    }

    @Override
    public View getView(final int position,final View convertView, final ViewGroup parent) {

        View v = convertView;
        Log.wtf("Position", String.valueOf(position));
        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.typical_view, null);
           final Article value = items.get(position);
            ((TextView)v.findViewById(R.id.typicalTextTitle)).setText(value.title);
        }

        //  String p = getItem(position);
        final int pos = position;

        return v;
    }




}