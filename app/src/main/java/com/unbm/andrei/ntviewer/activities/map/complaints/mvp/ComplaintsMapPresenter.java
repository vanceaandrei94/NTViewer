package com.unbm.andrei.ntviewer.activities.map.complaints.mvp;

import android.util.Log;

import com.unbm.andrei.ntviewer.activities.common.mvp.BasePresenter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by andrei.vancea on 5/8/2017.
 */

public class ComplaintsMapPresenter implements BasePresenter {

    private final IComplaintsMapView view;
    private ComplaintsMapModel model;

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public ComplaintsMapPresenter(IComplaintsMapView view, ComplaintsMapModel model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void onCreate() {
        compositeDisposable.add(getComplaints());
    }

    @Override
    public void onDestroy() {
        compositeDisposable.dispose();
    }

    private Disposable getComplaints(){
        return model.getComplaints()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(complaints -> view.drawCoverage(complaints), ex -> Log.e("BASIC", "Error loading providers coverage: " + ex.getMessage()) );
    }

}
