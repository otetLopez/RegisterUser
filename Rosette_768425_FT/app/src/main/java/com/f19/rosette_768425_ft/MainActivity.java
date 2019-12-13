package com.f19.rosette_768425_ft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Person> persons = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(Constants.ENABLE_DEBUG) {
            Person p1 = new Person("Person1", "email1@email.com", (long) 1234567891, R.drawable.icon01_01);
            Person p2 = new Person("Person2", "email2@email.com", (long) 1234432491, R.drawable.icon01_02);
            Person p3 = new Person("Person3", "email3@email.com", (long) 1245678563, R.drawable.icon01_03);
            Person p4 = new Person("Person4", "email4@email.com", (long) 1534567865, R.drawable.icon01_04);
            Person p5 = new Person("Person5", "email5@email.com", (long) 1564567834, R.drawable.icon01_05);

            persons.add(p1);
            persons.add(p2);
            persons.add(p3);
            persons.add(p4);
            persons.add(p5);
        }
        updateList();
        ListView listView = findViewById(R.id.list_names);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("Clicked", "You clicked position " + i);


                Intent intent = new Intent(MainActivity.this, PersonDetailsActivity.class);
                intent.putExtra("detail", persons.get(i));
                startActivity(intent);
            }
        });

        Button btn = findViewById(R.id.btn_add);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivityForResult(intent, Constants.INTENT_REQUEST_CODE_ADD_USER);
            }
        });

    }

    private void updateList() {
        ListView listView  = findViewById(R.id.list_names);
//        ArrayList<String> names = new ArrayList<>();
//        for(int i=0; i<persons.size(); ++i) {
//            names.add(persons.get(i).getName());
//
//        }
        //ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, names);
        //listView.setAdapter(adapter);

//        ArrayList<Person> personLists = new ArrayList<>();
//        for(int i=0; i<persons.size(); ++i) {
//            PersonList newPerson = new PersonList(persons.get(i).getName(), persons.get(i).getImg());
//            personLists.add(newPerson);
//
//        }
        CustomAdapter customAdapter = new CustomAdapter(MainActivity.this, persons);
        listView.setAdapter(customAdapter);

    }
}
