package com.f19.rosette_768425_ft;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    Person person;

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
                    person = new Person(name.getText().toString(),email.getText().toString(), Long.valueOf(phone.getText().toString()),
                            Constants.Icons[constant.getRandom(Constants.ICON_COUNT)]);
                    Intent intent = new Intent(RegisterActivity.this, VerificationActivity.class);
                    intent.putExtra("detail", person);
                    //intent.addFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
                    //startActivity(intent);
                    //finish();
                    startActivityForResult(intent, Constants.INTENT_REQUEST_CODE_VERIFY_USER);
                }

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == Constants.INTENT_REQUEST_CODE_VERIFY_USER) {
            if(resultCode == RESULT_OK) {
                //if(person != null) {
                    Intent returnIntent = new Intent();
                    returnIntent.putExtra("addNew", person);
                    setResult(MainActivity.RESULT_OK, returnIntent);
                    finish();
               // }
            }

        }
    }
}
