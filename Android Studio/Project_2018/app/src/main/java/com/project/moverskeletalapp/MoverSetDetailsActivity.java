package com.project.moverskeletalapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MoverSetDetailsActivity extends AppCompatActivity {

    private EditText fname;
    private EditText lname;
    private EditText phone;
    private EditText VehReg;
    private EditText ID;
    private Button Save2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mover_set_details);

        fname = findViewById(R.id.FnameET);
        lname = findViewById(R.id.LnameET);
        phone = findViewById(R.id.PhoneET);
        VehReg = findViewById(R.id.CarET);
        ID = findViewById(R.id.IdET);
        Save2 = findViewById(R.id.SaveBtn);

        Save2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Confirm(v);
            }
        });
    }
    //Saves the details entered for the mover
    public void MoverSetDetails(View view){
        Intent intent = new Intent(this, MoverListOfMatches.class);
        startActivity(intent);

    }


    //boolean statement is used for checking to see if the first name box is or is not empty
    private boolean validatefname(){
        String firstname = fname.getText().toString().trim();

        if(firstname.isEmpty()){
            fname.setError("Fields can't be empty");
            return false;
        } else {
            fname.setError(null);
            return true;
        }
    }

    //boolean statement is used for checking to see if the last name box is or is not empty
    private boolean validatelname(){
        String lastname = lname.getText().toString().trim();

        if(lastname.isEmpty()){
            lname.setError("Fields can't be empty");
            return false;
        } else {
            lname.setError(null);
            return true;
        }
    }

    //boolean statement is used for checking to see if the phone number box is or is not empty and to see of the phone number valid. it must contain 10 digits or its not clarified as a real number
    private boolean validatephone() {
        String phonenumber = phone.getText().toString().trim();

        if(phonenumber.isEmpty()) {
            phone.setError("Fields cant be empty");
            return false;
        } else {
            phone.setError(null);
            return true;
        }
    }

    //boolean statement is used for checking to see if the address box is or is not empty
    private boolean validateCar(){
        String CarReg = VehReg.getText().toString().trim();

        if(CarReg.isEmpty()){
            VehReg.setError("Fields can't be empty");
            return false;
        } else {
            VehReg.setError(null);
            return true;
        }
    }

    //boolean statement is used for checking to see if the price box is or is not empty
    private boolean validateID(){
        String moveid = ID.getText().toString().trim();

        if(moveid.isEmpty()){
            ID.setError("Fields can't be empty");
            return false;
        } else {
            ID.setError(null);
            return true;
        }
    }


    //the validate method below checks to see if all the boolean statements above are true or false. if the boolean statements are true then it will select the User choice method. this calls upon the redirect activity at the top of the page which will redirect the user to the next page.
    public void Confirm(View v){
        if (validatefname() && validatelname() && validatephone() && validateCar() && validateID()){
            MoverSetDetails(v);
            String input = " Your Details have been saved";

            //Toast methos prints out the above string in a little box
            Toast.makeText(this, input, Toast.LENGTH_LONG).show();
        }


    }

}
