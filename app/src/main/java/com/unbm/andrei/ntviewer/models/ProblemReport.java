package com.unbm.andrei.ntviewer.models;

import java.util.Date;

/**
 * Created by Andrei on 8/26/2017.
 */

public class ProblemReport {

    @ProblemType
    private int problemType;

    @PriorityType
    private int problemPriority;

    private String problemDetails;

    private Date reportedAt;

    private int id;

    private boolean active;
    private double lat;
    private double lon;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getReportedAt() {
        return reportedAt;
    }

    public void setReportedAt(Date reportedAt) {
        this.reportedAt = reportedAt;
    }

    @ProblemType
    public int getProblemType() {
        return problemType;
    }

    public void setProblemType(int problemType) {
        this.problemType = problemType;
    }

    public int getProblemPriority() {
        return problemPriority;
    }

    public void setProblemPriority(int problemPriority) {
        this.problemPriority = problemPriority;
    }

    public String getProblemDetails() {
        return problemDetails;
    }

    public void setProblemDetails(String problemDetails) {
        this.problemDetails = problemDetails;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
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
}
