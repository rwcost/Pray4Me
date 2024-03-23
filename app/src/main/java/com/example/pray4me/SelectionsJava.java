package com.example.pray4me;


import static com.example.pray4me.R.id.btnSelectToPray;
import static com.example.pray4me.R.id.btnclear;
import static com.example.pray4me.R.id.btnAddRequest;
import static com.example.pray4me.R.id.donebutton;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;


import java.util.ArrayList;

public class SelectionsJava extends AppCompatActivity implements View.OnClickListener {

    Editable prayerRequest;
    String menuJavaUserID = "";


    /*
    This method is called when opening the activity on the phone
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // This is where the userid is passed from the last activity (screen)
        Bundle extras = getIntent().getExtras();
        menuJavaUserID=extras.getString("key");

        // this mates this java code to the xml for the screen design
        setContentView(R.layout.selections_xml);

        //this is the button to
        Button selectbutton = findViewById(btnSelectToPray);
        selectbutton.setOnClickListener(this);

        Button submitbutton = findViewById(btnAddRequest);
        submitbutton.setOnClickListener(this);

        Button clearbutton = findViewById(btnclear);
        clearbutton.setOnClickListener(this);

        Button donebutton = findViewById(R.id.donebutton);
        donebutton.setOnClickListener(this);

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    @Override
    public void onClick(View v) {
        // make a new textview to represent the xml one
        EditText requestcontents = (EditText) findViewById(R.id.request);
        //receiving activity
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            menuJavaUserID = extras.getString("key");
            //The key argument here must match that used in the other activity
        }

            String resource;
        switch (v.getId()){

            case btnclear:
                //set the text for the request box
                requestcontents.setText("");
                break;
            case btnAddRequest:
                // add the request text to an arraylist
                //prayerRequestList.add(requestcontents.getText());
                //requestcontents.setText("");
                Model.instance().setPrayerRequestList(requestcontents.getText());
                Intent kk=new Intent(SelectionsJava.this, PrayRequestJava.class);
                kk.putExtra("key",menuJavaUserID);
                startActivity(kk);
                break;
            case donebutton:
                // get the string for the text view
                //resource = getResources().getString(R.string.parent);
                //save the arraylist of prayer requests to the Model class (share data here)
                Model.instance().setPrayerRequestList(prayerRequest);
                Intent ii=new Intent(SelectionsJava.this, PrayRequestJava.class);
                ii.putExtra("key",menuJavaUserID);
                startActivity(ii);
                break;
            case btnSelectToPray:
                // this is the button to pray for a request
                Intent j =new Intent(SelectionsJava.this, SelectRequestJava.class);
                j.putExtra("key",menuJavaUserID);
                startActivity(j);

       }
    }
}