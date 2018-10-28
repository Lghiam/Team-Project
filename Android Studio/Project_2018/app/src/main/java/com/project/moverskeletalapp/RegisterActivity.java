package com.project.moverskeletalapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    //Variables to hold the completed registrations intake.
    public String username;
    public String password;
    public String email;

    //temp variables used while validating.
    public String tempEmail;
    public String tempPass;

    //Boolean variables to check each validation for the inputs.
    boolean validUsername = false;
    boolean validPassword = false;
    boolean validEmail = false;

    //Code generated on page load.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    //Button to finish Registration then go back to login page.
    public void btnFinishReg(View view) {

        //Code that takes the input values to be run through validation.
        EditText checkUsername = (EditText) findViewById(R.id.setUsername);
        EditText checkPassword = (EditText) findViewById(R.id.setPassword);
        tempPass = checkPassword.getText().toString();
        EditText checkEmail = (EditText) findViewById(R.id.setEmail);
        tempEmail = checkEmail.getText().toString();
        TextView DisplayedMessage = findViewById(R.id.outputError);

        //Assigns the required characters for the email validation.
        Pattern patternEmail = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcherEmail = patternEmail.matcher(tempEmail);

        //Assigns the required characters for the password validation
        Pattern patternPassword = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$");
        Matcher matcherPassword = patternPassword.matcher(tempPass);

        //Code to validate the password.
        if (matcherPassword.matches() == true) {
            validPassword = true;
        } else {
            validPassword = false;
            checkPassword.setError(checkPassword.getHint() + " is invalid");
        }

        //code to validate the email.
        if (matcherEmail.matches() == true) {
            validEmail = true;
        } else {
            validEmail = false;
            checkEmail.setError(checkEmail.getHint() + " is invalid");
        }

        //code to validate the username
        if (checkUsername.length() > 8) {
            validUsername = true;
        } else {
            validUsername = false;
            checkUsername.setError(checkUsername.getHint() + " is too short");
        }

        //code that checks all three inputs are valid
        if (validPassword == true && validEmail == true && validUsername == true) {
            DisplayedMessage.setText(String.valueOf("Registration Completed"));

            //code that saves the validated inputs to the necessary variables
            username = checkUsername.getText().toString();
            email = tempEmail;
            password = tempPass;

            //code to add a 1.5 second delay before changing the view.
            try {
                //sleep 1.5 seconds
                Thread.sleep(1500);

                //code that brings the user back to the login screen.
                Intent returnToLoading = new Intent(this, LoginRegActivity.class);
                startActivity(returnToLoading);
            } catch (InterruptedException e) {
                e.printStackTrace();
                DisplayedMessage.setText(String.valueOf("Problem with sleeper catch"));
            }
        //Code that happens if the validation fails.
        } else {
            DisplayedMessage.setText(String.valueOf("Problem with Registration"));
        }
    }
}


