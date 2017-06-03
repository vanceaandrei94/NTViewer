package com.unbm.andrei.ntviewer.application.network.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by andrei.vancea on 5/18/2017.
 */

public class NetworkProvider implements Parcelable{

    private List<EdgePoint> coverageEdges;

    protected NetworkProvider(Parcel in) {
        coverageEdges = in.createTypedArrayList(EdgePoint.CREATOR);
    }

    public static final Creator<NetworkProvider> CREATOR = new Creator<NetworkProvider>() {
        @Override
        public NetworkProvider createFromParcel(Parcel in) {
            return new NetworkProvider(in);
        }

        @Override
        public NetworkProvider[] newArray(int size) {
            return new NetworkProvider[size];
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
