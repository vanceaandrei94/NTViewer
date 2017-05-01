package com.unbm.andrei.ntviewer.activities.siteinfo.config.dagger;

import com.unbm.andrei.ntviewer.activities.siteinfo.SiteInfoActivity;
import com.unbm.andrei.ntviewer.application.dagger.AppComponent;

import dagger.Component;

/**
 * Created by Andrei on 5/1/2017.
 */

@SiteScope
@Component(modules = SiteModule.class, dependencies = AppComponent.class)
public interface SiteComponent {

    void inject(SiteInfoActivity activity);

}
