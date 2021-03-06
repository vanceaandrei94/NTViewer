package com.unbm.andrei.ntviewer.activities.main.config.dagger;

import com.unbm.andrei.ntviewer.activities.main.MainActivity;
import com.unbm.andrei.ntviewer.activities.main.config.mvp.MainModel;
import com.unbm.andrei.ntviewer.activities.main.config.mvp.MainPresenter;
import com.unbm.andrei.ntviewer.application.network.NTVService;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Andrei on 4/30/2017.
 */

@Module
public class MainModule {


    private final MainActivity activity;

    public MainModule(MainActivity activity) {
        this.activity = activity;
    }

    @Provides
    @MainScope
    public MainModel provideModel() {
        return new MainModel(activity);
    }

    @Provides
    @MainScope
    public MainPresenter providePresenter(MainModel model) {
        return new MainPresenter(activity, model);
    }
}
