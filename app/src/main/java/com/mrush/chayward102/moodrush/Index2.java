package com.mrush.chayward102.moodrush;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static com.mrush.chayward102.moodrush.R.styleable.View;

public class Index2 extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index2);

        textView = (TextView) (findViewById(R.id.welcomeText));
        textView.setKeyListener(null);
    }

    public void consentBtnClicked(View view){
        Intent intent = new Intent(this, Consent.class);
        startActivity(intent);
    }

    public void aboutBtnClicked(View view){
        Intent intent = new Intent(this, About.class);
        startActivity(intent);
    }


    public void howStudyBtnClicked(View view){
        Intent intent = new Intent(this, HowWorks.class);
        startActivity(intent);
    }


    public void whoRunStudyClicked(View view){
        Intent intent = new Intent(this, RunningWho.class);
        startActivity(intent);
    }










}
