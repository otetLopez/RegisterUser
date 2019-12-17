package com.f19.rosette_768425_ft;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 *
 */
interface Listener {
    void onItemClick(int id);
}
public class MainFragment extends Fragment {
    private View view;
    LayoutInflater inflater;
    Listener listener;
    ArrayList<Person> persons = new ArrayList<>();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listener = (Listener) context;
    }

    public MainFragment() {
         // Required empty public constructor
    }

    public void displayDetails(ArrayList<Person> persons) {

         ListView listView  = view.findViewById(R.id.list);

        if(persons.size() > 0) {
            this.persons = persons;
            CustomAdapter customAdapter = new CustomAdapter(view.getContext(), persons);
            listView.setAdapter(customAdapter);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        this.view = inflater.inflate(R.layout.fragment_main, container, false);
        this.inflater = inflater;
        updateList();

        Button btn = view.findViewById(R.id.btn_add);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), RegisterActivity.class);
                startActivityForResult(intent, Constants.INTENT_REQUEST_CODE_ADD_USER);
            }
        });

        //inflater.inflate(R.layout.fragment_person_details, container, false);
        return this.view;
    }

    private void updateList() {
        ListView listView = view.findViewById(R.id.list);
        if(persons.size() > 0) {
            CustomAdapter customAdapter = new CustomAdapter(view.getContext(), persons);
            listView.setAdapter(customAdapter);
        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == Constants.INTENT_REQUEST_CODE_ADD_USER) {
            if(data.getExtras() != null)
            {
                Person person = (Person) data.getExtras().get("addNew");
                if (person != null) {
                    persons.add(person);
                    updateList();
                }
            }

        }
    }

//    @Override
//    public void onListItemClick(ListView l, View v, int position, long id) {
//        if (listener != null)
//            listener.onItemClick(position);
//    }


}
