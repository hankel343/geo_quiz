package com.example.geoquizfrontend.services;

import android.content.Context;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.geoquizfrontend.models.GameData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CountryService {
    private static final String COUNTRY_URL = "http://coms-309-012.class.las.iastate.edu:8080/countries";
    private final RequestQueue requestQueue;

    public CountryService(Context context) {
        requestQueue = Volley.newRequestQueue(context);
    }

    public void getData(Response.Listener<JSONArray> listener, Response.ErrorListener errorListener) {
        String url = COUNTRY_URL + "/gameDataAll";
        JsonArrayRequest req = new JsonArrayRequest(Request.Method.GET, url, null, listener, errorListener);

        // Add the request to the queue and execute it
        requestQueue.add(req);
    }

    public List<GameData> parseGameDataResponse(JSONObject response) {
        List<GameData> gameDataList = new ArrayList<>();

        try {
            JSONArray jsonArray = response.getJSONArray("data"); // Assuming the JSON array is under a key called "data"

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject dataObject = jsonArray.getJSONObject(i);
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
