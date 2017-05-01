package com.unbm.andrei.ntviewer.application.network.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Andrei on 4/30/2017.
 */

public class Subscriber implements Parcelable{

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("home_addr")
    @Expose
    private String address;

    @SerializedName("location")
    @Expose
    private Coordinate location;

    @SerializedName("phone")
    @Expose
    private String phoneNumber;

    @SerializedName("ipAddress")
    @Expose
    private String publicIp;

    @SerializedName("subnetwork")
    @Expose
    private Subnetwork subnetwork;

    //those should appear there
//    private double internetSpeed; // KB/s or Mb/s
//    private int ping;
//    private boolean hasProblem;
//    private boolean active;


    protected Subscriber(Parcel in) {
        name = in.readString();
        address = in.readString();
        location = in.readParcelable(Coordinate.class.getClassLoader());
        phoneNumber = in.readString();
        publicIp = in.readString();
        subnetwork = in.readParcelable(Subnetwork.class.getClassLoader());
    }

    public static final Creator<Subscriber> CREATOR = new Creator<Subscriber>() {
        @Override
        public Subscriber createFromParcel(Parcel in) {
            return new Subscriber(in);
        }

        @Override
        public Subscriber[] newArray(int size) {
            return new Subscriber[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Coordinate getLocation() {
        return location;
    }

    public void setLocation(Coordinate location) {
        this.location = location;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPublicIp() {
        return publicIp;
    }

    public void setPublicIp(String publicIp) {
        this.publicIp = publicIp;
    }

    public Subnetwork getSubnetwork() {
        return subnetwork;
    }

    public void setSubnetwork(Subnetwork subnetwork) {
        this.subnetwork = subnetwork;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(address);
        dest.writeParcelable(location, flags);
        dest.writeString(phoneNumber);
        dest.writeString(publicIp);
        dest.writeParcelable(subnetwork, flags);
    }
}
