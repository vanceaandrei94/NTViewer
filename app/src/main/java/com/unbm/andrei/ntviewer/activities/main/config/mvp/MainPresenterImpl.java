package com.unbm.andrei.ntviewer.activities.main.config.mvp;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Andrei on 4/30/2017.
 */

@SuppressWarnings("Convert2MethodRef")
public class MainPresenterImpl implements MainPresenter<IMainView> {

    private IMainView view;
    private final MainModel model;

    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    public MainPresenterImpl(MainModel model) {
        this.model = model;
    }

    public void onCreate() {

    }

    public void onDestroy() {
        compositeDisposable.dispose();
    }

    public void onViewCoverageActivity() {
        model.startMapCoverageActivity();
    }

    public void onViewComplaintsActivity() {
        model.startComplaintsActivity();
    }

    public void onNetworkRouteActivity() {
        model.startNetworkRouteActivity();
    }


    public void onReportProblemScreen() {
        model.startReportProblemActivity();
    }

    @Override
    public void attachView(IMainView view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }
}
