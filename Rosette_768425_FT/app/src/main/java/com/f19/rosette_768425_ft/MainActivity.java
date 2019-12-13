package com.f19.rosette_768425_ft;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Person> persons = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(Constants.ENABLE_DEBUG) {
            Person p1 = new Person("Person1", "email@email.com", (long) 1234567891);
            Person p2 = new Person("Person2", "email@email.com", (long) 1234567891);
            Person p3 = new Person("Person3", "email@email.com", (long) 1234567891);
            Person p4 = new Person("Person4", "email@email.com", (long) 1234567891);
            Person p5 = new Person("Person5", "email@email.com", (long) 1234567891);

            persons.add(p1);
            persons.add(p2);
            persons.add(p3);
            persons.add(p4);
            persons.add(p5);
        }
        updateList();
        //ListView listView = findViewById(R.id.list_names);

    }

    private void updateList() {
        ListView listView  = findViewById(R.id.list_names);
        ArrayList<String> names = new ArrayList<>();
        for(int i=0; i<persons.size(); ++i) {
            names.add(persons.get(i).getName());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, names);
        listView.setAdapter(adapter);
    }
}
