package com.f19.rosette_768425_ft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class VerificationActivity extends AppCompatActivity {
    int[] images = Constants.Images;
    ImgAdapter iconAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verificication);

        final Intent intent = getIntent();
        final Person person = (Person) intent.getExtras().get("detail");

        GridView gridView = findViewById(R.id.gridView);
        iconAdapter = new ImgAdapter(this);

        setImages();

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(VerificationActivity.this, "You clicked on " + iconAdapter.getItem(position), Toast.LENGTH_SHORT).show();
            }
        });

        final CheckBox check = findViewById(R.id.checkbox);

        Button btn = findViewById(R.id.btn_verify);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!check.isChecked()) {
                    Toast.makeText(VerificationActivity.this, "You are a robot", Toast.LENGTH_SHORT).show();
                } else {
//                    Intent intent_add = new Intent(VerificationActivity.this, MainActivity.class);
//                    intent_add.putExtra("addNew", person);
//                    startActivity(intent_add);
//                    finish();
                    Intent returnIntent = new Intent();
                    //returnIntent.putExtra("addNew",person);
                    setResult(RegisterActivity.RESULT_OK,returnIntent);
                    finish();
                }
            }
        });

        ImageView imageView = findViewById(R.id.img_verify);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setImages();
            }
        });

    }

    private void setImages() {
        GridView gridView = findViewById(R.id.gridView);
        images = Constants.RandomizeArray(Constants.Images);
        iconAdapter.setImageIcons(images);
        gridView.setAdapter(iconAdapter);
    }
}
