package com.mrush.chayward102.moodrush;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class RunningWho extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_running_who);

        textView = (TextView) (findViewById(R.id.runningWhoText));
        textView.setKeyListener(null);

        textView.setMovementMethod(new ScrollingMovementMethod());
    }
}
