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

public class MainPresenter implements BasePresenter {

    private final MainView view;
    private final MainModel model;

    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    public MainPresenter(MainView view, MainModel model) {
        this.view = view;
        this.model = model;
    }

    public void onCreate() {
        //add disposables to the composite
        //such as onClickObservables and others
    }

    public void startViewProfileActivity() {
        view.showLoading(true);
        model.getCurrentUserInfo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnEach(__ -> view.showLoading(false))
                .subscribe(user -> startProfileActivity(user));
    }

    public void startViewRequestsActivity() {
        view.showLoading(true);
        model.getSubscribeRequests()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnEach(__ -> view.showLoading(false))
                .subscribe(sRequests -> startRequestsActivity(sRequests));
    }

    public void startViewComplaintsActivity() {
        model.startViewComplaintsActivity();
    }

    private void startProfileActivity(User user) {
        model.startViewProfileActivity(user);
    }

    private void startRequestsActivity(List<SRequest> sRequests) {
        model.startViewRequestsActivity(sRequests);
    }

    public void onDestroy() {
        compositeDisposable.dispose();
    }
}
