package com.majorprojectmodule.android.p2rsmusicstreamer;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.majorprojectmodule.android.p2rsmusicstreamer.Helper.JSONParser;
import com.majorprojectmodule.android.p2rsmusicstreamer.adapter.TrackAdapter;
import com.majorprojectmodule.android.p2rsmusicstreamer.entity.Track;
import com.squareup.picasso.Picasso;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class NowPlayingFragment extends Fragment {

    private String LOG_TAG = NowPlayingFragment.class.getSimpleName();

    private MediaPlayer mediaPlayer;

    private TrackAdapter trackAdapter;
    private List<Track> trackList;

    ImageView playPause;
    TextView title;
    ImageView albumArt;

    RequestQueue requestQueue;

    Track selectedTrack;

    public NowPlayingFragment() {
    }

    @Override
    public void onStop() {
        super.onStop();
        mediaPlayer.stop();
        mediaPlayer.release();
    }

    private void togglePlayButton(){
        if(mediaPlayer.isPlaying()){
            mediaPlayer.pause();
            playPause.setImageResource(R.drawable.ic_play_arrow_black_36dp);
        }
        else{
            mediaPlayer.start();
            playPause.setImageResource(R.drawable.ic_pause_black_36dp);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_now_playing, container, false);

        trackList = new ArrayList();

        trackAdapter = new TrackAdapter(getContext(),trackList);

        ListView trackListView = (ListView) rootView.findViewById(R.id.track_list_view_recom);

        trackListView.setAdapter(trackAdapter);

        trackListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Track selectedTrack = trackAdapter.getItem(i);

                Intent nowPlayIntent = new Intent(getActivity(),NowPlaying.class);

                nowPlayIntent.putExtra("selected_track",selectedTrack);

                startActivity(nowPlayIntent);
            }
        });

        title = (TextView) rootView.findViewById(R.id.nowplaying_title);

        albumArt = (ImageView) rootView.findViewById(R.id.album_art);

        playPause = (ImageView) rootView.findViewById(R.id.play_button);

        playPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                togglePlayButton();
            }
        });

        Intent receivedIntent = getActivity().getIntent();

        if (receivedIntent != null && receivedIntent.hasExtra("selected_track")){

            selectedTrack = receivedIntent.getParcelableExtra("selected_track");

            title.setText(selectedTrack.getTitle());

            Picasso.with(getContext()).load(selectedTrack.getArtworkURL().replace("/300x300/","/174s/")).into(albumArt);

            Picasso.with(getContext()).load(R.drawable.ic_play_arrow_black_36dp).into(playPause);
        }
        requestQueue = Volley.newRequestQueue(getContext());

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("USER", Context.MODE_PRIVATE);

        String username = sharedPreferences.getString("userName","NONE");


        String recomUrl = "http://192.168.100.6:8084/AdminApp/track/audio/getRecomd/"   +   selectedTrack.getId()+"/"
                            +username;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, recomUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.v(LOG_TAG, response);

                try {
                    trackList = new JSONParser().getTrackDetails(response);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                trackList.add(new Track());

                trackAdapter.addAll(trackList);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(LOG_TAG,error.getStackTrace().toString());
            }
        });

        requestQueue.add(stringRequest);

        mediaPlayer = new MediaPlayer();

        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {

                mediaPlayer.start();

                playPause.setImageResource(R.drawable.ic_pause_black_36dp);
            }
        });

        try {
            String url = selectedTrack.getStreamURL();

            Log.v("URL",selectedTrack.getStreamURL());

            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

            mediaPlayer.setDataSource(url);

            mediaPlayer.prepareAsync();

        } catch (IOException e) {
           e.printStackTrace();
        }


        return rootView;
    }

}
