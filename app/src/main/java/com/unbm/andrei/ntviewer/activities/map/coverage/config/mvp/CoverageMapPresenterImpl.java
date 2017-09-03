package com.unbm.andrei.ntviewer.activities.map.coverage.config.mvp;

import android.util.Log;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by andrei.vancea on 5/8/2017.
 */

public class CoverageMapPresenterImpl implements CoverageMapPresenter<ICoverageMapView> {

    private ICoverageMapView view;
    private CoverageMapModel model;

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public CoverageMapPresenterImpl(CoverageMapModel model) {
        this.model = model;
    }

    @Override
    public void onCreate() {
        compositeDisposable.add(getProvidersCoverage());
    }

    @Override
    public void onDestroy() {
        compositeDisposable.dispose();
    }

    private Disposable getProvidersCoverage() {
        return model.getProvidersCoverage()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(providers -> view.drawCoverage(providers), ex -> Log.e("BASIC", "Error loading providers coverage: " + ex.getMessage()));
    }

    @Override
    public void attachView(ICoverageMapView view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }
}
