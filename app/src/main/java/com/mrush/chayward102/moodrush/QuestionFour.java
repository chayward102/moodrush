/**
 * Question Four
 */

package com.mrush.chayward102.moodrush;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;


public class QuestionFour extends AppCompatActivity {

    private Tracker mTracker;

    /**
     * The {@link Tracker} used to record screen views.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_four);

        // [START shared_tracker]
        // Obtain the shared Tracker instance.
        AnalyticsApplication application = (AnalyticsApplication) getApplication();
        mTracker = application.getDefaultTracker();
        // [END shared_tracker]

        sendScreenName();
    }

    private void sendScreenName() {
        String name = getResources().getString(R.string.q4);

        // [START screen_view_hit]
        mTracker.setScreenName(name);
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());
        // [END screen_view_hit]
    }

    /**
     * Called when the user selects an image
     */

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.a: {
                // handle button A click;
                mTracker.send(new HitBuilders.EventBuilder()
                        .setCategory(getResources().getString(R.string.q4))
                        .setAction("a")
                        .setLabel("A")
                        .setValue(1)
                        .build());
                Intent intent = new Intent(this, QuestionFive.class);
                startActivity(intent);
                break;
            }
            case R.id.b: {
                // handle button b click;
                mTracker.send(new HitBuilders.EventBuilder()
                        .setCategory(getResources().getString(R.string.q4))
                        .setAction("b")
                        .setLabel("B")
                        .setValue(2)
                        .build());
                Intent intent = new Intent(this, QuestionFive.class);
                startActivity(intent);
                break;
            }
            case R.id.c: {
                //handle button c click;
                mTracker.send(new HitBuilders.EventBuilder()
                        .setCategory(getResources().getString(R.string.q4))
                        .setAction("c")
                        .setLabel("A")
                        .setValue(1)
                        .build());
                Intent intent = new Intent(this, QuestionFive.class);
                startActivity(intent);
                break;
            }
            case R.id.d: {
                //handle button d click
                mTracker.send(new HitBuilders.EventBuilder()
                        .setCategory(getResources().getString(R.string.q4))
                        .setAction("d")
                        .setLabel("A")
                        .setValue(1)
                        .build());
                Intent intent = new Intent(this, QuestionFive.class);
                startActivity(intent);
                break;
            }

            default:
                throw new RuntimeException("Unknown button ID");
        }

    }

}

