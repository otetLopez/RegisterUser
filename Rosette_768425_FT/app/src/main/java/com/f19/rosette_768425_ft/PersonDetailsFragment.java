package com.f19.rosette_768425_ft;

import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PersonDetailsFragment extends Fragment {

    View view;

    public void displayDetails(Person person) {
        Log.i("Clicked", "PersonDetailsFragment: You have clicked " + person.getName());
        if (view != null) {
            ImageView imageView = view.findViewById(R.id.detail_img);
            TextView name = view.findViewById(R.id.detail_name);
            TextView email = view.findViewById(R.id.detail_email);
            TextView phone = view.findViewById(R.id.detail_num);

            imageView.setImageResource(person.getImg());
            name.setText(person.getName());
            email.setText(person.getEmail());
            phone.setText(String.valueOf(person.getPhone()));
        }
    }

    public PersonDetailsFragment() {
        // Required empty public constructor
        Log.i("Clicked", "PersonDetailsFragment created");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.fragment_person_details, container, false);
        View v = this.view;
        return v;
    }

}
