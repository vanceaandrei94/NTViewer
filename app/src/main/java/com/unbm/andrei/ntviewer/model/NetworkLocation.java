package com.unbm.andrei.ntviewer.model;

/**
 * Created by andrei.vancea on 2/27/2017.
 */

public class NetworkLocation {

    private String name;
    private String ipAddress;

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
}
