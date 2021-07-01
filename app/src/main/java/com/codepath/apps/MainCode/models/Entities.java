package com.codepath.apps.MainCode.models;

import android.util.Log;
import android.widget.ImageView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

@Parcel
public class Entities {

    public String imageUrl;
    public String heightImage;
    private static final String TAG = "EMBEDDED_IMAGE";

    public Entities() {}

    public static Entities fromJson(JSONObject jsonObject) throws JSONException {
        Entities entities = new Entities();
        try {
            JSONArray mediaArray = jsonObject.getJSONArray("media");
            JSONObject media = mediaArray.getJSONObject(0);
            entities.imageUrl = media.getString("media_url_https");
            //JSONObject sizes = media.getJSONObject(0).getJSONObject("sizes");
            //entities.heightImage = sizes.getJSONObject("small").getString("h");
            Log.i(TAG, media.toString());
        } catch (JSONException e) {
            Log.e(TAG, "There was no image to get", e);
        }
        return entities;
    }
}
