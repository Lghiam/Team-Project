package com.project.moverskeletalapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CustomersListOfMatchsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customers_list_of_matchs);
    }

    //On Click command to bring up matches details
    public void btnCustomerMatch(View view){
        Intent intent = new Intent(this, MoverDisplayedDetails.class);
        startActivity(intent);

    }
}
