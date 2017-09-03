package com.unbm.andrei.ntviewer.activities.login.config.mvp;

import com.unbm.andrei.ntviewer.activities.common.mvp.BasePresenter;

/**
 * Created by Andrei on 9/3/2017.
 */

public interface LoginPresenter<V> extends BasePresenter {

    void signInUser(String username, String password);

    void attachView(V view);

    void detachView();

}
