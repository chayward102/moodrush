/**
 * Question One of Twentyone.
 */

package com.mrush.chayward102.moodrush;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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

        //creat DB
        myDB = new DatabaseHelper(this);

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
        switch (v.getId()) {
            case R.id.a: {
                // handle button A click;
                mTracker.send(new HitBuilders.EventBuilder()
                        .setCategory(getResources().getString(R.string.q1))
                        .setAction("a")
                        .setLabel("A")
                        .setValue(1)
                        .build());
                //insert answer into DB
                myDB.addData(0);
                Intent intent = new Intent(this, quizResults.class);
                startActivity(intent);
                break;
            }
            case R.id.b: {
                // handle button b click;
                mTracker.send(new HitBuilders.EventBuilder()
                        .setCategory(getResources().getString(R.string.q1))
                        .setAction("b")
                        .setLabel("B")
                        .setValue(2)
                        .build());
                //insert answer into DB
                AddData(1);
                Intent intent = new Intent(this, QuestionTwo.class);
                startActivity(intent);
                break;
            }
            case R.id.c: {
                //handle button c click;
                mTracker.send(new HitBuilders.EventBuilder()
                        .setCategory(getResources().getString(R.string.q1))
                        .setAction("c")
                        .setLabel("C")
                        .setValue(3)
                        .build());
                //insert answer into DB
                AddData(1);
                Intent intent = new Intent(this, QuestionTwo.class);
                startActivity(intent);
                break;
            }
            case R.id.d: {
                //handle button d click
                mTracker.send(new HitBuilders.EventBuilder()
                        .setCategory(getResources().getString(R.string.q1))
                        .setAction("d")
                        .setLabel("C")
                        .setValue(4)
                        .build());
                //insert answer into DB
                AddData(1);
                Intent intent = new Intent(this, QuestionTwo.class);
                startActivity(intent);
                break;
            }

            default:
                throw new RuntimeException("Unknown button ID");
        }

    }

    public void AddData(int newEntry) {


    }

}
