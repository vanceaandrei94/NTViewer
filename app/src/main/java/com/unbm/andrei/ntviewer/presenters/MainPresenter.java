package com.unbm.andrei.ntviewer.presenters;

import android.content.Context;

/**
 * Created by Andrei on 4/16/2017.
 */

public interface MainPresenter {

    void onResume();

    void onItemClicked(int position, Context context);

    void onDestroy();

    void loadAllNetworkSites();

}
