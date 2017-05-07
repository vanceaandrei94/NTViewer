package com.unbm.andrei.ntviewer.application;

import android.app.Activity;
import android.app.Application;

import com.unbm.andrei.ntviewer.application.dagger.AppComponent;
import com.unbm.andrei.ntviewer.application.dagger.DaggerAppComponent;
import com.unbm.andrei.ntviewer.application.dagger.modules.ContextModule;

import timber.log.Timber;

/**
 * Created by andrei.vancea on 3/6/2017.
 */

public class NTViewerApplication extends Application {

    AppComponent appComponent;

    public static NTViewerApplication get(Activity activity) {
        return (NTViewerApplication) activity.getApplication();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());
        appComponent = DaggerAppComponent.builder()
                .contextModule(new ContextModule(this))
                .build();
    }

    public AppComponent getComponent() {
        return appComponent;
    }

}
