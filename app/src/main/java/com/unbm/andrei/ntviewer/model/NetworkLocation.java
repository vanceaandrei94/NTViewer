package com.unbm.andrei.ntviewer.model;

/**
 * Created by andrei.vancea on 2/27/2017.
 */

public class NetworkLocation {

    private int id;
    private String name;
    private String ipAddress;
    private double lat;
    private double lon;
    private boolean available = false;

    public NetworkLocation() {
    }

    public NetworkLocation(int id, String name, String ipAddress, double lat, double lon) {
        this.id = id;
        this.name = name;
        this.ipAddress = ipAddress;
        this.lat = lat;
        this.lon = lon;
    }

    public NetworkLocation(String name) {
        this.name = name;
    }

    public NetworkLocation(String name, String ipAddress, double lat, double lon) {
        this.name = name;
        this.ipAddress = ipAddress;
        this.lat = lat;
        this.lon = lon;
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

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
