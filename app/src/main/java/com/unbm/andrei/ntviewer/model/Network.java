package com.unbm.andrei.ntviewer.model;

import java.util.List;

/**
 * Created by Andrei on 3/18/2017.
 */

public class Network {

    private int id;
    private String name;
    private String endpointAddress;
    private List<NetworkNode> networkNodeList;
    private String addedAt;
    private String locationId;

    public Network(String name) {
        this.name = name;
    }

    public Network(String name, String endpointAddress, List<NetworkNode> networkNodeList) {
        this.name = name;
        this.endpointAddress = endpointAddress;
        this.networkNodeList = networkNodeList;
    }

    public Network() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEndpointAddress() {
        return endpointAddress;
    }

    public void setEndpointAddress(String endpointAddress) {
        this.endpointAddress = endpointAddress;
    }

    public List<NetworkNode> getNetworkNodeList() {
        return networkNodeList;
    }

    public void setNetworkNodeList(List<NetworkNode> networkNodeList) {
        this.networkNodeList = networkNodeList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(String addedAt) {
        this.addedAt = addedAt;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }
}
