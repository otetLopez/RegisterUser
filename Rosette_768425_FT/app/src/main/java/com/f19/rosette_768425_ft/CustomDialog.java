package com.f19.rosette_768425_ft;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class CustomDialog extends Dialog implements android.view.View.OnClickListener {

    public Activity activity;
    public Dialog d;
    public Button ok;
    String text;

    public CustomDialog(Activity activity, String text) {
        super(activity);
        // TODO Auto-generated constructor stub
        this.activity = activity;
        this.text = text;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.custom_dialog);
        TextView textView = findViewById(R.id.txt_dia);
        textView.setText(this.text);
        ok = (Button) findViewById(R.id.btn_ok);
        ok.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        dismiss();

        if(this.text == Constants.INPUT_VERIFIED) {
            this.activity.finish();
        }
    }
}
