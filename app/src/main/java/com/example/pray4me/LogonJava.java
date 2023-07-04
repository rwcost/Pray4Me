package com.example.pray4me;

import static com.example.pray4me.R.id.prayRequestImageButton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
/*
This class is the opening screen which provides login options
 */
public class LogonJava extends AppCompatActivity implements View.OnClickListener
{
/*
This method will be called when the Activity is started
 */

    Button button;
    Button newuserButton;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.logon_xml);

        button = (Button) findViewById(R.id.Loginbutton);
        button.setOnClickListener(this);

        newuserButton = (Button) findViewById(R.id.buttonNewUser);
        newuserButton.setOnClickListener(this);


    }
            @Override
            public void onClick(View v)
            {
                switch (v.getId())
                {
                    case R.id.Loginbutton:
                    /*
                    Creates the intent which will create an operation to be ran, in this case,
                    to open the Prayer request menu screen by opening the Java class.
                    */
                    Intent i=new Intent(LogonJava.this, MenuJava.class);
                    startActivity(i);
                    button.setText("Button has been pressed");
                    TextView user = (TextView) findViewById(R.id.loginName);


                    user.toString().trim();

                    if(true)
                    {
                        //say login is ok
                        Snackbar mySnackbar = Snackbar.make(v, "login is ok", 2500);
                        mySnackbar.show();
                        Intent j =new Intent(LogonJava.this, MenuJava.class);
                        startActivity(j);
                    }
                    else
                    {
                        //say login is invalid
                        Snackbar mySnackbar = Snackbar.make(v, "login is invalid", 2500);
                        mySnackbar.show();
                    }
                    break;
                   case R.id.buttonNewUser:
                        Intent k=new Intent(LogonJava.this, addContact.class);
                       startActivity(k);
                }
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

