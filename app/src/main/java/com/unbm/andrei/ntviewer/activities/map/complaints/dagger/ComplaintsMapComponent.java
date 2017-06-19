package com.unbm.andrei.ntviewer.activities.map.complaints.dagger;

import com.unbm.andrei.ntviewer.activities.map.complaints.ComplaintsMapActivity;
import com.unbm.andrei.ntviewer.application.dagger.AppComponent;

import dagger.Component;

/**
 * Created by andrei.vancea on 5/8/2017.
 */

@ComplaintsMapScope
@Component(modules = ComplaintsMapModule.class, dependencies = AppComponent.class)
public interface ComplaintsMapComponent {

    void inject(ComplaintsMapActivity activity);
}
