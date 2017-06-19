package com.unbm.andrei.ntviewer.activities.map.networkroute.config.dagger;

import com.unbm.andrei.ntviewer.activities.map.networkroute.NetworkRouteActivity;
import com.unbm.andrei.ntviewer.application.dagger.AppComponent;

import dagger.Component;

/**
 * Created by andrei.vancea on 5/8/2017.
 */

@NetworkRouteScope
@Component(modules = NetworkRouteModule.class, dependencies = AppComponent.class)
public interface NetworkRouteComponent {

    void inject(NetworkRouteActivity activity);
}
