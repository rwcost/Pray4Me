package com.example.pray4me;

import static com.example.pray4me.R.id.btnAdd;
import static com.example.pray4me.R.id.btnSummaryClear;
import static com.example.pray4me.R.id.btnSend;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class PrayRequestJava extends AppCompatActivity implements View.OnClickListener {

    EditText summary;
    ArrayList<Editable> myArrayList = new ArrayList<Editable>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pray_request_list);
        summary = (EditText) findViewById(R.id.mlvRequestSummary);
        myArrayList = (ArrayList<Editable>) Model.instance().getPrayerRequestList();

        // set up a button and point it to a xml button
        Button sendbutton = findViewById(btnSend);
        sendbutton.setOnClickListener(this);

        // set up a button and point it to a xml button
        Button addButton = findViewById(btnAdd);
        addButton.setOnClickListener(this);

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
        switch (v.getId())
        {
            case btnSummaryClear:
                // clear the multiline textview
                summary.setText("");
                //clear the arraylist
                myArrayList.clear();
                break;
            case btnAdd:
                // go to the pray request page and add another request
                Intent kk = new Intent(PrayRequestJava.this, SelectionsJava.class);
                startActivity(kk);
            case btnSend:

                APIExchange myExchange = new APIExchange();

                try {
                    myExchange.postDataUsingVolleyBody("Joe","Dirt",this);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

                //myExchange.GetDataFromAPI(this,"1");

//                StringBuilder responseString = new StringBuilder();
//
//                JSONArray responseArray = new JSONArray();
//
//                APIData myAPI = new APIData();
//
//                responseArray = myAPI.GetDataFromAPI(this);
//
//                for(int i = 0; i < responseArray.length() - 1;i++)
//            {
//                try {
//                    responseString.append((responseArray.getJSONObject(i).getString("summary")));
//                    responseString.append(" ; ");
//                } catch (JSONException e) {
//                    throw new RuntimeException(e);
//                }
//            }

                String test = "";

//                // send requests to api
//                //write your code to send request to the api
//// Instantiate the RequestQueue.
//                ////final TextView textView = (TextView) findViewById(R.id.text);
//                //String myUrl = "http://run.mocky.io/v3/81915be5-ea63-45b2-b29f-2d43494a335d";
//                String myUrl = "http://10.0.2.2:5069/WeatherForecast";
//                //String myUrl = "https://www.7timer.info/bin/astro.php?lon=113.2&lat=23.1&ac=0&unit=metric&output=json&tzshift=0";
//                StringRequest myRequest = new StringRequest(Request.Method.GET, myUrl,
//                        response -> {
//                            try {
//                                //Create a JSON object containing information from the API.
//                                JSONArray myJsonObject = new JSONArray(response);
//
//                                } catch (JSONException e) {
//                                e.printStackTrace();
//                            }
//                        },
//                        volleyError -> Toast.makeText(PrayRequestJava.this, volleyError.getMessage(), Toast.LENGTH_SHORT).show()
//                );
//                RequestQueue requestQueue = Volley.newRequestQueue(this);
//                requestQueue.add(myRequest);
        }
    }
}
