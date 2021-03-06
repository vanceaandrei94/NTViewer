package com.unbm.andrei.ntviewer.activities.map.networkroute.config.mvp;

import android.util.Log;

import com.unbm.andrei.ntviewer.activities.common.mvp.BasePresenter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

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
        compositeDisposable.add(getNetworkRoutes());
    }

    private Disposable getNetworkRoutes() {
        return model.getNetworkRoutes()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(routes -> view.drawNetworkRoutes(routes), ex -> {
                    Log.e("BASIC", "Error while processing network routes: " + ex.getMessage());
                    ex.printStackTrace();
                });
    }

    @Override
    public void onDestroy() {
        compositeDisposable.dispose();
    }

    public void getInfoForNode(String id) {
        view.showLoading(true);
        compositeDisposable.add(model.getNodeInfo(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnEach(__ -> view.showLoading(false))
                .subscribe(nodeInfo -> view.showNodeInfoPopup(nodeInfo),
                        ex -> Log.e("BASIC", "Error while processing network routes: " + ex.getMessage())));
    }
}
