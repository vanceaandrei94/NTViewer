package com.unbm.andrei.ntviewer.application.network.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Andrei on 4/30/2017.
 */

public class NetworkNode implements Parcelable{

    private String name;
    private String type;
    private String localIpAddress;
    private String macAddress;

    protected NetworkNode(Parcel in) {
        name = in.readString();
        type = in.readString();
        localIpAddress = in.readString();
        macAddress = in.readString();
    }

    public static final Creator<NetworkNode> CREATOR = new Creator<NetworkNode>() {
        @Override
        public NetworkNode createFromParcel(Parcel in) {
            return new NetworkNode(in);
        }

        @Override
        public NetworkNode[] newArray(int size) {
            return new NetworkNode[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(type);
        dest.writeString(localIpAddress);
        dest.writeString(macAddress);
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getLocalIpAddress() {
        return localIpAddress;
    }

    public String getMacAddress() {
        return macAddress;
    }
}
