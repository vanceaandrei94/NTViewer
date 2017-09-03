package com.unbm.andrei.ntviewer.activities.map.coverage.config.mvp;

import com.unbm.andrei.ntviewer.activities.common.mvp.BasePresenter;

/**
 * Created by Andrei on 9/3/2017.
 */

public interface CoverageMapPresenter<V> extends BasePresenter {

    void attachView(V view);

    void detachView();

}
