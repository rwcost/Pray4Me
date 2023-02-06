package com.example.pray4me;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import static com.example.pray4me.R.id.btnSelectToPray;

public class SelectRequestJava extends AppCompatActivity implements View.OnClickListener{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_request_xml);
//        TextView txtScroll = (TextView) findViewById(R.id.txt1);
//        txtScroll.setMovementMethod(new ScrollingMovementMethod());

        Button btnSelect = findViewById(R.id.donebutton);
        btnSelect.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case btnSelectToPray:
            Intent i = new Intent(SelectRequestJava.this, PrayRequestJava.class);
            startActivity(i);
        }
    }
}