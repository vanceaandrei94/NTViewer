package com.unbm.andrei.ntviewer.application.network.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Andrei on 5/1/2017.
 */

public class SiteLocation implements Parcelable {

    @SerializedName("coordinates")
    @Expose
    private List<Coordinate> coordinates;

    protected SiteLocation(Parcel in) {
        coordinates = in.createTypedArrayList(Coordinate.CREATOR);
    }

    public static final Creator<SiteLocation> CREATOR = new Creator<SiteLocation>() {
        @Override
        public SiteLocation createFromParcel(Parcel in) {
            return new SiteLocation(in);
        }

        @Override
        public SiteLocation[] newArray(int size) {
            return new SiteLocation[size];
        }
    };

    public List<Coordinate> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(coordinates);
    }
}
