package com.example.geoquizfrontend.services;

import android.content.Context;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONObject;

public class CountryService {
    private static final String COUNTRY_URL = "http://coms-309-012.class.las.iastate.edu:8080/countries";
    private final RequestQueue requestQueue;

    public CountryService(Context context) {
        requestQueue = Volley.newRequestQueue(context);
    }

    public void getData(Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        String url = COUNTRY_URL + "/gameDataAll";
        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET, url, null, listener, errorListener);

        // Add the request to the queue and execute it
        requestQueue.add(req);
    }
}
