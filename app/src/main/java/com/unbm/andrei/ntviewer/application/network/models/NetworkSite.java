package com.unbm.andrei.ntviewer.application.network.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Andrei on 4/30/2017.
 */

public class NetworkSite implements Parcelable {

    private String name;
    private String bounds; //check to see
    private List<NetworkSubscriber> subscribers;

    protected NetworkSite(Parcel in) {
        name = in.readString();
        bounds = in.readString();
        subscribers = in.createTypedArrayList(NetworkSubscriber.CREATOR);
    }

    public static final Creator<NetworkSite> CREATOR = new Creator<NetworkSite>() {
        @Override
        public NetworkSite createFromParcel(Parcel in) {
            return new NetworkSite(in);
        }

        @Override
        public NetworkSite[] newArray(int size) {
            return new NetworkSite[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(bounds);
        dest.writeTypedList(subscribers);
    }

    public String getName() {
        return name;
    }

    public String getBounds() {
        return bounds;
    }

    public List<NetworkSubscriber> getSubscribers() {
        return subscribers;
    }
}
