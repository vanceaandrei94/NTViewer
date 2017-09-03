package com.unbm.andrei.ntviewer.activities.main.config.mvp;

import com.unbm.andrei.ntviewer.activities.common.mvp.BasePresenter;

/**
 * Created by Andrei on 9/3/2017.
 */

public interface MainPresenter<V> extends BasePresenter {

    void attachView(V view);

    void detachView();

    void onViewCoverageActivity();

    void onViewComplaintsActivity();

    void onNetworkRouteActivity();

    void onReportProblemScreen();
}
