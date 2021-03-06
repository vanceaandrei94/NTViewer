package com.unbm.andrei.ntviewer.application.network.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NetworkProvider implements Parcelable {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("color")
    @Expose
    private String color;
    @SerializedName("geoLocations")
    @Expose
    private List<GeoLocation> geoLocations = null;

    protected NetworkProvider(Parcel in) {
        name = in.readString();
        color = in.readString();
        geoLocations = in.createTypedArrayList(GeoLocation.CREATOR);
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<GeoLocation> getGeoLocations() {
        return geoLocations;
    }

    public void setGeoLocations(List<GeoLocation> geoLocations) {
        this.geoLocations = geoLocations;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(color);
        dest.writeTypedList(geoLocations);
    }
}
