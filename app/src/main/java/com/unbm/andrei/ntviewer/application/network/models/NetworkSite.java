package com.unbm.andrei.ntviewer.application.network.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Andrei on 4/30/2017.
 */

public class NetworkSite implements Parcelable {

    @SerializedName("site_name")
    @Expose
    private String name;

    @SerializedName("site_location")
    @Expose
    private SiteLocation siteLocation;

    @SerializedName("subscribers")
    @Expose
    private List<Subscriber> subscribers;

    @SerializedName("site_quality")
    @Expose
    private String quality;

    protected NetworkSite(Parcel in) {
        name = in.readString();
        siteLocation = in.readParcelable(SiteLocation.class.getClassLoader());
        subscribers = in.createTypedArrayList(Subscriber.CREATOR);
        quality = in.readString();
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

    public String getName() {
        return name;
    }


    public List<Subscriber> getSubscribers() {
        return subscribers;
    }

    public SiteLocation getSiteLocation() {
        return siteLocation;
    }

    public String getQuality() {
        return quality;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSiteLocation(SiteLocation siteLocation) {
        this.siteLocation = siteLocation;
    }

    public void setSubscribers(List<Subscriber> subscribers) {
        this.subscribers = subscribers;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeParcelable(siteLocation, flags);
        dest.writeTypedList(subscribers);
        dest.writeString(quality);
    }
}
