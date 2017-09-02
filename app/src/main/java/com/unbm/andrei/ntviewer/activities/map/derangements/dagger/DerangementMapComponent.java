package com.unbm.andrei.ntviewer.activities.map.derangements.dagger;

import com.unbm.andrei.ntviewer.activities.map.derangements.DerangementMapActivity;
import com.unbm.andrei.ntviewer.application.dagger.AppComponent;

import dagger.Component;

/**
 * Created by andrei.vancea on 5/8/2017.
 */

@DerangementMapScope
@Component(modules = DerangementMapModule.class, dependencies = AppComponent.class)
public interface DerangementMapComponent {

    void inject(DerangementMapActivity activity);
}
