package com.mrush.chayward102.moodrush;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class About extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        textView = (TextView) (findViewById(R.id.aboutStudy));
        textView.setKeyListener(null);
    }
}
