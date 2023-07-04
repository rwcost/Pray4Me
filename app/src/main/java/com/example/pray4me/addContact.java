package com.example.pray4me;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class addContact extends AppCompatActivity  implements View.OnClickListener,AdapterView.OnItemSelectedListener {
    // create array of Strings
    // and store name of courses
    String[] usertypes= { "requester", "prayer",
            "admin", "resource"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        //create a button and associate it with the xml button on the screen
        Button btnContactDone;
        btnContactDone = findViewById(R.id.btnContactDone);

        // add a listener so the program will go to the onclick method when the button is clicked
        btnContactDone.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {
        Spinner username = findViewById(R.id.spinner);
        Object listener = null;
        username.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

        // Create the instance of ArrayAdapter
        // having the list of courses
        ArrayAdapter ad
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                usertypes);

        // set simple layout resource file
        // for each item of spinner
        ad.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);

        // Set the ArrayAdapter (ad) data on the
        // Spinner which binds data to spinner
        username.setAdapter(ad);



//        EditText fname = findViewById(R.id.et_firstname);
//        EditText lname = findViewById(R.id.et_firstname);
//        EditText add1 = findViewById(R.id.et_firstname);
//        EditText add2 = findViewById(R.id.et_firstname);
//        EditText city = findViewById(R.id.et_firstname);
//        EditText state = findViewById(R.id.et_firstname);
//        EditText zipcode = findViewById(R.id.et_firstname);
//        EditText phone = findViewById(R.id.et_firstname);
//        EditText status = findViewById(R.id.et_firstname);
//        EditText sex = findViewById(R.id.et_firstname);



        //String test = fname.getEditableText().toString();

        JSONObject jsonBody = new JSONObject();
        try {
            jsonBody.put("fname", "Bob");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        // make toastof name of course
        // which is selected in spinner
        Toast.makeText(getApplicationContext(),
                        usertypes[position],
                        Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}