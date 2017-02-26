package com.mrush.chayward102.moodrush;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    /** Called when the user clicks the lets go button*/
    public void goToQuestionOne(View view){
        Intent intent = new Intent(this, QuestionOne.class);
        startActivity(intent);
    }
}
