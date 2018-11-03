package com.project.moverskeletalapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginRegActivity extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_reg);


        button = (Button) findViewById(R.id.BtnL);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BtnLogin();
            }
        });

        button = (Button) findViewById(R.id.BtnR);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BtnToRegister();
            }
        });
    }

    // Button to go to the Registration Page
    public void BtnToRegister(){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);

    }
    //Button that accepts login Details and goes to user choice page
    public void BtnLogin(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);

    }
}
