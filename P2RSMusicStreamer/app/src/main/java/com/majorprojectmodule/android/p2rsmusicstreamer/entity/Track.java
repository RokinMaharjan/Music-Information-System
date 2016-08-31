package com.majorprojectmodule.android.p2rsmusicstreamer.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by gandoff on 8/4/16.
 */
public class Track implements Parcelable {

    private int id;

    private String title;

    private String streamURL;

    private String artworkURL;




    public Track() {
    }

    public Track(int id ,String title, String streamURL, String artworkURL) {
        this.id = id;
        this.title = title;
        this.streamURL = streamURL;
        this.artworkURL = artworkURL;
    }

    protected Track(Parcel in){
        id = in.readInt();
        title = in.readString();
        streamURL = in.readString();
        artworkURL = in.readString();
    }

    public static final Creator<Track> CREATOR = new Creator<Track>() {
        @Override
        public Track createFromParcel(Parcel in) {
            return new Track(in);
        }

        @Override
        public Track[] newArray(int size) {
            return new Track[size];
        }
    };

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getTitle() {return title;}

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStreamURL() {
        return streamURL;
    }

    public void setStreamURL(String streamURL) {
        this.streamURL = streamURL;
    }

    public String getArtworkURL() {
        return artworkURL;
    }

    public void setArtworkURL(String artworkURL) {
        this.artworkURL = artworkURL;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(title);
        parcel.writeString(streamURL);
        parcel.writeString(artworkURL);

    }


}
