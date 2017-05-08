package com.unbm.andrei.ntviewer.activities.sitesmap.config.dagger;

import com.unbm.andrei.ntviewer.activities.sitesmap.SitesMapActivity;
import com.unbm.andrei.ntviewer.application.dagger.AppComponent;

import dagger.Component;

/**
 * Created by andrei.vancea on 5/8/2017.
 */

@SitesMapScope
@Component(modules = SitesMapModule.class, dependencies = AppComponent.class)
public interface SitesMapComponent {

    void inject(SitesMapActivity activity);
}
