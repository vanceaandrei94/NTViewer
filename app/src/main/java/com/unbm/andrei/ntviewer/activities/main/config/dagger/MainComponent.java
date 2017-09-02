package com.unbm.andrei.ntviewer.activities.main.config.dagger;

import com.unbm.andrei.ntviewer.activities.main.MainActivity;
import com.unbm.andrei.ntviewer.application.dagger.AppComponent;

import dagger.Component;

/**
 * Created by Andrei on 4/30/2017.
 */
@MainScope
@Component(modules = MainModule.class, dependencies = AppComponent.class)
public interface MainComponent {

    void inject(MainActivity activity);
}
