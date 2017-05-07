package com.unbm.andrei.ntviewer.activities.login.config.dagger;

import com.unbm.andrei.ntviewer.activities.login.LoginActivity;
import com.unbm.andrei.ntviewer.activities.login.config.mvp.LoginModel;
import com.unbm.andrei.ntviewer.activities.login.config.mvp.LoginPresenter;
import com.unbm.andrei.ntviewer.activities.login.config.mvp.LoginView;
import com.unbm.andrei.ntviewer.application.network.NTVService;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Andrei on 5/6/2017.
 */

@Module
public class LoginModule {

    private final LoginActivity activity;

    public LoginModule(LoginActivity activity) {
        this.activity = activity;
    }

    @Provides
    @LoginScope
    public LoginModel provideModel(NTVService ntvService) {
        return new LoginModel(activity, ntvService);
    }

    @Provides
    @LoginScope
    public LoginPresenter providePresenter(LoginView view, LoginModel model) {
        return new LoginPresenter(view, model);
    }

    @Provides
    @LoginScope
    public LoginView provideView() {
        return new LoginView(activity);
    }
}
