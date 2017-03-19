package com.unbm.andrei.ntviewer.model;

/**
 * Created by Andrei on 3/18/2017.
 */

public class SketchNetworkNode extends NetworkNode {

    private float[] position;

    /**
     * File Path of the file where the model data is located
     */
    private String modelFile;

    public SketchNetworkNode(String name, String localIpAddress, String type, String macAddress, String addedAt, String lastOnline, boolean isActive, float[] position, String modelFile) {
        super(name, localIpAddress, type, macAddress, addedAt, lastOnline, isActive);
        this.position = position;
        this.modelFile = modelFile;
    }

    public SketchNetworkNode(float[] position, String modelFile) {
        this.position = position;
        this.modelFile = modelFile;
    }

    public float[] getPosition() {
        return position;
    }

    public void setPosition(float[] position) {
        this.position = position;
    }

    public String getModelFile() {
        return modelFile;
    }

    public void setModelFile(String modelFile) {
        this.modelFile = modelFile;
    }
}
