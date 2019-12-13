package com.f19.rosette_768425_ft;

import android.content.Context;
import android.database.DataSetObserver;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter implements ListAdapter {
    private ArrayList<Person> personLists;

    public CustomAdapter(Context context, ArrayList<Person> personLists) {
        this.personLists = personLists;
        this.context = context;
    }

    private Context context;

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int i) {
        return false;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public int getCount() {
        return personLists.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Person person = personLists.get(i);
        if(view == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            view = layoutInflater.inflate(R.layout.list_person, null);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });

            TextView textView = view.findViewById(R.id.name);
            ImageView img = view.findViewById(R.id.icon);
            textView.setText(person.getName());
            img.setImageResource(person.getImg());

        }
        return view;
    }

    @Override
    public int getItemViewType(int i) {
        return i;
    }

    @Override
    public int getViewTypeCount() {
        return personLists.size();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
