package com.example.pray4me;

import static com.example.pray4me.R.id.btnLogin1;
import static com.example.pray4me.R.id.btnGuest;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.content.Intent;
import android.os.Bundle;
/*
The MainActivity is where the program starts running.
 */
public class MainActivity extends AppCompatActivity implements OnClickListener {
    Button loginButton;
    Button guestButton;
    /*
    This onCreate method will be called when this activity is called.
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.opening_main);
        loginButton = (Button) findViewById(btnLogin1);
        loginButton.setOnClickListener(this);
        guestButton = (Button) findViewById(btnGuest);
        guestButton.setOnClickListener(this);
    }
    // method to process the above listener for the button
    public void onClick(View v){
        switch (v.getId()){
            case btnLogin1:// if the login button was pressed
                Intent i=new Intent(MainActivity.this, LogonJava.class);
                startActivity(i);
            case btnGuest:// if the guest button was pressed
                Intent j=new Intent(MainActivity.this, MenuJava.class);
                startActivity(j);
        }
    }
}