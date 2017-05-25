package com.mrush.chayward102.moodrush;

import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ResultsMediumRisk extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results_medium_risk);
    }


    /** Called when the user selects an image*/

    public void onClick(View v) {

        //Gets the button that has been clicked
        Button btnClicked = (Button)findViewById(v.getId());

        //Gets the tag assigned to the clicked button and converts it to and Integer
        int id = Integer.parseInt(btnClicked.getTag().toString());



        // 1 go to
        if(id == 1){
            // user BoD suggests using Intent.ACTION_PICK instead of .ACTION_GET_CONTENT to avoid the chooser
            Intent intent = new Intent(Intent.ACTION_PICK);
            // BoD con't: CONTENT_TYPE instead of CONTENT_ITEM_TYPE
            intent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
            startActivityForResult(intent, 1);
        }
        else if(id ==2 ){
            Intent intent = new Intent(this, Index2.class);
            startActivity(intent);
        }
        else {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.healthpoint.co.nz/gps-accident-urgent-medical-care/"));
            startActivity(browserIntent);
        }


        //changes screen

    }
}
