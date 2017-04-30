package com.unbm.andrei.ntviewer.activities.main.config.mvp;

import android.app.Activity;

import com.unbm.andrei.ntviewer.activities.main.MainActivity;
import com.unbm.andrei.ntviewer.application.network.SitesProviderService;
import com.unbm.andrei.ntviewer.application.network.models.NetworkSite;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Andrei on 4/30/2017.
 */

public class MainModel {

    private SitesProviderService sitesProviderService;
    private Activity activity;

    public MainModel(SitesProviderService sitesProviderService, MainActivity activity) {
        this.sitesProviderService = sitesProviderService;
        this.activity = activity;
    }

    public Observable<List<NetworkSite>> getAllSites() {
        return sitesProviderService.getAllNetworkSites();
    }
}