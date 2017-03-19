package com.unbm.andrei.ntviewer.model;

import java.util.Date;

/**
 * Created by Andrei on 3/18/2017.
 */

public class NetworkNode {

    private String id;
    private String name;
    private String localIpAddress;
    private String type;
    private String macAddress;
    private String addedAt;
    private String lastOnline;
    private boolean isActive;
    private String path2DFile;
    private String path3DFile;
    private String networkId;

    public NetworkNode(String name, String localIpAddress, String type, String macAddress, String addedAt, String lastOnline, boolean isActive) {
        this.name = name;
        this.localIpAddress = localIpAddress;
        this.type = type;
        this.macAddress = macAddress;
        this.addedAt = addedAt;
        this.lastOnline = lastOnline;
        this.isActive = isActive;
    }

    public NetworkNode() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocalIpAddress() {
        return localIpAddress;
    }

    public void setLocalIpAddress(String localIpAddress) {
        this.localIpAddress = localIpAddress;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(String addedAt) {
        this.addedAt = addedAt;
    }

    public String getLastOnline() {
        return lastOnline;
    }

    public void setLastOnline(String lastOnline) {
        this.lastOnline = lastOnline;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }


    public String getPath2DFile() {
        return path2DFile;
    }

    public String getPath3DFile() {
        return path3DFile;
    }

    public void setPath2DFile(String path2DFile) {
        this.path2DFile = path2DFile;
    }

    public void setPath3DFile(String path3DFile) {
        this.path3DFile = path3DFile;
    }

    public String getNetworkId() {
        return networkId;
    }

    public void setNetworkId(String networkId) {
        this.networkId = networkId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
