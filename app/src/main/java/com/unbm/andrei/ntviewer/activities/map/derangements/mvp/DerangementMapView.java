package com.unbm.andrei.ntviewer.activities.map.derangements.mvp;

import com.unbm.andrei.ntviewer.models.ProblemReport;

import java.util.List;

/**
 * Created by Andrei on 6/3/2017.
 */

public interface DerangementMapView {

    void drawDerangements(List<ProblemReport> providers);

    void showDerangementInfo(ProblemReport problemReport);
}
