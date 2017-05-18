package com.unbm.andrei.ntviewer.application.network.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by andrei.vancea on 5/18/2017.
 */

public class NetworkProviders implements Parcelable{

    private List<EdgePoint> coverageEdges;

    protected NetworkProviders(Parcel in) {
        coverageEdges = in.createTypedArrayList(EdgePoint.CREATOR);
    }

    public static final Creator<NetworkProviders> CREATOR = new Creator<NetworkProviders>() {
        @Override
        public NetworkProviders createFromParcel(Parcel in) {
            return new NetworkProviders(in);
        }

        @Override
        public NetworkProviders[] newArray(int size) {
            return new NetworkProviders[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(coverageEdges);
    }
}
