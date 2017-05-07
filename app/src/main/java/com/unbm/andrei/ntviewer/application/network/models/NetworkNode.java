package com.unbm.andrei.ntviewer.application.network.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Andrei on 4/30/2017.
 */

public class NetworkNode implements Parcelable {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("local_ip")
    @Expose
    private String localIpAddress;

    @SerializedName("mac")
    @Expose
    private String macAddress;

    @SerializedName("state")
    @Expose
    private String state;

    @SerializedName("last_active")
    @Expose
    private String lastActive;

    @SerializedName("last_max_time_active")
    @Expose
    private String lastMaxTimeActive;

    protected NetworkNode(Parcel in) {
        name = in.readString();
        type = in.readString();
        localIpAddress = in.readString();
        macAddress = in.readString();
        state = in.readString();
        lastActive = in.readString();
        lastMaxTimeActive = in.readString();
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

    public String getState() {
        return state;
    }

    public String getLastActive() {
        return lastActive;
    }

    public String getLastMaxTimeActive() {
        return lastMaxTimeActive;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLocalIpAddress(String localIpAddress) {
        this.localIpAddress = localIpAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setLastActive(String lastActive) {
        this.lastActive = lastActive;
    }

    public void setLastMaxTimeActive(String lastMaxTimeActive) {
        this.lastMaxTimeActive = lastMaxTimeActive;
    }

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
        dest.writeString(state);
        dest.writeString(lastActive);
        dest.writeString(lastMaxTimeActive);
    }
}
