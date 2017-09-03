package com.unbm.andrei.ntviewer.activities.main.config.mvp;

import android.app.Activity;

import com.unbm.andrei.ntviewer.activities.main.MainActivity;
import com.unbm.andrei.ntviewer.activities.map.coverage.CoverageMapActivity;
import com.unbm.andrei.ntviewer.activities.map.derangements.DerangementMapActivity;
import com.unbm.andrei.ntviewer.activities.map.networkroute.NetworkRouteActivity;
import com.unbm.andrei.ntviewer.activities.problem.ReportProblemActivity;

import javax.inject.Inject;

/**
 * Created by Andrei on 4/30/2017.
 */

public class MainModelImpl implements MainModel {

    private Activity activity;

    public MainModelImpl(MainActivity activity) {
        this.activity = activity;
    }

    public void startMapCoverageActivity() {
        CoverageMapActivity.start(activity);
    }

    public void startComplaintsActivity() {
        DerangementMapActivity.start(activity);
    }

    public void startNetworkRouteActivity() {
        NetworkRouteActivity.start(activity);
    }

    public void startReportProblemActivity() {
        ReportProblemActivity.start(activity);
    }
}
