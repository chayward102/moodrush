package com.mrush.chayward102.moodrush;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class HowWorks extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_works);

        textView = (TextView) (findViewById(R.id.howStudyText));
        textView.setKeyListener(null);
    }
}
