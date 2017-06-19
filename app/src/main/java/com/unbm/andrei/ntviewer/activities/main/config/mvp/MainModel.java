package com.unbm.andrei.ntviewer.activities.main.config.mvp;

import android.app.Activity;

import com.unbm.andrei.ntviewer.activities.map.complaints.ComplaintsMapActivity;
import com.unbm.andrei.ntviewer.activities.main.MainActivity;
import com.unbm.andrei.ntviewer.activities.map.coverage.CoverageMapActivity;

/**
 * Created by Andrei on 4/30/2017.
 */

public class MainModel {

    private Activity activity;

    public MainModel(MainActivity activity) {
        this.activity = activity;
    }

    public void startMapCoverageActivity() {
        CoverageMapActivity.start(activity);
    }

    public void startComplaintsActivity() {
        ComplaintsMapActivity.start(activity);
    }
}
