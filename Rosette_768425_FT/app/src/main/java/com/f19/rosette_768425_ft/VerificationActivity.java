package com.f19.rosette_768425_ft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class VerificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verificication);

        Intent intent = getIntent();
        Person person = (Person) intent.getExtras().get("detail");

        GridView gridView = findViewById(R.id.gridView);

        final ImgAdapter iconAdapter = new ImgAdapter(this, Constants.Images);
        gridView.setAdapter(iconAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(VerificationActivity.this, "You clicked on " + iconAdapter.getItem(position), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
