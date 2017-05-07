package com.unbm.andrei.ntviewer.application.network.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Andrei on 5/7/2017.
 */

public class SRequest implements Parcelable {

    @SerializedName("date_created")
    @Expose
    private String dateCreated;

    @SerializedName("subscriber")
    @Expose
    private Subscriber subscriber;

    protected SRequest(Parcel in) {
        dateCreated = in.readString();
        subscriber = in.readParcelable(Subscriber.class.getClassLoader());
    }

    public static final Creator<SRequest> CREATOR = new Creator<SRequest>() {
        @Override
        public SRequest createFromParcel(Parcel in) {
            return new SRequest(in);
        }

        @Override
        public SRequest[] newArray(int size) {
            return new SRequest[size];
        }
    };

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Subscriber getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(Subscriber subscriber) {
        this.subscriber = subscriber;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(dateCreated);
        dest.writeParcelable(subscriber, flags);
    }
}
