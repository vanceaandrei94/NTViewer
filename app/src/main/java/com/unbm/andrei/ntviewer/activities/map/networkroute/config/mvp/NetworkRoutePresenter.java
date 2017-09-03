package com.unbm.andrei.ntviewer.activities.map.networkroute.config.mvp;

import com.unbm.andrei.ntviewer.activities.common.mvp.BasePresenter;

/**
 * Created by Andrei on 9/3/2017.
 */

public interface NetworkRoutePresenter<V> extends BasePresenter {

    void attachView(V view);

    void detachView();

    void getInfoForNode(String tag);
}
