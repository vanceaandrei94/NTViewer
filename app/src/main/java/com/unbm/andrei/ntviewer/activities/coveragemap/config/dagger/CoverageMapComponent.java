package com.unbm.andrei.ntviewer.activities.coveragemap.config.dagger;

import com.unbm.andrei.ntviewer.activities.coveragemap.CoverageMapActivity;
import com.unbm.andrei.ntviewer.application.dagger.AppComponent;

import dagger.Component;

/**
 * Created by andrei.vancea on 5/8/2017.
 */

@CoverageMapScope
@Component(modules = CoverageMapModule.class, dependencies = AppComponent.class)
public interface CoverageMapComponent {

    void inject(CoverageMapActivity activity);
}
