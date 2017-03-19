package com.unbm.andrei.ntviewer.model;

/**
 * Created by andrei.vancea on 2/27/2017.
 */

public class NetworkLocation {

    private int id;
    private String name;
    private double lat;
    private double lon;
    private Network network;

    public NetworkLocation(String name, double lat, double lon) {
        this.name = name;
        this.lat = lat;
        this.lon = lon;
        network = new Network(name);
    }

    public NetworkLocation(int id, String name, double lat, double lon, Network network) {
        this.id = id;
        this.name = name;
        this.lat = lat;
        this.lon = lon;
        this.network = network;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Network getNetwork() {
        return network;
    }

    public void setNetwork(Network network) {
        this.network = network;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
