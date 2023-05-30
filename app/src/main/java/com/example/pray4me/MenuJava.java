package com.example.pray4me;

import static com.example.pray4me.R.id.prayRequestImageButton;
import static com.example.pray4me.R.id.prayForSomeoneButton;
import static com.example.pray4me.R.id.communityButton;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
/*
The MenuJava class is the main menu for the application,
allowing users to go to the Prayer Request, the prayChain or the community resource pages.
 */
public class MenuJava extends AppCompatActivity implements View.OnClickListener {
    String username = "";
    String password = "";
/*
This onCreate method will be called when this activity is called.
 */
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
        This setContentView is important since it sets the reference of the screen page to this java class.
         */
        setContentView(R.layout.menu_xml);

        /* This section will set up connect the screen buttons to Java buttons so the program
        knows when someone clicks on the screen button.  The function findViewById will link them.
         */
        ImageButton prayRequestButton; // create an ImageButton to reference from the Display page
        prayRequestButton = findViewById(prayRequestImageButton);// Links the screen button to the Java button
        prayRequestButton.setOnClickListener(this);// The onClick listener is a hardware process that waits for the mouse click

        ImageButton prayerForButton; // create an ImageButton to reference from the Display page
        prayerForButton = findViewById(prayForSomeoneButton);// Links the screen button to the Java button
        prayerForButton.setOnClickListener(this);// The onClick listener is a hardware process that waits for the mouse click

        ImageButton communityResourceButton; // create an ImageButton to reference from the Display page
        communityResourceButton = findViewById(communityButton);// Links the screen button to the Java button
        communityResourceButton.setOnClickListener(this);// The onClick listener is a hardware process that waits for the mouse click

        Context context = getApplicationContext();
        // This will display a message on the screen
        Toast toast = Toast.makeText(context,password,Toast.LENGTH_LONG);
        toast.show();

    }
    /*
    After you have linked the screen buttons to the newly created Java buttons and you have set the onclick listener,
    then this method will be called on a mouse click, then the case statement will determine which code gets ran.
     */
    public void onClick(View v){
        switch (v.getId()){
            case prayRequestImageButton:
                /*
                Creates the intent which will create an operation to be ran, in this case,
                to open the Prayer request menu screen by opening the Java class.
                */
                Intent i=new Intent(MenuJava.this, SelectionsJava.class);
                startActivity(i);
                break;
            case prayForSomeoneButton:
                /*
                Creates the intent which will create an operation to be ran, in this case,
                to open the Prayer Chain menu screen by opening the Java class.
                */
                Intent j =new Intent(MenuJava.this, SelectRequestJava.class);
                startActivity(j);
                break;
            case communityButton:
                /*
                Creates the intent which will create an operation to be ran, in this case,
                to open the community resource menu screen by opening the Java class.
                */
                Intent k =new Intent(MenuJava.this, ResourceJava.class);
                startActivity(k);
                break;
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}