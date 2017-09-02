package com.unbm.andrei.ntviewer.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Andrei on 5/6/2017.
 */

public class User implements Parcelable {

    private String username;
    private String password;
    private int id;

    public User(String username, int id) {
        this.username = username;
        this.id = id;
    }

    public User(String username) {
        this.username = username;
    }

    protected User(Parcel in) {
        username = in.readString();
        password = in.readString();
        id = in.readInt();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(username);
        dest.writeString(password);
        dest.writeInt(id);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }
}
