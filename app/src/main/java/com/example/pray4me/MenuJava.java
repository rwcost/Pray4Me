package com.example.pray4me;

import static com.example.pray4me.R.id.prayRequestImageButton;
import static com.example.pray4me.R.id.chainButton;
import static com.example.pray4me.R.id.communityButton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MenuJava extends AppCompatActivity implements View.OnClickListener {
    String username = "";
    String password = "";



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_xml);
        ImageButton prayRequestbutton;
        ImageButton prayerChainButton;
        ImageButton communityResourceButton;

        prayRequestbutton = findViewById(prayRequestImageButton);
        prayRequestbutton.setOnClickListener(this);

        prayerChainButton = findViewById(chainButton);
        prayerChainButton.setOnClickListener(this);

        communityResourceButton = findViewById(communityButton);
        communityResourceButton.setOnClickListener(this);


        //create a sqlite local database on the android phone
        //SQLiteDatabase db;
        //db = openOrCreateDatabase("pray4medb",MODE_PRIVATE,null);
        //db.execSQL("CREATE TABLE IF NOT EXISTS user(Username VARCHAR,Password VARCHAR);");
        //db.execSQL("INSERT INTO user VALUES('rwcost788','br549');");

        //String query = "SELECT Password FROM user WHERE Username = ?";
        //String[] selectionArgs = {"rwcost788"};

        //Cursor resultSet = db.rawQuery(query,selectionArgs);
        //resultSet.moveToFirst();

        //password = resultSet.getString(0);

        Context context = getApplicationContext();

        Toast toast = Toast.makeText(context,password,Toast.LENGTH_LONG);
        toast.show();

//            final String createTableIfNeeded = "CREATE TABLE IF NOT EXISTS tbl_user_info ("
//                    + "ID INTEGER primary key AUTOINCREMENT,"
//                    + "date_time DATETIME,"
//                    + "username String,"
//                    + "zipcode String,"
//                    + "address1 String,"
//                    + "address2 String,"
//                    + "city String,"
//                    + "state String,"
//                    + "faith String,"
//                    + "age INT"
//                    + ");";

            // this is actual executing statement that creates a SQLite database if needed
 //           db.execSQL(createTableIfNeeded);

    }
    // method to process the above listener for the button
    public void onClick(View v){
        switch (v.getId()){
            case prayRequestImageButton:
                Intent i=new Intent(MenuJava.this, SelectionsJava.class);
                startActivity(i);
                break;
            case chainButton:
                Intent j =new Intent(MenuJava.this, PrayerChainJava.class);
                startActivity(j);
                break;
            case communityButton:
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