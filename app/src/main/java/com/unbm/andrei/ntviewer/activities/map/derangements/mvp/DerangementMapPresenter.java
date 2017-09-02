package com.unbm.andrei.ntviewer.activities.map.derangements.mvp;

import android.util.Log;

import com.unbm.andrei.ntviewer.activities.common.mvp.BasePresenter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by andrei.vancea on 5/8/2017.
 */

public class DerangementMapPresenter implements BasePresenter {

    private final DerangementMapView view;
    private DerangementMapModel model;

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public DerangementMapPresenter(DerangementMapView view, DerangementMapModel model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void onCreate() {
        compositeDisposable.add(getProblemReports());
    }

    @Override
    public void onDestroy() {
        compositeDisposable.dispose();
    }

    private Disposable getProblemReports() {
        return model.getProblemReports()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(problemReports -> view.drawDerangements(problemReports), ex -> Log.e("BASIC", "Error loading providers coverage: " + ex.getMessage()));
    }

    public void onShowDerangementInfo(Object tag) {
        if (tag instanceof Integer) {
            int id = (Integer) tag;
            model.getProblemReportInfo(id)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(problemReport -> view.showDerangementInfo(problemReport), ex -> Log.e("BASIC", "Error loading derangement info: " + ex.getMessage()));


        }
    }
}
