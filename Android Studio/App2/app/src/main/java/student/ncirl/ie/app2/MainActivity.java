package student.ncirl.ie.app2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    //Declaring Variables
    private EditText fname;
    private EditText lname;
    private EditText phone;
    private EditText address;
    private EditText price;
    private Spinner type;
    private Button save;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Searching for ID of variables by the name of the Text box
        fname = findViewById(R.id.FnameET);
        lname = findViewById(R.id.LnameET);
        phone = findViewById(R.id.PhoneET);
        address = findViewById(R.id.AddressET);
        price = findViewById(R.id.PriceET);
        type = findViewById(R.id.spinner1);
        save = findViewById(R.id.saveBtn);

        //On click function for save details button. It calls upon the validate method which checks all the text boxes.
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(v);
            }
        });

        Spinner spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Type, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    //the User choice function is used for redirecting the user to the next page.
    public void UserChoice(){
        Intent intent = new Intent(this, SecondActivity.class);
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
        } else if (phone.length()<10) {
            phone.setError("Not a valid phone Number");
            return false;
        } else {
            phone.setError(null);
            return true;
        }
    }

    //boolean statement is used for checking to see if the address box is or is not empty
    private boolean validateaddress(){
        String homeaddress = address.getText().toString().trim();

        if(homeaddress.isEmpty()){
            address.setError("Fields can't be empty");
            return false;
        } else {
            address.setError(null);
            return true;
        }
    }

    //boolean statement is used for checking to see if the price box is or is not empty
    private boolean validateprice(){
        String amount = price.getText().toString().trim();

        if(amount.isEmpty()){
            price.setError("Fields can't be empty");
            return false;
        } else {
            price.setError(null);
            return true;
        }
    }


    //the validate method below checks to see if all the boolean statements above are true or false. if the boolean statements are true then it will select the User choice method. this calls upon the redirect activity at the top of the page which will redirect the user to the next page.
    public void validate(View v){
        if (validatefname() && validatelname() && validatephone() && validateaddress() && validateprice()){
            UserChoice();
            String input = " Your Detail have been saved";

            //Toast methos prints out the above string in a little box
            Toast.makeText(this, input, Toast.LENGTH_LONG).show();
        }


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

