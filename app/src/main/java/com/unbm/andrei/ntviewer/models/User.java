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
    private boolean isWorking;

    public User(String username, int id) {
        this.username = username;
        this.id = id;
    }

    public User(String username, boolean isWorking) {
        this.username = username;
        this.isWorking = isWorking;
    }

    public User(String username, String password, boolean isWorking) {
        this.username = username;
        this.password = password;
        this.isWorking = isWorking;
    }

    protected User(Parcel in) {
        username = in.readString();
        password = in.readString();
        id = in.readInt();
        isWorking = in.readByte() != 0;
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

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getIsWorking() {
        return isWorking;
    }

    public void setIsWorking(boolean isWorking) {
        this.isWorking = isWorking;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isWorking() {
        return isWorking;
    }

    public void setWorking(boolean working) {
        isWorking = working;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(username);
        dest.writeString(password);
        dest.writeInt(id);
        dest.writeByte((byte) (isWorking ? 1 : 0));
    }
}
