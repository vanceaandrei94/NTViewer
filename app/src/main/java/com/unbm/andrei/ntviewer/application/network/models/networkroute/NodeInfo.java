package com.unbm.andrei.ntviewer.application.network.models.networkroute;

/**
 * Created by Andrei on 6/22/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NodeInfo {

    @SerializedName("nodeId")
    @Expose
    private String nodeId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("ip")
    @Expose
    private String ip;
    @SerializedName("last_updated")
    @Expose
    private String lastUpdated;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("type")
    @Expose
    private String type;

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}