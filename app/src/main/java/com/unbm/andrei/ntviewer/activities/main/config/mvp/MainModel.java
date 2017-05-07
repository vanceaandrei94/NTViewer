package com.unbm.andrei.ntviewer.activities.main.config.mvp;

import android.app.Activity;

import com.unbm.andrei.ntviewer.activities.main.MainActivity;
import com.unbm.andrei.ntviewer.activities.siteinfo.SiteInfoActivity;
import com.unbm.andrei.ntviewer.application.network.NTVService;
import com.unbm.andrei.ntviewer.application.network.models.Site;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Andrei on 4/30/2017.
 */

public class MainModel {

    private NTVService NTVService;
    private Activity activity;

    public MainModel(NTVService NTVService, MainActivity activity) {
        this.NTVService = NTVService;
        this.activity = activity;
    }

    public Observable<List<Site>> getAllSites() {
        return NTVService.getAllNetworkSites();
    }

    public void startSiteInfoActivity(Site site) {
        SiteInfoActivity.start(activity, site);
    }
}
