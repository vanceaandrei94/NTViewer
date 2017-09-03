package com.unbm.andrei.ntviewer.activities.problem.config.mvp;

import com.unbm.andrei.ntviewer.activities.common.mvp.BasePresenter;

/**
 * Created by Andrei on 9/3/2017.
 */

public interface ReportProblemPresenter<V> extends BasePresenter {

    void attachView(V view);

    void detachView();

    void reportProblem();
}
