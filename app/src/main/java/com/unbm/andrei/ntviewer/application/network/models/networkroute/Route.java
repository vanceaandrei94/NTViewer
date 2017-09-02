package com.unbm.andrei.ntviewer.application.network.models.networkroute;

/**
 * Created by Andrei on 6/21/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Route {

    @SerializedName("routeId")
    @Expose
    private String routeId = null;

    @SerializedName("linePoints")
    @Expose
    private List<LinePoint> line = null;
    @SerializedName("routeOk")
    @Expose
    private boolean routeOk;

    public List<LinePoint> getLine() {
        return line;
    }

    public void setLine(List<LinePoint> line) {
        this.line = line;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public boolean isRouteOk() {
        return routeOk;
    }
}