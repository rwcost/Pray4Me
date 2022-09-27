package com.example.pray4me;

import static com.example.pray4me.R.id.btnBack;
import static com.example.pray4me.R.id.btnSummaryClear;
import static com.example.pray4me.R.id.btnSend;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class PrayRequestMainActivity5 extends AppCompatActivity implements View.OnClickListener {

    EditText summary;
    ArrayList<Editable> myArrayList = new ArrayList<Editable>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pray_request_main5);
        summary = (EditText) findViewById(R.id.mlvRequestSummary);
        myArrayList = (ArrayList<Editable>) Model.instance().getPrayerRequestList();

        // set up a button and point it to a xml button
        Button sendbutton = findViewById(btnSend);
        sendbutton.setOnClickListener(this);

        // set up a button and point it to a xml button
        Button backbutton = findViewById(btnBack);
        backbutton.setOnClickListener(this);

        // set up a button and point it to a xml button
        Button clearbutton = findViewById(btnSummaryClear);
        clearbutton.setOnClickListener(this);

        // make a new textview to represent the xml one
        EditText summary = (EditText) findViewById(R.id.mlvRequestSummary);
        String lineSep = System.getProperty("line.separator");
        ArrayList<Editable> myArrayList = (ArrayList<Editable>) Model.instance().getPrayerRequestList();

        for (int i = 0; i <= myArrayList.size() - 1; i++) {
            summary.append(myArrayList.get(i));
            summary.append(lineSep);
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case btnSummaryClear:
                // clear the multiline textview
                summary.setText("");
                //clear the arraylist
                myArrayList.clear();
                break;
        }
    }
}