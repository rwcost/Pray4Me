package com.example.pray4me;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import static com.example.pray4me.R.id.btnSelectToPray;
import static com.example.pray4me.R.id.btnPrayForAll;
import static com.example.pray4me.R.id.btnRandomRequest;
import static com.example.pray4me.R.id.btnPrayByZipcode;

public class SelectRequestJava extends AppCompatActivity implements View.OnClickListener{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_request_xml);
//        TextView txtScroll = (TextView) findViewById(R.id.txt1);
//        txtScroll.setMovementMethod(new ScrollingMovementMethod());

        Button btnAll = findViewById(R.id.btnPrayForAll);
        btnAll.setOnClickListener(this);

        Button btnRandom = findViewById(R.id.btnRandomRequest);
        btnRandom.setOnClickListener(this);

        Button btnZipcode = findViewById(R.id.btnPrayByZipcode);
        btnZipcode.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case btnRandomRequest:

            Intent i = new Intent(SelectRequestJava.this, PrayRequestJava.class);
            startActivity(i);

            case btnPrayForAll:
                Intent j = new Intent(SelectRequestJava.this, PrayRequestJava.class);
                startActivity(j);

            case btnPrayByZipcode:
/*
                Create a request to get data from the web API,
                Create a new TextView to send to the request class so it can put the data
                received from the mssql database.  I had to send the view to the request because
                the request catches the request with data as well.
                */
                TextView myView;
                //Connecting the new TextView object with the XML that defines the textView on the screen
                myView = (TextView) findViewById(R.id.tvRequestReturned);

                /*
                Create a new class to get the data from the mssql database
                 */
                APIExchange myExchange = new APIExchange();
                /*
                Use the newly created class to send the query to the database.  the "myView" TextView
                is sent to the class so it can fill in the textView with data returned from the database.
                 */
                myExchange.GetDataFromAPI(this,"request_by_zipcode",myView);

        }
    }
}