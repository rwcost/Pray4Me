package com.example.pray4me;

import static com.example.pray4me.R.id.btnLogin1;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements OnClickListener {
//public class MainActivity extends AppCompatActivity {
    Button mybutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.opening_main);
        mybutton = (Button) findViewById(btnLogin1);
        mybutton.setOnClickListener(this);
    }

    // method to process the above listener for the button
    public void onClick(View v){
        switch (v.getId()){
            case btnLogin1:
                Intent i=new Intent(MainActivity.this, LogonJava.class);
                startActivity(i);
        }
    }


}