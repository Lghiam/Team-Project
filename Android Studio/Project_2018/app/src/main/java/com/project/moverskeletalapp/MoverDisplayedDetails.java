package com.project.moverskeletalapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MoverDisplayedDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mover_displayed_details);
    }

    // Button to go to Contact page
    public void btnContactMover(View view){
        Intent intent = new Intent(this, ChatCustomerSideActivity.class);
        startActivity(intent);

    }

    // Button to go to Map page
    public void btnMap(View view){
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);

    }

    // Button to go to Review page
    public void btnReview(View view){
        Intent intent = new Intent(this, ReviewActivity.class);
        startActivity(intent);

    }
}
