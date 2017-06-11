package com.unbm.andrei.ntviewer.activities.main.config.mvp;

import android.util.Log;

import com.unbm.andrei.ntviewer.activities.common.mvp.BasePresenter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

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
        model.startMapCoverageActivity();
    }

    public void onDestroy() {
        compositeDisposable.dispose();
    }
}
