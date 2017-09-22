/**
 * Question Three
 */

package com.mrush.chayward102.moodrush;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;


public class QuestionThree extends AppCompatActivity {

    DatabaseHelper myDB;
    private Tracker mTracker;

    /**
     * The {@link Tracker} used to record screen views.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_three);

        // [START shared_tracker]
        // Obtain the shared Tracker instance.
        AnalyticsApplication application = (AnalyticsApplication) getApplication();
        mTracker = application.getDefaultTracker();
        // [END shared_tracker]

        //New data connect database
        myDB = new DatabaseHelper(this);


        sendScreenName();
    }

    private void sendScreenName() {
        String name = getResources().getString(R.string.q3);

        // [START screen_view_hit]
        mTracker.setScreenName(name);
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());
        // [END screen_view_hit]
    }

    /**
     * Called when the user selects an image
     */

    public void onClick(View v) {

        //Gets the button that has been clicked
        Button btnClicked = (Button)findViewById(v.getId());

        //Gets the tag assigned to the clicked button and converts it to and Integer
        int id = Integer.parseInt(btnClicked.getTag().toString());

        //below line is added because when question4 is selected it exceeds the range of the new String list
        id = id -1;


        mTracker.send(new HitBuilders.EventBuilder()
                .setCategory(getResources().getString(R.string.q3))
                .setAction(new String[]{"a","b","c","d"}[id])
                .setValue(id)
                .build());

        //Adds the data to the database dependent on the button that is clicked using the tag
        AddData(id);

        //changes screen
        Intent intent = new Intent(this, QuestionFour.class);
        startActivity(intent);
    }

    public void AddData(int newEntry) {
        int questionID = Integer.parseInt(((LinearLayout) findViewById(R.id.mainLayout)).getTag().toString());
        myDB.answerQuestion(questionID,newEntry);
    }

}

