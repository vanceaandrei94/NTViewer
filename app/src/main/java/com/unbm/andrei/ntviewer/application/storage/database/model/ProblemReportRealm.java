package com.unbm.andrei.ntviewer.application.storage.database.model;

import com.unbm.andrei.ntviewer.models.PriorityType;
import com.unbm.andrei.ntviewer.models.ProblemType;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Andrei on 8/26/2017.
 */

public class ProblemReportRealm extends RealmObject {

    @PrimaryKey
    private int id;

    @ProblemType
    private int problemType;

    @PriorityType
    private int problemPriority;

    private Double lat;
    private Double lon;
    private String problemDescription;
    private Date reportedAt;
    private boolean active;

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

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

    public String getProblemDescription() {
        return problemDescription;
    }

    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
