package com.majorprojectmodule.android.p2rsmusicstreamer;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.majorprojectmodule.android.p2rsmusicstreamer.Helper.JSONParser;
import com.majorprojectmodule.android.p2rsmusicstreamer.adapter.TrackAdapter;
import com.majorprojectmodule.android.p2rsmusicstreamer.entity.Track;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private final String LOG_TAG = MainActivityFragment.class.getSimpleName();

    private List<Track> trackList;
    private TrackAdapter trackAdapter;

    @Override
    public void onStart() {
        updateTrackList();
        super.onStart();
    }

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        trackList = new ArrayList();

        trackAdapter = new TrackAdapter(getActivity(), trackList);

        ListView trackList = (ListView) rootView.findViewById(R.id.track_list_view);

        trackList.setAdapter(trackAdapter);

        trackList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Track selectedTrack = trackAdapter.getItem(i);

                Intent nowPlayIntent = new Intent(getActivity(),NowPlaying.class);

                nowPlayIntent.putExtra("selected_track",selectedTrack);

                startActivity(nowPlayIntent);
            }
        });

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("USER", Context.MODE_PRIVATE);

        Log.v("USERNAME",sharedPreferences.getString("userName","NONE"));

        return rootView;

    }
    private void updateTrackList(){
        new FetchTrackTask().execute();
    }

    public class FetchTrackTask extends AsyncTask<Void ,Void ,List<Track>> {

        private final String LOG_TAG = FetchTrackTask.class.getSimpleName();

        @Override
        protected List<Track> doInBackground(Void... voids) {
            // These two need to be declared outside the try/catch
            // so that they can be closed in the finally block.
            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;

            // Will contain the raw JSON response as a string.
            String trackJsonStr = null;


            int numDays = 7;

            try {

                URL url = new URL("http://192.168.100.6:8084/AdminApp/track/getAll");

                // Create the request to OpenWeatherMap, and open the connection
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                // Read the input stream into a String
                InputStream inputStream = urlConnection.getInputStream();
                StringBuffer buffer = new StringBuffer();
                if (inputStream == null) {
                    // Nothing to do.
                    trackJsonStr = null;
                }
                reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                while ((line = reader.readLine()) != null) {
                    // Since it's JSON, adding a newline isn't necessary (it won't affect parsing)
                    // But it does make debugging a *lot* easier if you print out the completed
                    // buffer for debugging.
                    buffer.append(line + "\n");
                }

                if (buffer.length() == 0) {
                    // Stream was empty.  No point in parsing.
                    trackJsonStr = null;
                }
                trackJsonStr = buffer.toString();


            } catch (IOException e) {
                Log.e(LOG_TAG, "IOException ", e);
                // If the code didn't successfully get the weather data, there's no point in attempting
                // to parse it.
                trackJsonStr = null;
            }
            finally{
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (final IOException e) {
                        Log.e(LOG_TAG, "Error closing stream", e);
                    }
                }
            }
            try {
                List<Track> tracks = new JSONParser().getTrackDetails(trackJsonStr);

                return tracks;
            }
            catch (JSONException e){
                Log.e(LOG_TAG,"JSONException",e);

            }
            return null;
        }

        @Override
        protected void onPostExecute(List<Track> result) {

            trackAdapter.clear();
            trackAdapter.addAll(result);

        }
    }

}
