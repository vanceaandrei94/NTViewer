package com.unbm.andrei.ntviewer.presenters;

/**
 * Created by Andrei on 4/16/2017.
 */

public interface MainPresenter {

    void onResume();

    void onItemClicked(int position);

    void onDestroy();

    void loadAllNetworkSites();

}
