package com.unbm.andrei.ntviewer.activities.map.networkroute.config.mvp;

import com.unbm.andrei.ntviewer.activities.common.mvp.BasePresenter;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Andrei on 6/19/2017.
 */

public class NetworkRoutePresenter implements BasePresenter {

    private NetworkRouteView view;
    private NetworkRouteModel model;

    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    public NetworkRoutePresenter(NetworkRouteView view, NetworkRouteModel model) {
        this.view = view;
        this.model = model;
    }


    @Override
    public void onCreate() {

    }

    @Override
    public void onDestroy() {
        compositeDisposable.dispose();
    }
}
