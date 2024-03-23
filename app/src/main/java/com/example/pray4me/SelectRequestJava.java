package com.example.pray4me;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.pray4me.R.id.btnPrayForAll;
import static com.example.pray4me.R.id.btnRandomRequest;
import static com.example.pray4me.R.id.btnPrayByZipcode;
import static com.example.pray4me.R.id.btnPrayByZipcodeCont;

public class SelectRequestJava extends AppCompatActivity implements View.OnClickListener{

    String menuJavaUserID = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_request_xml);

        Bundle extras = getIntent().getExtras();
        menuJavaUserID = extras.getString("key");

//        TextView txtScroll = (TextView) findViewById(R.id.txt1);
//        txtScroll.setMovementMethod(new ScrollingMovementMethod());

        //create java buttons and link them to the screen buttons
        Button btnAll = findViewById(R.id.btnPrayForAll);
        btnAll.setOnClickListener(this);

        //create java buttons and link them to the screen buttons
        Button btnRandom = findViewById(R.id.btnRandomRequest);
        btnRandom.setOnClickListener(this);

        //create java buttons and link them to the screen buttons
        Button btnZipcode = findViewById(R.id.btnPrayByZipcode);
        btnZipcode.setOnClickListener(this);

        //create java buttons and link them to the screen buttons
        Button btnZipcodeCont = findViewById(R.id.btnPrayByZipcodeCont);
        btnZipcodeCont.setOnClickListener(this);

        // This will reference the zipcode textview so the user can
        TextView txtVision = (TextView) findViewById(R.id.txtZipcode);
        txtVision.setVisibility(View.INVISIBLE);

    }
    // do the actions for the button clicks
    @SuppressLint("NonConstantResourceId")
    @Override
    // this view or "v" is the this view and case select the correct button that got pressed
    public void onClick(View v) {
        switch (v.getId()){
            // this is the random prayer request button
            case btnRandomRequest:

            // the next two lines will switch to the page PrayRequestJava class and its screen page
            Intent i = new Intent(SelectRequestJava.this, PrayRequestJava.class);
            i.putExtra("key",menuJavaUserID);
            startActivity(i);

            case btnPrayForAll:
                Intent j = new Intent(SelectRequestJava.this, PrayRequestJava.class);
                j.putExtra("key",menuJavaUserID);
                startActivity(j);

            case btnPrayByZipcode:

                // this is the place where you enter your zipcode
                EditText myView = findViewById(R.id.txtZipcode);
                myView.setVisibility(View.VISIBLE);

            case btnPrayByZipcodeCont:
                /*
                Create a request to get data from the web API,
                Create a new TextView to send to the request class so it can put the data
                received from the mssql database.  I had to send the view to the request because
                the request catches the request with data as well.
                */

                //Connecting the new TextView object with the XML that defines the textView on the screen

                // this is the place where you enter your zipcode
                TextView resultView = findViewById(R.id.tvRequestReturned);

                /*
                Create a new class to get the data from the SQlServer database
                 */
                APIExchange myExchange = new APIExchange();
                /*
                Use the newly created class to send the query to the database.  the "myView" TextView
                is sent to the class so it can fill in the textView with data returned from the database.
                 */

                myView = findViewById(R.id.txtZipcode);
                String zipcode = myView.getText().toString();

                if (!zipcode.equals(""))
                {
                    String queryToProcess = "SELECT dbo.request.request from dbo.users " +
                            "INNER JOIN dbo.request ON dbo.users.userid = dbo.request.userid " +
                            "WHERE (dbo.users.zipcode LIKE '" + zipcode + "')";
                    myExchange.GetDataFromAPI(this,queryToProcess,resultView);
                }
                else
                {
                    // setup the alert builder
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("Zip Code Request");
                    builder.setMessage("Please enter a zip code for prayer request");

                    // add a button
                    builder.setPositiveButton("OK", null);

                    // create and show the alert dialog
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }

        }
    }
}