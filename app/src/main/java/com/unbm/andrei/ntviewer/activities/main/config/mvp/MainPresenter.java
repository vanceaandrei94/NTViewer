package com.unbm.andrei.ntviewer.activities.main.config.mvp;

import com.unbm.andrei.ntviewer.activities.main.config.mvp.view.MainView;
import com.unbm.andrei.ntviewer.application.network.models.NetworkSite;
import com.unbm.andrei.ntviewer.base.mvp.BasePresenter;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Andrei on 4/30/2017.
 */

public class MainPresenter extends BasePresenter {

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
        compositeDisposable.add(observeButton());
    }

    public Disposable observeButton() {
        return view.observeButton()
                .doOnNext(__ -> view.showLoading(true))
                .observeOn(Schedulers.io())
                .switchMap(__ -> model.getAllSites())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnEach(__ -> view.showLoading(false))
                .subscribe(sites -> view.updateSitesList(sites));

    }

    public Disposable showSitesList() {
        return model.getAllSites()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .retry(3)
                .subscribe(sites -> view.updateSitesList(sites), e -> {
                    view.showToast(SITES_LOADING_ERROR);
                    e.printStackTrace();
                });
    }

    public void onDestroy() {
        compositeDisposable.dispose();
    }
}
