package com.example.pray4me;

import static com.example.pray4me.R.id.addiction;
import static com.example.pray4me.R.id.btnclear;
import static com.example.pray4me.R.id.btnsubmit;
import static com.example.pray4me.R.id.cancer;
import static com.example.pray4me.R.id.chilld;
import static com.example.pray4me.R.id.depressed;
import static com.example.pray4me.R.id.donebutton;
import static com.example.pray4me.R.id.husband;
import static com.example.pray4me.R.id.job;
import static com.example.pray4me.R.id.lonely;
import static com.example.pray4me.R.id.dad;
import static com.example.pray4me.R.id.mother;
import static com.example.pray4me.R.id.wife;
import static com.example.pray4me.R.id.trouble;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;


import java.util.ArrayList;

public class PrayRequestMainActivity4 extends AppCompatActivity implements View.OnClickListener {

    ArrayList<Editable> prayerRequestList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pray_request_main4);

        Button submitbutton = findViewById(btnsubmit);
        submitbutton.setOnClickListener(this);

        Button clearbutton = findViewById(btnclear);
        clearbutton.setOnClickListener(this);

        Button donebutton = findViewById(R.id.donebutton);
        donebutton.setOnClickListener(this);

        TextView troubletrigger = findViewById(trouble);
        troubletrigger.setOnClickListener(this);

        TextView wifetrigger = findViewById(wife);
        wifetrigger.setOnClickListener(this);

        TextView mothertrigger = findViewById(mother);
        mothertrigger.setOnClickListener(this);

        TextView addictiontrigger = findViewById(addiction);
        addictiontrigger.setOnClickListener(this);

        TextView cancertrigger = findViewById(cancer);
        cancertrigger.setOnClickListener(this);

        TextView jobtrigger = findViewById(job);
        jobtrigger.setOnClickListener(this);

        TextView depressedtrigger = findViewById(depressed);
        depressedtrigger.setOnClickListener(this);

        TextView husbandtrigger = findViewById(husband);
        husbandtrigger.setOnClickListener(this);

        TextView lonelytrigger = findViewById(lonely);
        lonelytrigger.setOnClickListener(this);

        TextView chilldtrigger = findViewById(chilld);
        chilldtrigger.setOnClickListener(this);

        TextView dadtrigger = findViewById(dad);
        dadtrigger.setOnClickListener(this);

        //TextView tvTrouble = null;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    @Override
    public void onClick(View v) {
        // make a new textview to represent the xml one
        EditText requestcontents = (EditText) findViewById(R.id.request);
        String resource;
        switch (v.getId()){
            case R.id.trouble:
                // get the string for the text view
                resource = getResources().getString(R.string.trouble);
                //set the text for the request box
                requestcontents.setText(resource);
                break;
            case mother:
                // get the string for the text view
                resource = getResources().getString(R.string.momtext);
                //set the text for the request box
                requestcontents.setText(resource);
                break;
            case husband:
                // get the string for the text view
                resource = getResources().getString(R.string.husbandtext);
                //set the text for the request box
                requestcontents.setText(resource);
                break;
            case R.id.addiction:
                // get the string for the text view
                resource = getResources().getString(R.string.addiction);
                //set the text for the request box
                requestcontents.setText(resource);
                break;
            case R.id.cancer:
                // get the string for the text view
                resource = getResources().getString(R.string.cancer);
                //set the text for the request box
                requestcontents.setText(resource);
                break;
            case R.id.job:
                // get the string for the text view
                resource = getResources().getString(R.string.job);
                //set the text for the request box
                requestcontents.setText(resource);
                break;
            case R.id.depressed:
                // get the string for the text view
                resource = getResources().getString(R.string.depressed);
                //set the text for the request box
                requestcontents.setText(resource);
                break;
            case R.id.wife:
                // get the string for the text view
                resource = getResources().getString(R.string.wifetext);
                //set the text for the request box
                requestcontents.setText(resource);
                break;
            case R.id.lonely:
                // get the string for the text view
                resource = getResources().getString(R.string.lonely);
                //set the text for the request box
                requestcontents.setText(resource);
                break;
            case R.id.dad:
                // get the string for the text view
                resource = getResources().getString(R.string.dadtext);
                //set the text for the request box
                requestcontents.setText(resource);
                break;
            case R.id.chilld:
                // get the string for the text view
                resource = getResources().getString(R.string.child);
                //set the text for the request box
                requestcontents.setText(resource);
                break;
            case btnclear:
                //set the text for the request box
                requestcontents.setText("");
                break;
            case btnsubmit:
                // add the request text to an arraylist
                prayerRequestList.add(requestcontents.getText());
                requestcontents.setText("");
                break;
            case donebutton:
                // get the string for the text view
                //resource = getResources().getString(R.string.parent);
                //save the arraylist of prayer requests to the Model class (share data here)
                Model.instance().setPrayerRequestList(prayerRequestList);
                Intent i=new Intent(PrayRequestMainActivity4.this, PrayRequestMainActivity5.class);
                startActivity(i);
                break;

       }
    }
}