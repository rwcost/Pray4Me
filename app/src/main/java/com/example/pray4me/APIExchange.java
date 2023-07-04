package com.example.pray4me;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
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
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/*
This class wi used to send and receive data to the SQL server
 */
public class APIExchange {

    APIExchange(){
        String responseString = "";
    }

    String responseString = "";
    final String[] responseString1 = {""};

    /*
     This method will get data from the web, we send a web request with the id passed below,
     then the data returned from the web will be put in a JSONArray
     */
    public void GetDataFromAPI(Context context, String queryToProcess, TextView myViewIn) {
        /*
            This address of the web API
        */
        String URL = "http://10.0.2.2:5215/api/Users/" + queryToProcess;

        /*
        This creates a queue to hold the requests and send them to Azure to request prayer request is ready
         */
        RequestQueue queue;
        /*
            Sets up the queue
         */
        queue = Volley.newRequestQueue(context);
        /*
            This is the code that creates a request for data from the Web API
            Notice the 'GET' in the parameters this means to 'get data' from
            wht web API.
         */
        StringRequest request = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            /*
                This is the section referenced above called the Response.Listener<java.lang.String> listener.
                It will actually run when a response comes back from the web API.  Just look at the commas
                for separation.
                Here is an example of the JSON object returned from Azure:
                 {"operations":["I have a need","I am bored"]}
            */
            @Override
            public void onResponse(String response)
            {
                try {
                    String resultCombo = "";

                    // put the response from the request to azure in a Json object
                    JSONObject obj = new JSONObject(response.toString());

                    // create a JSON array for the JSON object operations
                    JSONArray arr = obj.getJSONArray("operations");

                    // get the strings in the array and combine into resultCombo string
                    for (int i = 0; i < arr.length(); i++) {
                        resultCombo = resultCombo + arr.getString(i) + System.getProperty("line.separator");
                    }
                    // add the results strings into the screen view passed into this method
                    myViewIn.setText(resultCombo);

                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Log.d("error",error.toString());
            }
        });
        queue.add(request);
    }

//  ********************************** Post JSON body to the database below **********************************************
    /*
        //    This function will send a JSON Object to the web api.  This is an example of the data being in JSON format
        //    This is JSON format (JSON Object)
        //              {
            //            "fname" : "Bob",
            //             "lname" : "Jones",
            //             "address1" : "231 Riverroad",
            //             "address2" : "Suite 578",
            //             "city" : "Dayton",
            //             "state" : "Ohio",
            //             "country" : "USA",
            //             "zipcode" : "45454",
            //             "phone" : "543-222-2222",
            //             "contacttype" : "requester" ,
            //             "status" : "good",
            //             "userID" : "1",
            //             "guestID" : "na"
            //           }

    This method will Post send data from the phone to web API (Application Programming Interface)
    the information will be passed to this method.  Then the information
    is put in the request, then put in queue, then sent to the web.  This will store the user
    information to a database on a remote server via the web.
     */
    public void postDataUsingVolleyBody(String name, String job, Context context) throws JSONException {
        // url to post our data
        String url = "http://10.0.2.2:5215/api/Users/create";

        //loadingPB.setVisibility(View.VISIBLE);

        /*
         This section of code creates a test JSON object to send to the API
         */
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

        /*
        JSON does have a formatting style, but it is still just a string.
         */
        final String mRequestBody = jsonBody.toString();
        /*
        This section of code is using the volley library to send data to a remote API
        public StringRequest(java.lang.String url,
                     Response.Listener<java.lang.String> listener,
                     @Nullable
                     Response.ErrorListener errorListener)
         */
        StringRequest request = new StringRequest(Request.Method.POST, url, new com.android.volley.Response.Listener<String>()
        {
            /*
            This is the section referenced above called the Response.Listener<java.lang.String> listener.
            It will actually run when a response comes back from the web API.  Just look at the commas
            for separation.
             */
            @Override
            public void onResponse(String response)
            {
                //Toast.makeText(MainActivity.this, "Data added to API", Toast.LENGTH_SHORT).show();
                try { //Try is used to catch errors in the try area and send them to the catch
                    /*
                        This will put the data sent back from the request into the variable 'respObj'
                     */
                    JSONObject respObj = new JSONObject(response);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new com.android.volley.Response.ErrorListener()
        {
            /*
            This area is different from the try/catch because this is an error that is from the
            remote Web API
             */
            @Override
            public void onErrorResponse(VolleyError error)
            {
                // method to handle errors.
                //Toast.makeText(MainActivity.this, "Fail to get response = " + error, Toast.LENGTH_SHORT).show();
            }
        })		{
            /*
                This section will set up the formatting type for the JSON Body
             */
            @Override
            public String getBodyContentType()
            {
                return "application/json; charset=utf-8";
            }

           /*
                This
            */
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
        /*
            This will add the above into a "queue" system to send them when the system
            is ready to send them.
         */
        queue.add(request);
    }

}
