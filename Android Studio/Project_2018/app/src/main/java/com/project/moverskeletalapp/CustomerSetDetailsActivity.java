package com.project.moverskeletalapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CustomerSetDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_set_details);
    }
    // Saves the details to the server
    public void btnCustomerSaveDetails(View view){
        Intent intent = new Intent(this, CustomersListOfMatchsActivity.class);
        startActivity(intent);

    }
}
