package com.unbm.andrei.ntviewer.application.network.models.networkroute;

/**
 * Created by Andrei on 6/21/2017.
 */
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NetworkRoute {

    @SerializedName("routes")
    @Expose
    private List<Route> routes = null;
    @SerializedName("nodes")
    @Expose
    private List<Node> nodes = null;

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

}
