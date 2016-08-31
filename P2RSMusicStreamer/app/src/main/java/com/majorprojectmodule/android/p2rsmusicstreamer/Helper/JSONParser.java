package com.majorprojectmodule.android.p2rsmusicstreamer.Helper;

import com.majorprojectmodule.android.p2rsmusicstreamer.entity.Track;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gandoff on 7/16/16.
 */
public class JSONParser {

    private final String LOG_TAG = JSONParser.class.getSimpleName();

    public List<Track> getTrackDetails(String json) throws JSONException {

        JSONArray tracks = new JSONArray(json);

        List<Track> trackList = new ArrayList<>();

        for (int i =0;i < tracks.length() ;i++){

            Track tr = new Track();

            JSONObject trackJson = tracks.getJSONObject(i);

            tr.setId(trackJson.getInt("trackId"));

            tr.setTitle(trackJson.getString("trackTitle"));

            tr.setArtworkURL(trackJson.getString("albumArtURL"));

            tr.setStreamURL((trackJson.getString("streamURL") + trackJson.getString("trackSource")).replace(" ","%20"));

            trackList.add(tr);
        }

        return trackList;

    }


}
