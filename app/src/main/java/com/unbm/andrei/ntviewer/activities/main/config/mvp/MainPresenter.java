package com.unbm.andrei.ntviewer.activities.main.config.mvp;

import com.unbm.andrei.ntviewer.activities.common.mvp.BasePresenter;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Andrei on 4/30/2017.
 */

@SuppressWarnings("Convert2MethodRef")
public class MainPresenter implements BasePresenter {

    private final IMainView view;
    private final MainModel model;

    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    public MainPresenter(IMainView view, MainModel model) {
        this.view = view;
        this.model = model;
    }

    public void onCreate() {

    }

    public void startViewCoverageActivity() {
//        view.showLoading(true);
//        compositeDisposable.add(model.getMapCoverage()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .doOnEach(__ -> view.showLoading(false))
//                .subscribe(networkProviders -> model.startMapCoverageActivity(networkProviders)));
        model.startViewMapActivity();
    }

    public void onDestroy() {
        compositeDisposable.dispose();
    }
}
