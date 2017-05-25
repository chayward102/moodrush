package com.mrush.chayward102.moodrush;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class quizResults extends AppCompatActivity {

    DatabaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_results);


        myDB = new DatabaseHelper(this);

        Cursor c = myDB.getListContents();

        TextView name = (TextView)findViewById(R.id.txtRes);
        int sum = myDB.getSum();


       String stringSum = Integer.toString(sum);
        Toast.makeText(this, stringSum,Toast.LENGTH_LONG).show();

        name.setText( "Your score: " + Integer.toString(sum) );
        if (sum<22){
            setContentView(R.layout.activity_results_low_risk);
        }

        else if(sum>21 && sum<29){
            setContentView(R.layout.activity_results_medium_risk);
        }
        else{
            setContentView(R.layout.activity_results_high_risk);
        }



/*
        //populate an ArrayList<String> from the database and then view it
        ArrayList<String> theList = new ArrayList<>();
        //Cursor data = myDB.getSum();
        if(data.getCount() == 0){
            Toast.makeText(this, "There are no contents in this list!",Toast.LENGTH_LONG).show();
        }else{
            while(data.moveToNext()){
                ((TextView)findViewById(R.id.textView1)).setText("total score is: " + data.getString(1));
            }
        }
        */


    }
}