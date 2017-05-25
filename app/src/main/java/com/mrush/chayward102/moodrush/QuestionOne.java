/**
 * Question One of Twentyone.
 */

package com.mrush.chayward102.moodrush;

import android.content.Intent;
import android.icu.text.IDNA;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;


public class QuestionOne extends AppCompatActivity {

    DatabaseHelper myDB;
    private Tracker mTracker;

    /**
     * The {@link Tracker} used to record screen views.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_one);

        // [START shared_tracker]
        // Obtain the shared Tracker instance.
        AnalyticsApplication application = (AnalyticsApplication) getApplication();
        mTracker = application.getDefaultTracker();
        // [END shared_tracker]

        //DB instance for read write to DB
        myDB = new DatabaseHelper(this);


        //for testing
        myDB.onUpgrade(myDB.getWritableDatabase(),0,1);

        sendScreenName();


    }

    private void sendScreenName() {
        String name = getResources().getString(R.string.q1);

        // [START screen_view_hit]
        mTracker.setScreenName(name);
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());
        // [END screen_view_hit]
    }

    /** Called when the user selects an image*/

    public void onClick(View v) {

        //Gets the button that has been clicked
        Button btnClicked = (Button)findViewById(v.getId());

        //Gets the tag assigned to the clicked button and converts it to and Integer
        int id = Integer.parseInt(btnClicked.getTag().toString());

        //below line is added because when question4 is selected it exceeds the range of the new String list
        id = id -1;

        mTracker.send(new HitBuilders.EventBuilder()
                .setCategory(getResources().getString(R.string.q1))
                .setAction(new String[]{"a","b","c","d"}[id])
                .setValue(id)
                .build());

        //Adds the data to the database dependent on the button that is clicked using the tag
        AddData(id);

        //changes screen
        Intent intent = new Intent(this, QuestionTwo.class);
        startActivity(intent);
    }

    public void AddData(int newEntry) {
        int questionID = Integer.parseInt(((LinearLayout) findViewById(R.id.mainLayout)).getTag().toString());
        myDB.answerQuestion(questionID,newEntry);
    }

}
