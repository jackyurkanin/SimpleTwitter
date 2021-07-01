package com.codepath.apps.MainCode.models;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

@Parcel
public class Entities {

    public String imageUrl;
    private static final String TAG = "EMBEDDED_IMAGE";

    public Entities() {}

    public static Entities fromJson(JSONObject jsonObject) throws JSONException {
        Entities entities = new Entities();
        try {
            JSONArray media = jsonObject.getJSONArray("media");
            entities.imageUrl = String.valueOf(media.getJSONObject(0).getString("media_url_https"));
            Log.i(TAG, String.valueOf(media.getJSONObject(0)));
        } catch (JSONException e) {
            Log.e(TAG, "There was no image to get", e);
        }
        return entities;
    }
}
