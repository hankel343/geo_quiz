package com.example.geoquizfrontend.services;

import android.content.Context;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.geoquizfrontend.models.GameData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;

public class CountryService {
    private static final String COUNTRY_URL = "http://coms-309-012.class.las.iastate.edu:8080/countries";
    private final RequestQueue requestQueue;

    private final String[] countryNames = new String[243];

    public CountryService(Context context) {
        requestQueue = Volley.newRequestQueue(context);
    }

    public void getData(Response.Listener<JSONArray> listener, Response.ErrorListener errorListener) {
        String url = COUNTRY_URL + "/gameDataAll";
        JsonArrayRequest req = new JsonArrayRequest(Request.Method.GET, url, null, listener, errorListener);

        // Add the request to the queue and execute it
        requestQueue.add(req);
    }

    public String[] getCountryNames() {
        String url = COUNTRY_URL + "/testCommon";

        JsonArrayRequest req = new JsonArrayRequest(Request.Method.GET, url, null,
                response -> {
                    try {
                        JSONArray jsonArray = response;
                        for (int i = 0; i < jsonArray.length(); i++) {
                            countryNames[i] = jsonArray.getString(i);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace(); // Handle JSON parsing error
                    }
                },
                error -> {
                    error.printStackTrace(); // Handle network error
                }
        );

        requestQueue.add(req);

        // You may want to wait for the network request to complete here
        // before returning the country names, which may require using callbacks
        // or other mechanisms to ensure the data is available.

        return countryNames;
    }

    public List<GameData> parseGameDataResponse(JSONArray response) {
        List<GameData> gameDataList = new ArrayList<>();

        try {
            for (int i = 0; i < response.length(); i++) {
                JSONObject dataObject = response.getJSONObject(i);
                String name = dataObject.getString("name");
                String capital = dataObject.getString("capital");
                String flag = dataObject.getString("flag");
                String continent = dataObject.getString("continent");
                int population = dataObject.getInt("population");

                GameData gameData = new GameData(name, capital, flag, continent, population);
                gameDataList.add(gameData);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return gameDataList;
    }
}
