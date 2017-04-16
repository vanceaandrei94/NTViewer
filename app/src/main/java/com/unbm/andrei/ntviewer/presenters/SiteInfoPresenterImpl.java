package com.unbm.andrei.ntviewer.presenters;

import android.location.Location;

import com.unbm.andrei.ntviewer.NTViewerApplication;
import com.unbm.andrei.ntviewer.model.NetworkSite;
import com.unbm.andrei.ntviewer.service.NetworkApi;
import com.unbm.andrei.ntviewer.service.api.INetworkServiceProvider;
import com.unbm.andrei.ntviewer.views.SiteInfoView;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Andrei on 4/16/2017.
 */

public class SiteInfoPresenterImpl implements SiteInfoPresenter {

    private SiteInfoView siteInfoView;
    private INetworkServiceProvider networkApi;

    public SiteInfoPresenterImpl(SiteInfoView siteInfoView) {
        this.siteInfoView = siteInfoView;
        networkApi = NetworkApi.getInstance().getNetworkService();
    }


    @Override
    public void loadClosestSite() {
        Location lastKnownLocation = NTViewerApplication.getInstance().getLastKnownLocation();
        if (lastKnownLocation != null) {
            Observable<NetworkSite> networkSiteRequest = networkApi.getClosestNetworkSite(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());
            networkSiteRequest.subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(this::loadSite);
        }
    }

    private void loadSite(NetworkSite site) {
        siteInfoView.loadSite();
    }
}
