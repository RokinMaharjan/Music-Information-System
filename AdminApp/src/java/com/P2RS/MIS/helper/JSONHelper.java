package com.P2RS.MIS.helper;

import com.P2RS.MIS.entity.Track;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONHelper {

    public static Track getTrackDetails(String json) throws JSONException {

        System.out.println("JOSN" + json);

        JSONObject resultantJson = new JSONObject(json);

        JSONObject results = resultantJson.getJSONObject("results");

        JSONObject trackMatches = results.getJSONObject("trackmatches");

        JSONArray tracks = trackMatches.getJSONArray("track");

        Track tr = new Track();

        JSONObject trackInfo = tracks.getJSONObject(0);

        tr.setArtist(trackInfo.getString("artist"));

        JSONArray images = trackInfo.getJSONArray("image");

        JSONObject image = images.getJSONObject(3);

        tr.setAlbumArtURL(image.getString("#text"));

        return tr;

    }

   

}
