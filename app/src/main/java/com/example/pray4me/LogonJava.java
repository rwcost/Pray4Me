package com.example.pray4me;

import static com.example.pray4me.R.id.prayRequestImageButton;
import static com.example.pray4me.R.id.trouble;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
/*
This class is the opening screen which provides login options
 */
/*
This method will be called when the Activity is started
 */
public class LogonJava extends AppCompatActivity implements View.OnClickListener
{
    Button button;
    Button newuserButton;
    SaveDataHere saveDataHere = new SaveDataHere();

    //TextView pwd_status = findViewById(R.id.returnedValue);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.logon_xml);

        button = (Button) findViewById(R.id.Loginbutton);
        button.setOnClickListener(this);

        newuserButton = (Button) findViewById(R.id.buttonNewUser);
        newuserButton.setOnClickListener(this);

        //TextView pwd_status = findViewById(R.id.returnedValue);
    }

    public void setTxt(String retStatus)
    {
        TextView pwd_status = findViewById(R.id.returnedValue);
        pwd_status.setText(retStatus);
    }
            @Override
            public void onClick(View v)
            {
                switch (v.getId())
                {
                    case R.id.Loginbutton:

                        // this is the place where you enter your zipcode
                        TextView resultView = findViewById(R.id.returnedValue);
                        resultView.setText("");
                        TextView user1 = (TextView) findViewById(R.id.loginName);
                        String user2 = user1.getText().toString().trim();
                    /*
                    Creates the intent which will create an operation to be ran, in this case,
                    to open the Prayer request menu screen by opening the Java class.
                    */
                        APIExchange myExchange = new APIExchange();

                       String queryToProcess = "select password from users where username like '" + user2 + "'"     ;

                       String myResult = myExchange.GetDataFromAPI(this,queryToProcess,resultView);

                    break;
                   case R.id.buttonNewUser:
                        Intent k=new Intent(LogonJava.this, addContact.class);
                       startActivity(k);
                       break;
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

