package com.unbm.andrei.ntviewer.activities.main.config.dagger;

import com.unbm.andrei.ntviewer.activities.main.MainActivity;
import com.unbm.andrei.ntviewer.activities.main.config.mvp.MainModel;
import com.unbm.andrei.ntviewer.activities.main.config.mvp.MainPresenter;
import com.unbm.andrei.ntviewer.activities.main.config.mvp.view.MainView;
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
    public MainModel provideModel(NTVService NTVService) {
        return new MainModel(NTVService, activity);
    }

    @Provides
    @MainScope
    public MainView provideView() {
        return new MainView(activity);
    }

    @Provides
    @MainScope
    public MainPresenter providePresenter(MainView view, MainModel model) {
        return new MainPresenter(view, model);
    }
}
