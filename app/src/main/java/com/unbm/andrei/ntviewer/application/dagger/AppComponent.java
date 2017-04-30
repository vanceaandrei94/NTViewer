package com.unbm.andrei.ntviewer.application.dagger;

import com.unbm.andrei.ntviewer.application.dagger.modules.ContextModule;
import com.unbm.andrei.ntviewer.application.dagger.modules.NetworkModule;
import com.unbm.andrei.ntviewer.application.network.SitesProviderService;

import dagger.Component;

/**
 * Created by Andrei on 4/30/2017.
 */
@AppScope
@Component(modules = {ContextModule.class, NetworkModule.class})
public interface AppComponent {

    SitesProviderService sitesProviderService();
}
