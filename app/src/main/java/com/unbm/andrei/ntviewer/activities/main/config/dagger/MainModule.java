package com.unbm.andrei.ntviewer.activities.main.config.dagger;

import com.unbm.andrei.ntviewer.activities.main.MainActivity;
import com.unbm.andrei.ntviewer.activities.main.config.mvp.IMainView;
import com.unbm.andrei.ntviewer.activities.main.config.mvp.MainModel;
import com.unbm.andrei.ntviewer.activities.main.config.mvp.MainModelImpl;
import com.unbm.andrei.ntviewer.activities.main.config.mvp.MainPresenter;
import com.unbm.andrei.ntviewer.activities.main.config.mvp.MainPresenterImpl;

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
        return new MainModelImpl(activity);
    }

    @Provides
    @MainScope
    public MainPresenter<IMainView> providePresenter(MainModel model) {
        return new MainPresenterImpl(model);
    }
}
