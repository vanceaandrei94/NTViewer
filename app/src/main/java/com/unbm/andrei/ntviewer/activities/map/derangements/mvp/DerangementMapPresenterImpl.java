package com.unbm.andrei.ntviewer.activities.map.derangements.mvp;

import android.util.Log;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by andrei.vancea on 5/8/2017.
 */

public class DerangementMapPresenterImpl implements DerangementMapPresenter<DerangementMapView> {

    private DerangementMapView view;
    private DerangementMapModel model;

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public DerangementMapPresenterImpl(DerangementMapModel model) {
        this.model = model;
    }

    @Override
    public void onCreate() {
        compositeDisposable.add(getAllReports());
    }

    @Override
    public void onDestroy() {
        compositeDisposable.dispose();
    }

    private Disposable getAllReports() {
        return model.getProblemReports()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(problemReports -> view.drawDerangements(problemReports), ex -> Log.e("BASIC", "Error loading providers coverage: " + ex.getMessage()));
    }

    public void onShowDerangementInfo(Object tag) {
        if (tag instanceof Integer) {
            int id = (Integer) tag;
            compositeDisposable.add(model.getProblemReportInfo(id)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(problemReport -> view.showDerangementInfo(problemReport), ex -> Log.e("BASIC", "Error loading derangement info: " + ex.getMessage())));


        }
    }

    public void onResolveDerangement(int id) {
        compositeDisposable.add(model.resolveReport(id).subscribe(aVoid -> view.showResolvedSuccess(),
                throwable -> view.showErrorResolvingDerangement(),
                () -> view.showResolvedSuccess()));
    }

    @Override
    public void attachView(DerangementMapView view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }
}
