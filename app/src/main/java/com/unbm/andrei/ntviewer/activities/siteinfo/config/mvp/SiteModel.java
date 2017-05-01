package com.unbm.andrei.ntviewer.activities.siteinfo.config.mvp;

import com.unbm.andrei.ntviewer.activities.siteinfo.SiteInfoActivity;
import com.unbm.andrei.ntviewer.application.network.models.Site;

import java.util.List;

/**
 * Created by Andrei on 5/1/2017.
 */

public class SiteModel {

    private final SiteInfoActivity activity;

    public SiteModel(SiteInfoActivity activity) {
        this.activity = activity;
    }

    public List<Site> getSite() {
        return activity.getIntent().getParcelableExtra(SiteInfoActivity.SITE);
    }
}
