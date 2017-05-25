package com.mrush.chayward102.moodrush;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.provider.ContactsContract;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

public class ResultsHighRisk extends AppCompatActivity {

    DatabaseHelper myDB;
    private Tracker mTracker;

    /**
     * The {@link Tracker} used to record screen views.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results_high_risk);

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
        String name = getResources().getString(R.string.q2);

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
        Button btnClicked = (Button) findViewById(v.getId());

        //Gets the tag assigned to the clicked button and converts it to and Integer
        int id = Integer.parseInt(btnClicked.getTag().toString());


        mTracker.send(new HitBuilders.EventBuilder()
                .setCategory(getResources().getString(R.string.q2))
                .setAction(new String[]{"call_friend", "call_111", "call_youthline", "call_lifeline", "main_menu"}[id])
                .setValue(id)
                .build());

        //Adds the data to the database dependent on the button that is clicked using the tag


        //changes screen

        switch (id) {
            case 1:
                // user BoD suggests using Intent.ACTION_PICK instead of .ACTION_GET_CONTENT to avoid the chooser
                Intent intent = new Intent(Intent.ACTION_PICK);
                // BoD con't: CONTENT_TYPE instead of CONTENT_ITEM_TYPE
                intent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
                startActivityForResult(intent, 1);

                break;
            case 2:
                Intent i = new Intent(Intent.ACTION_DIAL);
                String p = "tel:" + getString(R.string.phone_number_111);
                i.setData(Uri.parse(p));
                startActivity(i);
                break;
            case 3:
                Intent j = new Intent(Intent.ACTION_DIAL);
                String q = "tel:" + getString(R.string.phone_number_youthline);
                j.setData(Uri.parse(q));
                startActivity(j);
                break;
            case 4:
                Intent k = new Intent(Intent.ACTION_DIAL);
                String r = "tel:" + getString(R.string.phone_number_lifeline);
                k.setData(Uri.parse(r));
                startActivity(k);
            case 5:


            default:
                System.out.println("Invalid grade");
        }

    }

}
