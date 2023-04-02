package com.example.pray4me;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.concurrent.atomic.AtomicReference;

public class APIData {

    public JSONArray GetDataFromAPI(Context context) {
        AtomicReference<JSONArray> responseArray = new AtomicReference<>(new JSONArray());
        // Instantiate the RequestQueue.
        // Online test API's
        //String myUrl = "http://run.mocky.io/v3/81915be5-ea63-45b2-b29f-2d43494a335d";
        //String myUrl = "https://www.7timer.info/bin/astro.php?lon=113.2&lat=23.1&ac=0&unit=metric&output=json&tzshift=0";
        // Instantiate the RequestQueue.
        //connection string to PrayForMe API
        String myUrl = "http://localhost:5069/WeatherForecast";
        AtomicReference<String> errorMessage = new AtomicReference<>("");


//        StringRequest myRequest = new StringRequest(Request.Method.GET, myUrl,
//                response ->
//                {
//                    try {
//                        //Create a JSON object containing information from the API.
//                        JSONArray myJsonArray = new JSONArray(response);
//                        responseArray.set(myJsonArray);
//
//
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                },
//                volleyError -> errorMessage.set(volleyError.getMessage())
//
//        );

        StringRequest myRequest = new StringRequest(Request.Method.GET, myUrl,
                response ->
                {
                   String Hello;
                },
                volleyError -> errorMessage.set(volleyError.getMessage())

        );

        RequestQueue requestQueue = Volley.newRequestQueue(context);

        requestQueue.add(myRequest);

        return responseArray.get();
    }
}
