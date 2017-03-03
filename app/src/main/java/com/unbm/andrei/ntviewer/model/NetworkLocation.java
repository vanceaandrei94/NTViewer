package com.unbm.andrei.ntviewer.model;

/**
 * Created by andrei.vancea on 2/27/2017.
 */

public class NetworkLocation {

    private String name;
    private String ipAddress;
    private boolean available = false;

    public NetworkLocation() {
    }

    public NetworkLocation(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
