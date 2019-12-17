package com.f19.rosette_768425_ft;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Listener {

    ArrayList<Person> persons = new ArrayList<>();
    boolean flag = false;
    boolean mIsDualPane = false;

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

        if(savedInstanceState!=null){
            persons = (ArrayList<Person>) savedInstanceState.getSerializable("data");
        }


        MainFragment mainFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.main_frag);
        if(persons.size() > 0)
            mainFragment.displayDetails(persons);

        mIsDualPane = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;//detailView != null && detailView.getVisibility() == View.VISIBLE;

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == Constants.INTENT_REQUEST_CODE_ADD_USER) {
            if(data.getExtras() != null)
            {
                Person person = (Person) data.getExtras().get("addNew");
                if (person != null) {
                    persons.add(person);
                }
            }
        }
    }


    @Override
    public void onItemClick(int id) {
        Log.i("Clicked", "You clicked position " + id);

        if(mIsDualPane) {
            PersonDetailsFragment descriptionFragment = (PersonDetailsFragment) getSupportFragmentManager().findFragmentById(R.id.details_frag);
            descriptionFragment.displayDetails(persons.get(id));

        } else {
            Intent intent = new Intent(MainActivity.this, PersonDetailsActivity.class);
            intent.putExtra("detail", persons.get(id));
            startActivity(intent);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("data", persons);
    }


}
