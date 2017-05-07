package com.unbm.andrei.ntviewer.activities.main.config.mvp;

import com.unbm.andrei.ntviewer.activities.common.mvp.BasePresenter;
import com.unbm.andrei.ntviewer.activities.main.config.mvp.view.MainView;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Andrei on 4/30/2017.
 */

public class MainPresenter implements BasePresenter {

    private static final String SITES_LOADING_ERROR = "Sites loading error";
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
        compositeDisposable.add(showSitesList());
    }

    public Disposable showSitesList() {
        view.showLoading(true);
        return model.getAllSites()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .retry(3)
                .doOnEach(__ -> view.showLoading(false))
                .subscribe(sites -> view.updateSitesList(sites), e -> {
                    view.showToast(SITES_LOADING_ERROR);
                    e.printStackTrace();
                });
    }

    public void onDestroy() {
        compositeDisposable.dispose();
    }
}
