package com.mrush.chayward102.moodrush;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.analytics.HitBuilders;

public class Consent extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consent);

        textView = (TextView) (findViewById(R.id.consentText));
        textView.setKeyListener(null);
    }

    public void agreeBtnClicked(View view){

        //changed to MainActivity
        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);


    }

}
