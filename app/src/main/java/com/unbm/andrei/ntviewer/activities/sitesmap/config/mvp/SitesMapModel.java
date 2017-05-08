package com.unbm.andrei.ntviewer.activities.sitesmap.config.mvp;

import android.app.Activity;

import com.unbm.andrei.ntviewer.application.network.NTVService;

/**
 * Created by andrei.vancea on 5/8/2017.
 */

public class SitesMapModel {

    private final Activity activity;

    private final NTVService service;

    public SitesMapModel(Activity activity, NTVService service) {
        this.activity = activity;
        this.service = service;
    }


}
