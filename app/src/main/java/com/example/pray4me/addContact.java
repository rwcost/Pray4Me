package com.example.pray4me;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import org.json.JSONException;
import org.json.JSONObject;

public class addContact extends AppCompatActivity  implements View.OnClickListener,AdapterView.OnItemSelectedListener {
    // create array of Strings
    // and store name of courses
    String[] usertypes= { "requester", "prayer",
            "admin", "resource"};
    String contacttype = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_contact);

        //create a button and associate it with the xml button on the screen
        Button btnContactDone;
        btnContactDone = findViewById(R.id.btnContactDone);

        // add a listener so the program will go to the onclick method when the button is clicked
        btnContactDone.setOnClickListener(this);

        Spinner username = findViewById(R.id.spinner);
        Object listener = null;
        username.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

        // Create the instance of ArrayAdapter
        // having the list of courses
        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_spinner_item, usertypes);

        // set simple layout resource file
        // for each item of spinner
        ad.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);

        // Set the ArrayAdapter (ad) data on the
        // Spinner which binds data to spinner
        username.setAdapter(ad);

    }

    @Override
    public void onClick(View v)
    {

        JSONObject jsonBody = new JSONObject();
        try {
            EditText fname = findViewById(R.id.et_firstname);
            EditText lname = findViewById(R.id.et_lastname);
            EditText add1 = findViewById(R.id.et_address1);
            EditText add2 = findViewById(R.id.et_address2);
            EditText city = findViewById(R.id.et_city);
            EditText state = findViewById(R.id.et_state);
            EditText zipcode = findViewById(R.id.et_zipcode);
            EditText email = findViewById(R.id.et_email);

            jsonBody.put("fname", fname.getText());
            jsonBody.put("lname", lname.getText());
            jsonBody.put("address1", add1.getText());
            jsonBody.put("address2", add2.getText());
            jsonBody.put("city", city.getText());
            jsonBody.put("state", state.getText());
            jsonBody.put("country", "USA");
            jsonBody.put("zipcode", zipcode.getText());
            jsonBody.put("email", email.getText());
            jsonBody.put("contacttype", contacttype);
            jsonBody.put("status","calm");
            jsonBody.put("userid","br549");
            jsonBody.put("guestid","br549a");

            APIExchange api = new APIExchange();

            api.postDataUsingVolleyBody(jsonBody,"ok",this);

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        // make toastof name of course
        // which is selected in spinner
//        Toast.makeText(getApplicationContext(),
//                        usertypes[position],
//                        Toast.LENGTH_LONG)
//                .show();
        contacttype = usertypes[position];
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {

    }
    public void popUpMaker(String messageToDisplay)
    {
        Toast.makeText(getApplicationContext(),messageToDisplay,Toast.LENGTH_LONG).show();
    }
}