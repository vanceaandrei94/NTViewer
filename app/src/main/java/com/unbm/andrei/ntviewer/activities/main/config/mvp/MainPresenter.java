package com.unbm.andrei.ntviewer.activities.main.config.mvp;

import com.unbm.andrei.ntviewer.activities.common.mvp.BasePresenter;
import com.unbm.andrei.ntviewer.application.network.models.SRequest;
import com.unbm.andrei.ntviewer.models.User;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Andrei on 4/30/2017.
 */

@SuppressWarnings("Convert2MethodRef")
public class MainPresenter implements BasePresenter {

    private final MainView view;
    private final MainModel model;

    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    public MainPresenter(MainView view, MainModel model) {
        this.view = view;
        this.model = model;
    }

    public void onCreate() {

    }

    public void startViewProfileActivity() {
        view.showLoading(true);
        compositeDisposable.add(model.getCurrentUserInfo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnEach(__ -> view.showLoading(false))
                .subscribe(user -> model.startViewProfileActivity(user)));
    }

    public void startViewRequestsActivity() {
        view.showLoading(true);
        compositeDisposable.add(model.getSubscribeRequests()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnEach(__ -> view.showLoading(false))
                .subscribe(sRequests -> model.startViewRequestsActivity(sRequests)));
    }

    public void startSitesMapActivity() {
        view.showLoading(true);
        compositeDisposable.add(model.getAllSites()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnEach(__ -> view.showLoading(false))
                .subscribe(sites -> model.startSitesMapActivity(sites)));
    }

    public void startViewComplaintsActivity() {
        view.showLoading(true);
        compositeDisposable.add(model.getComplaints()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnEach(__ -> view.showLoading(false))
                .subscribe(complaints -> model.startViewComplaintsActivity(complaints)));
    }

    public void onDestroy() {
        compositeDisposable.dispose();
    }
}
