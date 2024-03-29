package com.f19.rosette_768425_ft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PersonDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_details);

        Intent intent = getIntent();
        Person person = (Person) intent.getExtras().get("detail");

        PersonDetailsFragment descriptionFragment = (PersonDetailsFragment) getSupportFragmentManager().findFragmentById(R.id.details_frag);
        descriptionFragment.displayDetails(person);

    }
}
