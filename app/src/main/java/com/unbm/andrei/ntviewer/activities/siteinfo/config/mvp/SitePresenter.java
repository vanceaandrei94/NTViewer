package com.unbm.andrei.ntviewer.activities.siteinfo.config.mvp;

import com.unbm.andrei.ntviewer.base.mvp.BasePresenter;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Andrei on 5/1/2017.
 */

public class SitePresenter extends BasePresenter {

    private final SiteView view;
    private final SiteModel model;
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    public SitePresenter(SiteView view, SiteModel model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDestroy() {
        compositeDisposable.dispose();
    }


}
