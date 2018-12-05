package com.project.moverskeletalapp;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class CustomersListOfMatchsActivity extends AppCompatActivity {

    private ListView mListView;


    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference myRef;
    private String userID;
    private static final String TAG = "ViewDatabase";


    //connecting my variables to the EditTexts in the GUI
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customers_list_of_matchs);
        mListView = (ListView) findViewById(R.id.custResultsList);


        /*
        mAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        myRef = mFirebaseDatabase.getReference();
        FirebaseUser user = mAuth.getCurrentUser();
        userID = user.getUid();
        */


        myRef.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot){
                showData(dataSnapshot);
            }

            @Override
            public void onCancelled(DatabaseError databaseError)
            {

            }
        });

    }


    //Taking a screenshot of the database to pull data
    private void showData(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()){
            moverInfo mInfo = new moverInfo();


            mInfo.setfName(ds.child(userID).getValue(moverInfo.class).getfName()); //set & get the name
            mInfo.setlName(ds.child(userID).getValue(moverInfo.class).getlName()); //set & get the name
            mInfo.setPhoneNumber(ds.child(userID).getValue(moverInfo.class).getPhoneNumber()); //set & get the name
            mInfo.setLicense(ds.child(userID).getValue(moverInfo.class).getLicense()); //set & get license number
            mInfo.setVehReg(ds.child(userID).getValue(moverInfo.class).getVehReg()); //set & get veh reg
            mInfo.setVehicleType(ds.child(userID).getValue(moverInfo.class).getVehicleType()); //set & get vechType

            //display all the information
            Log.d(TAG, "showData: Name: " + mInfo.getfName() + " " + mInfo.getlName());
            Log.d(TAG, "showData: Phone Number: " + mInfo.getPhoneNumber());
            Log.d(TAG, "showData: License: " + mInfo.getLicense());
            Log.d(TAG, "showData: Vehicle Registration: " + mInfo.getVehReg());
            Log.d(TAG, "showData: Vehicle Model: " + mInfo.getVehicleType());

            ArrayList<String> array = new ArrayList<>();
            array.add(mInfo.getfName());
            array.add(mInfo.getlName());
            array.add(mInfo.getPhoneNumber());
            array.add(mInfo.getLicense());
            array.add(mInfo.getVehReg());
            array.add(mInfo.getVehicleType());
            ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,array);
            mListView.setAdapter(adapter);

        }
    }

    //On Click command to bring up matches details
    public void btnCustomerMatch(View view){
        Intent intent = new Intent(this, MoverDisplayedDetails.class);
        startActivity(intent);

    }
}
