package com.unbm.andrei.ntviewer.activities.map.derangements.mvp;

import com.unbm.andrei.ntviewer.activities.common.mvp.BasePresenter;

/**
 * Created by Andrei on 9/3/2017.
 */

public interface DerangementMapPresenter<V> extends BasePresenter {

    void attachView(V view);

    void detachView();

    void onShowDerangementInfo(Object tag);

    void onResolveDerangement(int id);
}