package com.project.moverskeletalapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }
    //Button to finish Registration then go back to login page
    public void btnFinishReg(View view){
        Intent intent = new Intent(this, LoginRegActivity.class);
        startActivity(intent);

    }
}
