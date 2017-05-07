package com.unbm.andrei.ntviewer.application.network.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Andrei on 5/1/2017.
 */

public class Subnetwork implements Parcelable {

    @SerializedName("NetworkNodes")
    @Expose
    private List<NetworkNode> networkNodes = null;

    protected Subnetwork(Parcel in) {
        networkNodes = in.createTypedArrayList(NetworkNode.CREATOR);
    }

    public static final Creator<Subnetwork> CREATOR = new Creator<Subnetwork>() {
        @Override
        public Subnetwork createFromParcel(Parcel in) {
            return new Subnetwork(in);
        }

        @Override
        public Subnetwork[] newArray(int size) {
            return new Subnetwork[size];
        }
    };

    public List<NetworkNode> getNetworkNodes() {
        return networkNodes;
    }

    public void setNetworkNodes(List<NetworkNode> networkNodes) {
        this.networkNodes = networkNodes;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(networkNodes);
    }
}
