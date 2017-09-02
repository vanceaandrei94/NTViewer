package com.unbm.andrei.ntviewer.activities.login.config.mvp;

import android.content.Context;

/**
 * Created by Andrei on 6/3/2017.
 */

public interface ILoginView {

    void showLoading(boolean show);

    void showToast(String message);

    Context getContext();
}
