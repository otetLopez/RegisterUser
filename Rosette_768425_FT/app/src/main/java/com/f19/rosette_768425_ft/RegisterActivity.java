package com.f19.rosette_768425_ft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button btn = findViewById(R.id.btn_add);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText name = findViewById(R.id.reg_name);
                EditText email = findViewById(R.id.reg_email);
                EditText phone = findViewById(R.id.reg_phone);

                if(name.getText().toString().isEmpty() || email.getText().toString().isEmpty() || phone.getText().toString().isEmpty())
                    Toast.makeText(RegisterActivity.this, "You should fill all the fields", Toast.LENGTH_SHORT).show();
                else {
                    // Get image
                    Constants constant = new Constants();
                    Person person = new Person(name.getText().toString(),email.getText().toString(), Long.valueOf(phone.getText().toString()),
                            Constants.Icons[constant.getRandom()]);
                    Intent intent = new Intent(RegisterActivity.this, PersonDetailsActivity.class);//VerificicationActivity.class);
                    intent.putExtra("detail", person);
                    startActivity(intent);
                }

            }
        });
    }
}