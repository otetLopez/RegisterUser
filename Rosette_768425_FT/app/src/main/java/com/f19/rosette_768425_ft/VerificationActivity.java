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
    boolean isChecked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verificication);

        final Intent intent = getIntent();
        final Person person = (Person) intent.getExtras().get("detail");

        GridView gridView = findViewById(R.id.gridView);
        iconAdapter = new ImgAdapter(this);
        setImages();

//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(VerificationActivity.this, "You clicked on " + iconAdapter.getItem(position), Toast.LENGTH_SHORT).show();
//                //ImageView img = (ImageView) view;
//                //img.setImageResource(R.drawable.checked);
//                //img.setBackgroundResource((Integer) iconAdapter.getItem(position));
//            }
//        });

        final CheckBox check = findViewById(R.id.checkbox);

        Button btn = findViewById(R.id.btn_verify);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check.isChecked() && iconAdapter.checkAnswer()) {
                    CustomDialog d = new CustomDialog(VerificationActivity.this, Constants.INPUT_VERIFIED);
                    d.show();

                    Intent returnIntent = new Intent();
                    setResult(RegisterActivity.RESULT_OK,returnIntent);
                } else {

                    CustomDialog d = new CustomDialog(VerificationActivity.this, Constants.INPUT_NOT_VERIFIED);
                    d.show();

                    //Toast.makeText(VerificationActivity.this, "You are a robot", Toast.LENGTH_SHORT).show();
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

    public void verified()  {
        Intent returnIntent = new Intent();
        setResult(RegisterActivity.RESULT_OK,returnIntent);
        finish();
    }
}
