package com.unbm.andrei.ntviewer.application.network.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Andrei on 4/30/2017.
 */

public class NetworkSubscriber implements Parcelable{

    private String name;
    private String address;
    private int lat;
    private int lon;
    private String phoneNumber;
    private String publicIp;
    private List<NetworkNode> subNetwork;

    //those should appear there
//    private double internetSpeed; // KB/s or Mb/s
//    private int ping;
//    private boolean hasProblem;
//    private boolean active;


    protected NetworkSubscriber(Parcel in) {
        name = in.readString();
        address = in.readString();
        lat = in.readInt();
        lon = in.readInt();
        phoneNumber = in.readString();
        publicIp = in.readString();
        subNetwork = in.createTypedArrayList(NetworkNode.CREATOR);
    }

    public static final Creator<NetworkSubscriber> CREATOR = new Creator<NetworkSubscriber>() {
        @Override
        public NetworkSubscriber createFromParcel(Parcel in) {
            return new NetworkSubscriber(in);
        }

        @Override
        public NetworkSubscriber[] newArray(int size) {
            return new NetworkSubscriber[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getLat() {
        return lat;
    }

    public int getLon() {
        return lon;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPublicIp() {
        return publicIp;
    }

    public List<NetworkNode> getSubNetwork() {
        return subNetwork;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(address);
        dest.writeInt(lat);
        dest.writeInt(lon);
        dest.writeString(phoneNumber);
        dest.writeString(publicIp);
        dest.writeTypedList(subNetwork);
    }
}
