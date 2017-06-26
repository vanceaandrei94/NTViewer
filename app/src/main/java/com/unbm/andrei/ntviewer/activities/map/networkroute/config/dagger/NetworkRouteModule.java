package com.unbm.andrei.ntviewer.activities.map.networkroute.config.dagger;

import com.unbm.andrei.ntviewer.activities.map.networkroute.NetworkRouteActivity;
import com.unbm.andrei.ntviewer.activities.map.networkroute.config.mvp.NetworkRouteModel;
import com.unbm.andrei.ntviewer.activities.map.networkroute.config.mvp.NetworkRoutePresenter;
import com.unbm.andrei.ntviewer.application.network.NTVService;

import dagger.Module;
import dagger.Provides;

/**
 * Created by andrei.vancea on 5/8/2017.
 */

@Module
public class NetworkRouteModule {

    private final NetworkRouteActivity activity;

    public NetworkRouteModule(NetworkRouteActivity activity) {
        this.activity = activity;
    }

    @Provides
    @NetworkRouteScope
    public NetworkRouteModel provideModel(NTVService service) {
        return new NetworkRouteModel(service);
    }

    @Provides
    @NetworkRouteScope
    public NetworkRoutePresenter providePresenter(NetworkRouteModel model) {
        return new NetworkRoutePresenter(activity, model);
    }

}
