package com.majorprojectmodule.android.p2rsmusicstreamer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.majorprojectmodule.android.p2rsmusicstreamer.R;
import com.majorprojectmodule.android.p2rsmusicstreamer.entity.Track;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by gandoff on 8/4/16.
 */
public class TrackAdapter extends ArrayAdapter<Track> {


    public TrackAdapter(Context context, List<Track> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Track track = getItem(position);

        if(convertView == null){

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.content_track_list_view,parent,false);
        }

        ImageView imageView = (ImageView) convertView.findViewById(R.id.track_image);

        Picasso.with(getContext()).load(track.getArtworkURL()).into(imageView);

        TextView textView = (TextView) convertView.findViewById(R.id.track_title);

        textView.setText(track.getTitle());

        ViewGroup.LayoutParams layoutParams = convertView.getLayoutParams();

        layoutParams.height=350;

        return convertView;
    }
}
