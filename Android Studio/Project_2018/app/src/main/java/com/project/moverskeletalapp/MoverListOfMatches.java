package com.project.moverskeletalapp;

import android.content.Intent;
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

public class MoverListOfMatches extends AppCompatActivity {

    //creating my ET variables
    //private boolean validateAddress;
    private static final String TAG = "ViewDatabase";
    private ListView cListView;


    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference myRef;
    private String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mover_list_of_matches);

        //connecting my variables to the ETs in GUI

        //taking snapshot of database to grab data
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
    //attaching data pulled from DB to empty variables in GUI
    private void showData(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()){

            customerInfo cInfo = new customerInfo();

            cInfo.setCustFName(ds.child(userID).getValue(customerInfo.class).getCustFName()); //set & get the name
            cInfo.setCustLName(ds.child(userID).getValue(customerInfo.class).getCustLName()); //set & get the name
            cInfo.setCustNumber(ds.child(userID).getValue(customerInfo.class).getCustNumber()); //set & get the name
            cInfo.setCustAddress(ds.child(userID).getValue(customerInfo.class).getCustAddress()); //set & get the address

            Log.d(TAG, "showData: Name: " + cInfo.getCustFName() + " " + cInfo.getCustLName());
            Log.d(TAG, "showData: Number: " + cInfo.getCustNumber());
            Log.d(TAG, "showData: Address: " + cInfo.getCustAddress());


            ArrayList<String> array = new ArrayList<>();
            array.add(cInfo.getCustFName());
            array.add(cInfo.getCustLName());
            array.add(cInfo.getCustNumber());
            array.add(cInfo.getCustAddress());
            ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,array);
            cListView.setAdapter(adapter);


        }
    }


    //On Click command to bring up matches details
    public void btnMoverMatch(View view){
        Intent intent = new Intent(this, CustomerDisplayedDetails.class);
        startActivity(intent);

    }
}
