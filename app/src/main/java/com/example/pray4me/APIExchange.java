package com.example.pray4me;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class APIExchange {

    APIExchange(){

    }
    /*
    This method will Post data (send from phone to web) and Get data
    the information will be passed to this method.  Then the information
    is put in the request, then put in queue, then sent to the web.
     */
    public void postDataUsingVolley(String name, String job, Context context) {
        // url to post our data
        //String url = "https://reqres.in/api/users";
        String url = "http://10.0.2.2:5215/api/Users/dddd";

        //loadingPB.setVisibility(View.VISIBLE);

        // creating a new variable for our request queue
        RequestQueue queue = Volley.newRequestQueue(context);

        // on below line we are calling a string
        // request method to post the data to our API
        // in this we are calling a post method.
        StringRequest request = new StringRequest(Request.Method.POST, url, new com.android.volley.Response.Listener<String>()
        {
            @Override
            public void onResponse(String response)
            {
                // inside on response method we are
                // hiding our progress bar
                // and setting data to edit text as empty
                //loadingPB.setVisibility(View.GONE);
                //nameEdt.setText("");
                //jobEdt.setText("");

                // on below line we are displaying a success toast message.
                //Toast.makeText(MainActivity.this, "Data added to API", Toast.LENGTH_SHORT).show();
                try {
                    // on below line we are parsing the response
                    // to json object to extract data from it.
                    JSONObject respObj = new JSONObject(response);

                    // below are the strings which we
                    // extract from our json object.
                    //String requester = respObj.getString("requester1");
                    //String request = respObj.getString("Pray for me");

                    // on below line we are setting this string s to our text view.
                    //responseTV.setText("Name : " + name + "\n" + "Job : " + job);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new com.android.volley.Response.ErrorListener()
            {
            @Override
            public void onErrorResponse(VolleyError error)
                {
                // method to handle errors.
                //Toast.makeText(MainActivity.this, "Fail to get response = " + error, Toast.LENGTH_SHORT).show();
                }
            })
//        {
////
//            protected String myData()
//            {
//                return "HelloThere";
//            }
////            @Override
////            protected Map<String, String> getParams()
////            {
////                String mydata = "helloThere";
////                // below line we are creating a map for
////                // storing our values in key and value pair.
////                Map<String, String> params = new HashMap<String, String>();
////
////                // on below line we are passing our key
////                // and value pair to our parameters.
////                params.put("name", "requester1");
////                params.put("request", "Pray for me");
////
////                // at last we are
////                // returning our params.
////                return params;
////               }
        //}
        ;
        // below line is to make
        // a json object request.
        queue.add(request);
    }
    /*
     This method will get data from the web, we send a web request with the id passed below,
     then the data returned fro the web wil be put in a JSONArray
     */
    public JSONArray GetDataFromAPI(Context context,String id) {
        AtomicReference<JSONArray> responseArray = new AtomicReference<>(new JSONArray());
        // Instantiate the RequestQueue.
        // Online test API's
        //String myUrl = "http://run.mocky.io/v3/81915be5-ea63-45b2-b29f-2d43494a335d";
        //String myUrl = "https://www.7timer.info/bin/astro.php?lon=113.2&lat=23.1&ac=0&unit=metric&output=json&tzshift=0";
        // Instantiate the RequestQueue.
        //connection string to PrayForMe API
        String myUrl = "http://10.0.2.2:5069/WeatherForecast";
        AtomicReference<String> errorMessage = new AtomicReference<>("");
        StringRequest myRequest = new StringRequest(Request.Method.GET, myUrl,
                response ->
                {
                    try {
                        //Create a JSON object containing information from the API.
                        JSONArray myJsonArray = new JSONArray(response);
                        responseArray.set(myJsonArray);

                        //summary.setText("");

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                volleyError -> errorMessage.set(volleyError.getMessage())

        );
        RequestQueue requestQueue = Volley.newRequestQueue(context);

        requestQueue.add(myRequest);

        return responseArray.get();
    }

    public void postDataUsingVolleyBody(String name, String job, Context context) throws JSONException {
        // url to post our data
        //String url = "https://reqres.in/api/users";
        String url = "http://10.0.2.2:5215/api/Users/create";

        //loadingPB.setVisibility(View.VISIBLE);

        // creating a new variable for our request queue
        RequestQueue queue = Volley.newRequestQueue(context);
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("fname", "Bob");
        jsonBody.put("lname", "Jones");
        jsonBody.put("address1", "231 River Road");
        jsonBody.put("address2", "suite");
        jsonBody.put("city", "Dayton");
        jsonBody.put("state", "Ohio");
        jsonBody.put("country", "USA");
        jsonBody.put("zipcode", "45454");
        jsonBody.put("phone", "543-222-2222");
        jsonBody.put("contacttype", "requester");
        jsonBody.put("status", "good");
        jsonBody.put("userID", "1");
        jsonBody.put("guestID", "na");


        final String mRequestBody = jsonBody.toString();
        // on below line we are calling a string
        // request method to post the data to our API
        // in this we are calling a post method.
        StringRequest request = new StringRequest(Request.Method.POST, url, new com.android.volley.Response.Listener<String>()
        {
            @Override
            public void onResponse(String response)
            {
                // inside on response method we are
                // hiding our progress bar
                // and setting data to edit text as empty
                //loadingPB.setVisibility(View.GONE);
                //nameEdt.setText("");
                //jobEdt.setText("");

                // on below line we are displaying a success toast message.
                //Toast.makeText(MainActivity.this, "Data added to API", Toast.LENGTH_SHORT).show();
                try {
                    // on below line we are parsing the response
                    // to json object to extract data from it.
                    JSONObject respObj = new JSONObject(response);

                    // below are the strings which we
                    // extract from our json object.
                    //String requester = respObj.getString("requester1");
                    //String request = respObj.getString("Pray for me");

                    // on below line we are setting this string s to our text view.
                    //responseTV.setText("Name : " + name + "\n" + "Job : " + job);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new com.android.volley.Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                // method to handle errors.
                //Toast.makeText(MainActivity.this, "Fail to get response = " + error, Toast.LENGTH_SHORT).show();
            }
        })		{
            @Override
            public String getBodyContentType()
            {
                return "application/json; charset=utf-8";
            }

            @Override
            public byte[] getBody() throws AuthFailureError
            {
                try
                {
                    return mRequestBody == null ? null : mRequestBody.getBytes("utf-8");
                } catch (UnsupportedEncodingException uee)
                {
                    VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", mRequestBody, "utf-8");
                    return null;
                }
            }

            @Override
            protected Response<String> parseNetworkResponse(NetworkResponse response)
            {
                String responseString = "";
                if (response != null)
                {
                    responseString = String.valueOf(response.statusCode);
                }
                return Response.success(responseString, HttpHeaderParser.parseCacheHeaders(response));
            }
        };
        // below line is to make
        // a json object request.
        queue.add(request);
    }



}
