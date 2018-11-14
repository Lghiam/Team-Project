package com.project.moverskeletalapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class CustomerDisplayedDetails extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_customer_displayed_details);
    }
    public void btnContactCustomer(View view){
        Intent intent = new Intent(this, ChatMoverSideActivity.class);
        startActivity(intent);

    }
}
