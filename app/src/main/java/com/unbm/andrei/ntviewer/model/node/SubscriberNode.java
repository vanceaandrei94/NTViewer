package com.unbm.andrei.ntviewer.model.node;

import android.graphics.Color;

import com.unbm.andrei.ntviewer.model.NetworkNode;

/**
 * Created by Andrei on 4/10/2017.
 */

public class SubscriberNode extends NetworkNode {

    private static final int NODE_COLOR = Color.RED;
    private static final int STROKE_COLOR = Color.GREEN;
    private static final int STROKE_PROBLEM_COLOR = Color.RED;
    private static final int STROKE_WIDTH = 5;

    private String name;
    private String address;

    public SubscriberNode(double lat, double lon, String publicIp) {
        super(lat, lon, publicIp);
        mapObject.strokeColor(STROKE_COLOR).strokeWidth(STROKE_WIDTH).fillColor(NODE_COLOR);
    }

    public SubscriberNode(String name, String address, double lat, double lon, String publicIp) {
        this(lat, lon, publicIp);
        this.name = name;
        this.address = address;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
