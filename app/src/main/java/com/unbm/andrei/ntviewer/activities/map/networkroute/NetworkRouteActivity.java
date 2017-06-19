package com.unbm.andrei.ntviewer.activities.map.networkroute;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.unbm.andrei.ntviewer.R;
import com.unbm.andrei.ntviewer.activities.map.base.MapActivity;
import com.unbm.andrei.ntviewer.activities.map.networkroute.config.dagger.DaggerNetworkRouteComponent;
import com.unbm.andrei.ntviewer.activities.map.networkroute.config.dagger.NetworkRouteModule;
import com.unbm.andrei.ntviewer.activities.map.networkroute.config.mvp.NetworkRoutePresenter;
import com.unbm.andrei.ntviewer.activities.map.networkroute.config.mvp.NetworkRouteView;
import com.unbm.andrei.ntviewer.application.NTViewerApplication;

import javax.inject.Inject;

/**
 * Created by Andrei on 6/19/2017.
 */

public class NetworkRouteActivity extends MapActivity implements NetworkRouteView {

    public static void start(Activity activity) {
        Intent intent = new Intent(activity, NetworkRouteActivity.class);
        activity.startActivity(intent);
    }

    @Inject
    NetworkRoutePresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerNetworkRouteComponent.builder()
                .appComponent(NTViewerApplication.get(this).getComponent())
                .networkRouteModule(new NetworkRouteModule(this))
                .build().inject(this);

        presenter.onCreate();
        getSupportActionBar().setTitle(getResources().getString(R.string.network_route_title));
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }
}
