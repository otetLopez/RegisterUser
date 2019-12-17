package com.f19.rosette_768425_ft;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.DataSetObserver;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

public class CustomAdapter extends FragmentActivity implements ListAdapter  {
    private ArrayList<Person> personLists;
    private Context context;

    public CustomAdapter(Context context, ArrayList<Person> personLists) {
        this.personLists = personLists;
        this.context = context;
    }

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
        final Person person = personLists.get(i);
        if(view == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            view = layoutInflater.inflate(R.layout.list_person, null);

            final View v = view;

            TextView textView = view.findViewById(R.id.name);
            ImageView img = view.findViewById(R.id.icon);
            TextView email = view.findViewById(R.id.email);
            TextView phone = view.findViewById(R.id.phone);
            textView.setText(person.getName());
            img.setImageResource(person.getImg());
            email.setText(person.getEmail());
            phone.setText(String.valueOf(person.getPhone()));

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("Clicked", "CustomAdapter: clicked " + person.getName() + " with " + person.getImg());

                    if(v.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                        Log.i("Clicked", "CustomAdapter: resource is in landscape. ");
                        PersonDetailsFragment descriptionFragment = (PersonDetailsFragment) ((AppCompatActivity) context).getSupportFragmentManager().findFragmentById(R.id.details_frag);
                        Log.i("Clicked", "CustomAdapter: Done declaration of  PersonDetailsFragment");
                        descriptionFragment.displayDetails(person);
                    }  else {
                        Intent intent = new Intent(context, PersonDetailsActivity.class);
                        intent.putExtra("detail", person);
                        context.startActivity(intent);
                    }
                }
            });
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
