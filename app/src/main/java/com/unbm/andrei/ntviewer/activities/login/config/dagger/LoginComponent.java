package com.unbm.andrei.ntviewer.activities.login.config.dagger;

import com.unbm.andrei.ntviewer.activities.login.LoginActivity;
import com.unbm.andrei.ntviewer.application.dagger.AppComponent;

import dagger.Component;

/**
 * Created by Andrei on 5/6/2017.
 */

@LoginScope
@Component(modules = LoginModule.class, dependencies = AppComponent.class)
public interface LoginComponent {

    void inject(LoginActivity loginActivity);

}
