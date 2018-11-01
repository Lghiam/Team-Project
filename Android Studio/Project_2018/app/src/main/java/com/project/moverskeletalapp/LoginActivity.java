package com.project.moverskeletalapp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {

    //Declaring Varaibles
    private EditText emailET;
    private EditText passwordET;
    private Button logBtn;
    private Boolean validateEmail;
    private Boolean validatePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailET = findViewById(R.id.EmailET);
        passwordET = findViewById(R.id.PasswordET);
        logBtn = findViewById(R.id.logBtn);

        //On click function for login button. checks the condition of validation mentioned below/
        logBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmInput(v);
            }
        });

    }


    //redirects user to Next page after successful login
    public void SecondActivity() {
        Intent intent = new Intent(this, UserChoiceActivity.class);
        startActivity(intent);
    }

    //checks the validation conditions for email.
    private boolean validateEmail() {
        String email = emailET.getText().toString().trim();

        //checking if there are an blanks in the text boxes. if there is it will no redirect to the next page unless it is filled
        if (email.isEmpty()) {
            emailET.setError("Field can't be empty");
            return false;
        } else {
            emailET.setError(null);
            return true;
        }
    }

    //checks the validation conditions for password.
    private boolean validatePassword() {
        String password = passwordET.getText().toString().trim();

        //checking if there no blanks in the text boxes and making sure the password is not less than 5 characters. conditions must be met to continue to next page
        if (password.isEmpty()) {
            passwordET.setError("fields can't be empty");
            return false;
        } else if (passwordET.length() < 5) {
            passwordET.setError("password is too short");
            return false;
        } else {
            passwordET.setError(null);
            return true;
        }
    }

    //method is used to check to see of both validation conditions for email and password are true or false. if conditions are met, user will be redirected to next page.
    public void confirmInput(View v) {
        if (validateEmail() && validatePassword()) {
            SecondActivity();
        }

        //prints a small box below with email and password entered.
        String input = "email: " + emailET.getText().toString().trim();
        input += "\n";
        input += "password: " + passwordET.getText().toString().trim();

        //Toast method below is used to display the box.
        Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
    }




}