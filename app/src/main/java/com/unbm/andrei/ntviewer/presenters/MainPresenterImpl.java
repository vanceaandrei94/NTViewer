package com.unbm.andrei.ntviewer.presenters;

import com.google.android.gms.location.LocationServices;
import com.unbm.andrei.ntviewer.model.NetworkSite;
import com.unbm.andrei.ntviewer.service.NetworkApi;
import com.unbm.andrei.ntviewer.service.api.INetworkServiceProvider;
import com.unbm.andrei.ntviewer.views.MainView;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Andrei on 4/16/2017.
 */

public class MainPresenterImpl implements MainPresenter {

    private MainView mainView;
    private INetworkServiceProvider networkApi;

    public MainPresenterImpl(MainView mainView) {
        this.mainView = mainView;
        networkApi = NetworkApi.getInstance().getNetworkService();
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onItemClicked(int position) {

    }

    @Override
    public void onDestroy() {
        mainView = null;
    }

    @Override
    public void loadAllNetworkSites() {
        Observable<List<NetworkSite>> loadSites = networkApi.getAllSites();
        loadSites.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::loadNetworkSites);
    }

    private void loadNetworkSites(List<NetworkSite> sites) {
        mainView.loadAllNetworkSites(sites);
    }
}
