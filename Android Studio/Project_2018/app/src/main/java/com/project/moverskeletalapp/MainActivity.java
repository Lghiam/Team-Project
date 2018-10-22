package com.project.moverskeletalapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Button to go to the Login/reg page from the splash screen
    public void buttonToLogin(View view){
        Intent intent = new Intent(this, LoginRegActivity.class);
        startActivity(intent);

    }
}
