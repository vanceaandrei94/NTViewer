package com.unbm.andrei.ntviewer.application.network.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Andrei on 6/11/2017.
 */

public class Derangement implements Parcelable {

    @SerializedName("priority")
    @Expose
    private int priority;
    @SerializedName("lat")
    @Expose
    private float lat;
    @SerializedName("lon")
    @Expose
    private float lon;

    protected Derangement(Parcel in) {
        priority = in.readInt();
        lat = in.readFloat();
        lon = in.readFloat();
    }

    public static final Creator<Derangement> CREATOR = new Creator<Derangement>() {
        @Override
        public Derangement createFromParcel(Parcel in) {
            return new Derangement(in);
        }

        @Override
        public Derangement[] newArray(int size) {
            return new Derangement[size];
        }
    };

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(priority);
        dest.writeFloat(lat);
        dest.writeFloat(lon);
    }
}
