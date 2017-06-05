package com.unbm.andrei.ntviewer.activities.coveragemap.config.mvp;

import android.util.Log;

import com.unbm.andrei.ntviewer.activities.common.mvp.BasePresenter;
import com.unbm.andrei.ntviewer.application.network.models.NetworkProvider;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by andrei.vancea on 5/8/2017.
 */

public class CoverageMapPresenter implements BasePresenter {

    private final ICoverageMapView view;
    private CoverageMapModel model;

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public CoverageMapPresenter(ICoverageMapView view, CoverageMapModel model) {
        this.view = view;
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

    private Disposable getProvidersCoverage(){
        return model.getProvidersCoverage()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(providers -> view.drawCoverage(providers), ex -> Log.e("BASIC", "Error loading providers coverage: " + ex.getMessage()) );
    }

}
