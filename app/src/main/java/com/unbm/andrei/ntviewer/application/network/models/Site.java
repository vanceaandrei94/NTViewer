package com.unbm.andrei.ntviewer.application.network.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Andrei on 5/1/2017.
 */

public class Site implements Parcelable {

    @SerializedName("NetworkSite")
    @Expose
    private NetworkSite networkSite;

    protected Site(Parcel in) {
        networkSite = in.readParcelable(NetworkSite.class.getClassLoader());
    }

    public static final Creator<Site> CREATOR = new Creator<Site>() {
        @Override
        public Site createFromParcel(Parcel in) {
            return new Site(in);
        }

        @Override
        public Site[] newArray(int size) {
            return new Site[size];
        }
    };

    public NetworkSite getNetworkSite() {
        return networkSite;
    }

    public void setNetworkSite(NetworkSite networkSite) {
        this.networkSite = networkSite;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(networkSite, flags);
    }
}
