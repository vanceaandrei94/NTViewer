package com.unbm.andrei.ntviewer.model;


import android.graphics.Color;

import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Andrei on 3/18/2017.
 */
@Getter
@Setter
public class NetworkNode {

    private static final int DEFAULT_NODE_COLOR = Color.RED;
    private static final float DEFAULT_STROKE_WIDTH = 1; //in meters
    private static final double DEFAULT_NODE_RADIUS = 100;//in meters

    protected double lat;
    protected double lon;
    protected CircleOptions mapObject;
    protected String publicIp;

    public NetworkNode(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
        mapObject = new CircleOptions().center(new LatLng(lat, lon))
                .strokeWidth(DEFAULT_STROKE_WIDTH)
                .fillColor(DEFAULT_NODE_COLOR)
                .strokeColor(DEFAULT_NODE_COLOR)
                .radius(DEFAULT_NODE_RADIUS)
                .clickable(true);
    }

    public NetworkNode(double lat, double lon, String publicIp) {
        this(lat, lon);
        this.publicIp = publicIp;
    }

}
