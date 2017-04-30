package com.unbm.andrei.ntviewer.application.dagger.modules;

import android.content.Context;

import com.unbm.andrei.ntviewer.application.dagger.AppScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Andrei on 4/30/2017.
 */

@Module
public class ContextModule {

    public final Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    @AppScope
    public Context provideContext() {
        return context;
    }
}
