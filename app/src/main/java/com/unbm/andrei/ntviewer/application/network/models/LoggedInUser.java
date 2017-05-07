package com.unbm.andrei.ntviewer.application.network.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Andrei on 5/6/2017.
 */

public class LoggedInUser implements Parcelable {

    private String username;
    private String isWorking;


    protected LoggedInUser(Parcel in) {
        username = in.readString();
        isWorking = in.readString();
    }

    public static final Creator<LoggedInUser> CREATOR = new Creator<LoggedInUser>() {
        @Override
        public LoggedInUser createFromParcel(Parcel in) {
            return new LoggedInUser(in);
        }

        @Override
        public LoggedInUser[] newArray(int size) {
            return new LoggedInUser[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(username);
        dest.writeString(isWorking);
    }

    public String getUsername() {
        return username;
    }

    public String getIsWorking() {
        return isWorking;
    }
}
