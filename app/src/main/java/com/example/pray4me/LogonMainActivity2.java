package com.example.pray4me;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class LogonMainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logon_main2);
        changeText();
    }
    public void changeText(){

        final Button button = (Button) findViewById(R.id.Loginbutton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                button.setText("Button has been pressed");

                TextView user = (TextView) findViewById(R.id.editTextTextPersonName2);
                TextView password = (TextView) findViewById(R.id.editTextTextPersonName3);

                user.toString().trim();

                //if(login(user.toString().trim(),password.toString().trim()))
                if(true)
                {
                    //say login is ok
                    Snackbar mySnackbar = Snackbar.make(view, "login is ok", 2500);
                    mySnackbar.show();
                    Intent i=new Intent(LogonMainActivity2.this, MenuMainActivity3.class);
                    startActivity(i);
                }
                else
                {
                    //say login is invalid
                    Snackbar mySnackbar = Snackbar.make(view, "login is invalid", 2500);
                    mySnackbar.show();
                }

//                Intent i=new Intent(MainActivity2.this, MainActivity3.class);
//                startActivity(i);
            }
        });

    }
    public boolean login(String username, String password){
        //do database lookup
        //open the database Pray4medb
        SQLiteDatabase db = openOrCreateDatabase("pray4medb",MODE_PRIVATE,null);

        //this is the sql string to get the password into to database lookup results
        String sql = "select password from user where Username = " + username;
        
        // You have to have a cursor to put the results into
        Cursor resultSet = db.rawQuery(sql,null);

        //move the cursor (pointer) to the first row in the results set
        resultSet.moveToFirst();

        // Get the text in the password column in the data base (first row)
        String passwordLookUp = resultSet.getString(1);

        if(password.equals(passwordLookUp)){
            return true;
        }
        else{
            return(false);
        }
    }


}

