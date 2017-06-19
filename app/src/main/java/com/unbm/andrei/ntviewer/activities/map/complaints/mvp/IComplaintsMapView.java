package com.unbm.andrei.ntviewer.activities.map.complaints.mvp;

import com.unbm.andrei.ntviewer.application.network.models.Complaint;

import java.util.List;

/**
 * Created by Andrei on 6/3/2017.
 */

public interface IComplaintsMapView {

    void drawCoverage(List<Complaint> providers);
}
