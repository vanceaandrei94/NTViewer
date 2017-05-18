package com.unbm.andrei.ntviewer.application.network.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by andrei.vancea on 5/18/2017.
 */

public class EdgePoint implements Parcelable{

    private double lat;
    private double lon;

    protected EdgePoint(Parcel in) {
        lat = in.readDouble();
        lon = in.readDouble();
    }

    public static final Creator<EdgePoint> CREATOR = new Creator<EdgePoint>() {
        @Override
        public EdgePoint createFromParcel(Parcel in) {
            return new EdgePoint(in);
        }

        @Override
        public EdgePoint[] newArray(int size) {
            return new EdgePoint[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(lat);
        dest.writeDouble(lon);
    }
}
