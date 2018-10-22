package com.project.moverskeletalapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MoverSetDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mover_set_details);
    }
    //Saves the details entered for the mover
    public void btnMoverSetDetails(View view){
        Intent intent = new Intent(this, MoverListOfMatches.class);
        startActivity(intent);

    }
}
