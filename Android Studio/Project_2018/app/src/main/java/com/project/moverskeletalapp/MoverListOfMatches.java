package com.project.moverskeletalapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MoverListOfMatches extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mover_list_of_matches);
    }
    //On Click command to bring up matches details
    public void btnMoverMatch(View view){
        Intent intent = new Intent(this, CustomerDisplayedDetails.class);
        startActivity(intent);

    }
}
