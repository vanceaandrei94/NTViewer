package com.unbm.andrei.ntviewer.activities.map.coverage.config.dagger;

import com.unbm.andrei.ntviewer.activities.map.coverage.CoverageMapActivity;
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
