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
import java.util.List;

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
                break;
            case btnSend:
                /*
                    This is a class in which all the Web API code is accessed
                    insert into dbo.request (userid,request,priority,type) values ('4','hello','1','1');
                 */

            // create a json object for the array body

                JSONArray myJsonArray = new JSONArray();

            for(int i=0;i<myArrayList.size();i++) {
                try {
                    // add the prayer request list using an index ("i") as a object name
                    JSONObject myJSONBody = new JSONObject();
                    myJSONBody.put(Integer.toString(i), myArrayList.get(i).toString());
                    myJsonArray.put(myJSONBody);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }

                //JSONArray myJsonArray = new JSONArray();

                //myJsonArray.put(myJSONBody);

                JSONObject mainObj = new JSONObject();

                try {
                       mainObj.put("requestList", myJsonArray);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

//                try {
//                    myJSONBody.put("requestList", myArrayList.toString());
//                } catch (JSONException e) {
//                    throw new RuntimeException(e);
//                }

//            for(int i=0;i<myArrayList.size();i++)
//            {
//                try {
//                    myJSONBody.put("json",myArrayList.get(i));
//                } catch (JSONException e) {
//                    throw new RuntimeException(e);
//                }
//            }

            APIExchange myExchange = new APIExchange();

                try {
                    myExchange.postDataUsingVolleyBody(mainObj,"PrayerRequestJava",this);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

                //myExchange.postDataUsingVolleyBody();

                /*
                Create a request to get data from the web API,
                The data back from the request is saved using the SaveDataHere.
                */
                String sql = "insert into dbo.request (userid,request,priority,type) values ('4','hello','1','1'); ";
                //myExchange.GetDataFromAPI(this,"request_by_zipcode",summary);

                //ToDo : Put in query to save the prayer request

        }
    }
}
